package christmas.domain.model.event;

import static christmas.domain.constant.event.GiftMenuConstant.CHAMPAGNE_GIFT;
import static christmas.domain.constant.event.GiftMenuConstant.GIFT_MENU_REQUIREMENT_AMOUNT;
import static christmas.domain.constant.event.GiftMenuConstant.NO_GIFT;

public class GiftMenu {

    private final String giftMenu;

    private GiftMenu(int originalOrderAmount) {
        if (isGiftMenuAvailable(originalOrderAmount)) {
            giftMenu = CHAMPAGNE_GIFT.getMessage();
            return;
        }
        giftMenu = NO_GIFT.getMessage();
    }

    public static GiftMenu create(int originalOrderAmount) {
        return new GiftMenu(originalOrderAmount);
    }

    private boolean isGiftMenuAvailable(int originalOrderAmount) {
        return originalOrderAmount >= GIFT_MENU_REQUIREMENT_AMOUNT.getNumber();
    }

    public String getGiftMenu() {
        return giftMenu;
    }
}
