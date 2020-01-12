package com.adminOfficialWeb.demo.mapper;

import com.adminOfficialWeb.demo.dto.RoleDTO;
import com.adminOfficialWeb.demo.entity.Role;
import com.adminOfficialWeb.demo.mapper.Base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<RoleDTO, Role> {
}
