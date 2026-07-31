package model;

import java.time.LocalDate;

public class Expense {

    private int id;
    private String title;
    private String category;
    private double amount;
    private LocalDate expenseDate;

    // Default Constructor
    public Expense() {

    }

    // Parameterized Constructor
    public Expense(int id, String title, String category, double amount, LocalDate expenseDate) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.expenseDate = expenseDate;
    }

    public Expense(String title, String category, double amount, LocalDate expenseDate) {
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.expenseDate = expenseDate;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    // toString()

    @Override
    public String toString() {
        return "ID: " + id +
                "\nTitle: " + title +
                "\nCategory: " + category +
                "\nAmount: " + amount +
                "\nDate: " + expenseDate;
    }
}