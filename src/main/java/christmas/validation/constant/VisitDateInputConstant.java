package christmas.validation.constant;

public enum VisitDateInputConstant {
    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;

    VisitDateInputConstant(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
