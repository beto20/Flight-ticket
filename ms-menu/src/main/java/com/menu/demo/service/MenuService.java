package com.menu.demo.service;

import com.menu.demo.model.dto.MenuRequest;
import com.menu.demo.model.dto.MenuResponse;


public interface MenuService {

    void registerMenu(MenuRequest menuRequest);
    Iterable<MenuResponse> getMenus();
    void updateMenu(MenuRequest menuRequest);
    void removeMenu(int id);

}
