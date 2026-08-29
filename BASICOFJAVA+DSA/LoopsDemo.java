/**
 * 10. Loops in Java - Runnable Demonstration
 */
public class LoopsDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. For Loop (Fixed Iterations) ===");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\n=== 2. While Loop (Condition Based) ===");
        int count = 1;
        while (count <= 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();

        System.out.println("\n=== 3. Do-While Loop (Executes at least once) ===");
        int num = 1;
        do {
            System.out.print(num + " ");
            num++;
        } while (num <= 5);
        System.out.println();

        System.out.println("\n=== 4. Enhanced For Loop (For-Each) ===");
        int[] scores = {10, 20, 30, 40, 50};
        for (int s : scores) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("\n=== 5. Break & Continue ===");
        System.out.print("Break at 4: ");
        for (int i = 1; i <= 6; i++) {
            if (i == 4) break;
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("Continue (skip 3): ");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) continue;
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
