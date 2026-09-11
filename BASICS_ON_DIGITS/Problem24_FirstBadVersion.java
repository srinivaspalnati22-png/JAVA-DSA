package BASICS_ON_DIGITS;

/**
 * LeetCode 278: First Bad Version
 * URL: https://leetcode.com/problems/first-bad-version/
 * 
 * Problem Statement:
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, all the versions 
 * after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
 * which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which returns whether version is bad. 
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * 
 * Example 1:
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * 
 * Example 2:
 * Input: n = 1, bad = 1
 * Output: 1
 * 
 * Constraints:
 * 1 <= bad <= n <= 2^31 - 1 (2,147,483,647 in digits)
 * 
 * Key Insights & Intuition:
 * - Monotonicity: Versions before the first bad version are all false, and versions from the first bad version onwards are all true:
 *     [F, F, F, ..., F, T, T, ..., T]
 * - Binary Search: Because of this sorted monotonic partition, we can find the boundary in O(log n) API calls.
 * - Integer Overflow: n can be up to 2^31 - 1 (Integer.MAX_VALUE = 2147483647).
 *   Computing `(low + high) / 2` will cause signed 32-bit integer overflow!
 *   Must use `mid = low + (high - low) / 2` or `(low + high) >>> 1`.
 * 
 * Approaches:
 * 
 * 1. Approach 1: Linear Search (Brute Force)
 *    - Scan sequentially from version 1 to n calling isBadVersion(i).
 *    - The first version returning true is the answer.
 *    - Time Complexity: O(n) -> TLE when n = 2^31 - 1 (~2.14 billion calls).
 *    - Space Complexity: O(1)
 * 
 * 2. Approach 2: Binary Search with Candidate Variable (Optimal & Safe)
 *    - Maintain search space [low, high] where low = 1, high = n.
 *    - Compute mid = low + (high - low) / 2.
 *    - If isBadVersion(mid) is true:
 *        - Record ans = mid.
 *        - Look for an earlier bad version on the left: high = mid - 1.
 *    - If isBadVersion(mid) is false:
 *        - The first bad version must be to the right: low = mid + 1.
 *    - Time Complexity: O(log n) -> At most 31 API calls for n = 2^31 - 1.
 *    - Space Complexity: O(1)
 * 
 * 3. Approach 3: Binary Search Boundary Convergence (low < high)
 *    - Maintain [low, high] where low = 1, high = n.
 *    - When isBadVersion(mid) is true: high = mid (keep mid in range since it could be the first bad version).
 *    - When isBadVersion(mid) is false: low = mid + 1 (mid cannot be bad, search right).
 *    - Loop terminates when low == high, which points directly to the first bad version.
 *    - Time Complexity: O(log n)
 *    - Space Complexity: O(1)
 */

// Simulated base class representing LeetCode's pre-defined VersionControl API
class VersionControl {
    protected static int firstBadVersionNumber;

    public static void setBadVersion(int bad) {
        firstBadVersionNumber = bad;
    }

    /**
     * Pre-defined API:
     * @param version the version number to check
     * @return true if version is bad, false otherwise
     */
    public static boolean isBadVersion(int version) {
        return version >= firstBadVersionNumber;
    }
}

public class Problem24_FirstBadVersion extends VersionControl {

    /**
     * Approach 1: Linear Search (Brute Force - O(n))
     * Will result in Time Limit Exceeded (TLE) for large n.
     */
    public static int firstBadVersionLinear(int n) {
        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return n;
    }

    /**
     * Approach 2: Binary Search with Answer Variable (Optimal - O(log n))
     * Uses safe midpoint calculation `low + (high - low) / 2` to avoid integer overflow.
     */
    public static int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int ans = n;

        while (low <= high) {
            // Safe midpoint calculation prevents 32-bit signed integer overflow
            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                ans = mid;        // mid is bad, record as candidate
                high = mid - 1;   // search left for potentially earlier bad version
            } else {
                low = mid + 1;    // mid is good, search right
            }
        }

        return ans;
    }

    /**
     * Approach 3: Binary Search Boundary Convergence (low < high) - O(log n)
     * Shrinks the interval until low == high.
     */
    public static int firstBadVersionBoundary(int n) {
        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                high = mid;      // First bad version is at mid or to the left
            } else {
                low = mid + 1;   // First bad version is strictly to the right
            }
        }

        return low; // low == high points to the first bad version
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       LeetCode 278: First Bad Version");
        System.out.println("==================================================");

        // Test Case 1
        int n1 = 5, bad1 = 4;
        setBadVersion(bad1);
        int ans1 = firstBadVersion(n1);
        System.out.println("Test 1: n = 5, bad = 4");
        System.out.println("Binary Search (ans)      : " + ans1 + " | Passed: " + (ans1 == bad1));
        System.out.println("Binary Search (boundary) : " + firstBadVersionBoundary(n1) + " | Passed: " + (firstBadVersionBoundary(n1) == bad1));

        // Test Case 2
        int n2 = 1, bad2 = 1;
        setBadVersion(bad2);
        int ans2 = firstBadVersion(n2);
        System.out.println("\nTest 2: n = 1, bad = 1");
        System.out.println("Binary Search (ans)      : " + ans2 + " | Passed: " + (ans2 == bad2));
        System.out.println("Binary Search (boundary) : " + firstBadVersionBoundary(n2) + " | Passed: " + (firstBadVersionBoundary(n2) == bad2));

        // Test Case 3
        int n3 = 3, bad3 = 2;
        setBadVersion(bad3);
        int ans3 = firstBadVersion(n3);
        System.out.println("\nTest 3: n = 3, bad = 2");
        System.out.println("Binary Search (ans)      : " + ans3 + " | Passed: " + (ans3 == bad3));
        System.out.println("Binary Search (boundary) : " + firstBadVersionBoundary(n3) + " | Passed: " + (firstBadVersionBoundary(n3) == bad3));

        // Test Case 4: Max constraint edge case (tests integer overflow prevention)
        int n4 = Integer.MAX_VALUE; // 2147483647
        int bad4 = 1701199199;
        setBadVersion(bad4);
        int ans4 = firstBadVersion(n4);
        System.out.println("\nTest 4 (Integer Overflow Prevention):");
        System.out.println("n = 2147483647 (Integer.MAX_VALUE), bad = " + bad4);
        System.out.println("Binary Search (ans)      : " + ans4 + " | Passed: " + (ans4 == bad4));
        System.out.println("Binary Search (boundary) : " + firstBadVersionBoundary(n4) + " | Passed: " + (firstBadVersionBoundary(n4) == bad4));

        System.out.println("==================================================");
    }
}
