package com.abstract1.example.test2;

/**
 * @Date: 2021/6/4 21:56
 * @Desc:
 */
public class RoleUserInfoBaseBO {
    private String status;
    private String statusStr;
    private String userLevel;
    private String userLevelStr;
    private String roleLevel;
    private String roleLevelStr;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserLevelStr() {
        return userLevelStr;
    }

    public void setUserLevelStr(String userLevelStr) {
        this.userLevelStr = userLevelStr;
    }

    public String getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getRoleLevelStr() {
        return roleLevelStr;
    }

    public void setRoleLevelStr(String roleLevelStr) {
        this.roleLevelStr = roleLevelStr;
    }

    @Override
    public String toString() {
        return "RoleUserInfoBaseBO{" +
                "status='" + status + '\'' +
                ", statusStr='" + statusStr + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", userLevelStr='" + userLevelStr + '\'' +
                ", roleLevel='" + roleLevel + '\'' +
                ", roleLevelStr='" + roleLevelStr + '\'' +
                '}';
    }
}
