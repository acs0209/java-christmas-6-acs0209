package christmas.domain.model.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.dto.EventPlanDto;
import christmas.domain.model.Menus;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DiscountedOrderAmountTest {

    private Menus menus;

    @BeforeEach
    void initMenus() {
        menus = Menus.init();
    }

    @ParameterizedTest(name = "할인 후 예상 결제 금액 생성 기능 테스트")
    @CsvSource({
            "1, '바비큐립-1,시저샐러드-4,레드와인-2,아이스크림-4', 222977",
            "3, '티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1', 135754",
            "13, '해산물파스타-3,초코케이크-2,양송이수프-5,샴페인-1', 183754",
            "13, '양송이수프-1,제로콜라-1', 6800",
            "28, '양송이수프-1,제로콜라-1', 9000",
            "26, '타파스-1,제로콜라-1', 8500"
    })
    void testExpectedPaymentAfterDiscount(String visitDate, String menu, int expectedDiscountedOrderAmount) {
        User user = User.create(visitDate, menu);
        OriginalOrderAmount originalOrderAmount = OriginalOrderAmount.create(menus, user);
        EventPlanDto eventPlanDto = EventPlanDto.create(menus, user);

        BenefitDetails benefitDetails = BenefitDetails.create();
        benefitDetails.createEventPlan(originalOrderAmount, eventPlanDto);
        DiscountedOrderAmount discountedOrderAmount = DiscountedOrderAmount.create(originalOrderAmount, benefitDetails);

        assertThat(discountedOrderAmount.getDiscountedOrderAmount()).isEqualTo(expectedDiscountedOrderAmount);
    }
}