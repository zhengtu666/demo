package com.example.service;

import com.example.model.SysRole;
import com.example.service.core.BaseService;
import com.example.service.spi.ISysRoleService;
import com.example.service.spi.IUserService;
import org.apache.catalina.User;

/**
 * @author: liuhuan
 * @Description: 用户相关
 * @date: 2018/12/13
 */
public class UserService extends BaseService<User,Long> implements IUserService {

}
