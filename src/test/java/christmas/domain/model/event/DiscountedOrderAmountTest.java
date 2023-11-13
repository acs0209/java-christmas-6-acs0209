package christmas.domain.model.event;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import christmas.domain.dto.EventPlanDto;
import christmas.domain.model.Menus;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DiscountedOrderAmountTest {

    @Nested
    @DisplayName("할인 후 예상 결제 금액 생성 기능 테스트")
    class testExpectedPaymentAfterDiscount {

        private final Menus menus = Menus.init();

        private void testDiscountedOrderAmount(String visitDate, String menu, int expectedDiscountedOrderAmount) {
            User user = User.create(visitDate, menu);
            OriginalOrderAmount originalOrderAmount = OriginalOrderAmount.create(menus, user);
            EventPlanDto eventPlanDto = EventPlanDto.create(menus, user);

            BenefitDetails benefitDetails = BenefitDetails.create();
            benefitDetails.createEventPlan(originalOrderAmount, eventPlanDto);

            DiscountedOrderAmount discountedOrderAmount = DiscountedOrderAmount.create(originalOrderAmount, benefitDetails);

            assertAll(
                    () -> assertThat(discountedOrderAmount.getDiscountedOrderAmount()).isEqualTo(expectedDiscountedOrderAmount),
                    () -> assertThat(discountedOrderAmount.getDiscountedOrderAmount()).isEqualTo(expectedDiscountedOrderAmount)
            );
        }

        @Test
        @DisplayName("여러 할인 혜택을 받은 후 예상 결제 금액 생성 테스트")
        void testExpectedPaymentAfterMultipleDiscounts() {
            testDiscountedOrderAmount("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1", 135754);
        }

        @Test
        @DisplayName("아무 할인 혜택도 받지 못한 후 예상 결제 금액 생성 테스트")
        void testExpectedPaymentNoDiscountApplied() {
            testDiscountedOrderAmount("26", "타파스-1,제로콜라-1", 8500);
        }
    }
}