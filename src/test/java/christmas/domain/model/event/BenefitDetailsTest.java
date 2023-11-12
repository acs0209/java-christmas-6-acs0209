package christmas.domain.model.event;

import static christmas.domain.constant.event.BenefitDetailsConstant.CHRISTMAS_DISCOUNT;
import static christmas.domain.constant.event.BenefitDetailsConstant.GIFT_EVENT;
import static christmas.domain.constant.event.BenefitDetailsConstant.SPECIAL_DISCOUNT;
import static christmas.domain.constant.event.BenefitDetailsConstant.WEEKDAY_DISCOUNT;
import static christmas.domain.constant.event.BenefitDetailsConstant.WEEKEND_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import christmas.domain.dto.EventPlanDto;
import christmas.domain.model.Menus;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BenefitDetailsTest {

    @Nested
    @DisplayName("이벤트 계획 생성 기능 테스트")
    class TestCreateEventPlan {

        private final Menus menus = Menus.init();

        private void testEventPlan(String visitDate, String menu, int expectedChristmas, int expectedWeekday,
                                   int expectedWeekend, int expectedSpecial, int expectedGift) {
            User user = User.create(visitDate, menu);
            OriginalOrderAmount originalOrderAmount = OriginalOrderAmount.create(menus, user);
            EventPlanDto eventPlanDto = EventPlanDto.create(menus, user);

            BenefitDetails benefitDetails = BenefitDetails.create();
            benefitDetails.createEventPlan(originalOrderAmount, eventPlanDto);

            assertAll(
                    () -> assertThat(benefitDetails.getBenefitDetails().get(CHRISTMAS_DISCOUNT.getMessage())).isEqualTo(expectedChristmas),
                    () -> assertThat(benefitDetails.getBenefitDetails().get(WEEKDAY_DISCOUNT.getMessage())).isEqualTo(expectedWeekday),
                    () -> assertThat(benefitDetails.getBenefitDetails().get(WEEKEND_DISCOUNT.getMessage())).isEqualTo(expectedWeekend),
                    () -> assertThat(benefitDetails.getBenefitDetails().get(SPECIAL_DISCOUNT.getMessage())).isEqualTo(expectedSpecial),
                    () -> assertThat(benefitDetails.getBenefitDetails().get(GIFT_EVENT.getMessage())).isEqualTo(expectedGift)
            );
        }

        @Test
        @DisplayName("각 이벤트의 할인 금액과 예상값이 일치하는지 테스트")
        void testDiscountAmountMatchExpectedAmountCase1() {
            testEventPlan("25", "티본스테이크-1,바비큐립-1,초코케이크-3,아이스크림-5,제로콜라-1", 3400, 16184, 0, 1000, 25000);
        }

        @Test
        @DisplayName("각 이벤트의 할인 금액과 예상값이 일치하는지 테스트")
        void testDiscountAmountMatchExpectedAmountCase2() {
            testEventPlan("30", "티본스테이크-2,바비큐립-2,해산물파스타-3,크리스마스파스타-4,초코케이크-2,제로콜라-1", 0, 0, 22253, 0, 25000);
        }

        @Test
        @DisplayName("각 이벤트의 할인 금액과 예상값이 일치하는지 테스트")
        void testDiscountAmountMatchExpectedAmountCase3() {
            testEventPlan("31", "해산물파스타-1,크리스마스파스타-1,초코케이크-2,아이스크림-2", 0, 8092, 0, 1000, 0);
        }
    }
}