package christmas.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OriginalOrderAmountTest {

    private Menus menus;

    @BeforeEach
    void initMenus() {
        menus = Menus.init();
    }

    @Test
    @DisplayName("할인 전 총주문 금액 계산 기능 테스트")
    void testCalculateTotalOrderAmountBeforeDiscount() {
        String visitDate = "7";
        String menu = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        User user = User.create(visitDate, menu);

        OriginalOrderAmount originalOrderAmount = OriginalOrderAmount.create(menus, user);

        assertThat(originalOrderAmount.getOrderAmount()).isEqualTo(142000);
    }
}