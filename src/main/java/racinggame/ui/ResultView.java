package racinggame.ui;

import java.io.PrintStream;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racinggame.domain.Winners;

public class ResultView {

    private static final PrintStream OUT = System.out;
    private static final String DASH = "-";

    private ResultView() {
        throw new AssertionError();
    }


    public static void print(String message) {
        OUT.print(message);
    }

    public static void println() {
        println("");
    }

    public static void println(String message) {
        OUT.println(message);
    }

    public static void printResultMessage() {
        println("실행 결과");
    }

    public static void printCarsPositions(final Map<String, Integer> carsPositions) {
        carsPositions.forEach((name, position) -> {
            print(name + " : ");
            printlnPositionsOfCar(position);
        });
        println();
    }

    private static void printlnPositionsOfCar(final int position) {
        final String skidMark = IntStream.range(0, position)
            .mapToObj(i -> DASH)
            .collect(Collectors.joining());

        print(skidMark);
        println();
    }

    public static void printWinners(final Winners winners) {
        print("최종 우승자: ");
        println(String.join(", ", winners.names()));
    }
}
