package racinggame.domain;

import java.util.Objects;

public class Position {

    public static final Position ZERO = new Position(0);

    private final int value;

    public Position(final int value) {
        if (value < 0 ) {
            throw new IllegalArgumentException("자동차의 위치는 음수가 될 수 없습니다");
        }
        this.value = value;
    }

    public Position increase() {
        return new Position(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position position = (Position) o;
        return getValue() == position.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
