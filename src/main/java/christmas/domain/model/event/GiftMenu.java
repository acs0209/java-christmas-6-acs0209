package christmas.domain.model.event;

import static christmas.domain.constant.event.GiftMenuConstant.CHAMPAGNE_GIFT;
import static christmas.domain.constant.event.GiftMenuConstant.GIFT_MENU_REQUIREMENT_AMOUNT;
import static christmas.domain.constant.event.GiftMenuConstant.NO_GIFT;

public class GiftMenu {

    private String giftMenu;

    private GiftMenu(int originalOrderAmount) {
        giftMenu = NO_GIFT.getMessage();
        isGiftMenuAvailable(originalOrderAmount);
    }

    public static GiftMenu create(int originalOrderAmount) {
        return new GiftMenu(originalOrderAmount);
    }

    private void isGiftMenuAvailable(int originalOrderAmount) {
        if (originalOrderAmount >= GIFT_MENU_REQUIREMENT_AMOUNT.getNumber()) {
            giftMenu = CHAMPAGNE_GIFT.getMessage();
        }
    }

    public String getGiftMenu() {
        return giftMenu;
    }
}
