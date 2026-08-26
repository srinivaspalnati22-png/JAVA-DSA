package ARRAYS;

/**
 * Problem 05: Find the Frequency
 * GFG URL: https://www.geeksforgeeks.org/problems/find-the-frequency/1
 * 
 * Problem Statement:
 * Given an array arr[] of integers and an element x, find the frequency of x in the array.
 * 
 * Examples:
 * Input: arr = [1, 1, 1, 1, 1], x = 1
 * Output: 5
 * 
 * Input: arr = [1, 2, 3, 3, 2, 1, 5, 12], x = 2
 * Output: 2
 * 
 * Constraints:
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^5
 * 1 <= x <= 10^5
 * 
 * Intuition:
 * - Initialize `freq = 0`.
 * - Loop through each element. If `num == x`, increment `freq`.
 * - Return `freq`.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Problem05_FindFrequency {

    public static int findFrequency(int[] arr, int x) {
        int freq = 0;
        for (int num : arr) {
            if (num == x) {
                freq++;
            }
        }
        return freq;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 1, 1, 1};
        System.out.println("Frequency of 1 in [1, 1, 1, 1, 1] -> " + findFrequency(arr1, 1)); // Expected: 5

        int[] arr2 = {1, 2, 3, 3, 2, 1, 5, 12};
        System.out.println("Frequency of 2 in [1, 2, 3, 3, 2, 1, 5, 12] -> " + findFrequency(arr2, 2)); // Expected: 2
    }
}
