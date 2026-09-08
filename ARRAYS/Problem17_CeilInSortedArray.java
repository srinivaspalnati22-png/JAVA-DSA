package ARRAYS;

import java.util.Arrays;

/**
 * Problem 17: Ceil in a Sorted Array
 * GFG URL: https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1
 * 
 * Problem Statement:
 * Given a sorted array arr[] and an integer x, find the index (0-based) of the 
 * smallest element in arr[] that is greater than or equal to x. This element is 
 * called the ceil of x. If such an element does not exist, return -1.
 * 
 * Note:
 * In case of multiple occurrences of ceil of x, return the index of the first occurrence.
 * 
 * Examples:
 * Example 1:
 * Input: arr[] = [1, 2, 8, 10, 11, 12, 19], x = 5
 * Output: 2
 * Explanation: Smallest number greater than 5 is 8, whose index is 2.
 * 
 * Example 2:
 * Input: arr[] = [1, 2, 8, 10, 11, 12, 19], x = 20
 * Output: -1
 * Explanation: No element greater than or equal to 20 is found. So output is -1.
 * 
 * Example 3:
 * Input: arr[] = [1, 1, 2, 8, 10, 11, 12, 19], x = 0
 * Output: 0
 * Explanation: Smallest number greater than 0 is 1, whose indices are 0 and 1. 
 * The index of the first occurrence is 0.
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
 *    - As soon as we encounter an element arr[i] >= x, return its index i.
 *    - Since the array is sorted, this is guaranteed to be the smallest element >= x
 *      and also the first occurrence in case of duplicates.
 *    - If no element satisfies arr[i] >= x, return -1.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Binary Search (Optimal)
 *    - Maintain `low = 0`, `high = n - 1`, and `ans = -1`.
 *    - Calculate `mid = low + (high - low) / 2`.
 *    - If `arr[mid] >= x`:
 *        - `mid` is a valid candidate for ceil. Save `ans = mid`.
 *        - Since we want the smallest element >= x and its first occurrence in case of duplicates,
 *          we search on the left side: `high = mid - 1`.
 *    - If `arr[mid] < x`:
 *        - `arr[mid]` is too small, so elements at and before `mid` cannot be >= x.
 *        - Search on the right side: `low = mid + 1`.
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 */
public class Problem17_CeilInSortedArray {

    // Approach 1: Linear Search - O(n) Time, O(1) Space
    public static int findCeilLinear(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= x) {
                return i; // First element >= x encountered
            }
        }
        return -1; // No element >= x found
    }

    // Approach 2: Binary Search (Optimal) - O(log n) Time, O(1) Space
    public static int findCeil(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1; // Default if no element is >= x

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = mid;      // Valid candidate found
                high = mid - 1; // Look for a smaller index or first occurrence on the left
            } else {
                low = mid + 1;  // arr[mid] < x, look on the right
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 8, 10, 11, 12, 19};
        System.out.println("Array 1: " + Arrays.toString(arr1));

        // Test Case 1: x = 5 (Element not present)
        int x1 = 5;
        System.out.println("\nx = " + x1);
        System.out.println("Ceil Index (Linear) : " + findCeilLinear(arr1, x1)); // Expected: 2 (value 8)
        System.out.println("Ceil Index (Binary) : " + findCeil(arr1, x1));       // Expected: 2 (value 8)

        // Test Case 2: x = 20 (Greater than all elements)
        int x2 = 20;
        System.out.println("\nx = " + x2);
        System.out.println("Ceil Index (Linear) : " + findCeilLinear(arr1, x2)); // Expected: -1
        System.out.println("Ceil Index (Binary) : " + findCeil(arr1, x2));       // Expected: -1

        // Test Case 3: Duplicates at start with x = 0 (Smaller than all elements)
        int[] arr2 = {1, 1, 2, 8, 10, 11, 12, 19};
        System.out.println("\nArray 2: " + Arrays.toString(arr2));
        int x3 = 0;
        System.out.println("x = " + x3);
        System.out.println("Ceil Index (Linear) : " + findCeilLinear(arr2, x3)); // Expected: 0 (first occurrence of 1)
        System.out.println("Ceil Index (Binary) : " + findCeil(arr2, x3));       // Expected: 0 (first occurrence of 1)

        // Test Case 4: Multiple occurrences of exact match
        int[] arr3 = {1, 2, 8, 10, 10, 10, 12, 19};
        System.out.println("\nArray 3: " + Arrays.toString(arr3));
        int x4 = 10;
        System.out.println("x = " + x4);
        System.out.println("Ceil Index (Linear) : " + findCeilLinear(arr3, x4)); // Expected: 3 (first occurrence of 10)
        System.out.println("Ceil Index (Binary) : " + findCeil(arr3, x4));       // Expected: 3 (first occurrence of 10)

        // Test Case 5: Exact match at last element
        int x5 = 19;
        System.out.println("\nx = " + x5);
        System.out.println("Ceil Index (Linear) : " + findCeilLinear(arr3, x5)); // Expected: 7
        System.out.println("Ceil Index (Binary) : " + findCeil(arr3, x5));       // Expected: 7
    }
}
