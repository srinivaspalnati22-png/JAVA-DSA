# 🔍 14. Linear Search in Java

---

## 📌 1. What Is Linear Search?

**Linear Search** (also known as **Sequential Search**) is the simplest and most fundamental searching algorithm in Computer Science. 

It works by inspecting each element in a data structure (such as an array or list) **one by one, in sequence (from start to finish)**, until either:
1. The **target element is found** (Search Successful $\to$ Return index or value).
2. The **entire collection is exhausted** without finding the target (Search Unsuccessful $\to$ Return `-1` or `false`).

$$\text{Input Array } [a_0, a_1, a_2, \dots, a_{n-1}] \quad \xrightarrow{\text{Compare with Target } T} \quad \begin{cases} \text{Match found at index } i & \to \mathbf{\text{Return } i} \\ \text{End reached with no match} & \to \mathbf{\text{Return } -1} \end{cases}$$

```
                           ┌───────────────────────────────┐
                           │    LINEAR SEARCH PRINCIPLE    │
                           └──────────────┬────────────────┘
                                          │
    ┌─────────────┬─────────────┬─────────┴───┬─────────────┬─────────────┐
    ▼             ▼             ▼             ▼             ▼             ▼
┌───────┐     ┌───────┐     ┌───────┐     ┌───────┐     ┌───────┐     ┌───────┐
│ arr[0]│ ──> │ arr[1]│ ──> │ arr[2]│ ──> │ arr[3]│ ──> │ arr[4]│ ──> │ arr[5]│
└───────┘     └───────┘     └───────┘     └───────┘     └───────┘     └───────┘
  idx 0         idx 1         idx 2         idx 3         idx 4         idx 5
  Check?        Check?        Check?        MATCH! 🎯
                                            (Stop & Return 3)
```

---

### 📚 Real-World Analogies

| Real-World Scenario | How It Matches Linear Search |
| :--- | :--- |
| 📖 **Unorganized Bookshelf** | Looking for a specific book on an unsorted shelf: You scan titles from the leftmost book to the rightmost book one by one until you find it. |
| 🔑 **Keychain in the Dark** | Trying keys on an unmarked keyring one by one until one fits the lock. |
| 🃏 **Unsorted Deck of Cards** | Searching for the "Ace of Spades" by flipping cards off the top of an unarranged deck one card at a time. |
| 🛒 **Grocery Store Aisle** | Walking down an unsorted clearance bin looking for your favorite cereal box. |

---

## 🎯 2. Step-by-Step Visual Execution Trace

Let's trace how Linear Search searches for `Target = 28` in the following array of 6 integers:
`arr = [14, 52, 28, 9, 33, 7]`

```
Array:      [ 14 ,  52 ,  28 ,   9 ,  33 ,   7 ]
Indices:       0     1     2     3     4     5
Target:     28

=============================================================================
Step 1: i = 0
-----------------------------------------------------------------------------
  Pointer:     [14]   52    28     9    33     7
  Check:       arr[0] == 28  =>  14 == 28 ?  ❌ FALSE
  Action:      Advance pointer (i++)

=============================================================================
Step 2: i = 1
-----------------------------------------------------------------------------
  Pointer:      14   [52]   28     9    33     7
  Check:       arr[1] == 28  =>  52 == 28 ?  ❌ FALSE
  Action:      Advance pointer (i++)

=============================================================================
Step 3: i = 2
-----------------------------------------------------------------------------
  Pointer:      14    52   [28]    9    33     7
  Check:       arr[2] == 28  =>  28 == 28 ?  ✅ TRUE (TARGET FOUND!)
  Action:      Immediately return Index = 2 (Early Exit)
=============================================================================
```

### ❌ Case: Target Not Present (`Target = 99`)
If searching for `99`:
- `i=0` $\to$ `14 != 99`
- `i=1` $\to$ `52 != 99`
- `i=2` $\to$ `28 != 99`
- `i=3` $\to$ `9 != 99`
- `i=4` $\to$ `33 != 99`
- `i=5` $\to$ `7 != 99`
- Loop terminates (`i == arr.length`). We exit loop and return `-1` (Not Found).

---

## 🏗️ 3. Algorithm & Pseudocode

