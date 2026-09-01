/**
 * ============================================================================
 * ⏱️ DEMO: TIME AND SPACE COMPLEXITY IN JAVA
 * ============================================================================
 * This program demonstrates and benchmarks various time complexity classes
 * (O(1), O(log N), O(N), O(N log N), O(N^2)) and space complexity differences
 * (In-Place O(1) vs Auxiliary Buffer O(N), and StringBuilder vs String churn).
 * ============================================================================
 */
public class ComplexityDemo {

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("       ⏱️ JAVA TIME & SPACE COMPLEXITY DEMONSTRATION           ");
        System.out.println("===============================================================\n");

        demoConstantTime();
        demoLogarithmicTime();
        demoLinearVsQuadraticTime();
        demoStringTrapBenchmark();
        demoSpaceComplexityComparison();

        System.out.println("===============================================================");
        System.out.println("           🎉 COMPLEXITY DEMO COMPLETED SUCCESSFULLY           ");
        System.out.println("===============================================================");
    }

    /**
     * 1. Constant Time: O(1)
     * Regardless of input size, operation count is fixed.
     */
    private static void demoConstantTime() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("1️⃣ DEMO: O(1) - Constant Time Complexity");
        System.out.println("---------------------------------------------------------------");

        int[] sample = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        
        // Instant direct indexing
        int first = sample[0];
        int last = sample[sample.length - 1];

        // Math formula for sum of 1..N
        int n = 1_000_000;
        long sumFormula = (long) n * (n + 1) / 2;

        System.out.println("Array Length: " + sample.length);
        System.out.println("First element: " + first + ", Last element: " + last);
        System.out.println("Sum of 1 to " + n + " via formula (O(1) steps): " + sumFormula);
        System.out.println(">> Total operations: 1 (Instantaneous regardless of N)\n");
    }

    /**
     * 2. Logarithmic Time: O(log N)
     * Search space / number is halved every iteration.
     */
    private static void demoLogarithmicTime() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("2️⃣ DEMO: O(log N) - Logarithmic Time Complexity");
        System.out.println("---------------------------------------------------------------");

        int[] testSizes = {16, 1024, 1_000_000, 1_000_000_000};

        for (int n : testSizes) {
            int steps = 0;
            int temp = n;
            while (temp > 1) {
                temp /= 2;
                steps++;
            }
            System.out.printf("For N = %,13d  -->  Halving Steps (log2 N): %2d%n", n, steps);
        }
        System.out.println(">> Notice: Even for 1 BILLION items, only ~30 steps needed!\n");
    }

    /**
     * 3. Linear O(N) vs. Quadratic O(N^2)
     * Demonstrates operation count explosion in nested loops.
     */
    private static void demoLinearVsQuadraticTime() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("3️⃣ DEMO: O(N) Linear vs. O(N^2) Quadratic Growth");
        System.out.println("---------------------------------------------------------------");

        int[] testValues = {10, 50, 100, 500, 1000};
        System.out.printf("%-10s | %-15s | %-18s | %-15s%n", "N", "O(N) Steps", "O(N^2) Steps", "O(N^2 / 2) Triangle");
        System.out.println("---------------------------------------------------------------");

        for (int n : testValues) {
            long linearSteps = n;
            long quadraticSteps = (long) n * n;
            long triangleSteps = (long) n * (n - 1) / 2;

            System.out.printf("%-10d | %,15d | %,18d | %,15d%n",
                    n, linearSteps, quadraticSteps, triangleSteps);
        }
        System.out.println(">> When N=1,000, O(N) is 1,000 steps, but O(N^2) jumps to 1,000,000!\n");
    }

    /**
     * 4. Java String Concatenation Trap Benchmark
     * Shows how String '+' inside loops behaves as O(N^2) vs StringBuilder's O(N).
     */
    private static void demoStringTrapBenchmark() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("4️⃣ DEMO: The Java String Concatenation Performance Trap");
        System.out.println("---------------------------------------------------------------");

        int iterations = 30_000;

        // Test 1: String concatenation (+) -> O(N^2) Time & Space
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a";
        }
        long durationString = System.currentTimeMillis() - startTime;

        // Test 2: StringBuilder append -> O(N) Time & Space
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        String result = sb.toString();
        long durationBuilder = System.currentTimeMillis() - startTime;

        System.out.println("Appending 'a' " + iterations + " times:");
        System.out.printf("❌ String concatenation (+) [O(N^2)]:  %5d ms%n", durationString);
        System.out.printf("✅ StringBuilder.append()   [O(N)]  :  %5d ms%n", durationBuilder);
        System.out.println(">> Always use StringBuilder for repeated string additions!\n");
    }

    /**
     * 5. Space Complexity: In-Place O(1) vs Auxiliary Buffer O(N)
     */
    private static void demoSpaceComplexityComparison() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("5️⃣ DEMO: Space Complexity (In-Place O(1) vs Buffer O(N))");
        System.out.println("---------------------------------------------------------------");

        int[] original = {1, 2, 3, 4, 5};
        System.out.print("Original Array: ");
        printArray(original);

        // Approach A: In-place reversal (Two pointers) -> Auxiliary Space: O(1)
        int[] inPlaceArr = original.clone();
        int left = 0, right = inPlaceArr.length - 1;
        while (left < right) {
            int temp = inPlaceArr[left];
            inPlaceArr[left] = inPlaceArr[right];
            inPlaceArr[right] = temp;
            left++;
            right--;
        }
        System.out.print("Approach A (In-Place Two-Pointers, O(1) Extra Space): ");
        printArray(inPlaceArr);

        // Approach B: Auxiliary Buffer Array -> Auxiliary Space: O(N)
        int[] buffer = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            buffer[i] = original[original.length - 1 - i];
        }
        System.out.print("Approach B (Auxiliary Buffer Array, O(N) Extra Space): ");
        printArray(buffer);
        System.out.println(">> In-place algorithms avoid allocating extra arrays in RAM.\n");
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
