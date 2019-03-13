package com.example.service;

import com.example.dao.mapper.SysUserMapper;
import com.example.dto.SysUserDto;
import com.example.service.core.BaseService;
import com.example.service.spi.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: liuhuan
 * @Description: 用户相关
 * @date: 2018/12/13
 */
@Service
public class SysUserService extends BaseService<SysUserDto,Long> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUserDto selectByAccount(String account) {
        return sysUserMapper.findByAccount(account);
    }
}
