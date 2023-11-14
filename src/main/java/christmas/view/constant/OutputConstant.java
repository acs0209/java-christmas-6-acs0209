package christmas.view.constant;

public enum OutputConstant {
    PREVIEW_EVENT_BENEFITS("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_START("<주문 메뉴>"),
    ORDER_MENU("%s %d개"),
    PRE_DISCOUNT_ORDER("<할인 전 총주문 금액>\r\n%s"),
    COLON(": "),
    DASH("-"),
    WON("원"),
    NEW_LINE("\r\n");

    private final String message;

    OutputConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
