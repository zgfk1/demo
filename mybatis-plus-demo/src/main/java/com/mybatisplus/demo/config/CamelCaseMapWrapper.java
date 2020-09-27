package com.mybatisplus.demo.config;

import cn.hutool.core.util.StrUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.MapWrapper;

import java.util.Map;

/**
 * @描述:
 * @作者: REN
 * @时间: 2018/11/19 17:45
 */
public class CamelCaseMapWrapper extends MapWrapper {

    CamelCaseMapWrapper(MetaObject metaObject, Map<String, Object> map) {
        super(metaObject, map);
    }

    @Override
    public String findProperty(String name, boolean useCamelCaseMapping) {
        //首先转换小写
        name = name.toLowerCase();
        if (useCamelCaseMapping) {
            name = StrUtil.toCamelCase(name);
        }
        return name;
    }
}
