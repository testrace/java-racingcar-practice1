package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 생성")
    @Test
    void constructor() {
        //given
        //when
        final Car actual = new Car();

        //then
        assertThat(actual).isEqualTo(new Car());
    }

    @DisplayName("자동차는 움직일 수 있다")
    @Test
    void movable() {
        //given
        final Car actual = new Car();
        final Car expected = new Car(new Position(1));

        //when
        actual.move(() -> true);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("자동차는 움직일 수 없다")
    @Test
    void cantMovable() {
        //given
        final Car actual = new Car();
        final Car expected = new Car(new Position(0));

        //when
        actual.move(() -> false);

        //then
        assertThat(actual).isEqualTo(expected);
    }

}
