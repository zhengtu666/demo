package com.example.service.spi;

import com.example.model.SysAuth;
import com.example.service.core.spi.IBaseService;

import java.util.List;

/**
 * @author: liuhuan
 * @Description: 权限相关
 * @date: 2018/12/13
 */
public interface ISysAuthService extends IBaseService<SysAuth,Long> {
    List<SysAuth> queryByUserId(Long userId);
}
