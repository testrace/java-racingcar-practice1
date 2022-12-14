package racinggame.domain;

import java.util.Objects;

public class Car {

    private final Name name;
    private Position position;

    public Car(final String name) {
        this(name, Position.ZERO);
    }

    public Car(final String name, final Position position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void move(final ForwardMovable forwardMovable) {
        if (forwardMovable.isMovable()) {
            position = position.increase();
        }
    }

    public String name() {
        return name.value();
    }

    public int position() {
        return position.getValue();
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
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
