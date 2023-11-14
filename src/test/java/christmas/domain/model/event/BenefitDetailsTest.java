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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BenefitDetailsTest {

    private Menus menus;

    @BeforeEach
    void initMenus() {
        menus = Menus.init();
    }

    @ParameterizedTest(name = "각 이벤트의 할인 금액과 예상값이 일치하는지 테스트")
    @CsvSource({
            "1, '티본스테이크-1,바비큐립-1,양송이수프-3,초코케이크-1,제로콜라-1', 1000, 0, 4046, 0, 25000",
            "2, '양송이수프-3,초코케이크-1,제로콜라-1', 1100, 0, 0, 0, 0",
            "2, '양송이수프-3,초코케이크-1,제로콜라-1,아이스크림-10,레드와인-2', 1100, 0, 0, 0, 25000",
            "3, '티본스테이크-1,바비큐립-1,양송이수프-3,초코케이크-1,아이스크림-5,제로콜라-1', 1200, 12138, 0, 1000, 25000",
            "4, '티본스테이크-1,바비큐립-1,제로콜라-1', 1300, 0, 0, 0, 0",
            "5, '티본스테이크-1,바비큐립-1,크리스마스파스타-7,제로콜라-1', 1400, 0, 0, 0, 25000",
            "25, '티본스테이크-1,바비큐립-1,초코케이크-3,아이스크림-5,제로콜라-1', 3400, 16184, 0, 1000, 25000",
            "30, '티본스테이크-2,바비큐립-2,해산물파스타-3,크리스마스파스타-4,초코케이크-2,제로콜라-1', 0, 0, 22253, 0, 25000",
            "31, '해산물파스타-1,크리스마스파스타-1,초코케이크-2,아이스크림-2', 0, 8092, 0, 1000, 0",
            "31, '해산물파스타-1,크리스마스파스타-1,레드와인-2', 0, 0, 0, 1000, 25000"
    })
    void testDiscountAmountMatchExpectedAmount(String visitDate, String menu, int expectedChristmas, int expectedWeekday,
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
}