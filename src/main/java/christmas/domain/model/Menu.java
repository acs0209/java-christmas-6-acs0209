package christmas.domain.model;

public class Menu {

    private final String category;
    private final int price;

    private Menu(String category, int price) {
        this.category = category;
        this.price = price;
    }

    public static Menu create(String category, int price) {
        return new Menu(category, price);
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
}
