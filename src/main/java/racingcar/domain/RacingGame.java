package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<String> names) {
        this.cars = names.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
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
