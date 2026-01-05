package racingcar;

import racingcar.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.readCarNames();
        String[] cars = carNames.split(",");

        int tryCount = Integer.parseInt(InputView.readTryCount());

        int roundCount = Randoms.pickNumberInRange(0, 9);

    }
}
