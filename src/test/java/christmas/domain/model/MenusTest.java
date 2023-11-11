package christmas.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenusTest {

    @Test
    @DisplayName("menus 객체가 정상적으로 생성이 됐는지 테스트")
    void testMenusCreation() {
        int menuCount = 12;
        Menus initMenus = Menus.init();

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
}