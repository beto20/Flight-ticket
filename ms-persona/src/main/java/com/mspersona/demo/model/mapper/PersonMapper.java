package com.mspersona.demo.model.mapper;

import com.mspersona.demo.model.dto.PersonResponse;
import com.mspersona.demo.model.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper MAPPER = Mappers.getMapper(PersonMapper.class);
    PersonResponse toPersonResponse(PersonEntity entity);
}
