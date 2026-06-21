package com.menu.demo.repository;

import com.menu.demo.model.entity.MenuEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<MenuEntity, Integer> {
}
