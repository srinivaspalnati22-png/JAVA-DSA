package BASICS_ON_DIGITS;

/**
 * LeetCode 3099: Harshad Number
 * URL: https://leetcode.com/problems/harshad-number/
 * 
 * Problem Statement:
 * An integer divisible by the sum of its digits is said to be a Harshad number. 
 * You are given an integer x. Return the sum of the digits of x if x is a Harshad number, otherwise return -1.
 * 
 * Example 1:
 * Input: x = 18
 * Output: 9
 * Explanation:
 * The sum of digits of 18 is 1 + 8 = 9. Since 18 is divisible by 9, 18 is a Harshad number and the answer is 9.
 * 
 * Example 2:
 * Input: x = 23
 * Output: -1
 * Explanation:
 * The sum of digits of 23 is 2 + 3 = 5. Since 23 is not divisible by 5, 23 is not a Harshad number and the answer is -1.
 * 
 * Constraints:
 * 1 <= x <= 100
 * 
 * Intuition & Algorithm:
 * 1. Compute digit sum using `temp % 10` and `temp /= 10`.
 * 2. Check if original `x % sum == 0`.
 * 3. Return `sum` if divisible, otherwise `-1`.
 * 
 * Time Complexity: O(log10(x))
 * Space Complexity: O(1)
 */
public class Problem20_HarshadNumber {

    public static int sumOfTheDigitsOfHarshadNumber(int n) {
        int temp = n;
        int sum = 0;
        
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            temp /= 10;
        }
        
        if (n % sum == 0) {
            return sum;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("x = 18 -> " + sumOfTheDigitsOfHarshadNumber(18)); // Expected: 9
        System.out.println("x = 23 -> " + sumOfTheDigitsOfHarshadNumber(23)); // Expected: -1
    }
}
