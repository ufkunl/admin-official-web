package com.adminOfficialWeb.demo.dto;

import com.adminOfficialWeb.demo.dto.base.BaseDTO;
import lombok.Data;

@Data
public class CategoryDTO extends BaseDTO {

    private String name;

    private boolean active;

}
