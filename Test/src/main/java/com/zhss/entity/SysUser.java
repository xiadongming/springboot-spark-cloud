package com.zhss.entity;

/**
 * @Date: 2021/7/5 17:29
 * @Desc:
 */
public class SysUser {

    private String userId;
    private String loginName;
    private String password;
    private String cellPhone;
    private String email;
    private String status;
    private String roleName;

    private Boolean isAuto;
    private boolean isAuto2;


    public boolean isAuto2() {
        return isAuto2;
    }

    public void setAuto2(boolean auto2) {
        isAuto2 = auto2;
    }

    public Boolean getAuto() {
        return isAuto;
    }

    public void setAuto(Boolean auto) {
        isAuto = auto;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId='" + userId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", roleName='" + roleName + '\'' +
                ", isAuto=" + isAuto +
                ", isAuto2=" + isAuto2 +
                '}';
    }
}
