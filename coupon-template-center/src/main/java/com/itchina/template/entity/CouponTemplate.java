package com.itchina.template.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itchina.common.constant.CouponCategory;
import com.itchina.common.constant.DistributeTarget;
import com.itchina.common.constant.ProductLine;
import com.itchina.common.vo.TemplateRule;
import com.itchina.template.serialization.CouponTemplateSerialize;
import org.springframework.data.annotation.CreatedDate;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
    private Integer count;

    /** 创建时间 */
    private Date createTime;

    /** 创建用户 */
    private Long userId;

    /** 优惠券模板的编码 */
    private String key;

    /** 目标用户 */
    private Integer target;

    /** 优惠券规则 */
    private String rule;

    public CouponTemplate() {
    }

    /**
     * <h2>自定义构造函数</h2>
     * */
    public CouponTemplate(String available,String expired ,String name, String logo, String desc, String category,
                          Integer productLine, Integer count, Long userId,
                          Integer target, String rule) {

        this.available = available;
        this.expired = expired;
        this.name = name;
        this.logo = logo;
        this.desc = desc;
        this.count = count;
        this.userId = userId;
        // 优惠券模板唯一编码 = 4(产品线和类型) + 8(日期: 20190101) + id(扩充为4位)
        this.key = productLine.toString() + category +
                new SimpleDateFormat("yyyyMMdd").format(new Date());
        this.rule = rule;
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
                ", category=" + category +
                ", productLine=" + productLine +
                ", count=" + count +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", key='" + key + '\'' +
                ", target=" + target +
                ", rule=" + rule +
                '}';
    }
}
