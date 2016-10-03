package com.fruit.pomegranate.converter;

import com.fruit.pomegranate.dto.ApplicationDTO;
import com.fruit.pomegranate.dto.MenuDTO;
import com.fruit.pomegranate.entity.Menu;
import org.springframework.beans.BeanUtils;

/**
 * Created by hanlei6 on 2016/9/30.
 */
public class MenuConverter {
    public static MenuDTO convertDTO(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        BeanUtils.copyProperties(menu, menu, "application", "menu", "menus");
        ApplicationDTO applicationDTO = new ApplicationDTO();
        BeanUtils.copyProperties(menu.getApplication(), applicationDTO, "menus");
        menuDTO.setApplication(applicationDTO);
        MenuDTO parent = new MenuDTO();
        BeanUtils.copyProperties(menu.getMenu(), parent, "application", "menu", "menus");
        menuDTO.setMenu(parent);
        return menuDTO;
    }

    public static Menu convertEntity(MenuDTO menuDTO) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDTO, menu, "menu", "application", "menus");
        return menu;
    }
}
