package com.enic.Polymorphic;

import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 线程上下文 用来记录全局信息 可被子线程继承 随业务中断或恢复
 */
public class InheritableBaseContext {

    private final static InheritableThreadLocal<Map<String, Object>> THREAD_LOCAL = new InheritableThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new ConcurrentHashMap<String, Object>();
        }
    };

    /**
     * 设置属性值
     *
     * @param key
     * @param value
     */
    public static void setObjectProperty(String key, Object value) {
        if (StringUtils.isEmpty(key)) {
            return;
        }
        THREAD_LOCAL.get().put(key.toUpperCase(), value);
    }

    /**
     * 设置只读属性，如果存在则返回旧值
     *
     * @param key
     * @param value
     * @return
     */
    public static Object setReadOnlyProperty(String key, Object value) {
        Object oldValue = null;
        if (!(StringUtils.isEmpty(key)) && (oldValue = THREAD_LOCAL.get().get(key.toUpperCase())) == null) {
            THREAD_LOCAL.get().put(key.toUpperCase(), value);
            return value;
        }
        return oldValue;
    }

    public static Object getObjectProperty(String key) {
        if (!(StringUtils.isEmpty(key))) {
            return THREAD_LOCAL.get().get(key);
        }
        return null;
    }

    public static void clearThreadContextInfo() {
        THREAD_LOCAL.remove();
    }
}
