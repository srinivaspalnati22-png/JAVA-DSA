# ⚡ 15. Binary Search in Java

---

## 📌 1. What Is Binary Search?

**Binary Search** is an ultra-fast, highly optimized searching algorithm designed for **sorted collections** (arrays or lists). 

Instead of checking elements sequentially one by one from left to right like Linear Search, Binary Search uses the **Divide and Conquer** paradigm:
1. It compares the **target** with the element at the **middle index** of the search space.
2. If the middle element matches the target, the search is complete! 🎯
3. If the middle element is **greater than the target**, the target must reside in the **left half**. The entire right half is discarded.
4. If the middle element is **less than the target**, the target must reside in the **right half**. The entire left half is discarded.
5. The process repeats on the remaining half until the target is found or the search window shrinks to zero.

$$\text{Search Space: } [L, R] \quad \xrightarrow{\text{Check Mid } M} \quad \begin{cases} \text{arr}[M] == \text{target} & \implies \mathbf{\text{Found at index } M} \\ \text{arr}[M] < \text{target} & \implies \text{Search Right Half: } [M + 1, R] \\ \text{arr}[M] > \text{target} & \implies \text{Search Left Half: } [L, M - 1] \end{cases}$$

```
                                  ┌────────────────────────────────┐
                                  │    BINARY SEARCH PRINCIPLE     │
                                  └───────────────┬────────────────┘
                                                  │
                 ┌────────────────────────────────┴────────────────────────────────┐
                 │       [ 2,  5,  8, 12, 16, 23, 38, 45, 56, 72, 91 ]             │
                 └────────────────────────────────┬────────────────────────────────┘
                                                  │
                                          Compare Target (23)
                                          with Mid = arr[5] (23)
                                                  │
                                                  ▼
                                      🎯 MATCH FOUND! (O(1) Step)
```

---

### 📚 Real-World Intuition & Analogies

| Real-World Scenario | How It Matches Binary Search |
| :--- | :--- |
| 📖 **Looking up a word in a Physical Dictionary** | You don't read page 1, then page 2. You flip open the middle. If you see "M" and you are looking for "T", you throw away the entire front half ("A" through "M") and flip into the middle of the second half! |
| 🔢 **The "Guess My Number (1 to 100)" Game** | If someone picks a secret number between 1 and 100: Your first guess is **50**. If they say *"Too High"*, you know the answer is between 1 and 49. Your next guess is **25**. You cut the possibilities in half every single guess! |
| 📞 **Searching a Telephone Directory** | Phonebooks are sorted alphabetically by last name. Searching for "Smith" means opening near the back, never scanning from "Aaron". |

---

## ⚡ 2. The Superpower of $O(\log N)$ Time Complexity

Why is Binary Search celebrated as one of the most fundamental algorithms in computer science?

Because cutting the search space in half at each step shrinks massive datasets at an exponential rate:

$$\text{Search space size after } k \text{ steps} = \frac{N}{2^k}$$

When the search space reduces to 1 element:
$$\frac{N}{2^k} = 1 \implies N = 2^k \implies \mathbf{k = \log_2 N}$$

### 📊 Linear Search vs. Binary Search Comparison

| Array Size ($N$) | Linear Search (Worst Case: $N$ checks) | Binary Search (Worst Case: $\approx \log_2 N$ checks) | Speedup Factor |
| :--- | :--- | :--- | :--- |
| **$16$** | 16 comparisons | **4** comparisons | $4\times$ |
| **$1,024$** ($10^3$) | 1,024 comparisons | **10** comparisons | $\approx 100\times$ |
| **$1,000,000$** ($10^6$) | 1,000,000 comparisons | **20** comparisons | $\mathbf{50,000\times}$ |
| **$1,000,000,000$** ($10^9$) | 1,000,000,000 comparisons ($\approx 1\text{ sec}$) | **30** comparisons ($\approx 0.00000003\text{ sec}$) | $\mathbf{33,333,333\times}$ |
| **$4,000,000,000$** ($4\times 10^9$) | 4 Billion operations | **32** comparisons | $\mathbf{125,000,000\times}$ |

> 🚀 **Takeaway:** Even on an array containing the entire population of planet Earth ($\approx 8\text{ Billion}$ entries), Binary Search needs at most **33 comparisons** to find any item!

---

## 🎯 3. Step-by-Step Visual Execution Trace

Let's trace how Binary Search finds `Target = 56` in a sorted array of 9 elements:

