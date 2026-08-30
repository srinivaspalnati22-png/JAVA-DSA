# 📥📤 11. Inputs and Outputs in Java

---

## 📌 1. What Are Inputs and Outputs (I/O)?

In computer science, **Input** is the data given to a computer program by a user, file, or system, and **Output** is the information or results sent back to the screen, console, file, or external system.

$$\text{User / Source} \xrightarrow{\quad\text{Input}\quad} \mathbf{\left[\; \text{Java Program} \;\right]} \xrightarrow{\quad\text{Output}\quad} \text{Console / Screen}$$

Java handles input and output using the concept of **Streams** — a continuous sequence of data flowing from a source to a destination.

---

## 🌊 2. Standard Streams in Java (`System` Class)

Java provides three built-in standard stream objects under the `java.lang.System` class:

```
                          ┌────────────────────────┐
                          │   java.lang.System     │
                          └───────────┬────────────┘
                                      │
        ┌─────────────────────────────┼─────────────────────────────┐
        ▼                             ▼                             ▼
  System.in                     System.out                    System.err
 ┌──────────────────────┐      ┌──────────────────────┐      ┌──────────────────────┐
 │ Standard Input       │      │ Standard Output      │      │ Standard Error       │
 │ Type: InputStream    │      │ Type: PrintStream    │      │ Type: PrintStream    │
 │ Source: Keyboard     │      │ Target: Console      │      │ Target: Error log    │
 └──────────────────────┘      └──────────────────────┘      └──────────────────────┘
```

| Stream Object | Type | Direction | Default Device | Purpose |
| :--- | :--- | :--- | :--- | :--- |
| **`System.in`** | `InputStream` | Input | Keyboard | Reads raw bytes from keyboard or redirected input stream. |
| **`System.out`** | `PrintStream` | Output | Console Screen | Prints standard output messages and results. |
| **`System.err`** | `PrintStream` | Output | Console Screen / Log | Prints error messages and diagnostics (often styled in red in IDEs). |

---

## 📤 3. Output in Java (Console Printing)

Java provides three primary methods for displaying information on the console:

### 1️⃣ `System.out.print()`
Prints the given text **without** adding a newline at the end. The cursor stays on the same line.

```java
System.out.print("Hello ");
System.out.print("World!");
// Output: Hello World!
```

---

### 2️⃣ `System.out.println()`
Prints the given text followed by an **automatic newline** (`\n`). The cursor moves to the beginning of the next line.

```java
System.out.println("Line 1");
System.out.println("Line 2");
// Output:
// Line 1
// Line 2
```

---

### 3️⃣ `System.out.printf()` & `String.format()`
Provides **formatted printing** with custom precision, alignment, and format specifiers (similar to `printf` in C/C++).

```java
String name = "Alice";
int age = 21;
double gpa = 3.9284;

System.out.printf("Student: %-10s | Age: %03d | GPA: %.2f%n", name, age, gpa);
// Output: Student: Alice      | Age: 021 | GPA: 3.93
```

#### 📊 Common Format Specifiers:
| Specifier | Data Type | Example | Output |
| :--- | :--- | :--- | :--- |
| **`%d`** | Integer (`byte`, `short`, `int`, `long`) | `printf("%d", 42)` | `42` |
| **`%f`** | Floating-point (`float`, `double`) | `printf("%.2f", 3.14159)` | `3.14` |
| **`%s`** | String / Object | `printf("%s", "Java")` | `Java` |
| **`%c`** | Character (`char`) | `printf("%c", 'A')` | `A` |
| **`%b`** | Boolean (`boolean`) | `printf("%b", true)` | `true` |
| **`%n`** | Platform-independent Newline | `printf("Hi%n")` | Moves cursor to next line |

#### 📐 Formatting Flags & Width:
- **`%10s`**: Right-align within 10 characters width.
- **`%-10s`**: Left-align within 10 characters width.
- **`%05d`**: Pad integer with leading zeros to 5 digits (e.g., `00042`).
- **`%.2f`**: Round floating point to exactly 2 decimal places.

---

### 🔤 4. Common Escape Sequences
Escape sequences allow printing special characters like tabs, newlines, and quotes:

| Escape Sequence | Character Represented | Example Code | Output |
| :--- | :--- | :--- | :--- |
| **`\n`** | Newline (Line feed) | `System.out.print("A\nB");` | `A` on line 1, `B` on line 2 |
| **`\t`** | Horizontal Tab | `System.out.print("Age:\t25");` | `Age:    25` |
| **`\"`** | Double Quote | `System.out.print("\"Java\"");` | `"Java"` |
| **`\'`** | Single Quote | `System.out.print('\'');` | `'` |
| **`\\`** | Backslash | `System.out.print("C:\\path");` | `C:\path` |

---

## 📥 5. Standard Input Using `Scanner` (`java.util.Scanner`)

The **`Scanner`** class is the most beginner-friendly and versatile way to read primitive values and strings from standard input (`System.in`).

### 📝 Basic Setup:
```java
import java.util.Scanner; // 1. Import Scanner

public class InputDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 2. Create Scanner Object

        System.out.print("Enter your age: ");
        int age = sc.nextInt(); // 3. Read an integer

        System.out.println("Your age is " + age);

        sc.close(); // 4. Close the scanner
    }
}
```

---

### 🗂️ Common `Scanner` Methods

