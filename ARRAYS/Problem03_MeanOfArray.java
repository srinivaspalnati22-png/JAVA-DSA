package ARRAYS;

/**
 * Problem 03: Mean of an Array
 * GFG URL: https://www.geeksforgeeks.org/problems/mean0021/1
 * 
 * Problem Statement:
 * Given an array of n integers arr[], the task is to find the floor value of the mean of the array elements.
 * Mean = (Sum of all elements) / (Total number of elements)
 * 
 * Examples:
 * Input: arr = [56, 67, 30, 79]
 * Output: 58
 * Explanation: Sum = 56 + 67 + 30 + 79 = 232. Mean = 232 / 4 = 58.
 * 
 * Input: arr = [1, 2, 3, 4, 5]
 * Output: 3
 * Explanation: Sum = 15. Mean = 15 / 5 = 3.
 * 
 * Constraints:
 * 1 <= n <= 10^5
 * 1 <= arr[i] <= 10^5
 * 
 * Intuition:
 * - Use a `long` variable for the sum to avoid 32-bit integer overflow when n is large.
 * - Return `(int) (sum / n)`.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Problem03_MeanOfArray {

    public static int findMean(int[] arr) {
        int n = arr.length;
        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (int) (sum / n);
    }

    public static void main(String[] args) {
        int[] arr1 = {56, 67, 30, 79};
        System.out.println("Mean of [56, 67, 30, 79] -> " + findMean(arr1)); // Expected: 58

        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Mean of [1, 2, 3, 4, 5] -> " + findMean(arr2));   // Expected: 3
    }
}
