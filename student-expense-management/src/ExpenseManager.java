import java.util.ArrayList;
import java.util.List;

/**
 * Core business logic for managing student expenses:
 * adding, deleting, searching, and summarizing records.
 */
public class ExpenseManager {

    private List<Expense> expenses;
    private int nextId;

    public ExpenseManager() {
        this.expenses = FileHandler.loadExpenses();
        this.nextId = calculateNextId();
    }

    private int calculateNextId() {
        int maxId = 0;
        for (Expense e : expenses) {
            if (e.getId() > maxId) {
                maxId = e.getId();
            }
        }
        return maxId + 1;
    }

    public void addExpense(String studentName, String category, double amount, String date, String description) {
        Expense expense = new Expense(nextId, studentName, category, amount, date, description);
        expenses.add(expense);
        nextId++;
        FileHandler.saveExpenses(expenses);
    }

    public boolean deleteExpense(int id) {
        boolean removed = expenses.removeIf(e -> e.getId() == id);
        if (removed) {
            FileHandler.saveExpenses(expenses);
        }
        return removed;
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public List<Expense> getExpensesByStudent(String studentName) {
        List<Expense> result = new ArrayList<>();
        for (Expense e : expenses) {
            if (e.getStudentName().equalsIgnoreCase(studentName)) {
                result.add(e);
            }
        }
        return result;
    }

    public List<Expense> getExpensesByCategory(String category) {
        List<Expense> result = new ArrayList<>();
        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                result.add(e);
            }
        }
        return result;
    }

    public double getTotalExpense() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    public double getTotalExpenseByStudent(String studentName) {
        double total = 0;
        for (Expense e : expenses) {
            if (e.getStudentName().equalsIgnoreCase(studentName)) {
                total += e.getAmount();
            }
        }
        return total;
    }
}
