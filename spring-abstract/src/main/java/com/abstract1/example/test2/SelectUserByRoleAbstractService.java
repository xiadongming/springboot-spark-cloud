package com.abstract1.example.test2;

/**
 * @Date: 2021/6/4 21:56
 * @Desc:
 */
public abstract class SelectUserByRoleAbstractService implements SelectUserByRoleService{
    public    void validStatue(RoleUserInfoBaseBO baseBO) {
        //0：正常1：锁定 2：注销 3：待审核
        switch (baseBO.getStatus()) {
            case "0":
                baseBO.setStatusStr("正常");
                break;
            case "1":
                baseBO.setStatusStr("锁定");
                break;
            case "2":
                baseBO.setStatusStr("注销");
                break;
            case "3":
                baseBO.setStatusStr("待审核");
                break;
            default:
                baseBO.setStatusStr(null);
        }
    }

    public  void validUserLevel(RoleUserInfoBaseBO baseBO) {
        switch (baseBO.getUserLevel()) {
            case "1":
                baseBO.setUserLevelStr("总部级");
                break;
            case "2":
                baseBO.setUserLevelStr("省份级");
                break;
            case "3":
                baseBO.setUserLevelStr("地市级");
                break;
            case "4":
                baseBO.setUserLevelStr("区县级");
                break;
            case "5":
                baseBO.setUserLevelStr("公司级");
                break;
            default:
                baseBO.setUserLevelStr(null);
        }
    }
    public  void validRoleLevel(RoleUserInfoBaseBO baseBO) {
        switch (baseBO.getRoleLevel()) {
            case "01":
                baseBO.setRoleLevelStr("全省");
                break;
            case "02":
                baseBO.setRoleLevelStr("地市");
                break;
            case "03":
                baseBO.setRoleLevelStr("厅店");
                break;
            default:
                baseBO.setRoleLevelStr(null);
        }
    }

}
