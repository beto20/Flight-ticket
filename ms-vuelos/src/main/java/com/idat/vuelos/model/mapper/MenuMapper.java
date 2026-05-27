package com.idat.vuelos.model.mapper;

import com.idat.vuelos.model.dto.MenuRequest;
import com.idat.vuelos.model.dto.MenuResponse;
import com.idat.vuelos.model.entity.MenuEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuMapper {
    MenuMapper MAPPER = Mappers.getMapper(MenuMapper.class);
    MenuResponse toMenuResponse(MenuEntity entity);
    MenuEntity toMenuEntity(MenuRequest request);
}
