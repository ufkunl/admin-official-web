package com.adminOfficialWeb.demo.mapper;

import com.adminOfficialWeb.demo.dto.UserCategoryDTO;
import com.adminOfficialWeb.demo.entity.UserCategory;
import com.adminOfficialWeb.demo.mapper.Base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {UserMapper.class,CategoryMapper.class})
public interface UserCategoryMapper extends BaseMapper<UserCategoryDTO, UserCategory> {
}
