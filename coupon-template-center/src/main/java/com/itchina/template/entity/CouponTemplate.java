package com.itchina.template.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itchina.template.serialization.CouponTemplateSerialize;
import java.io.Serializable;
import java.util.Date;

/**
 * <h1>优惠券模板实体类定义: 基础属性 + 规则属性</h1>
 *  指定自定义序列化器
 */
@JsonSerialize(using = CouponTemplateSerialize.class)
public class CouponTemplate implements Serializable {

    /** 自增主键 */
    private Integer id;

    /** 是否是可用状态 */
    private String available;

    /** 是否过期 */
    private String expired;

    /** 优惠券名称 */
    private String name;

    /** 优惠券 logo */
    private String logo;

    /** 优惠券描述 */
    private String desc;

    /** 优惠券分类 */
    private String category;

    /** 产品线 */
    private String productLine;

    /** 总数 */
    private Integer couponCount;

    /** 创建时间 */
    private Date createTime;

    /** 创建用户 */
    private Long userId;

    /** 优惠券模板的编码 */
    private String templateKey;

    /** 目标用户 */
    private Integer target;

    /** 优惠券规则 */
    private String rule;

    public CouponTemplate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTemplateKey() {
        return templateKey;
    }

    public void setTemplateKey(String templateKey) {
        this.templateKey = templateKey;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    @Override
    public String toString() {
        return "CouponTemplate{" +
                "id=" + id +
                ", available='" + available + '\'' +
                ", expired='" + expired + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", desc='" + desc + '\'' +
                ", category='" + category + '\'' +
                ", productLine='" + productLine + '\'' +
                ", couponCount=" + couponCount +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", templateKey='" + templateKey + '\'' +
                ", target=" + target +
                ", rule='" + rule + '\'' +
                '}';
    }
}
