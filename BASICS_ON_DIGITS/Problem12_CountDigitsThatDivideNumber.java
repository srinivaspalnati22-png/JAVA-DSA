package BASICS_ON_DIGITS;

/**
 * LeetCode 2520: Count the Digits That Divide a Number
 * URL: https://leetcode.com/problems/count-digits-that-divide-a-number/
 * 
 * Problem Statement:
 * Given an integer num, return the number of digits in num that divide num.
 * An integer val divides num if nums % val == 0.
 * 
 * Example 1:
 * Input: num = 7
 * Output: 1
 * Explanation: 7 divides itself, so answer is 1.
 * 
 * Example 2:
 * Input: num = 121
 * Output: 2
 * Explanation: 121 is divisible by 1, but not by 2. Since 1 occurs twice as a digit, answer is 2.
 * 
 * Example 3:
 * Input: num = 1248
 * Output: 4
 * Explanation: 1248 is divisible by all its digits: 1, 2, 4, and 8.
 * 
 * Constraints:
 * 1 <= num <= 10^9
 * num does not contain 0 as one of its digits.
 * 
 * Intuition & Algorithm:
 * - Make a copy of `num` (say `temp`).
 * - While `temp > 0`:
 *   1. Extract last digit: `digit = temp % 10`.
 *   2. Check if `num % digit == 0`. If yes, increment count.
 *   3. Discard last digit: `temp /= 10`.
 * - Return count.
 * 
 * Time Complexity: O(log10(num)) -> At most 10 digits for 32-bit int
 * Space Complexity: O(1)
 */
public class Problem12_CountDigitsThatDivideNumber {

    public static int countDigits(int num) {
        int count = 0;
        int temp = num;
        
        while (temp > 0) {
            int digit = temp % 10;
            if (num % digit == 0) {
                count++;
            }
            temp /= 10;
        }
        
        return count;
    }

    public static void main(String[] args) {
        System.out.println("num = 7 -> " + countDigits(7));       // Expected: 1
        System.out.println("num = 121 -> " + countDigits(121));   // Expected: 2
        System.out.println("num = 1248 -> " + countDigits(1248)); // Expected: 4
    }
}
