package ARRAYS;

/**
 * Problem 01: Largest Element in Array
 * GFG URL: https://www.geeksforgeeks.org/problems/largest-element-in-array4009/1
 * 
 * Problem Statement:
 * Given an array arr[]. The task is to find the largest element and return it.
 * 
 * Examples:
 * Input: arr = [1, 8, 7, 56, 90]
 * Output: 90
 * Explanation: The largest element of given array is 90.
 * 
 * Input: arr = [5, 5, 5, 5]
 * Output: 5
 * 
 * Input: arr = [10]
 * Output: 10
 * 
 * Constraints:
 * 1 <= arr.length <= 10^5
 * 0 <= arr[i] <= 10^5
 * 
 * Intuition & Algorithm:
 * - Initialize `max = arr[0]`.
 * - Traverse from index 1 to length - 1:
 *   If `arr[i] > max`, update `max = arr[i]`.
 * - Return `max`.
 * 
 * Time Complexity: O(n) -> Single pass
 * Space Complexity: O(1)
 */
public class Problem01_LargestElement {

    public static int largest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 8, 7, 56, 90};
        System.out.println("Largest in [1, 8, 7, 56, 90] -> " + largest(arr1)); // Expected: 90

        int[] arr2 = {5, 5, 5, 5};
        System.out.println("Largest in [5, 5, 5, 5] -> " + largest(arr2));       // Expected: 5
    }
}
