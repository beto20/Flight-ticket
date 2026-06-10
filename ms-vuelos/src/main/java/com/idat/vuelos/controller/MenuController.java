package com.idat.vuelos.controller;

import com.idat.vuelos.model.dto.MenuRequest;
import com.idat.vuelos.model.dto.MenuResponse;
import com.idat.vuelos.service.MenuService;
import com.idat.vuelos.service.impl.MenuServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/menus")
@Tag(name = "API de Menus", description = "APIs que corresponden al contexto de menu de los vuelos")
@Server(url = "https://test.com", description = "servidor de pruebas")
public class MenuController {

    private static MenuService menuService;

    public MenuController(MenuServiceImpl menuServiceImpl) {
        menuService = menuServiceImpl;
    }

    @GetMapping
    @Operation(description = "Endpoint para listar todos los menus", method = "POST", hidden = true)
    public Iterable<MenuResponse> menus() {
        return menuService.getMenus();
    }

    @PostMapping("/register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found"),
            @ApiResponse(responseCode = "304", description = "Customer found"),
            @ApiResponse(responseCode = "204", description = "Customer "),
    }
    )
    @Operation(description = "Endpoint para registros de menus", method = "POST", deprecated = false,
            responses = @ApiResponse(responseCode = "400", description = "Invalid ID supplied")
    )
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
