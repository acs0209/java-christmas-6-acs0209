package christmas.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OriginalOrderAmountTest {

    private Menus menus;

    @BeforeEach
    void initMenus() {
        menus = Menus.init();
    }

    @ParameterizedTest(name = "할인 전 총주문 금액 계산 기능 테스트")
    @CsvSource({
            "7, '티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1', 142000",
            "15, '해산물파스타-1,크리스마스파스타-1,아이스크림-2,레드와인-1', 130000",
            "7, '양송이수프-1,타파스-1,시저샐러드-2,티본스테이크-1,바비큐립-1,해산물파스타-1,크리스마스파스타-1,"
                    + "초코케이크-2,아이스크림-1,제로콜라-1,레드와인-1,샴페인-1', 319500",
            "3, '타파스-1,제로콜라-1', 8500",
    })
    void testCalculateTotalOrderAmountBeforeDiscount(int visitDate, String menu, int expectedTotalOrderAmount) {
        User user = User.create(String.valueOf(visitDate), menu);

        OriginalOrderAmount originalOrderAmount = OriginalOrderAmount.create(menus, user);

        assertThat(originalOrderAmount.getOrderAmount()).isEqualTo(expectedTotalOrderAmount);
    }
}