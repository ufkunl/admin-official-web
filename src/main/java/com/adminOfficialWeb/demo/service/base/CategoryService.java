package com.adminOfficialWeb.demo.service.base;

import com.adminOfficialWeb.demo.entity.Base.BaseEntity;

import java.util.List;

public interface CategoryService<T extends BaseEntity,ID> {

    T create(T entity);

    T update(T entity);

    T findById(ID id);

    List<T> getByActive();

    boolean deleteById(ID id);

    List<T> findAll();

}
