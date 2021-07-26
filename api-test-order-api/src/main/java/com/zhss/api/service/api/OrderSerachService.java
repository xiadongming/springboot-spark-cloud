package com.zhss.api.service.api;


import entity.SearchOrderInfoPO;
import entity.SearchOrderInfoRspBO;

/**
 * @Date: 2021/7/23 15:13
 * @Desc:
 */
public interface OrderSerachService {

    SearchOrderInfoRspBO elasticSearchOrders(SearchOrderInfoPO searchOrderInfoPO);

}
