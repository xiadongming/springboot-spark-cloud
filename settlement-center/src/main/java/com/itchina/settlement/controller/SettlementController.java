package com.itchina.settlement.controller;

import com.alibaba.fastjson.JSON;
import com.itchina.common.exception.CouponException;
import com.itchina.common.vo.SettlementInfo;
import com.itchina.settlement.executor.ExecuteManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>结算服务 Controller</h1>
 * Created by Qinyi.
 */
@RestController
public class SettlementController {
    final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    /** 结算规则执行管理器 */
    @Autowired
    private  ExecuteManager executeManager;


    /**
     * <h2>优惠券结算</h2>
     * 127.0.0.1:7003/coupon-settlement/settlement/compute
     * 127.0.0.1:9000/imooc/coupon-settlement/settlement/compute
     * */
    @PostMapping("/settlement/compute")
    public SettlementInfo computeRule(@RequestBody SettlementInfo settlement)  throws CouponException {
        logger.info("settlement: {}", JSON.toJSONString(settlement));
        return executeManager.computeRule(settlement);
    }
}
