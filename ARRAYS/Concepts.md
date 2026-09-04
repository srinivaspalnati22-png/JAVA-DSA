# 📦 Complete Guide to Arrays in Java

---

## 📌 1. What is an Array?
An **Array** in Java is a **fixed-size**, **indexed** collection of **homogeneous** (same datatype) elements stored in **contiguous (continuous) memory locations**.

```
Memory Layout (Contiguous):
Index:      [ 0 ]   [ 1 ]   [ 2 ]   [ 3 ]   [ 4 ]
Value:     |  10  |  20  |  30  |  40  |  50  |
Address:    1000    1004    1008    1012    1016   (each int = 4 bytes)
```

### 🔑 Key Characteristics:
1. **Homogeneous**: Can only store values of the same datatype (e.g., all `int`, all `String`).
2. **Fixed Size**: Size cannot be changed after creation.
3. **Contiguous Memory**: Elements are placed side-by-side in memory.
4. **Indexed**: Every element has an index from `0` to `length - 1`.

### 🌍 Real-Life Examples:
- Student Marks in a class
- Monthly Employee Salaries
- Daily Temperatures of a week
- IPL Cricket Scores over by over

---

## 🏗️ 2. Declaration, Allocation & Initialization

Creating an array involves 3 stages:

```java
// 1. Declaration (Creates reference variable on Stack)
int[] arr; 

// 2. Allocation (Allocates memory on Heap using 'new')
arr = new int[5]; 

// 3. Initialization (Assigns actual values)
arr[0] = 10;
arr[1] = 20;
arr[2] = 30;
arr[3] = 40;
arr[4] = 50;

// ⚡ One-Line Shortcut (Declaration + Allocation + Initialization together):
int[] numbers = {10, 20, 30, 40, 50};
```

---

## 🔍 3. Syntax Breakdown — Why Each Keyword?

| Syntax Component | Why is it used? |
| :--- | :--- |
| `[]` | Indicates the variable is an **array** reference (holds multiple values). |
| `new` | Dynamically allocates memory on the **Heap** and creates the array object. |
| `Size [5]` | Java arrays have **fixed size**, so memory size must be specified up-front. |
| `{...}` | Array initializer syntax used to directly assign literal values. |

---

## ⚙️ 4. Default Values in Java Arrays

When an array is allocated with `new`, Java automatically fills it with default values:

| Data Type | Default Value | Example Array |
| :--- | :--- | :--- |
| `byte`, `short`, `int`, `long` | `0` | `[0, 0, 0, 0, 0]` |
| `float` | `0.0f` | `[0.0, 0.0, ...]` |
| `double` | `0.0` | `[0.0, 0.0, ...]` |
| `boolean` | `false` | `[false, false, ...]` |
| `char` | `'\u0000'` (null char) | `['\0', '\0', ...]` |
| `String` / `Object` | `null` | `[null, null, ...]` *(⚠️ Not empty string `""`!)* |

---

## 🎯 5. Indexing & Memory Calculation

### Why does indexing start from `0`?
In contiguous memory, the location of any element is calculated using:
$$\text{Address of Element} = \text{Base Address} + (\text{Index} \times \text{Size of Datatype})$$

- When $\text{Index} = 0$:
  $$\text{Address} = \text{Base Address} + (0 \times 4) = \text{Base Address}$$
  *(No extra multiplication/addition required $\rightarrow$ $O(1)$ instant access!)*

- **First Element:** `arr[0]`
- **Last Element:** `arr[arr.length - 1]`

---

## 🔁 6. Array Traversal Techniques

### 1. Traditional `for` Loop (Index-Based)
- **Pros:** Full access to index `i`, can modify elements, can traverse backwards or in steps.
```java
for (int i = 0; i < arr.length; i++) {
    System.out.println("Index " + i + " : " + arr[i]);
}
```

### 2. Enhanced `for-each` Loop (Value-Based)
- **Pros:** Clean, readable, prevents off-by-one errors.
- **Cons:** Read-only traversal, no index available.
```java
for (int num : arr) {
    System.out.println(num);
}
```

---

## ☕ 7. Arrays are Objects in Java

In Java, arrays are **NOT** primitive types—they are **Objects** stored in Heap memory.

1. **`arr.length` is a property/field (not a method!):**
   - `arr.length` ✅ *(Array property)*
   - `str.length()` ❌ *(String method)*
2. **Runtime Class:**
   - `arr.getClass().getName()` returns `[I` for `int[]`, `[Ljava.lang.String;` for `String[]`.
3. **Inherits from `Object`:**
   - `Object obj = arr;` is completely valid in Java.

---

## 🛠️ 8. Common Array Operations in DSA

