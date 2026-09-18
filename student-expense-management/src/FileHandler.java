import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles reading and writing Expense records to a CSV file on disk,
 * so that data persists between program runs.
 */
public class FileHandler {

    private static final String FILE_PATH = "data/expenses.txt";

    /**
     * Saves the given list of expenses to the data file, overwriting old content.
     */
    public static void saveExpenses(List<Expense> expenses) {
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs(); // ensure the "data" folder exists

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Expense expense : expenses) {
                writer.write(expense.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error while saving expenses: " + e.getMessage());
        }
    }

    /**
     * Loads all expenses from the data file. Returns an empty list
     * if the file does not exist yet (first run of the program).
     */
    public static List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return expenses;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    expenses.add(Expense.fromCsv(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Error while loading expenses: " + e.getMessage());
        }

        return expenses;
    }
}
