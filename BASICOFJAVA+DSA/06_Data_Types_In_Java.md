# 📊 06. Introduction to Data Types in Java

---

## 📌 1. What is a Data Type?

A **Data Type** tells Java what kind of data a variable can store — a number, a character, a decimal, or a `true`/`false` boolean value. It strictly determines:
1. **Memory Allocation**: How many bytes are reserved in RAM.
2. **Valid Operations**: What operations (addition, string concatenation, logical comparisons) can be performed on the value.
3. **Range of Values**: The minimum and maximum possible values the variable can hold.

```
                  ┌──────────────────────────────┐
                  │          DATA TYPE           │
                  └──────────────┬───────────────┘
                                 │
         ┌───────────────────────┼───────────────────────┐
         ▼                       ▼                       ▼
┌─────────────────┐     ┌─────────────────┐     ┌─────────────────┐
│ Memory Reserved │     │ Range of Values │     │ Valid Operation │
│ (e.g., 4 Bytes) │     │ (-2^31 to 2^31-1)│     │ (+, -, *, /, %) │
└─────────────────┘     └─────────────────┘     └─────────────────┘
```

### 💻 Code Example:
```java
int age = 22;
double salary = 50000.50;
char grade = 'A';
boolean isPassed = true;
```

> [!NOTE]
> Each variable is declared with a specific data type before its identifier name, instructing the Java compiler on how to interpret and handle the underlying binary bits.

---

## 🎯 2. Why Do Data Types Matter?

Java is a **statically typed** and **strongly typed** language. Understanding data types is critical for 4 core reasons:

```
┌─────────────────────────────────────────────────────────────────────────┐
│                          WHY DATA TYPES MATTER                          │
├────────────────────┬────────────────────┬───────────────────────────────┤
│ 🧠 Memory          │ ⚡ Better           │ 🛡️ Type                       │
│    Optimization    │    Performance     │    Safety                     │
│ Uses only needed   │ Compile-time type  │ Catches mismatches early,     │
│ bytes (byte=1B vs  │ knowledge enables  │ preventing runtime bugs       │
│ long=8B)           │ optimized bytecode │ before code executes          │
├────────────────────┴────────────────────┴───────────────────────────────┤
│ 📋 Easy Data Management: Clear types make code readable, maintainable,   │
│    and self-documenting.                                                │
└─────────────────────────────────────────────────────────────────────────┘
```

---

## 🏷️ 3. Classification of Java Data Types

Java categorizes all data types into two primary families: **Primitive Types** and **Non-Primitive (Reference) Types**.

```
                              Java Data Types
                                     │
         ┌───────────────────────────┴───────────────────────────┐
         ▼                                                       ▼
   Primitive Types (8)                                Non-Primitive Types (Reference)
   • Stores actual value in memory                     • Stores memory address (heap reference)
   • Fixed size, no methods                            • Dynamic size, rich methods
   • Stored in Stack memory                            • Object in Heap, reference in Stack
   • Cannot be null                                    • Can be null
         │                                                       │
   ┌─────┴──────────────┐                              ┌─────────┴─────────┐
   │                    │                              │                   │
Numeric              Non-Numeric                     String              Array
├── Integral         ├── Character (`char`)          Class               Object
│   ├── `byte` (1B)  └── Logical (`boolean`)         Interface           Enum
│   ├── `short` (2B)
│   ├── `int` (4B)
│   └── `long` (8B)
└── Floating-Point
    ├── `float` (4B)
    └── `double` (8B)
```

### ⚖️ Primitives vs Non-Primitives Comparison:

| Feature | Primitive Types | Non-Primitive (Reference) Types |
| :--- | :--- | :--- |
| **Storage** | Stores actual value directly in Stack memory | Stores reference (memory address) pointing to Heap object |
| **Methods** | No methods or properties available | Provides rich built-in methods and properties |
| **Size** | Fixed size defined by language specification | Dynamic size depending on object structure |
| **Default / Null**| Always has a default value (e.g. `0`, `false`) | Can be `null` when not referencing any object |
| **Examples** | `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean` | `String`, `int[]`, `ArrayList`, `Scanner`, `CustomClass` |

---

## 🔢 4. Integer Data Types

Java provides 4 signed integral data types to store whole numbers without decimals. Choose the smallest type that fits your data to optimize memory.

| Data Type | Size (Bytes / Bits) | Minimum Value | Maximum Value | Default Value | Example |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **`byte`** | 1 Byte (8 bits) | $-128$ ($-2^7$) | $127$ ($2^7 - 1$) | `0` | `byte age = 25;` |
| **`short`** | 2 Bytes (16 bits) | $-32,768$ ($-2^{15}$) | $32,767$ ($2^{15} - 1$) | `0` | `short year = 2026;` |
| **`int`** | 4 Bytes (32 bits) | $-2,147,483,648$ ($-2^{31}$) | $2,147,483,647$ ($2^{31} - 1$) | `0` | `int salary = 50000;` |
| **`long`** | 8 Bytes (64 bits) | $-9,223,372,036,854,775,808$ ($-2^{63}$) | $9,223,372,036,854,775,807$ ($2^{63} - 1$) | `0L` | `long mobile = 9876543210L;` |

