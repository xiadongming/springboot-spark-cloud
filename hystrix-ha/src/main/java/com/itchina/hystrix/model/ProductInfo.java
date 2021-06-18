package com.itchina.hystrix.model;

/**
 * @Date: 2021/5/5 7:24
 * @Desc:
 */
public class ProductInfo {


    private String name;
    private String address;

    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", productId=" + productId +
                '}';
    }
}
