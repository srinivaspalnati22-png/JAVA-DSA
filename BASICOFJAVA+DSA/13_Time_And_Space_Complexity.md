# ⏱️ 13. Time and Space Complexity in Java

---

## 📌 1. The Core Intuition: Why Do We Analyze Algorithms?

When writing code to solve a problem, having a program that merely produces the correct output is not enough. In production systems, competitive programming, and technical interviews, **efficiency** is paramount.

$$\mathbf{\text{Efficiency}} = \underbrace{\text{How FAST it runs}}_{\mathbf{\text{Time Complexity}}} \;+\; \underbrace{\text{How much MEMORY it consumes}}_{\mathbf{\text{Space Complexity}}}$$

```
   ┌────────────────────────────────────────────────────────────────────────────┐
   │                   THE THREE PILLARS OF ALGORITHM DESIGN                   │
   ├────────────────────────┬───────────────────────────┬───────────────────────┤
   │     1. Correctness     │     2. Time Efficiency    │  3. Space Efficiency  │
   │ Does it give right     │ Does it run within time   │ Does it fit within    │
   │ answers for all inputs?│ limits without lagging?   │ RAM memory limits?    │
   └────────────────────────┴───────────────────────────┴───────────────────────┘
```

---

### 🛑 The "Wall-Clock" / Stopwatch Fallacy

Why can't we simply measure the execution time of a program using a stopwatch or `System.currentTimeMillis()`?

```java
long start = System.currentTimeMillis();
solveProblem(input);
long end = System.currentTimeMillis();
System.out.println("Execution time: " + (end - start) + " ms");
```

Measuring wall-clock time fails because physical run-time is heavily influenced by external variables:
1. **Hardware Discrepancies**: A modern Intel i9 / Apple M3 processor will execute code significantly faster than an older laptop or a cloud micro-instance.
2. **Background System Activity**: OS multitasking, background browser tabs, or antivirus scans introduce inconsistent noise into measurements.
3. **Compiler & JIT Optimizations**: The Java Virtual Machine (JVM) optimizes frequently executed bytecode (hotspots) at runtime, altering clock timings across runs.
4. **Input Scale Variability**: A slow algorithm might take $0.1\text{ ms}$ on 10 items, but take $10\text{ hours}$ on $1,000,000$ items.

> 💡 **The Big-O Solution:** Instead of measuring *seconds*, we analyze the **rate of growth of elementary operations** as a mathematical function of input size $N$ ($N \to \infty$).

---

### 🚗 Real-World Analogy: Data Transfer

Imagine transferring a file of size $N$ Gigabytes across the country:

```
Method A (Internet Download) : Takes 1 second per Megabyte  --> T(N) = c * N  (Linear Growth)
Method B (Physical Hard Drive): Fly a 10TB SSD via airplane  --> T(N) = 5 hours (Constant Time)
```

- If the file is **10 MB**, Method A takes a split second. Method B takes 5 hours.
- If the file is **10 Terabytes**, Method A takes weeks! Method B still takes 5 hours.

As $N$ becomes massive, the algorithmic growth rate dominates over any initial constant advantages!

---

## 📐 2. Asymptotic Notations: The Three Mathematical Bounds

To formally describe how an algorithm scales, computer scientists use **Asymptotic Notations**:

```
                       ┌─────────────────────────────────────────┐
                       │          ASYMPTOTIC NOTATIONS           │
                       └────────────────────┬────────────────────┘
                                            │
               ┌────────────────────────────┼────────────────────────────┐
               ▼                            ▼                            ▼
     ┌──────────────────┐         ┌──────────────────┐         ┌──────────────────┐
     │  1. Big-O ( O )  │         │ 2. Big-Omega (Ω) │         │ 3. Big-Theta (Θ) │
     │   Upper Bound    │         │   Lower Bound    │         │   Tight Bound    │
     │   (Worst Case)   │         │   (Best Case)    │         │  (Average Case)  │
     └──────────────────┘         └──────────────────┘         └──────────────────┘
```

