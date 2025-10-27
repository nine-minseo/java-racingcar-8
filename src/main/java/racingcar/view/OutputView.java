package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class OutputView {
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String DELIMITER = ", ";
    private static final String SEPARATOR_CAR_PROGRESS = " : ";
    private static final String PROGRESS_BAR = "-";

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(
                    car.getName() + SEPARATOR_CAR_PROGRESS + PROGRESS_BAR.repeat(car.getNumberOfForwardSteps()));
        }
    }

    public static void printWinners(List<Car> winners) {
        System.out.print(FINAL_WINNER);
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(DELIMITER);
            }
        }
    }
}
