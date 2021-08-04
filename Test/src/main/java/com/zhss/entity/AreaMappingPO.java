package com.zhss.entity;

import java.io.Serializable;

/**
 * @Date: 2021/8/3 14:06
 * @Desc:
 */
public class AreaMappingPO implements Serializable {


    /** 地区编码 */
    private String areaCode;

    /** 地区名称 */
    private String areaName;

    /** 上级地区编码 */
    private String parentCode;

    /** 地区级别1-全国2-省3-地市4-区县 */
    private String areaLevel;

    /** 地区路径 如：1-12-121-  */
    private String areaTreePath;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(String areaLevel) {
        this.areaLevel = areaLevel;
    }

    public String getAreaTreePath() {
        return areaTreePath;
    }

    public void setAreaTreePath(String areaTreePath) {
        this.areaTreePath = areaTreePath;
    }

    @Override
    public String toString() {
        return "AreaMappingPO{" +
                "areaCode='" + areaCode + '\'' +
                ", areaName='" + areaName + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", areaLevel='" + areaLevel + '\'' +
                ", areaTreePath='" + areaTreePath + '\'' +
                '}';
    }
}