| Operation | Description | Time Complexity |
| :--- | :--- | :--- |
| **Traversal** | Visit and process each element once | $O(n)$ |
| **Searching** | Linear Search ($O(n)$) / Binary Search on sorted array ($O(\log n)$) | $O(n)$ or $O(\log n)$ |
| **Insertion & Update** | Update `arr[i] = val` | $O(1)$ |
| **Min / Max / Sum** | Compute statistics in a single pass | $O(n)$ |
| **Reversing** | Two-pointer swap from start and end | $O(n)$ |
| **Rotation** | Shift elements left/right by $k$ positions | $O(n)$ |

---

## 📝 9. Interview Cheat Sheet Summary ✅

- [x] **Homogeneous Only:** Store only one data type per array.
- [x] **Fixed Size:** Array length is decided at creation and cannot grow dynamically.
- [x] **0-Based Indexing:** Valid indices are `0` to `arr.length - 1`. Out of range throws `ArrayIndexOutOfBoundsException`.
- [x] **Length Property:** Use `arr.length` without parentheses.
- [x] **Default Values:** Primitive numbers become `0`, boolean becomes `false`, object/string arrays become `null`.
- [x] **Memory Location:** Arrays are objects stored on the **Heap**, references live on the **Stack**.

---

## 📚 Solved Problems Index (GeeksforGeeks)

| # | Problem File | GFG Problem Link | Core Concept & Technique |
|---|---|---|---|
| **01** | [Problem01_LargestElement.java](file:///c:/Users/srini/OneDrive/Desktop/JAVA+DSA/ARRAYS/Problem01_LargestElement.java) | [Largest Element in Array](https://www.geeksforgeeks.org/problems/largest-element-in-array4009/1) | Array Traversal & Finding Maximum |
| **02** | [Problem02_SumOfArrayElements.java](file:///c:/Users/srini/OneDrive/Desktop/JAVA+DSA/ARRAYS/Problem02_SumOfArrayElements.java) | [Sum of Array Elements](https://www.geeksforgeeks.org/problems/sum-all-array-elements/1) | Accumulator Pattern ($O(n)$) |
| **03** | [Problem03_MeanOfArray.java](file:///c:/Users/srini/OneDrive/Desktop/JAVA+DSA/ARRAYS/Problem03_MeanOfArray.java) | [Mean of an Array](https://www.geeksforgeeks.org/problems/mean0021/1) | Summation with 64-bit `long` & Floor Mean |
| **04** | [Problem04_CountOddEven.java](file:///c:/Users/srini/OneDrive/Desktop/JAVA+DSA/ARRAYS/Problem04_CountOddEven.java) | [Count Odd Even](https://www.geeksforgeeks.org/problems/count-odd-even/1) | Parity Check (`num % 2`) & Array Return |
| **05** | [Problem05_FindFrequency.java](file:///c:/Users/srini/OneDrive/Desktop/JAVA+DSA/ARRAYS/Problem05_FindFrequency.java) | [Find the Frequency](https://www.geeksforgeeks.org/problems/find-the-frequency/1) | Target Match Counter |
| **06** | [Problem06_NumberOfOccurrence.java](file:///c:/Users/srini/OneDrive/Desktop/JAVA+DSA/ARRAYS/Problem06_NumberOfOccurrence.java) | [Number of Occurrence](https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1) | Binary Search First & Last Occurrence ($O(\log n)$) |
| **07** | [Problem07_CheckSorted.java](file:///c:/Users/srini/OneDrive/Desktop/JAVA+DSA/ARRAYS/Problem07_CheckSorted.java) | [Check if an Array is Sorted](https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1) | Adjacent Inversion Check (`arr[i] < arr[i-1]`) |
| **08** | [Problem08_ProductOfArrayElements.java](file:///c:/Users/srini/OneDrive/Desktop/JAVA+DSA/ARRAYS/Problem08_ProductOfArrayElements.java) | [Product of Array Element](https://www.geeksforgeeks.org/problems/product-of-array-element/1) | Modulo Arithmetic Multiplication |
| **09** | [Problem09_SearchElement.java](file:///c:/Users/srini/OneDrive/Desktop/JAVA+DSA/ARRAYS/Problem09_SearchElement.java) | [Search an Element in an Array](https://www.geeksforgeeks.org/problems/search-an-element-in-an-array-1587115621/1) | Linear Search ($O(n)$) |
| **10** | [Problem10_ReverseArray.java](file:///c:/Users/srini/OneDrive/Desktop/JAVA+DSA/ARRAYS/Problem10_ReverseArray.java) | [Reverse an Array](https://www.geeksforgeeks.org/problems/reverse-an-array/1) | Two-Pointer In-Place Swap ($O(1)$ Space) |
| **11** | [Problem11_SecondLargest.java](file:///c:/Users/srini/OneDrive/Desktop/JAVA+DSA/ARRAYS/Problem11_SecondLargest.java) | [Second Largest](https://www.geeksforgeeks.org/problems/second-largest3735/1) | Optimal Single-Pass Track Largest & 2nd Largest ($O(n)$) |