```
Algorithm LinearSearch(arr, target):
    1. If arr is null or length is 0:
           Return -1
    2. For each index i from 0 to (arr.length - 1):
           a. If arr[i] equals target:
                  Return i          // Target found at index i
    3. Return -1                    // Target was not found in the array
```

```
                          ┌──────────────────────────┐
                          │   Start: search(arr, T)  │
                          └────────────┬─────────────┘
                                       │
                                       ▼
                          ┌──────────────────────────┐
                          │      Is arr empty?       │─── YES ───> [ Return -1 ]
                          └────────────┬─────────────┘
                                       │ NO
                                       ▼
                          ┌──────────────────────────┐
                          │     Initialize i = 0     │
                          └────────────┬─────────────┘
                                       │
                         ┌─────────────┴─────────────┐
                         ▼                           │
              ┌─────────────────────┐                │
              │    i < arr.length?  │─── NO ──┐      │
              └──────────┬──────────┘         │      │
                         │ YES                │      │
                         ▼                    │      │
              ┌─────────────────────┐         │      │
              │   arr[i] == target? │         │      │
              └────┬───────────┬────┘         │      │
                   │ YES       │ NO           │      │
                   │           ▼              │      │
                   │     ┌───────────┐        │      │
                   │     │   i = i+1 │────────┘      │
                   │     └───────────┘               │
                   ▼                                 ▼
         [ Return index i ]                  [ Return -1 ]
```

---

## 💻 4. Comprehensive Java Implementations

---

### 1️⃣ Standard Linear Search (Returns Index)
Returns the zero-based index of the target if present, otherwise returns `-1`.

```java
public class LinearSearch {

    /**
     * Searches for a target integer in an array.
     * @param arr The array to search
     * @param target The value to locate
     * @return Zero-based index if found, or -1 if not found
     */
    public static int linearSearch(int[] arr, int target) {
        // Edge Case: Check for null or empty array
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // Sequential scan from index 0 to arr.length - 1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Early Exit: Match found!
            }
        }

        // If loop finished without returning, target does not exist
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {18, 12, 9, 73, 77, 50};
        int target = 73;

        int resultIndex = linearSearch(numbers, target);

        if (resultIndex != -1) {
            System.out.println("Target " + target + " found at index: " + resultIndex);
        } else {
            System.out.println("Target " + target + " was not found.");
        }
    }
}
```

---

### 2️⃣ Linear Search Returning Boolean (Existence Check)
When you only care about whether an element exists, not its index:

```java
public static boolean contains(int[] arr, int target) {
    if (arr == null) return false;

    // Enhanced for-each loop can be used when index is not needed
    for (int element : arr) {
        if (element == target) {
            return true;
        }
    }
    return false;
}
```

---

### 3️⃣ Linear Search on Strings & Characters

Searching for a character inside a String or character array:

```java
public class StringSearch {

    /**
     * Search character in a string using charAt(i)
     */
    public static int searchCharacter(String str, char target) {
        if (str == null || str.length() == 0) {
            return -1;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Search string inside an array of Strings (Case-sensitive / Case-insensitive)
     */
    public static int searchString(String[] words, String target) {
        if (words == null || target == null) {
            return -1;
        }

        for (int i = 0; i < words.length; i++) {
            // ALWAYS use .equals() for String content comparison in Java!
            if (target.equals(words[i])) {
                return i;
            }
        }
        return -1;
    }
}
```

> ⚠️ **Java String Trap:** Never use `target == words[i]` for Strings! `==` compares object memory references, not String contents. Always use `.equals()` or `.equalsIgnoreCase()`.

---

### 4️⃣ Linear Search in a Specified Range `[start, end]`

Allows searching only within a subarray from index `start` to index `end` (inclusive):

```java
public static int searchInRange(int[] arr, int target, int start, int end) {
    // Validate bounds
    if (arr == null || arr.length == 0) return -1;
    if (start < 0 || end >= arr.length || start > end) return -1;

    for (int i = start; i <= end; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}
```

---

### 5️⃣ Finding Minimum and Maximum Elements

Linear Search is the standard algorithm to find the smallest and largest values in an unsorted array:

```java
public class MinMaxSearch {

    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int minVal = arr[0]; // Assume first element is minimum
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i]; // Update minimum
            }
        }
        return minVal;
    }

    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int maxVal = arr[0]; // Assume first element is maximum
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i]; // Update maximum
            }
        }
        return maxVal;
    }
}
```

