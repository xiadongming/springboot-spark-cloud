package com.zhss.entity;

import java.io.Serializable;
import java.util.List;

public class OrgTreeChildRspBO implements Serializable {
    private Long orgId;
    private String orgName;
    private Long parentOrgId;
    private String orgType;
    private String orgTreePath;
    private String provinceCode;
    private String cityCode;
    private String districtCode;
    private String storeId;
    private String provinceName;
    private String cityName;
    private String districtName;
    private String storeAttr;//业务类型
    private String storeAttrName;//业务类型转义
    private String isSelf;//门店类型
    private String isSelfStr;//门店类型转义
    private String isCutover;
    private String isSynScm;
    private String scmCustomerNo;//scm客户编号
    private String outInvoiceCode;//开票编码

    /** 是否制定销售计划  1-是 0-否  20201210版本 */
    private String isSalesPlan;
    /** 门店地址 */
    private String orgAddr;

    /** 门店名称 */
    private String storeName;

    private Integer isParent;

    private List<OrgTreeChildRspBO> children ;

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgTreePath() {
        return orgTreePath;
    }

    public void setOrgTreePath(String orgTreePath) {
        this.orgTreePath = orgTreePath;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getStoreAttr() {
        return storeAttr;
    }

    public void setStoreAttr(String storeAttr) {
        this.storeAttr = storeAttr;
    }

    public String getStoreAttrName() {
        return storeAttrName;
    }

    public void setStoreAttrName(String storeAttrName) {
        this.storeAttrName = storeAttrName;
    }

    public String getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(String isSelf) {
        this.isSelf = isSelf;
    }

    public String getIsSelfStr() {
        return isSelfStr;
    }

    public void setIsSelfStr(String isSelfStr) {
        this.isSelfStr = isSelfStr;
    }

    public String getIsCutover() {
        return isCutover;
    }

    public void setIsCutover(String isCutover) {
        this.isCutover = isCutover;
    }

    public String getIsSynScm() {
        return isSynScm;
    }

    public void setIsSynScm(String isSynScm) {
        this.isSynScm = isSynScm;
    }

    public String getScmCustomerNo() {
        return scmCustomerNo;
    }

    public void setScmCustomerNo(String scmCustomerNo) {
        this.scmCustomerNo = scmCustomerNo;
    }

    public String getOutInvoiceCode() {
        return outInvoiceCode;
    }

    public void setOutInvoiceCode(String outInvoiceCode) {
        this.outInvoiceCode = outInvoiceCode;
    }

    public String getIsSalesPlan() {
        return isSalesPlan;
    }

    public void setIsSalesPlan(String isSalesPlan) {
        this.isSalesPlan = isSalesPlan;
    }

    public String getOrgAddr() {
        return orgAddr;
    }

    public void setOrgAddr(String orgAddr) {
        this.orgAddr = orgAddr;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<OrgTreeChildRspBO> getChildren() {
        return children;
    }

    public void setChildren(List<OrgTreeChildRspBO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "OrgTreeChildRspBO{" +
                "orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                ", parentOrgId=" + parentOrgId +
                ", orgType='" + orgType + '\'' +
                ", orgTreePath='" + orgTreePath + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", districtCode='" + districtCode + '\'' +
                ", storeId='" + storeId + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", districtName='" + districtName + '\'' +
                ", storeAttr='" + storeAttr + '\'' +
                ", storeAttrName='" + storeAttrName + '\'' +
                ", isSelf='" + isSelf + '\'' +
                ", isSelfStr='" + isSelfStr + '\'' +
                ", isCutover='" + isCutover + '\'' +
                ", isSynScm='" + isSynScm + '\'' +
                ", scmCustomerNo='" + scmCustomerNo + '\'' +
                ", outInvoiceCode='" + outInvoiceCode + '\'' +
                ", isSalesPlan='" + isSalesPlan + '\'' +
                ", orgAddr='" + orgAddr + '\'' +
                ", storeName='" + storeName + '\'' +
                ", isParent=" + isParent +
                ", children=" + children +
                '}';
    }
}
