package com.idat.vuelos.service;

import com.idat.vuelos.model.dto.MenuRequest;
import com.idat.vuelos.model.dto.MenuResponse;


public interface MenuService {

    void registerMenu(MenuRequest menuRequest);
    Iterable<MenuResponse> getMenus();
    void updateMenu(MenuRequest menuRequest);
    void removeMenu(int id);

}