`arr = [3, 9, 14, 20, 35, 42, 56, 68, 90]`  
Indices: `0, 1, 2, 3, 4, 5, 6, 7, 8`

```
========================================================================================
INITIAL STATE:
  start = 0, end = 8, target = 56
  mid = start + (end - start) / 2 = 0 + (8 - 0) / 2 = 4
========================================================================================

STEP 1:
  Indices:    0    1    2    3    4    5    6    7    8
  Array:    [ 3,   9,  14,  20,  35,  42,  56,  68,  90 ]
  Pointers:   ▲                   ▲                   ▲
            start                mid                 end

  Check:     arr[mid] == target  =>  arr[4] == 56  =>  35 == 56 ? ❌ (No)
  Compare:   arr[mid] < target   =>  35 < 56 ? ✅ TRUE!
  Action:    Target is LARGER than 35. Discard entire left half [0..4]!
             New start = mid + 1 = 4 + 1 = 5

----------------------------------------------------------------------------------------
STEP 2:
  start = 5, end = 8
  mid = 5 + (8 - 5) / 2 = 5 + 1 = 6

  Indices:    0    1    2    3    4    5    6    7    8
  Array:    [ x,   x,   x,   x,   x,  42,  56,  68,  90 ]
  Pointers:                           ▲    ▲         ▲
                                    start mid       end

  Check:     arr[mid] == target  =>  arr[6] == 56  =>  56 == 56 ? ✅ MATCH FOUND!
  Action:    Return index = 6! 🎯
========================================================================================
```

---

### ❌ Case Trace: Target Not Present (`Target = 25`)

Let's search for `Target = 25` in `arr = [3, 9, 14, 20, 35, 42, 56, 68, 90]`:

```
Step 1: start = 0, end = 8 -> mid = 4 (arr[4] = 35)
        arr[4] > 25 (35 > 25) -> Target is smaller -> end = mid - 1 = 3

Step 2: start = 0, end = 3 -> mid = 1 (arr[1] = 9)
        arr[1] < 25 (9 < 25)  -> Target is larger  -> start = mid + 1 = 2

Step 3: start = 2, end = 3 -> mid = 2 (arr[2] = 14)
        arr[2] < 25 (14 < 25) -> Target is larger  -> start = mid + 1 = 3

Step 4: start = 3, end = 3 -> mid = 3 (arr[3] = 20)
        arr[3] < 25 (20 < 25) -> Target is larger  -> start = mid + 1 = 4

Step 5: start = 4, end = 3 -> Condition (start <= end) FAILS! (4 <= 3 is FALSE)
        Loop exits! Return -1 (Target does not exist).
```

---

## ⚠️ 4. The Critical Integer Overflow Bug (The 20-Year-Old Bug)

In standard textbooks, the middle index formula was historically written as:

```java
// ❌ WRONG (Vulnerable to 32-bit signed Integer Overflow!)
int mid = (start + end) / 2;
```

### Why does this fail?
In Java, standard `int` values have a maximum limit:
$$\text{Integer.MAX\_VALUE} = 2^{31} - 1 = 2,147,483,647$$

If `start` and `end` are large (e.g., in arrays with $\approx 10^9$ elements or large numerical search spaces):
$$\text{start} = 1,500,000,000, \quad \text{end} = 2,000,000,000$$
$$\text{start} + \text{end} = 3,500,000,000 \quad \mathbf{(Over-flows\ to\ a\ negative\ number!)}$$
$$\text{mid} = \frac{-794,967,296}{2} = -397,483,648 \implies \text{Throws } \texttt{ArrayIndexOutOfBoundsException}!$$

### ✅ The Safe Formulas:

#### Approach 1: Subtraction-Based Mid (Most Popular & Recommended)
```java
int mid = start + (end - start) / 2;
```
*Why this works:* `end - start` never exceeds `end`, eliminating any risk of overflow while mathematically producing identical results:
$$start + \frac{end - start}{2} = \frac{2 \cdot start + end - start}{2} = \frac{start + end}{2}$$

#### Approach 2: Bitwise Unsigned Right Shift (Fastest)
```java
int mid = (start + end) >>> 1;
```
*Why this works:* The unsigned right-shift operator `>>>` treats the leading sign bit as standard data, cleanly handling values up to $2^{32} - 1$.

---

## 🏗️ 5. Binary Search Models & Design Patterns

Binary search is not just a single algorithm; it is a **universal paradigm**. Below are all essential models required for top technical interviews.

