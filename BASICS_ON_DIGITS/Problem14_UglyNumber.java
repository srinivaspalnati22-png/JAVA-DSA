package BASICS_ON_DIGITS;

/**
 * LeetCode 263: Ugly Number
 * URL: https://leetcode.com/problems/ugly-number/
 * 
 * Problem Statement:
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * Given an integer n, return true if n is an ugly number.
 * 
 * Example 1:
 * Input: n = 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * 
 * Example 2:
 * Input: n = 1
 * Output: true
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * 
 * Example 3:
 * Input: n = 14
 * Output: false
 * Explanation: 14 is not ugly since it includes the prime factor 7.
 * 
 * Constraints:
 * -2^31 <= n <= 2^31 - 1
 * 
 * Concept Connection:
 * "Remove all 'a's from a Number using Repeated Division" (from notes)
 * - Divide out all factors of 2: while (n % 2 == 0) n /= 2;
 * - Divide out all factors of 3: while (n % 3 == 0) n /= 3;
 * - Divide out all factors of 5: while (n % 5 == 0) n /= 5;
 * - If the remaining number is 1, it only contained factors 2, 3, and 5!
 * 
 * Time Complexity: O(log2(n) + log3(n) + log5(n)) = O(log n)
 * Space Complexity: O(1)
 */
public class Problem14_UglyNumber {

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        // Divide out all 2s
        while (n % 2 == 0) {
            n /= 2;
        }

        // Divide out all 3s
        while (n % 3 == 0) {
            n /= 3;
        }

        // Divide out all 5s
        while (n % 5 == 0) {
            n /= 5;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println("n = 6 -> " + isUgly(6));   // Expected: true
        System.out.println("n = 1 -> " + isUgly(1));   // Expected: true
        System.out.println("n = 14 -> " + isUgly(14)); // Expected: false
        System.out.println("n = -6 -> " + isUgly(-6)); // Expected: false
    }
}
