package BASICS_ON_DIGITS;

/**
 * LeetCode 7: Reverse Integer
 * URL: https://leetcode.com/problems/reverse-integer/
 * 
 * Problem Statement:
 * Given a signed 32-bit integer x, return x with its digits reversed. 
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * 
 * Example 1:
 * Input: x = 123
 * Output: 321
 * 
 * Example 2:
 * Input: x = -123
 * Output: -321
 * 
 * Example 3:
 * Input: x = 120
 * Output: 21
 * 
 * Constraints:
 * -2^31 <= x <= 2^31 - 1
 * 
 * Intuition & Overflow Handling:
 * - Integer.MAX_VALUE = 2147483647
 * - Integer.MIN_VALUE = -2147483648
 * - Before doing `rev * 10 + digit`, we must check:
 *   1. If `rev > Integer.MAX_VALUE / 10`, multiplying by 10 will definitely overflow.
 *   2. If `rev == Integer.MAX_VALUE / 10`, it will overflow if `digit > 7`.
 *   3. If `rev < Integer.MIN_VALUE / 10`, multiplying by 10 will definitely underflow.
 *   4. If `rev == Integer.MIN_VALUE / 10`, it will underflow if `digit < -8`.
 * 
 * Time Complexity: O(log10(n)) -> There are roughly log10(n) digits in integer n (~ max 10 iterations)
 * Space Complexity: O(1)
 */
public class Problem03_ReverseInteger {

    public static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            
            // Check for positive overflow
            if ((rev > Integer.MAX_VALUE / 10) || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            // Check for negative underflow
            if ((rev < Integer.MIN_VALUE / 10) || (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            
            rev = rev * 10 + digit;
            n = n / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println("x = 123 -> " + reverse(123));   // Expected: 321
        System.out.println("x = -123 -> " + reverse(-123)); // Expected: -321
        System.out.println("x = 120 -> " + reverse(120));   // Expected: 21
        System.out.println("x = 1534236469 -> " + reverse(1534236469)); // Expected: 0 (overflows)
    }
}
