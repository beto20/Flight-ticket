package com.idat.vuelos.client;


import com.idat.vuelos.model.dto.MenuResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "MenuClient", url = "http://localhost:8082/v1/menus")
public interface MenuClient {

    @GetMapping
    List<MenuResponse> getMenus();
}
