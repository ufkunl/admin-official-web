package com.adminOfficialWeb.demo.mapper.Base;

import com.adminOfficialWeb.demo.dto.base.BaseDTO;
import com.adminOfficialWeb.demo.entity.Base.BaseEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;

public interface BaseMapper<dto extends BaseDTO,entity extends BaseEntity> {

    @Named("toEntity")
    entity toEntity(dto dto);

    @Named("toDTO")
    dto toDTO(entity entity);

    @IterableMapping(qualifiedByName = "toEntity")
    List<entity> toEntityList(List<dto> dtoList);

    @IterableMapping(qualifiedByName = "toDTO")
    List<dto> toDTOList(List<entity> entityList);

}
