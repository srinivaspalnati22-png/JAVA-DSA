package ARRAYS;

import java.util.Arrays;

/**
 * Problem 13: Find Pivot Index
 * LeetCode 724: https://leetcode.com/problems/find-pivot-index/
 * (Also LeetCode 1991: Find the Middle Index in Array)
 * 
 * Problem Statement:
 * Given an array of integers nums, calculate the pivot index of this array.
 * 
 * The pivot index is the index where the sum of all the numbers strictly to the left 
 * of the index is equal to the sum of all the numbers strictly to the index's right.
 * 
 * If the index is on the left edge of the array, then the left sum is 0 because there are 
 * no elements to the left. This also applies to the right edge of the array.
 * 
 * Return the leftmost pivot index. If no such index exists, return -1.
 * 
 * Examples:
 * Example 1:
 * Input: nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * 
 * Example 2:
 * Input: nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * 
 * Example 3:
 * Input: nums = [2, 1, -1]
 * Output: 0
 * Explanation:
 * The pivot index is 0.
 * Left sum = 0 (no elements to the left of index 0)
 * Right sum = nums[1] + nums[2] = 1 + (-1) = 0
 * 
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -1000 <= nums[i] <= 1000
 * 
 * Approaches:
 * 
 * 1. Approach 1: Brute Force
 *    - For each index `i`, compute left sum from 0 to i-1 and right sum from i+1 to n-1.
 *    - Return the first index `i` where leftSum == rightSum.
 *    - Time Complexity: O(n^2)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Prefix and Suffix Sum Arrays
 *    - Precompute prefix sums and suffix sums in auxiliary arrays.
 *    - Compare prefix[i] and suffix[i] at each index.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n)
 * 
 * 3. Approach 3: Optimal Total Sum & Running Left Sum (Recommended)
 *    - Pass 1: Compute `totalSum` of the array.
 *    - Pass 2: Maintain `leftSum = 0`.
 *      For each index `i`:
 *        `rightSum = totalSum - leftSum - nums[i]`
 *        If `leftSum == rightSum`, return `i`.
 *        `leftSum += nums[i]`
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 */
public class Problem13_FindPivotIndex {

    // Approach 1: Brute Force - O(n^2) Time, O(1) Space
    public static int pivotIndexBruteForce(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            int rightSum = 0;
            for (int j = i + 1; j < n; j++) {
                rightSum += nums[j];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    // Approach 2: Prefix & Suffix Arrays - O(n) Time, O(n) Space
    public static int pivotIndexPrefixSuffix(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        // Fill leftSum
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        // Fill rightSum
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        // Find leftmost pivot index
        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i]) {
                return i;
            }
        }

        return -1;
    }

    // Approach 3: Optimal Total Sum & Running Left Sum - O(n) Time, O(1) Space
    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // rightSum = totalSum - leftSum - nums[i]
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard pivot in the middle
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println("Test Case 1: " + Arrays.toString(nums1));
        System.out.println("Pivot Index (Brute Force)    : " + pivotIndexBruteForce(nums1));    // Expected: 3
        System.out.println("Pivot Index (Prefix/Suffix)  : " + pivotIndexPrefixSuffix(nums1));  // Expected: 3
        System.out.println("Pivot Index (Optimal O(1))   : " + pivotIndex(nums1));              // Expected: 3

        // Test Case 2: No pivot index exists
        int[] nums2 = {1, 2, 3};
        System.out.println("\nTest Case 2: " + Arrays.toString(nums2));
        System.out.println("Pivot Index: " + pivotIndex(nums2)); // Expected: -1

        // Test Case 3: Pivot at index 0 (left edge)
        int[] nums3 = {2, 1, -1};
        System.out.println("\nTest Case 3: " + Arrays.toString(nums3));
        System.out.println("Pivot Index: " + pivotIndex(nums3)); // Expected: 0

        // Test Case 4: Pivot at right edge (last element)
        int[] nums4 = {-1, 1, 0, 5};
        System.out.println("\nTest Case 4: " + Arrays.toString(nums4));
        System.out.println("Pivot Index: " + pivotIndex(nums4)); // Expected: 3 (left sum = -1+1+0 = 0, right sum = 0)

        // Test Case 5: All zeros
        int[] nums5 = {0, 0, 0, 0};
        System.out.println("\nTest Case 5: " + Arrays.toString(nums5));
        System.out.println("Pivot Index: " + pivotIndex(nums5)); // Expected: 0 (leftmost)
    }
}