---

### 6️⃣ Linear Search in 2D Arrays (Matrices)

Searching through a grid of rows and columns ($R \times C$):

```java
public class Search2DArray {

    /**
     * Searches for target in a 2D matrix.
     * @return int[] containing {rowIndex, colIndex}, or {-1, -1} if not found.
     */
    public static int[] searchIn2D(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{-1, -1};
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target) {
                    return new int[]{row, col}; // Found at (row, col)
                }
            }
        }
        return new int[]{-1, -1}; // Not found
    }
}
```

```
Matrix (3 x 3):
[ [12, 45, 78],
  [33, 89, 21],
  [56, 90, 64] ]
Target: 89
Search Path: (0,0) -> (0,1) -> (0,2) -> (1,0) -> (1,1) MATCH! => Returns {1, 1}
```

---

### 7️⃣ Finding All Occurrences (Multiple Matches)

When an element appears multiple times and you need all matching indices:

```java
import java.util.ArrayList;
import java.util.List;

public static List<Integer> findAllOccurrences(int[] arr, int target) {
    List<Integer> indices = new ArrayList<>();
    if (arr == null) return indices;

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            indices.add(i); // Collect every matching index
        }
    }
    return indices;
}
```

---

## ⏱️ 5. Time & Space Complexity Analysis

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                     LINEAR SEARCH COMPLEXITY BREAKDOWN                      │
├────────────────────┬──────────────────┬─────────────────────────────────────┤
│ Metric             │ Complexity       │ Scenario / Explanation              │
├────────────────────┼──────────────────┼─────────────────────────────────────┤
│ 🟢 Best Case Time  │ $O(1)$           │ Target is at the very first index   │
│                    │                  │ (index 0). Only 1 comparison made.  │
├────────────────────┼──────────────────┼─────────────────────────────────────┤
│ 🔴 Worst Case Time │ $O(N)$           │ Target is at the last index ($N-1$) │
│                    │                  │ or NOT in the array. All $N$ checked│
├────────────────────┼──────────────────┼─────────────────────────────────────┤
│ 🟡 Average Case    │ $O(N)$           │ Target is in the middle.            │
│                    │                  │ Avg comparisons: $\frac{N+1}{2}$    │
├────────────────────┼──────────────────┼─────────────────────────────────────┤
│ 📦 Auxiliary Space │ $O(1)$           │ Constant extra memory. In-place     │
│                    │                  │ iteration with only loop pointers.  │
├────────────────────┼──────────────────┼─────────────────────────────────────┤
│ 🗄️ 2D Matrix Time  │ $O(R \times C)$  │ Must check all rows and columns in  │
│                    │                  │ worst case ($R$ rows, $C$ columns). │
└────────────────────┴──────────────────┴─────────────────────────────────────┘
```

### 🧮 Mathematical Proof for Average Case Time Complexity:
Assuming the target is uniformly distributed across all $N$ positions with equal probability $P(i) = \frac{1}{N}$:

$$\text{Average Comparisons} = \sum_{i=1}^{N} i \cdot P(i) = \frac{1}{N} \sum_{i=1}^{N} i = \frac{1}{N} \cdot \frac{N(N+1)}{2} = \frac{N+1}{2}$$

$$\lim_{N \to \infty} \frac{N+1}{2} \implies \mathbf{O(N)}$$

---

## ⚖️ 6. Linear Search vs. Binary Search

| Comparison Dimension | 🔍 Linear Search | ⚡ Binary Search |
| :--- | :--- | :--- |
| **Prerequisite / Condition** | **None** (Works on sorted & unsorted data) | **Strictly required: Sorted Data** |
| **Time Complexity (Worst)** | $O(N)$ | $O(\log N)$ |
| **Time Complexity (Best)** | $O(1)$ | $O(1)$ |
| **Space Complexity** | $O(1)$ | $O(1)$ iterative, $O(\log N)$ recursive |
| **Data Structure Support** | Arrays, Linked Lists, Streams, Files | Arrays, ArrayLists (Random Access $O(1)$) |
| **Algorithm Strategy** | Sequential Brute-Force | Divide and Conquer |
| **Performance on $N=1,000,000$** | Up to $1,000,000$ comparisons | Max $\approx 20$ comparisons ($\log_2 10^6$) |
| **Best Used When** | Small arrays ($N \le 50$), Unsorted data, Single search query | Large datasets ($N > 100$), Repeated lookups on sorted data |

> 💡 **Rule of Thumb:** If data is **unsorted** and you only search **once**, Linear Search $O(N)$ is faster than sorting first ($O(N \log N)$) and then binary searching ($O(\log N)$)!

---

## ⚠️ 7. Common Pitfalls & Traps to Avoid

### ❌ Pitfall 1: Premature Return in Loop (The "Immediate -1" Bug)
Putting the `return -1;` inside the `for` loop body instead of after the loop ends:

```java
// ❌ INCORRECT (Returns -1 after checking ONLY index 0!)
public static int badSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        } else {
            return -1; // 💥 BUG: Stops the entire search on the first mismatch!
        }
    }
    return -1;
}

