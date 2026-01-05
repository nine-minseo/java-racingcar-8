package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int steps = 0;

    public Car(String name) {
        this.name = name;
    }

    public void advance() {
        this.steps++;
    }

    public String getName() {
        return this.name;
    }

    public int getSteps() {
        return this.steps;
    }
}