| Notation | Mathematical Concept | Plain English Meaning | Interview Relevance |
| :--- | :--- | :--- | :--- |
| **Big-O ($\mathcal{O}$)** | **Upper Bound** | *"The algorithm will take AT MOST $f(N)$ steps in the worst possible scenario."* | **⭐⭐⭐ 99% of DSA focus** |
| **Big-Omega ($\Omega$)** | **Lower Bound** | *"The algorithm will take AT LEAST $f(N)$ steps in the luckiest scenario."* | Used for theoretical limits |
| **Big-Theta ($\Theta$)** | **Tight Bound** | *"The algorithm's growth is sandwiched strictly between $c_1 f(N)$ and $c_2 f(N)$."* | Precise mathematical characterization |

```
Operations ^
           │                          /  c2 * g(N) [Upper Bound: Big-O]
           │                         /
           │                        /  f(N) [Exact Execution]
           │                       /
           │                      /  c1 * g(N) [Lower Bound: Big-Omega]
           │                     /
           │                    /
           │         .─────────'
           └─────────┴────────────────────────>
                    N0 (Threshold)           Input Size N
```

---

## ⚖️ 3. The Three Golden Rules of Calculating Big-O

Calculating Big-O from mathematical step counts boils down to three straightforward rules:

```
┌──────────────────────────────────────────────────────────────────────────────┐
│                       THE 3 GOLDEN RULES OF BIG-O                            │
├──────────────────────────────────────────────────────────────────────────────┤
│ 1. DROP CONSTANTS:           O(5N)       ──>  O(N)                           │
│                              O(1000)     ──>  O(1)                           │
│                                                                              │
│ 2. DROP NON-DOMINANT TERMS:  O(N² + 5N + 500)  ──>  O(N²)                    │
│                              O(N³ + N² + N)    ──>  O(N³)                    │
│                                                                              │
│ 3. ADD SEQUENTIAL,           Loop A followed by Loop B  ──>  O(A + B)        │
│    MULTIPLY NESTED:          Loop A containing Loop B   ──>  O(A * B)        │
└──────────────────────────────────────────────────────────────────────────────┘
```

### 1️⃣ Rule 1: Drop All Multiplicative & Additive Constants
As $N$ grows to billions, constant multipliers have negligible impact on the overall growth category:
- $T(N) = 3N + 7 \implies \mathcal{O}(N)$
- $T(N) = \frac{1}{2} N^2 + 100 \implies \mathcal{O}(N^2)$

### 2️⃣ Rule 2: Keep Only the Highest-Order Dominant Term
When an expression has multiple terms, the term with the fastest growth rate overshadows everything else:
- For $N = 10^6$:
  - $N^2 = 1,000,000,000,000$ ($10^{12}$)
  - $100N = 100,000,000$ ($10^8$) — barely $0.01\%$ of $N^2$!
  - $5000 = 5000$ — negligible rounding error.
- Therefore: $\mathcal{O}(N^2 + 100N + 5000) = \mathcal{O}(N^2)$.

### 3️⃣ Rule 3: Add vs. Multiply
- **Sequential Steps (Add):** If Task A is followed by Task B, add their complexities:
  $$\mathcal{O}(A) + \mathcal{O}(B) = \mathcal{O}(A + B)$$
- **Nested Loops (Multiply):** If Task B executes inside each iteration of Task A, multiply:
  $$\mathcal{O}(A) \times \mathcal{O}(B) = \mathcal{O}(A \times B)$$

---

## 📈 4. The Complete Time Complexity Hierarchy

The spectrum of algorithm complexities arranged from **fastest (best)** to **slowest (worst)**:

$$\mathcal{O}(1) < \mathcal{O}(\log N) < \mathcal{O}(\sqrt{N}) < \mathcal{O}(N) < \mathcal{O}(N \log N) < \mathcal{O}(N^2) < \mathcal{O}(N^3) < \mathcal{O}(2^N) < \mathcal{O}(N!)$$

```
  Operations
     ^
     │                                                     | O(N!)
     │                                              |      | Factorial
     │                                        |     | O(2^N)
     │                                        |     | Exponential
     │                                 |      | O(N^2)
     │                                 |      | Quadratic
     │                          |      | O(N log N) Linearithmic
     │                   |      |      |
     │            |      |      |      | O(N) Linear
     │     |      |      |      |      |
     │  ___|______|______|______|______|___ O(log N) Logarithmic
     │  ═══════════════════════════════════ O(1) Constant
     └────────────────────────────────────────────────────────> Input Size N
```

