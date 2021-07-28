package com.zhss.controller;

import com.zhss.controller.service.SeataService;
import com.zhss.order.service.UpdateOrderService;
import com.zhss.stock.service.UpdateStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/7/27 15:56
 * @Desc:
 */
@RestController
public class SeataController {

    @Autowired
    private SeataService seataService;


    @RequestMapping(value = "/seata")
    public Object seataTest() throws Exception {

        seataService.seateCreate();

        return "successful";
    }

}
