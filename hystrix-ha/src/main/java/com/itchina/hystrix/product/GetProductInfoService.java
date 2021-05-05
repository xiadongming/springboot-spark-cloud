package com.itchina.hystrix.product;

import com.itchina.hystrix.model.ProductInfo;

/**
 * @Date: 2021/5/5 7:29
 * @Desc:
 */
public interface GetProductInfoService {

    ProductInfo getProductInfo(Long productId);

}
