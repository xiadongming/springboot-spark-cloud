package com.abstract1.example.test;

import org.springframework.stereotype.Service;

/**
 * @Date: 2021/6/4 20:54
 * @Desc:
 */
@Service("orderQueryService")
public class OrderQueryServiceImpl extends OrderAbstractService {
    @Override
    public String doCreateOrder() {

        voladition();

        return "query-successful";
    }
}
