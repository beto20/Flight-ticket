package com.idat.vuelos.model.mapper;

import com.idat.vuelos.model.dto.FlightRequest;
import com.idat.vuelos.model.dto.PersonRequest;
import com.idat.vuelos.model.dto.PersonResponse;
import com.idat.vuelos.model.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper MAPPER = Mappers.getMapper(PersonMapper.class);
    PersonEntity toPersonEntity(PersonResponse response);
    PersonRequest toPersonRequest(FlightRequest.Person dto);
}
