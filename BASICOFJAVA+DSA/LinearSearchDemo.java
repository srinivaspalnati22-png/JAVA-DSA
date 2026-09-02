import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * ============================================================================
 * 🔍 DEMO: LINEAR SEARCH IN JAVA
 * ============================================================================
 * This program demonstrates practical implementations of Linear Search:
 * 1. Standard 1D Array Search (Returns Index or -1)
 * 2. Boolean Search (Element existence check)
 * 3. String & Character Search
 * 4. Range-Bound Search [start, end]
 * 5. Minimum & Maximum Value Finder
 * 6. 2D Matrix Coordinate Search
 * 7. Multi-Occurrence / All-Matches Collector
 * 8. Real-world LeetCode Problem: Even Number of Digits
 * ============================================================================
 */
public class LinearSearchDemo {

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("           🔍 JAVA LINEAR SEARCH DEMONSTRATION                 ");
        System.out.println("===============================================================\n");

        demoStandardSearch();
        demoBooleanSearch();
        demoStringAndCharSearch();
        demoRangeSearch();
        demoMinMaxSearch();
        demo2DMatrixSearch();
        demoAllOccurrencesSearch();
        demoEvenDigitsProblem();

        System.out.println("===============================================================");
        System.out.println("          🎉 LINEAR SEARCH DEMO COMPLETED SUCCESSFULLY         ");
        System.out.println("===============================================================");
    }

    /**
     * 1. Standard Linear Search in 1D integer array
     */
    private static void demoStandardSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("1️⃣ STANDARD 1D INTEGER SEARCH");
        System.out.println("---------------------------------------------------------------");

        int[] arr = {42, 17, 89, 55, 23, 64, 11};
        int targetPresent = 55;
        int targetAbsent = 999;

        System.out.println("Array: " + Arrays.toString(arr));

        int idx1 = linearSearch(arr, targetPresent);
        System.out.println("Searching for " + targetPresent + " -> " + 
            (idx1 != -1 ? "Found at index: " + idx1 : "Not Found (-1)"));

        int idx2 = linearSearch(arr, targetAbsent);
        System.out.println("Searching for " + targetAbsent + " -> " + 
            (idx2 != -1 ? "Found at index: " + idx2 : "Not Found (-1)"));
        System.out.println();
    }

    public static int linearSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Early Exit on match
            }
        }
        return -1; // Target not found
    }

    /**
     * 2. Boolean Linear Search (Existence check)
     */
    private static void demoBooleanSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("2️⃣ BOOLEAN SEARCH (EXISTENCE CHECK)");
        System.out.println("---------------------------------------------------------------");

        int[] arr = {5, 10, 15, 20, 25};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Contains 15? " + contains(arr, 15));
        System.out.println("Contains 40? " + contains(arr, 40));
        System.out.println();
    }

    public static boolean contains(int[] arr, int target) {
        if (arr == null) return false;
        for (int element : arr) {
            if (element == target) return true;
        }
        return false;
    }

    /**
     * 3. String & Character Linear Search
     */
    private static void demoStringAndCharSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("3️⃣ STRING & CHARACTER SEARCH");
        System.out.println("---------------------------------------------------------------");

        String text = "DataStructures";
        char targetChar = 'S';
        int charIdx = searchChar(text, targetChar);
        System.out.println("Text: \"" + text + "\"");
        System.out.println("Search char '" + targetChar + "' -> Index: " + charIdx);

        String[] fruits = {"Apple", "Banana", "Cherry", "Mango", "Orange"};
        String query = "Cherry";
        int wordIdx = searchString(fruits, query);
        System.out.println("Fruits: " + Arrays.toString(fruits));
        System.out.println("Search word \"" + query + "\" -> Index: " + wordIdx);
        System.out.println();
    }

    public static int searchChar(String str, char target) {
        if (str == null) return -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) return i;
        }
        return -1;
    }

    public static int searchString(String[] arr, String target) {
        if (arr == null || target == null) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (target.equals(arr[i])) return i;
        }
        return -1;
    }

    /**
     * 4. Range-Bound Linear Search
     */
    private static void demoRangeSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("4️⃣ RANGE-BOUND SEARCH [start, end]");
        System.out.println("---------------------------------------------------------------");

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
        int target = 40;
        int start = 2, end = 5;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Searching for " + target + " between index " + start + " and " + end + ":");
        int idx = searchInRange(arr, target, start, end);
        System.out.println("Result index: " + idx);
        System.out.println();
    }

    public static int searchInRange(int[] arr, int target, int start, int end) {
        if (arr == null || start < 0 || end >= arr.length || start > end) return -1;
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    /**
     * 5. Finding Min & Max via Linear Scan
     */
    private static void demoMinMaxSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("5️⃣ MINIMUM & MAXIMUM VALUE FINDER");
        System.out.println("---------------------------------------------------------------");

        int[] nums = {45, -8, 12, 103, 0, -25, 77};
        System.out.println("Numbers: " + Arrays.toString(nums));
        System.out.println("Minimum Value: " + findMin(nums));
        System.out.println("Maximum Value: " + findMax(nums));
        System.out.println();
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    /**
     * 6. 2D Matrix Coordinate Search
     */
    private static void demo2DMatrixSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("6️⃣ 2D MATRIX SEARCH");
        System.out.println("---------------------------------------------------------------");

        int[][] grid = {
            {23, 4, 1},
            {18, 12, 3, 9},
            {78, 99, 34, 56}
        };

        int target = 99;
        int[] coords = search2D(grid, target);

        System.out.println("Matrix: " + Arrays.deepToString(grid));
        System.out.println("Searching for " + target + " -> Coordinates (row, col): [" + 
            coords[0] + ", " + coords[1] + "]");
        System.out.println();
    }

    public static int[] search2D(int[][] matrix, int target) {
        if (matrix == null) return new int[]{-1, -1};
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 7. Multi-Occurrence / All Matches Collector
     */
    private static void demoAllOccurrencesSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("7️⃣ FIND ALL OCCURRENCES");
        System.out.println("---------------------------------------------------------------");

        int[] arr = {10, 40, 20, 40, 50, 40, 90};
        int target = 40;
        List<Integer> occurrences = findAllOccurrences(arr, target);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);
        System.out.println("All matching indices: " + occurrences);
        System.out.println("Total count: " + occurrences.size());
        System.out.println();
    }

    public static List<Integer> findAllOccurrences(int[] arr, int target) {
        List<Integer> matches = new ArrayList<>();
        if (arr == null) return matches;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                matches.add(i);
            }
        }
        return matches;
    }

    /**
     * 8. LeetCode 1295: Find Numbers with Even Number of Digits
     */
    private static void demoEvenDigitsProblem() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("8️⃣ PRACTICAL APPLICATION: FIND EVEN NUMBER OF DIGITS (LC 1295)");
        System.out.println("---------------------------------------------------------------");

        int[] nums = {12, 345, 2, 6, 7896, 45678, 90};
        System.out.println("Numbers: " + Arrays.toString(nums));

        int count = findEvenDigitNumbers(nums);
        System.out.println("Count of numbers with EVEN digit count: " + count);
        System.out.println();
    }

    public static int findEvenDigitNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int digits = (num == 0) ? 1 : (int)(Math.log10(Math.abs(num))) + 1;
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
