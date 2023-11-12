package christmas.controller.event;

import christmas.domain.model.event.GiftMenu;
import christmas.service.event.GiftMenuService;

public class GiftMenuController {

    private final GiftMenuService giftMenuService;

    public GiftMenuController() {
        this.giftMenuService = new GiftMenuService();
    }

    public GiftMenu getGiftMenu(int originalOrderAmount) {
        return giftMenuService.createGiftMenu(originalOrderAmount);
    }
}
