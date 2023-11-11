package christmas.domain.model;

import christmas.domain.constant.MenuConstant;
import java.util.HashMap;
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
}