// ✅ CORRECT: Let the loop finish before concluding target is missing
public static int goodSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i; // Only return when matched
        }
    }
    return -1; // Return -1 ONLY after checking all elements
}
```

---

### ❌ Pitfall 2: Off-By-One Index Boundary Error
Using `<=` instead of `<` on `arr.length`:

```java
// ❌ INCORRECT (Throws ArrayIndexOutOfBoundsException at i = arr.length)
for (int i = 0; i <= arr.length; i++) { ... }

// ✅ CORRECT
for (int i = 0; i < arr.length; i++) { ... }
```

---

### ❌ Pitfall 3: Using `==` on Object Reference Comparisons
Comparing Strings or custom objects with `==`:

```java
String[] names = {"Alice", "Bob", "Charlie"};
String query = new String("Bob");

// ❌ WRONG: query == names[1] evaluates to false due to different memory addresses
// ✅ CORRECT: query.equals(names[i])
```

---

### ❌ Pitfall 4: Neglecting Null or Empty Arrays
Calling `.length` on a null reference throws a `NullPointerException`:

```java
// ✅ ALWAYS check for null before accessing length or elements
if (arr == null || arr.length == 0) {
    return -1;
}
```

---

## 💡 8. Classic Interview Problems Solved via Linear Search

### 🎯 Problem 1: Find Numbers with Even Number of Digits (LeetCode 1295)
*Given an array `nums` of integers, return how many of them contain an **even** number of digits.*

```java
public class EvenDigits {

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (hasEvenDigits(num)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasEvenDigits(int num) {
        int digitCount = countDigits(num);
        return digitCount % 2 == 0;
    }

    private static int countDigits(int num) {
        if (num < 0) num = num * -1; // Handle negatives
        if (num == 0) return 1;
        
        // Fast digit count using Math.log10
        return (int) (Math.log10(num)) + 1;
    }
}
```

---

### 🎯 Problem 2: Richest Customer Wealth (LeetCode 1672)
*You are given an `m x n` integer grid `accounts` where `accounts[i][j]` is the money the $i^{\text{th}}$ customer has in the $j^{\text{th}}$ bank. Return the wealth that the richest customer has.*

```java
public class RichestCustomer {

    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int person = 0; person < accounts.length; person++) {
            int personWealth = 0;
            for (int bank = 0; bank < accounts[person].length; bank++) {
                personWealth += accounts[person][bank];
            }
            if (personWealth > maxWealth) {
                maxWealth = personWealth;
            }
        }
        return maxWealth;
    }
}
```

---

## 🧠 9. Summary & Quick Reference Card

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                         LINEAR SEARCH QUICK SUMMARY                         │
├─────────────────────────────────────────────────────────────────────────────┤
│ • Core Mechanism   : Sequentially compare target with each element from     │
│                      left to right.                                         │
│ • Unsorted Friendly: YES — Does NOT require data to be sorted.             │
│ • Best Case Time   : O(1) (First element is target)                         │
│ • Worst Case Time  : O(N) (Target at end or absent)                         │
│ • Average Time     : O(N) ((N + 1) / 2 comparisons)                         │
│ • Space Complexity : O(1) (In-place, constant auxiliary space)              │
│ • Standard Output  : Index of element (0 to N-1) or -1 if not found.        │
│ • Primary Use Cases: Small arrays, Unsorted lists, Singly Linked Lists,     │
│                      One-off queries where sorting overhead is wasteful.     │
└─────────────────────────────────────────────────────────────────────────────┘
```
