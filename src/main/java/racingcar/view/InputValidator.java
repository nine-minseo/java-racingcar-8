package racingcar.view;

import java.util.List;

public class InputValidator {
    public static void validateHasInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
        }
    }

    public static int validateIsNumeric(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }

    public static void validateIsPositive(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수만 입력할 수 있습니다.");
        }
    }

    public static void validateDuplicate(List<String> input) {
        if (input.stream()
                .distinct()
                .count() != input.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static void validateHasBlankName(List<String> input) {
        if (input.stream()
                .anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("[ERROR] 입력하지 않은 자동차 이름이 있습니다.");
        }
    }
}
