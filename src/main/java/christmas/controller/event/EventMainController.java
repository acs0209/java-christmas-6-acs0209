package christmas.controller.event;

import static christmas.view.constant.EventConstant.GIFT_MENU;

import christmas.domain.dto.EventMainDto;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.event.GiftMenu;
import christmas.view.EventOutputView;

public class EventMainController {

    private final EventOutputView eventOutputView;
    private final GiftMenuController giftMenuController;

    public EventMainController() {
        this.eventOutputView = new EventOutputView();
        this.giftMenuController = new GiftMenuController();
    }

    public void run(OriginalOrderAmount originalOrderAmount, EventMainDto eventMainDto) {
        GiftMenu giftMenu = giftMenuController.getGiftMenu(originalOrderAmount.getOrderAmount());
        printGiftMenu(giftMenu);

    }

    private void printGiftMenu(GiftMenu giftMenu) {
        EventOutputView.printMessage(GIFT_MENU.getMessage());
        eventOutputView.printGiftMenu(giftMenu);
    }
}
