/**
 * 07. Java Operators - Runnable Demonstration
 */
public class OperatorsDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. Arithmetic Operators ===");
        int a = 10, b = 3;
        System.out.println("a + b = " + (a + b)); // 13
        System.out.println("a - b = " + (a - b)); // 7
        System.out.println("a * b = " + (a * b)); // 30
        System.out.println("a / b = " + (a / b)); // 3 (integer division)
        System.out.println("a % b = " + (a % b)); // 1 (modulus)

        System.out.println("\n=== 2. Assignment Operators ===");
        int x = 10;
        x += 5; // x = 15
        System.out.println("After x += 5: " + x);
        x *= 2; // x = 30
        System.out.println("After x *= 2: " + x);

        System.out.println("\n=== 3. Comparison Operators ===");
        int p = 10, q = 20;
        System.out.println("p == q: " + (p == q)); // false
        System.out.println("p != q: " + (p != q)); // true
        System.out.println("p < q:  " + (p < q));  // true
        System.out.println("p >= q: " + (p >= q)); // false

        System.out.println("\n=== 4. Logical Operators ===");
        int age = 22;
        boolean hasID = true;
        System.out.println("age >= 18 && hasID: " + (age >= 18 && hasID)); // true
        System.out.println("age < 18 || hasID:  " + (age < 18 || hasID));  // true
        System.out.println("!hasID:             " + (!hasID));             // false
    }
}
