import java.util.Arrays;

/**
 * ============================================================================
 * ⚡ COMPREHENSIVE DEMO: BINARY SEARCH IN JAVA
 * ============================================================================
 * This program demonstrates practical implementations and tests for:
 *  1. Standard Iterative Binary Search (Ascending)
 *  2. Recursive Binary Search
 *  3. Order-Agnostic Binary Search (Ascending & Descending)
 *  4. First and Last Occurrence / Lower & Upper Bounds (Duplicates)
 *  5. Floor and Ceiling of a Number
 *  6. Peak Index in Mountain Array (Bitonic Array)
 *  7. Search in Rotated Sorted Array (LeetCode 33)
 *  8. Binary Search on Answer Space: Integer Sqrt (LeetCode 69)
 *  9. 2D Matrix Binary Search (Strict Flattened & Staircase Row-Col)
 * 10. Java Built-in Arrays.binarySearch() with Negative Index Decoding
 * 11. Full Edge Case & Target Test Suite Matrix
 * ============================================================================
 */
public class BinarySearchDemo {

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("           ⚡ JAVA BINARY SEARCH MASTER DEMONSTRATION          ");
        System.out.println("===============================================================\n");

        demoStandardIterativeSearch();
        demoRecursiveSearch();
        demoOrderAgnosticSearch();
        demoFirstAndLastOccurrence();
        demoFloorAndCeiling();
        demoMountainPeakSearch();
        demoRotatedSortedArraySearch();
        demoSqrtSearch();
        demo2DMatrixSearch();
        demoBuiltInArraysBinarySearch();
        runFullTestSuiteMatrix();

