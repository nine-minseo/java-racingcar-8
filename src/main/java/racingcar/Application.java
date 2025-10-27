package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String ERROR_INVALID_ATTEMPT_COUNT = "시도 횟수를 입력해야 합니다.";

    public static void main(String[] args) {
        String carName = InputView.getCarName();
        int attemptCount = validateAttemptCount(InputView.getAttemptCount());

        List<String> carNameList = List.of(carName.split(","));

        List<Car> carList = new ArrayList<>();
        for (String car : carNameList) {
            carList.add(new Car(car));
        }

        startGame(carList, attemptCount);
    }

    public static int validateAttemptCount(String attemptCount) {
        if (attemptCount == null || attemptCount.isBlank()) {
            throw new IllegalArgumentException(ERROR_INVALID_ATTEMPT_COUNT);
        }
        return Integer.parseInt(attemptCount);
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
