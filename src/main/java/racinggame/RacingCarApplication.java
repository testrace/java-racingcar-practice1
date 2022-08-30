package racinggame;

import racinggame.domain.RacingGame;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

public class RacingCarApplication {
    private static final String RACING_RESULT_MESSAGE = "실행 결과";

    public static void main(String[] args) {
        final int countOfCars = InputView.countOfCars();
        final int countOfTry = InputView.countOfTry();

        final RacingGame racingGame = new RacingGame(countOfCars, countOfTry);

        ResultView.println(RACING_RESULT_MESSAGE);

        while (racingGame.isPlaying()) {
            racingGame.race();
            ResultView.printPositions(racingGame.positions());
        }

    }

}
