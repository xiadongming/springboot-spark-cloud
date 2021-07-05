package com.itchina.hystrix.commond;

import com.itchina.hystrix.model.ProductInfo;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @Date: 2021/5/5 7:23
 * @Desc: fail-silient模式 模式
 */
public class FailureSilientCommond extends HystrixCommand<ProductInfo> {

    protected FailureSilientCommond(HystrixCommandGroupKey group) {
        super(group);
    }

    /**
     * fail-silient模式，立即失败模式
     */
    @Override
    protected ProductInfo run() throws Exception {
        return new ProductInfo();
    }

    @Override
    protected ProductInfo getFallback() {
        return super.getFallback();
    }
}
