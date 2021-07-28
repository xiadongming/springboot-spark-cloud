package com.zhss.stock.entity;

import java.io.Serializable;

/**
 * @Date: 2021/7/27 15:14
 * @Desc:
 */
public class Storage implements Serializable {

    private Integer id;
    private String stockCode;
    private String name;
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", stockCode='" + stockCode + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
