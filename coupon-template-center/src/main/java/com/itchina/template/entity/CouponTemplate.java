package com.itchina.template.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itchina.template.converter.CouponCategoryConverter;
import com.itchina.template.converter.DistributeTargetConverter;
import com.itchina.template.converter.ProductLineConverter;
import com.itchina.template.converter.RuleConverter;
import com.itchina.template.serialization.CouponTemplateSerialize;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Transient;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <h1>优惠券模板实体类定义: 基础属性 + 规则属性</h1>
 */
@JsonSerialize(using = CouponTemplateSerialize.class)
public class CouponTemplate implements Serializable {

    /** 自增主键 */
    private Integer id;

    /** 是否是可用状态 */
    private Boolean available;

    /** 是否过期 */
    private Boolean expired;

    /** 优惠券名称 */
    private String name;

    /** 优惠券 logo */
    private String logo;

    /** 优惠券描述 */
    private String desc;

    /** 优惠券分类 */
    @Column(name = "category", nullable = false)
    @Convert(converter = CouponCategoryConverter.class)
    private String categoryCode;

    /** 产品线 */
    @Column(name = "product_line", nullable = false)
    @Convert(converter = ProductLineConverter.class)
    private String productLineCode;

    /** 总数 */
    private Integer count;

    /** 创建时间 */
    private Date createTime;

    /** 创建用户 */
    private Long userId;

    /** 优惠券模板的编码 */
    private String key;

    /** 目标用户 */
    @Column(name = "target", nullable = false)
    @Convert(converter = DistributeTargetConverter.class)
    private String targetCode;

    /** 优惠券规则 */
    @Column(name = "rule", nullable = false)
    @Convert(converter = RuleConverter.class)
    private String ruleCode;

    /**
     * <h2>自定义构造函数</h2>
     * */
    public CouponTemplate(String name, String logo, String desc, String category,
                          String productLine, Integer count, Long userId,
                          String target, String rule) {

        this.available = false;
        this.expired = false;
        this.name = name;
        this.logo = logo;
        this.desc = desc;
        this.categoryCode = category;
        this.productLineCode = productLine;
        this.count = count;
        this.userId = userId;
        // 优惠券模板唯一编码 = 4(产品线和类型) + 8(日期: 20190101) + id(扩充为4位)
        this.key = productLine.toString() + category +
                new SimpleDateFormat("yyyyMMdd").format(new Date());
        this.targetCode = target;
        this.ruleCode = rule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getProductLineCode() {
        return productLineCode;
    }

    public void setProductLineCode(String productLineCode) {
        this.productLineCode = productLineCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }
}
