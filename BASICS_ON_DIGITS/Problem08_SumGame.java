package BASICS_ON_DIGITS;

/**
 * LeetCode 1927: Sum Game
 * URL: https://leetcode.com/problems/sum-game/
 * 
 * Problem Statement:
 * Alice and Bob take turns playing a game, with Alice going first.
 * You are given a string `num` of even length consisting of digits and '?'.
 * In each turn, a player replaces a '?' with a digit from '0' to '9'.
 * The game ends when there are no '?' left.
 * Bob wins if the sum of the first half of the digits equals the sum of the second half.
 * Alice wins if the sums are unequal.
 * Return true if Alice wins, or false if Bob wins.
 * 
 * Example 1:
 * Input: num = "5023"
 * Output: false
 * Explanation: 5+0 = 5, 2+3 = 5. Already equal, no '?', Bob wins.
 * 
 * Example 2:
 * Input: num = "25??"
 * Output: true
 * Explanation: Alice can guarantee a win.
 * 
 * Example 3:
 * Input: num = "?3295???"
 * Output: false
 * 
 * Intuition & Game Theory:
 * 1. Count question marks on left (qLeft) and right (qRight).
 * 2. Calculate known sum difference: `diff = sumLeft - sumRight`.
 * 3. Each pair of '?' on the same side can contribute an average of 9 / 2 = 4.5 per question mark.
 * 4. Bob wins IF AND ONLY IF:
 *    - The remaining '?' are balanced such that for every move Alice makes (say digit d), Bob can counter with (9 - d).
 *    - This requires: `sumLeft - sumRight == (qRight - qLeft) * 4.5`
 *    - Cross-multiplying: `2 * diff == 9 * (qRight - qLeft)`
 * 5. Otherwise, Alice has an asymmetric advantage and can force unequal sums.
 * 
 * Time Complexity: O(n) -> Single pass over the string
 * Space Complexity: O(1)
 */
public class Problem08_SumGame {

    public static boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int diff = 0;
        int qLeft = 0;
        int qRight = 0;

        // Left half
        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                qLeft++;
            } else {
                diff += c - '0';
            }
        }

        // Right half
        for (int i = half; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                qRight++;
            } else {
                diff -= c - '0';
            }
        }

        // Bob wins only when: 2 * diff == 9 * (qRight - qLeft)
        // Otherwise Alice wins.
        return 2 * diff != 9 * (qRight - qLeft);
    }

    public static void main(String[] args) {
        System.out.println("num = \"5023\" -> " + sumGame("5023"));   // Expected: false (Bob wins)
        System.out.println("num = \"25??\" -> " + sumGame("25??"));   // Expected: true (Alice wins)
        System.out.println("num = \"?3295???\" -> " + sumGame("?3295???")); // Expected: false (Bob wins)
    }
}
