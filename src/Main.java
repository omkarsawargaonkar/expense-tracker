import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import model.Expense;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        boolean running = true;
        int nextId = 1;

        while (running) {

            System.out.println("\n===========================");
            System.out.println("      Expense Tracker");
            System.out.println("===========================");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Search Expense");
            System.out.println("5. Update Expense");
            System.out.println("6. Calculate Total Expenses");
            System.out.println("7. Filter by Category");
            System.out.println("8. Sort Expenses");
            System.out.println("9. Highest Expense");
            System.out.println("10. Lowest Expense");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    int id = nextId;
                    nextId++;

                    // ---------------- Title Validation ----------------

                    boolean validTitle = false;
                    String title = "";

                    while (!validTitle) {

                        System.out.print("Enter Title: ");
                        title = sc.nextLine().trim();

                        if (title.isEmpty()) {
                            System.out.println("Title cannot be empty.");
                        } else {
                            validTitle = true;
                        }
                    }

                    // ---------------- Category Validation ----------------

                    boolean validCategory = false;
                    String category = "";

                    while (!validCategory) {

                        System.out.print("Enter Category: ");
                        category = sc.nextLine().trim();

                        if (category.isEmpty()) {
                            System.out.println("Category cannot be empty.");
                        } else {
                            validCategory = true;
                        }
                    }

                    // ---------------- Amount Validation ----------------

                    boolean validAmount = false;
                    double amount = 0;

                    while (!validAmount) {

                        try {

                            System.out.print("Enter Amount: ");
                            amount = sc.nextDouble();

                            if (amount < 0) {
                                System.out.println("Amount cannot be negative.");
                            } else {
                                validAmount = true;
                            }

                        } catch (InputMismatchException e) {

                            System.out.println("Invalid number! Please enter a numeric value.");
                            sc.next();
                            continue;

                        }

                    }

                    sc.nextLine(); // Consume leftover newline

                    // ---------------- Date ----------------

                    // ---------------- Date Validation ----------------

                    boolean validDate = false;
                    LocalDate expenseDate = null;

                    while (!validDate) {

                        try {

                            System.out.print("Enter Date (YYYY-MM-DD): ");
                            String input = sc.nextLine().trim();

                            expenseDate = LocalDate.parse(input);

                            validDate = true;

                        } catch (DateTimeParseException e) {

                            System.out.println("Invalid date! Please enter the date in YYYY-MM-DD format.");

                        }

                    }

                    // ---------------- Create Expense ----------------

                    Expense expense = new Expense(id, title, category, amount, expenseDate);

                    expenses.add(expense);

                    System.out.println("\nExpense Added Successfully!");

                    break;
                case 2:

                    if (expenses.isEmpty()) {
                        System.out.println("\nNo expenses found.");
                    } else {

                        System.out.println("\n===== Expense List =====");

                        for (Expense e : expenses) {
                            System.out.println(e);
                            System.out.println("------------------------");
                        }
                    }

                    break;

                case 3:

                    if (expenses.isEmpty()) {
                        System.out.println("\nNo expenses found.");
                        break;
                    }

                    System.out.print("Enter Expense ID to delete: ");
                    int idToDelete = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < expenses.size(); i++) {

                        if (expenses.get(i).getId() == idToDelete) {

                            expenses.remove(i);
                            System.out.println("\nExpense deleted successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("\nExpense not found.");
                    }

                    break;

                case 4:

                    if (expenses.isEmpty()) {
                        System.out.println("\nNo expenses found.");
                        break;
                    }

                    System.out.print("Enter Expense ID to search: ");
                    int idToSearch = sc.nextInt();

                    found = false;

                    for (int i = 0; i < expenses.size(); i++) {

                        if (expenses.get(i).getId() == idToSearch) {

                            System.out.println("\nExpense Found:");
                            System.out.println(expenses.get(i));
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("\nExpense not found.");
                    }

                    break;

                case 5:

                    if (expenses.isEmpty()) {
                        System.out.println("\nNo expenses found.");
                        break;
                    }

                    System.out.print("Enter Expense ID to update: ");
                    int idToUpdate = sc.nextInt();
                    sc.nextLine();

                    found = false;

                    for (int i = 0; i < expenses.size(); i++) {

                        if (expenses.get(i).getId() == idToUpdate) {

                            Expense exp = expenses.get(i);

                            System.out.println("\nCurrent Expense:");
                            System.out.println(exp);

                            System.out.print("Enter New Title: ");
                            String newTitle = sc.nextLine();

                            System.out.print("Enter New Category: ");
                            String newCategory = sc.nextLine();

                            System.out.print("Enter New Amount: ");
                            double newAmount = sc.nextDouble();

                            sc.nextLine();

                            System.out.print("Enter New Date (YYYY-MM-DD): ");
                            LocalDate newDate = LocalDate.parse(sc.nextLine().trim());

                            exp.setTitle(newTitle);
                            exp.setCategory(newCategory);
                            exp.setAmount(newAmount);
                            exp.setExpenseDate(newDate);

                            System.out.println("\nExpense updated successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("\nExpense not found.");
                    }

                    break;

                case 6:

                    if (expenses.isEmpty()) {
                        System.out.println("\nNo expenses found.");
                    } else {

                        double total = 0;

                        for (Expense exp : expenses) {
                            total += exp.getAmount();
                        }

                        System.out.println("\n===== Total Expenses =====");
                        System.out.println("Total Amount: " + total);
                    }

                    break;

                case 7:

                    if (expenses.isEmpty()) {
                        System.out.println("\nNo expenses found.");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter Category: ");
                    String searchCategory = sc.nextLine();

                    found = false;

                    System.out.println("\n===== Matching Expenses =====");

                    for (Expense exp : expenses) {

                        if (exp.getCategory().equalsIgnoreCase(searchCategory)) {

                            System.out.println(exp);
                            System.out.println("------------------------");
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("\nNo expenses found in this category.");
                    }

                    break;

                case 8:

                    if (expenses.isEmpty()) {
                        System.out.println("\nNo expenses found.");
                        break;
                    }

                    System.out.println("\n===== Sort Expenses =====");
                    System.out.println("1. Amount (Ascending)");
                    System.out.println("2. Amount (Descending)");
                    System.out.print("Enter your choice: ");

                    int sortChoice = sc.nextInt();

                    if (sortChoice == 1) {

                        Collections.sort(expenses,
                                (e1, e2) -> Double.compare(e1.getAmount(), e2.getAmount()));

                        System.out.println("\nExpenses sorted in ascending order.");

                    } else if (sortChoice == 2) {

                        Collections.sort(expenses,
                                (e1, e2) -> Double.compare(e2.getAmount(), e1.getAmount()));

                        System.out.println("\nExpenses sorted in descending order.");

                    } else {

                        System.out.println("\nInvalid choice!");
                        break;
                    }

                    System.out.println("\n===== Expense List =====");

                    for (Expense exp : expenses) {
                        System.out.println(exp);
                        System.out.println("------------------------");
                    }

                    break;

                case 9:

                    if (expenses.isEmpty()) {
                        System.out.println("\nNo expenses found.");
                        break;
                    }

                    Expense highest = expenses.get(0);

                    for (Expense exp : expenses) {

                        if (exp.getAmount() > highest.getAmount()) {
                            highest = exp;
                        }
                    }

                    System.out.println("\n===== Highest Expense =====");
                    System.out.println(highest);

                    break;

                case 10:

                    if (expenses.isEmpty()) {
                        System.out.println("\nNo expenses found.");
                        break;
                    }

                    Expense lowest = expenses.get(0);

                    for (Expense exp : expenses) {

                        if (exp.getAmount() < lowest.getAmount()) {
                            lowest = exp;
                        }
                    }

                    System.out.println("\n===== Lowest Expense =====");
                    System.out.println(lowest);

                    break;

                case 11:

                    running = false;
                    System.out.println("\nThank you for using Expense Tracker!");
                    break;

                default:

                    System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}