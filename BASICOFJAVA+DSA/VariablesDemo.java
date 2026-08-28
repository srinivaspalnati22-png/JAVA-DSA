/**
 * VariablesDemo.java
 * Demonstrates:
 * 1. Variable declaration & initialization across datatypes
 * 2. Reusability of variables
 * 3. Variable mutability (updating values dynamically)
 * 4. Case-sensitivity and camelCase naming conventions
 */
public class VariablesDemo {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("            JAVA VARIABLES DEMONSTRATION          ");
        System.out.println("==================================================");

        // 1. Variable declaration and initialization
        int age = 22;
        double salary = 50000.50;
        char grade = 'A';
        String name = "Ramesh";
        boolean isActive = true;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Grade: " + grade);
        System.out.println("Active Status: " + isActive);

        // 2. Reusability
        System.out.println("\n--- Variable Reusability ---");
        System.out.println("Welcome, " + name + "!");
        System.out.println("User profile belongs to: " + name);

        // 3. Variable values can change (Mutability)
        System.out.println("\n--- Variable Mutability ---");
        System.out.println("Initial Age: " + age);
        age = 25; // Value updated
        System.out.println("Updated Age: " + age);

        // 4. Case sensitivity
        int marks = 95;
        int Marks = 100;
        System.out.println("\n--- Case Sensitivity ---");
        System.out.println("marks (lowercase): " + marks);
        System.out.println("Marks (uppercase): " + Marks);
    }
}
