package racinggame.domain;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String value;

    public Name(final String value) {
        validate(value);
        this.value = value;
    }

    private static void validate(final String value) {
        validateEmpty(value);
        validateLength(value);
    }

    private static void validateEmpty(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 null 이거나 빈 문자열일 수 없습니다");
        }
    }

    private static void validateLength(final String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다");
        }
    }

    public String value() {
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
        final Name name1 = (Name) o;
        return Objects.equals(value(), name1.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }
}
