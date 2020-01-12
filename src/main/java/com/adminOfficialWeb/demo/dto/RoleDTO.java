package com.adminOfficialWeb.demo.dto;

import com.adminOfficialWeb.demo.dto.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleDTO extends BaseDTO {

    private String name;

    private boolean active;
}
