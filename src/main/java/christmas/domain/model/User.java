package christmas.domain.model;

import static christmas.util.Parser.HYPHEN_DELIMITER;

import christmas.domain.wrapper.MenuCount;
import christmas.util.Parser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private final Map<String, Integer> orderMenu = new HashMap<>();
    private final MenuCount menuCount;

    private User(String menuCount, String menu) {
        this.menuCount = MenuCount.create(Integer.parseInt(menuCount));
        createOrderMenu(menu);
    }

    public static User create(String menuCount, String menu) {
        return new User(menuCount, menu);
    }

    private void createOrderMenu(String menu) {
        List<String> menus = Parser.stringToList(menu);
        menus.stream()
                .map(menuItems -> menuItems.split(HYPHEN_DELIMITER))
                .forEach(menuItem -> orderMenu.put(menuItem[0], Integer.parseInt(menuItem[1])));
    }

    public Map<String, Integer> getOrderMenu() {
        return orderMenu;
    }

    public MenuCount getMenuCount() {
        return menuCount;
    }
}
