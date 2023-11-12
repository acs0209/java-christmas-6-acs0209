package christmas.view.constant;

public enum NoEventResultConstant {
    GIFT_MENU("\n<증정 메뉴>\n없음\n"),
    BENEFIT_DETAILS("\n<혜택 내역>\n없음\n"),
    TOTAL_BENEFIT_AMOUNT("\n<총혜택 금액>\n없음\n"),
    EXPECTED_PAYMENT_AFTER_DISCOUNT("\n<할인 후 예상 결제 금액>\n%s\n"),
    DECEMBER_EVENT_BADGE("\n<12월 이벤트 배지>\n없음");

    private final String message;

    NoEventResultConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
