package racinggame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private static final Dice DICE = new Dice(10);
    private final List<Car> cars;
    private final int countOfTry;

    private int raceCount = 0;

    public RacingGame(final int countOfCars, final int countOfTry) {
        this.countOfTry = countOfTry;
        this.cars = createCars(countOfCars);
    }

    private List<Car> createCars(final int countOfCars) {
        return IntStream.range(0, countOfCars)
            .mapToObj(i -> new Car("123"))
            .collect(Collectors.toUnmodifiableList());
    }

    public void race() {
        cars.forEach(car -> car.move(rolling()));
        raceCount++;
    }

    public boolean isPlaying() {
        return raceCount != countOfTry;
    }

    public List<Integer> positions() {
        return cars.stream()
            .map(Car::getPosition)
            .map(Position::getValue)
            .collect(Collectors.toUnmodifiableList());
    }

    private ForwardMovable rolling() {
        return new DefaultForwardMovable(DICE.roll());
    }

}
