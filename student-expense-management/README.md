# Student Expense Management System

A simple console-based Java application that helps students track their daily
expenses — food, travel, books, hostel fees, and more — and gives quick
summaries of spending by student or by category.

## Features

- **Add Expense** — record a new expense with student name, category, amount, date, and a short note.
- **View All Expenses** — list every expense stored so far.
- **View Expenses by Student** — filter and view all expenses for a specific student.
- **View Expenses by Category** — filter expenses by category (Food, Travel, Books, etc.).
- **Delete Expense** — remove a record by its ID.
- **Total Expense (All Students)** — get the overall spending total.
- **Total Expense (Per Student)** — get the total spent by one student.
- **Persistent Storage** — all data is saved to a local text file (`data/expenses.txt`), so records are kept between runs.

## Tech Stack

- **Language:** Java (JDK 17 or later recommended)
- **Storage:** Plain text file (CSV format), no external database required
- **Interface:** Command-line (console) menu

## Project Structure

```
student-expense-management/
├── src/
│   ├── Main.java             # Entry point; console menu and user interaction
│   ├── ExpenseManager.java   # Business logic (add/delete/search/summaries)
│   ├── Expense.java          # Expense data model + CSV conversion
│   └── FileHandler.java      # Reads/writes expenses.txt for persistence
├── data/
│   └── expenses.txt          # Auto-generated data file (created on first run)
├── README.md
└── STATEMENT.md              # Project report / problem statement
```

## How to Compile and Run

1. Clone this repository:
   ```bash
   git clone https://github.com/<your-username>/student-expense-management.git
   cd student-expense-management
   ```

2. Compile all Java files:
   ```bash
   javac -d bin src/*.java
   ```

3. Run the program:
   ```bash
   java -cp bin Main
   ```

   > Note: The program creates a `data/expenses.txt` file automatically the
   > first time you add an expense, so no manual setup is needed.

## Sample Menu

```
--------- MAIN MENU ---------
1. Add Expense
2. View All Expenses
3. View Expenses by Student
4. View Expenses by Category
5. Delete an Expense
6. View Total Expense (All Students)
7. View Total Expense for a Student
8. Exit
```

## Future Enhancements

- Add a graphical user interface (JavaFX or Swing).
- Add monthly/category-wise spending charts.
- Support multiple currencies.
- Add a budget-limit alert feature.
- Migrate storage from a text file to a database (MySQL/SQLite).

## Author

Add your name, roll number, and course details here before submission.

## License

This project is open-source and available for educational use.
