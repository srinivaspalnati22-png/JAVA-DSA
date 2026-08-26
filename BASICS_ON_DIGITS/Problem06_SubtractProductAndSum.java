package BASICS_ON_DIGITS;

/**
 * LeetCode 1281: Subtract the Product and Sum of Digits of an Integer
 * URL: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * 
 * Problem Statement:
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * 
 * Example 1:
 * Input: n = 234
 * Output: 15 
 * Explanation: 
 * Product of digits = 2 * 3 * 4 = 24 
 * Sum of digits = 2 + 3 + 4 = 9 
 * Result = 24 - 9 = 15
 * 
 * Example 2:
 * Input: n = 4421
 * Output: 21
 * Explanation: 
 * Product of digits = 4 * 4 * 2 * 1 = 32 
 * Sum of digits = 4 + 4 + 2 + 1 = 11 
 * Result = 32 - 11 = 21
 * 
 * Constraints:
 * 1 <= n <= 10^5
 * 
 * Intuition & Algorithm:
 * - Initialize `product = 1` and `sum = 0`.
 * - While `n > 0`, extract the last digit (`n % 10`), multiply to product, add to sum, and divide `n` by 10.
 * - Return `product - sum`.
 * 
 * Time Complexity: O(log10(n)) -> Process each digit once
 * Space Complexity: O(1)
 */
public class Problem06_SubtractProductAndSum {

    public static int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        
        while (n != 0) {
            int digit = n % 10;
            product *= digit;
            sum += digit;
            n /= 10;
        }
        
        return product - sum;
    }

    public static void main(String[] args) {
        System.out.println("n = 234 -> " + subtractProductAndSum(234));   // Expected: 15
        System.out.println("n = 4421 -> " + subtractProductAndSum(4421)); // Expected: 21
    }
}
