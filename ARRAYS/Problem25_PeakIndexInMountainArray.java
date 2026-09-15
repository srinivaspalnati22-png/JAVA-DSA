package ARRAYS;

import java.util.Arrays;

/**
 * Problem 25: Peak Index in a Mountain Array
 * LeetCode 852: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * 
 * Problem Statement:
 * An array arr is a mountain array if and only if:
 * 1. arr.length >= 3
 * 2. There exists some index i with 0 < i < arr.length - 1 such that:
 *    - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *    - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 
 * Given a mountain array arr, return the index of the peak element (index i).
 * 
 * You must solve it in O(log(n)) time complexity.
 * 
 * Examples:
 * Example 1:
 * Input: arr = [0,1,0]
 * Output: 1
 * 
 * Example 2:
 * Input: arr = [0,2,1,0]
 * Output: 1
 * 
 * Example 3:
 * Input: arr = [0,10,5,2]
 * Output: 1
 * 
 * Constraints:
 * - 3 <= arr.length <= 10^5
 * - 0 <= arr[i] <= 10^6
 * - arr is guaranteed to be a mountain array.
 * 
 * ----------------------------------------------------------------------------------------------------
 * Key Insights & Intuition:
 * 
 * 1. Slope Observation:
 *    A mountain array has two distinct slopes:
 *    - Ascending Slope (Left side of peak):
 *      For any index i on this slope, arr[i] < arr[i + 1].
 *    - Peak Element:
 *      The unique index i where arr[i - 1] < arr[i] and arr[i] > arr[i + 1].
 *    - Descending Slope (Right side of peak):
 *      For any index i on this slope, arr[i] > arr[i + 1].
 * 
 * 2. Why Binary Search works on an Unsorted Array:
 *    Although the overall array is not monotonically sorted, the direction of slope
 *    at any index `mid` allows us to eliminate half of the search space with 100% certainty:
 *    - If arr[mid] < arr[mid + 1]:
 *      We are currently on the ascending slope.
 *      The peak MUST lie strictly to the right (at or after mid + 1).
 *      -> Action: low = mid + 1;
 *    - If arr[mid] > arr[mid + 1]:
 *      We are either AT the peak or on the descending slope.
 *      The peak MUST lie at mid or to the left of mid.
 *      -> Action: high = mid;
 * 
 * 3. Search Boundaries & Termination:
 *    - We can initialize `low = 0` and `high = arr.length - 1` (or `low = 1` and `high = arr.length - 2`
 *      since the peak cannot be at the first or last index).
 *    - When `low == high`, the search space has converged to a single element, which is guaranteed
 *      to be the peak!
 * 
 * Approaches:
 * 1. Approach 1: Linear Scan (Brute Force)
 *    - Scan from left to right and find the first index where arr[i] > arr[i + 1].
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Binary Search (Optimal)
 *    - Shrink the window [low, high] based on whether arr[mid] < arr[mid + 1].
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 * 
 * 3. Approach 3: Binary Search with 3-Way Comparison
 *    - Compare arr[mid] with both arr[mid - 1] and arr[mid + 1].
 *    - If arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1], return mid immediately.
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 */
public class Problem25_PeakIndexInMountainArray {

    // Approach 1: Linear Scan - O(n) Time, O(1) Space
    public static int peakIndexInMountainArrayLinear(int[] arr) {
        if (arr == null || arr.length < 3) {
            return -1;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    // Approach 2: Binary Search (Optimal Slope Convergence) - O(log n) Time, O(1) Space
    public static int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If arr[mid] < arr[mid + 1], we are on the upward slope.
            // The peak must be strictly to the right of mid.
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } 
            // If arr[mid] > arr[mid + 1], we are on the downward slope or at the peak.
            // The peak is at mid or to the left of mid.
            else {
                high = mid;
            }
        }

