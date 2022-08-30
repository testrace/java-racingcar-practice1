package racinggame.ui;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racinggame.domain.Winners;

public class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    private static final String DASH = "-";

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printCars(final Map<String, Integer> carsPositions) {
        carsPositions.forEach((name, position) -> {
            System.out.print(name + " : ");
            printPositionsOfCar(position);
        });
        System.out.println();
    }

    private static void printPositionsOfCar(final int position) {
        final String skidMark = IntStream.range(0, position)
            .mapToObj(i -> DASH)
            .collect(Collectors.joining());

        System.out.print(skidMark);
        System.out.println();
    }

    public static void printWinners(final Winners winners) {
        System.out.print("최종 우승자: ");
        System.out.println(String.join(", ", winners.names()));
    }
}
