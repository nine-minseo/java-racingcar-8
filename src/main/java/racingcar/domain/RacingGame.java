package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public void oneRound() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
        OutputView.printRoundResult(cars);
    }

    public List<Car> findWinner() {
        int maxPosition = 0;
        for (Car car : cars) {
            int position = car.getPosition();
            if (position >= maxPosition) {
                maxPosition = position;
            }
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }
}
