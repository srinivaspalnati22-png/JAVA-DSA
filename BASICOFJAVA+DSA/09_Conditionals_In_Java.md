# 🔀 09. Conditionals in Java

---

## 📌 1. What Are Conditionals?

Every smart program needs to make decisions based on changing data. **Conditionals** give your Java code the ability to **think, compare, and choose** which execution path to take — just like human decision-making in everyday life.

$$\mathbf{Condition} \xrightarrow{\quad\text{Evaluate}\quad} \begin{cases} \mathbf{true} & \implies \text{Execute Block A} \\ \mathbf{false} & \implies \text{Execute Block B / Skip} \end{cases}$$

---

## 🌍 2. Conditionals in Real Life

You already make conditional decisions daily. Programming formalizes these logic flows into syntax:

| Real Life Situation | Programming Decision | Code Logic Equivalent |
| :--- | :--- | :--- |
| 🗳️ **Voting Eligibility** | If your age is 18 or above, you can vote. | `if (age >= 18) { canVote = true; }` |
| 🌧️ **Rainy Day** | If it is raining, take an umbrella. | `if (isRaining) { takeUmbrella(); }` |
| 🎓 **Exam Grades** | If your marks are 90+, you get an A+. | `if (marks >= 90) { grade = "A+"; }` |

$$\mathbf{Conditionals} = \text{Decision Making in Programming}$$

---

## 1️⃣ 3. The Simple `if` Statement

Used when you have a **single condition** to check.

### 📝 Syntax & Mechanics:
```java
if (condition) {
    // Code runs ONLY if condition evaluates to true
}
```

```java
int age = 20;
if (age >= 18) {
    System.out.println("Eligible to Vote");
}
```

### 🔑 Key Points:
- The condition must evaluate strictly to a **`boolean` (`true` or `false`)**.
- Code inside `{ }` is executed only if `condition == true`.
- If the condition is `false`, Java skips the block entirely.

---

## 2️⃣ 4. The `if-else` Statement

When there are **exactly two mutually exclusive outcomes**, use `if-else`. One path executes for `true`, the alternative path for `false`.

```
                    ┌─────────────────┐
                    │    Condition    │
                    └────────┬────────┘
                             │
                  ┌──────────┴──────────┐
                  │ true          false │
                  ▼                     ▼
          ┌──────────────┐      ┌──────────────┐
          │   if block   │      │  else block  │
          └──────┬───────┘      └──────┬───────┘
                 └──────────┬──────────┘
                            ▼
                    Continue Program
```

### 💻 Code Example:
```java
int age = 16;
if (age >= 18) {
    System.out.println("Eligible to Vote");
} else {
    System.out.println("Not Eligible to Vote");
}
```

### 🎯 When to Use:
- Pass / Fail checks
- Yes / No decisions
- Valid / Invalid input checks
> [!IMPORTANT]
> **One of the two blocks ALWAYS runs — never both.**

---

## 🪜 5. The `else-if` Ladder

Use an `else-if` ladder when you have **multiple conditions to evaluate in sequence**. Java stops and executes the block at the **first matching condition**.

```java
int marks = 82;

if (marks >= 90) {
    System.out.println("Grade A");
} else if (marks >= 75) {
    System.out.println("Grade B"); // <-- Matches here & skips remainder
} else if (marks >= 50) {
    System.out.println("Grade C");
} else {
    System.out.println("Fail");
}
```

### 📊 Evaluation Map:
```
  [marks >= 90] ──► false ──► [marks >= 75] ──► true ──► Output: "Grade B" (Exit Ladder)
```

---

## 🪆 6. Nested `if` Statements

A **nested `if`** is an `if` statement placed **inside another `if` statement**. The inner condition only runs when the outer condition is `true`.

### 💻 Code Example:
```java
int age = 22;
boolean isCitizen = true;

if (age >= 18) {
    if (isCitizen) {
        System.out.println("Eligible to Vote in National Election");
    }
}
```

### 🎯 When to Use:
- **Dependency Checks**: When condition B only makes sense if condition A has already passed.
- ⚠️ **Caution**: Avoid deeply nested `if` statements (3+ levels) as they harm readability. Prefer combining conditions with logical `&&` or refactoring into helper methods.

---

## ❓ 7. The Ternary Operator (`?:`)

The ternary operator is a **compact, one-line expression shorthand for `if-else`**.

### 📝 Syntax:
$$\text{result} = (\text{condition}) \;\mathbf{?}\; \text{valueIfTrue} \;\mathbf{:}\; \text{valueIfFalse};$$

```java
int age = 20;
String status = (age >= 18) ? "Eligible" : "Not Eligible";
System.out.println(status); // Output: Eligible
```

```java
int a = 15, b = 25;
int max = (a > b) ? a : b; // max = 25
```

> [!TIP]
> Use the ternary operator only for simple, concise assignments. For complex logic, stick with standard `if-else` blocks for readability.

---

## 🔀 8. The `switch` Statement

Use `switch` when comparing a single variable against **multiple known fixed values (cases)**. It is cleaner, faster, and more readable than a long `else-if` chain.

```java
int day = 3;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Invalid Day");
}
```

### 🔑 Rules & Mechanics of `switch`:
1. **`break` Keyword**: Prevents "fall-through" into subsequent cases.
2. **`default` Clause**: Executes if no `case` matches (equivalent to `else`).
3. **Supported Data Types**: `byte`, `short`, `char`, `int`, `String`, and `enum`. (Floats, doubles, and booleans are NOT supported).

---

## 🧭 9. Which Conditional Should You Use?

| Statement | Best Used When... | Example Scenario |
| :--- | :--- | :--- |
| **`if`** | You have a single optional action to perform. | Display warning if battery is low. |
| **`if-else`** | There are exactly two mutually exclusive outcomes. | Check whether a number is even or odd. |
| **`else-if`** | You need to test multiple range-based conditions sequentially. | Grade calculation (90+, 75+, 50+). |
| **`nested if`** | One check strictly depends on a previous check succeeding. | Check logged-in $\rightarrow$ Check admin role. |
| **`switch`** | Comparing one variable against discrete fixed values. | Menu options, day of week, calculator commands. |
| **`?:` Ternary** | You want a concise one-liner to return or assign a value. | `int min = (a < b) ? a : b;` |

---

## 🏁 10. Key Takeaways

1. **Conditionals = Decisions**: Enable your code to branch and choose different paths dynamically.
2. **Pick the Right Construct**: `if` for single checks, `if-else` for binary branches, `else-if` for chained ranges, `switch` for discrete values.
3. **Keep Code Clean**: Avoid excessive nesting. Use ternary operator for short value assignments.
