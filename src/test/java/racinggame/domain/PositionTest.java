package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("자동차의 위치")
    @Test
    void position() {
        //given
        final int defaultValue = 0;

        //when
        final Position actual = new Position(defaultValue);

        //then
        assertThat(actual).isEqualTo(new Position(defaultValue));
    }

    @DisplayName("자동차의 위치가 음수일 경우 예외를 발생시킨다")
    @Test
    void exceptionThrowsNegativePosition() {
        //given
        final int negativeValue = -1;

        //when
        final ThrowingCallable actual = () -> new Position(negativeValue);

        //then
        assertThatThrownBy(actual)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차의 위치는 음수가 될 수 없습니다");
    }

    @DisplayName("자동차의 위치를 1 증가시킨다")
    @Test
    void increase() {
        //given
        final Position position = new Position(0);

        //when
        final Position actual = position.increase();

        //then
        assertThat(actual).isEqualTo(new Position(1));

    }
}
