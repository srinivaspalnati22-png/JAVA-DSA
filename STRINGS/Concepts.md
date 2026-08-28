# 🧵 Complete Guide to Strings in Java

---

## 📌 1. What is a String?

A **String** in Java is a **sequence of characters** used to store and manipulate text. It is one of the most fundamental and widely used data types in Java programming and Data Structures & Algorithms.

```
Visual Representation of a String: "JAVA"
Index:      [ 0 ]   [ 1 ]   [ 2 ]   [ 3 ]
Char:      |  'J' |  'A' |  'V' |  'A' |
```

### 🔑 Key Characteristics:
1. **String is a Class**: Unlike `int`, `char`, or `double`, `String` is **NOT a primitive data type**. It is a class defined in the `java.lang` package (`java.lang.String`) with rich built-in behaviors and methods.
2. **Stores Text**: Used for storing names, messages, file paths, URLs, JSON payloads, search queries, etc.
3. **Immutable**: Once a String object is created in memory, its content **cannot be modified or changed**. Any modification creates a brand new String object.

---

## 🏗️ 2. Creating Strings: Literal vs `new` Keyword

Java offers two ways to create a String object:

```java
// Method 1: String Literal Syntax (Recommended & Preferred)
String name = "Eshwar";
String city = "Tirupati";

// Method 2: Using the 'new' Keyword
String str = new String("Tirupati");
```

### 🔍 Under-the-Hood Comparison:

| Feature | Literal Syntax (`"..."`) | `new` Keyword (`new String(...)`) |
| :--- | :--- | :--- |
| **Storage Location** | Stored in the **String Constant Pool (SCP)** inside Heap memory | Stored directly in the general **Heap memory** (outside SCP) |
| **Object Creation** | Reuses existing instances if the same literal already exists | **Always creates a new object** on the heap, even if value exists |
| **Memory Efficiency** | ⚡ High (Saves memory by avoiding duplicates) | ⚠️ Low (Creates redundant heap objects) |
| **Best Practice** | **Preferred for almost all standard use cases** | Used only when explicitly requiring an independent object |

---

## 🔒 3. String Immutability

### What does "Immutable" mean?
> **Immutability** means that once a String object is created in memory, its state or character sequence **can never be altered**.

```java
String s = "Java";
s = "Python";
```

### 🧠 What Happens in Memory?
1. `"Java"` is created in the String Pool, and `s` points to `"Java"`.
2. When executing `s = "Python";`, Java **does NOT modify** `"Java"` to become `"Python"`.
3. Instead, a **new String object** `"Python"` is created in memory.
4. The reference variable `s` stops pointing to `"Java"` and now references the new object `"Python"`.
5. The original `"Java"` remains completely unchanged in memory (and will be garbage collected if no other reference points to it).

```
Stack                     Heap (String Constant Pool)
+-------+                 +-------------------------+
|   s   | --------------> |  "Python" (New Object)  |
+-------+      \          +-------------------------+
                \ - - - > |  "Java"   (Unmodified)  |
                          +-------------------------+
```

### 💡 Why are Strings Immutable in Java?
1. **String Constant Pool (SCP) Sharing**: Multiple reference variables can safely point to the exact same String object without fear of one modifying it for others.
2. **Security**: Sensitive parameters like database URLs, usernames, passwords, socket connections, and file paths cannot be altered maliciously during transit.
3. **Thread Safety**: Immutable objects are inherently thread-safe and can be shared across multiple threads without synchronization locks.
4. **HashCode Caching**: The hash code of a String is computed once and cached. This makes Strings optimal keys for hash-based collections like `HashMap` and `HashSet`.

---

## 🏊 4. The String Pool (String Constant Pool / SCP)

The **String Constant Pool** is a special reserved memory region inside Java's Heap memory designed specifically for caching String literals.

```
                     HEAP MEMORY
+----------------------------------------------------+
|  Non-Pool Heap Memory:                             |
|  +---------------------------+                     |
|  | c = new String("Hello")   |                     |
|  +---------------------------+                     |
|                                                    |
|  STRING CONSTANT POOL (SCP):                       |
|  +-----------------------------------------------+ |
|  |  "Hello" <------- a ("Hello")                 | |
|  |          <------- b ("Hello") (Reuses Object!)| |
|  +-----------------------------------------------+ |
+----------------------------------------------------+
```

