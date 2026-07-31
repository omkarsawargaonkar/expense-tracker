package util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {

    public static String getValidText(Scanner sc, String fieldName) {

        while (true) {

            System.out.print("Enter " + fieldName + ": ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println(fieldName + " cannot be empty.");
            } else {
                return input;
            }

        }

    }

    public static double getValidAmount(Scanner sc) {

        while (true) {

            try {

                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();

                if (amount < 0) {
                    System.out.println("Amount cannot be negative.");
                } else {
                    sc.nextLine();   // Consume newline
                    return amount;
                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid amount! Please enter a valid number.");
                sc.next(); // Remove invalid input

            }

        }

    }

    public static LocalDate getValidDate(Scanner sc) {

        while (true) {

            try {

                System.out.print("Enter Date (YYYY-MM-DD): ");
                String input = sc.nextLine().trim();

                return LocalDate.parse(input);

            } catch (DateTimeParseException e) {

                System.out.println("Invalid date! Please enter the date in YYYY-MM-DD format.");

            }

        }

    }

}
