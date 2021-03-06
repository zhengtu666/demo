package com.example.service.spi;

import com.example.dto.SysUserDto;
import com.example.model.SysRole;
import com.example.model.SysUser;
import com.example.service.core.spi.IBaseService;
import org.apache.catalina.User;

/**
 * @author: liuhuan
 * @Description: 用户相关
 * @date: 2018/12/13
 */
public interface ISysUserService extends IBaseService<SysUserDto,Long> {
    SysUserDto selectByAccount(String username);
}
