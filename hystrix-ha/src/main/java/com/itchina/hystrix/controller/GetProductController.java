package com.itchina.hystrix.controller;

import com.itchina.hystrix.model.ProductInfo;
import com.itchina.hystrix.product.GetProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/5/5 7:39
 * @Desc:
 */
@RestController
public class GetProductController {

    @Autowired
    private GetProductInfoService getProductInfoService;

    @RequestMapping(value = "/getNoHystrix")
    public ProductInfo getProductNoHystrix(Long productId) {
        ProductInfo productInfo = getProductInfoService.getProductInfo(productId);
        //productInfo.setProductId(productId);
        return productInfo;
    }

}
