package com.adminOfficialWeb.demo.mapper;

import com.adminOfficialWeb.demo.dto.UserDTO;
import com.adminOfficialWeb.demo.entity.User;
import com.adminOfficialWeb.demo.mapper.Base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {RoleMapper.class})
public interface UserMapper extends BaseMapper<UserDTO,User> {
}
