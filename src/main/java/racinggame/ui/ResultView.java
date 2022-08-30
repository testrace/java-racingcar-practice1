package racinggame.ui;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String DASH = "-";

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printPositions(final List<Integer> positions) {
        positions.forEach(ResultView::printPositionsOfCar);
        System.out.println();
    }

    private static void printPositionsOfCar(final int position) {
        final String skidMark = IntStream.range(0, position)
            .mapToObj(i -> DASH)
            .collect(Collectors.joining());

        System.out.print(skidMark);
        System.out.println();
    }

}
