package ARRAYS;

import java.util.Arrays;

/**
 * Problem 12: Find the Highest Altitude
 * LeetCode 1732: https://leetcode.com/problems/find-the-highest-altitude/
 * 
 * Problem Statement:
 * There is a biker going on a road trip. The road trip consists of n + 1 points at various altitudes.
 * The biker starts his trip on point 0 with altitude equal to 0.
 * 
 * You are given an integer array gain of length n where gain[i] is the net gain in altitude
 * between points i and i + 1 for all (0 <= i < n).
 * 
 * Return the highest altitude of a point.
 * 
 * Examples:
 * Example 1:
 * Input: gain = [-5, 1, 5, 0, -7]
 * Output: 1
 * Explanation: The altitudes are [0, -5, -4, 1, 1, -6]. The highest is 1.
 * 
 * Example 2:
 * Input: gain = [-4, -3, -2, -1, 4, 3, 2]
 * Output: 0
 * Explanation: The altitudes are [0, -4, -7, -9, -10, -6, -3, -1]. The highest is 0.
 * 
 * Constraints:
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 * 
 * Intuition & Approaches:
 * 
 * 1. Concept: Prefix Sum
 *    - Point 0 altitude is always 0.
 *    - Point 1 altitude = 0 + gain[0]
 *    - Point 2 altitude = Point 1 + gain[1] = gain[0] + gain[1]
 *    - In general: altitude[i] = altitude[i-1] + gain[i-1]
 * 
 * 2. Approach 1: Explicit Prefix Sum Array
 *    - Build an array of size n + 1: `altitudes = new int[n + 1]`.
 *    - Fill each point altitude sequentially.
 *    - Find and return the maximum value in `altitudes`.
 *    - Time Complexity: O(n)
 *    - Space Complexity: O(n) auxiliary space
 * 
 * 3. Approach 2: Running Sum / Optimal In-Place Tracking (Recommended)
 *    - Instead of storing all intermediate altitudes, maintain two integer variables:
 *        `currentAltitude = 0`
 *        `maxAltitude = 0` (since biker starts at altitude 0, answer is at least 0)
 *    - In a single pass through `gain`:
 *        `currentAltitude += g`
 *        `maxAltitude = Math.max(maxAltitude, currentAltitude)`
 *    - Time Complexity: O(n) - single pass
 *    - Space Complexity: O(1) - constant auxiliary memory
 */
public class Problem12_FindHighestAltitude {

    // Approach 1: Explicit Prefix Sum Array (O(n) Time, O(n) Space)
    public static int largestAltitudePrefixArray(int[] gain) {
        int n = gain.length;
        int[] altitudes = new int[n + 1];
        altitudes[0] = 0;
        int maxAltitude = 0;

        for (int i = 0; i < n; i++) {
            altitudes[i + 1] = altitudes[i] + gain[i];
            maxAltitude = Math.max(maxAltitude, altitudes[i + 1]);
        }

        return maxAltitude;
    }

    // Approach 2: Optimal Running Sum (O(n) Time, O(1) Space)
    public static int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0; // Starts at point 0 where altitude is 0

        for (int g : gain) {
            currentAltitude += g;
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }

        return maxAltitude;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard example
        int[] gain1 = {-5, 1, 5, 0, -7};
        System.out.println("Test Case 1:");
        System.out.println("gain: " + Arrays.toString(gain1));
        System.out.println("Highest Altitude (Prefix Array): " + largestAltitudePrefixArray(gain1)); // Expected: 1
        System.out.println("Highest Altitude (Running Sum)  : " + largestAltitude(gain1));           // Expected: 1

        // Test Case 2: All negative dips
        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println("\nTest Case 2:");
        System.out.println("gain: " + Arrays.toString(gain2));
        System.out.println("Highest Altitude (Prefix Array): " + largestAltitudePrefixArray(gain2)); // Expected: 0
        System.out.println("Highest Altitude (Running Sum)  : " + largestAltitude(gain2));           // Expected: 0

        // Test Case 3: Strictly ascending gains
        int[] gain3 = {1, 2, 3, 4};
        System.out.println("\nTest Case 3:");
        System.out.println("gain: " + Arrays.toString(gain3));
        System.out.println("Highest Altitude: " + largestAltitude(gain3)); // Expected: 10 (0 -> 1 -> 3 -> 6 -> 10)

        // Test Case 4: Single element positive
        int[] gain4 = {10};
        System.out.println("\nTest Case 4:");
        System.out.println("gain: " + Arrays.toString(gain4));
        System.out.println("Highest Altitude: " + largestAltitude(gain4)); // Expected: 10

        // Test Case 5: Single element negative
        int[] gain5 = {-10};
        System.out.println("\nTest Case 5:");
        System.out.println("gain: " + Arrays.toString(gain5));
        System.out.println("Highest Altitude: " + largestAltitude(gain5)); // Expected: 0
    }
}
