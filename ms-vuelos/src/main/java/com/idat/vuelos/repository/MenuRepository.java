package com.idat.vuelos.repository;

import com.idat.vuelos.model.entity.MenuEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<MenuEntity, Integer> {
}
