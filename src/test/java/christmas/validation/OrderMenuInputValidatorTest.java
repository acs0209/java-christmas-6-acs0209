package christmas.validation;

import static christmas.validation.constant.OrderMenuInputConstant.INVALID_ORDER;
import static christmas.validation.constant.OrderMenuInputConstant.INVALID_TOTAL_QUANTITY;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderMenuInputValidatorTest {

    @Nested
    @DisplayName("사용자가 입력한 메뉴 형식에 대해 검증한다.")
    class testValidateInputFormat {

        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크1,바비큐립1치킨-4", "초코케이크-2제로콜라-1치킨-4",
                "티본스테이크 -1,바비큐립- 1", "초코케이크 - 2 ,  제로콜라-1",
                "티본스테이크,1,바비큐립,1", "초코케이크:2,제로콜라-1",
                "티본스테이크-1-바비큐립-1", "초코케이크-2,제로콜라-1,",
                "티본스테이크--1,바비큐립--1", "초코케이크-2,,제로콜라-1",
                "티본스테이크-e,바비큐립-1", "초코케이크-2,제로콜라-오",
                "티본스테이크-1,바비큐립-1,초코케이크-2,-1", "티본스테이크-1,제로콜라!@#$%^&*-1",
                "초코케이크-two,제로콜라-1", "2-초코케이크,1-제로콜라,티본스테이크-1",
                "초코케이크-,-,-1"})
        @DisplayName("메뉴 형식이 예시와 다른 경우 예외가 발생해야 하는 테스트")
        void testInvalidMenuFormatShouldThrowException(String input) {
            OrderMenuInputValidator inputValidation = new OrderMenuInputValidator();

            assertThatThrownBy(() -> inputValidation.validateInputFormat(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_ORDER.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1", "티본스테이크-1"})
        @DisplayName("메뉴 형식이 예시와 같은 경우 예외가 발생하지 않아야 하는 테스트")
        void testValidMenuFormatShouldNotThrowException(String input) {
            OrderMenuInputValidator inputValidation = new OrderMenuInputValidator();

            assertThatCode(() -> inputValidation.validateInputFormat(input))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("입력한 메뉴의 중복에 대해 검증한다.")
    class testValidateMenuDuplication {

        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크-1,바비큐립-1,바비큐립-1"})
        @DisplayName("중복 메뉴를 입력한 경우 예외가 발생해야 하는 테스트")
        void testInvalidDuplicateMenuException(String input) {
            OrderMenuInputValidator inputValidation = new OrderMenuInputValidator();

            assertThatThrownBy(() -> inputValidation.validateMenuDuplication(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_ORDER.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크-1,바비큐립-1,초코케이크-1"})
        @DisplayName("중복 메뉴를 입력 하지 않은 경우 예외가 발생하지 않아야 하는 테스트")
        void testValidDuplicateMenuException(String input) {
            OrderMenuInputValidator inputValidation = new OrderMenuInputValidator();

            assertThatCode(() -> inputValidation.validateMenuDuplication(input))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("입력한 메뉴의 개수에 대해 검증한다.")
    class testValidateMenuQuantities {

        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크-0,바비큐립-1,레드와인-0"})
        @DisplayName("입력한 메뉴의 개수가 1 이상의 숫자가 아니면 예외가 발생해야 하는 테스트")
        void testInvalidMenuCountException(String input) {
            OrderMenuInputValidator inputValidation = new OrderMenuInputValidator();

            assertThatThrownBy(() -> inputValidation.validateMenuQuantity(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_ORDER.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크-1,바비큐립-1,레드와인-2"})
        @DisplayName("입력한 메뉴의 개수가 1 이상의 숫자면 예외가 발생하지 않아야 하는 테스트")
        void testValidMenuCount(String input) {
            OrderMenuInputValidator inputValidation = new OrderMenuInputValidator();

            assertThatCode(() -> inputValidation.validateMenuQuantity(input))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("입력한 메뉴 개수 총합에 대해 검증한다.")
    class testValidateTotalMenuQuantity {

        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크-10,바비큐립-4,레드와인-5,시저샐러드-2", "티본스테이크-21"})
        @DisplayName("입력한 메뉴의 개수 총합이 20이 넘으면 예외가 발생해야 하는 테스트")
        void testTotalQuantityExceededException(String input) {
            OrderMenuInputValidator inputValidation = new OrderMenuInputValidator();

            assertThatThrownBy(() -> inputValidation.validateTotalMenuQuantity(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_TOTAL_QUANTITY.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크-6,바비큐립-4,레드와인-5,시저샐러드-5"})
        @DisplayName("입력한 메뉴의 개수 총합이 20이하면 예외가 발생하지 않아야 하는 테스트")
        void testValidTotalQuantity(String input) {
            OrderMenuInputValidator inputValidation = new OrderMenuInputValidator();

            assertThatCode(() -> inputValidation.validateTotalMenuQuantity(input))
                    .doesNotThrowAnyException();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-6,바비큐립-2,레드와인-1,시저샐러드-5"})
    @DisplayName("메뉴 입력에 대해 모든 검증을 하여 정상 입력이면 오류가 발생하지 않는 테스트")
    void testValidateMenuInput(String input) {
        OrderMenuInputValidator inputValidation = new OrderMenuInputValidator();

        assertThatCode(() -> inputValidation.validateMenuInput(input))
                .doesNotThrowAnyException();
    }
}