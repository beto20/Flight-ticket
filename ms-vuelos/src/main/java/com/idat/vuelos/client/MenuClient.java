package com.idat.vuelos.client;


import com.idat.vuelos.model.dto.MenuResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "MenuClient", url = "http://ec2-13-220-217-119.compute-1.amazonaws.com:8080/v1/menus")
public interface MenuClient {

    @GetMapping
    List<MenuResponse> getMenus();
}
