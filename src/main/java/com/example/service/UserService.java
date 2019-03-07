package com.example.service;

import com.example.model.SysRole;
import com.example.model.SysUser;
import com.example.service.core.BaseService;
import com.example.service.spi.ISysRoleService;
import com.example.service.spi.IUserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

/**
 * @author: liuhuan
 * @Description: 用户相关
 * @date: 2018/12/13
 */
@Service
public class UserService extends BaseService<User,Long> implements IUserService {

    @Override
    public SysUser selectByAccount(String username) {
        return null;
    }
}
