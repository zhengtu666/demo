package com.example.service.core;

import com.example.dao.core.CoreMapper;
import com.example.service.core.spi.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author: liuhuan
 * @Description: 基类服务实现
 * @date: 2018/12/13
 */
public class BaseService<T,PK extends Serializable> implements IBaseService<T,PK> {

    //@Autowired
    private CoreMapper coreMapper;


    @Override
    public T findById(PK id) {
        return (T) coreMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(T t) {
        coreMapper.insert(t);
    }

    @Override
    public void update(T t) {
        coreMapper.updateByPrimaryKey(t);
    }

    @Override
    public void delete(PK id) {
        coreMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(PK[] ids) {
        coreMapper.delete(ids);
    }


    @Override
    public <T> List<T> search(T var1) {
        return coreMapper.select(var1);
    }
}
