package com.adminOfficialWeb.demo.service.base;

import com.adminOfficialWeb.demo.dto.base.BaseDTO;

public interface UserService<T extends BaseDTO,ID> extends BaseService<T,Long> {
}
