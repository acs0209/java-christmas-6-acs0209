package christmas.view;

import static christmas.view.constant.OutputConstant.ORDER_MENU;
import static christmas.view.constant.OutputConstant.ORDER_START;
import static christmas.view.constant.OutputConstant.PREVIEW_EVENT_BENEFITS;
import static christmas.view.constant.OutputConstant.PRE_DISCOUNT_ORDER;
import static christmas.view.constant.PrintFormat.SEPARATOR_FORMAT;

import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.User;
import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printOrderMenu(User user) {
        StringBuilder orderMenuResult = new StringBuilder();
        createOrderMenuResult(orderMenuResult, user);
        System.out.println(orderMenuResult);
    }

    private void createOrderMenuResult(StringBuilder orderMenuResult, User user) {
        orderMenuResult.append(PREVIEW_EVENT_BENEFITS.getMessage())
                .append(ORDER_START.getMessage());
        Map<String, Integer> orderMenus = user.getOrderMenu();
        orderMenus.forEach((name, count) -> orderMenuResult.append(String.format(ORDER_MENU.getMessage(), name, count)));
    }

    public void printOriginalOrderAmount(OriginalOrderAmount originalOrderAmount) {
        StringBuilder originalOrderResult = new StringBuilder();
        createOriginalOrderResult(originalOrderResult, originalOrderAmount);
        System.out.println(originalOrderResult);
    }

    private void createOriginalOrderResult(StringBuilder originalOrderResult, OriginalOrderAmount originalOrderAmount) {
        DecimalFormat seperatedFormat = SEPARATOR_FORMAT.getFormat();
        String decimalTypeFormattedOrderAmount = seperatedFormat.format(originalOrderAmount.getOrderAmount());
        originalOrderResult.append(
                String.format(PRE_DISCOUNT_ORDER.getMessage(), decimalTypeFormattedOrderAmount));
    }
}
