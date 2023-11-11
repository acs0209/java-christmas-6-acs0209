package christmas.controller;

import christmas.domain.model.Menus;
import christmas.service.MenuService;

public class MenuController {

    private final MenuService menuService;

    public MenuController() {
        this.menuService = new MenuService();
    }

    public Menus initMenus() {
        return menuService.initMenus();
    }
}
