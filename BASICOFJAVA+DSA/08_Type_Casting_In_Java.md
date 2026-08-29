# 🔄 08. Type Casting in Java

---

## 📌 1. What is Type Casting?

**Type Casting** is the process of converting a variable or value of **one data type into another data type**.

$$\text{Data Type A} \xrightarrow{\quad\text{Type Casting}\quad} \text{Data Type B}$$

Since Java is a **strongly typed language**, variables cannot simply change their types on the fly. When you want to store a value of one type into a variable of another type or perform operations across different types, **type casting** is used.

### 📦 The "Container Transfer" Analogy:
- **Small Glass $\rightarrow$ Large Bucket**: Water easily fits without any spill. (Automatic / Widening)
- **Large Bucket $\rightarrow$ Small Glass**: Water might overflow and spill unless carefully controlled. (Manual / Narrowing)

---

## 🎯 2. The Java Type Hierarchy Ladder

Java defines a clear size-based hierarchy for its numeric primitive types:

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                          JAVA TYPE PROMOTION LADDER                         │
│                                                                             │
│   byte (1B) ──► short (2B) ──► int (4B) ──► long (8B) ──► float (4B) ──► double (8B)
│                   ▲                                                         │
│                   │                                                         │
│                char (2B)                                                    │
└─────────────────────────────────────────────────────────────────────────────┘
  ◄─── Narrowing / Explicit Casting (Manual)       Widening / Implicit Casting (Automatic) ───►
```

> [!NOTE]
> Even though `long` is 8 bytes and `float` is 4 bytes, `float` is placed higher in the ladder because `float` can represent a much larger numerical range than `long` using IEEE 754 floating-point exponent representation!

---

## 🔼 3. Widening (Implicit) Type Casting

**Widening Casting** occurs when converting a **smaller data type to a larger data type**.

### 🌟 Characteristics:
- **Automatic**: Performed by the Java compiler automatically.
- **Safe**: No data loss or loss of precision.
- **Direction**: `byte` $\rightarrow$ `short` $\rightarrow$ `char` $\rightarrow$ `int` $\rightarrow$ `long` $\rightarrow$ `float` $\rightarrow$ `double`.

### 💻 Code Example:
```java
int myInt = 9;
double myDouble = myInt; // Automatic casting: int to double

System.out.println(myInt);    // Output: 9
System.out.println(myDouble); // Output: 9.0
```

---

## 🔽 4. Narrowing (Explicit) Type Casting

**Narrowing Casting** occurs when converting a **larger data type to a smaller data type**.

### ⚠️ Characteristics:
- **Manual**: Requires explicit target type in parentheses: `(targetType) value`.
- **Potential Data Loss**: Fractional parts are truncated or numbers may overflow.
- **Direction**: `double` $\rightarrow$ `float` $\rightarrow$ `long` $\rightarrow$ `int` $\rightarrow$ `short`/`char` $\rightarrow$ `byte`.

### 💻 Code Example:
```java
double myDouble = 9.78;
int myInt = (int) myDouble; // Manual casting: double to int

System.out.println(myDouble); // Output: 9.78
System.out.println(myInt);    // Output: 9 (decimal portion truncated!)
```

---

## ⚖️ 5. Widening vs Narrowing Comparison

| Feature | Widening (Implicit) Casting | Narrowing (Explicit) Casting |
| :--- | :--- | :--- |
| **Conversion** | Smaller type $\rightarrow$ Larger type | Larger type $\rightarrow$ Smaller type |
| **Syntax** | Done automatically: `double d = intVal;` | Done manually: `int i = (int) doubleVal;` |
| **Data Loss** | ❌ None (Completely Safe) | ⚠️ Potential truncation or overflow |
| **Compiler Intervention** | Done seamlessly by compiler | Compiler rejects unless cast explicitly |
| **Memory Flow** | Small container $\rightarrow$ Big container | Big container $\rightarrow$ Small container |

---

## 🧮 6. Type Promotion in Expressions

When evaluating arithmetic expressions involving multiple mixed data types, Java automatically **promotes** smaller types according to these rules:

1. **Byte / Short / Char Rule**: All `byte`, `short`, and `char` operands are automatically promoted to `int` before any operation.
2. **Dominant Type Rule**: If any operand is `double`, the whole expression is promoted to `double`.
   - Else if any operand is `float`, expression is promoted to `float`.
   - Else if any operand is `long`, expression is promoted to `long`.
   - Else, the expression evaluates to `int`.

```
                ┌────────────────────────────────┐
                │   Is any operand double? ──► double
                │   Is any operand float?  ──► float
                │   Is any operand long?   ──► long
                │   Otherwise              ──► int
                └────────────────────────────────┘
