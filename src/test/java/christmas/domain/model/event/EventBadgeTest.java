package christmas.domain.model.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.dto.EventPlanDto;
import christmas.domain.model.Menus;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EventBadgeTest {

    private Menus menus;

    @BeforeEach
    void initMenus() {
        menus = Menus.init();
    }

    @ParameterizedTest(name = "생성한 이벤트 베지값이 기대값인 expectedEventBadge 와 같은지 테스트")
    @CsvSource({
            "25, '티본스테이크-1,초코케이크-3,아이스크림-5,제로콜라-1', 산타",
            "31, '해산물파스타-1,초코케이크-1,아이스크림-10', 산타",
            "15, '크리스마스파스타-4,아이스크림-1,제로콜라-1', 트리",
            "27, '아이스크림-5,초코케이크-2,제로콜라-1', 트리",
            "28, '해산물파스타-1,초코케이크-2,아이스크림-2', 별",
            "29, '크리스마스파스타-3,아이스크림-2', 별",
            "11, '티본스테이크-1,제로콜라-2,타파스-2', 없음",
            "29, '양송이수프-3,초코케이크-2,아이스크림-2', 없음"
    })
    void testCreationEventBadge(String visitDate, String menu, String expectedEventBadge) {
        User user = User.create(visitDate, menu);
        OriginalOrderAmount originalOrderAmount = OriginalOrderAmount.create(menus, user);
        EventPlanDto eventPlanDto = EventPlanDto.create(menus, user);
        BenefitDetails benefitDetails = BenefitDetails.create();
        benefitDetails.createEventPlan(originalOrderAmount, eventPlanDto);

        EventBadge eventBadge = EventBadge.create(benefitDetails);

        assertThat(eventBadge.getEventBadge()).isEqualTo(expectedEventBadge);
    }
}