---

### 📊 Comparative Growth Rate Table

See how the number of operations explodes for different algorithms as input size grows:

| Complexity | Name | $N = 10$ | $N = 100$ | $N = 1,000$ | $N = 1,000,000$ ($10^6$) | Rating |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **$\mathcal{O}(1)$** | Constant | $1$ | $1$ | $1$ | $1$ | 🟢 **Excellent** |
| **$\mathcal{O}(\log N)$** | Logarithmic | $\approx 3$ | $\approx 7$ | $\approx 10$ | $\approx 20$ | 🟢 **Excellent** |
| **$\mathcal{O}(\sqrt{N})$** | Square Root | $\approx 3$ | $10$ | $\approx 31$ | $1,000$ | 🟢 **Great** |
| **$\mathcal{O}(N)$** | Linear | $10$ | $100$ | $1,000$ | $1,000,000$ | 🟡 **Good** |
| **$\mathcal{O}(N \log N)$** | Linearithmic | $\approx 33$ | $\approx 664$ | $\approx 9,965$ | $\approx 2 \times 10^7$ | 🟡 **Acceptable** |
| **$\mathcal{O}(N^2)$** | Quadratic | $100$ | $10,000$ | $1,000,000$ | $10^{12}$ *(TLE!)* | 🔴 **Slow** |
| **$\mathcal{O}(N^3)$** | Cubic | $1,000$ | $1,000,000$ | $10^9$ | $10^{18}$ *(Meltdown)* | 🔴 **Very Slow** |
| **$\mathcal{O}(2^N)$** | Exponential | $1,024$ | $1.26 \times 10^{30}$ | *Unfathomable* | *Universe ends* | ⛔ **Unusable for large N** |
| **$\mathcal{O}(N!)$** | Factorial | $3,628,800$ | $9.33 \times 10^{157}$ | *Impossible* | *Impossible* | ⛔ **Unusable for large N** |

---

## 🔍 5. Deep-Dive: Code Patterns for Each Complexity Class

### 1️⃣ $\mathcal{O}(1)$ — Constant Time
The execution time is completely invariant to the size of the input. No loops dependent on $N$.

```java
// Example 1: Direct array indexing
int getFirst(int[] arr) {
    return arr[0]; // Exactly 1 operation regardless of arr.length
}

// Example 2: Mathematical formula
int sumOfFirstN(int n) {
    return n * (n + 1) / 2; // Arithmetic formula executes in O(1)
}

// Example 3: Basic conditional
boolean isEven(int n) {
    return (n % 2 == 0); // Single modulo check
}
```

---

### 2️⃣ $\mathcal{O}(\log N)$ — Logarithmic Time
In every step of the algorithm, the search space / problem size is **halved** (or divided by a constant factor $k$).

$$\text{Problem Size Progression: } N \longrightarrow \frac{N}{2} \longrightarrow \frac{N}{4} \longrightarrow \frac{N}{8} \longrightarrow \dots \longrightarrow 1 \implies k = \log_2 N \text{ steps}$$

```java
// Example 1: Binary Search on sorted array
int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) low = mid + 1;  // Discard left half
        else high = mid - 1;                        // Discard right half
    }
    return -1;
}

// Example 2: Loop counter multiplied/divided
for (int i = 1; i < n; i *= 2) {
    System.out.println(i); // Runs log2(n) times
}

// Example 3: Extracting digits of a number
while (n > 0) {
    int digit = n % 10;
    n /= 10; // Runs log10(n) times
}
```

---

### 3️⃣ $\mathcal{O}(\sqrt{N})$ — Square Root Time
Common in number theory algorithms where factor checks beyond $\sqrt{N}$ are redundant mirror pairs.

```java
// Prime number test: Check factors only up to sqrt(n)
boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i * i <= n; i++) { // Equivalent to i <= Math.sqrt(n)
        if (n % i == 0) return false;
    }
    return true;
}
```

---

