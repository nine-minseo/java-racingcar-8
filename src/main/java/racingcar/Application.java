package racingcar;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.readCarNames();
        String[] cars = carNames.split(",");

        int tryCount = Integer.parseInt(InputView.readTryCount());

    }
}
