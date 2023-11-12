package christmas.domain.model;

public class OriginalOrderAmount {

    private final int orderAmount;

    private OriginalOrderAmount(Menus menus, User user) {
        this.orderAmount = createOriginalOrderAmount(menus, user);
    }

    public static OriginalOrderAmount create(Menus menus, User user) {
        return new OriginalOrderAmount(menus, user);
    }

    private int createOriginalOrderAmount(Menus menus, User user) {
        return user.getOrderMenu().entrySet().stream()
                .mapToInt(orderMenu -> menus.getMenus().get(orderMenu.getKey()).getPrice() * orderMenu.getValue())
                .sum();
    }

    public int getOrderAmount() {
        return orderAmount;
    }
}
