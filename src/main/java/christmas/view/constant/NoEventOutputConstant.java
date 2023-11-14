package christmas.view.constant;

public enum NoEventOutputConstant {
    GIFT_MENU("<증정 메뉴>\n없음"),
    BENEFIT_DETAILS("<혜택 내역>\n없음"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>\n0원"),
    EXPECTED_PAYMENT_AFTER_DISCOUNT("<할인 후 예상 결제 금액>\n%s원"),
    DECEMBER_EVENT_BADGE("<12월 이벤트 배지>\n없음");

    private final String message;

    NoEventOutputConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
