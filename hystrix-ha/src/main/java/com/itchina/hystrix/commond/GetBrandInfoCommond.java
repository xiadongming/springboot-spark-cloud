package com.itchina.hystrix.commond;

import com.alibaba.fastjson.JSONObject;
import com.itchina.hystrix.http.HttpClientUtils;
import com.itchina.hystrix.model.ProductInfo;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/**
 * @Date: 2021/5/5 15:10
 * @Desc:  这个关于 hystrix的配置是比较全的
 */
public class GetBrandInfoCommond extends HystrixCommand<String> {

    private Long brandId;

    public GetBrandInfoCommond(Long brandId) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetBrandInfoCommondGroup"))
                /** 指定线程池隔离 */
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD))
                /**  线程池大小 */
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(10)
                        .withQueueSizeRejectionThreshold(10))
                /** 最多同时调用fallback的线程数量，避免fallback被hang死 */
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(15))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        /**
                         * 断路器
                         */
                        .withCircuitBreakerRequestVolumeThreshold(30) //10秒中内超过30个，则打开断路器
                        .withCircuitBreakerErrorThresholdPercentage(40) //异常的比例超过40%，则打开断路器
                        .withCircuitBreakerSleepWindowInMilliseconds(3000) //休眠3秒后，尝试自动恢复，打开半开状态
                        .withExecutionTimeoutInMilliseconds(500) //超时时间500毫秒
                )
        );
        this.brandId = brandId;
    }

    @Override
    protected String getFallback() {
        System.out.println("调用降级服务");
        return "降级的返回值：10000";
    }

    /**
     * 模拟异常情况
     */
    @Override
    protected String run() throws Exception {
        /**
         * 正常调用的逻辑
         * */
        String url = "http://127.0.0.1:9122/getNoHystrix?productId=" + 1;
        String response = HttpClientUtils.sendGetRequest(url);
        ProductInfo parse = JSONObject.parseObject(response, ProductInfo.class);
        /**
         * 异常情况模拟
         * */
        throw new Exception();
    }


}
