package christmas.view;

import static christmas.view.constant.NoEventOutputConstant.BENEFIT_DETAILS;
import static christmas.view.constant.NoEventOutputConstant.DECEMBER_EVENT_BADGE;
import static christmas.view.constant.NoEventOutputConstant.EXPECTED_PAYMENT_AFTER_DISCOUNT;
import static christmas.view.constant.NoEventOutputConstant.GIFT_MENU;
import static christmas.view.constant.NoEventOutputConstant.TOTAL_BENEFIT_AMOUNT;
import static christmas.view.constant.OutputConstant.ORDER_MENU;
import static christmas.view.constant.OutputConstant.ORDER_START;
import static christmas.view.constant.OutputConstant.PREVIEW_EVENT_BENEFITS;
import static christmas.view.constant.OutputConstant.PRE_DISCOUNT_ORDER;
import static christmas.view.constant.OutputConstant.WON;
import static christmas.view.constant.OutputConstant.NEW_LINE;
import static christmas.view.constant.PrintFormat.SEPARATOR_FORMAT;

import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.User;
import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private void printNoEventMessage(String eventName, String eventResult) {
        System.out.println(eventName);
        System.out.println(eventResult);
        System.out.println();
    }

    public void printOrderMenu(User user) {
        StringBuilder orderMenuResult = new StringBuilder();
        createOrderMenuResult(orderMenuResult, user);
        System.out.println(orderMenuResult);
    }

    private void createOrderMenuResult(StringBuilder orderMenuResult, User user) {
        orderMenuResult.append(String.format(PREVIEW_EVENT_BENEFITS.getMessage(), user.getVisitDate().getDate()))
                .append(NEW_LINE.getMessage()).append(NEW_LINE.getMessage())
                .append(ORDER_START.getMessage()).append(NEW_LINE.getMessage());
        Map<String, Integer> orderMenus = user.getOrderMenu();
        orderMenus.forEach((name, count) -> orderMenuResult.append(String.format(ORDER_MENU.getMessage(), name, count))
                .append(NEW_LINE.getMessage()));
    }

    public void printOriginalOrderAmount(OriginalOrderAmount originalOrderAmount) {
        StringBuilder originalOrderResult = new StringBuilder();
        createOriginalOrderResult(originalOrderResult, originalOrderAmount);
        System.out.println(originalOrderResult);
    }

    private void createOriginalOrderResult(StringBuilder originalOrderResult, OriginalOrderAmount originalOrderAmount) {
        DecimalFormat seperatedFormat = SEPARATOR_FORMAT.getFormat();
        String decimalTypeFormattedOrderAmount = seperatedFormat.format(originalOrderAmount.getOrderAmount());
        originalOrderResult.append(String.format(PRE_DISCOUNT_ORDER.getMessage(), decimalTypeFormattedOrderAmount))
                .append(WON.getMessage())
                .append(NEW_LINE.getMessage());
    }

    public void printNoEventResult(int originalOrderAmount) {
        DecimalFormat seperatedFormat = SEPARATOR_FORMAT.getFormat();
        String decimalTypeFormattedOrderAmount = seperatedFormat.format(originalOrderAmount);
        createNoEventResult(decimalTypeFormattedOrderAmount);
    }

    private void createNoEventResult(String decimalTypeFormattedOrderAmount) {
        printNoEventMessage(GIFT_MENU.getEventName(), GIFT_MENU.getEventResult());
        printNoEventMessage(BENEFIT_DETAILS.getEventName(), BENEFIT_DETAILS.getEventResult());
        printNoEventMessage(TOTAL_BENEFIT_AMOUNT.getEventName(), TOTAL_BENEFIT_AMOUNT.getEventResult());
        printNoEventMessage(EXPECTED_PAYMENT_AFTER_DISCOUNT.getEventName(),
                String.format(EXPECTED_PAYMENT_AFTER_DISCOUNT.getEventResult(), decimalTypeFormattedOrderAmount));
        printNoEventMessage(DECEMBER_EVENT_BADGE.getEventName(), DECEMBER_EVENT_BADGE.getEventResult());
    }
}
