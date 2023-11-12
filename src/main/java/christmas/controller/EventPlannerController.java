package christmas.controller;

import christmas.domain.model.Menus;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.User;
import christmas.view.OutputView;

public class EventPlannerController {

    private final MenuController menuController;
    private final UserController userController;
    private final OriginalOrderController originalOrderController;
    private final OutputView outputView;

    public EventPlannerController() {
        this.menuController = new MenuController();
        this.userController = new UserController();
        this.originalOrderController = new OriginalOrderController();
        this.outputView = new OutputView();
    }

    public void run() {
        Menus menus = menuController.initMenus();
        User user = userController.getUser(menus);
        printOrderMenu(user);

        OriginalOrderAmount originalOrderAmount = originalOrderController.getOriginalOrderAmount(menus, user);
        printOriginalOrderAmount(originalOrderAmount);
        isEventApplicableAmount(originalOrderAmount.getOrderAmount());
    }

    private void printOrderMenu(User user) {
        outputView.printOrderMenu(user);
    }

    private void printOriginalOrderAmount(OriginalOrderAmount originalOrderAmount) {
        outputView.printOriginalOrderAmount(originalOrderAmount);
    }

    private void isEventApplicableAmount(int originalOrderAmount) {
        if (originalOrderAmount < 10000) {
            outputView.printNoEventResult(originalOrderAmount);
            return;
        }
    }
}
