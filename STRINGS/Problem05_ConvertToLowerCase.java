package STRINGS;

/**
 * Problem 05: Java Convert String to Lowercase
 * GFG URL: https://www.geeksforgeeks.org/problems/java-convert-string-to-lowercase/1
 * 
 * Problem Statement:
 * Given a string s. The task is to convert characters of string to lowercase.
 * 
 * Examples:
 * Input: s = "ABCddE"
 * Output: "abcdde"
 * Explanation: The characters 'A', 'B', and 'E' are converted to 'a', 'b', and 'e' respectively.
 * 
 * Input: s = "LMNOppQQ"
 * Output: "lmnoppqq"
 * 
 * Constraints:
 * 1 <= |s| <= 10^5
 * s contains only lowercase and uppercase English alphabets.
 * 
 * Intuition & Algorithm:
 * - Method 1: ASCII Manipulation (Core DSA Approach)
 *   - Each uppercase letter ('A' to 'Z') has ASCII values [65, 90].
 *   - Corresponding lowercase letters ('a' to 'z') have ASCII values [97, 122].
 *   - Difference between lowercase and uppercase is 32 ('a' - 'A' = 32).
 *   - Iterate through characters: if `c >= 'A' && c <= 'Z'`, convert by `(char)(c + 32)`.
 * - Method 2: Built-in `s.toLowerCase()` method.
 * 
 * Time Complexity: O(n) -> Single pass over characters.
 * Space Complexity: O(n) -> Char array for result creation.
 */
public class Problem05_ConvertToLowerCase {

    // Approach 1: ASCII manipulation
    public static String toLower(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

    // Approach 2: Built-in method
    public static String toLowerBuiltin(String s) {
        return s.toLowerCase();
    }

    public static void main(String[] args) {
        String s1 = "ABCddE";
        System.out.println("s = \"" + s1 + "\" -> " + toLower(s1)); // Expected: "abcdde"

        String s2 = "LMNOppQQ";
        System.out.println("s = \"" + s2 + "\" -> " + toLower(s2)); // Expected: "lmnoppqq"

        String s3 = "GeeksForGeeks";
        System.out.println("s = \"" + s3 + "\" -> " + toLower(s3)); // Expected: "geeksforgeeks"
    }
}
