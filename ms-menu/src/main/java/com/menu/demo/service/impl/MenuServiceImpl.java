package com.menu.demo.service.impl;

import com.menu.demo.model.dto.MenuRequest;
import com.menu.demo.model.dto.MenuResponse;
import com.menu.demo.model.mapper.MenuMapper;
import com.menu.demo.repository.MenuRepository;
import com.menu.demo.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MenuServiceImpl implements MenuService {

    private static MenuRepository repository;

    public MenuServiceImpl(MenuRepository repository) {
        this.repository = repository;
    }


    @Override
    public void registerMenu(MenuRequest menuRequest) {
        var entity = MenuMapper.MAPPER.toMenuEntity(menuRequest);
        repository.save(entity);
    }

    @Override
    public Iterable<MenuResponse> getMenus() {
        var menus = repository.findAll();
        var res = new ArrayList<MenuResponse>();
        menus.forEach(x -> {
            var menu = MenuMapper.MAPPER.toMenuResponse(x);
            res.add(menu);
        });

        return res;
    }

    @Override
    public void updateMenu(MenuRequest menuRequest) {
        var menu = repository.findById(menuRequest.getId());

        if (!menu.isPresent()) {
            throw new RuntimeException("Error menu no existe");
        }

        menu.get().setEntrada(menuRequest.getEntrada());
        menu.get().setFondo(menuRequest.getFondo());

        repository.save(menu.get());
    }

    @Override
    public void removeMenu(int id) {
        repository.deleteById(id);
    }
}
