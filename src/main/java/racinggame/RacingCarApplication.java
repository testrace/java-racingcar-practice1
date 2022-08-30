package racinggame;

import racinggame.domain.RacingGame;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

public class RacingCarApplication {
    private static final String RACING_RESULT_MESSAGE = "실행 결과";

    public static void main(String[] args) {
        final String[] names = InputView.nameOfCars();
        final int countOfTry = InputView.countOfTry();

        final RacingGame racingGame = new RacingGame(names, countOfTry);

        ResultView.println(RACING_RESULT_MESSAGE);

        while (racingGame.isPlaying()) {
            racingGame.race();
            ResultView.printCars(racingGame.carsPositions());
        }

        ResultView.printWinners(racingGame.carsPositions());

    }

}
