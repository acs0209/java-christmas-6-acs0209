package christmas.domain.model.event;

import static christmas.domain.constant.event.GiftMenuConstant.CHAMPAGNE_GIFT;
import static christmas.domain.constant.event.GiftMenuConstant.NO_GIFT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GiftMenuTest {

    @Nested
    @DisplayName("증정 메뉴 생성에 대해 테스트한다.")
    class testCreationGiftMenu {

        @ParameterizedTest
        @ValueSource(ints = {120000, 150000, 230000})
        @DisplayName("할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개가 증정이 되는지 테스트한다.")
        void testFreeChampagneOnTotalOrderAmount(int originalOrderAmount) {
            GiftMenu giftMenu = GiftMenu.create(originalOrderAmount);

            assertThat(giftMenu.getGiftMenu()).isEqualTo(CHAMPAGNE_GIFT.getMessage());
        }

        @ParameterizedTest
        @ValueSource(ints = {119999, 20000, 100000})
        @DisplayName("할인 전 총주문 금액이 12만 원 이상이 아니면, 샴페인 1개가 증정이 안 됐는지 테스트한다.")
        void testNoFreeChampagneOnTotalOrderAmountBelowThreshold(int originalOrderAmount) {
            GiftMenu giftMenu = GiftMenu.create(originalOrderAmount);

            assertThat(giftMenu.getGiftMenu()).isEqualTo(NO_GIFT.getMessage());
        }
    }
}