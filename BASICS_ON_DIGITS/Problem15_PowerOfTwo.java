package BASICS_ON_DIGITS;

/**
 * LeetCode 231: Power of Two
 * URL: https://leetcode.com/problems/power-of-two/
 * 
 * Problem Statement:
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2^x.
 * 
 * Example 1:
 * Input: n = 1
 * Output: true (2^0 = 1)
 * 
 * Example 2:
 * Input: n = 16
 * Output: true (2^4 = 16)
 * 
 * Example 3:
 * Input: n = 3
 * Output: false
 * 
 * Constraints:
 * -2^31 <= n <= 2^31 - 1
 * 
 * Approaches:
 * 1. Repeated Division (User Solution):
 *    - While `n % 2 == 0`, do `n /= 2`.
 *    - If `n == 1`, return true.
 *    - Time Complexity: O(log n)
 * 
 * 2. Bit Manipulation (Optimal O(1)):
 *    - A power of 2 in binary has exactly ONE set bit (e.g. 1=0001, 2=0010, 4=0100, 8=1000).
 *    - `n - 1` flips that bit and sets all lower bits (e.g. 8-1=7 -> 0111).
 *    - Hence: `n & (n - 1) == 0` for all powers of two (when n > 0).
 *    - Time Complexity: O(1)
 *    - Space Complexity: O(1)
 */
public class Problem15_PowerOfTwo {

    // Approach 1: Repeated Division
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    // Approach 2: Bit Trick O(1)
    public static boolean isPowerOfTwoBitwise(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println("n = 1 -> " + isPowerOfTwo(1));   // Expected: true
        System.out.println("n = 16 -> " + isPowerOfTwo(16)); // Expected: true
        System.out.println("n = 3 -> " + isPowerOfTwo(3));   // Expected: false
        System.out.println("n = 16 (Bitwise) -> " + isPowerOfTwoBitwise(16)); // Expected: true
    }
}
