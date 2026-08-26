package BASICS_ON_DIGITS;

/**
 * LeetCode 509: Fibonacci Number
 * URL: https://leetcode.com/problems/fibonacci-number/
 * 
 * Problem Statement:
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, 
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is:
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 * 
 * Example 1:
 * Input: n = 2
 * Output: 1 (F(2) = F(1) + F(0) = 1 + 0 = 1)
 * 
 * Example 2:
 * Input: n = 3
 * Output: 2 (F(3) = F(2) + F(1) = 1 + 1 = 2)
 * 
 * Example 3:
 * Input: n = 4
 * Output: 3 (F(4) = F(3) + F(2) = 2 + 1 = 3)
 * 
 * Constraints:
 * 0 <= n <= 30
 * 
 * Approaches:
 * 1. Iterative Space-Optimized (Optimal):
 *    - Maintain two variables `a` and `b` representing F(i-2) and F(i-1).
 *    - In each step: `c = a + b`, then shift `a = b`, `b = c`.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 */
public class Problem09_FibonacciNumber {

    // Optimal Iterative O(n) Time, O(1) Space
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println("F(2) = " + fib(2)); // Expected: 1
        System.out.println("F(3) = " + fib(3)); // Expected: 2
        System.out.println("F(4) = " + fib(4)); // Expected: 3
        System.out.println("F(10) = " + fib(10)); // Expected: 55
    }
}
