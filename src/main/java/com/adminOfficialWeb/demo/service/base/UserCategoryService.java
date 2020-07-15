package com.adminOfficialWeb.demo.service.base;

import com.adminOfficialWeb.demo.dto.UserCategoryDTO;
import com.adminOfficialWeb.demo.dto.base.BaseDTO;

import java.util.List;

public interface UserCategoryService<T extends BaseDTO,ID> extends BaseService<T,Long> {

    List<UserCategoryDTO> getActiveCategoryByUserKey(String key);

}
