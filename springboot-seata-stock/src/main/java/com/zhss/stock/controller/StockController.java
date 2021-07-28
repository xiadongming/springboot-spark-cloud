package com.zhss.stock.controller;

import com.zhss.stock.service.UpdateStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/7/27 15:39
 * @Desc:
 */
@RestController
public class StockController {

    @Autowired
    private UpdateStockService updateStockService;

    @RequestMapping(value = "stock")
    public void createStock(){

        try {
            updateStockService.createStock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
