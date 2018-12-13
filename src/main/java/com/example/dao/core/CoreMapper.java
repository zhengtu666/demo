package com.example.dao.core;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.base.insert.InsertMapper;

/**
 * @author: liuhuan
 * @Description: mapper插件接口
 * @date: 2018/12/13
 */
public interface CoreMapper<T> extends BaseMapper<T>, ConditionMapper<T>, InsertMapper<T> {
}
