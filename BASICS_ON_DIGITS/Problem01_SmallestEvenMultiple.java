package BASICS_ON_DIGITS;

/**
 * LeetCode 2413: Smallest Even Multiple
 * URL: https://leetcode.com/problems/smallest-even-multiple/
 * 
 * Problem Statement:
 * Given a positive integer n, return the smallest positive integer that is a multiple of both 2 and n.
 * 
 * Example 1:
 * Input: n = 5
 * Output: 10
 * Explanation: The smallest multiple of both 5 and 2 is 10.
 * 
 * Example 2:
 * Input: n = 6
 * Output: 6
 * Explanation: The smallest multiple of both 6 and 2 is 6. Note that a number is a multiple of itself.
 * 
 * Constraints:
 * 1 <= n <= 150
 * 
 * Intuition & Approach:
 * - A number is a multiple of 2 if it is even (`n % 2 == 0`).
 * - If `n` is already even, the smallest common multiple of `n` and `2` is `n` itself.
 * - If `n` is odd, the smallest common multiple is `n * 2`.
 * 
 * Time Complexity: O(1) -> Constant time arithmetic operation
 * Space Complexity: O(1) -> No extra memory used
 */
public class Problem01_SmallestEvenMultiple {

    public static int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        }
        return n * 2;
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println("n = 5 -> " + smallestEvenMultiple(5)); // Expected: 10
        System.out.println("n = 6 -> " + smallestEvenMultiple(6)); // Expected: 6
    }
}
