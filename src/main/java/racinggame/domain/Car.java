package racinggame.domain;

import java.util.Objects;

public class Car {

    private Position position;

    public Car() {
        this(Position.ZERO);
    }

    public Car(final Position position) {
        this.position = position;
    }

    public void move(final ForwardMovable forwardMovable) {
        if (forwardMovable.isMovable()) {
            position = position.increase();
        }
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Car car = (Car) o;
        return Objects.equals(getPosition(), car.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
