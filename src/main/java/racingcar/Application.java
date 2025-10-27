package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

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
        System.out.println("\n실행 결과");

        for (int i = 0; i < attemptCount; i++) {
            playOneRound(carList);
            System.out.println();
        }

        int maxForwardStep = 0;
        for (Car car : carList) {
            if (maxForwardStep < car.getNumberOfForwardSteps()) {
                maxForwardStep = car.getNumberOfForwardSteps();
            }
        }

        List<Car> maxForwardCarList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getNumberOfForwardSteps() == maxForwardStep) {
                maxForwardCarList.add(car);
            }
        }

        OutputView.printWinners(maxForwardCarList);
    }

    public static void playOneRound(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                car.advance();
            }
        }
        OutputView.printRoundResult(carList);
    }
}
