package com.sdgc.demo.plugin;

import com.sdgc.demo.annotation.BizCode;
import com.sdgc.demo.plugin.extension.Extension;
import com.sdgc.demo.plugin.extension.ExtensionFacade;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ExtensionBuilder {

    private ExtensionBuilder() {
    }

    public static ExtensionBuilder getInstance() {
        return ExtensionBuilderInstance.INSTANCE;
    }

    private static class ExtensionBuilderInstance {
        private static final ExtensionBuilder INSTANCE = new ExtensionBuilder();
    }

    /**
     * 扩展类 => (业务编码 => 业务扩展实例)
     */
    private final Map<Class, ConcurrentHashMap<String, Extension>> multiExtMap = new ConcurrentHashMap<>();

    /**
     * 注册业务扩展类实例
     */
    public void build() {
        try {
            // 找出所有类型的扩展接口/类（继承或实现了Extension）：这里主要是想找出继承于Extension的子接口，并不关心Extension子接口的实现类
            Reflections extKindReflections = new Reflections("com.sdgc.demo.plugin.extension");
            Set<Class<? extends Extension>> extKindClasses = extKindReflections.getSubTypesOf(Extension.class);

            // 找出所有业务扩展门面类（继承或实现了ExtensionFacade）
            Reflections extFacadeReflections = new Reflections("com.sdgc.demo.plugin.extension");
            Set<Class<? extends ExtensionFacade>> extFacadeClasses =
                    extFacadeReflections.getSubTypesOf(ExtensionFacade.class);

            // 对每一种类型的扩展
            for (Class<? extends Extension> extKindClass : extKindClasses) {
                // 过滤Extension子接口的实现类
                if (!extKindClass.isInterface()) {
                    continue;
                }

                ConcurrentHashMap<String, Extension> extMap = new ConcurrentHashMap<>();

                // 遍历所有扩展门面类，获取该类型扩展的业务实现
                for (Class<? extends ExtensionFacade> extFacade : extFacadeClasses) {
                    // 构建：业务编码 => 业务扩展实例
                    BizCode[] annotationsByType = extFacade.getAnnotationsByType(BizCode.class);
                    if (annotationsByType.length > 0) {
                        BizCode bizCode = annotationsByType[0];
                        Extension extension = null;

                        Object extensionFacade = extFacade.newInstance();
                        Method[] facadeMethods = extFacade.getDeclaredMethods();
                        // 遍历扩展门面的所有方法
                        for (Method facadeMethod : facadeMethods) {
                            // 找到返回该类型扩展的method
                            if (extKindClass.isAssignableFrom(facadeMethod.getReturnType())) {
                                // 从业务扩展门面的方法返回中，获取该类型扩展的业务实现
                                extension = (Extension) facadeMethod.invoke(extensionFacade);
                            }
                        }
                        if (null != extension) {
                            extMap.put(bizCode.value(), extension);
                        }
                    }
                }

                multiExtMap.put(extKindClass, extMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据业务扩展类型、业务编码，获取对应的业务扩展类实例
     *
     * @param extClass 业务扩展类型
     * @param bizCode  业务编码
     * @return
     */
    public <Ext> Ext getExt(Class<Ext> extClass, String bizCode) {
        return (Ext) multiExtMap.get(extClass).get(bizCode);
    }
}
