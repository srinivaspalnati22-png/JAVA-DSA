package ARRAYS;

import java.util.Arrays;

/**
 * Problem 11: Second Largest Element in Array
 * GFG URL: https://www.geeksforgeeks.org/problems/second-largest3735/1
 * 
 * Problem Statement:
 * Given an array of positive integers arr[], return the second largest element from the array.
 * If the second largest element doesn't exist then return -1.
 * 
 * Note:
 * The second largest element should not be equal to the largest element.
 * 
 * Examples:
 * Input: arr[] = [12, 35, 1, 10, 34, 1]
 * Output: 34
 * Explanation: The largest element of the array is 35 and the second largest element is 34.
 * 
 * Input: arr[] = [10, 5, 10]
 * Output: 5
 * Explanation: The largest element of the array is 10 and the second largest element is 5.
 * 
 * Input: arr[] = [10, 10, 10]
 * Output: -1
 * Explanation: The largest element of the array is 10 and the second largest element does not exist.
 * 
 * Constraints:
 * 2 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^5
 * 
 * Intuition & Approaches:
 * 1. Brute Force (Sorting):
 *    - Sort the array in ascending order: O(n log n).
 *    - Traverse from the end backwards to find the first element strictly smaller than arr[n - 1].
 *    - Time: O(n log n), Space: O(1) or O(n).
 * 
 * 2. Better Approach (Two Passes):
 *    - Pass 1: Find the maximum element `largest`.
 *    - Pass 2: Find the maximum element that is strictly less than `largest`.
 *    - Time: O(2n) = O(n), Space: O(1).
 * 
 * 3. Optimal Approach (Single Pass):
 *    - Maintain two variables: `largest = -1` and `secondLargest = -1`.
 *    - Iterate through each element `num`:
 *      - If `num > largest`:
 *          the previous `largest` becomes the new `secondLargest`,
 *          and `largest` is updated to `num`.
 *      - Else if `num < largest && num > secondLargest`:
 *          `secondLargest` is updated to `num`.
 *    - Return `secondLargest`.
 * 
 * Time Complexity: O(n) -> Single traversal
 * Space Complexity: O(1) -> Auxiliary space
 */
public class Problem11_SecondLargest {

    public static int getSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int largest = -1;
        int secondLargest = -1;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard case
        int[] arr1 = {12, 35, 1, 10, 34, 1};
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Second Largest: " + getSecondLargest(arr1)); // Expected: 34

        // Test Case 2: Array with duplicate maximums
        int[] arr2 = {10, 5, 10};
        System.out.println("\nArray: " + Arrays.toString(arr2));
        System.out.println("Second Largest: " + getSecondLargest(arr2)); // Expected: 5

        // Test Case 3: All identical elements
        int[] arr3 = {10, 10, 10};
        System.out.println("\nArray: " + Arrays.toString(arr3));
        System.out.println("Second Largest: " + getSecondLargest(arr3)); // Expected: -1

        // Test Case 4: Strictly decreasing order
        int[] arr4 = {50, 40, 30, 20, 10};
        System.out.println("\nArray: " + Arrays.toString(arr4));
        System.out.println("Second Largest: " + getSecondLargest(arr4)); // Expected: 40

        // Test Case 5: Strictly increasing order
        int[] arr5 = {1, 2, 3, 4, 5};
        System.out.println("\nArray: " + Arrays.toString(arr5));
        System.out.println("Second Largest: " + getSecondLargest(arr5)); // Expected: 4
    }
}