### 4️⃣ $\mathcal{O}(N)$ — Linear Time
The runtime grows in direct, 1-to-1 proportion to the input size $N$. Every item is processed a constant number of times.

```java
// Example 1: Single loop traversal
int findMax(int[] arr) {
    int max = arr[0];
    for (int num : arr) { // Visits every element once: N operations
        if (num > max) max = num;
    }
    return max;
}

// Example 2: Count frequencies with single loop
int countOccurrences(int[] arr, int target) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) count++;
    }
    return count;
}
```

---

### 5️⃣ $\mathcal{O}(N \log N)$ — Linearithmic Time
Arises when an algorithm performs an $\mathcal{O}(\log N)$ operation for each of the $N$ elements, or in optimal Divide-and-Conquer sorting algorithms.

```
       [Divide: log N levels of tree]
                 ┌──────┴──────┐
              ┌──┴──┐       ┌──┴──┐
             ┌┴┐   ┌┴┐     ┌┴┐   ┌┴┐
             
       [Conquer: At every level, we merge N elements total]
       Total Work = (Height of Tree) * (Work per Level) = (log N) * N = O(N log N)
```

```java
// Example: Java's built-in Dual-Pivot Quicksort / TimSort
import java.util.Arrays;

void sortArray(int[] arr) {
    Arrays.sort(arr); // O(N log N) time complexity
}
```

---

### 6️⃣ $\mathcal{O}(N^2)$ — Quadratic Time
Typically occurs when code uses nested loops where both the outer and inner loops iterate up to $N$.

```java
// Example 1: All pairs comparison
void printAllPairs(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {       // Runs N times
        for (int j = 0; j < n; j++) {   // Runs N times for EACH i
            System.out.println(arr[i] + ", " + arr[j]);
        }
    }
} // Total: N * N = O(N^2)

// Example 2: Dependent nested loops (Triangle loops)
void printTriangularPairs(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            System.out.println(arr[i] + ", " + arr[j]);
        }
    }
}
```

> ❓ **Why is the triangle loop still $\mathcal{O}(N^2)$?**
> Inner loop runs: $(N-1) + (N-2) + \dots + 2 + 1 + 0 = \frac{N(N-1)}{2} = \frac{N^2}{2} - \frac{N}{2}$
> Applying Big-O rules (drop constants and lower terms) $\implies \mathbf{\mathcal{O}(N^2)}$.

---

### 7️⃣ $\mathcal{O}(2^N)$ — Exponential Time
The operations double with each addition to the input dataset. Typical of naive recursive algorithms without memoization.

```java
// Naive Recursive Fibonacci: Branches 2 ways at every level
int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2); // 2 recursive calls per step
}
```

```
                        fib(4)
                    ┌─────┴─────┐
                 fib(3)       fib(2)
                ┌───┴───┐     ┌──┴──┐
             fib(2)  fib(1) fib(1) fib(0)
             ┌──┴──┐
          fib(1) fib(0)
          
Total Nodes in Tree ≈ 2^0 + 2^1 + 2^2 + ... + 2^N ≈ 2^(N+1) - 1 = O(2^N)
```

---

### 8️⃣ $\mathcal{O}(N!)$ — Factorial Time
The slowest common complexity class. Generates every permutation of a collection.

- For $N = 5 \implies 5! = 120$ operations.
- For $N = 10 \implies 10! = 3,628,800$ operations.
- For $N = 20 \implies 20! \approx 2.43 \times 10^{18}$ operations (Takes hundreds of years).

```java
// Generating all permutations of an array of size N
void generatePermutations(int[] arr, int index) {
    if (index == arr.length) {
        print(arr);
        return;
    }
    for (int i = index; i < arr.length; i++) {
        swap(arr, index, i);
        generatePermutations(arr, index + 1); // Recurses (N-1)!, (N-2)! ...
        swap(arr, index, i);
    }
}
```

---

## 💾 6. Space Complexity: Decoding Memory Consumption

Space complexity measures the **total memory** an algorithm needs with respect to the input size $N$.

