package racingcar.domain;

public class Car {
    private String name;
    private int numberOfForwardSteps = 0;

    public Car(String name) {
        this.name = name;
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