```
                               ┌─────────────────────────────────────────┐
                               │       BINARY SEARCH DESIGN MODELS       │
                               └────────────────────┬────────────────────┘
                                                    │
        ┌───────────────────┬───────────────────────┼───────────────────────┬───────────────────┐
        ▼                   ▼                       ▼                       ▼                   ▼
  ┌───────────┐       ┌───────────┐           ┌───────────┐           ┌───────────┐       ┌───────────┐
  │  Model 1  │       │  Model 2  │           │  Model 3  │           │  Model 4  │       │  Model 5  │
  │ Standard  │       │   Order   │           │First/Last │           │ Floor and │       │ Infinite  │
  │ BS (1D)   │       │ Agnostic  │           │Occurrence │           │  Ceiling  │       │  Arrays   │
  └───────────┘       └───────────┘           └───────────┘           └───────────┘       └───────────┘
        │                   │                       │                       │                   │
        ▼                   ▼                       ▼                       ▼                   ▼
  ┌───────────┐       ┌───────────┐           ┌───────────┐           ┌───────────┐       ┌───────────┐
  │  Model 6  │       │  Model 7  │           │  Model 8  │           │  Model 9  │       │ Model 10  │
  │ Mountain  │       │  Rotated  │           │ BS on Ans │           │ 2D Matrix │       │  Arrays.  │
  │ Peak Find │       │   Array   │           │(Sqrt/Cap) │           │  Search   │       │binSearch()│
  └───────────┘       └───────────┘           └───────────┘           └───────────┘       └───────────┘
```

---

### 🧩 Model 1: Standard Binary Search (Ascending Order)

#### A. Iterative Implementation ($O(1)$ Auxiliary Space - Preferred)
```java
public class StandardBinarySearch {

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // Safe mid calculation
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                start = mid + 1; // Discard left half
            } else {
                end = mid - 1;   // Discard right half
            }
        }

        return -1; // Target not found
    }
}
```

#### B. Recursive Implementation ($O(\log N)$ Auxiliary Stack Space)
```java
public class RecursiveBinarySearch {

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        return searchHelper(arr, target, 0, arr.length - 1);
    }

    private static int searchHelper(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1; // Base case: Search window empty
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return searchHelper(arr, target, mid + 1, end);
        } else {
            return searchHelper(arr, target, start, mid - 1);
        }
    }
}
```

---

### 🧩 Model 2: Order-Agnostic Binary Search

In many real-world problems, you are told an array is sorted, but **you don't know whether it is in Ascending or Descending order**.

#### Strategy:
Compare the first and last elements:
- If `arr[0] < arr[arr.length - 1]`, array is **Ascending**.
- If `arr[0] > arr[arr.length - 1]`, array is **Descending**.

```java
public class OrderAgnosticBinarySearch {

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int start = 0;
        int end = arr.length - 1;

        // Check whether array is ascending or descending
        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAscending) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else { // Descending array logic
                if (arr[mid] < target) {
                    end = mid - 1;   // Target is to the LEFT in descending array
                } else {
                    start = mid + 1; // Target is to the RIGHT in descending array
                }
            }
        }

        return -1;
    }
}
```

---

### 🧩 Model 3: First and Last Occurrence of Duplicate Elements

Given a sorted array with duplicates (e.g., `arr = [2, 4, 4, 4, 4, 8, 9]`), find the **First Occurrence (Lower Bound)** and **Last Occurrence (Upper Bound)** of `Target = 4`.

#### Key Insight:
When `arr[mid] == target`:
- For **First Occurrence**: Don't stop! Keep searching in the **left half** (`end = mid - 1`) to see if an earlier instance exists.
- For **Last Occurrence**: Don't stop! Keep searching in the **right half** (`start = mid + 1`) to see if a later instance exists.

```java
public class FirstAndLastOccurrence {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) return result;

        result[0] = findBound(nums, target, true);  // Find first occurrence
        result[1] = findBound(nums, target, false); // Find last occurrence

        return result;
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int start = 0;
        int end = nums.length - 1;
        int boundIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                boundIndex = mid; // Candidate found!
                if (isFirst) {
                    end = mid - 1;   // Keep checking left
                } else {
                    start = mid + 1; // Keep checking right
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return boundIndex;
    }
}
```

```
Array:   [ 2,  4,  4,  4,  4,  8,  9 ], Target = 4
First Index: 1  (Lower Bound)
Last Index : 4  (Upper Bound)
Total Count = (Last - First + 1) = 4 - 1 + 1 = 4 occurrences!
```

