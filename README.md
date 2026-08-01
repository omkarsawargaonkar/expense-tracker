# Expense Tracker

A Java console-based Expense Tracker application that helps users efficiently manage their daily expenses. The application allows users to perform complete CRUD operations on expense records stored in a MySQL database using JDBC. It also provides expense analysis features such as total expenses, category-wise filtering, sorting, and identifying the highest and lowest expenses.

---

## Features

- Add a new expense
- View all expenses
- Update existing expenses
- Delete expenses
- Calculate total expenses
- Filter expenses by category
- Sort expenses by amount (Ascending)
- Sort expenses by amount (Descending)
- Find the highest expense
- Find the lowest expense
- Input validation for:
    - Expense Title
    - Amount
    - Category
    - Date
- Persistent data storage using MySQL
- Modular project structure following separation of concerns
- Proper resource management using try-with-resources

---

## Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| JDBC | Database Connectivity |
| MySQL | Database |
| IntelliJ IDEA | IDE |
| Git | Version Control |
| GitHub | Project Hosting |

---

## Project Structure

```
ExpenseTracker
│
├── src
│   ├── dao
│   │   └── ExpenseDAO.java
│   │
│   ├── db
│   │   └── DBConnection.java
│   │
│   ├── model
│   │   └── Expense.java
│   │
│   ├── util
│   │   └── InputValidator.java
│   │
│   └── Main.java
│
└── README.md
```

---

## Database

### Database Name

```text
expense_tracker
```

### Table Name

```text
expenses
```

### SQL Script

```sql
CREATE DATABASE expense_tracker;

USE expense_tracker;

CREATE TABLE expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    category VARCHAR(100) NOT NULL,
    date DATE NOT NULL
);
```

---

## How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/omkarsawargaonkar/expense-tracker.git
```

### 2. Open the project

Open the project using IntelliJ IDEA or any Java IDE.

### 3. Create the Database

Execute the SQL script provided above.

### 4. Configure Database Connection

Update your MySQL credentials inside:

```
src/db/DBConnection.java
```

Example:

```java
private static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
```

### 5. Add MySQL JDBC Driver

Ensure MySQL Connector/J is added to the project.

### 6. Run the Project

Run:

```
Main.java
```

---

## Input Validation

The application validates user input before storing it in the database.

Validation includes:

- Empty title validation
- Empty category validation
- Positive amount validation
- Valid LocalDate format
- Invalid input handling

---

## Project Highlights

- Console-based Java application
- JDBC-based database connectivity
- MySQL integration
- Clean package structure
- Utility class for reusable validation methods
- Auto Increment Primary Key
- try-with-resources for automatic resource management
- Modular and maintainable code
- Git version control with meaningful commits

---

## Future Enhancements

- Search expenses by title
- Monthly expense reports
- Expense statistics dashboard
- Export expenses to CSV
- Export expenses to PDF
- User authentication
- Java Swing GUI
- Spring Boot REST API
- Web-based interface

---

## Learning Outcomes

This project helped me strengthen my understanding of:

- Core Java
- Object-Oriented Programming
- JDBC
- MySQL
- CRUD Operations
- Exception Handling
- Input Validation
- LocalDate API
- Project Structuring
- Git & GitHub

---

## Author

**Omkar Sawargaonkar**

Computer Engineering Graduate

- GitHub: https://github.com/omkarsawargaonkar
- LinkedIn: https://www.linkedin.com/in/omkarsawargaonkar/



