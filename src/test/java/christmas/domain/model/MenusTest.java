package christmas.domain.model;

import static christmas.validation.constant.OrderMenuInputConstant.INVALID_ORDER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenusTest {

    private Menus initMenus;

    @BeforeEach
    void initMenus() {
        initMenus = Menus.init();
    }

    @Test
    @DisplayName("menus 객체가 정상적으로 생성이 됐는지 테스트")
    void testMenusCreation() {
        int menuCount = 12;
        Map<String, Menu> menus = initMenus.getMenus();
        Menu mushroomSoup = menus.get("양송이수프");
        Menu champagne = menus.get("샴페인");

        assertAll(
                () -> assertThat(menus.size()).isEqualTo(menuCount),
                () -> assertThat(mushroomSoup.getCategory()).isEqualTo("애피타이저"),
                () -> assertThat(mushroomSoup.getPrice()).isEqualTo(6000),
                () -> assertThat(champagne.getCategory()).isEqualTo("음료"),
                () -> assertThat(champagne.getPrice()).isEqualTo(25000)
        );
    }

    @Nested
    @DisplayName("고객이 메뉴판에 없는 메뉴 입력에 대해 검증한다.")
    class testValidateMenuExist {

        @ParameterizedTest
        @ValueSource(strings = {"레드와인-10,폭립-4,와인-5", "시저샐러드-2,공기밥-3", "생성까스-2"})
        @DisplayName("입력한 메뉴가 메뉴판에 없는 경우 예외가 발생해야 하는 테스트")
        void testMenuInputNotExistException(String input) {

            assertThatThrownBy(() -> initMenus.validateMenuExist(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(INVALID_ORDER.getMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"티본스테이크-2,바비큐립-4,레드와인-5,시저샐러드-5"})
        @DisplayName("입력한 메뉴가 메뉴판에 있는 경우 예외가 발생하지 않아야 하는 테스트")
        void testMenuInputExistNotException(String input) {

            assertThatCode(() -> initMenus.validateMenuExist(input))
                    .doesNotThrowAnyException();
        }
    }
}