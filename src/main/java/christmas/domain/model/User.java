package christmas.domain.model;

import static christmas.util.Parser.HYPHEN_DELIMITER;

import christmas.domain.wrapper.VisitDate;
import christmas.util.Parser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private final Map<String, Integer> orderMenu = new HashMap<>();
    private final VisitDate visitDate;

    private User(String date, String menu) {
        visitDate = VisitDate.create(Integer.parseInt(date));
        createOrderMenu(menu);
    }

    public static User create(String date, String menu) {
        return new User(date, menu);
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

    public VisitDate getVisitDate() {
        return visitDate;
    }
}
