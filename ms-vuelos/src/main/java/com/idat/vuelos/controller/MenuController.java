package com.idat.vuelos.controller;

import com.idat.vuelos.model.dto.MenuRequest;
import com.idat.vuelos.model.dto.MenuResponse;
import com.idat.vuelos.service.MenuService;
import com.idat.vuelos.service.impl.MenuServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/menus")
public class MenuController {

    private static MenuService menuService;

    public MenuController(MenuServiceImpl menuServiceImpl) {
        menuService = menuServiceImpl;
    }

    @GetMapping
    public Iterable<MenuResponse> menus() {
        return menuService.getMenus();
    }

    @PostMapping("/register")
    public void register(@RequestBody MenuRequest menuRequest) {
        menuService.registerMenu(menuRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody MenuRequest menuRequest) {
        menuService.updateMenu(menuRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable("id") int id) {
        menuService.removeMenu(id);
    }

}
