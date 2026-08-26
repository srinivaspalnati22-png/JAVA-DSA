package ARRAYS;

/**
 * Problem 07: Check if an Array is Sorted
 * GFG URL: https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1
 * 
 * Problem Statement:
 * Given an array arr[], check whether it is sorted in non-decreasing order. Return true if sorted, otherwise false.
 * 
 * Examples:
 * Input: arr = [10, 20, 30, 40, 50]
 * Output: true
 * 
 * Input: arr = [90, 80, 100, 70, 40, 30]
 * Output: false
 * 
 * Constraints:
 * 1 <= arr.length <= 10^5
 * -10^9 <= arr[i] <= 10^9
 * 
 * Intuition & Algorithm:
 * - Traverse from index 1 to length - 1:
 *   If any element `arr[i] < arr[i - 1]`, the array is not sorted -> return false.
 * - If the loop completes without violation, return true.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Problem07_CheckSorted {

    public static boolean arraySortedOrNot(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40, 50};
        System.out.println("isSorted([10, 20, 30, 40, 50]) -> " + arraySortedOrNot(arr1)); // Expected: true

        int[] arr2 = {90, 80, 100, 70, 40, 30};
        System.out.println("isSorted([90, 80, 100, 70, 40, 30]) -> " + arraySortedOrNot(arr2)); // Expected: false
    }
}
