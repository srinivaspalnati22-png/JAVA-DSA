package BASICS_ON_DIGITS;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 2154: Keep Multiplying Found Values by Two / Missing Multiple
 * URL: https://leetcode.com/problems/keep-multiplying-found-values-by-two/
 * 
 * Problem Statement:
 * You are given an array of integers nums. You are also given an integer original / k.
 * Repeatedly check if original / multiple is present in nums:
 * - If found, multiply it by 2 (or find next multiple in the sequence) and repeat.
 * - Otherwise, return the first value that is missing from nums.
 * 
 * Example 1:
 * Input: nums = [5, 3, 6, 1, 12], original = 3
 * Output: 24
 * Explanation: 3 is found -> 6 is found -> 12 is found -> 24 is NOT found -> return 24.
 * 
 * Example 2:
 * Input: nums = [2, 7, 9], original = 4
 * Output: 4
 * 
 * Constraints:
 * 1 <= nums.length <= 1000
 * 1 <= nums[i], original <= 1000
 * 
 * Approaches:
 * 1. Linear Scan Loop (User Solution):
 *    - Loop through array each time multiple is found.
 *    - Time Complexity: O(nums.length * k)
 * 
 * 2. HashSet Lookup (Optimal O(N)):
 *    - Add all elements of `nums` to a HashSet for O(1) lookups.
 *    - While `set.contains(original)`, double it (`original *= 2`).
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n)
 */
public class Problem18_MissingMultiple {

    // Approach 1: Linear Scan (User Solution)
    public static int missingMultiple(int[] nums, int k) {
        int multiple = k;
        while (true) {
            boolean found = false;
            for (int num : nums) {
                if (num == multiple) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return multiple;
            }
            multiple += k; // or multiple *= 2 depending on problem variation
        }
    }

    // Approach 2: HashSet O(1) Lookup (Keep Multiplying by 2)
    public static int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 3, 6, 1, 12};
        System.out.println("findFinalValue(nums1, 3) -> " + findFinalValue(nums1, 3)); // Expected: 24

        int[] nums2 = {2, 7, 9};
        System.out.println("findFinalValue(nums2, 4) -> " + findFinalValue(nums2, 4)); // Expected: 4
    }
}
