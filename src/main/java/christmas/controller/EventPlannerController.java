package christmas.controller;

import christmas.domain.model.Menus;
import christmas.domain.model.User;
import christmas.view.OutputView;

public class EventPlannerController {

    private final MenuController menuController;
    private final UserController userController;
    private final OutputView outputView;

    public EventPlannerController() {
        this.menuController = new MenuController();
        this.userController = new UserController();
        this.outputView = new OutputView();
    }

    public void run() {
        Menus menus = menuController.initMenus();
        User user = userController.getUser(menus);
        printOrderMenu(user);
    }

    private void printOrderMenu(User user) {
        outputView.printOrderMenu(user);
    }
}
