package com.example.model;

/**
 * @author: liuhuan
 * @Description: 角色表，存放所有的角色信息
 * @date: 2018/12/13
 */
public class SysRole {

    private Integer sysRoleAva; //角色是否生效

    private String sysRoleDes;//角色描述

    private String sysRoleName;//角色名称

    public Integer getSysRoleAva() {
        return sysRoleAva;
    }

    public void setSysRoleAva(Integer sysRoleAva) {
        this.sysRoleAva = sysRoleAva;
    }

    public String getSysRoleDes() {
        return sysRoleDes;
    }

    public void setSysRoleDes(String sysRoleDes) {
        this.sysRoleDes = sysRoleDes;
    }

    public String getSysRoleName() {
        return sysRoleName;
    }

    public void setSysRoleName(String sysRoleName) {
        this.sysRoleName = sysRoleName;
    }
}
