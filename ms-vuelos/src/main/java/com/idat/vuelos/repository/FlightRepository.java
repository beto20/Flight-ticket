package com.idat.vuelos.repository;

import com.idat.vuelos.model.entity.FlightEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<FlightEntity, Integer> {
}
