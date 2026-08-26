package ARRAYS;

import java.util.Arrays;

/**
 * ArrayConcepts.java
 * Complete demonstration of Java Array fundamentals:
 * - Declaration, allocation & initialization
 * - Default values for different types
 * - Traversal (for loop vs for-each)
 * - Object nature & length property
 * - Common operations: Min, Max, Sum, Linear Search, In-place Reversal
 */
public class ArrayConcepts {

    // 1. Calculate Sum of Elements
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // 2. Find Maximum Element
    public static int findMax(int[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 3. Find Minimum Element
    public static int findMin(int[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // 4. Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found at index i
            }
        }
        return -1; // Not found
    }

    // 5. In-place Reversal using Two Pointers
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("         JAVA ARRAYS DEMONSTRATION        ");
        System.out.println("==========================================");

        // --- 1. Default Values Demonstration ---
        int[] defaultInts = new int[3];
        boolean[] defaultBools = new boolean[3];
        String[] defaultStrings = new String[3];

        System.out.println("Default int[]: " + Arrays.toString(defaultInts));       // [0, 0, 0]
        System.out.println("Default boolean[]: " + Arrays.toString(defaultBools));   // [false, false, false]
        System.out.println("Default String[]: " + Arrays.toString(defaultStrings)); // [null, null, null]

        // --- 2. Array as an Object ---
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("\nArray length (property): " + numbers.length); // 5
        System.out.println("Array runtime class: " + numbers.getClass().getName()); // [I

        // --- 3. Traversals ---
        System.out.print("\nStandard for loop: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        System.out.print("Enhanced for-each loop: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // --- 4. Basic Array Operations ---
        int[] sample = {45, 12, 89, 34, 67, 23};
        System.out.println("\nOriginal Array: " + Arrays.toString(sample));
        System.out.println("Sum: " + calculateSum(sample));
        System.out.println("Max: " + findMax(sample));
        System.out.println("Min: " + findMin(sample));
        System.out.println("Linear Search (89): Index " + linearSearch(sample, 89));
        System.out.println("Linear Search (99): Index " + linearSearch(sample, 99));

        // --- 5. Reversal ---
        reverseArray(sample);
        System.out.println("Reversed Array: " + Arrays.toString(sample));
    }
}