$$\mathbf{\text{Total Space Complexity}} = \mathbf{\text{Input Space}} \;+\; \mathbf{\text{Auxiliary Space}}$$

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                          MEMORY BREAKDOWN IN DSA                            │
├──────────────────────────────────────┬──────────────────────────────────────┤
│ 📥 INPUT SPACE                       │ 🛠️ AUXILIARY SPACE (Extra Space)      │
│ Memory used to store the input data  │ Extra or temporary storage allocated │
│ passed into the function (e.g. input │ by the algorithm itself to solve the │
│ array of size N = O(N)).             │ problem (e.g., hash tables, buffers).│
├──────────────────────────────────────┴──────────────────────────────────────┤
│ 🎯 Interview Note: When interviewers ask for Space Complexity, they almost  │
│    always mean AUXILIARY SPACE!                                             │
└─────────────────────────────────────────────────────────────────────────────┘
```

---

### 🧠 Stack Space vs. Heap Space

```
┌─────────────────────────────────────────────────────────────────────────────┐
│ 1. HEAP MEMORY (Data Structures)                                            │
│    Explicitly allocated data structures:                                    │
│    • `int[] temp = new int[n];`             ──>  O(N) Auxiliary Space       │
│    • `HashMap<Integer, Integer> map;`       ──>  O(N) Auxiliary Space       │
│    • `int[][] matrix = new int[n][n];`      ──>  O(N²) Auxiliary Space      │
├─────────────────────────────────────────────────────────────────────────────┤
│ 2. STACK MEMORY (Call Stack / Recursion Frames)                             │
│    Every recursive call creates a new stack frame storing local variables:  │
│    • Recursion depth = N  (e.g., countdown(n)) ──> O(N) Stack Space        │
│    • Recursion depth = log N (e.g., binary search) ──> O(log N) Stack Space │
└─────────────────────────────────────────────────────────────────────────────┘
```

### ⚖️ Comparing In-Place vs. Extra Space Implementations

#### Case A: In-Place Array Reversal ($\mathcal{O}(1)$ Auxiliary Space)
```java
void reverseInPlace(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        int temp = arr[left]; // Single primitive variable = O(1)
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}
// Time: O(N), Auxiliary Space: O(1)
```

#### Case B: Auxiliary Array Buffer ($\mathcal{O}(N)$ Auxiliary Space)
```java
int[] reverseWithBuffer(int[] arr) {
    int n = arr.length;
    int[] result = new int[n]; // Creates new array of size N = O(N) space
    for (int i = 0; i < n; i++) {
        result[i] = arr[n - 1 - i];
    }
    return result;
}
// Time: O(N), Auxiliary Space: O(N)
```

---

## ⚠️ 7. Five Critical Java-Specific Traps

### 💣 Trap 1: The String Concatenation Trap
In Java, `String` objects are **immutable**. Concatenating strings inside a loop creates a new copy every single time!

```java
// ❌ WRONG: O(N^2) Time & O(N^2) Total Space Churn!
String s = "";
for (int i = 0; i < n; i++) {
    s += "a"; // Creates a brand new String copy of length 1, 2, 3... N
}

// ✅ CORRECT: O(N) Time & O(N) Space using StringBuilder
StringBuilder sb = new StringBuilder();
for (int i = 0; i < n; i++) {
    sb.append("a"); // Amortized O(1) per append
}
String s = sb.toString();
```

---

### 💣 Trap 2: Collection `.contains()` inside a Loop
```java
List<Integer> list = new ArrayList<>();
// ... populate list with N elements ...

// ❌ ArrayList.contains() is O(N)!
// Outer loop O(M) * contains O(N) = O(M * N)
for (int x : queryArray) {
    if (list.contains(x)) { ... }
}

