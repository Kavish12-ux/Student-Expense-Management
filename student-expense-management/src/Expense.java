/**
 * Represents a single expense record made by a student.
 */
public class Expense {

    private int id;
    private String studentName;
    private String category;
    private double amount;
    private String date;        // format: dd-MM-yyyy
    private String description;

    public Expense(int id, String studentName, String category, double amount, String date, String description) {
        this.id = id;
        this.studentName = studentName;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    // ----- Getters -----
    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Converts this expense into a single CSV line for file storage.
     * Commas inside description/category are replaced to keep the format safe.
     */
    public String toCsv() {
        return id + "," +
               studentName.replace(",", " ") + "," +
               category.replace(",", " ") + "," +
               amount + "," +
               date + "," +
               description.replace(",", " ");
    }

    /**
     * Builds an Expense object back from a CSV line.
     */
    public static Expense fromCsv(String line) {
        String[] parts = line.split(",", 6);
        int id = Integer.parseInt(parts[0].trim());
        String studentName = parts[1].trim();
        String category = parts[2].trim();
        double amount = Double.parseDouble(parts[3].trim());
        String date = parts[4].trim();
        String description = parts.length > 5 ? parts[5].trim() : "";
        return new Expense(id, studentName, category, amount, date, description);
    }

    @Override
    public String toString() {
        return String.format("ID: %-4d | Student: %-15s | Category: %-12s | Amount: Rs.%-10.2f | Date: %-10s | Note: %s",
                id, studentName, category, amount, date, description);
    }
}
