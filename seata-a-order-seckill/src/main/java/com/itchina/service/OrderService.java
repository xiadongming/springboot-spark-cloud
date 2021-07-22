package com.itchina.service;


import com.itchina.model.OrderModel;

/**
 */
public interface OrderService {
    OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount, String stockLogId) ;

}
