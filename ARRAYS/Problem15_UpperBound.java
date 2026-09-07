package ARRAYS;

import java.util.Arrays;

/**
 * Problem 15: Implement Upper Bound
 * GFG URL: https://www.geeksforgeeks.org/problems/implement-upper-bound/1
 * 
 * Problem Statement:
 * Given a sorted array arr[] and a number target, the task is to find the upper bound 
 * of the target in this given array.
 * 
 * The upper bound of a number is defined as the smallest index in the sorted array 
 * where the element is strictly greater than the given number (arr[i] > target).
 * 
 * Note:
 * If all the elements in the given array are smaller than or equal to the target, 
 * the upper bound will be the length of the array (n).
 * 
 * Examples:
 * Example 1:
 * Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
 * Output: 3
 * Explanation: 3 is the smallest index in arr[], at which element (arr[3] = 10) is > 9.
 * 
 * Example 2:
 * Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 11
 * Output: 6
 * Explanation: 6 is the smallest index in arr[], at which element (arr[6] = 25) is > 11.
 * 
 * Example 3:
 * Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 100
 * Output: 7
 * Explanation: As no element in arr[] is > 100, return the length of array (7).
 * 
 * Constraints:
 * 1 <= arr.length <= 10^6
 * 1 <= arr[i] <= 10^6
 * 1 <= target <= 10^6
 * 
 * Approaches:
 * 
 * 1. Approach 1: Linear Search (Brute Force)
 *    - Traverse array sequentially from index 0 to n-1.
 *    - Return the first index where arr[i] > target.
 *    - If no such element exists, return arr.length.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Binary Search (Optimal)
 *    - Initialize `low = 0`, `high = n - 1`, and `ans = n`.
 *    - In each iteration, calculate `mid = low + (high - low) / 2`.
 *    - If `arr[mid] > target`:
 *        - `mid` is a valid candidate for upper bound. Save `ans = mid`.
 *        - Try to find a smaller valid index by narrowing search to left: `high = mid - 1`.
 *    - If `arr[mid] <= target`:
 *        - Elements up to `mid` are not strictly greater than `target`.
 *        - Move search range to the right: `low = mid + 1`.
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 */
public class Problem15_UpperBound {

    // Approach 1: Linear Search - O(n) Time, O(1) Space
    public static int upperBoundLinear(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target) {
                return i;
            }
        }
        return arr.length;
    }

    // Approach 2: Binary Search (Optimal) - O(log n) Time, O(1) Space
    public static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // Default if no element is > target

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                ans = mid;         // Candidate found
                high = mid - 1;    // Check for smaller index on the left
            } else {
                low = mid + 1;     // Element <= target, look on the right
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        System.out.println("Array: " + Arrays.toString(arr));

        // Test Case 1: target = 9
        int target1 = 9;
        System.out.println("\nTarget: " + target1);
        System.out.println("Upper Bound (Linear) : " + upperBoundLinear(arr, target1)); // Expected: 3
        System.out.println("Upper Bound (Binary) : " + upperBound(arr, target1));       // Expected: 3

        // Test Case 2: target = 11 (Duplicate values, should find index after last 11)
        int target2 = 11;
        System.out.println("\nTarget: " + target2);
        System.out.println("Upper Bound (Linear) : " + upperBoundLinear(arr, target2)); // Expected: 6
        System.out.println("Upper Bound (Binary) : " + upperBound(arr, target2));       // Expected: 6

        // Test Case 3: target = 100 (Greater than all elements)
        int target3 = 100;
        System.out.println("\nTarget: " + target3);
        System.out.println("Upper Bound (Linear) : " + upperBoundLinear(arr, target3)); // Expected: 7 (length)
        System.out.println("Upper Bound (Binary) : " + upperBound(arr, target3));       // Expected: 7 (length)

        // Test Case 4: target = 1 (Smaller than all elements)
        int target4 = 1;
        System.out.println("\nTarget: " + target4);
        System.out.println("Upper Bound (Linear) : " + upperBoundLinear(arr, target4)); // Expected: 0
        System.out.println("Upper Bound (Binary) : " + upperBound(arr, target4));       // Expected: 0

        // Test Case 5: target = 25 (Equal to max element)
        int target5 = 25;
        System.out.println("\nTarget: " + target5);
        System.out.println("Upper Bound (Binary) : " + upperBound(arr, target5));       // Expected: 7
    }
}
