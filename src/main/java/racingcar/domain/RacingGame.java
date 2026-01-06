package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.OutputView;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void oneRound() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
        OutputView.printRoundResult(cars);
    }
}
