package com.itchina.template.schedule;

import com.itchina.common.vo.TemplateRule;
import com.itchina.template.entity.CouponTemplate;
import com.itchina.template.mapper.CouponTemplateMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <h1>定时清理已过期的优惠券模板</h1>
 * Created by Qinyi.
 */
@Component
public class ScheduledTask {
    final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    @Autowired
    private  CouponTemplateMapper couponTemplateMapper;

    /**
     * <h2>下线已过期的优惠券模板</h2>
     * */
    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void offlineCouponTemplate() {

        logger.info("Start To Expire CouponTemplate");

        List<CouponTemplate> templates =  couponTemplateMapper.selectAll();
        if (CollectionUtils.isEmpty(templates)) {
            logger.info("Done To Expire CouponTemplate.");
            return;
        }

        Date cur = new Date();
        List<CouponTemplate> expiredTemplates =  new ArrayList<>(templates.size());

        templates.forEach(t -> {
            // 根据优惠券模板规则中的 "过期规则" 校验模板是否过期
          /*  TemplateRule rule = t.getRuleCode();
            if (rule.getExpiration().getDeadline() < cur.getTime()) {
                t.setExpired(true);
                expiredTemplates.add(t);
            }*/
        });
        if (CollectionUtils.isNotEmpty(expiredTemplates)) {
            /**
             * 方便起见，循环调用
             * */
            for (CouponTemplate expiredTemplate : expiredTemplates) {
                couponTemplateMapper.updateTemplate(expiredTemplate);
            }
            logger.info("Expired CouponTemplate Num: {}", expiredTemplates.size());
        }
        logger.info("Done To Expire CouponTemplate.");
    }
}
