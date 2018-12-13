package com.example.model;

/**
 * @author: liuhuan
 * @Description: 用来存储用户的密码，用户名等等信息
 * @date: 2018/12/13
 */
public class SysUser {

    private Integer userId;

    private String userAccount;//用户账号

    private String userPassword;//用户密码

    private Integer UserState;//用户状态

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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
        return UserState;
    }

    public void setUserState(Integer userState) {
        UserState = userState;
    }
}
