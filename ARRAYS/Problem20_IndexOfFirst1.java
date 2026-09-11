package ARRAYS;

import java.util.Arrays;

/**
 * Problem 20: Index of First 1 in a Sorted Array of 0s and 1s
 * GeeksforGeeks Problem: "Index of first 1 in a sorted array of 0s and 1s"
 * 
 * Problem Statement:
 * Given a sorted array `arr` consisting of 0s and 1s. The task is to find 
 * the index (0-based indexing) of the first 1 in the given array.
 * 
 * NOTE: If 1 is not present, return -1.
 * 
 * Key Insight:
 * Since the array is sorted and contains only 0s and 1s, it has the form:
 * [0, 0, 0, ..., 0, 1, 1, ..., 1]
 * This monotonic transition allows us to use Binary Search to find the first occurrence 
 * of 1 in O(log n) time, drastically outperforming O(n) linear search.
 * 
 * Examples:
 * Example 1:
 * Input : arr[] = [0, 0, 0, 0, 0, 0, 1, 1, 1, 1]
 * Output: 6
 * Explanation: The index of first 1 in the array is 6.
 * 
 * Example 2:
 * Input : arr[] = [0, 0, 0, 0]
 * Output: -1
 * Explanation: 1's are not present in the array.
 * 
 * Example 3:
 * Input : arr[] = [1, 1, 1, 1]
 * Output: 0
 * Explanation: The first element is 1, so index 0.
 * 
 * Constraints:
 * 1 <= arr.length <= 10^6
 * 0 <= arr[i] <= 1
 * 
 * Approaches:
 * 
 * 1. Approach 1: Linear Search (Brute Force)
 *    - Traverse the array from left to right.
 *    - As soon as arr[i] == 1, return i.
 *    - If traversal finishes without finding 1, return -1.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Binary Search (First Occurrence / Lower Bound) - Optimal
 *    - Initialize low = 0, high = n - 1, and ans = -1.
 *    - While low <= high:
 *        - mid = low + (high - low) / 2
 *        - If arr[mid] == 1:
 *            - Candidate found: ans = mid
 *            - Check for an earlier occurrence on the left: high = mid - 1
 *        - Else (arr[mid] == 0):
 *            - 1 must be to the right: low = mid + 1
 *    - Return ans.
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 */
public class Problem20_IndexOfFirst1 {

    // Approach 1: Linear Search - O(n) Time, O(1) Space
    public static int firstIndexLinear(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    // Approach 2: Binary Search (Optimal) - O(log n) Time, O(1) Space
    public static int firstIndex(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == 1) {
                ans = mid;        // Record potential first 1
                high = mid - 1;   // Search left to see if an earlier 1 exists
            } else {
                low = mid + 1;    // 1 must be in the right half
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard mixed array
        int[] arr1 = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        System.out.println("Test Case 1: " + Arrays.toString(arr1));
        System.out.println("Linear Search : " + firstIndexLinear(arr1)); // Expected: 6
        System.out.println("Binary Search : " + firstIndex(arr1));       // Expected: 6

        // Test Case 2: No 1s present
        int[] arr2 = {0, 0, 0, 0};
        System.out.println("\nTest Case 2: " + Arrays.toString(arr2));
        System.out.println("Linear Search : " + firstIndexLinear(arr2)); // Expected: -1
        System.out.println("Binary Search : " + firstIndex(arr2));       // Expected: -1

        // Test Case 3: All 1s
        int[] arr3 = {1, 1, 1, 1, 1};
        System.out.println("\nTest Case 3: " + Arrays.toString(arr3));
        System.out.println("Linear Search : " + firstIndexLinear(arr3)); // Expected: 0
        System.out.println("Binary Search : " + firstIndex(arr3));       // Expected: 0

        // Test Case 4: Only a single 1 at the end
        int[] arr4 = {0, 0, 0, 0, 1};
        System.out.println("\nTest Case 4: " + Arrays.toString(arr4));
        System.out.println("Linear Search : " + firstIndexLinear(arr4)); // Expected: 4
        System.out.println("Binary Search : " + firstIndex(arr4));       // Expected: 4

        // Test Case 5: Single element array [0]
        int[] arr5 = {0};
        System.out.println("\nTest Case 5: " + Arrays.toString(arr5));
        System.out.println("Binary Search : " + firstIndex(arr5));       // Expected: -1

        // Test Case 6: Single element array [1]
        int[] arr6 = {1};
        System.out.println("\nTest Case 6: " + Arrays.toString(arr6));
        System.out.println("Binary Search : " + firstIndex(arr6));       // Expected: 0
    }
}
