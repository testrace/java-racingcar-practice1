package racinggame.ui;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COUNT_OF_CARS_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String COUNT_OF_TRY_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private InputView() {
        throw new AssertionError();
    }

    public static int countOfCars() {
        println(COUNT_OF_CARS_MESSAGE);
        return SCANNER.nextInt();
    }

    public static int countOfTry() {
        println(COUNT_OF_TRY_MESSAGE);
        return SCANNER.nextInt();
    }

    private static void println(String message) {
        System.out.println(message);
    }

}
