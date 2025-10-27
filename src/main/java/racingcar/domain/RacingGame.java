package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playOneRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                car.advance();
            }
        }
    }

    public List<Car> findWinners() {
        int maxForwardStep = 0;
        for (Car car : cars) {
            if (maxForwardStep < car.getNumberOfForwardSteps()) {
                maxForwardStep = car.getNumberOfForwardSteps();
            }
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getNumberOfForwardSteps() == maxForwardStep) {
                winners.add(car);
            }
        }
        return winners;
    }
}
