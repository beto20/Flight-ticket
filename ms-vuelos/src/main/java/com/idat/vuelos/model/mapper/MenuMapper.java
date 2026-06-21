package com.idat.vuelos.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuMapper {
    MenuMapper MAPPER = Mappers.getMapper(MenuMapper.class);
}
