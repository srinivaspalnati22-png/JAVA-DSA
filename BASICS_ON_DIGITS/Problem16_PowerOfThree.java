package BASICS_ON_DIGITS;

/**
 * LeetCode 326: Power of Three
 * URL: https://leetcode.com/problems/power-of-three/
 * 
 * Problem Statement:
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * An integer n is a power of three, if there exists an integer x such that n == 3^x.
 * 
 * Example 1:
 * Input: n = 27
 * Output: true
 * 
 * Example 2:
 * Input: n = 0
 * Output: false
 * 
 * Example 3:
 * Input: n = -1
 * Output: false
 * 
 * Constraints:
 * -2^31 <= n <= 2^31 - 1
 * 
 * Approaches:
 * 1. Repeated Division (User Solution):
 *    - While `n % 3 == 0`, do `n /= 3`.
 *    - Check if `n == 1`.
 *    - Time Complexity: O(log3(n))
 * 
 * 2. Max Integer Power of Three (Optimal O(1)):
 *    - The maximum power of 3 that fits inside a signed 32-bit int is 3^19 = 1,162,261,467.
 *    - Since 3 is prime, any power of 3 will only have factors of 3.
 *    - Therefore, `n` is a power of 3 iff `n > 0 && 1162261467 % n == 0`.
 *    - Time Complexity: O(1)
 *    - Space Complexity: O(1)
 */
public class Problem16_PowerOfThree {

    // Approach 1: Repeated Division
    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    // Approach 2: Max 32-bit Power of 3 (O(1))
    public static boolean isPowerOfThreeOptimal(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println("n = 27 -> " + isPowerOfThree(27)); // Expected: true
        System.out.println("n = 0 -> " + isPowerOfThree(0));   // Expected: false
        System.out.println("n = 9 -> " + isPowerOfThree(9));   // Expected: true
        System.out.println("n = 45 -> " + isPowerOfThree(45)); // Expected: false
    }
}