---

### 🧩 Model 4: Floor and Ceiling of a Number

Given a sorted array and a target value:
- **Ceiling:** The **smallest element** in the array that is **greater than or equal to** `target` ($\ge \text{target}$).
- **Floor:** The **largest element** in the array that is **less than or equal to** `target` ($\le \text{target}$).

```
Array: [ 2, 3, 5, 9, 14, 16, 18 ], Target = 15
- Ceiling of 15 is 16 (Smallest number >= 15) -> Index 5 (start pointer after loop)
- Floor of 15 is 14 (Largest number <= 15)  -> Index 4 (end pointer after loop)
```

#### 🌟 The Golden Post-Loop Pointer Insight:
When a standard binary search loop terminates (`start > end`):
- `arr[start]` is the **Ceiling** of the target!
- `arr[end]` is the **Floor** of the target!

```java
public class FloorCeilingSearch {

    /**
     * Finds the index of the Ceiling of target (Smallest element >= target).
     * Returns -1 if target is greater than all elements in the array.
     */
    public static int findCeiling(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        if (target > arr[arr.length - 1]) return -1; // No element >= target

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid; // Exact match is the ceiling
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // When loop ends, start points to the smallest element > target
        return start;
    }

    /**
     * Finds the index of the Floor of target (Largest element <= target).
     * Returns -1 if target is smaller than all elements in the array.
     */
    public static int findFloor(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;
        if (target < arr[0]) return -1; // No element <= target

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid; // Exact match is the floor
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // When loop ends, end points to the largest element < target
        return end;
    }
}
```

---

### 🧩 Model 5: Binary Search in an Infinite / Unbounded Array

**Problem:** Find the position of a target in an array of infinite length (or where calling `.length` is not permitted).

#### Strategy (Exponential / Doubling Search):
1. Start with a window size of 2 (`start = 0`, `end = 1`).
2. While `target > arr[end]`:
   - Calculate new `start = end + 1`.
   - Double the search window: `end = end + (end - start + 1) * 2`.
3. Once `target <= arr[end]`, perform standard binary search between `[start, end]`!

```java
public class InfiniteArraySearch {

    public static int searchInInfiniteArray(int[] arr, int target) {
        // Step 1: Find the bounds containing target
        int start = 0;
        int end = 1;

        while (end < arr.length && target > arr[end]) {
            int newStart = end + 1;
            // Double the previous box size
            end = end + (end - start + 1) * 2;
            if (end >= arr.length) {
                end = arr.length - 1;
            }
            start = newStart;
        }

        // Step 2: Perform standard binary search in bounded range
        return binarySearch(arr, target, start, end);
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
```

---

### 🧩 Model 6: Peak Index in a Mountain Array (Bitonic Array)

A mountain array increases strictly to a peak element and then decreases strictly (e.g., `[0, 2, 5, 10, 8, 4, 1]`).

#### Strategy:
- If `arr[mid] < arr[mid + 1]`: We are in the **ascending slope**. The peak lies to the right $\to$ `start = mid + 1`.
- If `arr[mid] > arr[mid + 1]`: We are in the **descending slope** (or at the peak). The peak lies at `mid` or to the left $\to$ `end = mid`.
- Loop condition: `while (start < end)`. When `start == end`, both point to the peak!

```java
public class PeakIndexMountainArray {

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Ascending part of the mountain
                start = mid + 1;
            } else {
                // Descending part of the mountain (mid might be the peak)
                end = mid;
            }
        }

        // start and end converge to the highest peak element
        return start;
    }
}
```

---

### 🧩 Model 7: Search in Rotated Sorted Array (LeetCode 33)

An array sorted in ascending order is rotated at some unknown pivot index (e.g., `[0,1,2,4,5,6,7]` becomes `[4,5,6,7,0,1,2]`).

```
                7
              6 |
            5   |
          4     |
        ────────┼────────
                |       2
                |     1
                |   0
         Left Sorted   Right Sorted
```

#### Key Observation:
For any `mid`, **at least one half of the array is ALWAYS normally sorted**:
1. If `arr[start] <= arr[mid]`: The **left half is sorted**.
   - If `arr[start] <= target && target < arr[mid]`: Search left half (`end = mid - 1`).
   - Else: Search right half (`start = mid + 1`).
