package christmas.controller;

import christmas.domain.model.Menus;

public class EventPlannerController {

    private final MenuController menuController;
    private final UserController userController;

    public EventPlannerController() {
        this.menuController = new MenuController();
        this.userController = new UserController();
    }

    public void run() {
        Menus menus = menuController.initMenus();
        userController.getUser(menus);
    }
}
