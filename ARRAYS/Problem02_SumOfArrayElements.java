package ARRAYS;

/**
 * Problem 02: Sum of Array Elements
 * GFG URL: https://www.geeksforgeeks.org/problems/sum-all-array-elements/1
 * 
 * Problem Statement:
 * You are given an integer array arr[]. You need to find the sum of all elements in the array.
 * 
 * Examples:
 * Input: arr = [3, 2, 1]
 * Output: 6
 * Explanation: 3 + 2 + 1 = 6.
 * 
 * Input: arr = [-1, -2, -3, -4]
 * Output: -10
 * 
 * Constraints:
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i] <= 10^4
 * 
 * Intuition & Algorithm:
 * - Initialize `sum = 0`.
 * - Traverse through every element and add `sum += arr[i]`.
 * - Return `sum`.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Problem02_SumOfArrayElements {

    public static int sum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1};
        System.out.println("Sum of [3, 2, 1] -> " + sum(arr1)); // Expected: 6

        int[] arr2 = {-1, -2, -3, -4};
        System.out.println("Sum of [-1, -2, -3, -4] -> " + sum(arr2)); // Expected: -10
    }
}