2. Else: The **right half is sorted** (`arr[mid] <= arr[end]`).
   - If `arr[mid] < target && target <= arr[end]`: Search right half (`start = mid + 1`).
   - Else: Search left half (`end = mid - 1`).

```java
public class RotatedSortedArraySearch {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if LEFT half is sorted
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1; // Target lies in the left half
                } else {
                    start = mid + 1; // Target lies in the right half
                }
            }
            // Otherwise, RIGHT half must be sorted
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1; // Target lies in the right half
                } else {
                    end = mid - 1; // Target lies in the left half
                }
            }
        }

        return -1;
    }
}
```

---

### 🧩 Model 8: Binary Search on Answer Space (e.g., Integer Square Root - LeetCode 69)

Binary Search is not limited to searching arrays. It can search **monotonic mathematical spaces $[1, x]$**.

Given a non-negative integer $x$, compute and return the integer square root $\lfloor \sqrt{x} \rfloor$:

```java
public class SqrtBinarySearch {

    public static int mySqrt(int x) {
        if (x < 2) return x;

        int start = 1;
        int end = x / 2;
        int ans = 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Use long to prevent integer overflow during mid * mid
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;       // Candidate answer
                start = mid + 1; // Try finding larger root
            } else {
                end = mid - 1;   // Square is too big
            }
        }

        return ans;
    }
}
```

---

### 🧩 Model 9: Binary Search in 2D Matrices

#### Pattern A: Strictly Sorted 2D Matrix (LeetCode 74)
Every row is sorted, and the first integer of each row is greater than the last integer of the previous row.

**Key Insight:** Treat the $R \times C$ matrix as a single 1D virtual array of length $N = R \times C$.
- Virtual Index `mid` $\implies$ `Row = mid / C`, `Col = mid % C`
- Complexity: $\mathbf{O(\log(R \times C))}$

```java
public class StrictlySortedMatrixSearch {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
```

#### Pattern B: Row-Wise and Column-Wise Sorted Matrix (LeetCode 240 / Staircase Search)
Matrix is sorted from left-to-right across rows and top-to-bottom across columns.

**Strategy:** Start at the Top-Right Corner `(row = 0, col = cols - 1)`:
- If `matrix[row][col] == target` $\to$ Match found!
- If `matrix[row][col] > target` $\to$ Column contains values too big $\to$ Move Left (`col--`).
- If `matrix[row][col] < target` $\to$ Row contains values too small $\to$ Move Down (`row++`).
- Complexity: $\mathbf{O(R + C)}$

```java
public class RowColMatrixSearch {

    public static int[] search(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return new int[]{-1, -1};

        int row = 0;
        int col = matrix[0].length - 1; // Start at Top-Right

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            } else if (matrix[row][col] > target) {
                col--; // Eliminate current column
            } else {
                row++; // Eliminate current row
            }
        }

        return new int[]{-1, -1};
    }
}
```

---

### 🧩 Model 10: Built-in `Arrays.binarySearch()` in Java

Java provides built-in binary search methods in `java.util.Arrays`.

```java
import java.util.Arrays;

int[] arr = {10, 20, 30, 40, 50};
int idx = Arrays.binarySearch(arr, 30); // returns 2
```

#### 💡 How to Decode Negative Return Values:
If the target is **NOT present**, Java returns:
$$\mathbf{\text{return value} = -(\text{insertion point}) - 1}$$

Where `insertion point` is the index where the key would be inserted to maintain sorted order!

```java
int[] arr = {10, 20, 40, 50};
int idx = Arrays.binarySearch(arr, 30); // returns -3

// Decoding:
// -3 = -(insertion_point) - 1  =>  insertion_point = 2 (index between 20 and 40)
int insertIdx = -(idx + 1); // Equals 2!
```

---

## ⏱️ 6. Comprehensive Complexity Analysis

| Scenario / Metric | Time Complexity | Auxiliary Space Complexity | Explanation |
| :--- | :--- | :--- | :--- |
| 🟢 **Best Case** | $\mathbf{O(1)}$ | $O(1)$ | Target element is located precisely at the initial `mid` index. |
| 🔴 **Worst Case** | $\mathbf{O(\log N)}$ | $O(1)$ (Iterative) | Target is at the final single element or not present; search space halved at each step. |
| 🟡 **Average Case** | $\mathbf{O(\log N)}$ | $O(1)$ (Iterative) | Expected comparisons across all uniform positions is $\approx \log_2 N - 1$. |
| 🔄 **Recursive Approach** | $O(\log N)$ | $\mathbf{O(\log N)}$ | Uses JVM Call Stack frames for each recursion depth. |
| 🗺️ **2D Matrix (Strict 1D)** | $O(\log(R \times C))$ | $O(1)$ | Virtual index mapping over total flattened elements. |
| 🪜 **2D Matrix (Row-Col)** | $O(R + C)$ | $O(1)$ | Staircase traversal eliminating one row or column per step. |