| Method | Reads | Example Return |
| :--- | :--- | :--- |
| **`sc.nextInt()`** | `int` | `100` |
| **`sc.nextDouble()`** | `double` | `99.95` |
| **`sc.nextFloat()`** | `float` | `3.14f` |
| **`sc.nextLong()`** | `long` | `9876543210L` |
| **`sc.nextBoolean()`** | `boolean` | `true` or `false` |
| **`sc.nextByte()`** | `byte` | `127` |
| **`sc.nextShort()`** | `short` | `32000` |
| **`sc.next()`** | `String` (Reads single word up to whitespace) | `"Java"` (from `"Java DSA"`) |
| **`sc.nextLine()`** | `String` (Reads entire line including spaces) | `"Java DSA Course"` |
| **`sc.next().charAt(0)`** | `char` (Reads single character) | `'M'` |

---

### ⚠️ 6. The Classic `nextLine()` Trap (Must Know!)

One of the most common pitfalls in Java occurs when calling `sc.nextLine()` immediately after reading a number using `sc.nextInt()` or `sc.nextDouble()`.

#### 🔴 The Problem:
```java
Scanner sc = new Scanner(System.in);

System.out.print("Enter roll number: ");
int roll = sc.nextInt(); // User types: 42 and presses [ENTER]

System.out.print("Enter full name: ");
String name = sc.nextLine(); // ❌ SKIPPED! Reads leftover '\n' from previous line

System.out.println("Roll: " + roll + ", Name: " + name);
```

#### 🔍 Why Does This Happen?
- When the user types `42` followed by **Enter**, the input buffer contains: `['4', '2', '\n']`.
- `sc.nextInt()` consumes `42`, leaving `'\n'` in the buffer.
- `sc.nextLine()` reads until the next `'\n'`, immediately encounters the leftover newline, and returns an empty string `""` without waiting for user input!

```
Buffer: [ 4 ][ 2 ][ \n ]
         ▲────────▲  ▲
      sc.nextInt()   │
                     └── sc.nextLine() reads '\n' and finishes immediately!
```

#### 🟢 The Solution:
Consume the leftover newline character by placing a dummy `sc.nextLine()` after `sc.nextInt()`:

```java
int roll = sc.nextInt();
sc.nextLine(); // ✅ Consumes leftover newline '\n'

String name = sc.nextLine(); // ✅ Now properly waits for user input!
```

---

## ⚡ 7. Fast I/O for DSA & Competitive Programming: `BufferedReader`

While `Scanner` is convenient with automatic parsing and regex tokenization, it is **slow** for processing large inputs ($10^5$ to $10^6$ lines) common in DSA and competitive programming platforms (LeetCode, Codeforces, CodeChef).

### 🚀 Why Use `BufferedReader`?
- **Larger Buffer**: 8KB buffer (compared to 1KB in `Scanner`).
- **Zero Regex Overhead**: Reads raw lines directly without regular expression parsing.
- **$\approx 5\times - 10\times$ Faster** than `Scanner`.

### 💻 `BufferedReader` Code Template:
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FastIODemo {
    public static void main(String[] args) throws IOException {
        // Wrap System.in in an InputStreamReader and BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading an entire line
        String line = br.readLine();

        // Parsing an integer
        int n = Integer.parseInt(br.readLine());

        // Parsing space-separated tokens on a single line
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println("Sum: " + (a + b));
    }
}
```

---

## ⚖️ 8. `Scanner` vs `BufferedReader` Comparison

| Feature | `Scanner` (`java.util`) | `BufferedReader` (`java.io`) |
| :--- | :--- | :--- |
| **Speed / Performance** | Slower (uses regex & parsing) | **Much faster** ($\sim 5\times-10\times$) |
| **Default Buffer Size** | 1 KB (1024 chars) | **8 KB** (8192 chars) |
| **Parsing Capability** | Built-in (`nextInt()`, `nextDouble()`) | Manual parsing (`Integer.parseInt()`) |
| **Exception Handling** | Hides `IOException` | Requires `throws IOException` or `try-catch` |
| **Input Source** | Strings, Streams, Files | Reader objects / Streams |
| **Thread Safety** | Not synchronized (faster single thread) | Synchronized (thread-safe) |
| **Best Use Case** | Beginner programs, Small inputs, Menus | **Competitive Programming, DSA, Large I/O** |

---

## 🛡️ 9. Resource Management & Closing Streams

Streams interact with native operating system resources. When done using a `Scanner` or `BufferedReader`, always release system resources:

```java
// Method 1: Manual close
Scanner sc = new Scanner(System.in);
// ... do operations ...
sc.close();

// Method 2: Try-with-resources (Automatic Cleanup)
try (Scanner scanner = new Scanner(System.in)) {
    int val = scanner.nextInt();
    System.out.println("Value: " + val);
} // scanner is automatically closed here
```

> [!NOTE]
> If you close a `Scanner` connected to `System.in`, `System.in` itself is closed and **cannot be reopened** in the same program execution. In console applications with multiple methods, it is recommended to keep a single `Scanner` instance or close it only at the very end of `main()`.

---

## 🏁 10. Key Takeaways

1. **Standard Streams**: `System.in` (input), `System.out` (output), `System.err` (error output).
2. **Output Formatting**: Use `print()` for continuous text, `println()` for automatic newlines, and `printf()` for formatted data and decimal precision.
3. **`Scanner` Utility**: Convenient for parsing primitives (`nextInt()`, `nextDouble()`) and words (`next()`, `nextLine()`).
4. **Newline Trap**: Remember to call a dummy `sc.nextLine()` after `sc.nextInt()` before reading string lines.
5. **Fast I/O for DSA**: Prefer `BufferedReader` + `StringTokenizer` when dealing with $10^5+$ inputs in competitive programming.
