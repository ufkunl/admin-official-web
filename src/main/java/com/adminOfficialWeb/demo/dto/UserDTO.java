package com.adminOfficialWeb.demo.dto;

import com.adminOfficialWeb.demo.dto.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends BaseDTO {

    private String name;

    private String surname;

    private String email;

    private String password;

    private String userKey;

    private boolean active;

    private String cvContent;

    private String cvUrl;
}
