package christmas.validation;

import static christmas.validation.constant.VisitDateInputConstant.INVALID_DATE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDateInputValidatorTest {

    @Nested
    @DisplayName("식당 예상 방문 날짜 입력의 유효한 값과 유효하지 않은 값을 테스트 한다.")
    class testValidateInputDate {
        @ParameterizedTest
        @ValueSource(strings = {"0", "32", "123", "-1", "abc", "1a", "거북이", "e", "23 3", " 5 "})
        @DisplayName("입력값이 1 이상 31 이하의 숫자가 아닌 경우 예외가 발생해야 하는 테스트")
        void testInvalidNumberException(String input) {
            VisitDateInputValidator inputValidation = new VisitDateInputValidator();

            assertThatThrownBy(() -> inputValidation.validateInputDate(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_DATE.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "26", "31"})
        @DisplayName("입력값이 1 이상 31 이하의 숫자면 예외가 발생하지 않아야 하는 테스트")
        void testValidNumberNoException(String input) {
            VisitDateInputValidator inputValidation = new VisitDateInputValidator();

            assertThatCode(() -> inputValidation.validateInputDate(input))
                    .doesNotThrowAnyException();
        }
    }
}