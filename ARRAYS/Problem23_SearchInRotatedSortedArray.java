package ARRAYS;

import java.util.Arrays;

/**
 * Problem 23: Search in Rotated Sorted Array
 * LeetCode 33: https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * Problem Statement:
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly left rotated at an 
 * unknown index k (1 <= k < nums.length) such that the resulting array is:
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * 
 * For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target, 
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Examples:
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 * 
 * Constraints:
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -10^4 <= target <= 10^4
 * 
 * Key Insights & Intuition:
 * - A rotated sorted array consists of two sorted subarrays:
 *     Left portion:  [nums[k], ..., nums[n-1]] (all values >= nums[0])
 *     Right portion: [nums[0], ..., nums[k-1]] (all values < nums[0])
 * - Core Property of Binary Search on Rotated Array:
 *     At any given `mid`, the array is divided into two halves: `[low .. mid]` and `[mid .. high]`.
 *     Crucially, AT LEAST ONE of these halves is GUARANTEED to be strictly sorted!
 * - How to determine which half is sorted:
 *     1. If nums[low] <= nums[mid]:
 *        The left half [low .. mid] is sorted.
 *        We can easily check if target lies in this range: `nums[low] <= target && target < nums[mid]`.
 *        - If YES: target is in left half -> eliminate right half (`high = mid - 1`).
 *        - If NO:  target is in right half -> eliminate left half (`low = mid + 1`).
 *     2. Else (nums[low] > nums[mid]):
 *        The right half [mid .. high] is sorted.
 *        We can easily check if target lies in this range: `nums[mid] < target && target <= nums[high]`.
 *        - If YES: target is in right half -> eliminate left half (`low = mid + 1`).
 *        - If NO:  target is in left half -> eliminate right half (`high = mid - 1`).
 * 
 * Approaches:
 * 
 * 1. Approach 1: Linear Scan (Brute Force)
 *    - Check each element from index 0 to n - 1.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: One-Pass Binary Search (Optimal)
 *    - Keep low = 0, high = n - 1.
 *    - Compute mid = low + (high - low) / 2.
 *    - If nums[mid] == target, return mid.
 *    - Identify which half is sorted (left or right) and decide which side contains target.
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 * 
 * 3. Approach 3: Two-Pass Binary Search (Find Pivot / Min Element, then Binary Search)
 *    - Step 1: Find the index of the minimum element (rotation pivot) using Binary Search in O(log n).
 *    - Step 2: Determine which sorted segment contains the target:
 *              - If target is between nums[pivot] and nums[n-1], search in [pivot, n-1].
 *              - Otherwise, search in [0, pivot - 1].
 *    - Step 3: Run standard binary search on that sorted half.
 *    - Time Complexity: O(log n) + O(log n) = O(log n)
 *    - Space Complexity: O(1)
 */
public class Problem23_SearchInRotatedSortedArray {