### Scenario Breakdown:
```java
String a = "Hello";              // Stored in String Pool
String b = "Hello";              // Reuses the same "Hello" object from Pool
String c = new String("Hello");  // Creates a distinct new object in Heap
```

- `a == b` evaluates to **`true`** because both point to the exact same memory address in the String Pool.
- `a == c` evaluates to **`false`** because `c` refers to a separate object in Heap memory outside the pool.
- `a.equals(c)` evaluates to **`true`** because both have identical character sequences (`"Hello"`).

---

## ⚖️ 5. Comparing Strings: `==` vs `equals()`

| Comparison | Syntax | What It Compares | Example Result (`a="Java"`, `b=new String("Java")`) |
| :--- | :--- | :--- | :--- |
| **Reference Equality** | `a == b` | **Memory addresses** (whether both point to the same object) | ❌ `false` |
| **Content Equality** | `a.equals(b)` | **Actual character content** (value equality) | ✅ `true` |
| **Case-Insensitive** | `a.equalsIgnoreCase(b)` | Characters ignoring uppercase/lowercase | ✅ `true` (`"java"` vs `"JAVA"`) |
| **Lexicographical** | `a.compareTo(b)` | Dictionary order difference ($< 0$, $0$, or $> 0$) | `0` (Equal) |

```java
// ❌ WRONG: Comparing content using ==
String a = "Java";
String b = new String("Java");
if (a == b) { // FALSE! Checks reference address
    System.out.println("Same");
}

// ✅ CORRECT: Comparing content using equals()
if (a.equals(b)) { // TRUE! Checks character sequence
    System.out.println("Equal content");
}

// ✅ Case-Insensitive Comparison
if ("java".equalsIgnoreCase("JAVA")) { // TRUE!
    System.out.println("Matches ignoring case");
}
```

> [!WARNING]
> **Always use `.equals()` or `.equalsIgnoreCase()` to compare String values in Java — NEVER use `==`!**

---

## 🛠️ 6. Common String Built-in Methods

Java's `String` class provides rich built-in methods:

| Method | Return Type | Description | Example (`String str = "  Java DSA  ";`) | Result |
| :--- | :--- | :--- | :--- | :--- |
| `length()` | `int` | Number of characters | `str.length()` | `12` |
| `charAt(int index)` | `char` | Character at given index | `"Java".charAt(2)` | `'v'` |
| `toUpperCase()` | `String` | Converts to uppercase | `"java".toUpperCase()` | `"JAVA"` |
| `toLowerCase()` | `String` | Converts to lowercase | `"JAVA".toLowerCase()` | `"java"` |
| `contains(CharSequence s)` | `boolean` | Checks if substring exists | `"Java DSA".contains("DSA")` | `true` |
| `replace(old, new)` | `String` | Replaces character/substring | `"Java".replace("Java", "Python")`| `"Python"` |
| `substring(begin, end)` | `String` | Substring from `begin` to `end - 1` | `"Tirupati".substring(0, 4)` | `"Tiru"` |
| `substring(begin)` | `String` | Substring from `begin` to end | `"Tirupati".substring(4)` | `"pati"` |
| `trim()` | `String` | Removes leading & trailing whitespace | `"  Hello  ".trim()` | `"Hello"` |
| `indexOf(String s)` | `int` | First index of substring (-1 if absent) | `"Java".indexOf("v")` | `2` |
| `lastIndexOf(String s)` | `int` | Last index of substring | `"banana".lastIndexOf("a")` | `5` |
| `startsWith(String prefix)`| `boolean` | Checks starting prefix | `"Java".startsWith("Ja")` | `true` |
| `endsWith(String suffix)` | `boolean` | Checks ending suffix | `"Main.java".endsWith(".java")` | `true` |
| `toCharArray()` | `char[]` | Converts String to char array | `"DSA".toCharArray()` | `['D','S','A']` |
| `split(String regex)` | `String[]` | Splits string by delimiter | `"a,b,c".split(",")` | `["a", "b", "c"]` |
| `isEmpty()` | `boolean` | Checks if `length == 0` | `"".isEmpty()` | `true` |
| `isBlank()` | `boolean` | Checks if empty or only whitespace | `"   ".isBlank()` | `true` |
| `String.valueOf(val)` | `String` | Converts any primitive/object to String | `String.valueOf(123)` | `"123"` |

