package ARRAYS;

import java.util.Arrays;

/**
 * Problem 22: Find Smallest Letter Greater Than Target
 * LeetCode 744: https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * 
 * Problem Statement:
 * You are given an array of characters letters that is sorted in non-decreasing order, 
 * and a character target. There are at least two different characters in letters.
 * 
 * Return the smallest character in letters that is lexicographically greater than target. 
 * If such a character does not exist, return the first character in letters (circular wrap-around).
 * 
 * Examples:
 * Example 1:
 * Input: letters = ["c","f","j"], target = "a"
 * Output: 'c'
 * Explanation: The smallest character lexicographically greater than 'a' is 'c'.
 * 
 * Example 2:
 * Input: letters = ["c","f","j"], target = "c"
 * Output: 'f'
 * Explanation: The smallest character lexicographically greater than 'c' is 'f'.
 * 
 * Example 3:
 * Input: letters = ["x","x","y","y"], target = "z"
 * Output: 'x'
 * Explanation: No character in letters is greater than 'z', so return letters[0].
 * 
 * Constraints:
 * 2 <= letters.length <= 10^4
 * letters[i] is a lowercase English letter.
 * letters is sorted in non-decreasing order.
 * letters contains at least two different characters.
 * target is a lowercase English letter.
 * 
 * Key Insights & Intuition:
 * - Upper Bound Concept: We need the first element strictly greater than `target` (letters[i] > target).
 * - Circular Wrap-around: If target >= letters[letters.length - 1], no such element exists, 
 *   so by problem definition we wrap around to return `letters[0]`.
 * - Binary Search: Since the array is sorted, we can find the upper bound in O(log n) time.
 * 
 * Approaches:
 * 
 * 1. Approach 1: Linear Scan (Brute Force)
 *    - Traverse from index 0 to n - 1.
 *    - The first character with `letters[i] > target` is our answer.
 *    - If no such character is found after full traversal, return `letters[0]`.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Binary Search (Upper Bound with Candidate Variable) - Optimal
 *    - Initialize low = 0, high = n - 1, and ans = letters[0].
 *    - While low <= high:
 *        - mid = low + (high - low) / 2
 *        - If letters[mid] > target:
 *            - Candidate found: ans = letters[mid]
 *            - Check left for a smaller valid character: high = mid - 1
 *        - Else:
 *            - letters[mid] <= target, search right: low = mid + 1
 *    - Return ans.
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 * 
 * 3. Approach 3: Binary Search with Modulo Wrap-Around (Concise)
 *    - While low <= high:
 *        - mid = low + (high - low) / 2
 *        - If letters[mid] <= target: low = mid + 1
 *        - Else: high = mid - 1
 *    - At termination, `low` points to the upper bound index.
 *    - If low == n, `low % n` equals 0, naturally handling the wrap-around!
 *    - Return `letters[low % n]`.
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 */
public class Problem22_FindSmallestLetterGreaterThanTarget {

    // Approach 1: Linear Scan - O(n) Time, O(1) Space
    public static char nextGreatestLetterLinear(char[] letters, char target) {
        for (char ch : letters) {
            if (ch > target) {
                return ch;
            }
        }
        return letters[0]; // Wrap-around
    }

    // Approach 2: Binary Search with Candidate Variable - O(log n) Time, O(1) Space
    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        char ans = letters[0]; // Default wrap-around answer

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] > target) {
                ans = letters[mid]; // Candidate strictly greater than target
                high = mid - 1;     // Try to find a smaller valid character on the left
            } else {
                low = mid + 1;      // Search on the right
            }
        }

        return ans;
    }

    // Approach 3: Binary Search with Modulo Wrap-Around - O(log n) Time, O(1) Space
    public static char nextGreatestLetterModulo(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        int n = letters.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // If low reaches n (target >= all letters), low % n wraps back to 0
        return letters[low % n];
    }

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("  LeetCode 744: Find Smallest Letter Greater Than Target");
        System.out.println("===============================================================");

        // Example 1: target = 'a'
        char[] letters1 = {'c', 'f', 'j'};
        char target1 = 'a';
        System.out.println("Test 1: letters = " + Arrays.toString(letters1) + ", target = '" + target1 + "'");
        System.out.println("Linear Scan        : '" + nextGreatestLetterLinear(letters1, target1) + "'");  // Expected: 'c'
        System.out.println("Binary Search (ans): '" + nextGreatestLetter(letters1, target1) + "'");        // Expected: 'c'
        System.out.println("Binary Search (mod): '" + nextGreatestLetterModulo(letters1, target1) + "'");  // Expected: 'c'

        // Example 2: target = 'c'
        char[] letters2 = {'c', 'f', 'j'};
        char target2 = 'c';
        System.out.println("\nTest 2: letters = " + Arrays.toString(letters2) + ", target = '" + target2 + "'");
        System.out.println("Linear Scan        : '" + nextGreatestLetterLinear(letters2, target2) + "'");  // Expected: 'f'
        System.out.println("Binary Search (ans): '" + nextGreatestLetter(letters2, target2) + "'");        // Expected: 'f'
        System.out.println("Binary Search (mod): '" + nextGreatestLetterModulo(letters2, target2) + "'");  // Expected: 'f'

        // Example 3: target = 'z' (wrap-around)
        char[] letters3 = {'x', 'x', 'y', 'y'};
        char target3 = 'z';
        System.out.println("\nTest 3: letters = " + Arrays.toString(letters3) + ", target = '" + target3 + "'");
        System.out.println("Linear Scan        : '" + nextGreatestLetterLinear(letters3, target3) + "'");  // Expected: 'x'
        System.out.println("Binary Search (ans): '" + nextGreatestLetter(letters3, target3) + "'");        // Expected: 'x'
        System.out.println("Binary Search (mod): '" + nextGreatestLetterModulo(letters3, target3) + "'");  // Expected: 'x'

        // Example 4: target equals last character (wrap-around)
        char[] letters4 = {'c', 'f', 'j'};
        char target4 = 'j';
        System.out.println("\nTest 4: letters = " + Arrays.toString(letters4) + ", target = '" + target4 + "'");
        System.out.println("Binary Search (ans): '" + nextGreatestLetter(letters4, target4) + "'");        // Expected: 'c'
        System.out.println("Binary Search (mod): '" + nextGreatestLetterModulo(letters4, target4) + "'");  // Expected: 'c'

        // Example 5: target between elements with duplicates
        char[] letters5 = {'e', 'e', 'e', 'k', 'q', 'q', 'u', 'v', 'v', 'y'};
        char target5 = 'e';
        System.out.println("\nTest 5: letters = " + Arrays.toString(letters5) + ", target = '" + target5 + "'");
        System.out.println("Binary Search (ans): '" + nextGreatestLetter(letters5, target5) + "'");        // Expected: 'k'
        System.out.println("Binary Search (mod): '" + nextGreatestLetterModulo(letters5, target5) + "'");  // Expected: 'k'

        System.out.println("===============================================================");
    }
}
