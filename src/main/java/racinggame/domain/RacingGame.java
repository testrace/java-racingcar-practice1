package racinggame.domain;

import java.util.Map;

public class RacingGame {

    private final RacingCars racingCars;
    private final int countOfTry;

    private int raceCount = 0;

    public RacingGame(final String[] names, final int countOfTry) {
        this.racingCars = new RacingCars(names);
        this.countOfTry = countOfTry;
    }

    public void race(Dice dice) {
        racingCars.move(dice);
        raceCount++;
    }

    public boolean isPlaying() {
        return raceCount != countOfTry;
    }

    public Map<String, Integer> carsPositions() {
        return racingCars.carsPositions();
    }

    public Winners winners() {
        return racingCars.winners();
    }
}