```

### 💻 Code Examples of Type Promotion:

```java
// Rule 1: byte + byte promotes to int!
byte a = 40;
byte b = 50;
// byte c = a + b; // ❌ Compile-time ERROR: (a + b) produces int
byte c = (byte) (a + b); // ✅ Correct: Explicitly cast back to byte

// Rule 2: Dominant type promotion
int count = 5;
double price = 12.5;
double total = count * price; // count (int) promoted to double -> 62.5
```

---

## 🔤 7. Character and ASCII / Unicode Casting

Since `char` is stored internally as a 16-bit unsigned integer (Unicode/ASCII code), conversions between `char` and numeric types are very common in DSA.

```java
// char to int (Widening / ASCII value)
char ch = 'A';
int asciiVal = ch; // Implicit conversion
System.out.println(asciiVal); // Output: 65

// int to char (Narrowing / ASCII to Character)
int code = 97;
char letter = (char) code; // Explicit conversion required
System.out.println(letter); // Output: 'a'

// Character math (e.g. converting '3' to integer 3)
char digitChar = '5';
int digit = digitChar - '0'; // '5' (53) - '0' (48) = 5
System.out.println(digit);   // Output: 5
```

---

## 💥 8. Overflow & Underflow in Narrowing Casting

When a number exceeds the range of the target type during explicit casting, Java uses **Two's Complement bit truncation (wrapping)**.

### 🔬 How Byte Overflow Works:
`byte` range is `[-128, 127]`. What happens when you cast `130` to `byte`?

$$\text{Formula: } \text{Result} = \text{Value} - 256 \quad (\text{for byte range wraparound})$$
$$130 - 256 = -126$$

```java
int largeNumber = 130;
byte b = (byte) largeNumber;
System.out.println(b); // Output: -126 (Wrapped around!)
```

---

## 🔄 9. Casting vs Parsing (String Conversion)

> [!WARNING]
> **Type casting is NOT String parsing.**
> You cannot cast a `String` to an `int` using `(int) "123"`!

| Task | Incorrect (Cannot Cast) | Correct Utility Method |
| :--- | :--- | :--- |
| **String to int** | `int x = (int) "123";` ❌ | `int x = Integer.parseInt("123");` ✅ |
| **String to double** | `double d = (double) "12.34";` ❌ | `double d = Double.parseDouble("12.34");` ✅ |
| **int to String** | `String s = (String) 123;` ❌ | `String s = String.valueOf(123);` or `Integer.toString(123);` ✅ |

---

## 🏁 10. Key Takeaways

1. **Widening (Implicit)**: Smaller type $\rightarrow$ Larger type. Completely automatic and lossless.
2. **Narrowing (Explicit)**: Larger type $\rightarrow$ Smaller type. Requires `(type)` syntax; can cause truncation or overflow.
3. **Expression Promotion**: `byte`, `short`, and `char` are always promoted to `int` in arithmetic expressions.
4. **Integer Division Gotcha**: In DSA, `int / int` gives integer (e.g. `5 / 2 = 2`). Use `(double) 5 / 2` to preserve decimals (`2.5`).
5. **Char Arithmetic**: `char` $\leftrightarrow$ `int` conversion allows fast ASCII indexing (`c - 'a'`) frequently used in String DSA problems.
