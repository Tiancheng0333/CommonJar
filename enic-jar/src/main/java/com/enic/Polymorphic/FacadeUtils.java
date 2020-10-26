package com.enic.Polymorphic;

import org.springframework.util.StringUtils;

import java.util.List;

public class FacadeUtils {

    public static <T extends ISupport<SupportedEnum>> T getSupportBean(List<T> supportBeanList) {
        if (StringUtils.isEmpty(supportBeanList)) {
            System.out.println("FacadeUtils-supportBeanList{}" + "数据为空");
        }
        Integer classId = InheritableBusinessContext.getProductClassId();
        T defaultBean = null;
        for (T bean : supportBeanList) {
            if (SupportedEnum.DEFAULT_CAL.equals(bean.support())) {
                defaultBean = bean;
                continue;
            }
            if (bean.support().isSupported(classId)) {
                return bean;
            }
        }
        if (null == defaultBean) {
            System.out.println("FacadeUtils-defaultBean->此业务无可匹配的业务类");
        }
        return defaultBean;
    }
}
