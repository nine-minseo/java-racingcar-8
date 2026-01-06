package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    public void run() {
        List<String> input = InputView.readCarNames();
        int tryCount = InputView.readTryCount();

        RacingGame racingGame = new RacingGame(input);

        OutputView.printResultStartMessage();

        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
            OutputView.printRoundResult(racingGame.getCars());
        }

        OutputView.printWinners(racingGame.findWinner());
    }
}
