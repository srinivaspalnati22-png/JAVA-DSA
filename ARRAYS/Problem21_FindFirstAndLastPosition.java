package ARRAYS;

import java.util.Arrays;

/**
 * Problem 21: Find First and Last Position of Element in Sorted Array
 * LeetCode 34: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * Problem Statement:
 * Given an array of integers nums sorted in non-decreasing order, find the starting 
 * and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Examples:
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * Constraints:
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 * 
 * Approaches:
 * 
 * 1. Approach 1: Linear Scan (Brute Force)
 *    - Traverse from left to right to find the first occurrence.
 *    - Traverse from right to left to find the last occurrence.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Two Binary Searches (First & Last Occurrence) - Optimal
 *    - Binary Search 1 (findFirst):
 *        When nums[mid] == target, record mid as potential first occurrence and move high = mid - 1.
 *    - Binary Search 2 (findLast):
 *        When nums[mid] == target, record mid as potential last occurrence and move low = mid + 1.
 *    - Optimization: If findFirst returns -1, target is not in the array, so we can skip findLast.
 *    - Time Complexity: O(log n) + O(log n) = O(log n)
 *    - Space Complexity: O(1)
 * 
 * 3. Approach 3: Lower Bound and Upper Bound
 *    - First position = Lower Bound of target (smallest index where nums[i] >= target).
 *    - If Lower Bound doesn't exist or nums[lb] != target, return [-1, -1].
 *    - Last position = Upper Bound of target - 1 (smallest index where nums[i] > target, minus 1).
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 */
public class Problem21_FindFirstAndLastPosition {

    // Approach 1: Linear Scan - O(n) Time, O(1) Space
    public static int[] searchRangeLinear(int[] nums, int target) {
        int first = -1, last = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }

        return new int[]{first, last};
    }

    // Approach 2: Two Binary Searches (Optimal) - O(log n) Time, O(1) Space
    public static int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);

        // If target is not present, no need to search for the ending position
        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    /**
     * Helper method to find either the first or last occurrence using binary search.
     * @param isFirst if true, searches for first occurrence; if false, searches for last.
     */
    private static int findBound(int[] nums, int target, boolean isFirst) {
        int low = 0;
        int high = nums.length - 1;
        int bound = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    high = mid - 1; // Narrow search to left half for first occurrence
                } else {
                    low = mid + 1;  // Narrow search to right half for last occurrence
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return bound;
    }

    // Approach 3: Using Lower Bound and Upper Bound - O(log n) Time, O(1) Space
    public static int[] searchRangeBounds(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums, target);

        // If target is not present
        if (lb == n || nums[lb] != target) {
            return new int[]{-1, -1};
        }

        int ub = upperBound(nums, target);
        return new int[]{lb, ub - 1};
    }

    private static int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1, ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1, ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("  LeetCode 34: Find First and Last Position in Sorted Array");
        System.out.println("===============================================================");

        // Test Case 1: Target present multiple times
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] res1 = searchRange(nums1, target1);
        System.out.println("Test 1: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Binary Search : " + Arrays.toString(res1)); // Expected: [3, 4]
        System.out.println("Bounds Method : " + Arrays.toString(searchRangeBounds(nums1, target1)));

        // Test Case 2: Target absent
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] res2 = searchRange(nums2, target2);
        System.out.println("\nTest 2: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Binary Search : " + Arrays.toString(res2)); // Expected: [-1, -1]

        // Test Case 3: Empty array
        int[] nums3 = {};
        int target3 = 0;
        int[] res3 = searchRange(nums3, target3);
        System.out.println("\nTest 3: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Binary Search : " + Arrays.toString(res3)); // Expected: [-1, -1]

        // Test Case 4: Single element array matching target
        int[] nums4 = {1};
        int target4 = 1;
        int[] res4 = searchRange(nums4, target4);
        System.out.println("\nTest 4: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Binary Search : " + Arrays.toString(res4)); // Expected: [0, 0]

        // Test Case 5: All elements identical to target
        int[] nums5 = {2, 2, 2, 2, 2};
        int target5 = 2;
        int[] res5 = searchRange(nums5, target5);
        System.out.println("\nTest 5: nums = " + Arrays.toString(nums5) + ", target = " + target5);
        System.out.println("Binary Search : " + Arrays.toString(res5)); // Expected: [0, 4]

        System.out.println("===============================================================");
    }
}
