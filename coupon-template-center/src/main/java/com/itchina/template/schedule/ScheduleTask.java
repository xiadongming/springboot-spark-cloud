package com.itchina.template.schedule;

import com.itchina.template.entity.CouponTemplate;
import com.itchina.template.mapper.CouponTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Date: 2021/4/9 22:24
 * @Desc: 定时清理过期优惠卷模板
 */
@Component
public class ScheduleTask {
    @Autowired
    CouponTemplateMapper couponTemplateMapper;

    /**
     * 每一个小时执行一次
     */
    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void offlineCouponTemplate() {
        System.out.println("定时任务清理过期优惠卷模板，时间= " + new Date());
        /**
         * 查询出可用的有优惠卷模板
         * */
        List<CouponTemplate> templateList = couponTemplateMapper.selectOfflineTemplate();
        if(CollectionUtils.isEmpty(templateList)){
            System.out.println("未查询到可用优惠卷模板");
            return;
        }
       /**
        *根据优惠卷模板规则，判断是否过期
        * */
        ArrayList<CouponTemplate> objects = new ArrayList<>(templateList.size());
        Date date = new Date();
        templateList.forEach(tem ->{
            /** 可以修改成从数据库查询或是redis查询，模板对应的规则 */
            String rule = tem.getRule();
            if(date.getTime() > 1000){
               tem.setExpired("1");//标记位过期
                objects.add(tem);
            }
        });

        /**
         * 方便起见，循环调用
         * */
        for (CouponTemplate object : objects) {
            couponTemplateMapper.updateTemplate(object);
        }
    }

}
