package ARRAYS;

import java.util.Arrays;

/**
 * Problem 19: Search Insert Position
 * LeetCode URL: https://leetcode.com/problems/search-insert-position/ (LC 35)
 * 
 * Problem Statement:
 * Given a sorted array of distinct integers and a target value, return the index if 
 * the target is found. If not, return the index where it would be if it were inserted 
 * in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Key Insight:
 * This problem is identical to finding the "Lower Bound" of the target in a sorted array:
 * finding the smallest index `i` such that `nums[i] >= target`.
 * If target is greater than all elements, the insert position is `nums.length`.
 * 
 * Examples:
 * Example 1:
 * Input: nums = [1, 3, 5, 6], target = 5
 * Output: 2
 * Explanation: 5 is found at index 2.
 * 
 * Example 2:
 * Input: nums = [1, 3, 5, 6], target = 2
 * Output: 1
 * Explanation: 2 is not present. If inserted in order, it would be placed at index 1.
 * 
 * Example 3:
 * Input: nums = [1, 3, 5, 6], target = 7
 * Output: 4
 * Explanation: 7 is greater than all elements, so it would be inserted at index 4 (end of array).
 * 
 * Example 4:
 * Input: nums = [1, 3, 5, 6], target = 0
 * Output: 0
 * Explanation: 0 is smaller than all elements, so it would be inserted at index 0 (beginning).
 * 
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 * 
 * Approaches:
 * 
 * 1. Approach 1: Linear Search (Brute Force)
 *    - Traverse the array from left to right.
 *    - The first index `i` where `nums[i] >= target` is the insert position or exact match.
 *    - If no element is >= target, return `nums.length`.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Binary Search with Candidate Variable (Lower Bound Pattern)
 *    - Maintain `low = 0`, `high = n - 1`, and `ans = n` (default insert position if > all).
 *    - Calculate `mid = low + (high - low) / 2`.
 *    - If `nums[mid] == target`: return `mid` immediately (exact match).
 *    - If `nums[mid] > target`:
 *        - `mid` is a valid candidate where target could be inserted.
 *        - Update `ans = mid` and search left: `high = mid - 1`.
 *    - If `nums[mid] < target`:
 *        - Target must be to the right: `low = mid + 1`.
 *    - Return `ans`.
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 * 
 * 3. Approach 3: Binary Search Returning `low` (Direct & Idiomatic)
 *    - Standard binary search:
 *      while (low <= high):
 *          mid = low + (high - low) / 2
 *          if nums[mid] == target: return mid
 *          else if nums[mid] < target: low = mid + 1
 *          else: high = mid - 1
 *    - Why returning `low` works:
 *      When the loop terminates (low > high), `low` will point to the first index
 *      where `nums[low] > target`, which is the exact insert position!
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 */
public class Problem19_SearchInsertPosition {

    // Approach 1: Linear Search - O(n) Time, O(1) Space
    public static int searchInsertLinear(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    // Approach 2: Binary Search using Lower Bound Pattern - O(log n) Time, O(1) Space
    public static int searchInsertLowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length; // Default to end of array if all elements < target

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                ans = mid;      // Possible insertion point
                high = mid - 1; // Look for an even smaller index on left
            } else {
                low = mid + 1;  // Look on right
            }
        }

        return ans;
    }

    // Approach 3: Binary Search Returning `low` (Optimal & Idiomatic) - O(log n) Time, O(1) Space
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        // When low > high, `low` is guaranteed to be the correct insertion index
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println("Array: " + Arrays.toString(nums));

        // Example 1: Target present in array (target = 5)
        int target1 = 5;
        System.out.println("\n--- Test Case 1: Target present (5) ---");
        System.out.println("Linear Search      : " + searchInsertLinear(nums, target1));      // Expected: 2
        System.out.println("Lower Bound BS     : " + searchInsertLowerBound(nums, target1));  // Expected: 2
        System.out.println("Binary Search (low): " + searchInsert(nums, target1));            // Expected: 2

        // Example 2: Target not present, inserted in middle (target = 2)
        int target2 = 2;
        System.out.println("\n--- Test Case 2: Target not present, insert middle (2) ---");
        System.out.println("Linear Search      : " + searchInsertLinear(nums, target2));      // Expected: 1
        System.out.println("Lower Bound BS     : " + searchInsertLowerBound(nums, target2));  // Expected: 1
        System.out.println("Binary Search (low): " + searchInsert(nums, target2));            // Expected: 1

        // Example 3: Target greater than all elements (target = 7)
        int target3 = 7;
        System.out.println("\n--- Test Case 3: Target greater than all (7) ---");
        System.out.println("Linear Search      : " + searchInsertLinear(nums, target3));      // Expected: 4
        System.out.println("Lower Bound BS     : " + searchInsertLowerBound(nums, target3));  // Expected: 4
        System.out.println("Binary Search (low): " + searchInsert(nums, target3));            // Expected: 4

        // Example 4: Target smaller than all elements (target = 0)
        int target4 = 0;
        System.out.println("\n--- Test Case 4: Target smaller than all (0) ---");
        System.out.println("Linear Search      : " + searchInsertLinear(nums, target4));      // Expected: 0
        System.out.println("Lower Bound BS     : " + searchInsertLowerBound(nums, target4));  // Expected: 0
        System.out.println("Binary Search (low): " + searchInsert(nums, target4));            // Expected: 0

        // Example 5: Single-element array
        int[] single = {4};
        System.out.println("\n--- Test Case 5: Single-element array [4] ---");
        System.out.println("target = 2 -> Insert at: " + searchInsert(single, 2)); // Expected: 0
        System.out.println("target = 4 -> Insert at: " + searchInsert(single, 4)); // Expected: 0
        System.out.println("target = 6 -> Insert at: " + searchInsert(single, 6)); // Expected: 1
    }
}
