package christmas.view;

import static christmas.view.constant.EventConstant.COLON;
import static christmas.view.constant.EventConstant.DASH;
import static christmas.view.constant.EventConstant.NEW_LINE;
import static christmas.view.constant.EventConstant.NO_EVENT;
import static christmas.view.constant.EventConstant.WON;
import static christmas.view.constant.PrintFormat.SEPARATOR_FORMAT;

import christmas.domain.model.event.BenefitDetails;
import christmas.domain.model.event.DiscountedOrderAmount;
import christmas.domain.model.event.EventBadge;
import christmas.domain.model.event.GiftMenu;
import java.text.DecimalFormat;
import java.util.Map;

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
        giftMenuResult.append(giftMenu.getGiftMenu())
                .append(NEW_LINE.getMessage());
    }

    public void printBenefitDetails(BenefitDetails benefitDetails) {
        StringBuilder benefitDetailsResult = new StringBuilder();
        if (hasNoEvents(benefitDetails.getTotalBenefitAmount())) {
            benefitDetailsResult.append(NO_EVENT.getMessage()).append(NEW_LINE.getMessage());
            System.out.println(benefitDetailsResult);
            return;
        }

        createBenefitDetailsResult(benefitDetailsResult, benefitDetails);
        System.out.println(benefitDetailsResult);
    }

    private void createBenefitDetailsResult(StringBuilder benefitDetailsResult, BenefitDetails benefitDetails) {
        DecimalFormat seperatedFormat = SEPARATOR_FORMAT.getFormat();
        Map<String, Integer> printBenefitDetails = benefitDetails.getBenefitDetails();

        printBenefitDetails.entrySet()
                .stream()
                .filter(benefitDetail -> benefitDetail.getValue() != 0)
                .forEach(benefitDetail -> benefitDetailsResult.append(benefitDetail.getKey())
                        .append(COLON.getMessage())
                        .append(DASH.getMessage())
                        .append(seperatedFormat.format(benefitDetail.getValue()))
                        .append(WON.getMessage())
                        .append(NEW_LINE.getMessage()));
    }

    private boolean hasNoEvents(int totalBenefitAmount) {
        return totalBenefitAmount == 0;
    }

    public void printTotalBenefitAmount(int totalBenefitAmount) {
        StringBuilder totalBenefitAmountResult = new StringBuilder();
        createTotalBenefitAmountResult(totalBenefitAmountResult, totalBenefitAmount);
        System.out.println(totalBenefitAmountResult);
    }

    private void createTotalBenefitAmountResult(StringBuilder totalBenefitAmountResult, int totalBenefitAmount) {
        DecimalFormat seperatedFormat = SEPARATOR_FORMAT.getFormat();
        if (totalBenefitAmount == 0) {
            totalBenefitAmountResult.append(seperatedFormat.format(totalBenefitAmount))
                    .append(WON.getMessage())
                    .append(NEW_LINE.getMessage());
            return;
        }

        totalBenefitAmountResult.append(DASH.getMessage())
                .append(seperatedFormat.format(totalBenefitAmount))
                .append(WON.getMessage())
                .append(NEW_LINE.getMessage());
    }

    public void printDiscountedOrderAmount(DiscountedOrderAmount discountedOrderAmount) {
        StringBuilder discountedOrderAmountResult = new StringBuilder();
        createDiscountedOrderAmount(discountedOrderAmountResult, discountedOrderAmount);
        System.out.println(discountedOrderAmountResult);
    }

    private void createDiscountedOrderAmount(StringBuilder discountedOrderAmountResult, DiscountedOrderAmount discountedOrderAmount) {
        DecimalFormat seperatedFormat = SEPARATOR_FORMAT.getFormat();
        discountedOrderAmountResult.append(seperatedFormat.format(discountedOrderAmount.getDiscountedOrderAmount()))
                .append(WON.getMessage())
                .append(NEW_LINE.getMessage());
    }

    public void printEventBadge(EventBadge eventBadge) {
        StringBuilder eventBadgeResult = new StringBuilder();
        createEventBadge(eventBadgeResult, eventBadge);
        System.out.println(eventBadgeResult);
    }

    private void createEventBadge(StringBuilder eventBadgeResult, EventBadge eventBadge) {
        eventBadgeResult.append(eventBadge.getEventBadge());
    }
}
