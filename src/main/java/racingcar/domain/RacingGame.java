package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
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

    public List<Car> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
