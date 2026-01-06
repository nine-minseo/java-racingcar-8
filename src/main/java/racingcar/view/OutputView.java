package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public static void printResult() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getSteps()));
        }
        System.out.println();
    }
}
