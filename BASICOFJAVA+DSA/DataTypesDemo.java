/**
 * 06. Data Types in Java - Runnable Demonstration
 */
public class DataTypesDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. Integer Data Types ===");
        byte age = 25;
        short year = 2026;
        int salary = 50000;
        long mobile = 9876543210L;

        System.out.println("byte: " + age);
        System.out.println("short: " + year);
        System.out.println("int: " + salary);
        System.out.println("long: " + mobile);

        System.out.println("\n=== 2. Floating-Point Data Types ===");
        float percentage = 85.5f;
        double price = 999.99;
        System.out.println("float: " + percentage);
        System.out.println("double: " + price);

        System.out.println("\n=== 3. Character & Boolean Data Types ===");
        char grade = 'A';
        char unicodeSymbol = '$';
        boolean isActive = true;
        boolean hasError = false;
        System.out.println("char: " + grade + ", symbol: " + unicodeSymbol);
        System.out.println("boolean isActive: " + isActive + ", hasError: " + hasError);

        System.out.println("\n=== 4. Wrapper Classes & Constants ===");
        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.SIZE (bits): " + Integer.SIZE);
        System.out.println("Double.MAX_VALUE: " + Double.MAX_VALUE);
    }
}
