package christmas.controller;

import christmas.domain.model.Menus;
import christmas.domain.model.User;

public class EventPlannerController {

    private final MenuController menuController;
    private final UserController userController;

    public EventPlannerController() {
        this.menuController = new MenuController();
        this.userController = new UserController();
    }

    public void run() {
        Menus menus = menuController.initMenus();
        User user = userController.getUser(menus);
    }
}
