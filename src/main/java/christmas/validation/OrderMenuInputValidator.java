package christmas.validation;

import static christmas.validation.constant.OrderMenuInputConstant.DELIMITER;
import static christmas.validation.constant.OrderMenuInputConstant.INVALID_ORDER;
import static christmas.validation.constant.OrderMenuInputConstant.INVALID_TOTAL_QUANTITY;

import christmas.util.Parser;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderMenuInputValidator {

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
        Set<String> distinctMenus = new HashSet<>(menus);
        if (distinctMenus.size() < menus.size()) {
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

    public void validateMenuInput(String input) {
        validateInputFormat(input);
        validateMenuDuplication(input);
        validateMenuQuantity(input);
        validateTotalMenuQuantity(input);
    }
}
