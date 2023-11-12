package christmas.view;

import christmas.domain.model.event.GiftMenu;

public class EventOutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printGiftMenu(GiftMenu giftMenu) {
        StringBuilder giftMenuResult = new StringBuilder();
        createGiftMenuResult(giftMenuResult, giftMenu);
        System.out.println(giftMenuResult);
    }

    private void createGiftMenuResult(StringBuilder giftMenuResult, GiftMenu giftMenu) {
        giftMenuResult.append(giftMenu.getGiftMenu());
    }
}