---

## ⚡ 7. `String` vs `StringBuilder` vs `StringBuffer`

Because `String` is immutable, repeated string concatenation (e.g. `str += "a"` inside a loop) creates $O(N)$ intermediate throwaway objects, resulting in **$O(N^2)$ time complexity** and excessive memory churn. 

`StringBuilder` and `StringBuffer` solve this by providing **mutable sequences of characters**.

### 📊 Comprehensive Comparison Table:

| Feature | `String` | `StringBuilder` | `StringBuffer` |
| :--- | :--- | :--- | :--- |
| **Mutability** | ❌ **Immutable** | ✅ **Mutable** | ✅ **Mutable** |
| **Thread Safety** | ✅ **Thread-Safe** (by immutability) | ❌ **Not Thread-Safe** (No sync overhead) | ✅ **Thread-Safe** (`synchronized` methods) |
| **Performance / Speed**| 🐢 Slower on frequent modifications | 🚀 **Fastest** (Best for DSA) | ⏳ Slower than StringBuilder (Sync lock overhead) |
| **Introduced In** | Java 1.0 | Java 1.5 | Java 1.0 |
| **Storage** | String Pool / Heap | Heap memory | Heap memory |
| **Primary Use Case** | Constant values, keys, read-only text | Single-threaded heavy modifications, DSA | Multi-threaded shared mutable strings |

### 🛠️ Working with `StringBuilder`:
```java
StringBuilder sb = new StringBuilder();

// 1. Append
sb.append("Java");
sb.append(" DSA");
System.out.println(sb); // "Java DSA"

// 2. Insert
sb.insert(4, " &");
System.out.println(sb); // "Java & DSA"

// 3. Reverse (Very useful in DSA!)
sb.reverse();
System.out.println(sb); // "ASD & avaJ"

// 4. Delete
sb.delete(0, 4);        // Deletes range [0, 4)

// 5. Convert back to String
String result = sb.toString();
```

---

## 🌍 8. Where are Strings Used in Real-World Development?

1. **User Input Handling**: Names, email addresses, passwords, search bars, phone numbers.
2. **Web & Network Protocols**: URLs, URI paths, HTTP request headers, REST APIs, JSON/XML serialization.
3. **Communication Systems**: Chat applications, email templates, push notifications, logging (`System.out.println`, Log4j).
4. **File & Database Operations**: File paths, reading/writing text & CSV files, SQL queries, configuration properties.

---

## 🎯 9. Common String Problem-Solving Patterns in DSA

| Pattern / Technique | Core Concept | Example Problems |
| :--- | :--- | :--- |
| **Two Pointers** | Compare/swap characters from left and right inward | Valid Palindrome, Reverse String |
| **Frequency Array / Hash Map** | Count ASCII/lowercase characters (`int[26]` or `int[256]`) | Valid Anagram, First Unique Character |
| **Sliding Window** | Expand & shrink window to track unique/valid substring | Longest Substring Without Repeating Characters |
| **StringBuilder Accumulation** | Mutable string modification without $O(N^2)$ copies | String Compression, Add Binary |
| **Pattern Matching / KMP** | Substring search algorithms | Find the Index of the First Occurrence |

---

## 📝 10. Key Takeaways & Interview Cheat Sheet ✅

- [x] **Class, Not Primitive**: `String` is an object in `java.lang.String`.
- [x] **Immutable by Design**: Modifications return new String objects; originals are never changed.
- [x] **String Constant Pool**: Reuses identical string literals to conserve memory.
- [x] **`new String()` Bypasses Pool Reuse**: Creates a distinct new object in Heap memory.
- [x] **Use `.equals()`, Not `==`**: `==` checks memory reference equality; `.equals()` checks character content.
- [x] **Use `StringBuilder` for Modifications**: Provides mutable character sequences and optimal $O(N)$ operations for algorithms and loops.
- [x] **String Length**: Use `str.length()` (method with parentheses), unlike `arr.length` (array property without parentheses).
