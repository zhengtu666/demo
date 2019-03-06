package com.example.service;

import com.example.model.SysAuth;
import com.example.service.core.BaseService;
import com.example.service.spi.ISysAuthService;

import java.util.List;

/**
 * @author: liuhuan
 * @Description: 权限
 * @date: 2018/12/13
 */
public class SysAuthService extends BaseService<SysAuth,Long> implements ISysAuthService {

    @Override
    public List<SysAuth> queryByUserId(Long userId) {
        return null;
    }
}
