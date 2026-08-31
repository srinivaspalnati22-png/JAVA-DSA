# 🧩 12. Methods in Java

---

## 📌 1. What Is a Method?

A **Method** (often called a *function* in other languages) is a reusable block of code that performs a specific, well-defined task.

$$\text{Caller} \xrightarrow{\quad\text{Arguments (Input)}\quad} \mathbf{\left[\; \text{Method Body (Logic)} \;\right]} \xrightarrow{\quad\text{Return Value (Output)}\quad} \text{Caller}$$

> **Core Philosophy:** **"Write Once, Call Anywhere"** — methods eliminate redundancy, keeping your programs clean, organized, modular, and maintainable.

---

## ⚖️ 2. Why Do We Need Methods?

Without methods, code quickly becomes repetitive, tangled, and fragile. Methods transform scattered procedural code into structured, modular units.

```
┌────────────────────────────────────────┬────────────────────────────────────────┐
│          ❌ WITHOUT METHODS            │            ✅ WITH METHODS             │
├────────────────────────────────────────┼────────────────────────────────────────┤
│ • Duplicate logic pasted across files  │ • 100% Code Reusability (DRY)          │
│ • Bugs must be fixed in 20 places      │ • Single point of maintenance & fix    │
│ • Hard to read, test, and debug        │ • High readability & self-documenting  │
│ • Monolithic, messy spaghetti code     │ • Modular architecture & separation    │
└────────────────────────────────────────┴────────────────────────────────────────┘
```

---

## 🏗️ 3. Method Syntax & Anatomical Components

### 📐 General Syntax
```java
accessModifier static returnType methodName(parameterType param1, parameterType param2, ...) {
    // Method Body (Logic)
    return value; // (Required if returnType is not void)
}
```

```
   public   static   int   calculateSum ( int a , int b )  { ... }
   ──────   ──────   ───   ────────────   ───────────────
     │        │       │         │                │
     │        │       │         │                └─ Parameters (Inputs)
     │        │       │         └─ Method Name (Identifier)
     │        │       └─ Return Type (Data type of output)
     │        └─ Static Modifier (Called without object instance)
     └─ Access Modifier (Controls visibility & scope)
```

### 🔍 Component Breakdown:
| Component | Keyword / Element | Purpose & Description |
| :--- | :--- | :--- |
| **Access Modifier** | `public`, `private`, `protected`, *(default)* | Controls where the method can be accessed from (e.g., within the class, package, or globally). |
| **Static Keyword** | `static` | Allows the method to be invoked directly using the class name without instantiating an object (`ClassName.method()`). |
| **Return Type** | `void`, `int`, `double`, `String`, etc. | Data type of the value returned by the method. Use `void` if no value is returned. |
| **Method Name** | `greet()`, `add()` | Valid Java identifier using `camelCase` naming convention describing the action. |
| **Parameter List** | `(int a, String name)` | Comma-separated list of input variables accepted by the method. Empty `()` if none. |
| **Method Body** | `{ /* statements */ }` | The block of code executed whenever the method is called. |

> ⚠️ **Key Rule:** A method **never executes automatically**; it runs **only when it is called (invoked)** by a caller.

---

## 🔄 4. Four Types of Methods

Every method in Java falls into one of four fundamental categories based on whether it accepts parameters and whether it returns a value:

```
                          ┌─────────────────────────────┐
                          │    FOUR TYPES OF METHODS    │
                          └──────────────┬──────────────┘
                                         │
        ┌──────────────────┬─────────────┴─────────────┬──────────────────┐
        ▼                  ▼                           ▼                  ▼
 ┌──────────────┐   ┌──────────────┐            ┌──────────────┐   ┌──────────────┐
 │ 1. No Param  │   │ 2. Param     │            │ 3. No Param  │   │ 4. Param     │
 │    No Return │   │    No Return │            │    + Return  │   │    + Return  │
 └──────────────┘   └──────────────┘            └──────────────┘   └──────────────┘
   void greet()      void greet(name)             int rollDice()     int add(a, b)
```

---

### 1️⃣ Type 1: No Parameters, No Return Value
The simplest form of a method. It performs a self-contained action without requiring input or sending output back.

```java
public static void greet() {
    System.out.println("Hello! Welcome to Java DSA.");
}

// Invocation:
greet();
```

---

### 2️⃣ Type 2: With Parameters, No Return Value
Accepts input arguments to customize its behavior, but performs an action (like printing or updating) without returning a result.

```java
public static void greetUser(String name) {
    System.out.println("Hello, " + name + "! Welcome back.");
}

// Invocation:
greetUser("Eshwar");
greetUser("Srinivas");
```

---

### 3️⃣ Type 3: No Parameters, With Return Value
Requires no external input arguments, but computes or retrieves a value and hands it back to the caller.

```java
public static double getPi() {
    return 3.141592653589793;
}

// Invocation:
double piValue = getPi();
```

---

### 4️⃣ Type 4: With Parameters & With Return Value
The **most versatile and widely used** pattern in programming and DSA. It takes input arguments, processes them, and returns the computed result.

