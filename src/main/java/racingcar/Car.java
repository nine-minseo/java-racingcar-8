package racingcar;

public class Car {
    private String name;
    private int numberOfForwardSteps = 0;

    Car(String name) {
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
