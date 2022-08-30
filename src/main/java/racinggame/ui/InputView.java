package racinggame.ui;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COUNT_OF_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String COUNT_OF_TRY_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private InputView() {
        throw new AssertionError();
    }

    public static String[] nameOfCars() {
        println(COUNT_OF_CARS_MESSAGE);
        return SCANNER.nextLine().split(",");
    }

    public static int countOfTry() {
        println(COUNT_OF_TRY_MESSAGE);
        return SCANNER.nextInt();
    }

    private static void println(String message) {
        System.out.println(message);
    }

}
