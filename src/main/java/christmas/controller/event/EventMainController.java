package christmas.controller.event;

import christmas.domain.dto.EventMainDto;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.event.GiftMenu;

public class EventMainController {

    private final GiftMenuController giftMenuController;

    public EventMainController() {
        giftMenuController = new GiftMenuController();
    }

    public void run(OriginalOrderAmount originalOrderAmount, EventMainDto eventMainDto) {
        GiftMenu giftMenu = giftMenuController.getGiftMenu(originalOrderAmount.getOrderAmount());
    }
}
