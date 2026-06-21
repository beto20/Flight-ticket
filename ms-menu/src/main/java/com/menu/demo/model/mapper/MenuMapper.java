package com.menu.demo.model.mapper;

import com.menu.demo.model.dto.MenuRequest;
import com.menu.demo.model.dto.MenuResponse;
import com.menu.demo.model.entity.MenuEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuMapper {
    MenuMapper MAPPER = Mappers.getMapper(MenuMapper.class);
    MenuResponse toMenuResponse(MenuEntity entity);
    MenuEntity toMenuEntity(MenuRequest request);
}
