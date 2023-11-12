package christmas.domain.constant.event;

public enum GiftMenuConstant {
    NO_GIFT("없음"),
    CHAMPAGNE_GIFT("샴페인 1개"),
    GIFT_MENU_REQUIREMENT_AMOUNT(120000);

    private String message;
    private int number;

    GiftMenuConstant(String message) {
        this.message = message;
    }

    GiftMenuConstant(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }
}
