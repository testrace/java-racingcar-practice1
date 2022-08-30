package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingGameTest {

    @DisplayName("게임 진행 중")
    @ParameterizedTest
    @CsvSource(value = {
        "3, 2, true",
        "3, 3, false"
    })
    void gameIsPlaying(int countOfTry, int raceCount, boolean expected) {
        //given
        final RacingGame racingGame = new RacingGame(new String[]{"이름"}, countOfTry);

        //when
        for (int i = 0; i < raceCount; i++) {
            racingGame.race();
        }

        final boolean actual = racingGame.isPlaying();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
