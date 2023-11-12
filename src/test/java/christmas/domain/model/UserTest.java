package christmas.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("User 객체가 정상적으로 생성이 됐는지 테스트")
    void testCreationUser() {
        String date = "7";
        String menu = "해산물파스타-2,레드와인-1,초코케이크-1";

        User user = User.create(date, menu);

        assertAll(
                () -> assertThat(user.getOrderMenu().get("해산물파스타")).isEqualTo(2),
                () -> assertThat(user.getOrderMenu().get("레드와인")).isEqualTo(1),
                () -> assertThat(user.getOrderMenu().get("초코케이크")).isEqualTo(1),
                () -> assertThat(user.getVisitDate().getVisitDate()).isEqualTo(7)
        );
    }
}