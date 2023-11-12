package christmas.controller.event;

import static christmas.view.constant.EventConstant.GIFT_MENU;

import christmas.domain.dto.EventPlanDto;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.event.GiftMenu;
import christmas.view.EventOutputView;

public class EventMainController {

    private final EventOutputView eventOutputView;
    private final GiftMenuController giftMenuController;
    private final BenefitDetailsController benefitDetailsController;

    public EventMainController() {
        this.eventOutputView = new EventOutputView();
        this.giftMenuController = new GiftMenuController();
        this.benefitDetailsController = new BenefitDetailsController();
    }

    public void run(OriginalOrderAmount originalOrderAmount, EventPlanDto eventPlanDto) {
        GiftMenu giftMenu = giftMenuController.getGiftMenu(originalOrderAmount.getOrderAmount());
        printGiftMenu(giftMenu);
        benefitDetailsController.getBenefitDetails(originalOrderAmount, eventPlanDto);
    }

    private void printGiftMenu(GiftMenu giftMenu) {
        EventOutputView.printMessage(GIFT_MENU.getMessage());
        eventOutputView.printGiftMenu(giftMenu);
    }
}
