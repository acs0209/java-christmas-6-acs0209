package christmas.domain.model;

import static christmas.validation.constant.OrderMenuInputConstant.DELIMITER;
import static christmas.validation.constant.OrderMenuInputConstant.INVALID_ORDER;

import christmas.domain.constant.MenuConstant;
import christmas.util.Parser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menus {

    private final Map<String, Menu> menus = new HashMap<>();

    private Menus() {
        MenuConstant.getMenus(menus);
    }

    public static Menus init() {
        return new Menus();
    }

    public Map<String, Menu> getMenus() {
        return menus;
    }

    public void validateMenuExist(String input) {
        List<String> menus = Parser.stringToList(input);
        menus.stream()
                .map(menuItem -> menuItem.split(DELIMITER.getMessage()))
                .forEach(menu -> isValidMenuExist(menu[0]));
    }

    private void isValidMenuExist(String category) {
        if (!menus.containsKey(category)) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }
}
