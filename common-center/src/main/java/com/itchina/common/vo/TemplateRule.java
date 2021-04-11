package com.itchina.common.vo;

import com.itchina.common.constant.CodeBaseEnum;
import com.itchina.common.constant.PeriodType;
import org.apache.commons.lang3.StringUtils;

/**
 * <h1>优惠券规则对象定义</h1>
 * Created by Qinyi.
 */
public class TemplateRule {

    /** 优惠券过期规则 */
    private Expiration expiration;

    /** 折扣 */
    private Discount discount;

    /** 每个人最多领几张的限制 */
    private Integer limitation;

    /** 使用范围: 地域 + 商品类型 */
    private Usage usage;

    /** 权重(可以和哪些优惠券叠加使用, 同一类的优惠券一定不能叠加): list[], 优惠券的唯一编码 */
    private String weight;

    /**
     * <h2>校验功能</h2>
     * */
    public boolean validate() {
        return expiration.validate() && discount.validate() && limitation > 0 && usage.validate() && StringUtils.isNotEmpty(weight);
    }


    /**
     * <h2>有效期限规则</h2>
     * */
    public static class Expiration {

        /** 有效期规则, 对应 PeriodType 的 code 字段 */
        private Integer period;

        /** 有效间隔: 只对变动性有效期有效 */
        private Integer gap;

        /** 优惠券模板的失效日期, 两类规则都有效 */
        private Long deadline;

        boolean validate() {
            // 最简化校验
            return null != PeriodType.of(period) && gap > 0 && deadline > 0;
        }

        public Integer getPeriod() {
            return period;
        }

        public void setPeriod(Integer period) {
            this.period = period;
        }

        public Integer getGap() {
            return gap;
        }

        public void setGap(Integer gap) {
            this.gap = gap;
        }

        public Long getDeadline() {
            return deadline;
        }

        public void setDeadline(Long deadline) {
            this.deadline = deadline;
        }
    }

    /**
     * <h2>折扣, 需要与类型配合决定</h2>
     * */
    public static class Discount {

        /** 额度: 满减(20), 折扣(85), 立减(10) */
        private Integer quota;

        /** 基准, 需要满多少才可用 */
        private Integer base;

        boolean validate() {

            return quota > 0 && base > 0;
        }

        public Integer getQuota() {
            return quota;
        }

        public void setQuota(Integer quota) {
            this.quota = quota;
        }

        public Integer getBase() {
            return base;
        }

        public void setBase(Integer base) {
            this.base = base;
        }
    }

    /**
     * <h2>使用范围</h2>
     * */
    public static class Usage {

        /** 省份 */
        private String province;

        /** 城市 */
        private String city;

        /** 商品类型, list[文娱, 生鲜, 家居, 全品类] */
        private String goodsType;

        boolean validate() {

            return StringUtils.isNotEmpty(province)
                    && StringUtils.isNotEmpty(city)
                    && StringUtils.isNotEmpty(goodsType);
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(String goodsType) {
            this.goodsType = goodsType;
        }
    }

    public Expiration getExpiration() {
        return expiration;
    }

    public void setExpiration(Expiration expiration) {
        this.expiration = expiration;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Integer getLimitation() {
        return limitation;
    }

    public void setLimitation(Integer limitation) {
        this.limitation = limitation;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
