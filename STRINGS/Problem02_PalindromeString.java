package STRINGS;

/**
 * Problem 02: Palindrome String
 * GFG URL: https://www.geeksforgeeks.org/problems/palindrome-string0817/1
 * 
 * Problem Statement:
 * You are given a string s. Your task is to determine if the string is a palindrome.
 * A string is called a palindrome if it reads the same backward as forward.
 * 
 * Examples:
 * Input: s = "abba"
 * Output: true
 * Explanation: "abba" reads the same forward and backward.
 * 
 * Input: s = "abc"
 * Output: false
 * Explanation: "abc" does not read the same forward and backward.
 * 
 * Constraints:
 * 1 <= s.length() <= 2 * 10^5
 * The string s contains only lowercase English letters.
 * 
 * Intuition & Algorithm:
 * - Two-pointer technique:
 *   - Place pointer `left` at index 0 and `right` at index `s.length() - 1`.
 *   - While `left < right`:
 *       - If `s.charAt(left) != s.charAt(right)`, the string is not a palindrome -> return `false`.
 *       - Increment `left++` and decrement `right--`.
 *   - If all matching characters match until pointers meet/cross, return `true`.
 * 
 * Time Complexity: O(n) -> At most n / 2 comparisons.
 * Space Complexity: O(1) -> In-place pointer traversal without extra allocations.
 */
public class Problem02_PalindromeString {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abba";
        System.out.println("s = \"" + s1 + "\" -> " + isPalindrome(s1)); // Expected: true

        String s2 = "abc";
        System.out.println("s = \"" + s2 + "\" -> " + isPalindrome(s2)); // Expected: false

        String s3 = "racecar";
        System.out.println("s = \"" + s3 + "\" -> " + isPalindrome(s3)); // Expected: true

        String s4 = "a";
        System.out.println("s = \"" + s4 + "\" -> " + isPalindrome(s4)); // Expected: true
    }
}
