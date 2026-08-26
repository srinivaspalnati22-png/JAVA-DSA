package BASICS_ON_DIGITS;

/**
 * LeetCode 1952: Three Divisors
 * URL: https://leetcode.com/problems/three-divisors/
 * 
 * Problem Statement:
 * Given an integer n, return true if n has exactly three positive divisors. Otherwise, return false.
 * An integer m is a divisor of n if there exists an integer k such that n = k * m.
 * 
 * Example 1:
 * Input: n = 2
 * Output: false
 * Explanation: 2 has only two divisors: 1 and 2.
 * 
 * Example 2:
 * Input: n = 4
 * Output: true
 * Explanation: 4 has three divisors: 1, 2, and 4.
 * 
 * Constraints:
 * 1 <= n <= 10^4
 * 
 * Approaches:
 * 1. Brute Force (Counting Divisors):
 *    - Count divisors from 1 to n. If total count == 3, return true.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(1)
 * 
 * 2. Mathematical Insight (Optimal):
 *    - A number has EXACTLY 3 divisors if and only if it is the square of a PRIME number!
 *    - e.g., 4 (2^2: 1, 2, 4), 9 (3^2: 1, 3, 9), 25 (5^2: 1, 5, 25), 49 (7^2: 1, 7, 49).
 *    - Numbers like 16 (4^2: 1, 2, 4, 8, 16) have 5 divisors because 4 is not prime.
 */
public class Problem02_ThreeDivisors {

    // Approach 1: Counting Divisors (User Solution)
    public static boolean isThree(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count == 3;
    }

    // Approach 2: Optimal O(sqrt(n)) using prime square property
    public static boolean isThreeOptimal(int n) {
        int root = (int) Math.sqrt(n);
        // If n is not a perfect square, it cannot have 3 divisors
        if (root * root != n) return false;
        
        // Check if root is prime
        if (root <= 1) return false;
        for (int i = 2; i * i <= root; i++) {
            if (root % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("n = 2 -> " + isThree(2));   // Expected: false
        System.out.println("n = 4 -> " + isThree(4));   // Expected: true
        System.out.println("n = 9 -> " + isThreeOptimal(9));  // Expected: true
        System.out.println("n = 16 -> " + isThreeOptimal(16)); // Expected: false
    }
}
