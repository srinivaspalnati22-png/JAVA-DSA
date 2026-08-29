package STRINGS;

/**
 * Problem 01: Last Index of One
 * GFG URL: https://www.geeksforgeeks.org/problems/last-index-of-15847/1
 * 
 * Problem Statement:
 * Given a string s consisting of only '0's and '1's, find the last index of the '1' present in it.
 * If '1' is not present in the string, return -1.
 * 
 * Examples:
 * Input: s = "00001"
 * Output: 4
 * Explanation: Last index of  1 in given string is 4.
 * 
 * Input: s = "0"
 * Output: -1
 * Explanation: Since, 1 is not present, so output is -1.
 * 
 * Input: s = "1"
 * Output: 0
 * 
 * Constraints:
 * 1 <= |s| <= 10^6
 * s contains only '0' and '1'
 * 
 * Intuition & Algorithm:
 * - Since we need to find the *last* occurrence of '1', we can traverse the string in reverse (from right to left).
 * - Start iterating from `i = s.length() - 1` down to `0`.
 * - If `s.charAt(i) == '1'`, return `i` immediately (the first '1' from right is the last '1' overall).
 * - If loop ends without encountering '1', return `-1`.
 * 
 * Time Complexity: O(n) -> Worst case passes once through the string.
 * Space Complexity: O(1) -> Uses only a constant amount of auxiliary space.
 */
public class Problem01_LastIndexOfOne {

    public static int lastIndex(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "00001";
        System.out.println("s = \"" + s1 + "\" -> " + lastIndex(s1)); // Expected: 4

        String s2 = "0";
        System.out.println("s = \"" + s2 + "\" -> " + lastIndex(s2)); // Expected: -1

        String s3 = "1";
        System.out.println("s = \"" + s3 + "\" -> " + lastIndex(s3)); // Expected: 0

        String s4 = "0101100";
        System.out.println("s = \"" + s4 + "\" -> " + lastIndex(s4)); // Expected: 4
    }
}
