package com.example.service.spi;

import com.example.model.SysAuth;
import com.example.model.SysRole;
import com.example.service.core.spi.IBaseService;

import java.util.List;

/**
 * @author: liuhuan
 * @Description: 角色服务接口
 * @date: 2018/12/13
 */
public interface ISysRoleService extends IBaseService<SysRole,Long> {
    List<SysRole> selectRoleByUser(Integer userId);
}
