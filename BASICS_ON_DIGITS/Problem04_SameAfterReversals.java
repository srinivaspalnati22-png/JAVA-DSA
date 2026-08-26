package BASICS_ON_DIGITS;

/**
 * LeetCode 2119: A Number After a Double Reversal
 * URL: https://leetcode.com/problems/a-number-after-a-double-reversal/
 * 
 * Problem Statement:
 * Reversing an integer means to reverse all its digits.
 * For example, reversing 2021 gives 1202. Reversing 12300 gives 321 as leading zeros are dropped.
 * Given an integer num, reverse num to get reversed1, then reverse reversed1 to get reversed2.
 * Return true if reversed2 equals num. Otherwise return false.
 * 
 * Example 1:
 * Input: num = 526
 * Output: true
 * Explanation: 526 -> 625 -> 526 == 526.
 * 
 * Example 2:
 * Input: num = 1800
 * Output: false
 * Explanation: 1800 -> 81 -> 18 != 1800 (trailing zeros are lost!).
 * 
 * Example 3:
 * Input: num = 0
 * Output: true
 * 
 * Constraints:
 * 0 <= num <= 10^6
 * 
 * Approaches:
 * 1. Double Reversal Simulation (User Solution):
 *    - Explicitly reverse twice and check equality.
 *    - Time Complexity: O(log10(num))
 * 
 * 2. Mathematical Observation (Optimal O(1)):
 *    - The only time digits are lost during reversal is when there are **trailing zeros** (e.g., 1800 ends in 0).
 *    - The only exception is `num = 0` itself.
 *    - Hence: `num == 0 || num % 10 != 0`
 *    - Time Complexity: O(1)
 */
public class Problem04_SameAfterReversals {

    // Approach 1: Reversal Simulation
    private static int reverse(int num) {
        int rev = 0;
        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num = num / 10;
        }
        return rev;
    }

    public static boolean isSameAfterReversals(int num) {
        return num == reverse(reverse(num));
    }

    // Approach 2: O(1) Check for Trailing Zeroes
    public static boolean isSameAfterReversalsOptimal(int num) {
        return num == 0 || num % 10 != 0;
    }

    public static void main(String[] args) {
        System.out.println("num = 526 -> " + isSameAfterReversals(526));   // Expected: true
        System.out.println("num = 1800 -> " + isSameAfterReversals(1800)); // Expected: false
        System.out.println("num = 0 -> " + isSameAfterReversals(0));       // Expected: true
        System.out.println("num = 1800 (Optimal) -> " + isSameAfterReversalsOptimal(1800)); // Expected: false
    }
}