```java
public static int add(int a, int b) {
    return a + b;
}

// Invocation:
int sum = add(10, 20); // sum holds 30
```

---

## ⚡ 5. Method Overloading (Compile-Time Polymorphism)

**Method Overloading** allows a class to have multiple methods with the **same name**, provided they have **different parameter lists** (different number of arguments, different data types, or different order of types).

```
                      ┌───────────────────────────┐
                      │    Overloaded: add(...)   │
                      └─────────────┬─────────────┘
                                    │
           ┌────────────────────────┼────────────────────────┐
           ▼                        ▼                        ▼
    add(int, int)            add(int, int, int)      add(double, double)
```

### 💻 Code Example:
```java
// Version 1: Two integer parameters
public static int add(int a, int b) {
    return a + b;
}

// Version 2: Three integer parameters
public static int add(int a, int b, int c) {
    return a + b + c;
}

// Version 3: Two double parameters
public static double add(double a, double b) {
    return a + b;
}

// Invocation (Compiler resolves the target method at compile-time):
int sum2 = add(10, 20);        // Calls Version 1
int sum3 = add(10, 20, 30);    // Calls Version 2
double sumDouble = add(2.5, 4.5); // Calls Version 3
```

> ⚠️ **Overloading Rules:**
> 1. Methods **MUST** differ in parameter count, parameter types, or sequence of types.
> 2. Changing **only the return type** does NOT overload a method and causes a compile error.

---

## 🔁 6. Recursion (Self-Calling Methods)

A **Recursive Method** is a method that **calls itself** to solve a smaller subproblem of the original problem.

```
       print(3) ──► prints 3 ──► calls print(2)
                                        │
                                        ▼
                                 prints 2 ──► calls print(1)
                                                     │
                                                     ▼
                                              prints 1 ──► calls print(0) [BASE CASE: STOP]
```

### 💻 Code Example:
```java
public static void printCountdown(int n) {
    // 1. BASE CASE (Stopping condition)
    if (n == 0) {
        return;
    }
    
    // 2. WORK
    System.out.println(n);
    
    // 3. RECURSIVE CALL
    printCountdown(n - 1);
}
```

### 🌟 Common DSA Use Cases for Recursion:
- **Mathematical Computations**: Factorial, Fibonacci, GCD, Power calculations ($x^n$).
- **Divide and Conquer**: Merge Sort, Quick Sort, Binary Search.
- **Tree & Graph Traversals**: Inorder, Preorder, Postorder, DFS.
- **Backtracking**: N-Queens, Sudoku Solver, Subset & Permutation generation.

---

## 🥞 7. The JVM Call Stack & Memory Model

Java manages method execution using a **Call Stack** (LIFO — *Last-In, First-Out*):

1. Whenever a method is called, a new **Stack Frame** is pushed onto the call stack containing local variables and execution state.
2. When the method completes (`return`), its frame is **popped off** the stack, and execution resumes in the caller method.

```
  ┌────────────────────────┐
  │   multiply() Frame     │  ◄── [3. Active Execution Top]
  ├────────────────────────┤
  │      add() Frame       │  ◄── [2. Waiting for multiply() to return]
  ├────────────────────────┤
  │      main() Frame      │  ◄── [1. Entry Point Base Frame]
  └────────────────────────┘
         CALL STACK
```

### 💥 The StackOverflowError:
If a recursive method **lacks a valid base case** (or the base case is unreachable), recursive calls push infinite stack frames until stack memory is exhausted:

$$\text{Infinite Recursion} \longrightarrow \text{Stack Overflow} \longrightarrow \mathbf{\text{java.lang.StackOverflowError}}$$

---

## 🌟 8. Best Practices for Writing Methods

| Best Practice | Description & Rule of Thumb |
| :--- | :--- |
| **Meaningful Names** | Use descriptive verb-noun names like `calculateTotal()` or `findMax()` instead of vague names like `func1()` or `doStuff()`. |
| **Single Responsibility (SRP)** | One method should do **one thing well**. Keep methods short and focused for easy testing and debugging. |
| **Avoid Duplicate Code (DRY)** | If identical logic appears in two or more places, extract it into a reusable helper method. |
| **Explicit Return Values** | Return outputs directly to callers rather than mutating global/static variables. |
| **Parameterize for Flexibility** | Pass varying inputs as parameters instead of hardcoding values inside the method body. |

---

## 🎯 9. Where Methods Are Used & Summary

```
                      ┌────────────────────────────────────────┐
                      │        WHERE METHODS ARE USED          │
                      └───────────────────┬────────────────────┘
                                          │
        ┌───────────────────┬─────────────┴─────────────┬───────────────────┐
        ▼                   ▼                           ▼                   ▼
   REST APIs &        Enterprise Apps             Reusable Utility        Algorithm &
 Web Controllers      (Spring Boot)             Libraries (Math/Arrays)  DSA Functions
```

### 💡 Key Takeaway:
> **"Methods are the fundamental building blocks of Java."**
> 
> Mastering method syntax, parameter passing, return values, overloading, recursion, and stack frame mechanics forms the foundation for **Object-Oriented Programming (OOP)**, modular software engineering, and advanced Data Structures & Algorithms.
