package ARRAYS;

/**
 * Problem 06: Number of Occurrence
 * GFG URL: https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
 * 
 * Problem Statement:
 * Given a sorted array arr[] and a target element target, find the number of occurrences of target in the array.
 * 
 * Examples:
 * Input: arr = [1, 1, 2, 2, 2, 2, 3], target = 2
 * Output: 4
 * 
 * Input: arr = [1, 1, 2, 2, 2, 2, 3], target = 4
 * Output: 0
 * 
 * Constraints:
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i], target <= 10^6
 * 
 * Approaches:
 * 1. Linear Scan:
 *    - Simply count matches in O(n).
 * 
 * 2. Binary Search (Optimal O(log n) since array is sorted):
 *    - Find the First Occurrence (left boundary).
 *    - Find the Last Occurrence (right boundary).
 *    - If element exists: `count = lastIndex - firstIndex + 1`.
 *    - Otherwise: `0`.
 */
public class Problem06_NumberOfOccurrence {

    // Approach 1: Linear Scan O(n)
    public static int countFreqLinear(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    // Approach 2: Binary Search O(log n)
    private static int findFirstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int first = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                first = mid;
                high = mid - 1; // Keep searching left
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    private static int findLastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int last = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                last = mid;
                low = mid + 1; // Keep searching right
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    public static int countFreq(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        if (first == -1) return 0;
        int last = findLastOccurrence(arr, target);
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        System.out.println("Occurrence of 2 -> " + countFreq(arr, 2)); // Expected: 4
        System.out.println("Occurrence of 4 -> " + countFreq(arr, 4)); // Expected: 0
    }
}
