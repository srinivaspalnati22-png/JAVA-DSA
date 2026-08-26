package BASICS_ON_DIGITS;

/**
 * LeetCode 69: Sqrt(x)
 * URL: https://leetcode.com/problems/sqrtx/
 * 
 * Problem Statement:
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 * 
 * Example 1:
 * Input: x = 4
 * Output: 2
 * 
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down, 2 is returned.
 * 
 * Constraints:
 * 0 <= x <= 2^31 - 1
 * 
 * Approaches:
 * 1. Linear Scan (User Solution):
 *    - Loop `i` while `i * i <= x`.
 *    - Time Complexity: O(sqrt(x))
 * 
 * 2. Binary Search (Optimal O(log x)):
 *    - Search space is [1, x].
 *    - `mid = low + (high - low) / 2`.
 *    - If `mid <= x / mid`, record `ans = mid` and search right: `low = mid + 1`.
 *    - Otherwise, search left: `high = mid - 1`.
 *    - Note: Using `mid <= x / mid` prevents 32-bit integer overflow!
 *    - Time Complexity: O(log x)
 *    - Space Complexity: O(1)
 */
public class Problem19_SqrtX {

    // Approach 1: Linear Scan (User Solution)
    public static int mySqrtLinear(int x) {
        int ans = 0;
        for (long i = 1; i * i <= x; i++) {
            ans = (int) i;
        }
        return ans;
    }

    // Approach 2: Binary Search (Optimal O(log x))
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int low = 1, high = x;
        int ans = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= x / mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("sqrt(4) -> " + mySqrt(4));   // Expected: 2
        System.out.println("sqrt(8) -> " + mySqrt(8));   // Expected: 2
        System.out.println("sqrt(2147395599) -> " + mySqrt(2147395599)); // Expected: 46339
    }
}
