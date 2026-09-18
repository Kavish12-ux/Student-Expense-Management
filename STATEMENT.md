# Project Report: Student Expense Management System

## 1. Abstract

Managing personal finances is a challenge many students face, especially when
juggling limited monthly budgets across food, travel, books, and hostel
expenses. The **Student Expense Management System** is a console-based Java
application designed to help students record, organize, and analyze their
daily spending. The system allows users to add, view, search, and delete
expense records, as well as generate spending summaries for individual
students or across categories. All data is stored persistently in a local
file, ensuring records are not lost between sessions.

## 2. Problem Statement

Students often lose track of where their money goes each month because they
rely on memory or scattered notes to track spending. There is a need for a
lightweight, easy-to-use tool that:

- Records every expense with relevant details (who spent it, on what, how
  much, and when).
- Allows quick retrieval of spending history by student or category.
- Calculates totals to help students understand their overall spending
  pattern.
- Requires no external database or internet connection to operate.

## 3. Objectives

1. Design a Java-based system to record and manage student expenses.
2. Implement core CRUD (Create, Read, Update via delete-and-readd, Delete)
   operations for expense records.
3. Provide search and filter capabilities by student name and category.
4. Provide expense summaries (total spending overall and per student).
5. Ensure data persistence using file handling, so records survive program
   restarts.
6. Apply object-oriented programming principles (encapsulation, separation of
   concerns) to keep the codebase maintainable.

## 4. Scope

The system is designed for individual or small-group use (e.g., a classroom
or hostel group tracking shared or personal expenses). It is not intended to
replace full accounting or banking software, but rather to serve as a
lightweight personal/academic expense tracker.

**In scope:**
- Adding, viewing, searching, and deleting expense records.
- Category-wise and student-wise reporting.
- File-based data persistence.

**Out of scope (see Future Enhancements):**
- Multi-user login and authentication.
- Graphical user interface.
- Database integration (MySQL/SQLite).
- Currency conversion or multi-currency support.

## 5. System Requirements

### Hardware Requirements
- Any computer capable of running a JVM (minimum 2 GB RAM recommended).

### Software Requirements
- Java Development Kit (JDK) 17 or later.
- A text editor or IDE (VS Code, IntelliJ IDEA, Eclipse, etc.) — optional.
- Operating System: Windows, macOS, or Linux.

## 6. System Design

### 6.1 Architecture

The application follows a simple layered design to separate concerns:

| Layer              | Class              | Responsibility                                      |
|--------------------|--------------------|------------------------------------------------------|
| Presentation Layer | `Main.java`        | Displays the menu and handles user input/output.     |
| Business Logic     | `ExpenseManager.java` | Implements add/delete/search/summary operations.   |
| Data Model         | `Expense.java`     | Represents a single expense record.                   |
| Persistence Layer  | `FileHandler.java` | Reads and writes expense data to/from a text file.     |

### 6.2 Class Descriptions

- **Expense** — A plain data class holding an expense's ID, student name,
  category, amount, date, and description. It also knows how to convert
  itself to and from a CSV line for storage.
- **FileHandler** — A utility class with static methods `saveExpenses()` and
  `loadExpenses()` that use `BufferedReader`/`BufferedWriter` to persist data
  in `data/expenses.txt`.
- **ExpenseManager** — Holds the in-memory list of expenses and exposes
  operations such as `addExpense()`, `deleteExpense()`,
  `getExpensesByStudent()`, `getExpensesByCategory()`, `getTotalExpense()`,
  and `getTotalExpenseByStudent()`. Every change is immediately persisted via
  `FileHandler`.
- **Main** — Presents a numbered console menu, reads user choices with a
  `Scanner`, and delegates all actual work to `ExpenseManager`.

### 6.3 Data Flow

1. On startup, `Main` creates an `ExpenseManager`, which loads any existing
   records from `data/expenses.txt` via `FileHandler`.
2. The user interacts with the console menu to add, view, search, or delete
   expenses.
3. Every add/delete operation updates the in-memory list and immediately
   rewrites the data file, so no data is lost even if the program exits
   unexpectedly.

### 6.4 Storage Format

Each expense is stored as a single comma-separated line:

```
id,studentName,category,amount,date,description
```

Example:
```
1,Rahul Sharma,Food,150.0,15-09-2026,Lunch at canteen
2,Priya Singh,Travel,80.0,16-09-2026,Bus fare to college
```

## 7. Modules Implemented

1. **Add Expense Module** — Captures student name, category, amount, date,
   and description, and saves it as a new record.
2. **View Modules** — View all expenses, filter by student, or filter by
   category.
3. **Delete Module** — Removes a record by its unique ID.
4. **Reporting Module** — Calculates total expenses across all students or
   for a single student.
5. **Persistence Module** — Ensures every change is saved to disk
   automatically.

## 8. Testing

The following scenarios were manually tested:

| Test Case                                   | Expected Result                              | Status |
|----------------------------------------------|-----------------------------------------------|--------|
| Add a new expense                            | Record appears in "View All Expenses"         | Pass   |
| Search expenses by an existing student name  | Only that student's records are shown         | Pass   |
| Search expenses by a non-existent student    | "No records found" message shown              | Pass   |
| Delete an expense with a valid ID            | Record removed and confirmation shown         | Pass   |
| Delete an expense with an invalid ID         | "No expense found" message shown              | Pass   |
| Restart the program after adding records     | Previously added records are still available  | Pass   |
| View total expense with no records           | Total shown as Rs.0.00                        | Pass   |

## 9. Limitations

- The application is single-user and does not support concurrent access.
- Data is stored in plain text, which is not encrypted or protected.
- No GUI is provided; the interface is text-based only.

## 10. Future Enhancements

- Build a graphical interface using JavaFX or Swing for easier interaction.
- Add visual reports (pie charts/bar graphs) for category-wise spending.
- Integrate a proper database (MySQL or SQLite) for more robust storage.
- Add user authentication for multi-student use on a shared system.
- Add monthly budget limits with alerts when a student overspends.

## 11. Conclusion

The Student Expense Management System successfully demonstrates the use of
core Java concepts — object-oriented design, collections (`ArrayList`), and
file handling (`BufferedReader`/`BufferedWriter`) — to build a practical,
working application. It solves a real, everyday problem for students by
giving them a simple way to track and understand their spending habits, and
it lays a solid foundation for future enhancements such as a GUI or database
integration.

## 12. References

- Oracle Java Documentation — https://docs.oracle.com/en/java/
- Java `ArrayList` and Collections Framework documentation
- Java I/O (`java.io`) package documentation
