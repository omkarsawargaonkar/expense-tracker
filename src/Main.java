import model.Expense;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        int nextId = 1;

        boolean running = true;

        while (running) {

            System.out.println("\n==============================");
            System.out.println("       Expense Tracker");
            System.out.println("==============================");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Search Expense");
            System.out.println("5. Update Expense");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    sc.nextLine();

                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    Expense expense = new Expense(
                            nextId,
                            title,
                            category,
                            amount,
                            date
                    );

                    expenses.add(expense);

                    nextId++;

                    System.out.println("\nExpense added successfully!");

                    break;

                case 2:

                    if (expenses.isEmpty()) {

                        System.out.println("\nNo expenses found.");

                    } else {

                        System.out.println("\n===== Expense List =====");

                        for (Expense e : expenses) {

                            System.out.println(e);
                            System.out.println("----------------------------");

                        }
                    }

                    break;

                case 3:

                    if (expenses.isEmpty()) {

                        System.out.println("\nNo expenses to delete.");

                    } else {

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

                            System.out.println("\nExpense with ID " + idToDelete + " not found.");

                        }
                    }

                    break;

                case 4:

                    if (expenses.isEmpty()) {

                        System.out.println("\nNo expenses found.");

                    } else {

                        System.out.print("Enter Expense ID: ");
                        int idToSearch = sc.nextInt();

                        boolean found = false;

                        for (int i = 0; i < expenses.size(); i++) {

                            if (expenses.get(i).getId() == idToSearch) {

                                System.out.println("\nExpense Found:");
                                System.out.println("----------------------------");
                                System.out.println(expenses.get(i));
                                System.out.println("----------------------------");

                                found = true;

                                break;
                            }
                        }

                        if (!found) {

                            System.out.println("\nExpense with ID " + idToSearch + " not found.");

                        }
                    }

                    break;

                case 5:

                    if (expenses.isEmpty()) {

                        System.out.println("\nNo expenses found.");

                    } else {

                        System.out.print("Enter Expense ID to update: ");
                        int idToUpdate = sc.nextInt();
                        sc.nextLine();

                        boolean found = false;

                        for (int i = 0; i < expenses.size(); i++) {

                            if (expenses.get(i).getId() == idToUpdate) {

                                Expense exp = expenses.get(i);

                                System.out.println("\nCurrent Expense:");
                                System.out.println(exp);

                                System.out.print("\nEnter New Title: ");
                                String newTitle = sc.nextLine();

                                System.out.print("Enter New Category: ");
                                String newCategory = sc.nextLine();

                                System.out.print("Enter New Amount: ");
                                double newAmount = sc.nextDouble();
                                sc.nextLine();

                                System.out.print("Enter New Date (YYYY-MM-DD): ");
                                String newDate = sc.nextLine();

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

                            System.out.println("\nExpense with ID " + idToUpdate + " not found.");

                        }
                    }

                    break;

                case 6:

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