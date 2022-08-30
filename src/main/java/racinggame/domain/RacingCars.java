package racinggame.domain;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(final String[] names) {
        this.cars = createCars(names);
    }

    private List<Car> createCars(final String[] names) {
        return Arrays.stream(names)
            .map(Car::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public void move(final Dice dice) {
        cars.forEach(car -> car.move(DefaultForwardMovable.of(dice.roll())));
    }

    public Map<String, Integer> carsPositions() {
        return cars.stream()
            .collect(toMap(Car::name, Car::position));
    }

    public Winners winners() {
        return new Winners(carsPositions());
    }

}
