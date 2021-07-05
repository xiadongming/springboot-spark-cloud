package com.itchina.hystrix.commond;

import com.alibaba.fastjson.JSONArray;
import com.itchina.hystrix.http.HttpClientUtils;
import com.itchina.hystrix.model.ProductInfo;
import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Date: 2021/6/13 20:09
 * @Desc: 请求合并技术，将多个请求合并，即将多个HystrixCommand合并在一起执行，发送一次网路请求，就能拉取多条数据，
 * 减少高并发下的线程连接数量和网络连接数量
 * 1-需要设置batch size和elapsed time，用于控制什么时候，触发command的执行
 */
public class GetProductInfosCollapser extends HystrixCollapser<List<ProductInfo>, ProductInfo, Long> {


    private Long productId;


    @Override
    protected String getCacheKey() {
        return "product_info_" + productId;
    }

    /**
     *
     */
    public GetProductInfosCollapser(Long productId) {
        this.productId = productId;
    }

    /**
     *
     */
    @Override
    public Long getRequestArgument() {
        return productId;
    }

    /**
     *
     */
    @Override
    protected HystrixCommand<List<ProductInfo>> createCommand(Collection<CollapsedRequest<ProductInfo, Long>> requests) {
        return new BatchCommand(requests);
    }

    /**
     *
     */
    @Override
    protected void mapResponseToRequests(List<ProductInfo> batchResponse, Collection<CollapsedRequest<ProductInfo, Long>> requests) {

        AtomicInteger coount = new AtomicInteger(0);
        requests.stream().forEach(request -> {
            request.setResponse(batchResponse.get(coount.getAndIncrement()));
        });
    }


    private static final class BatchCommand extends HystrixCommand<List<ProductInfo>> {

        private final Collection<CollapsedRequest<ProductInfo, Long>> requests;

        protected BatchCommand(Collection<CollapsedRequest<ProductInfo, Long>> requests) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ProductInfoService"))
                    .andCommandKey(HystrixCommandKey.Factory.asKey("GetProductInfosCollapserBatchCommand")));
            this.requests = requests;
        }

        @Override
        protected List<ProductInfo> run() throws Exception {

            StringBuilder stringBuilder = new StringBuilder();

            requests.stream().forEach(echo -> {
                stringBuilder.append(echo.getArgument()).append(",");
            });
            String params = stringBuilder.toString();
            String resultString = params.substring(0, params.length() - 1);

            String url = "http://localhost:8082/getProductInfos?productIds=" + resultString;
            String rsp = HttpClientUtils.sendGetRequest(url);


            List<ProductInfo> productInfos = JSONArray.parseArray(rsp, ProductInfo.class);

            return productInfos;
        }
    }

}
