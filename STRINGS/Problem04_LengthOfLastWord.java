package STRINGS;

/**
 * Problem 04: Length of Last Word
 * LeetCode 58: Length of Last Word
 * URL: https://leetcode.com/problems/length-of-last-word/description/
 * 
 * Problem Statement:
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * Examples:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * 
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * 
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * 
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 * 
 * Intuition & Algorithm:
 * - Start from the end of the string (`i = s.length() - 1`).
 * - Step 1: Skip any trailing spaces (`s.charAt(i) == ' '`).
 * - Step 2: Once the last word's end character is reached, count characters until encountering the next space or reaching index < 0.
 * - Return the counted length.
 * 
 * Time Complexity: O(n) -> At most one backward traversal of the string.
 * Space Complexity: O(1) -> No additional memory or array creation needed.
 */
public class Problem04_LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {
        String s1 = "Hello World";
        System.out.println("s = \"" + s1 + "\" -> " + lengthOfLastWord(s1)); // Expected: 5

        String s2 = "   fly me   to   the moon  ";
        System.out.println("s = \"" + s2 + "\" -> " + lengthOfLastWord(s2)); // Expected: 4

        String s3 = "luffy is still joyboy";
        System.out.println("s = \"" + s3 + "\" -> " + lengthOfLastWord(s3)); // Expected: 6

        String s4 = "a";
        System.out.println("s = \"" + s4 + "\" -> " + lengthOfLastWord(s4)); // Expected: 1
    }
}
