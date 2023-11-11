package christmas.controller;

import christmas.domain.model.Menus;

public class ChristmasMainController {

    private final MenuController menuController;

    public ChristmasMainController() {
        this.menuController = new MenuController();
    }

    public void run() {
        Menus menus = menuController.initMenus();
    }
}
