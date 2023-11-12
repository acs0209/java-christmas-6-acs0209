package christmas.controller;

import christmas.controller.event.EventMainController;
import christmas.domain.dto.EventMainDto;
import christmas.domain.model.Menus;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.User;
import christmas.view.OutputView;

public class EventPlannerController {

    private final MenuController menuController;
    private final UserController userController;
    private final OriginalOrderController originalOrderController;
    private final EventMainController eventMainController;
    private final OutputView outputView;

    public EventPlannerController() {
        this.menuController = new MenuController();
        this.userController = new UserController();
        this.originalOrderController = new OriginalOrderController();
        this.eventMainController = new EventMainController();
        this.outputView = new OutputView();
    }

    public void run() {
        Menus menus = menuController.initMenus();
        User user = userController.getUser(menus);
        printOrderMenu(user);

        OriginalOrderAmount originalOrderAmount = originalOrderController.getOriginalOrderAmount(menus, user);
        printOriginalOrderAmount(originalOrderAmount);

        EventMainDto eventMainDto = EventMainDto.create(menus, user);
        isEventApplicableAmount(originalOrderAmount, eventMainDto);
    }

    private void printOrderMenu(User user) {
        outputView.printOrderMenu(user);
    }

    private void printOriginalOrderAmount(OriginalOrderAmount originalOrderAmount) {
        outputView.printOriginalOrderAmount(originalOrderAmount);
    }

    private void isEventApplicableAmount(OriginalOrderAmount originalOrderAmount, EventMainDto eventMainDto) {
        if (originalOrderAmount.getOrderAmount() < 10000) {
            outputView.printNoEventResult(originalOrderAmount.getOrderAmount());
            return;
        }

        eventMainController.run(originalOrderAmount, eventMainDto);
    }
}
