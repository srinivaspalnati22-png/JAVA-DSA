package STRINGS;

/**
 * Problem 03: Reverse a String
 * GFG URL: https://www.geeksforgeeks.org/problems/reverse-a-string/1
 * 
 * Problem Statement:
 * You are given a string s. You need to reverse the string and return the reversed string.
 * 
 * Examples:
 * Input: s = "Geeks"
 * Output: "skeeG"
 * 
 * Input: s = "for"
 * Output: "rof"
 * 
 * Input: s = "a"
 * Output: "a"
 * 
 * Constraints:
 * 1 <= s.length() <= 10^5
 * s contains only lowercase or uppercase alphabets.
 * 
 * Intuition & Algorithm:
 * - Method 1: Two Pointers on char array (Optimal in-place conversion)
 *   - Convert string to `char[] arr = s.toCharArray()`.
 *   - Use two pointers: `left = 0`, `right = arr.length - 1`.
 *   - Swap `arr[left]` and `arr[right]`, then move `left++` and `right--`.
 *   - Return `new String(arr)`.
 * - Method 2: StringBuilder `reverse()` method.
 * 
 * Time Complexity: O(n) -> Single pass of n/2 swaps.
 * Space Complexity: O(n) -> Char array to hold reversed characters (Java strings are immutable).
 */
public class Problem03_ReverseString {

    // Approach 1: Two Pointer Swap on char array
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    // Approach 2: Using StringBuilder
    public static String reverseStringUsingStringBuilder(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "Geeks";
        System.out.println("s = \"" + s1 + "\" -> " + reverseString(s1)); // Expected: "skeeG"

        String s2 = "for";
        System.out.println("s = \"" + s2 + "\" -> " + reverseString(s2)); // Expected: "rof"

        String s3 = "JavaDSA";
        System.out.println("s = \"" + s3 + "\" -> " + reverseString(s3)); // Expected: "ASDavaJ"
    }
}
