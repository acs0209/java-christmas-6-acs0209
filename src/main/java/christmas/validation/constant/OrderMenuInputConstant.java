package christmas.validation.constant;

public enum OrderMenuInputConstant {
    INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_TOTAL_QUANTITY("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
    ONLY_BEVERAGE_ORDER("[ERROR] 음료만 주문 시, 주문할 수 없습니다."),
    DELIMITER("-");

    private final String message;

    OrderMenuInputConstant(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
