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

---

## 🛠️ How to Compile & Run

```bash
# Compile all demos in this module
javac BASICOFJAVA+DSA/*.java

# Run any demo
java BASICOFJAVA+DSA.DataTypesDemo
java BASICOFJAVA+DSA.OperatorsDemo
java BASICOFJAVA+DSA.TypeCastingDemo
java BASICOFJAVA+DSA.ConditionalsDemo
java BASICOFJAVA+DSA.LoopsDemo
java BASICOFJAVA+DSA.InputOutputDemo
```
