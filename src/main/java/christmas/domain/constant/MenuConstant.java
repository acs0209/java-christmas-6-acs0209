package christmas.domain.constant;

import christmas.domain.model.Menu;
import java.util.Map;

public enum MenuConstant {
    MUSHROOM_SOUP("양송이수프","애피타이저",  6000),
    TAPAS("타파스","애피타이저", 5500),
    CAESAR_SALAD("시저샐러드","애피타이저", 8000),
    T_BONE_STEAK("티본스테이크","메인",  55000),
    BBQ_RIBS("바비큐립","메인",  54000),
    SEAFOOD_PASTA("해산물파스타","메인",  35000),
    CHRISTMAS_PASTA("크리스마스파스타","메인",  25000),
    CHOCOLATE_CAKE("초코케이크","디저트",  15000),
    ICE_CREAM("아이스크림","디저트",  5000),
    ZERO_COLA("제로콜라","음료",  3000),
    RED_WINE("레드와인","음료",  60000),
    CHAMPAGNE("샴페인","음료",  25000);

    private final String name;
    private final String category;
    private final int price;

    MenuConstant(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public static void getMenus(Map<String, Menu> menus) {
        for (MenuConstant menu : MenuConstant.values()) {
            menus.put(menu.getName(), Menu.create(menu.getCategory(), menu.getPrice()));
        }
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
}
