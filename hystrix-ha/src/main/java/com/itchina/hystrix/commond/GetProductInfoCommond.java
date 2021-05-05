package com.itchina.hystrix.commond;

import com.alibaba.fastjson.JSONObject;
import com.itchina.hystrix.http.HttpClientUtils;
import com.itchina.hystrix.model.ProductInfo;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/**
 * @Date: 2021/5/5 7:23
 * @Desc:
 */
public class GetProductInfoCommond extends HystrixCommand<ProductInfo> {

    private Long productId;

    public GetProductInfoCommond(Long productId) {
      //  super(HystrixCommandGroupKey.Factory.asKey("GetProductInfoGroup"));
       super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GetProductInfoGroup"))
               /** 指定线程池隔离 */
               .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                       .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD))
               /**  线程池大小 */
               .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)));
        this.productId = productId;

    }
    /**
     * fallback降级机制
     * */
    @Override
    protected ProductInfo getFallback() {
        return super.getFallback();
    }
    @Override
    protected ProductInfo run() throws Exception {
        String url = "http://127.0.0.1:9122/getNoHystrix?productId=" + productId;
        String response = HttpClientUtils.sendGetRequest(url);
        ProductInfo parse = JSONObject.parseObject(response, ProductInfo.class);
        return parse;
    }
    /**
     * 缓存key
     * */
 /*   @Override
    protected String getCacheKey() {
        return "product_info_"+productId;
    }*/

}
