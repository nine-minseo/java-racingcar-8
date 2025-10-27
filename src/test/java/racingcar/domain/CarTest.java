package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
    void carName_Exceeds_MaxLength_Throws_Exception() {
        String longName = "pobiwoni";

        assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 null이면 예외가 발생한다.")
    void carName_Is_Null_Throws_Exception() {
        String nullName = null;

        assertThatThrownBy(() -> new Car(nullName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열(empty)이면 예외가 발생한다.")
    void carName_Is_Empty_Throws_Exception() {
        String emptyName = "";

        assertThatThrownBy(() -> new Car(emptyName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백(blank)이면 예외가 발생한다.")
    void carName_Is_Blank_Throws_Exception() {
        String blankName = "   ";

        assertThatThrownBy(() -> new Car(blankName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}