package christmas.controller.event;

import static christmas.view.constant.EventConstant.BENEFIT_DETAILS;
import static christmas.view.constant.EventConstant.DECEMBER_EVENT_BADGE;
import static christmas.view.constant.EventConstant.EXPECTED_PAYMENT_AFTER_DISCOUNT;
import static christmas.view.constant.EventConstant.GIFT_MENU;
import static christmas.view.constant.EventConstant.TOTAL_BENEFIT_AMOUNT;

import christmas.domain.dto.EventPlanDto;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.event.BenefitDetails;
import christmas.domain.model.event.DiscountedOrderAmount;
import christmas.domain.model.event.EventBadge;
import christmas.domain.model.event.GiftMenu;
import christmas.view.EventOutputView;

public class EventMainController {

    private final EventOutputView eventOutputView;
    private final GiftMenuController giftMenuController;
    private final BenefitDetailsController benefitDetailsController;
    private final DiscountedOrderController discountedOrderController;
    private final EventBadgeController eventBadgeController;

    public EventMainController() {
        this.eventOutputView = new EventOutputView();
        this.giftMenuController = new GiftMenuController();
        this.benefitDetailsController = new BenefitDetailsController();
        this.discountedOrderController = new DiscountedOrderController();
        this.eventBadgeController = new EventBadgeController();
    }

    public void run(OriginalOrderAmount originalOrderAmount, EventPlanDto eventPlanDto) {
        GiftMenu giftMenu = giftMenuController.getGiftMenu(originalOrderAmount.getOrderAmount());
        printGiftMenu(giftMenu);

        BenefitDetails benefitDetails = benefitDetailsController.getBenefitDetails(originalOrderAmount, eventPlanDto);
        printBenefitDetails(benefitDetails);
        printTotalBenefitAmount(benefitDetails.getTotalBenefitAmount());

        DiscountedOrderAmount discountedOrderAmount = discountedOrderController.getDiscountedOrderAmount(
                originalOrderAmount, benefitDetails);
        printDiscountedOrderAmount(discountedOrderAmount);

        EventBadge eventBadge = eventBadgeController.getEventBadge(benefitDetails);
        printEventBadge(eventBadge);
    }

    private void printGiftMenu(GiftMenu giftMenu) {
        EventOutputView.printMessage(GIFT_MENU.getMessage());
        eventOutputView.printGiftMenu(giftMenu);
    }

    private void printBenefitDetails(BenefitDetails benefitDetails) {
        EventOutputView.printMessage(BENEFIT_DETAILS.getMessage());
        eventOutputView.printBenefitDetails(benefitDetails);
    }

    private void printTotalBenefitAmount(int totalBenefitAmount) {
        EventOutputView.printMessage(TOTAL_BENEFIT_AMOUNT.getMessage());
        eventOutputView.printTotalBenefitAmount(totalBenefitAmount);
    }

    private void printDiscountedOrderAmount(DiscountedOrderAmount discountedOrderAmount) {
        EventOutputView.printMessage(EXPECTED_PAYMENT_AFTER_DISCOUNT.getMessage());
        eventOutputView.printDiscountedOrderAmount(discountedOrderAmount);
    }

    private void printEventBadge(EventBadge eventBadge) {
        EventOutputView.printMessage(DECEMBER_EVENT_BADGE.getMessage());
        eventOutputView.printEventBadge(eventBadge);
    }
}
