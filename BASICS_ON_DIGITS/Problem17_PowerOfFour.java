package BASICS_ON_DIGITS;

/**
 * LeetCode 342: Power of Four
 * URL: https://leetcode.com/problems/power-of-four/
 * 
 * Problem Statement:
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * An integer n is a power of four, if there exists an integer x such that n == 4^x.
 * 
 * Example 1:
 * Input: n = 16
 * Output: true
 * 
 * Example 2:
 * Input: n = 5
 * Output: false
 * 
 * Example 3:
 * Input: n = 1
 * Output: true (4^0 = 1)
 * 
 * Constraints:
 * -2^31 <= n <= 2^31 - 1
 * 
 * Approaches:
 * 1. Repeated Division (User Solution):
 *    - While `n % 4 == 0`, do `n /= 4`.
 *    - Check if `n == 1`.
 *    - Time Complexity: O(log4(n))
 * 
 * 2. Bit Manipulation & Math (Optimal O(1)):
 *    - A number is a power of 4 if:
 *      1. It is positive: `n > 0`
 *      2. It is a power of 2: `(n & (n - 1)) == 0`
 *      3. Powers of 4 modulo 3 always equal 1: `(4^x % 3 == (3+1)^x % 3 == 1)`
 *         Whereas powers of 2 that are NOT powers of 4 (like 2, 8, 32) modulo 3 equal 2.
 *      Hence: `(n > 0) && (n & (n - 1)) == 0 && (n % 3 == 1)`
 *    - Time Complexity: O(1)
 *    - Space Complexity: O(1)
 */
public class Problem17_PowerOfFour {

    // Approach 1: Repeated Division
    public static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    // Approach 2: Bit Manipulation & Modulo 3 (O(1))
    public static boolean isPowerOfFourOptimal(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n % 3 == 1);
    }

    public static void main(String[] args) {
        System.out.println("n = 16 -> " + isPowerOfFour(16)); // Expected: true
        System.out.println("n = 5 -> " + isPowerOfFour(5));   // Expected: false
        System.out.println("n = 1 -> " + isPowerOfFour(1));   // Expected: true
        System.out.println("n = 8 -> " + isPowerOfFour(8));   // Expected: false (Power of 2, not 4)
    }
}
