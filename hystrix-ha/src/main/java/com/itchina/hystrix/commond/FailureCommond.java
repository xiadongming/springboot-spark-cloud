package com.itchina.hystrix.commond;

import com.itchina.hystrix.model.ProductInfo;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @Date: 2021/5/5 7:23
 * @Desc: fail-fast模式
 */
public class FailureCommond extends HystrixCommand<ProductInfo> {

    protected FailureCommond(HystrixCommandGroupKey group) {
        super(group);
    }

    /**
     * fail-fast模式，立即失败模式
     */
    @Override
    protected ProductInfo run() throws Exception {
        /**
         * 直接报错
         */
        throw new Exception();
    }
}
