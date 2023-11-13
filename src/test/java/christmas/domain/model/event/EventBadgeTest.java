package christmas.domain.model.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.dto.EventPlanDto;
import christmas.domain.model.Menus;
import christmas.domain.model.OriginalOrderAmount;
import christmas.domain.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class EventBadgeTest {

    @Nested
    @DisplayName("이벤트 배지 생성 기능 테스트")
    class TestCreationEventBadge {

        private final Menus menus = Menus.init();

        private void testCreationEventBadge(String visitDate, String menu, String expectedEventBadge) {
            User user = User.create(visitDate, menu);
            OriginalOrderAmount originalOrderAmount = OriginalOrderAmount.create(menus, user);
            EventPlanDto eventPlanDto = EventPlanDto.create(menus, user);
            BenefitDetails benefitDetails = BenefitDetails.create();
            benefitDetails.createEventPlan(originalOrderAmount, eventPlanDto);

            EventBadge eventBadge = EventBadge.create(benefitDetails);

            assertThat(eventBadge.getEventBadge()).isEqualTo(expectedEventBadge);
        }

        @Test
        @DisplayName("생성한 이벤트 베지값이 기대값인 산타와 같은지 테스트")
        void testEventVeggieValueIsExpectedSanta() {
            testCreationEventBadge("25", "티본스테이크-1,초코케이크-3,아이스크림-5,제로콜라-1", "산타");
        }

        @Test
        @DisplayName("생성한 이벤트 베지값이 기대값인 트리와 같은지 테스트")
        void testEventVeggieValueIsExpectedTree() {
            testCreationEventBadge("27", "아이스크림-5,초코케이크-2,제로콜라-1", "트리");
        }

        @Test
        @DisplayName("생성한 이벤트 베지값이 기대값인 별과 같은지 테스트")
        void testEventVeggieValueIsExpectedStar() {
            testCreationEventBadge("28", "해산물파스타-1,초코케이크-2,아이스크림-2", "별");
        }

        @Test
        @DisplayName("생성한 이벤트 베지값이 기대값인 없음과 같은지 테스트")
        void testEventVeggieValueIsExpectedNone() {
            testCreationEventBadge("29", "양송이수프-3,초코케이크-2,아이스크림-2", "없음");
        }
    }
}