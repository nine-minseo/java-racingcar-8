package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        InputValidator.validateHasInput(input);

        List<String> names = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        InputValidator.validateDuplicate(names);
        InputValidator.validateHasBlankName(names);

        return names;
    }

    public static int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        InputValidator.validateHasInput(input);
        int num = InputValidator.validateIsNumeric(input);
        InputValidator.validateIsPositive(num);

        return num;
    }
}
