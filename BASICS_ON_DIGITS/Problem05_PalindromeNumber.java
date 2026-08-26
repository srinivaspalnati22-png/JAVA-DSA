package BASICS_ON_DIGITS;

/**
 * LeetCode 9: Palindrome Number
 * URL: https://leetcode.com/problems/palindrome-number/
 * 
 * Problem Statement:
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * 
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * 
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * 
 * Constraints:
 * -2^31 <= x <= 2^31 - 1
 * 
 * Approaches:
 * 1. Reverse Entire Number:
 *    - Negative numbers cannot be palindromes (due to minus sign).
 *    - Reverse all digits and check if reversed == original.
 * 
 * 2. Revert Half of the Number (Optimal):
 *    - We only need to reverse the second half of the number.
 *    - When `x <= revertedNumber`, we've reached the middle!
 *    - For odd length (e.g., 121), the middle digit doesn't matter: `x == revertedNumber / 10`.
 * 
 * Time Complexity: O(log10(x))
 * Space Complexity: O(1)
 */
public class Problem05_PalindromeNumber {

    // Approach 1: Full Reversal (User Solution)
    private static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }
        return rev;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == reverse(x);
    }

    // Approach 2: Revert Half Number (Avoids any potential overflow)
    public static boolean isPalindromeHalfReversal(int x) {
        // Negative numbers or numbers ending with 0 (except 0 itself) cannot be palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // Even length: x == revertedNumber
        // Odd length: x == revertedNumber / 10 (middle digit ignored)
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        System.out.println("x = 121 -> " + isPalindrome(121));   // Expected: true
        System.out.println("x = -121 -> " + isPalindrome(-121)); // Expected: false
        System.out.println("x = 10 -> " + isPalindrome(10));     // Expected: false
        System.out.println("x = 1221 (Half) -> " + isPalindromeHalfReversal(1221)); // Expected: true
    }
}
