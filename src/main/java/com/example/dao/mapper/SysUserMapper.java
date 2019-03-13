package com.example.dao.mapper;

import com.example.dao.core.CoreMapper;
import com.example.dto.SysUserDto;

/**
 * @author: liuhuan
 * @Description: 用户
 * @date: 2019/2/14
 */

public interface SysUserMapper extends CoreMapper<SysUserDto> {

   SysUserDto findByAccount(String account);
}
