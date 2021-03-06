package com.example.service;

import com.example.model.SysAuth;
import com.example.model.SysRole;
import com.example.service.core.BaseService;
import com.example.service.spi.ISysAuthService;
import com.example.service.spi.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: liuhuan
 * @Description: 角色相关
 * @date: 2018/12/13
 */
@Service
public class SysRoleService extends BaseService<SysRole,Long> implements ISysRoleService {
    @Override
    public List<SysRole> selectRoleByUser(Long userId) {
        return null;
    }
}