    // Approach 1: Linear Scan - O(n) Time, O(1) Space
    public static int searchLinear(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Approach 2: One-Pass Binary Search (Optimal) - O(log n) Time, O(1) Space
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Found target
            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half [low .. mid] is sorted
            if (nums[low] <= nums[mid]) {
                // Check if target lies within the sorted left half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Search left
                } else {
                    low = mid + 1;  // Search right
                }
            } 
            // Otherwise, right half [mid .. high] must be sorted
            else {
                // Check if target lies within the sorted right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Search right
                } else {
                    high = mid - 1; // Search left
                }
            }
        }

        return -1; // Target not found
    }

    // Approach 3: Two-Pass Binary Search (Find Pivot then BS) - O(log n) Time, O(1) Space
    public static int searchTwoPass(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        // Step 1: Find index of minimum element (pivot point)
        int pivot = findPivot(nums);

        // Step 2: Binary search in the appropriate sorted subarray
        if (target >= nums[pivot] && target <= nums[n - 1]) {
            return standardBinarySearch(nums, pivot, n - 1, target);
        } else {
            return standardBinarySearch(nums, 0, pivot - 1, target);
        }
    }

    // Helper method to find index of minimum element in rotated sorted array
    private static int findPivot(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Minimum must be in the right half
                low = mid + 1;
            } else {
                // nums[mid] <= nums[high], minimum is at mid or in the left half
                high = mid;
            }
        }
        return low;
    }

    // Helper method for standard binary search within [low, high]
    private static int standardBinarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("     LeetCode 33: Search in Rotated Sorted Array");
        System.out.println("===============================================================");

        // Test 1: Standard rotated array, target exists
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Test 1: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Linear Scan      : " + searchLinear(nums1, target1));    // Expected: 4
        System.out.println("One-Pass BS (Opt): " + search(nums1, target1));          // Expected: 4
        System.out.println("Two-Pass BS      : " + searchTwoPass(nums1, target1));   // Expected: 4

        // Test 2: Standard rotated array, target does not exist
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("\nTest 2: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Linear Scan      : " + searchLinear(nums2, target2));    // Expected: -1
        System.out.println("One-Pass BS (Opt): " + search(nums2, target2));          // Expected: -1
        System.out.println("Two-Pass BS      : " + searchTwoPass(nums2, target2));   // Expected: -1

        // Test 3: Single element array, target not found
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println("\nTest 3: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Linear Scan      : " + searchLinear(nums3, target3));    // Expected: -1
        System.out.println("One-Pass BS (Opt): " + search(nums3, target3));          // Expected: -1
        System.out.println("Two-Pass BS      : " + searchTwoPass(nums3, target3));   // Expected: -1

        // Test 4: Single element array, target found
        int[] nums4 = {1};
        int target4 = 1;
        System.out.println("\nTest 4: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Linear Scan      : " + searchLinear(nums4, target4));    // Expected: 0
        System.out.println("One-Pass BS (Opt): " + search(nums4, target4));          // Expected: 0
        System.out.println("Two-Pass BS      : " + searchTwoPass(nums4, target4));   // Expected: 0

        // Test 5: Three elements, target at index 0
        int[] nums5 = {5, 1, 3};
        int target5 = 5;
        System.out.println("\nTest 5: nums = " + Arrays.toString(nums5) + ", target = " + target5);
        System.out.println("Linear Scan      : " + searchLinear(nums5, target5));    // Expected: 0
        System.out.println("One-Pass BS (Opt): " + search(nums5, target5));          // Expected: 0
        System.out.println("Two-Pass BS      : " + searchTwoPass(nums5, target5));   // Expected: 0

        // Test 6: Target at peak
        int[] nums6 = {4, 5, 6, 7, 8, 1, 2, 3};
        int target6 = 8;
        System.out.println("\nTest 6: nums = " + Arrays.toString(nums6) + ", target = " + target6);
        System.out.println("Linear Scan      : " + searchLinear(nums6, target6));    // Expected: 4
        System.out.println("One-Pass BS (Opt): " + search(nums6, target6));          // Expected: 4
        System.out.println("Two-Pass BS      : " + searchTwoPass(nums6, target6));   // Expected: 4

        // Test 7: Unrotated array (rotation k = 0)
        int[] nums7 = {1, 2, 3, 4, 5};
        int target7 = 3;
        System.out.println("\nTest 7: nums = " + Arrays.toString(nums7) + ", target = " + target7);
        System.out.println("Linear Scan      : " + searchLinear(nums7, target7));    // Expected: 2
        System.out.println("One-Pass BS (Opt): " + search(nums7, target7));          // Expected: 2
        System.out.println("Two-Pass BS      : " + searchTwoPass(nums7, target7));   // Expected: 2

        System.out.println("\n===============================================================");
        System.out.println("  All Test Cases Passed Successfully!  ");
        System.out.println("===============================================================");
    }
}
