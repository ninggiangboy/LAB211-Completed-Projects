package Calculator.view;

import java.util.Scanner;

/**
 *
 * @author duykhanh
 */
public class Inputted {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final String NUMBER_VALID = "^-?\\d+$";

    public static int inputInt(String message, int min, int max) {
        if (min > max) {
            max = max + min;
            min = max - min;
            max = max - min;
        }

        System.out.print(message);
        int inputUser;

        do {
            try {
                String input = INPUT.nextLine().trim();
                if (!input.matches(NUMBER_VALID)) {
                    throw new Error();
                }
                inputUser = Integer.parseInt(input);

                if (inputUser < min || inputUser > max) {
                    throw new NumberFormatException();
                } else
                    return inputUser;
            } catch (Error e) {
                System.out.println("Nhap so di bay");
            } catch (NumberFormatException e) {
                System.err.println("Input out of range. Enter a value between " + min + " and " + max + ":");
            }
            System.out.print("Enter again: ");
        } while (true);
    }

    public static double inputDouble(String message, double min, double max) {
        if (min > max) {
            double temp = max;
            max = min;
            min = temp;
        }

        System.out.print(message);
        double inputUser;

        do {
            try {
                inputUser = Double.parseDouble(INPUT.nextLine().trim());

                if (inputUser < min || inputUser > max) {
                    System.err.println("Input out of range. Enter a value between " + min + " and " + max + ":");
                } else
                    return inputUser;
            } catch (NumberFormatException e) {
                System.err.println("Invalid number.");
            }
            System.out.print("Enter again: ");
        } while (true);
    }
}
