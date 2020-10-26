package com.enic.Polymorphic;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("Business")
public class BusinessFacade implements IBusiness, IBusinessFacade<IBusiness> {

    @Resource
    private List<IBusiness> iBusinesses;

    /**
     * 业务方法
     *
     * @return
     */
    @Override
    public Integer calForAvg() {
        return getMatchBean().calForAvg();
    }

    /**
     * 业务方法
     *
     * @return
     */
    @Override
    public String getMaxAge() {
        return getMatchBean().getMaxAge();
    }


    /**
     * 匹配对应的具体的业务bean
     *
     * @return
     */
    @Override
    public IBusiness getMatchBean() {
        return FacadeUtils.getSupportBean(iBusinesses);
    }

    @Override
    public SupportedEnum support(Object... prams) {
        return SupportedEnum.FACED;
    }
}
