package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    public void run() {
        String input = InputView.readCarNames();
        int tryCount = Integer.parseInt(InputView.readTryCount());

        String[] carNames = input.split(",");

        List<Car> cars = new ArrayList<>();
        for (String car : carNames) {
            cars.add(new Car(car));
        }
        RacingGame racingGame = new RacingGame(cars);

        OutputView.printResult();
        for (int i = 0; i < tryCount; i++) {
            racingGame.oneRound();
        }
    }
}
