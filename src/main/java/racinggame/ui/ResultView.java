package racinggame.ui;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

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

    public static void printWinners(final Map<String, Integer> carsPositions) {
        final int maxPosition = maxPosition(carsPositions);
        final List<String> winners = winners(carsPositions, maxPosition);

        System.out.print("최종 우승자: ");
        System.out.println(String.join(", ", winners));
    }

    private static int maxPosition(final Map<String, Integer> carsPositions) {
        return carsPositions.values().stream()
            .max(Integer::compareTo)
            .orElseThrow(IllegalArgumentException::new);
    }

    private static List<String> winners(final Map<String, Integer> carsPositions, final int maxPosition) {
        return carsPositions.entrySet().stream()
            .filter(entry -> entry.getValue() == maxPosition)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}
