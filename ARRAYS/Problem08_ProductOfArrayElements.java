package ARRAYS;

/**
 * Problem 08: Product of Array Elements
 * GFG URL: https://www.geeksforgeeks.org/problems/product-of-array-element/1
 * 
 * Problem Statement:
 * Given an array of integers arr[], return the product of all the elements of the array.
 * Note: Since the result can be large, return the product modulo mod (e.g., 10^9 + 7 or as required).
 * 
 * Examples:
 * Input: arr = [1, 2, 3, 4]
 * Output: 24
 * Explanation: 1 * 2 * 3 * 4 = 24
 * 
 * Input: arr = [100000, 100000]
 * Output: Modulo result
 * 
 * Constraints:
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^5
 * 
 * Intuition & Algorithm:
 * - Initialize `prod = 1L`.
 * - For each number: `prod = (prod * num) % MOD`.
 * - Return `prod`.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Problem08_ProductOfArrayElements {

    public static long product(int[] arr, long mod) {
        long prod = 1;
        for (int num : arr) {
            prod = (prod * num) % mod;
        }
        return prod;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        long mod = 1000000007L;
        System.out.println("Product of [1, 2, 3, 4] -> " + product(arr1, mod)); // Expected: 24
    }
}
