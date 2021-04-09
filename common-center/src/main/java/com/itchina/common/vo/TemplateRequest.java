package com.itchina.common.vo;


import org.apache.commons.lang3.StringUtils;

/**
 * @Date: 2021/4/9 7:24
 * @Desc: 优惠卷模板创建请求
 */
public class TemplateRequest {



    private String name;
    private String logo;
    private String desc ;

    private String category;
    private Integer productLine;
    private Integer count;
    private Long userId;
    private Integer target;//目标用户
    private TemplateRule rule;//优惠卷规则

    /**
     * 合法性校验
     * */
    public boolean volidate(){
         boolean stringValid = StringUtils.isNotBlank(name) && StringUtils.isNotBlank(logo) && StringUtils.isNotBlank(desc);
         boolean enumValid = StringUtils.isNotBlank(category) && null != productLine && null != target;
        return stringValid && enumValid;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
