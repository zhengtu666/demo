package com.example.model;

import com.example.common.bean.BaseEntity;

/**
 * @author: liuhuan
 * @Description: 权限表，定义了一些操作访问权限信息。
 * @date: 2018/12/13
 */
public class SysAuth extends BaseEntity {


    private String sysAuthCode; //权限编号

    private String sysAuthName; //权限名称

    private String sysAuthUrl; //权限请求的url 例如: user/login

    private String sysAuthPermission; //权限的的名称例如 user:login

    private Integer sysAuthAva; //权限是否有效

    private String sysAuthDes; //权限描述

    public String getSysAuthCode() {
        return sysAuthCode;
    }

    public void setSysAuthCode(String sysAuthCode) {
        this.sysAuthCode = sysAuthCode;
    }

    public String getSysAuthName() {
        return sysAuthName;
    }

    public void setSysAuthName(String sysAuthName) {
        this.sysAuthName = sysAuthName;
    }

    public String getSysAuthUrl() {
        return sysAuthUrl;
    }

    public void setSysAuthUrl(String sysAuthUrl) {
        this.sysAuthUrl = sysAuthUrl;
    }

    public String getSysAuthPermission() {
        return sysAuthPermission;
    }

    public void setSysAuthPermission(String sysAuthPermission) {
        this.sysAuthPermission = sysAuthPermission;
    }

    public Integer getSysAuthAva() {
        return sysAuthAva;
    }

    public void setSysAuthAva(Integer sysAuthAva) {
        this.sysAuthAva = sysAuthAva;
    }

    public String getSysAuthDes() {
        return sysAuthDes;
    }

    public void setSysAuthDes(String sysAuthDes) {
        this.sysAuthDes = sysAuthDes;
    }
}
