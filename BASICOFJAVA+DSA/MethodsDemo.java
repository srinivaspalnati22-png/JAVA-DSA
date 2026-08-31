/**
 * 12. Methods in Java - Runnable Demonstration
 */
public class MethodsDemo {

    // ==========================================
    // 1. Four Types of Methods
    // ==========================================

    // Type 1: No Parameters, No Return Value
    public static void greet() {
        System.out.println("[Type 1] Hello! Welcome to Java & DSA.");
    }

    // Type 2: With Parameters, No Return Value
    public static void greetUser(String name) {
        System.out.println("[Type 2] Hello, " + name + "! Welcome to Methods in Java.");
    }

    // Type 3: No Parameters, With Return Value
    public static double getPi() {
        return 3.141592653589793;
    }

    // Type 4: With Parameters & With Return Value
    public static int add(int a, int b) {
        return a + b;
    }

    // ==========================================
    // 2. Method Overloading (Compile-Time Polymorphism)
    // ==========================================

    // Overload 1: Two ints
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Overload 2: Three ints
    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    // Overload 3: Two doubles
    public static double multiply(double a, double b) {
        return a * b;
    }

    // ==========================================
    // 3. Recursion & Call Stack Example
    // ==========================================

    public static void printCountdown(int n) {
        // Base case
        if (n == 0) {
            System.out.println("  -> Base case reached (n=0). Unwinding call stack!");
            return;
        }
        System.out.println("  -> Pushing printCountdown(" + n + ") onto call stack");
        
        // Recursive call
        printCountdown(n - 1);
        
        System.out.println("  <- Popping printCountdown(" + n + ") from call stack");
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // ==========================================
    // Main Method (Entry Point)
    // ==========================================
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("          12. METHODS IN JAVA DEMO               ");
        System.out.println("==================================================");

        System.out.println("\n--- 1. Four Types of Methods ---");
        greet();                                      // Type 1
        greetUser("Eshwar");                          // Type 2
        double pi = getPi();                          // Type 3
        System.out.println("[Type 3] Retrieved Pi: " + pi);
        int sum = add(10, 20);                        // Type 4
        System.out.println("[Type 4] Sum (10 + 20): " + sum);

        System.out.println("\n--- 2. Method Overloading ---");
        System.out.println("multiply(3, 5): " + multiply(3, 5));
        System.out.println("multiply(3, 5, 2): " + multiply(3, 5, 2));
        System.out.println("multiply(2.5, 4.0): " + multiply(2.5, 4.0));

        System.out.println("\n--- 3. Recursion & Call Stack Trace ---");
        System.out.println("Starting Countdown Trace for n = 3:");
        printCountdown(3);

        System.out.println("\nFactorial of 5: " + factorial(5));
        System.out.println("==================================================");
    }
}
