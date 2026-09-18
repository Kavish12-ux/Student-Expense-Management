import java.util.List;
import java.util.Scanner;

/**
 * Student Expense Management System
 * A console-based Java application to record, track, and analyze
 * daily expenses made by students.
 */
public class Main {

    private static ExpenseManager manager = new ExpenseManager();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println(" STUDENT EXPENSE MANAGEMENT SYSTEM");
        System.out.println("=====================================");

        int choice;
        do {
            printMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> viewAllExpenses();
                case 3 -> viewExpensesByStudent();
                case 4 -> viewExpensesByCategory();
                case 5 -> deleteExpense();
                case 6 -> viewTotalExpense();
                case 7 -> viewTotalByStudent();
                case 8 -> System.out.println("Exiting program. All data has been saved. Goodbye!");
                default -> System.out.println("Invalid choice. Please select a valid option (1-8).");
            }
        } while (choice != 8);

        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n--------- MAIN MENU ---------");
        System.out.println("1. Add Expense");
        System.out.println("2. View All Expenses");
        System.out.println("3. View Expenses by Student");
        System.out.println("4. View Expenses by Category");
        System.out.println("5. Delete an Expense");
        System.out.println("6. View Total Expense (All Students)");
        System.out.println("7. View Total Expense for a Student");
        System.out.println("8. Exit");
    }

    private static void addExpense() {
        sc.nextLine(); // clear buffer
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter category (Food/Travel/Books/Hostel/Other): ");
        String category = sc.nextLine();

        double amount = readDouble("Enter amount spent: Rs.");

        sc.nextLine();
        System.out.print("Enter date (dd-MM-yyyy): ");
        String date = sc.nextLine();

        System.out.print("Enter a short description: ");
        String description = sc.nextLine();

        manager.addExpense(name, category, amount, date, description);
        System.out.println("Expense added successfully!");
    }

    private static void viewAllExpenses() {
        List<Expense> expenses = manager.getAllExpenses();
        printExpenseList(expenses, "All Expenses");
    }

    private static void viewExpensesByStudent() {
        sc.nextLine();
        System.out.print("Enter student name to search: ");
        String name = sc.nextLine();
        List<Expense> expenses = manager.getExpensesByStudent(name);
        printExpenseList(expenses, "Expenses for " + name);
    }

    private static void viewExpensesByCategory() {
        sc.nextLine();
        System.out.print("Enter category to search: ");
        String category = sc.nextLine();
        List<Expense> expenses = manager.getExpensesByCategory(category);
        printExpenseList(expenses, "Expenses in category: " + category);
    }

    private static void deleteExpense() {
        int id = readInt("Enter the Expense ID to delete: ");
        boolean removed = manager.deleteExpense(id);
        if (removed) {
            System.out.println("Expense with ID " + id + " deleted successfully.");
        } else {
            System.out.println("No expense found with ID " + id + ".");
        }
    }

    private static void viewTotalExpense() {
        double total = manager.getTotalExpense();
        System.out.printf("Total expense recorded by all students: Rs.%.2f%n", total);
    }

    private static void viewTotalByStudent() {
        sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        double total = manager.getTotalExpenseByStudent(name);
        System.out.printf("Total expense for %s: Rs.%.2f%n", name, total);
    }

    private static void printExpenseList(List<Expense> expenses, String title) {
        System.out.println("\n--- " + title + " ---");
        if (expenses.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    // ----- Helper methods for safe input -----

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid whole number.");
            sc.next();
            System.out.print(prompt);
        }
        return sc.nextInt();
    }

    private static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.println("Please enter a valid amount.");
            sc.next();
            System.out.print(prompt);
        }
        return sc.nextDouble();
    }
}