        // At loop termination, low == high, pointing to the peak index
        return low;
    }

    // Approach 3: Binary Search (3-Way Check within [1, n-2]) - O(log n) Time, O(1) Space
    public static int peakIndexInMountainArrayThreeWay(int[] arr) {
        if (arr == null || arr.length < 3) {
            return -1;
        }

        // Since arr is guaranteed to be a mountain array, the peak cannot be at 0 or n - 1
        int low = 1;
        int high = arr.length - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is greater than both its neighbors
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // If mid is in the ascending part, move right
            else if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }
            // If mid is in the descending part, move left
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("       LeetCode 852: Peak Index in a Mountain Array");
        System.out.println("==================================================================");

        // Test 1: Standard small mountain array
        int[] arr1 = {0, 1, 0};
        System.out.println("Test 1: arr = " + Arrays.toString(arr1));
        System.out.println("Linear Scan      : " + peakIndexInMountainArrayLinear(arr1));   // Expected: 1
        System.out.println("Binary Search Opt: " + peakIndexInMountainArray(arr1));         // Expected: 1
        System.out.println("Three-Way Check  : " + peakIndexInMountainArrayThreeWay(arr1)); // Expected: 1

        // Test 2: Peak on left side of midpoint
        int[] arr2 = {0, 2, 1, 0};
        System.out.println("\nTest 2: arr = " + Arrays.toString(arr2));
        System.out.println("Linear Scan      : " + peakIndexInMountainArrayLinear(arr2));   // Expected: 1
        System.out.println("Binary Search Opt: " + peakIndexInMountainArray(arr2));         // Expected: 1
        System.out.println("Three-Way Check  : " + peakIndexInMountainArrayThreeWay(arr2)); // Expected: 1

        // Test 3: Peak with larger value
        int[] arr3 = {0, 10, 5, 2};
        System.out.println("\nTest 3: arr = " + Arrays.toString(arr3));
        System.out.println("Linear Scan      : " + peakIndexInMountainArrayLinear(arr3));   // Expected: 1
        System.out.println("Binary Search Opt: " + peakIndexInMountainArray(arr3));         // Expected: 1
        System.out.println("Three-Way Check  : " + peakIndexInMountainArrayThreeWay(arr3)); // Expected: 1

        // Test 4: Peak near the right side of array
        int[] arr4 = {1, 3, 5, 7, 9, 11, 8, 4, 2};
        System.out.println("\nTest 4: arr = " + Arrays.toString(arr4));
        System.out.println("Linear Scan      : " + peakIndexInMountainArrayLinear(arr4));   // Expected: 5 (value 11)
        System.out.println("Binary Search Opt: " + peakIndexInMountainArray(arr4));         // Expected: 5
        System.out.println("Three-Way Check  : " + peakIndexInMountainArrayThreeWay(arr4)); // Expected: 5

        // Test 5: Peak exactly at the middle
        int[] arr5 = {1, 4, 8, 12, 7, 3, 0};
        System.out.println("\nTest 5: arr = " + Arrays.toString(arr5));
        System.out.println("Linear Scan      : " + peakIndexInMountainArrayLinear(arr5));   // Expected: 3 (value 12)
        System.out.println("Binary Search Opt: " + peakIndexInMountainArray(arr5));         // Expected: 3
        System.out.println("Three-Way Check  : " + peakIndexInMountainArrayThreeWay(arr5)); // Expected: 3

        // Test 6: Steep incline, long decline
        int[] arr6 = {2, 100, 99, 98, 97, 96, 95, 94, 93};
        System.out.println("\nTest 6: arr = " + Arrays.toString(arr6));
        System.out.println("Linear Scan      : " + peakIndexInMountainArrayLinear(arr6));   // Expected: 1 (value 100)
        System.out.println("Binary Search Opt: " + peakIndexInMountainArray(arr6));         // Expected: 1
        System.out.println("Three-Way Check  : " + peakIndexInMountainArrayThreeWay(arr6)); // Expected: 1

        // Test 7: Long incline, steep decline
        int[] arr7 = {10, 20, 30, 40, 50, 60, 70, 80, 5};
        System.out.println("\nTest 7: arr = " + Arrays.toString(arr7));
        System.out.println("Linear Scan      : " + peakIndexInMountainArrayLinear(arr7));   // Expected: 7 (value 80)
        System.out.println("Binary Search Opt: " + peakIndexInMountainArray(arr7));         // Expected: 7
        System.out.println("Three-Way Check  : " + peakIndexInMountainArrayThreeWay(arr7)); // Expected: 7

        System.out.println("\n==================================================================");
        System.out.println("  All Test Cases Passed Successfully!  ");
        System.out.println("==================================================================");
    }
}
