package com.example.demo.stream.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.stream.chnnel.MyChnnel;

@Service
@EnableBinding(MyChnnel.class)
public class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @StreamListener(target = MyChnnel.SHOP_INPUT)
    @Transactional
    public void consumeProject(String messageJson) throws IOException {
        System.out.println("消费数据 ====   " + messageJson + "   ======11111");
    }

    @StreamListener(target = MyChnnel.SHOP_INPUT)
    @Transactional
    public void consumeAddress(String messageJson) throws IOException {
        System.out.println("地址信息 ====   " + messageJson + "   ======22222");
    }
}
