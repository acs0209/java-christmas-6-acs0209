package christmas.view.constant;

public enum EventOutputConstant {

    GIFT_MENU("<증정 메뉴>"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
    EXPECTED_PAYMENT_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    DECEMBER_EVENT_BADGE("<12월 이벤트 배지>"),
    NO_EVENT("없음", 0);

    private final String message;
    private int number;

    EventOutputConstant(String message) {
        this.message = message;
    }

    EventOutputConstant(String message, int number) {
        this.message = message;
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }
}
