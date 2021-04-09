package com.itchina.common.vo;

/**
 * @Date: 2021/4/9 8:04
 * @Desc: 用于微服务之间优惠卷模板的信息定义
 */
public class CouponTemplateSDK {
    private Integer id;

    private String name ;
    private String logo;
    private String desc ;
    private String category;
    private Integer productLine;
    /** 优惠卷模板编码 */
    private String key;

    private Integer target;//目标用户

    private TemplateRule rule;//优惠卷规则

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

    public TemplateRule getRule() {
        return rule;
    }

    public void setRule(TemplateRule rule) {
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
