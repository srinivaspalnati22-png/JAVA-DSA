# ⚙️ 07. Java Operators

---

## 📌 1. What Are Operators?

**Operators** are special symbols that perform mathematical, relational, logical, or bitwise operations on variables and values. The values or variables on which an operator operates are called **operands**.

$$\underbrace{\text{int sum}}_{\text{Variable}} = \underbrace{\text{a}}_{\text{Operand}} \underbrace{+} _{\text{Operator}} \underbrace{\text{b}}_{\text{Operand}};$$

Operators are the core tools Java uses to manipulate data, compute expressions, and drive program logic.

---

## 🎯 2. Why Do We Need Operators?

Every Java program relies on operators to function. They power four essential computational capabilities:

```
┌────────────────────────────────────────────────────────────────────────┐
│                        WHY WE NEED OPERATORS                           │
├────────────────────┬────────────────────┬──────────────────────────────┤
│ ➕ Calculations    │ ⚖️ Comparisons      │ 📥 Assignments               │
│ Add, subtract,     │ Check if values    │ Store and update values      │
│ multiply, divide,  │ are equal, smaller,│ inside variables             │
│ and modulus math   │ or greater         │ cleanly & efficiently        │
├────────────────────┴────────────────────┴──────────────────────────────┤
│ 🔀 Decisions: Combine conditions to control execution flow with        │
│    `if`/`else` and loops.                                              │
└────────────────────────────────────────────────────────────────────────┘
```

---

## ➕ 3. Arithmetic Operators

Used to perform fundamental mathematical calculations on numeric operands.

| Operator | Name | Description | Example ($a=10, b=3$) | Result |
| :---: | :--- | :--- | :--- | :--- |
| **`+`** | Addition | Adds two operands | `a + b` | `13` |
| **`-`** | Subtraction | Subtracts right operand from left | `a - b` | `7` |
| **`*`** | Multiplication | Multiplies two operands | `a * b` | `30` |
| **`/`** | Division | Divides left operand by right operand (Truncates fraction for integers) | `a / b` | `3` (Integer Division) |
| **`%`** | Modulus | Returns remainder of division | `a % b` | `1` ($10 = 3 \times 3 + \mathbf{1}$) |

### 💻 Code Example:
```java
int a = 10, b = 3;
System.out.println(a + b); // 13
System.out.println(a - b); // 7
System.out.println(a * b); // 30
System.out.println(a / b); // 3
System.out.println(a % b); // 1
```

> [!TIP]
> To get precise decimal division in Java, make at least one operand floating-point: `(double) a / b` $\rightarrow 3.3333333333333335$.

---

## 📥 4. Assignment Operators

Used to assign and update values stored inside variables. Compound assignment operators provide shorthand syntax for frequent update patterns.

| Operator | Example | Equivalent Expansion | Description |
| :---: | :--- | :--- | :--- |
| **`=`** | `a = 10` | `a = 10` | Assigns right-side value to left-side variable |
| **`+=`** | `a += 5` | `a = a + 5` | Adds and assigns result |
| **`-=`** | `a -= 2` | `a = a - 2` | Subtracts and assigns result |
| **`*=`** | `a *= 3` | `a = a * 3` | Multiplies and assigns result |
| **`/=`** | `a /= 4` | `a = a / 4` | Divides and assigns result |
| **`%=`** | `a %= 3` | `a = a % 3` | Computes modulus and assigns remainder |

---

## ⚖️ 5. Comparison (Relational) Operators

Relational operators compare two values and **always return a `boolean` result** (`true` or `false`). They drive decision making in `if` statements and loops.

| Operator | Meaning | Example ($a=10, b=20$) | Boolean Result |
| :---: | :--- | :--- | :---: |
| **`==`** | Equal to | `a == b` | `false` |
| **`!=`** | Not equal to | `a != b` | `true` |
| **`>`** | Greater than | `a > b` | `false` |
| **`<`** | Less than | `a < b` | `true` |
| **`>=`** | Greater than or equal to | `a >= b` | `false` |
| **`<=`** | Less than or equal to | `a <= b` | `true` |

### 💻 Code Example:
```java
int a = 10, b = 20;
System.out.println(a == b); // false
System.out.println(a != b); // true
System.out.println(a < b);  // true
System.out.println(a >= b); // false
```

---

## 🔀 6. Logical Operators

Used to combine multiple boolean conditions. Essential for building complex decision trees in your programs.

| Operator | Name | Logic Rule | Syntax Example |
| :---: | :--- | :--- | :--- |
| **`&&`** | Logical AND | Returns `true` **only if BOTH** conditions are true. | `(age >= 18 && hasID == true)` |
| **`\|\|`** | Logical OR | Returns `true` if **AT LEAST ONE** condition is true. | `(age < 18 \|\| hasID == true)` |
| **`!`** | Logical NOT | **Inverts / Reverses** the boolean result (`true` $\rightarrow$ `false`). | `!hasID` |

### 📊 Truth Table:

| Condition A | Condition B | `A && B` (AND) | `A \|\| B` (OR) | `!A` (NOT) |
| :---: | :---: | :---: | :---: | :---: |
| `true` | `true` | **`true`** | **`true`** | `false` |
| `true` | `false` | `false` | **`true`** | `false` |
| `false` | `true` | `false` | **`true`** | `true` |
| `false` | `false` | `false` | `false` | `true` |

### 💻 Code Example:
```java
int age = 22;
boolean hasID = true;

// AND: both must be true
System.out.println(age >= 18 && hasID); // Output: true

// OR: at least one must be true
System.out.println(age < 18 || hasID);  // Output: true

// NOT: inverts the result
System.out.println(!hasID);              // Output: false
```

> [!NOTE]
> **Short-Circuit Evaluation**:
> - In `A && B`, if `A` is `false`, Java does NOT evaluate `B` (result is already guaranteed `false`).
> - In `A || B`, if `A` is `true`, Java does NOT evaluate `B` (result is already guaranteed `true`).

---

## 📋 7. All Operators at a Glance

| Category | Operators | Purpose | Example |
| :--- | :--- | :--- | :--- |
| **Arithmetic** | `+`, `-`, `*`, `/`, `%` | Mathematical calculations | `int sum = 10 + 5;` |
| **Assignment** | `=`, `+=`, `-=`, `*=`, `/=`, `%=` | Store and update variables | `count += 1;` |
| **Comparison** | `==`, `!=`, `>`, `<`, `>=`, `<=` | Evaluate relational conditions | `if (score >= 90)` |
| **Logical** | `&&`, `\|\|`, `!` | Combine multiple boolean rules | `if (isAdult && hasTicket)` |

---

## 🏁 8. Key Takeaways

1. **Operators are the Foundation**: Every calculation, condition check, and value update in Java is performed via operators.
2. **Four Essential Types**: Arithmetic (math) $\rightarrow$ Assignment (storage) $\rightarrow$ Comparison (checks) $\rightarrow$ Logical (combined rules).
3. **Comparison Returns Booleans**: Comparisons always yield `true` or `false`, driving all branches and loops.
4. **Next**: Conditionals & Loops rely directly on operator outputs to make dynamic runtime decisions.
