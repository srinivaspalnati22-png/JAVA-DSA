# ☕ Foundations of Java & DSA (`BASICOFJAVA+DSA`)

Welcome to the foundational module for Java programming and Data Structures & Algorithms. This module covers core architectural fundamentals, language basics, program lifecycle, memory concepts, types, operators, casting, conditionals, and loops.

---

## 📚 Module Curriculum & Topic Breakdown

| # | Topic Document | Key Concepts Covered |
|---|---|---|
| **01** | [01_What_Is_DSA.md](./01_What_Is_DSA.md) | What is DSA, Linear vs Non-Linear vs Hash-Based data structures, Algorithm classifications, Why learn DSA, Comprehensive learning roadmap. |
| **02** | [02_What_Is_Java.md](./02_What_Is_Java.md) | What is Java, History (Oak $\rightarrow$ Java $\rightarrow$ Oracle), WORA principle, Core features, JVM/JIT/GC, Enterprise use cases, 2026+ career outlook, Frameworks. |
| **03** | [03_Java_Execution_Flow.md](./03_Java_Execution_Flow.md) | How Java runs, Two-step execution model, Source code $\rightarrow$ Bytecode $\rightarrow$ Native code, JVM architecture & roles, JRE vs JDK comparison, The Golden Formula. |
| **04** | [04_Our_First_Java_Program.md](./04_Our_First_Java_Program.md) | Dissection of `HelloWorld`, `public class Main`, `public static void main(String[] args)`, `System.out.println()`, Terminal compilation & execution (`javac` & `java`). |
| **05** | [05_Variables_In_Java.md](./05_Variables_In_Java.md) | What is a Variable, Labeled Box & Water Bottle analogies, Variable anatomy, Memory reservation, Syntax across data types, Naming rules, Variable mutability. |
| **06** | [06_Data_Types_In_Java.md](./06_Data_Types_In_Java.md) | What is a Data Type, 8 Primitives vs Non-Primitives, Integer ranges & Two's complement formula, `float` vs `double`, `char` & `boolean`, Wrapper classes. |
| **07** | [07_Java_Operators.md](./07_Java_Operators.md) | Arithmetic, Assignment, Comparison/Relational, and Logical operators (`&&`, `\|\|`, `!`), Truth tables, Operator reference guide. |
| **08** | [08_Type_Casting_In_Java.md](./08_Type_Casting_In_Java.md) | Widening (Implicit) vs Narrowing (Explicit) casting, Type promotion rules, Char $\leftrightarrow$ ASCII conversion, Truncation & Byte overflow wraparound. |
| **09** | [09_Conditionals_In_Java.md](./09_Conditionals_In_Java.md) | Decision making in Java, Simple `if`, `if-else`, `else-if` ladder, Nested `if`, Ternary operator `?:`, `switch` statements, Decision guide. |
| **10** | [10_Loops_In_Java.md](./10_Loops_In_Java.md) | Why loops are needed, `for`, `while`, `do-while`, enhanced `for-each` loop, `break` & `continue` control flow, Infinite loops & prevention best practices. |
| **11** | [11_Inputs_And_Outputs_In_Java.md](./11_Inputs_And_Outputs_In_Java.md) | Standard streams (`in`, `out`, `err`), `print`/`println`/`printf` formatting, `Scanner` input methods, nextLine newline trap, fast I/O with `BufferedReader` & `StringTokenizer`. |
| **12** | [12_Methods_In_Java.md](./12_Methods_In_Java.md) | Methods in Java, Syntax & anatomy (`public static void`), Four types of methods, Method overloading, Recursion & base cases, JVM call stack & StackOverflowError, Best practices. |
| **13** | [13_Time_And_Space_Complexity.md](./13_Time_And_Space_Complexity.md) | Asymptotic Notations (Big-O, Ω, Θ), Rules of calculation, Complexity hierarchy ($O(1)$ to $O(N!)$), Code patterns, Auxiliary vs Input Space, Java traps, 1-second rule & constraint mapping. |
| **14** | [14_Linear_Search.md](./14_Linear_Search.md) | Linear search intuition, Step-by-step visual trace, 1D/2D arrays, Strings, Range bounds, Min/Max finding, Multi-occurrences, $O(1)$ to $O(N)$ complexity, Linear vs Binary Search, Pitfalls, LeetCode problems. |
| **15** | [15_Binary_Search.md](./15_Binary_Search.md) | Binary search intuition, $O(\log N)$ superpower proof, Safe `mid` integer overflow formula, 10 Models (Standard, Recursive, Order-Agnostic, First/Last occurrence, Floor/Ceiling, Mountain peak, Rotated array, Sqrt on answer space, 2D matrix, `Arrays.binarySearch()`), and Test matrix. |

