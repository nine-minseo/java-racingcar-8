package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("가장 많이 전진한 자동차가 1명일 때, 우승자를 한 명 반환한다.")
    void findWinners_SingleWinner() {
        Car pobi = new Car("pobi");
        pobi.advance();
        pobi.advance();
        pobi.advance();

        Car woni = new Car("woni");
        woni.advance();

        RacingGame game = new RacingGame(List.of(pobi, woni));

        List<Car> winners = game.findWinners();

        assertThat(winners).hasSize(1);

        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차가 여러 명일 때, 우승자를 여러 명 반환한다.")
    void findWinners_JointWinners() {

        Car pobi = new Car("pobi");
        pobi.advance();
        pobi.advance();
        pobi.advance();

        Car woni = new Car("woni");
        woni.advance();
        woni.advance();
        woni.advance();

        Car jun = new Car("jun");
        jun.advance();

        RacingGame game = new RacingGame(List.of(pobi, woni, jun));

        List<Car> winners = game.findWinners();

        assertThat(winners).hasSize(2);

        assertThat(winners)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi", "woni");
    }
}