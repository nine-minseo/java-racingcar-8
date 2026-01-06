package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);

        this.name = name;
    }

    private void validateNameLength(String input) {
        if (input.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
