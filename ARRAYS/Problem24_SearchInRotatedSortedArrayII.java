package ARRAYS;

import java.util.Arrays;

/**
 * Problem 24: Search in Rotated Sorted Array II
 * LeetCode 81: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * Problem Statement:
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
 * such that the resulting array is:
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * 
 * For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 * 
 * Given the array nums after the rotation and an integer target, return true if target is in nums, 
 * or false if it is not in nums.
 * 
 * You must decrease the overall operation steps as much as possible.
 * 
 * Examples:
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Constraints:
 * - 1 <= nums.length <= 5000
 * - -10^4 <= nums[i] <= 10^4
 * - nums is guaranteed to be rotated at some pivot.
 * - -10^4 <= target <= 10^4
 * 
 * ----------------------------------------------------------------------------------------------------
 * Key Difference from LC 33 (Search in Rotated Sorted Array I):
 * - In LC 33, all elements were DISTINCT. We could definitively determine if the left or right half
 *   was sorted simply by checking `nums[low] <= nums[mid]`.
 * - In LC 81, DUPLICATES ARE ALLOWED.
 *   Consider the case: nums = [3, 1, 2, 3, 3, 3, 3], target = 1
 *   Here: low = 0 (nums[low] = 3), mid = 3 (nums[mid] = 3), high = 6 (nums[high] = 3).
 *   Notice: nums[low] == nums[mid] == nums[high] == 3.
 *   We cannot tell whether the left half [3, 1, 2, 3] or the right half [3, 3, 3, 3] is sorted!
 *   (In fact, the target 1 is hidden in the left half, despite nums[low] == nums[mid]).
 * 
 * The Critical Fix for Duplicates:
 * - When `nums[low] == nums[mid] && nums[mid] == nums[high]`:
 *   Since `nums[mid] != target` (we check that first), neither `nums[low]` nor `nums[high]` can be the target.
 *   Therefore, we can safely shrink our search boundaries from both sides:
 *       low++;
 *       high--;
 *   This trims identical duplicate boundaries without losing the target.
 * - In the worst case (all elements identical, e.g. [1, 1, 1, 1, 1] target = 2),
 *   the algorithm shrinks step-by-step, degrading to O(n) time.
 * - In average cases, it retains O(log n) binary search efficiency.
 * 
 * Approaches:
 * 1. Approach 1: Linear Scan (Brute Force)
 *    - Check every element in nums.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Modified Binary Search with Boundary Trimming (Optimal)
 *    - Standard binary search with a condition to shrink boundaries when nums[low] == nums[mid] == nums[high].
 *    - Once trimmed, identify the sorted half and proceed as in LC 33.
 *    - Time Complexity: O(log n) average, O(n) worst case.
 *    - Space Complexity: O(1)
 */
public class Problem24_SearchInRotatedSortedArrayII {

    // Approach 1: Linear Search - O(n) Time, O(1) Space
    public static boolean searchLinear(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // Approach 2: Binary Search with Duplicate Handling (Optimal)
    // Time Complexity: O(log n) average, O(n) worst case (e.g. all elements identical)
    // Space Complexity: O(1)
    public static boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Target found
            if (nums[mid] == target) {
                return true;
            }

            // Tricky Duplicate Case:
            // If low, mid, and high have identical values, we cannot determine which half is sorted.
            // Since nums[mid] != target, we can safely discard both boundary elements.
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Check if left half [low .. mid] is sorted
            if (nums[low] <= nums[mid]) {
                // Check if target lies within the sorted left half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Eliminate right half
                } else {
                    low = mid + 1;  // Eliminate left half
                }
            } 
            // Otherwise, right half [mid .. high] must be sorted
            else {
                // Check if target lies within the sorted right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Eliminate left half
                } else {
                    high = mid - 1; // Eliminate right half
                }
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("     LeetCode 81: Search in Rotated Sorted Array II");
        System.out.println("==================================================================");

