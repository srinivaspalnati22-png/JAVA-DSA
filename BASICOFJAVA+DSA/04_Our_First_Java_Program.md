# 🚀 04. Our First Java Program

---

## 📌 1. The Classic "Hello, World!" Program

Every programmer's journey in Java begins with writing and executing this foundational program:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### 🖥️ Console Output:
```text
Hello, World!
```

---

## 🔍 2. Detailed Syntax Breakdown

Let us dissect every single keyword and symbol in this program.

```
public class Main {
  │     │     │
  │     │     └── 3. Class Name (Must match file name Main.java)
  │     └──────── 2. Class Keyword (Blueprint container for code)
  └────────────── 1. Access Modifier (Accessible from anywhere)

    public static void main(String[] args) {
      │      │     │    │        │
      │      │     │    │        └── 8. Command-Line Arguments Array
      │      │     │    └─────────── 7. Main Method Identifier (Entry point)
      │      │     └──────────────── 6. Return Type (Returns no value)
      │      └────────────────────── 5. Static Modifier (Called without object instantiation)
      └───────────────────────────── 4. Access Modifier (JVM can invoke from outside)

        System.out.println("Hello, World!");
          │     │    │
          │     │    └── 11. Print Method (Prints text and adds newline)
          │     └─────── 10. Standard Output Stream (Console destination)
          └───────────── 9. Built-in Java Class (System utility class)
    }
}
```

---

### 🧩 Part 1: `public class Main`

| Keyword | Role & Explanation |
| :--- | :--- |
| **`public`** | An access modifier that makes the class accessible from anywhere, including the JVM outside the package. |
| **`class`** | The fundamental building block keyword in Java used to declare a class. In Java, **every line of executable code must live inside a class**. |
| **`Main`** | The identifier / name of the class. |

> [!IMPORTANT]
> **File Name Rule:** In Java, if a class is declared `public`, the source file name **must exactly match** the class name with the `.java` extension (e.g., `public class Main` must be saved in `Main.java`).

---

### 🧩 Part 2: `public static void main(String[] args)`

The `main` method is the **exact entry point** where the JVM starts program execution.

| Component | Why is it used? |
| :--- | :--- |
| **`public`** | Allows the external JVM to locate and execute the entry point method from outside the class. |
| **`static`** | Allows the JVM to invoke `main()` directly **without creating an instance / object** of the `Main` class first (`Main.main()`). |
| **`void`** | The return type specifying that the method does **not return any value** upon finishing execution. |
| **`main`** | The predefined method name specifically recognized by the JVM as the application's starting point. |
| **`String[] args`** | An array of Strings that stores any **command-line arguments** passed when launching the program (e.g., `java Main arg1 arg2`). |

---

### 🧩 Part 3: `System.out.println("Hello, World!");`

| Component | What It Represents |
| :--- | :--- |
| **`System`** | A final utility class provided by `java.lang` package containing system-level resources. |
| **`out`** | A `public static final PrintStream` variable inside `System` representing the **standard output stream** (your terminal/console window). |
| **`println()`** | A built-in method that outputs the given text to the console and automatically moves the cursor to the beginning of the next line. |

---

## 🛠️ 3. How to Compile & Run via Terminal

```
Step 1: Write Code      ──►  Main.java
Step 2: Compile (javac) ──►  javac Main.java  (Produces Main.class bytecode)
Step 3: Run (java)      ──►  java Main        (Launches JVM to execute)
```

```bash
# 1. Compile the Java source file (Notice: include .java extension)
javac Main.java

# 2. Run the compiled Bytecode (Notice: do NOT include .class extension)
java Main
```

> [!TIP]
> Always compile with the full file name (`javac Main.java`), but run with just the class name (`java Main`).

---

## 📖 4. Quick Keyword Reference Sheet

| Keyword / Identifier | Meaning & Function |
| :--- | :--- |
| `public` | Accessible from anywhere |
| `class` | Blueprint keyword holding program code |
| `static` | Belongs to the class; executable without creating an object |
| `void` | Specifies that the method returns nothing |
| `main` | JVM application entry point identifier |
| `String[] args` | Array holding command line arguments |
| `System.out.println()` | Prints text to console and adds a newline |
| `System.out.print()` | Prints text to console **without** adding a newline |

---

## 📝 5. Key Takeaways ✅

1. **Every Java program lives inside a class**.
2. **File name and class name must match** for public classes.
3. **Execution always starts at `public static void main(String[] args)`**.
4. **Compile with `javac`, run with `java`**.
