package dao;

import db.DBConnection;
import model.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;

public class ExpenseDAO {

    public void addExpense(Expense expense) {

        String sql = "INSERT INTO expenses(title, category, amount, expense_date) VALUES (?, ?, ?, ?)";

        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {


            ps.setString(1, expense.getTitle());
            ps.setString(2, expense.getCategory());
            ps.setDouble(3, expense.getAmount());
            ps.setDate(4, java.sql.Date.valueOf(expense.getExpenseDate()));

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Expense added successfully!");
            } else {
                System.out.println("Failed to add expense!");
            }


        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void viewExpenses() {

        String sql = "SELECT * FROM expenses";

        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {



            System.out.println("\n===== Expense List =====");

            boolean found = false;

            while (rs.next()) {

                int id = rs.getInt("id");
                String title = rs.getString("title");
                String category = rs.getString("category");
                double amount = rs.getDouble("amount");
                LocalDate expenseDate = rs.getDate("expense_date").toLocalDate();

                Expense expense = new Expense(id, title, category, amount, expenseDate);

                System.out.println(expense);
                System.out.println("------------------------");

                found = true;
            }

            if (!found) {
                System.out.println("No expenses found.");
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void searchExpense(int id) {

        String sql = "SELECT * FROM expenses WHERE id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, id);

            try (
                    ResultSet rs = ps.executeQuery();
            ) {

                if (rs.next()) {

                    int expenseId = rs.getInt("id");
                    String title = rs.getString("title");
                    String category = rs.getString("category");
                    double amount = rs.getDouble("amount");
                    LocalDate expenseDate =
                            rs.getDate("expense_date").toLocalDate();

                    Expense expense = new Expense(
                            expenseId,
                            title,
                            category,
                            amount,
                            expenseDate
                    );

                    System.out.println("\n===== Expense Found =====");
                    System.out.println(expense);

                } else {

                    System.out.println("\nExpense not found.");

                }

            }

        } catch (SQLException e) {

            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();

        }
    }

    public void updateExpense(Expense expense) {

        String sql = "UPDATE expenses SET title = ?, category = ?, amount = ?, expense_date = ? WHERE id = ?";

        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {



            ps.setString(1, expense.getTitle());
            ps.setString(2, expense.getCategory());
            ps.setDouble(3, expense.getAmount());
            ps.setDate(4, java.sql.Date.valueOf(expense.getExpenseDate()));
            ps.setInt(5, expense.getId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\nExpense updated successfully!");
            } else {
                System.out.println("\nExpense not found.");
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteExpense(int id) {

        String sql = "DELETE FROM expenses WHERE id = ?";

        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {



            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\nExpense deleted successfully!");
            } else {
                System.out.println("\nExpense not found.");
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void getTotalExpenses() {

        String sql = "SELECT SUM(amount) AS total FROM expenses";

        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {



            if (rs.next()) {

                double total = rs.getDouble("total");

                System.out.println("\nTotal Expenses : ₹" + total);

            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void filterByCategory(String category) {

        String sql = "SELECT * FROM expenses WHERE category = ?";

        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {


            ps.setString(1, category);

            try (
                    ResultSet rs = ps.executeQuery();
            ) {
                boolean found = false;
                System.out.println("\n===== Filtered Expenses =====");


                while (rs.next()) {

                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String expenseCategory = rs.getString("category");
                    double amount = rs.getDouble("amount");
                    LocalDate expenseDate = rs.getDate("expense_date").toLocalDate();

                    Expense expense = new Expense(id, title, expenseCategory, amount, expenseDate);

                    System.out.println(expense);
                    System.out.println("------------------------");

                    found = true;
                }

                if (!found) {
                    System.out.println("No expenses found in this category.");
                }

            }
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void sortExpenses(int choice) {

        String sql;

        if (choice == 1) {
            sql = "SELECT * FROM expenses ORDER BY amount ASC";
        } else {
            sql = "SELECT * FROM expenses ORDER BY amount DESC";
        }

        try(
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {



            boolean found = false;

            System.out.println("\n===== Sorted Expenses =====");

            while (rs.next()) {

                int id = rs.getInt("id");
                String title = rs.getString("title");
                String category = rs.getString("category");
                double amount = rs.getDouble("amount");
                LocalDate expenseDate = rs.getDate("expense_date").toLocalDate();

                Expense expense = new Expense(id, title, category, amount, expenseDate);

                System.out.println(expense);
                System.out.println("------------------------");

                found = true;
            }

            if (!found) {
                System.out.println("No expenses found.");
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void highestExpense() {

        String sql = "SELECT * FROM expenses ORDER BY amount DESC LIMIT 1";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            if (rs.next()) {

                int id = rs.getInt("id");
                String title = rs.getString("title");
                String category = rs.getString("category");
                double amount = rs.getDouble("amount");
                LocalDate expenseDate = rs.getDate("expense_date").toLocalDate();

                Expense expense = new Expense(id, title, category, amount, expenseDate);

                System.out.println("\n===== Highest Expense =====");
                System.out.println(expense);

            } else {

                System.out.println("No expenses found.");

            }

        } catch (SQLException e) {

            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void lowestExpense() {

        String sql = "SELECT * FROM expenses ORDER BY amount ASC LIMIT 1";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            if (rs.next()) {

                int id = rs.getInt("id");
                String title = rs.getString("title");
                String category = rs.getString("category");
                double amount = rs.getDouble("amount");
                LocalDate expenseDate = rs.getDate("expense_date").toLocalDate();

                Expense expense = new Expense(
                        id,
                        title,
                        category,
                        amount,
                        expenseDate
                );

                System.out.println("\n===== Lowest Expense =====");
                System.out.println(expense);

            } else {

                System.out.println("No expenses found.");

            }

        } catch (SQLException e) {

            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();

        }
    }
}