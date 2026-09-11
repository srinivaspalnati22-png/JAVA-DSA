package ARRAYS;

import java.util.Arrays;

/**
 * Problem 06: Number of Occurrence
 * GFG URL: https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
 * 
 * Problem Statement:
 * Given a sorted array arr[] and a number target, find the number of occurrences of 
 * target in the given array.
 * 
 * Examples:
 * Example 1:
 * Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
 * Output: 4
 * Explanation: target = 2 occurs 4 times in the given array so the output is 4.
 * 
 * Example 2:
 * Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
 * Output: 0
 * Explanation: target = 4 is not present in the given array so the output is 0.
 * 
 * Example 3:
 * Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
 * Output: 3
 * Explanation: target = 12 occurs 3 times in the given array so the output is 3.
 * 
 * Constraints:
 * 1 <= arr.size(), arr[i], target <= 10^6
 * 
 * Approaches:
 * 
 * 1. Approach 1: Linear Scan (Brute Force)
 *    - Simply iterate through the array and count elements equal to target.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Binary Search (First and Last Occurrence) - Optimal
 *    - Find the First Occurrence (left boundary) using binary search.
 *    - If first occurrence is -1, target is absent, return 0.
 *    - Find the Last Occurrence (right boundary) using binary search.
 *    - Count = lastIndex - firstIndex + 1.
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 * 
 * 3. Approach 3: Binary Search (Upper Bound - Lower Bound) - Optimal & Elegant
 *    - lower_bound(target): First index where arr[i] >= target.
 *    - upper_bound(target): First index where arr[i] > target.
 *    - Count = upper_bound(target) - lower_bound(target).
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 */
public class Problem06_NumberOfOccurrence {

    // Approach 1: Linear Scan - O(n) Time, O(1) Space
    public static int countFreqLinear(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    // Approach 2: First and Last Occurrence Binary Search - O(log n) Time, O(1) Space
    private static int findFirstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                first = mid;
                high = mid - 1; // Keep searching left for earlier occurrence
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return first;
    }

    private static int findLastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                last = mid;
                low = mid + 1;  // Keep searching right for later occurrence
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return last;
    }

    public static int countFreq(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        if (first == -1) {
            return 0; // Target does not exist
        }
        int last = findLastOccurrence(arr, target);
        return last - first + 1;
    }

    // Approach 3: Upper Bound - Lower Bound - O(log n) Time, O(1) Space
    public static int countFreqBounds(int[] arr, int target) {
        int lb = lowerBound(arr, target);
        int ub = upperBound(arr, target);
        return ub - lb;
    }

    private static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("            GFG: Number of Occurrence in Sorted Array");
        System.out.println("===============================================================");

        // Example 1: target = 2
        int[] arr1 = {1, 1, 2, 2, 2, 2, 3};
        int target1 = 2;
        System.out.println("Test 1: arr = " + Arrays.toString(arr1) + ", target = " + target1);
        System.out.println("Linear Scan        : " + countFreqLinear(arr1, target1)); // Expected: 4
        System.out.println("Binary Search (F&L): " + countFreq(arr1, target1));       // Expected: 4
        System.out.println("Bounds (UB - LB)   : " + countFreqBounds(arr1, target1)); // Expected: 4

        // Example 2: target = 4 (not present)
        int[] arr2 = {1, 1, 2, 2, 2, 2, 3};
        int target2 = 4;
        System.out.println("\nTest 2: arr = " + Arrays.toString(arr2) + ", target = " + target2);
        System.out.println("Linear Scan        : " + countFreqLinear(arr2, target2)); // Expected: 0
        System.out.println("Binary Search (F&L): " + countFreq(arr2, target2));       // Expected: 0
        System.out.println("Bounds (UB - LB)   : " + countFreqBounds(arr2, target2)); // Expected: 0

        // Example 3: target = 12
        int[] arr3 = {8, 9, 10, 12, 12, 12};
        int target3 = 12;
        System.out.println("\nTest 3: arr = " + Arrays.toString(arr3) + ", target = " + target3);
        System.out.println("Linear Scan        : " + countFreqLinear(arr3, target3)); // Expected: 3
        System.out.println("Binary Search (F&L): " + countFreq(arr3, target3));       // Expected: 3
        System.out.println("Bounds (UB - LB)   : " + countFreqBounds(arr3, target3)); // Expected: 3

        System.out.println("===============================================================");
    }
}
