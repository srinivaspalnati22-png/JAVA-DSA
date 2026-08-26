package BASICS_ON_DIGITS;

/**
 * LeetCode 258: Add Digits
 * URL: https://leetcode.com/problems/add-digits/
 * 
 * Problem Statement:
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 * 
 * Example 1:
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2 
 * Since 2 has only one digit, return it.
 * 
 * Example 2:
 * Input: num = 0
 * Output: 0
 * 
 * Constraints:
 * 0 <= num <= 2^31 - 1
 * 
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * 
 * Approaches:
 * 1. Simulation with Loops (User Solution):
 *    - Loop while `num >= 10`.
 *    - In inner loop, extract and sum all digits.
 *    - Time Complexity: O(log10(num))
 * 
 * 2. Digital Root Formula (Optimal O(1)):
 *    - In base 10 arithmetic, a number modulo 9 gives its digital root.
 *    - If `num == 0` -> return 0.
 *    - If `num % 9 == 0` -> return 9.
 *    - Otherwise -> return `num % 9`.
 *    - Compact formula: `1 + (num - 1) % 9` (for num > 0)
 *    - Time Complexity: O(1)
 *    - Space Complexity: O(1)
 */
public class Problem11_AddDigits {

    // Approach 1: Iterative Simulation
    public static int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                int digit = num % 10;
                sum += digit;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    // Approach 2: Optimal O(1) Math (Digital Root)
    public static int addDigitsOptimal(int num) {
        if (num == 0) return 0;
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        System.out.println("num = 38 -> " + addDigits(38)); // Expected: 2
        System.out.println("num = 0 -> " + addDigits(0));   // Expected: 0
        System.out.println("num = 38 (Optimal) -> " + addDigitsOptimal(38)); // Expected: 2
    }
}
