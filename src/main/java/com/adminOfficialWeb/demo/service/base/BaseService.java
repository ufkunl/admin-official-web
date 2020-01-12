package com.adminOfficialWeb.demo.service.base;

import com.adminOfficialWeb.demo.dto.base.BaseDTO;

import java.util.List;

public interface  BaseService<T extends BaseDTO, ID> {

    T create(T dto);

    T update(T dto);

    T findById(ID id);

    List<T> getByActive();

    boolean deleteById(ID id);

    List<T> findAll();

}