// ✅ HashSet.contains() is O(1) average!
// Total Time: O(M * 1) = O(M)
Set<Integer> set = new HashSet<>(list);
for (int x : queryArray) {
    if (set.contains(x)) { ... }
}
```

---

### 💣 Trap 3: Two Pointers Look Like $O(N^2)$, but are $O(N)$
```java
int left = 0, right = arr.length - 1;
while (left < right) {
    if (arr[left] + arr[right] == target) return true;
    else if (arr[left] + arr[right] < target) left++;
    else right--;
}
```
> 💡 **Why is this $\mathcal{O}(N)$?** In every single iteration, either `left` moves right by 1, or `right` moves left by 1. The total steps cannot exceed $N$.

---

### 💣 Trap 4: Multiple Independent Inputs ($N$ and $M$)
If a method takes two distinct arrays of lengths $N$ and $M$:
- Two sequential loops: $\mathcal{O}(N + M)$ — *(NOT $\mathcal{O}(N)$!)*
- Two nested loops: $\mathcal{O}(N \times M)$ — *(NOT $\mathcal{O}(N^2)$!)*

---

### 💣 Trap 5: Recursion Stack Memory
Even if a recursive method creates zero objects or arrays on the Heap, each recursive call consumes a **Stack Frame**:
```java
void recursiveCount(int n) {
    if (n <= 0) return;
    recursiveCount(n - 1); // Depth is N -> O(N) Stack Memory!
}
```
> ⚠️ If $N = 10^5$, this will throw `java.lang.StackOverflowError`.

---

## 🎯 8. The "1-Second Rule" & Interview Constraint Cheat Sheet

Online Judges (LeetCode, Codeforces, HackerRank) and enterprise servers typically execute approximately:

$$\mathbf{\approx 10^8 \text{ Operations per Second}}$$

When given a problem with an input constraint $N$, use this table to know **immediately** which time complexity you must target to avoid **Time Limit Exceeded (TLE)**:

```
┌──────────────────────────────────────────────────────────────────────────────┐
│                    INPUT CONSTRAINT TO BIG-O TARGET MATRIX                   │
├────────────────────┬─────────────────────────────┬───────────────────────────┤
│ Input Size (N)     │ Maximum Allowed Complexity  │ Likely Techniques         │
├────────────────────┼─────────────────────────────┼───────────────────────────┤
│ N ≤ 10             │ O(N!) or O(2^N * N)         │ Backtracking, Permutations│
│ N ≤ 20             │ O(2^N)                      │ Bitmask DP, Subsets       │
│ N ≤ 500            │ O(N³)                       │ Floyd-Warshall, Matrix    │
│ N ≤ 5,000          │ O(N²)                       │ Two Pointers, DP, Nested  │
│ N ≤ 100,000 (10⁵)  │ O(N log N) or O(N)          │ Sorting, Trees, HashMaps  │
│ N ≤ 1,000,000 (10⁶)│ O(N) or O(N log N)          │ Prefix Sums, Sliding Win  │
│ N ≤ 10⁹ or 10¹⁸    │ O(log N) or O(1)            │ Binary Search, Math / Mod │
└────────────────────┴─────────────────────────────┴───────────────────────────┘
```

---

## 📋 9. Quick Summary & Interview Cheat Sheet

```
┌─────────────────┬──────────────┬────────────────────────┬─────────────────────┐
│ COMPLEXITY      │ NOTATION     │ TYPICAL EXAMPLES       │ SCALING PERFORMANCE │
├─────────────────┼──────────────┼────────────────────────┼─────────────────────┤
│ Constant        │ O(1)         │ Array index, Math formula│ Instant (Best)    │
│ Logarithmic     │ O(log N)     │ Binary Search, digit /2│ Incredible scaling  │
│ Square Root     │ O(√N)        │ Prime testing up to √N │ Fast                │
│ Linear          │ O(N)         │ Single loop traversal  │ Direct proportional │
│ Linearithmic    │ O(N log N)   │ MergeSort, Arrays.sort │ Standard for sorting│
│ Quadratic       │ O(N²)        │ Nested loops, pairs    │ Slow for N > 10,000 │
│ Cubic           │ O(N³)        │ 3 nested loops, matrix │ Melts for N > 500   │
│ Exponential     │ O(2^N)       │ Naive recursive subset │ Limit N ≤ 25        │
│ Factorial       │ O(N!)        │ Permutations           │ Limit N ≤ 11        │
└─────────────────┴──────────────┴────────────────────────┴─────────────────────┘
```

---

## 💻 10. Hands-on Java Demonstration

To see and benchmark these complexities directly in action, examine and run [ComplexityDemo.java](./ComplexityDemo.java).
