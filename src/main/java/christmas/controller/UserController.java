package christmas.controller;

import static christmas.view.constant.InputConstant.GET_MENU;
import static christmas.view.constant.InputConstant.DECEMBER_EVENT_PLANNER;
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

    private String readDate() {
        OutputView.printMessage(DECEMBER_EVENT_PLANNER.getMessage());
        OutputView.printMessage(GET_VISIT_DATE.getMessage());
        return inputView.readDate();
    }

    private String readMenu(Menus menus) {
        OutputView.printMessage(GET_MENU.getMessage());
        return inputView.readMenu(menus);
    }
}
