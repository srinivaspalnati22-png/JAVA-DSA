package ARRAYS;

import java.util.Arrays;

/**
 * Problem 18: Floor and Ceil in Unsorted Array
 * GFG URL: https://www.geeksforgeeks.org/problems/floor-and-ceil-in-unsorted/1
 * 
 * Problem Statement:
 * Given an unsorted array arr[] of integers and an integer x, find the floor and ceiling
 * of x in arr[].
 * 
 * - Floor of x: The largest element in arr[] which is smaller than or equal to x.
 *   Floor of x doesn't exist if x is smaller than the smallest element of arr[].
 * - Ceil of x: The smallest element in arr[] which is greater than or equal to x.
 *   Ceil of x doesn't exist if x is greater than the greatest element of arr[].
 * 
 * Return an array of two integers denoting [floor, ceil]. Return -1 for floor or ceiling
 * if they are not present.
 * 
 * Note:
 * Unlike "Floor in Sorted Array" which returns the index, this problem asks for the
 * actual values [floor, ceil].
 * 
 * Examples:
 * Example 1:
 * Input: x = 7, arr[] = [5, 6, 8, 9, 6, 5, 5, 6]
 * Output: [6, 8]
 * Explanation: Floor of 7 is 6 (largest element <= 7) and ceil of 7 is 8 (smallest element >= 7).
 * 
 * Example 2:
 * Input: x = 10, arr[] = [5, 6, 8, 8, 6, 5, 5, 6]
 * Output: [8, -1]
 * Explanation: Floor of 10 is 8, but ceil of 10 does not exist (no element >= 10).
 * 
 * Example 3:
 * Input: x = 3, arr[] = [5, 6, 8, 9]
 * Output: [-1, 5]
 * Explanation: No element <= 3, so floor is -1. Ceil is 5.
 * 
 * Constraints:
 * 1 <= arr.size() <= 10^5
 * 1 <= arr[i], x <= 10^6
 * 
 * Approaches:
 * 
 * 1. Approach 1: Sorting + Binary Search (Suboptimal for single query)
 *    - Clone and sort the array in O(n log n).
 *    - Use binary search to find floor and ceil values.
 *    - Time Complexity: O(n log n)
 *    - Space Complexity: O(n) or O(1) depending on sorting
 * 
 * 2. Approach 2: Single-Pass Linear Scan (Optimal)
 *    - Initialize floor = -1, ceil = -1.
 *    - Iterate through each element `num` in the array:
 *        a. If `num <= x`: Update floor = max(floor, num)
 *           (i.e., if floor == -1 || num > floor, floor = num).
 *        b. If `num >= x`: Update ceil = min(ceil, num)
 *           (i.e., if ceil == -1 || num < ceil, ceil = num).
 *    - Return new int[]{floor, ceil}.
 *    - Time Complexity: O(n) - single traversal
 *    - Space Complexity: O(1) - auxiliary space
 */
public class Problem18_FloorAndCeilInUnsorted {

    // Approach 1: Sorting + Binary Search - O(n log n) Time, O(n) Space
    public static int[] getFloorAndCeilSorting(int x, int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        int floor = -1;
        int ceil = -1;

        // Binary search for floor (largest element <= x)
        int low = 0, high = sorted.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sorted[mid] <= x) {
                floor = sorted[mid];
                low = mid + 1; // Look for larger value on right
            } else {
                high = mid - 1;
            }
        }

        // Binary search for ceil (smallest element >= x)
        low = 0;
        high = sorted.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sorted[mid] >= x) {
                ceil = sorted[mid];
                high = mid - 1; // Look for smaller value on left
            } else {
                low = mid + 1;
            }
        }

        return new int[]{floor, ceil};
    }

    // Approach 2: Single-Pass Linear Traversal (Optimal) - O(n) Time, O(1) Space
    public static int[] getFloorAndCeil(int x, int[] arr) {
        int floor = -1;
        int ceil = -1;

        for (int num : arr) {
            // Floor: largest element that is <= x
            if (num <= x) {
                if (floor == -1 || num > floor) {
                    floor = num;
                }
            }

            // Ceil: smallest element that is >= x
            if (num >= x) {
                if (ceil == -1 || num < ceil) {
                    ceil = num;
                }
            }
        }

        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        // Test Case 1: Standard case with both floor and ceil present
        int[] arr1 = {5, 6, 8, 9, 6, 5, 5, 6};
        int x1 = 7;
        System.out.println("Test Case 1:");
        System.out.println("Array: " + Arrays.toString(arr1) + ", x: " + x1);
        System.out.println("Optimal (Linear)  : " + Arrays.toString(getFloorAndCeil(x1, arr1)));         // Expected: [6, 8]
        System.out.println("Sorting + BS      : " + Arrays.toString(getFloorAndCeilSorting(x1, arr1)));  // Expected: [6, 8]

        // Test Case 2: x is greater than all elements (ceil does not exist)
        int[] arr2 = {5, 6, 8, 8, 6, 5, 5, 6};
        int x2 = 10;
        System.out.println("\nTest Case 2 (Ceil does not exist):");
        System.out.println("Array: " + Arrays.toString(arr2) + ", x: " + x2);
        System.out.println("Optimal (Linear)  : " + Arrays.toString(getFloorAndCeil(x2, arr2)));         // Expected: [8, -1]
        System.out.println("Sorting + BS      : " + Arrays.toString(getFloorAndCeilSorting(x2, arr2)));  // Expected: [8, -1]

        // Test Case 3: x is smaller than all elements (floor does not exist)
        int[] arr3 = {5, 6, 8, 9};
        int x3 = 3;
        System.out.println("\nTest Case 3 (Floor does not exist):");
        System.out.println("Array: " + Arrays.toString(arr3) + ", x: " + x3);
        System.out.println("Optimal (Linear)  : " + Arrays.toString(getFloorAndCeil(x3, arr3)));         // Expected: [-1, 5]
        System.out.println("Sorting + BS      : " + Arrays.toString(getFloorAndCeilSorting(x3, arr3)));  // Expected: [-1, 5]

        // Test Case 4: Exact match present in array (floor == ceil == x)
        int[] arr4 = {10, 20, 30, 40, 50};
        int x4 = 30;
        System.out.println("\nTest Case 4 (Exact match present):");
        System.out.println("Array: " + Arrays.toString(arr4) + ", x: " + x4);
        System.out.println("Optimal (Linear)  : " + Arrays.toString(getFloorAndCeil(x4, arr4)));         // Expected: [30, 30]
        System.out.println("Sorting + BS      : " + Arrays.toString(getFloorAndCeilSorting(x4, arr4)));  // Expected: [30, 30]

        // Test Case 5: Single element array
        int[] arr5 = {15};
        System.out.println("\nTest Case 5 (Single element):");
        System.out.println("Array: " + Arrays.toString(arr5) + ", x = 10: " + Arrays.toString(getFloorAndCeil(10, arr5))); // Expected: [-1, 15]
        System.out.println("Array: " + Arrays.toString(arr5) + ", x = 15: " + Arrays.toString(getFloorAndCeil(15, arr5))); // Expected: [15, 15]
        System.out.println("Array: " + Arrays.toString(arr5) + ", x = 20: " + Arrays.toString(getFloorAndCeil(20, arr5))); // Expected: [15, -1]
    }
}
