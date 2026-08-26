package ARRAYS;

import java.util.Arrays;

/**
 * Problem 04: Count Odd Even
 * GFG URL: https://www.geeksforgeeks.org/problems/count-odd-even/1
 * 
 * Problem Statement:
 * Given an array arr[] of positive integers. The task is to return the count of odd numbers and even numbers.
 * 
 * Examples:
 * Input: arr = [1, 2, 3, 4, 5]
 * Output: [3, 2] (3 odd elements, 2 even elements)
 * 
 * Input: arr = [1, 1]
 * Output: [2, 0]
 * 
 * Constraints:
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^6
 * 
 * Intuition:
 * - Maintain two counters: `oddCount` and `evenCount`.
 * - If `num % 2 == 0` -> evenCount++
 * - Else -> oddCount++
 * - Return `int[]{oddCount, evenCount}`.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Problem04_CountOddEven {

    public static int[] countOddEven(int[] arr) {
        int oddCount = 0;
        int evenCount = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return new int[]{oddCount, evenCount};
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Odd/Even count for [1, 2, 3, 4, 5] -> " + Arrays.toString(countOddEven(arr1))); // [3, 2]

        int[] arr2 = {2, 4, 6, 8};
        System.out.println("Odd/Even count for [2, 4, 6, 8] -> " + Arrays.toString(countOddEven(arr2))); // [0, 4]
    }
}