---

## 💻 Runnable Java Programs

- **[FirstProgram.java](./FirstProgram.java)**: Classic Java entry point and console printing demonstration.
- **[VariablesDemo.java](./VariablesDemo.java)**: Practical demonstration of variable declaration, memory updates, multiple data types, and naming conventions.
- **[DataTypesDemo.java](./DataTypesDemo.java)**: Integral boundaries, floating-point precision, character codes, and wrapper class constants.
- **[OperatorsDemo.java](./OperatorsDemo.java)**: Arithmetic calculations, assignment compounding, relational comparisons, and logical short-circuiting.
- **[TypeCastingDemo.java](./TypeCastingDemo.java)**: Widening vs narrowing casting, expression promotions, ASCII conversions, and overflow wrapping.
- **[ConditionalsDemo.java](./ConditionalsDemo.java)**: Execution branching across `if`, `if-else`, `else-if`, ternary operator, and `switch` matching.
- **[LoopsDemo.java](./LoopsDemo.java)**: Loop iterations across `for`, `while`, `do-while`, enhanced `for-each`, and `break`/`continue` flow control.
- **[InputOutputDemo.java](./InputOutputDemo.java)**: Output stream printing, formatted flags, escape sequences, `Scanner` token parsing, newline handling, and `BufferedReader` fast input.
- **[MethodsDemo.java](./MethodsDemo.java)**: Four types of methods, compile-time method overloading, recursion countdown & factorial, and JVM call stack visualization.
- **[ComplexityDemo.java](./ComplexityDemo.java)**: Practical benchmarks across $O(1)$, $O(\log N)$, $O(N)$, $O(N^2)$, String vs StringBuilder trap, and in-place vs buffer memory.
- **[LinearSearchDemo.java](./LinearSearchDemo.java)**: Comprehensive linear search across 1D arrays, boolean checks, strings, bounded ranges, min/max finding, 2D matrices, all occurrences, and LeetCode problems.
- **[BinarySearchDemo.java](./BinarySearchDemo.java)**: Comprehensive binary search across all 10 models (Iterative, Recursive, Order-Agnostic, Duplicates First/Last, Floor/Ceiling, Mountain Peak, Rotated Array, Sqrt Answer Space, 2D Matrix, and Built-in API decoding).

---

## 🛠️ How to Compile & Run

```bash
# Compile all demos in this module
javac BASICOFJAVA+DSA/*.java

# Run any demo
java -cp BASICOFJAVA+DSA DataTypesDemo
java -cp BASICOFJAVA+DSA OperatorsDemo
java -cp BASICOFJAVA+DSA TypeCastingDemo
java -cp BASICOFJAVA+DSA ConditionalsDemo
java -cp BASICOFJAVA+DSA LoopsDemo
java -cp BASICOFJAVA+DSA InputOutputDemo
java -cp BASICOFJAVA+DSA MethodsDemo
java -cp BASICOFJAVA+DSA ComplexityDemo
java -cp BASICOFJAVA+DSA LinearSearchDemo
java -cp BASICOFJAVA+DSA BinarySearchDemo
```
