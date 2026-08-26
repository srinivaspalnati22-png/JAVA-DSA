package ARRAYS;

import java.util.Arrays;

/**
 * Problem 10: Reverse an Array
 * GFG URL: https://www.geeksforgeeks.org/problems/reverse-an-array/1
 * 
 * Problem Statement:
 * You are given an array of integers arr[]. Your task is to reverse the given array in-place.
 * 
 * Examples:
 * Input: arr = [1, 4, 3, 2, 6, 5]
 * Output: [5, 6, 2, 3, 4, 1]
 * Explanation: The elements of the array are reversed.
 * 
 * Input: arr = [4, 5, 2]
 * Output: [2, 5, 4]
 * 
 * Input: arr = [1]
 * Output: [1]
 * 
 * Constraints:
 * 1 <= arr.length <= 10^5
 * 0 <= arr[i] <= 10^5
 * 
 * Intuition & Two-Pointer Approach:
 * - Place `left = 0` at the start and `right = arr.length - 1` at the end.
 * - Swap `arr[left]` and `arr[right]`.
 * - Move `left++` and `right--`.
 * - Repeat while `left < right`.
 * 
 * Time Complexity: O(n) -> Operates in n/2 swaps
 * Space Complexity: O(1) -> In-place modification
 */
public class Problem10_ReverseArray {

    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 3, 2, 6, 5};
        reverseArray(arr1);
        System.out.println("Reversed: " + Arrays.toString(arr1)); // [5, 6, 2, 3, 4, 1]

        int[] arr2 = {4, 5, 2};
        reverseArray(arr2);
        System.out.println("Reversed: " + Arrays.toString(arr2)); // [2, 5, 4]
    }
}
