package com.zhss.api.order.impl;

import com.zhss.api.service.api.OrderSerachService;
import entity.SearchOrderInfoPO;
import entity.SearchOrderInfoRspBO;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Date: 2021/7/23 15:14
 * @Desc:
 */
@Service
public class OrderSerachServiceImpl implements OrderSerachService {

    private static final Logger logger = LoggerFactory.getLogger(OrderSerachServiceImpl.class);

    @Override
    public SearchOrderInfoRspBO elasticSearchOrders(SearchOrderInfoPO searchOrderInfoPO) {
        logger.info("elasticsearch入参：{}", searchOrderInfoPO);

        SearchOrderInfoRspBO rspBO = searchOrderInfoPO.clone(SearchOrderInfoRspBO.class);
        return rspBO;
    }
}
