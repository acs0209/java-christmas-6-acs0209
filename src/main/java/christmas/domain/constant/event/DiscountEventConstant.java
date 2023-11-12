package christmas.domain.constant.event;

public enum DiscountEventConstant {
    CHRISTMAS_EVENT_START_DAY(1),
    CHRISTMAS_EVENT_LAST_DAY(25),
    START_VALUE(1000),
    CHRISTMAS_DISCOUNT_AMOUNT(100),
    FIRST_DAY(1),
    DAYS_IN_WEEK(7),
    WEEKEND_DAY_1(1),
    WEEKEND_DAY_2(2),
    DISCOUNT_AMOUNT(2023),
    SPECIAL_DISCOUNT_AMOUNT(1000),
    SPECIAL_DAY(3),
    CHRISTMAS_DAY(25),
    GIFT_EVENT_CHECK(120000),
    GIFT_EVENT_AMOUNT(25000),
    DESSERT("디저트"),
    MAIN("메인");

    private int number;
    private String message;

    DiscountEventConstant(int number) {
        this.number = number;
    }

    DiscountEventConstant(String message) {
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }
}
