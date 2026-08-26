package BASICS_ON_DIGITS;

/**
 * LeetCode 507: Perfect Number
 * URL: https://leetcode.com/problems/perfect-number/
 * 
 * Problem Statement:
 * A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself.
 * A divisor of an integer x is an integer that can divide x evenly.
 * Given an integer n, return true if n is a perfect number, otherwise return false.
 * 
 * Example 1:
 * Input: num = 28
 * Output: true
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14 (1, 2, 4, 7, 14 are proper divisors).
 * 
 * Example 2:
 * Input: num = 7
 * Output: false
 * 
 * Constraints:
 * 1 <= num <= 10^8
 * 
 * Approaches:
 * 1. Brute Force (User Solution):
 *    - Check every integer from 1 to num-1.
 *    - Time Complexity: O(num) -> TLE for num = 10^8.
 * 
 * 2. Optimized Divisor Pairing (Optimal O(sqrt(num))):
 *    - Divisors always come in pairs: if `d` divides `num`, then `num / d` also divides `num`.
 *    - Loop `i` from `2` up to `sqrt(num)`.
 *    - If `num % i == 0`:
 *        add `i`, and if `i != num / i`, also add `num / i`.
 *    - Start with `sum = 1` (since 1 divides all positive numbers > 1).
 *    - Time Complexity: O(sqrt(num))
 *    - Space Complexity: O(1)
 */
public class Problem21_PerfectNumber {

    // Approach 1: Brute Force
    public static boolean checkPerfectNumberBrute(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return num == sum;
    }

    // Approach 2: Optimal O(sqrt(n)) Divisor Sum
    public static boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;

        int sum = 1; // 1 is always a proper divisor
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }

        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println("num = 28 -> " + checkPerfectNumber(28)); // Expected: true
        System.out.println("num = 7 -> " + checkPerfectNumber(7));   // Expected: false
        System.out.println("num = 496 -> " + checkPerfectNumber(496)); // Expected: true
        System.out.println("num = 8128 -> " + checkPerfectNumber(8128)); // Expected: true
    }
}
