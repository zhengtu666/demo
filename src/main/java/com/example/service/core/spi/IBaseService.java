package com.example.service.core.spi;

import java.io.Serializable;
import java.util.List;

/**
 * @author: liuhuan
 * @Description: 服务父接口
 * @date: 2018/12/13
 */
public interface IBaseService<T,PK extends Serializable>{

    T findById(PK id);

    void save(T t);

    void update(T t);

    void delete(PK id);

    void deleteByIds(PK[] ids);

    <T> List<T> search(T var1);
}
