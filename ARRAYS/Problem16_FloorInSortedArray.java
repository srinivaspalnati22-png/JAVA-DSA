package ARRAYS;

import java.util.Arrays;

/**
 * Problem 16: Floor in a Sorted Array
 * GFG URL: https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
 * 
 * Problem Statement:
 * Given a sorted array arr[] and an integer x, find the index (0-based) of the 
 * largest element in arr[] that is less than or equal to x. This element is called 
 * the floor of x. If such an element does not exist, return -1.
 * 
 * Note:
 * In case of multiple occurrences of floor of x, return the index of the last occurrence.
 * 
 * Examples:
 * Example 1:
 * Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
 * Output: 1
 * Explanation: Largest number less than or equal to 5 is 2, whose index is 1.
 * 
 * Example 2:
 * Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 11
 * Output: 4
 * Explanation: Largest number less than or equal to 11 is 10, whose indices are 3 and 4.
 * The index of the last occurrence is 4.
 * 
 * Example 3:
 * Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 0
 * Output: -1
 * Explanation: No element less than or equal to 0 is found. So, output is -1.
 * 
 * Constraints:
 * 1 <= arr.length <= 10^6
 * 1 <= arr[i] <= 10^6
 * 0 <= x <= arr[n-1]
 * 
 * Approaches:
 * 
 * 1. Approach 1: Linear Search (Brute Force)
 *    - Traverse through the array from left to right.
 *    - While arr[i] <= x, keep updating ans = i.
 *    - As soon as arr[i] > x, break out (since array is sorted).
 *    - Returns index of the largest element <= x, and inherently the last occurrence.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Binary Search (Optimal)
 *    - Maintain `low = 0`, `high = n - 1`, and `ans = -1`.
 *    - Calculate `mid = low + (high - low) / 2`.
 *    - If `arr[mid] <= x`:
 *        - `mid` is a valid candidate for floor. Save `ans = mid`.
 *        - Since we want the largest element <= x (and its last occurrence in case of duplicates),
 *          search to the right: `low = mid + 1`.
 *    - If `arr[mid] > x`:
 *        - Elements from `mid` onward are too large.
 *        - Search to the left: `high = mid - 1`.
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 */
public class Problem16_FloorInSortedArray {

    // Approach 1: Linear Search - O(n) Time, O(1) Space
    public static int findFloorLinear(int[] arr, int x) {
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                ans = i;
            } else {
                break; // Since array is sorted, no subsequent element will be <= x
            }
        }
        return ans;
    }

    // Approach 2: Binary Search (Optimal) - O(log n) Time, O(1) Space
    public static int findFloor(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1; // Default if no element is <= x

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                ans = mid;      // Valid candidate found
                low = mid + 1;  // Look for larger element or later duplicate on the right
            } else {
                high = mid - 1; // arr[mid] > x, look on the left
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        System.out.println("Array: " + Arrays.toString(arr));

        // Test Case 1: x = 5 (Element not present)
        int x1 = 5;
        System.out.println("\nx = " + x1);
        System.out.println("Floor Index (Linear) : " + findFloorLinear(arr, x1)); // Expected: 1 (value 2)
        System.out.println("Floor Index (Binary) : " + findFloor(arr, x1));       // Expected: 1 (value 2)

        // Test Case 2: x = 11 (Between duplicates and higher element, last occurrence check)
        int x2 = 11;
        System.out.println("\nx = " + x2);
        System.out.println("Floor Index (Linear) : " + findFloorLinear(arr, x2)); // Expected: 4 (value 10, last occurrence)
        System.out.println("Floor Index (Binary) : " + findFloor(arr, x2));       // Expected: 4 (value 10, last occurrence)

        // Test Case 3: x = 0 (Smaller than smallest element)
        int x3 = 0;
        System.out.println("\nx = " + x3);
        System.out.println("Floor Index (Linear) : " + findFloorLinear(arr, x3)); // Expected: -1
        System.out.println("Floor Index (Binary) : " + findFloor(arr, x3));       // Expected: -1

        // Test Case 4: x = 10 (Exact match with duplicate elements, should return last occurrence)
        int x4 = 10;
        System.out.println("\nx = " + x4);
        System.out.println("Floor Index (Linear) : " + findFloorLinear(arr, x4)); // Expected: 4
        System.out.println("Floor Index (Binary) : " + findFloor(arr, x4));       // Expected: 4

        // Test Case 5: x = 25 (Larger than largest element)
        int x5 = 25;
        System.out.println("\nx = " + x5);
        System.out.println("Floor Index (Binary) : " + findFloor(arr, x5));       // Expected: 6 (index of 19)
    }
}
