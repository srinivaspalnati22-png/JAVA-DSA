package BASICS_ON_DIGITS;

/**
 * LeetCode 1295: Find Numbers with Even Number of Digits
 * URL: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * 
 * Problem Statement:
 * Given an array `nums` of integers, return how many of them contain an even number of digits.
 * 
 * Example 1:
 * Input: nums = [12, 345, 2, 6, 7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore, only 12 and 7896 contain an even number of digits.
 * 
 * Example 2:
 * Input: nums = [555, 901, 482, 1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 * 
 * Constraints:
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 * 
 * Approaches:
 * 1. Approach 1: Division by 10 (Standard Digit Extraction)
 *    - For each number, repeatedly divide by 10 until it becomes 0 to count the digits.
 *    - Check if digit count % 2 == 0.
 *    - Time Complexity: O(N * log10(M)) where M is the maximum value in nums
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: String Conversion
 *    - Convert each number to a string and check if String.valueOf(num).length() % 2 == 0.
 *    - Time Complexity: O(N * log10(M))
 *    - Space Complexity: O(log10(M)) auxiliary space for string representation
 * 
 * 3. Approach 3: Math.log10 Formula
 *    - The number of digits for any positive integer `num` is `(int) Math.log10(num) + 1`.
 *    - Check if this count is even.
 *    - Time Complexity: O(N)
 *    - Space Complexity: O(1)
 * 
 * 4. Approach 4: Range Checking (Optimized for Constraints: 1 <= nums[i] <= 10^5)
 *    - Even digit lengths within range [1, 100000]:
 *      * 2 digits: [10, 99]
 *      * 4 digits: [1000, 9999]
 *      * 6 digits: 100000
 *    - Directly test ranges using constant-time comparisons.
 *    - Time Complexity: O(N)
 *    - Space Complexity: O(1)
 */
public class Problem22_FindNumbersWithEvenNumberOfDigits {

    // Approach 1: Digit Counting by Division (Most General & Standard DSA Way)
    public static int findNumbersDivision(int[] nums) {
        int evenCount = 0;
        for (int num : nums) {
            if (hasEvenDigitsDivision(num)) {
                evenCount++;
            }
        }
        return evenCount;
    }

    private static boolean hasEvenDigitsDivision(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return (count % 2 == 0);
    }

    // Approach 2: String Conversion
    public static int findNumbersString(int[] nums) {
        int evenCount = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }

    // Approach 3: Math.log10
    public static int findNumbersLog(int[] nums) {
        int evenCount = 0;
        for (int num : nums) {
            int digits = (int) Math.log10(num) + 1;
            if (digits % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }

    // Approach 4: Range Checking (Optimized for Constraints: nums[i] <= 10^5)
    public static int findNumbersRange(int[] nums) {
        int evenCount = 0;
        for (int num : nums) {
            if ((num >= 10 && num <= 99) || 
                (num >= 1000 && num <= 9999) || 
                (num == 100000)) {
                evenCount++;
            }
        }
        return evenCount;
    }

    public static void main(String[] args) {
        int[] nums1 = {12, 345, 2, 6, 7896};
        int[] nums2 = {555, 901, 482, 1771};
        int[] nums3 = {100000, 1, 10, 999};

        System.out.println("--- Testing Approach 1 (Division) ---");
        System.out.println("Example 1: " + findNumbersDivision(nums1)); // Expected: 2
        System.out.println("Example 2: " + findNumbersDivision(nums2)); // Expected: 1
        System.out.println("Example 3: " + findNumbersDivision(nums3)); // Expected: 2 (100000 -> 6 digits, 10 -> 2 digits)

        System.out.println("\n--- Testing Approach 2 (String) ---");
        System.out.println("Example 1: " + findNumbersString(nums1)); // Expected: 2
        System.out.println("Example 2: " + findNumbersString(nums2)); // Expected: 1

        System.out.println("\n--- Testing Approach 3 (Math.log10) ---");
        System.out.println("Example 1: " + findNumbersLog(nums1)); // Expected: 2
        System.out.println("Example 2: " + findNumbersLog(nums2)); // Expected: 1

        System.out.println("\n--- Testing Approach 4 (Range Check) ---");
        System.out.println("Example 1: " + findNumbersRange(nums1)); // Expected: 2
        System.out.println("Example 2: " + findNumbersRange(nums2)); // Expected: 1
        System.out.println("Example 3: " + findNumbersRange(nums3)); // Expected: 2
    }
}