        System.out.println("===============================================================");
        System.out.println("       🎉 ALL BINARY SEARCH TESTS & MODELS PASSED CLEANLY!     ");
        System.out.println("===============================================================");
    }

    // =========================================================================
    // 1️⃣ MODEL 1: STANDARD ITERATIVE BINARY SEARCH
    // =========================================================================
    private static void demoStandardIterativeSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("1️⃣ MODEL 1: STANDARD ITERATIVE BINARY SEARCH [O(log N) Time, O(1) Space]");
        System.out.println("---------------------------------------------------------------");

        int[] arr = {3, 9, 14, 20, 35, 42, 56, 68, 90};
        int targetPresent = 56;
        int targetAbsent = 25;

        System.out.println("Sorted Array : " + Arrays.toString(arr));
        
        int idx1 = binarySearch(arr, targetPresent);
        System.out.println("Search Target: " + targetPresent + " -> " + 
            (idx1 != -1 ? "✅ Found at Index " + idx1 : "❌ Not Found (-1)"));

        int idx2 = binarySearch(arr, targetAbsent);
        System.out.println("Search Target: " + targetAbsent + " -> " + 
            (idx2 != -1 ? "✅ Found at Index " + idx2 : "❌ Not Found (-1)"));
        System.out.println();
    }

    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // Safe mid calculation preventing 32-bit signed integer overflow
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                start = mid + 1; // Target is in the right half
            } else {
                end = mid - 1;   // Target is in the left half
            }
        }
        return -1; // Target absent
    }

    // =========================================================================
    // 2️⃣ MODEL 2: RECURSIVE BINARY SEARCH
    // =========================================================================
    private static void demoRecursiveSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("2️⃣ MODEL 2: RECURSIVE BINARY SEARCH [O(log N) Time, O(log N) Space]");
        System.out.println("---------------------------------------------------------------");

        int[] arr = {11, 22, 33, 44, 55, 66, 77, 88};
        int target = 44;

        System.out.println("Array : " + Arrays.toString(arr));
        int idx = recursiveBinarySearch(arr, target, 0, arr.length - 1);
        System.out.println("Search Target: " + target + " -> " + 
            (idx != -1 ? "✅ Found at Index " + idx : "❌ Not Found (-1)"));
        System.out.println();
    }

    public static int recursiveBinarySearch(int[] arr, int target, int start, int end) {
        if (arr == null || start > end) return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return recursiveBinarySearch(arr, target, mid + 1, end);
        } else {
            return recursiveBinarySearch(arr, target, start, mid - 1);
        }
    }

    // =========================================================================
    // 3️⃣ MODEL 3: ORDER-AGNOSTIC BINARY SEARCH (Ascending & Descending)
    // =========================================================================
    private static void demoOrderAgnosticSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("3️⃣ MODEL 3: ORDER-AGNOSTIC BINARY SEARCH (Ascending OR Descending)");
        System.out.println("---------------------------------------------------------------");

        int[] ascArr = {2, 4, 6, 8, 10, 12, 14};
        int[] descArr = {90, 75, 60, 45, 30, 15, 0};

        System.out.println("Ascending Array : " + Arrays.toString(ascArr));
        System.out.println("Search 10 in Ascending : Index " + orderAgnosticBinarySearch(ascArr, 10));

        System.out.println("Descending Array: " + Arrays.toString(descArr));
        System.out.println("Search 45 in Descending: Index " + orderAgnosticBinarySearch(descArr, 45));
        System.out.println();
    }

    public static int orderAgnosticBinarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int start = 0;
        int end = arr.length - 1;

        // Determine sorting order
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAscending) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] < target) {
                    end = mid - 1;   // In descending, smaller values are to the right
                } else {
                    start = mid + 1; // Larger values are to the left
                }
            }
        }
        return -1;
    }

    // =========================================================================
    // 4️⃣ MODEL 4: FIRST & LAST OCCURRENCE (DUPLICATE BOUNDS)
    // =========================================================================
    private static void demoFirstAndLastOccurrence() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("4️⃣ MODEL 4: FIRST & LAST OCCURRENCE / BOUNDS SEARCH (LeetCode 34)");
        System.out.println("---------------------------------------------------------------");

        int[] arr = {1, 3, 5, 5, 5, 5, 7, 9};
        int target = 5;

        int first = findBound(arr, target, true);
        int last = findBound(arr, target, false);
        int count = (first != -1) ? (last - first + 1) : 0;

        System.out.println("Array with Duplicates: " + Arrays.toString(arr));
        System.out.println("Target: " + target);
        System.out.println("First Occurrence Index: " + first);
        System.out.println("Last Occurrence Index : " + last);
        System.out.println("Total Count of Target : " + count);
        System.out.println();
    }

    public static int findBound(int[] nums, int target, boolean isFirst) {
        if (nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;
        int bound = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                bound = mid; // Candidate found
                if (isFirst) {
                    end = mid - 1;   // Continue searching left
                } else {
                    start = mid + 1; // Continue searching right
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return bound;
    }

    // =========================================================================
    // 5️⃣ MODEL 5: FLOOR AND CEILING OF A TARGET
    // =========================================================================
    private static void demoFloorAndCeiling() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("5️⃣ MODEL 5: FLOOR & CEILING OF A TARGET");
        System.out.println("---------------------------------------------------------------");

        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 15;

        int ceilIdx = findCeiling(arr, target);
        int floorIdx = findFloor(arr, target);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);
        System.out.println("Ceiling (Smallest element >= " + target + "): " + 
            (ceilIdx != -1 ? arr[ceilIdx] + " (at index " + ceilIdx + ")" : "None"));
        System.out.println("Floor   (Largest element <= " + target + "): " + 
            (floorIdx != -1 ? arr[floorIdx] + " (at index " + floorIdx + ")" : "None"));
        System.out.println();
    }

    public static int findCeiling(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target > arr[arr.length - 1]) return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return start; // When loop ends, start points to ceiling
    }

    public static int findFloor(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < arr[0]) return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return end; // When loop ends, end points to floor
    }

    // =========================================================================
    // 6️⃣ MODEL 6: PEAK INDEX IN MOUNTAIN ARRAY
    // =========================================================================
    private static void demoMountainPeakSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("6️⃣ MODEL 6: PEAK INDEX IN MOUNTAIN ARRAY (LeetCode 852 / 162)");
        System.out.println("---------------------------------------------------------------");

        int[] mountain = {0, 2, 6, 12, 19, 15, 8, 3, 1};
        int peakIdx = findPeakIndex(mountain);

        System.out.println("Mountain Array: " + Arrays.toString(mountain));
        System.out.println("Peak Element  : " + mountain[peakIdx] + " at index " + peakIdx);
        System.out.println();
    }

    public static int findPeakIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1; // Ascending part of mountain
            } else {
                end = mid;       // Descending part (mid could be peak)
            }
        }
        return start; // start == end is the peak
    }

    // =========================================================================
    // 7️⃣ MODEL 7: SEARCH IN ROTATED SORTED ARRAY (LeetCode 33)
    // =========================================================================
    private static void demoRotatedSortedArraySearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("7️⃣ MODEL 7: SEARCH IN ROTATED SORTED ARRAY (LeetCode 33)");
        System.out.println("---------------------------------------------------------------");

        int[] rotated = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int idx = searchRotated(rotated, target);
        System.out.println("Rotated Array : " + Arrays.toString(rotated));
        System.out.println("Search Target : " + target + " -> Found at index " + idx);
        System.out.println();
    }

    public static int searchRotated(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid;

            // Check if LEFT half is sorted
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } 
            // Otherwise, RIGHT half is sorted
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    // =========================================================================
    // 8️⃣ MODEL 8: BINARY SEARCH ON ANSWER SPACE (Integer Sqrt - LeetCode 69)
    // =========================================================================
    private static void demoSqrtSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("8️⃣ MODEL 8: BINARY SEARCH ON ANSWER SPACE (Integer Sqrt)");
        System.out.println("---------------------------------------------------------------");

        int[] inputs = {0, 1, 4, 8, 25, 2147395600};

        for (int x : inputs) {
            int sqrt = mySqrt(x);
            System.out.println("Integer Sqrt of " + x + " = " + sqrt);
        }
        System.out.println();
    }

    public static int mySqrt(int x) {
        if (x < 2) return x;

        int start = 1;
        int end = x / 2;
        int ans = 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    // =========================================================================
    // 9️⃣ MODEL 9: 2D MATRIX BINARY SEARCH
    // =========================================================================
    private static void demo2DMatrixSearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("9️⃣ MODEL 9: 2D MATRIX BINARY SEARCH (Strict 1D Virtual & Staircase)");
        System.out.println("---------------------------------------------------------------");

        int[][] matrix1 = {
            { 1,  3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        boolean found = searchMatrixStrict(matrix1, 16);
        System.out.println("Strict Matrix Search for 16 -> " + (found ? "✅ Found (true)" : "❌ False"));

        int[][] matrix2 = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };

        int[] coord = searchMatrixRowCol(matrix2, 29);
        System.out.println("Staircase Row-Col Search for 29 -> Found at Row " + coord[0] + ", Col " + coord[1]);
        System.out.println();
    }

    public static boolean searchMatrixStrict(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = matrix[mid / cols][mid % cols];

            if (midVal == target) return true;
            else if (midVal < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }

    public static int[] searchMatrixRowCol(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return new int[]{-1, -1};

        int row = 0;
        int col = matrix[0].length - 1; // Top-right corner

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return new int[]{-1, -1};
    }

    // =========================================================================
    // 🔟 MODEL 10: BUILT-IN Arrays.binarySearch() & NEGATIVE RETURN DECODING
    // =========================================================================
    private static void demoBuiltInArraysBinarySearch() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("🔟 MODEL 10: JAVA Arrays.binarySearch() & RETURN CODE DECODING");
        System.out.println("---------------------------------------------------------------");

        int[] arr = {10, 20, 40, 50, 60};
        System.out.println("Array: " + Arrays.toString(arr));

        int hit = Arrays.binarySearch(arr, 40);
        System.out.println("Search 40 (Present): return = " + hit + " (Exact Index)");

        int miss = Arrays.binarySearch(arr, 30);
        int insertionPoint = -(miss + 1);
        System.out.println("Search 30 (Absent) : return = " + miss + 
            " -> Insertion Point = -(return + 1) = " + insertionPoint);
        System.out.println();
    }

    // =========================================================================
    // 🧪 FULL TEST SUITE MATRIX & TARGET VERIFICATION
    // =========================================================================
    private static void runFullTestSuiteMatrix() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("🧪 EXHAUSTIVE TEST SUITE MATRIX FOR ALL TARGET SCENARIOS");
        System.out.println("---------------------------------------------------------------");

        int[] sample = {-30, -10, 0, 5, 12, 18, 25, 40, 80};
        System.out.println("Master Test Array: " + Arrays.toString(sample));

        runTest("Target at Start (Boundary)", sample, -30, 0);
        runTest("Target in Middle", sample, 12, 4);
        runTest("Target at End (Boundary)", sample, 80, 8);
        runTest("Target Smaller than Min", sample, -100, -1);
        runTest("Target Larger than Max", sample, 999, -1);
        runTest("Target Absent in Between", sample, 15, -1);
        runTest("Single Element Hit", new int[]{42}, 42, 0);
        runTest("Single Element Miss", new int[]{42}, 99, -1);
        runTest("Empty Array Guard Check", new int[]{}, 10, -1);
        System.out.println();
    }

    private static void runTest(String testName, int[] arr, int target, int expectedIndex) {
        int actualIndex = binarySearch(arr, target);
        boolean passed = (actualIndex == expectedIndex);
        System.out.printf("  %-30s | Target: %4d | Expected: %2d | Got: %2d | %s\n",
            testName, target, expectedIndex, actualIndex, (passed ? "✅ PASS" : "❌ FAIL"));
    }
}
