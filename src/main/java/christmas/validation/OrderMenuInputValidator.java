package christmas.validation;

import static christmas.validation.constant.OrderMenuInputConstant.DELIMITER;
import static christmas.validation.constant.OrderMenuInputConstant.INVALID_ORDER;
import static christmas.validation.constant.OrderMenuInputConstant.INVALID_TOTAL_QUANTITY;
import static christmas.validation.constant.OrderMenuInputConstant.ONLY_BEVERAGE_ORDER;

import christmas.util.Parser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderMenuInputValidator {

    private final List<String> BEVERAGE_ITEMS = Arrays.asList("제로콜라", "레드와인", "샴페인");

    public void validateInputFormat(String input) {
        if (isNotValidInputFormat(input)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private boolean isNotValidInputFormat(String input) {
        return !input.matches("([\\w가-힣]+-\\d+,)*[\\w가-힣]+-\\d+");
    }

    public void validateMenuDuplication(String input) {
        List<String> menus = Parser.stringToList(input);
        List<String> menuNames = new ArrayList<>();
        Parser.extractMenuNamesFromMenus(menus, menuNames);

        Set<String> distinctMenuNames = new HashSet<>(menuNames);
        if (distinctMenuNames.size() < menuNames.size()) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    public void validateMenuQuantity(String input) {
        List<String> menus = Parser.stringToList(input);
        menus.stream()
                .map(menuItem -> menuItem.split(DELIMITER.getMessage()))
                .allMatch(menu -> menu.length == 2 && isValidQuantity(menu[1]));
    }

    private boolean isValidQuantity(String quantity) {
        int menuQuantity = Integer.parseInt(quantity);
        if (menuQuantity < 1) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
        return true;
    }

    public void validateTotalMenuQuantity(String input) {
        List<String> menus = Parser.stringToList(input);

        int totalQuantity = menus.stream()
                .map(menuItem -> menuItem.split(DELIMITER.getMessage()))
                .mapToInt(menu -> Integer.parseInt(menu[1]))
                .sum();

        isValidTotalMenuQuantity(totalQuantity);
    }

    private void isValidTotalMenuQuantity(int totalQuantity) {
        if (totalQuantity > 20) {
            throw new IllegalArgumentException(INVALID_TOTAL_QUANTITY.getMessage());
        }
    }

    public void validateOrder(String input) {
        if (isOnlyBeverageOrder(input)) {
            throw new IllegalArgumentException(ONLY_BEVERAGE_ORDER.getMessage());
        }
    }

    private boolean isOnlyBeverageOrder(String input) {
        List<String> menus = Parser.stringToList(input);
        return menus.stream()
                .map(menu -> menu.split(DELIMITER.getMessage())[0].trim())
                .allMatch(BEVERAGE_ITEMS::contains);
    }

    public void validateMenuInput(String input) {
        validateInputFormat(input);
        validateMenuDuplication(input);
        validateMenuQuantity(input);
        validateTotalMenuQuantity(input);
        validateOrder(input);
    }
}
