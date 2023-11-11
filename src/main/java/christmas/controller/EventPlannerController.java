package christmas.controller;

import christmas.domain.model.Menus;

public class EventPlannerController {

    private final MenuController menuController;

    public EventPlannerController() {
        this.menuController = new MenuController();
    }

    public void run() {
        Menus menus = menuController.initMenus();
    }
}
