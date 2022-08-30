package racinggame;

import racinggame.domain.Dice;
import racinggame.domain.RacingGame;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

public class RacingCarApplication {
    private static final Dice DICE = Dice.bound(10);

    public static void main(String[] args) {
        final String[] names = InputView.nameOfCars();
        final int countOfTry = InputView.countOfTry();

        final RacingGame racingGame = new RacingGame(names, countOfTry);

        ResultView.printResultMessage();

        while (racingGame.isPlaying()) {
            racingGame.race(DICE);
            ResultView.printCarsPositions(racingGame.carsPositions());
        }

        ResultView.printWinners(racingGame.winners());
    }

}
