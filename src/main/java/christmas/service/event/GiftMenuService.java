package christmas.service.event;

import christmas.domain.model.event.GiftMenu;

public class GiftMenuService {

    public GiftMenu createGiftMenu(int originalOrderAmount) {
        return GiftMenu.create(originalOrderAmount);
    }
}
