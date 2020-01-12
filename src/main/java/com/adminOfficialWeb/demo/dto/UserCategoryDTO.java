package com.adminOfficialWeb.demo.dto;

import com.adminOfficialWeb.demo.dto.base.BaseDTO;
import lombok.Data;

@Data
public class UserCategoryDTO extends BaseDTO {

    private UserDTO user;

    private CategoryDTO category;

    private boolean active;

}
