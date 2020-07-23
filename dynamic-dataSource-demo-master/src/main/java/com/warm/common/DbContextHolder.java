package com.warm.common;

/**
 * @Author DGD
 * @date 2018/2/7.
 */
public class DbContextHolder {
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal<>();
    /**
     * 设置数据源
     * @param dbTypeEnum
     */
    public static void setDbType(DBTypeEnum dbTypeEnum) {
        THREAD_LOCAL.set(dbTypeEnum.getValue());
    }

    /**
     * 取得当前数据源
     * @return
     */
    public static String getDbType() {
        return (String) THREAD_LOCAL.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clearDbType() {
        THREAD_LOCAL.remove();
    }
}
