package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수가 null이거나 공백이면 예외가 발생한다.")
    void validateAttemptCount_Null_Or_Blank_Throws_Exception() {
        String nullInput = null;
        String blankInput = "  ";

        assertThatThrownBy(() -> Application.validateAttemptCount(nullInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력해야 합니다.");

        assertThatThrownBy(() -> Application.validateAttemptCount(blankInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력해야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외가 발생한다.")
    void validateAttemptCount_Not_A_Number_Throws_Exception() {
        String notNumber = "abc";

        assertThatThrownBy(() -> Application.validateAttemptCount(notNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자여야 합니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
