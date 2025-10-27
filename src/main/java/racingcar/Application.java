package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNameAndAttemptCountList = getCarNameAndAttemptCountFromUser();
        List<String> carNameList = List.of(carNameAndAttemptCountList.getFirst().split(","));
        int attemptCount = Integer.parseInt(carNameAndAttemptCountList.getLast());

        List<Car> carList = new ArrayList<>();
        for (String car : carNameList) {
            carList.add(new Car(car));
        }

        startGame(carList);
    }

    public static List<String> getCarNameAndAttemptCountFromUser() {
        List<String> carNameAndAttemptCountList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNameAndAttemptCountList.add(Console.readLine());

        System.out.println("시도할 횟수는 몇 회인가요?");
        carNameAndAttemptCountList.add(Console.readLine());

        return validValue(carNameAndAttemptCountList);
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

    public static void startGame(List<Car> carList) {
        System.out.println("실행 결과");

        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                car.advance();
            }

            System.out.println(car.getName() + " : " + "-".repeat(car.getNumberOfForwardSteps()));
        }
    }
}
