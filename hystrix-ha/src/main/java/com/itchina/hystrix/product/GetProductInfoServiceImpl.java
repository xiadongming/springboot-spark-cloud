package com.itchina.hystrix.product;

import com.itchina.hystrix.model.ProductInfo;
import org.springframework.stereotype.Service;

/**
 * @Date: 2021/5/5 7:29
 * @Desc:
 */
@Service
public class GetProductInfoServiceImpl implements GetProductInfoService {


    @Override
    public ProductInfo getProductInfo(Long productId) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setAddress("北京市");
        productInfo.setName("长治久安");
        productInfo.setProductId(productId);
        return productInfo;
    }
}