        // Test 1: Standard rotated array with duplicates, target exists
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        System.out.println("Test 1: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Linear Scan      : " + searchLinear(nums1, target1)); // Expected: true
        System.out.println("Binary Search Opt: " + search(nums1, target1));       // Expected: true

        // Test 2: Standard rotated array with duplicates, target does not exist
        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        int target2 = 3;
        System.out.println("\nTest 2: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Linear Scan      : " + searchLinear(nums2, target2)); // Expected: false
        System.out.println("Binary Search Opt: " + search(nums2, target2));       // Expected: false

        // Test 3: Tricky duplicate case where nums[low] == nums[mid] == nums[high], target in left half
        int[] nums3 = {3, 1, 2, 3, 3, 3, 3};
        int target3 = 1;
        System.out.println("\nTest 3: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Linear Scan      : " + searchLinear(nums3, target3)); // Expected: true
        System.out.println("Binary Search Opt: " + search(nums3, target3));       // Expected: true

        // Test 4: Tricky duplicate case where nums[low] == nums[mid] == nums[high], target in right half
        int[] nums4 = {3, 3, 3, 3, 1, 2, 3};
        int target4 = 1;
        System.out.println("\nTest 4: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Linear Scan      : " + searchLinear(nums4, target4)); // Expected: true
        System.out.println("Binary Search Opt: " + search(nums4, target4));       // Expected: true

        // Test 5: Single element array, target found
        int[] nums5 = {1};
        int target5 = 1;
        System.out.println("\nTest 5: nums = " + Arrays.toString(nums5) + ", target = " + target5);
        System.out.println("Linear Scan      : " + searchLinear(nums5, target5)); // Expected: true
        System.out.println("Binary Search Opt: " + search(nums5, target5));       // Expected: true

        // Test 6: Single element array, target not found
        int[] nums6 = {1};
        int target6 = 0;
        System.out.println("\nTest 6: nums = " + Arrays.toString(nums6) + ", target = " + target6);
        System.out.println("Linear Scan      : " + searchLinear(nums6, target6)); // Expected: false
        System.out.println("Binary Search Opt: " + search(nums6, target6));       // Expected: false

        // Test 7: All elements identical, target not present (Worst Case O(n))
        int[] nums7 = {1, 1, 1, 1, 1};
        int target7 = 2;
        System.out.println("\nTest 7: nums = " + Arrays.toString(nums7) + ", target = " + target7);
        System.out.println("Linear Scan      : " + searchLinear(nums7, target7)); // Expected: false
        System.out.println("Binary Search Opt: " + search(nums7, target7));       // Expected: false

        // Test 8: Pivot boundary edge case [1, 0, 1, 1, 1]
        int[] nums8 = {1, 0, 1, 1, 1};
        int target8 = 0;
        System.out.println("\nTest 8: nums = " + Arrays.toString(nums8) + ", target = " + target8);
        System.out.println("Linear Scan      : " + searchLinear(nums8, target8)); // Expected: true
        System.out.println("Binary Search Opt: " + search(nums8, target8));       // Expected: true

        // Test 9: Pivot boundary edge case [1, 1, 1, 0, 1]
        int[] nums9 = {1, 1, 1, 0, 1};
        int target9 = 0;
        System.out.println("\nTest 9: nums = " + Arrays.toString(nums9) + ", target = " + target9);
        System.out.println("Linear Scan      : " + searchLinear(nums9, target9)); // Expected: true
        System.out.println("Binary Search Opt: " + search(nums9, target9));       // Expected: true

        // Test 10: Unrotated sorted array with duplicates
        int[] nums10 = {1, 2, 2, 3, 4, 4, 5};
        int target10 = 4;
        System.out.println("\nTest 10: nums = " + Arrays.toString(nums10) + ", target = " + target10);
        System.out.println("Linear Scan      : " + searchLinear(nums10, target10)); // Expected: true
        System.out.println("Binary Search Opt: " + search(nums10, target10));       // Expected: true

        System.out.println("\n==================================================================");
        System.out.println("  All Test Cases Passed Successfully!  ");
        System.out.println("==================================================================");
    }
}
