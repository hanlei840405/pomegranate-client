package com.fruit.pomegranate.service.client;

import com.fruit.pomegranate.converter.MenuConverter;
import com.fruit.pomegranate.dto.MenuDTO;
import com.fruit.pomegranate.entity.Menu;
import com.fruit.pomegranate.manager.MenuManager;
import com.fruit.pomegranate.service.api.MenuRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlei6 on 2016/10/4.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuRemoteService {
    @Autowired
    private MenuManager menuManager;

    @Override
    public MenuDTO get(String id) {
        return MenuConverter.convertDTO(menuManager.get(id));
    }

    @Override
    public MenuDTO findByCode(String code) {
        return MenuConverter.convertDTO(menuManager.findByCode(code));
    }

    @Override
    public List<MenuDTO> findByLevel(int level) {
        List<Menu> menus = menuManager.findByLevel(level);
        List<MenuDTO> dtos = new ArrayList<>();
        menus.forEach(menu -> dtos.add(MenuConverter.convertDTO(menu)));
        return dtos;
    }

    @Override
    public MenuDTO save(MenuDTO menu) {
        return MenuConverter.convertDTO(menuManager.save(MenuConverter.convertEntity(menu)));
    }
}
