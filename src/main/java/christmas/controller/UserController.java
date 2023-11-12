package christmas.controller;

import static christmas.view.constant.InputConstant.GET_MENU;
import static christmas.view.constant.InputConstant.GET_VISIT_DATE;

import christmas.domain.model.Menus;
import christmas.domain.model.User;
import christmas.service.UserService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class UserController {

    private final InputView inputView;
    private final UserService userService;

    public UserController() {
        this.inputView = new InputView();
        this.userService = new UserService();
    }

    public User getUser(Menus menus) {
        String date = readDate();
        String menu = readMenu(menus);
        return userService.createUser(date, menu);
    }

    public String readDate() {
        OutputView.printMessage(GET_VISIT_DATE.getMessage());
        return inputView.readDate();
    }

    public String readMenu(Menus menus) {
        OutputView.printMessage(GET_MENU.getMessage());
        return inputView.readMenu(menus);
    }
}
