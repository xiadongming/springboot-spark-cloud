package com.itchina.hystrix.controller;


import com.alibaba.fastjson.JSONObject;
import com.itchina.hystrix.commond.GetBrandInfoCommond;
import com.itchina.hystrix.commond.GetProductInfoCommond;
import com.itchina.hystrix.commond.GetProductInfoListCommond;
import com.itchina.hystrix.http.HttpClientUtils;
import com.itchina.hystrix.model.ProductInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/5/5 7:02
 * @Desc: 场景：去调用缓存服务，假设耗尽线程，模拟hystrix的场景
 * ：对缓存的调用，都是使用hystrix中的线程池的
 */
@RestController
public class CacheController {


    @RequestMapping(value = "/cacheNoHystrix")
    public ProductInfo getProductNoHystrix(Long productId) {
        String url = "http://127.0.0.1:9122/getNoHystrix?productId=" + productId;
        String response = HttpClientUtils.sendGetRequest(url);
        ProductInfo parse = JSONObject.parseObject(response, ProductInfo.class);
        return parse;

    }

    @RequestMapping(value = "/getHystrix")
    public ProductInfo getProductHystrix(Long productId) {
        GetProductInfoCommond getProductInfoCommond = new GetProductInfoCommond(productId);
        ProductInfo execute = getProductInfoCommond.execute();

        System.out.println("是否从缓存中获取："+getProductInfoCommond.isResponseFromCache());

        return execute;
    }
    /**
     * 模拟降级策略
     * */
    @RequestMapping(value = "/getHystrixFallback")
    public String getProductHystrixFallback(Long brandId) {
        GetBrandInfoCommond GetBrandInfoCommond = new GetBrandInfoCommond(brandId);
        String execute = GetBrandInfoCommond.execute();
        return execute;
    }
    @RequestMapping(value = "/getHystrixCache")
    public String getProductHystrixCache() {
        List<Long> productIdList = new ArrayList<>();
        productIdList.add(1L);
        productIdList.add(1L);
        productIdList.add(2L);
        productIdList.add(3L);
        for (Long productId : productIdList) {
            GetProductInfoCommond getProductInfoCommond = new GetProductInfoCommond(productId);
            ProductInfo execute = getProductInfoCommond.execute();
            System.out.println("是否从缓存中获取："+getProductInfoCommond.isResponseFromCache());
        }
        return "successful";
    }


    @RequestMapping(value = "/getHystrixList")
    public String getProductHystrixList() {
        List<Long> productIdList = new ArrayList<>();
        productIdList.add(1L);
        productIdList.add(1L);
        productIdList.add(2L);
        productIdList.add(3L);
        GetProductInfoListCommond getProductInfoListCommond = new GetProductInfoListCommond(productIdList);
         Observable<ProductInfo> observe = getProductInfoListCommond.observe();
        observe.subscribe(new Observer<ProductInfo>() {
            @Override
            public void onCompleted() {
                System.out.println("获取完成所有的商品数据");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(ProductInfo productInfo) {
                System.out.println("productInfo= " + productInfo);
            }
        });
        return "successful";
    }

    /**
     * 请求折叠
     */



}
