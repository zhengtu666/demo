package com.example.model;

import com.example.common.bean.BaseEntity;

/**
 * @author: liuhuan
 * @Description: 用来存储用户的密码，用户名等等信息
 * @date: 2018/12/13
 */
public class SysUser extends BaseEntity {


    private String userAccount;//用户账号

    private String userPassword;//用户密码

    private Integer userState;//用户状态

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }
}
