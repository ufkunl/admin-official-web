package com.adminOfficialWeb.demo.mapper;

import com.adminOfficialWeb.demo.dto.CategoryDTO;
import com.adminOfficialWeb.demo.entity.Category;
import com.adminOfficialWeb.demo.mapper.Base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<CategoryDTO,Category> {
}
