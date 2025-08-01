package com.example.utils;

/**
 * Boolean工具类
 */
public class BooleanUtils {

    /**
     * <p>将 Boolean 类型转换为 boolean，能够处理 <code>null</code> ，将返回 <code>false</code>。</p>
     * <pre>
     * BooleanUtils.toBoolean(Boolean.TRUE)  = true
     * BooleanUtils.toBoolean(Boolean.FALSE) = false
     * BooleanUtils.toBoolean(null)          = false
     * </pre>
     * @param bool 要转换的boolean值
     * @return <code>true</code> 或 <code>false</code>，<code>null</code> 将返回 <code>false</code>
     */
    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}