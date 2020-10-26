package com.enic.Polymorphic;

public class InheritableBusinessContext {
    /**
     * 设置属性
     *
     * @param key
     * @param value
     */
    public static void setObjectProperty(String key, Object value) {
        InheritableBaseContext.setObjectProperty(key, value);
    }

    /**
     * 设置只读属性，如果值已存在，则保留原有值，返回context中的值
     *
     * @param key
     * @param value
     * @return 设置的值
     */
    public static Object setReadOnlyProperty(String key, Object value) {
        return InheritableBaseContext.setReadOnlyProperty(key, value);
    }

    /**
     * 获取变量
     *
     * @param key
     * @return 获取的变量值
     */
    public static Object getObjectProperty(String key) {
        return InheritableBaseContext.getObjectProperty(key);
    }

    /**
     * 获取业务类
     *
     * @return 品类id
     */
    public static Integer getProductClassId() {
        return (Integer) getObjectProperty(Constants.BUSINESS_CLASS_ID);
    }

    /**
     * 设置业务类
     *
     * @param productClassId
     */
    public static void setProductClassId(Integer productClassId) {
        setObjectProperty(Constants.BUSINESS_CLASS_ID, productClassId);
    }
}
