package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class DiceTest {

    @DisplayName("주사위를 굴리면 0~9 사이의 숫자가 나온다")
    @RepeatedTest(100)
    void rollDice() {
        // given
        final Dice dice = new Dice(10);

        // when
        final int actual = dice.roll();

        // then
        assertThat(actual).isBetween(0, 9);
    }
}
