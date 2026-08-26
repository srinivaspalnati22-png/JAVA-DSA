package ARRAYS;

/**
 * Problem 09: Search an Element in an Array (Linear Search)
 * GFG URL: https://www.geeksforgeeks.org/problems/search-an-element-in-an-array-1587115621/1
 * 
 * Problem Statement:
 * Given an array arr[] and an integer x, return the 0-based index of the first occurrence of x in the array.
 * If the element is not present, return -1.
 * 
 * Examples:
 * Input: arr = [1, 2, 3, 4], x = 3
 * Output: 2
 * Explanation: 3 is present at index 2.
 * 
 * Input: arr = [10, 8, 30, 4, 5], x = 5
 * Output: 4
 * 
 * Input: arr = [10, 8, 30], x = 6
 * Output: -1
 * 
 * Constraints:
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i], x <= 10^6
 * 
 * Intuition:
 * - Sequentially check each element from index 0 to n-1.
 * - As soon as `arr[i] == x`, return `i`.
 * - If loop terminates without match, return `-1`.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Problem09_SearchElement {

    public static int search(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        System.out.println("Search 3 in [1, 2, 3, 4] -> " + search(arr1, 3)); // Expected: 2

        int[] arr2 = {10, 8, 30};
        System.out.println("Search 6 in [10, 8, 30] -> " + search(arr2, 6)); // Expected: -1
    }
}
