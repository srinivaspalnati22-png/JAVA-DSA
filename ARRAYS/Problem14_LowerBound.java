package ARRAYS;

import java.util.Arrays;

/**
 * Problem 14: Implement Lower Bound
 * GFG URL: https://www.geeksforgeeks.org/problems/implement-lower-bound/1
 * 
 * Problem Statement:
 * Given a sorted array arr[] (following 0-based indexing) and a number target, 
 * find the lower bound of the target in this given array.
 * 
 * The lower bound of a number is defined as the smallest index in the sorted array 
 * where the element is greater than or equal to the given number (arr[i] >= target).
 * 
 * Note:
 * If all the elements in the given array are smaller than the target, 
 * the lower bound will be the length of the array (n).
 * 
 * Examples:
 * Example 1:
 * Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
 * Output: 3
 * Explanation: 3 is the smallest index in arr[] where element (arr[3] = 10) is >= 9.
 * 
 * Example 2:
 * Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 11
 * Output: 4
 * Explanation: 4 is the smallest index in arr[] where element (arr[4] = 11) is >= 11.
 * 
 * Example 3:
 * Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 100
 * Output: 7
 * Explanation: As no element in arr[] is >= 100, return the length of array (7).
 * 
 * Constraints:
 * 1 <= arr.length <= 10^6
 * 1 <= arr[i] <= 10^6
 * 1 <= target <= 10^6
 * 
 * Approaches:
 * 
 * 1. Approach 1: Linear Search (Brute Force)
 *    - Traverse from index 0 to n-1.
 *    - The first index where arr[i] >= target is our answer.
 *    - If no such element is found, return arr.length.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Binary Search (Optimal)
 *    - Since the array is sorted, we can divide the search space in half each step.
 *    - Maintain `low = 0`, `high = n - 1`, and `ans = n`.
 *    - At each step, calculate `mid = low + (high - low) / 2`.
 *    - If `arr[mid] >= target`:
 *        - `mid` is a valid candidate. Save `ans = mid`.
 *        - Since we want the smallest index, check if there is an even smaller valid index
 *          to the left by setting `high = mid - 1`.
 *    - If `arr[mid] < target`:
 *        - `arr[mid]` is too small, so any index <= mid cannot be >= target.
 *        - Search the right half by setting `low = mid + 1`.
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 */
public class Problem14_LowerBound {

    // Approach 1: Linear Search - O(n) Time, O(1) Space
    public static int lowerBoundLinear(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }
        return arr.length;
    }

    // Approach 2: Binary Search (Optimal) - O(log n) Time, O(1) Space
    public static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // Default if no element is >= target

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = mid;         // Candidate found
                high = mid - 1;    // Look for smaller index on the left
            } else {
                low = mid + 1;     // Look on the right
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
        System.out.println("Lower Bound (Linear) : " + lowerBoundLinear(arr, target1)); // Expected: 3
        System.out.println("Lower Bound (Binary) : " + lowerBound(arr, target1));       // Expected: 3

        // Test Case 2: target = 11 (Duplicate values)
        int target2 = 11;
        System.out.println("\nTarget: " + target2);
        System.out.println("Lower Bound (Linear) : " + lowerBoundLinear(arr, target2)); // Expected: 4
        System.out.println("Lower Bound (Binary) : " + lowerBound(arr, target2));       // Expected: 4

        // Test Case 3: target = 100 (Greater than all elements)
        int target3 = 100;
        System.out.println("\nTarget: " + target3);
        System.out.println("Lower Bound (Linear) : " + lowerBoundLinear(arr, target3)); // Expected: 7 (length)
        System.out.println("Lower Bound (Binary) : " + lowerBound(arr, target3));       // Expected: 7 (length)

        // Test Case 4: target = 1 (Smaller than all elements)
        int target4 = 1;
        System.out.println("\nTarget: " + target4);
        System.out.println("Lower Bound (Linear) : " + lowerBoundLinear(arr, target4)); // Expected: 0
        System.out.println("Lower Bound (Binary) : " + lowerBound(arr, target4));       // Expected: 0

        // Test Case 5: Exact match at first element
        int target5 = 2;
        System.out.println("\nTarget: " + target5);
        System.out.println("Lower Bound (Binary) : " + lowerBound(arr, target5));       // Expected: 0
    }
}
