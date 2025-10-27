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

    public void advance() {
        numberOfForwardSteps++;
    }
}
