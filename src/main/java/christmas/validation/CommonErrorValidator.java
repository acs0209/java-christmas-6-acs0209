package christmas.validation;

import static christmas.validation.constant.CommonErrorConstant.EMPTY_ERROR;
import static christmas.validation.constant.CommonErrorConstant.NULL_ERROR;
import static christmas.validation.constant.CommonErrorConstant.SPACE_ERROR;

public class CommonErrorValidator {
    public void validateInputNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_ERROR.getMessage());
        }
    }

    public void validateInputEmpty(String input) {
        if (isEmptyValue(input)) {
            throw new IllegalArgumentException(EMPTY_ERROR.getMessage());
        }
    }

    private boolean isEmptyValue(String input) {
        return input.isEmpty();
    }

    public void validateInputSpace(String input) {
        if (isWhitespaceOnly(input)) {
            throw new IllegalArgumentException(SPACE_ERROR.getMessage());
        }
    }

    private boolean isWhitespaceOnly(String input) {
        return input.trim().isEmpty();
    }

    public void validateCommonError(String input) {
        validateInputNull(input);
        validateInputEmpty(input);
        validateInputSpace(input);
    }
}
