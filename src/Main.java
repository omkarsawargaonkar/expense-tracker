import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import dao.ExpenseDAO;
import util.InputValidator;

import model.Expense;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseDAO expenseDAO = new ExpenseDAO();

        boolean running = true;


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



                    // ---------------- Title Validation ----------------

                    String title = InputValidator.getValidText(sc, "Title");

                    // ---------------- Category Validation ----------------

                    String category = InputValidator.getValidText(sc, "Category");

                    // ---------------- Amount Validation ----------------

                    double amount = InputValidator.getValidAmount(sc);
                     // Consume leftover newline

                    // ---------------- Date ----------------

                    // ---------------- Date Validation ----------------

                    LocalDate expenseDate = InputValidator.getValidDate(sc);

                    // ---------------- Create Expense ----------------

                    Expense expense = new Expense(title, category, amount, expenseDate);

                    expenseDAO.addExpense(expense);

                    break;

                case 2:

                    expenseDAO.viewExpenses();

                    break;

                case 3:

                    System.out.print("Enter Expense ID to delete: ");
                    int idToDelete = sc.nextInt();

                    expenseDAO.deleteExpense(idToDelete);

                    break;

                case 4:

                    System.out.print("Enter Expense ID to search: ");
                    int idToSearch = sc.nextInt();

                    expenseDAO.searchExpense(idToSearch);

                    break;

                case 5:

                    System.out.print("Enter Expense ID to update: ");
                    int idToUpdate = sc.nextInt();
                    sc.nextLine();

                    String newTitle = InputValidator.getValidText(sc, "New Title");
                    String newCategory = InputValidator.getValidText(sc, "New Category");
                    double newAmount = InputValidator.getValidAmount(sc);
                    LocalDate newDate = InputValidator.getValidDate(sc);

                    Expense updatedExpense = new Expense(
                            idToUpdate,
                            newTitle,
                            newCategory,
                            newAmount,
                            newDate
                    );

                    expenseDAO.updateExpense(updatedExpense);

                    break;

                case 6:

                    expenseDAO.getTotalExpenses();

                    break;

                case 7:

                    System.out.print("Enter Category: ");
                    String filterCategory = sc.nextLine();

                    expenseDAO.filterByCategory(filterCategory);

                    break;


                case 8:

                    System.out.println("\n1. Ascending");
                    System.out.println("2. Descending");
                    System.out.print("Enter your choice: ");

                    int sortChoice = sc.nextInt();

                    if (sortChoice == 1 || sortChoice == 2) {
                        expenseDAO.sortExpenses(sortChoice);
                    } else {
                        System.out.println("Invalid Choice!");
                    }

                    break;


                case 9:

                    expenseDAO.highestExpense();
                    break;

                case 10:

                    expenseDAO.lowestExpense();

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