> [!IMPORTANT]
> - Integer literals are treated as `int` by default.
> - For `long` literals exceeding `int` range, always append an `L` or `l` suffix (e.g., `9876543210L`). Use uppercase `L` for clarity.

---

## 📐 5. Understanding Integer Ranges & Two's Complement

Java uses **Two's Complement Binary Representation** for all signed integer types.

### 🧮 The Range Formula:
For any $n$-bit signed integer:
$$\text{Minimum Value} = -2^{(n - 1)}$$
$$\text{Maximum Value} = 2^{(n - 1)} - 1$$

### ❓ Why is the range asymmetric?
In an $n$-bit binary representation:
- **1 bit is reserved for the sign** ($0$ = positive, $1$ = negative).
- The remaining $(n-1)$ bits represent magnitude.
- Zero ($0$) is represented using the positive sign bit ($0000\dots0$), leaving one extra slot for the negative side. That is why the negative boundary extends one value further than the positive boundary!

```
Example for byte (8 bits -> 1 sign bit + 7 value bits):
  Min = -2^(8-1) = -2^7 = -128
  Max = 2^(8-1) - 1 = 2^7 - 1 = 127
```

---

## 💧 6. Decimal (Floating-Point) Data Types

Java provides two data types to store real numbers with fractional components:

| Data Type | Size (Bytes) | Precision (Significant Digits) | Suffix Required | Preferred Use Case |
| :--- | :--- | :--- | :--- | :--- |
| **`float`** | 4 Bytes (32 bits) | $\sim 6 - 7$ decimal digits | `f` or `F` (e.g., `85.5f`) | Graphic engines, embedded memory-critical systems |
| **`double`** | 8 Bytes (64 bits) | $\sim 15 - 16$ decimal digits | Optional `d` or `D` (default) | Standard math, scientific computations, financial estimates |

```java
float percentage = 85.5f;   // 'f' suffix is mandatory, otherwise compiler treats as double
double price = 999.99;      // double is the default literal for floating points
```

> [!TIP]
> **Prefer `double` over `float`**: `double` is the standard default for fractional calculations in Java, offering much higher precision and avoiding truncation rounding errors.

---

## 🔤 7. Character & Boolean Data Types

### 🔠 `char` (Character Type):
- **Size**: 2 Bytes (16 bits)
- **Encoding**: **UTF-16 Unicode** (can store English alphabets, special symbols, emojis, and international characters like Greek, Telugu, Hindi, Chinese, etc.).
- **Range**: `0` to `65,535` (`\u0000` to `\uffff`).
- **Syntax**: Enclosed inside **single quotes** (`' '`).
```java
char grade = 'A';
char symbol = '$';
char teluguLetter = 'అ';
```

### 🔘 `boolean` (Logical Type):
- **Size**: JVM-dependent (typically 1 byte in memory, 1 bit logically).
- **Values**: Strictly `true` or `false`.
- **Purpose**: Controls decision branches, loops, and condition evaluations.
```java
boolean isActive = true;
boolean hasError = false;
```

---

## 🎁 8. Wrapper Classes

In Java, every primitive type has a corresponding **Wrapper Class** in the `java.lang` package. Wrapper classes encapsulate primitive values into full-fledged Java objects.

| Primitive Type | Wrapper Class | Size (Bits) | Example Constants |
| :--- | :--- | :--- | :--- |
| `byte` | `Byte` | 8 | `Byte.MIN_VALUE`, `Byte.MAX_VALUE` |
| `short` | `Short` | 16 | `Short.MIN_VALUE`, `Short.MAX_VALUE` |
| `int` | `Integer` | 32 | `Integer.MIN_VALUE`, `Integer.MAX_VALUE`, `Integer.SIZE` |
| `long` | `Long` | 64 | `Long.MIN_VALUE`, `Long.MAX_VALUE` |
| `float` | `Float` | 32 | `Float.MIN_VALUE`, `Float.MAX_VALUE` |
| `double` | `Double` | 64 | `Double.MIN_VALUE`, `Double.MAX_VALUE` |
| `char` | `Character` | 16 | `Character.isDigit('5')`, `Character.toUpperCase('a')` |
| `boolean` | `Boolean` | — | `Boolean.TRUE`, `Boolean.FALSE` |

### 🛠️ Why Use Wrapper Classes?
1. **Generic Collections**: Java Collections (`ArrayList<Integer>`, `HashMap<String, Double>`) cannot store primitives; they require wrapper objects.
2. **Utility Methods**: Conversion methods like `Integer.parseInt("123")` or `Character.isLetter('A')`.
3. **Constants**: Quick access to type boundaries (`Integer.MAX_VALUE = 2147483647`).

```java
System.out.println(Integer.MIN_VALUE); // -2147483648
System.out.println(Integer.MAX_VALUE); // 2147483647
System.out.println(Integer.SIZE);      // 32 bits
```

---

## 🏁 9. Key Takeaways

1. **8 Primitive Types**: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean` — each with fixed size.
2. **Primitives Store Values Directly**: Stored in Stack memory for lightning-fast access; non-primitives store references to Heap objects.
3. **Wrapper Classes Add Object Power**: Enable primitives to work with Collections, generics, and provide essential parsing utilities.
4. **Prefer `double` Over `float`**: `double` is the default decimal type in Java and offers superior numerical precision.
