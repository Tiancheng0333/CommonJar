package com.enic.Polymorphic;

public interface IBusinessFacade<T> {

    /**
     * 获取匹配的具体业务类
     *
     * @return
     */
    T getMatchBean();

}
