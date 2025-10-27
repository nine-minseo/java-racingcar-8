package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_INVALID_NAME = "자동차의 이름은 1~5자여야 합니다.";

    private String name;
    private int numberOfForwardSteps = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_NAME);
        }
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfForwardSteps() {
        return this.numberOfForwardSteps;
    }

    public void advance() {
        numberOfForwardSteps++;
    }
}
