package christmas.validation;

import static christmas.validation.constant.VisitDateInputConstant.INVALID_DATE;

import java.util.regex.Pattern;

public class VisitDateInputValidator {

    public void validateInputDate(String input) {
        if (isNotValidDate(input)) {
            throw new IllegalArgumentException(INVALID_DATE.getMessage());
        }
    }

    private boolean isNotValidDate(String input) {
        String regex = "^(?:[1-9]|1\\d|2[0-9]|3[0-1])$";
        return !Pattern.matches(regex, input);
    }
}
