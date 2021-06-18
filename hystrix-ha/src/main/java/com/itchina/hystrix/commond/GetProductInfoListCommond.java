package com.itchina.hystrix.commond;

import com.alibaba.fastjson.JSONObject;
import com.itchina.hystrix.http.HttpClientUtils;
import com.itchina.hystrix.model.ProductInfo;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;

import java.util.List;

/**
 * @Date: 2021/5/5 7:23
 * @Desc:
 */
public class GetProductInfoListCommond extends HystrixObservableCommand<ProductInfo> {

    private List<Long> productIdList;

    public GetProductInfoListCommond(List<Long> productIdList) {
        super(HystrixCommandGroupKey.Factory.asKey("GetProductInfoGroup"));
        this.productIdList = productIdList;
    }

    @Override
    protected Observable<ProductInfo> construct() {
        return Observable.create(new Observable.OnSubscribe<ProductInfo>() {
            @Override
            public void call(Subscriber<? super ProductInfo> observer) {
                System.out.println("调用HystrixObservableCommand的call方法");
                try {
                    for (Long aLong : productIdList) {
                        String url = "http://127.0.0.1:9122/getNoHystrix?productId=" + aLong;
                        String response = HttpClientUtils.sendGetRequest(url);
                        ProductInfo parse = JSONObject.parseObject(response, ProductInfo.class);
                        observer.onNext(parse);
                    }
                    observer.onCompleted();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
