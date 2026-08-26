package BASICS_ON_DIGITS;

/**
 * LeetCode 1872: Stone Game VIII
 * URL: https://leetcode.com/problems/stone-game-viii/
 * 
 * Problem Statement:
 * Alice and Bob play a game. There are n stones arranged in a row.
 * On each player's turn, while the number of stones is more than one, they can:
 * 1. Choose an integer x > 1, and remove the leftmost x stones from the row.
 * 2. Add a new stone to the left whose value equals the sum of the removed stones.
 * 3. The player receives a score equal to the value of the new stone.
 * The game ends when only 1 stone remains.
 * Alice and Bob play optimally to maximize their score minus the opponent's score.
 * Return Alice's score minus Bob's score.
 * 
 * Example 1:
 * Input: stones = [-1, 2, -3, 4, -5]
 * Output: 5
 * 
 * Example 2:
 * Input: stones = [7, -6, 5, 10, 5, -2, -6]
 * Output: 13
 * 
 * Constraints:
 * n == stones.length
 * 2 <= n <= 10^5
 * -10^4 <= stones[i] <= 10^4
 * 
 * Intuition & Game DP:
 * - Notice that picking the first x stones leaves a new stone with value equal to `prefix[x-1]`.
 * - The next player is now faced with a game on the remaining array where any choice of index >= x
 *   still corresponds to a prefix sum of the original array!
 * - Let `dp[i]` be the maximum score difference a player can achieve if the previous player stopped at index `i`.
 * - Transition: `dp[i] = max(dp[i+1], prefix[i] - dp[i+1])`
 * - We can compute backwards from `n-2` down to `1` using a single variable `dp`.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) or O(1) if prefix array is maintained
 */
public class Problem13_StoneGameVIII {

    public static int stoneGameVIII(int[] stones) {
        int n = stones.length;
        long[] prefix = new long[n];
        prefix[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        long dp = prefix[n - 1];

        // Traverse backwards from n-2 down to 1
        for (int i = n - 2; i >= 1; i--) {
            dp = Math.max(dp, prefix[i] - dp);
        }

        return (int) dp;
    }

    public static void main(String[] args) {
        int[] stones1 = {-1, 2, -3, 4, -5};
        System.out.println("stones1 -> " + stoneGameVIII(stones1)); // Expected: 5

        int[] stones2 = {7, -6, 5, 10, 5, -2, -6};
        System.out.println("stones2 -> " + stoneGameVIII(stones2)); // Expected: 13
    }
}
