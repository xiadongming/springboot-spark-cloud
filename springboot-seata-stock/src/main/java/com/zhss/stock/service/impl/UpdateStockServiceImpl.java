package com.zhss.stock.service.impl;

import com.zhss.stock.entity.Storage;
import com.zhss.stock.mapper.StorageMapper;
import com.zhss.stock.service.UpdateStockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Date: 2021/7/27 15:33
 * @Desc:
 */
@Service
public class UpdateStockServiceImpl implements UpdateStockService {

    private static final Logger logger = LoggerFactory.getLogger(UpdateStockServiceImpl.class);

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void createStock() throws Exception {

        try {
            Storage template = new Storage();
            template.setCount(300);
            template.setName("北京");
            template.setStockCode(String.valueOf(new Random().nextInt(1000)));
            storageMapper.saveTemplate(template);
        } catch (Exception e) {
            logger.error("更新库存失败", e);
            throw new Exception();
        }
    }
}
