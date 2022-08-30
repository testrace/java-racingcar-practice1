package racinggame.domain;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingGame {

    private static final Dice DICE = new Dice(10);
    private final List<Car> cars;
    private final int countOfTry;

    private int raceCount = 0;

    public RacingGame(final String[] names, final int countOfTry) {
        this.countOfTry = countOfTry;
        this.cars = createCars(names);
    }

    private List<Car> createCars(final String[] names) {
        return Arrays.stream(names)
            .map(Car::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public void race() {
        cars.forEach(car -> car.move(rolling()));
        raceCount++;
    }

    public boolean isPlaying() {
        return raceCount != countOfTry;
    }

    private ForwardMovable rolling() {
        return new DefaultForwardMovable(DICE.roll());
    }

    public Map<String, Integer> carsPositions() {
        return cars.stream()
            .collect(toMap(Car::name, Car::position));
    }

}
