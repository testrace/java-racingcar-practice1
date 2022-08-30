package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DefaultForwardMovableTest {

    @DisplayName("4이상인 경우 전진할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {
        "3, false",
        "4, true",
    })
    void movable(int value, boolean expected) {
        final ForwardMovable defaultForwardMovable = DefaultForwardMovable.of(value);

        final boolean actual = defaultForwardMovable.isMovable();

        assertThat(actual).isEqualTo(expected);
    }

}