---

## ⚠️ 7. Common Pitfalls & Traps to Avoid

### ❌ Pitfall 1: Loop Condition `start < end` vs `start <= end`
- When searching for a target that could be at the final remaining element, `while (start <= end)` is required.
- If you use `start < end`, a single-element array `[5]` searching for `5` will terminate without checking index 0!

### ❌ Pitfall 2: Integer Overflow on `mid`
```java
// ❌ WRONG
int mid = (start + end) / 2;

// ✅ CORRECT
int mid = start + (end - start) / 2;
```

### ❌ Pitfall 3: Forgetting `mid + 1` or `mid - 1` (Infinite Loop Hazard!)
```java
// ❌ WRONG (Can cause infinite loop when start and end are adjacent!)
if (arr[mid] < target) {
    start = mid; // 💥 Infinite Loop when start + 1 == end
}

// ✅ CORRECT
if (arr[mid] < target) {
    start = mid + 1;
}
```

### ❌ Pitfall 4: Applying Binary Search on Unsorted Data
Binary search **guarantees correctness ONLY when the underlying monotonic property holds** (usually sorted order). If data is unsorted, Linear Search or sorting first is required.

---

## 🧪 8. Test Matrix & Scenarios

| Test Case Category | Input Array | Target | Expected Output | Concept Verified |
| :--- | :--- | :--- | :--- | :--- |
| **Middle Element Match** | `[10, 20, 30, 40, 50]` | `30` | `Index 2` | $O(1)$ Best Case Immediate Hit |
| **First Element Match** | `[10, 20, 30, 40, 50]` | `10` | `Index 0` | Boundary: Start Index |
| **Last Element Match** | `[10, 20, 30, 40, 50]` | `50` | `Index 4` | Boundary: End Index |
| **Element Not Found (Too Small)** | `[10, 20, 30, 40, 50]` | `5` | `-1` | Left boundary overflow |
| **Element Not Found (Too Large)** | `[10, 20, 30, 40, 50]` | `99` | `-1` | Right boundary overflow |
| **Element Not Found (In Between)** | `[10, 20, 30, 40, 50]` | `25` | `-1` | Missing intermediate value |
| **Single Element (Present)** | `[42]` | `42` | `Index 0` | Single-element array hit |
| **Single Element (Absent)** | `[42]` | `10` | `-1` | Single-element array miss |
| **Empty Array** | `[]` | `7` | `-1` | Guard clause for empty/null |
| **Negative Numbers** | `[-50, -20, -10, 0, 15]`| `-20` | `Index 1` | Signed number ordering |
| **Duplicate Elements** | `[1, 3, 3, 3, 5]` | `3` | First: `1`, Last: `3` | Lower & Upper bound range |
| **Descending Order** | `[90, 70, 50, 30, 10]` | `70` | `Index 1` | Order-Agnostic branch |
| **Rotated Array** | `[4, 5, 6, 7, 0, 1, 2]` | `0` | `Index 4` | Shifted inflection point |

---

## 🧠 9. Summary & Quick Reference Card

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                         BINARY SEARCH QUICK SUMMARY                         │
├─────────────────────────────────────────────────────────────────────────────┤
│ • Prerequisite     : Array MUST be sorted (or possess a monotonic property).│
│ • Core Mechanism   : Compare mid; halve the search space at each iteration. │
│ • Mid Formula      : mid = start + (end - start) / 2 (Prevents overflow).   │
│ • Loop Condition   : while (start <= end) for exact match lookup.           │
│ • Best Case Time   : O(1) (Direct hit at first mid).                        │
│ • Worst Case Time  : O(log N) (Maximum log2(N) comparisons).                │
│ • Space Complexity : O(1) Iterative, O(log N) Recursive (Call stack).       │
│ • Post-Loop State  : When target missing, start = Ceiling, end = Floor.     │
│ • Key Models       : Order-Agnostic, First/Last Bound, Floor/Ceiling,       │
│                      Rotated Array, Infinite Array, Answer Space, 2D Matrix. │
└─────────────────────────────────────────────────────────────────────────────┘
```
