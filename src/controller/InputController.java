package controller;
import java.util.Scanner;

public class InputController {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputInt(int leftLimit, int rightLimit) {
        int value = leftLimit - 1;
        String range = "[" + leftLimit + " .. " +  rightLimit + "]";

        do try {
            value = Integer.parseInt(scanner.nextLine());
            if (value < leftLimit || value > rightLimit) printError(range);

        } catch (NumberFormatException exception) {
            printError(range);

        } while (value < leftLimit || value > rightLimit);
        return value;
    }

    public static String inputString() {
        String value, regex = "[а-яёА-ЯЁ -]+";

        do {
            value = scanner.nextLine();

            if (value.isEmpty() || !value.matches(regex))
                printError("['а .. я', 'А' .. 'Я', ' ', '-']");

        } while (value.isEmpty() || !value.matches(regex));
        return value;
    }

    private static void printError(String range) {
        System.out.println("\nВведено недопустимое значение. Повторите ввод данных!");
        System.out.print("Допустимые значения: " + range + ".\nВвод значения >> ");
    }
}