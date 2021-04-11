package com.itchina.common.vo;


/**
 * <h1>微服务之间用的优惠券模板信息定义</h1>
 */
public class CouponTemplateSDK {

    /** 优惠券模板主键 */
    private Integer id;

    /** 优惠券模板名称 */
    private String name;

    /** 优惠券 logo */
    private String logo;

    /** 优惠券描述 */
    private String desc;

    /** 优惠券分类 */
    private String category;

    /** 产品线 */
    private Integer productLine;

    /** 优惠券模板的编码 */
    private String key;

    /** 目标用户 */
    private Integer target;

    /** 优惠券规则 */
    private String rule;

    public CouponTemplateSDK(Integer id, String name, String logo, String desc, String category, Integer productLine, String key, Integer target, String rule) {
        this.id = id;
        this.name = name;
        this.logo=logo;
        this.desc=desc;
        this.category=category;
        this.productLine=productLine;
        this.key=key;
        this.target=target;
        this.rule=rule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getProductLine() {
        return productLine;
    }

    public void setProductLine(Integer productLine) {
        this.productLine = productLine;
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
        return "CouponTemplateSDK{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", desc='" + desc + '\'' +
                ", category='" + category + '\'' +
                ", productLine=" + productLine +
                ", key='" + key + '\'' +
                ", target=" + target +
                ", rule=" + rule +
                '}';
    }
}
