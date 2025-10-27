package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carName = InputView.getCarName();
        int attemptCount = Integer.parseInt(InputView.getAttemptCount());

        List<String> carNameList = List.of(carName.split(","));

        List<Car> carList = new ArrayList<>();
        for (String car : carNameList) {
            carList.add(new Car(car));
        }

        startGame(carList, attemptCount);
    }

    public static List<String> validValue(List<String> carNameAndAttemptCountList) {
        List<String> carNameList = List.of(carNameAndAttemptCountList.getFirst().split(","));
        String attemptCount = carNameAndAttemptCountList.getLast();

        for (String car : carNameList) {
            if (car.isEmpty() | car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        if (attemptCount.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return carNameAndAttemptCountList;
    }

    public static void startGame(List<Car> carList, int attemptCount) {
        RacingGame game = new RacingGame(carList);

        System.out.println("\n실행 결과");

        for (int i = 0; i < attemptCount; i++) {
            game.playOneRound();
            OutputView.printRoundResult(game.getCars());
            System.out.println();
        }
        List<Car> winners = game.findWinners();
        OutputView.printWinners(winners);
    }
}
