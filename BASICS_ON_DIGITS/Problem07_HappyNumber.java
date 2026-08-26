package BASICS_ON_DIGITS;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 202: Happy Number
 * URL: https://leetcode.com/problems/happy-number/
 * 
 * Problem Statement:
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * - Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * 
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1 (Happy!)
 * 
 * Example 2:
 * Input: n = 2
 * Output: false (Enters cycle: 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4)
 * 
 * Approaches:
 * 1. HashSet Cycle Detection:
 *    - Store visited sums in a Set. If a sum repeats before reaching 1, return false.
 * 
 * 2. Floyd's Tortoise and Hare (Slow & Fast Pointers - Optimal O(1) Space):
 *    - `slow` advances 1 step, `fast` advances 2 steps.
 *    - If `fast == 1`, return true. If `slow == fast`, cycle detected -> return false.
 */
public class Problem07_HappyNumber {

    // Helper: Calculate sum of squares of digits
    public static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    // Approach 1: HashSet Cycle Detection
    public static boolean isHappySet(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    // Approach 2: Floyd's Cycle Detection (O(1) Space)
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    public static void main(String[] args) {
        System.out.println("n = 19 -> " + isHappy(19)); // Expected: true
        System.out.println("n = 2 -> " + isHappy(2));   // Expected: false
    }
}
