package christmas.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MenuTest {

    @ParameterizedTest(name = "Menu 객체 생성 기능 테스트")
    @CsvSource({
            "애피타이저, 6000, 애피타이저, 6000",
            "메인, 55000, 메인, 55000",
            "디저트, 15000, 디저트, 15000",
            "음료, 60000, 음료, 60000"
    })
    void testCreationMenu(String category, String price, String expectedCategory, int expectedMenuPrice ) {
        int menuPrice = Integer.parseInt(price);
        Menu menu = Menu.create(category, menuPrice);

        assertThat(menu.getCategory()).isEqualTo(expectedCategory);
        assertThat(menu.getPrice()).isEqualTo(expectedMenuPrice);
    }
}