package christmas.validation.constant;

public enum CommonErrorConstant {
    NULL_ERROR("[ERROR] 값에 null이 들어올 수 없습니다."),
    EMPTY_ERROR("[ERROR] 값에 빈 값이 들어올 수 없습니다."),
    SPACE_ERROR("[ERROR] 값에 공백만 들어올 수 없습니다.");

    private final String message;

    CommonErrorConstant(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
