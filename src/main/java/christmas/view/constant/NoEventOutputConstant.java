package christmas.view.constant;

public enum NoEventOutputConstant {
    GIFT_MENU("<증정 메뉴>", "없음"),
    BENEFIT_DETAILS("<혜택 내역>", "없음"),
    TOTAL_BENEFIT_AMOUNT("<총혜택 금액>", "0원"),
    EXPECTED_PAYMENT_AFTER_DISCOUNT("<할인 후 예상 결제 금액>", "%s원"),
    DECEMBER_EVENT_BADGE("<12월 이벤트 배지>", "없음");

    private final String eventName;
    private final String eventResult;

    NoEventOutputConstant(String eventName, String eventResult) {
        this.eventName = eventName;
        this.eventResult = eventResult;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventResult() {
        return eventResult;
    }
}
