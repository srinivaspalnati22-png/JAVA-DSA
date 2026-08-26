package BASICS_ON_DIGITS;

/**
 * LeetCode 1137: N-th Tribonacci Number
 * URL: https://leetcode.com/problems/n-th-tribonacci-number/
 * 
 * Problem Statement:
 * The Tribonacci sequence Tn is defined as follows: 
 * T0 = 0, T1 = 1, T2 = 1, and T(n+3) = T(n) + T(n+1) + T(n+2) for n >= 0.
 * Given n, return the value of Tn.
 * 
 * Example 1:
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 
 * Example 2:
 * Input: n = 25
 * Output: 1389537
 * 
 * Constraints:
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer.
 * 
 * Approach:
 * - Base cases: T(0) = 0, T(1) = 1, T(2) = 1.
 * - For n >= 3, use three running variables `a = 0`, `b = 1`, `c = 1`.
 * - In each step: `d = a + b + c`, shift `a = b`, `b = c`, `c = d`.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Problem10_TribonacciNumber {

    public static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println("T(4) = " + tribonacci(4));   // Expected: 4
        System.out.println("T(25) = " + tribonacci(25)); // Expected: 1389537
    }
}
