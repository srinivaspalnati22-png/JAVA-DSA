package BASICS_ON_DIGITS;

/**
 * LeetCode 374: Guess Number Higher or Lower
 * URL: https://leetcode.com/problems/guess-number-higher-or-lower/
 * 
 * Problem Statement:
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 * 
 * You call a pre-defined API int guess(int num), which returns three possible results:
 *  -1: Your guess is higher than the number I picked (i.e. num > pick).
 *   1: Your guess is lower than the number I picked (i.e. num < pick).
 *   0: your guess is equal to the number I picked (i.e. num == pick).
 * 
 * Return the number that I picked.
 * 
 * Example 1:
 * Input: n = 10, pick = 6
 * Output: 6
 * 
 * Example 2:
 * Input: n = 1, pick = 1
 * Output: 1
 * 
 * Example 3:
 * Input: n = 2, pick = 1
 * Output: 1
 * 
 * Constraints:
 * 1 <= n <= 2^31 - 1
 * 1 <= pick <= n
 * 
 * Approaches:
 * 
 * 1. Approach 1: Linear Search (Brute Force)
 *    - Guess numbers sequentially from 1 to n.
 *    - In the worst case, requires n API calls.
 *    - Time Complexity: O(n) -> Time Limit Exceeded (TLE) when n = 2^31 - 1 (~2.14 billion).
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Binary Search (Optimal)
 *    - Since numbers from 1 to n are sorted, binary search can halve the search space at each step.
 *    - Maintain search boundaries: low = 1, high = n.
 *    - Calculate middle guess safely to prevent 32-bit signed integer overflow:
 *        mid = low + (high - low) / 2
 *    - Query guess(mid):
 *        res == 0  -> Found target! Return mid.
 *        res == -1 -> Guess is too high (mid > pick), search left: high = mid - 1.
 *        res == 1  -> Guess is too low (mid < pick), search right: low = mid + 1.
 *    - Time Complexity: O(log n) -> Maximum ~31 API calls for n = 2^31 - 1.
 *    - Space Complexity: O(1)
 */

// Simulated base class representing LeetCode's pre-defined GuessGame API
class GuessGame {
    protected static int pickedNumber;

    public static void setPick(int pick) {
        pickedNumber = pick;
    }

    /**
     * Pre-defined API:
     * @param num your guess
     * @return -1 if num > pick, 1 if num < pick, 0 if num == pick
     */
    public static int guess(int num) {
        if (num > pickedNumber) {
            return -1;
        } else if (num < pickedNumber) {
            return 1;
        }
        return 0;
    }
}

public class Problem23_GuessNumberHigherOrLower extends GuessGame {

    /**
     * Approach 1: Linear Search (Brute Force - O(n))
     * Time Limit Exceeded for large n.
     */
    public static int guessNumberLinear(int n) {
        for (int i = 1; i <= n; i++) {
            if (guess(i) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 2: Binary Search (Optimal - O(log n))
     * Uses safe midpoint calculation `low + (high - low) / 2` to avoid integer overflow.
     */
    public static int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            // Safe midpoint to prevent (low + high) 32-bit integer overflow
            int mid = low + (high - low) / 2;
            int res = guess(mid);

            if (res == 0) {
                return mid; // Exact match found
            } else if (res == -1) {
                high = mid - 1; // My guess was higher than pick -> search lower half
            } else {
                low = mid + 1;  // My guess was lower than pick -> search upper half
            }
        }

        return -1; // Unreachable under valid problem constraints
    }

    /**
     * Approach 3: Ternary Search (Alternative - O(log3 n))
     * Divides range into 3 parts using two midpoints.
     */
    public static int guessNumberTernary(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            int res1 = guess(mid1);
            int res2 = guess(mid2);

            if (res1 == 0) return mid1;
            if (res2 == 0) return mid2;

            if (res1 < 0) {
                high = mid1 - 1;
            } else if (res2 > 0) {
                low = mid2 + 1;
            } else {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  LeetCode 374: Guess Number Higher or Lower");
        System.out.println("==================================================");

        // Test Case 1
        int n1 = 10, pick1 = 6;
        setPick(pick1);
        int ans1 = guessNumber(n1);
        System.out.println("Test 1: n = 10, pick = 6");
        System.out.println("Result: " + ans1 + " | Passed: " + (ans1 == pick1));

        // Test Case 2
        int n2 = 1, pick2 = 1;
        setPick(pick2);
        int ans2 = guessNumber(n2);
        System.out.println("\nTest 2: n = 1, pick = 1");
        System.out.println("Result: " + ans2 + " | Passed: " + (ans2 == pick2));

        // Test Case 3
        int n3 = 2, pick3 = 1;
        setPick(pick3);
        int ans3 = guessNumber(n3);
        System.out.println("\nTest 3: n = 2, pick = 1");
        System.out.println("Result: " + ans3 + " | Passed: " + (ans3 == pick3));

        // Test Case 4: Max constraint edge case (tests integer overflow prevention)
        int n4 = Integer.MAX_VALUE, pick4 = 1701199199;
        setPick(pick4);
        int ans4 = guessNumber(n4);
        System.out.println("\nTest 4 (Integer Overflow Prevention):");
        System.out.println("n = 2147483647 (Integer.MAX_VALUE), pick = " + pick4);
        System.out.println("Result: " + ans4 + " | Passed: " + (ans4 == pick4));

        System.out.println("==================================================");
    }
}
