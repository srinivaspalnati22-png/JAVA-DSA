# 🔁 10. Loops in Java

---

## 📌 1. What Are Loops?

**Loops** allow you to execute a block of code repeatedly until a specified termination condition becomes `false` — automating repetitive tasks so you **never have to write the same code twice**.

$$\text{Initial State} \longrightarrow \left[ \;\text{Condition True?} \xrightarrow{\text{Yes}} \text{Execute Body} \xrightarrow{\quad} \text{Update Step} \;\right] \xrightarrow{\text{No}} \text{Exit Loop}$$

---

## 🎯 2. Why Do We Need Loops?

Without loops, performing repetitive computations would require copying and pasting code hundreds or thousands of times:

```
┌────────────────────────────────────────────────────────────────────────┐
│                          WHY WE NEED LOOPS                             │
├────────────────────┬────────────────────┬──────────────────────────────┤
│ 🔢 Print 1 to 100  │ 🔔 Notify 1K Users │ 📊 Sum an Array              │
│ One 3-line loop    │ Iterate through a  │ Visit every element          │
│ replaces 100 lines │ user list and send │ and accumulate total         │
│ of manual code     │ alerts cleanly     │ running sum                  │
├────────────────────┴────────────────────┴──────────────────────────────┤
│ 👥 Process a Classroom: Handle thousands of student records seamlessly │
│    without manual repetition.                                          │
└────────────────────────────────────────────────────────────────────────┘
```

---

## 1️⃣ 3. The `for` Loop

Use a **`for` loop** when you **know in advance exactly how many times** the block of code needs to repeat. It bundles initialization, condition check, and increment/decrement into a single line.

```
       for ( int i = 1 ;    i <= 5 ;       i++ )
             ─────────    ──────────     ──────
                 │            │             │
                 ▼            ▼             ▼
             1. START      2. TEST       3. STEP
           (Runs once)   (Each cycle)  (After body)
```

### 💻 Code Example:
```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
// Output: 1 2 3 4 5
```

### ⚙️ Step-by-Step Execution Lifecycle:
1. **Initialization (`int i = 1`)**: Sets up the loop counter variable. Executes only once at the start.
2. **Condition Check (`i <= 5`)**: Evaluated before every iteration. If `true`, body executes; if `false`, loop terminates.
3. **Loop Body**: Executes the code inside `{ }`.
4. **Update (`i++`)**: Increments or decrements the counter. Loop jumps back to Step 2.

---

## 2️⃣ 4. The `while` Loop

Use a **`while` loop** when the **number of iterations is NOT known beforehand**, but you know the condition under which it should stop. It tests the condition before executing the loop body.

### 📝 Syntax:
```java
int i = 1;
while (i <= 5) {
    System.out.println(i);
    i++; // Crucial: update loop variable inside body
}
// Output: 1 2 3 4 5
```

> [!CAUTION]
> **Always update the loop variable** inside the `while` body! Forgetting the update statement (`i++`) keeps the condition permanently `true`, causing an **infinite loop**.

---

## 3️⃣ 5. The `do-while` Loop

A **`do-while` loop** is an exit-controlled loop that **guarantees the body executes at least once**, because the condition is evaluated **after** the body runs.

### 📝 Syntax:
```java
int i = 1;
do {
    System.out.println(i);
    i++;
} while (i <= 5);
// Output: 1 2 3 4 5
```

### 🌟 Key Difference:
Even if the initial condition starts as `false`, a `do-while` loop still executes the body **once** before stopping:

```java
int num = 10;
do {
    System.out.println("Runs once!"); // Output: Runs once!
} while (num < 5);
```

### 🎯 Best Use Cases:
- Interactive CLI menus (display menu $\rightarrow$ get user choice $\rightarrow$ repeat if not exit).
- Password prompts (prompt at least once $\rightarrow$ re-prompt if invalid).

---

## 4️⃣ 6. The Enhanced `for` Loop (For-Each)

Used exclusively to **traverse arrays and collections** cleanly without manual index management.

### 📝 Syntax:
```java
int[] nums = {10, 20, 30};
for (int num : nums) {
    System.out.println(num);
}
// Output: 10 20 30
```

Read `for (int num : nums)` as: *"for each `num` in `nums`"*.

### ⚖️ Advantages:
- Eliminates `ArrayIndexOutOfBoundsException` errors.
- Clean, readable syntax without loop index variables (`i`, `j`).

---

## 🛑 7. Loop Control Statements: `break` & `continue`

These keywords provide fine-grained control over execution flow inside loops:

```
┌───────────────────────────────────────┬───────────────────────────────────────┐
│        break — Exit the Loop          │       continue — Skip Iteration       │
├───────────────────────────────────────┼───────────────────────────────────────┤
│ Instantly stops the entire loop and   │ Skips the current iteration and jumps │
│ jumps immediately to the next line    │ directly to the next cycle/step.      │
│ outside the loop.                     │                                       │
│                                       │                                       │
│ for (int i = 1; i <= 10; i++) {       │ for (int i = 1; i <= 5; i++) {        │
│     if (i == 5) break;                │     if (i == 3) continue;            │
│     System.out.println(i);            │     System.out.println(i);            │
│ }                                     │ }                                     │
│ Output: 1 2 3 4                       │ Output: 1 2 4 5                       │
└───────────────────────────────────────┴───────────────────────────────────────┘
```

---

## 🧭 8. Which Loop Should You Use?

| Loop Type | Best Use Case | Concrete Example |
| :--- | :--- | :--- |
| **`for`** | Known / fixed number of iterations | Print numbers from 1 to 100, binary search index ranges |
| **`while`** | Repetition based on a condition (unknown count) | Keep dividing a number until `n == 0`, read stream till EOF |
| **`do-while`** | Must run at least once before checking condition | User input prompt, Interactive game menu |
| **`for-each`** | Read-only iteration through arrays / collections | Calculate sum of all elements in an array or list |

---

## ⚠️ 9. Infinite Loops & Best Practices

An **infinite loop** is a loop that never terminates because its condition never becomes `false`.

```java
// ⚠️ Dangerous: Infinite Loop!
while (true) {
    System.out.println("Hello"); // Freezes program & exhausts CPU
}
```

### ✅ Best Practices:
1. **Always ensure termination**: Verify that the condition will eventually evaluate to `false` or reach a guaranteed `break`.
2. **Update loop variables properly**: Make sure the loop variable steps toward the exit condition.
3. **Use meaningful counter names**: Use descriptive names (`index`, `row`, `col`, `studentCount`) instead of obscure single letters when nesting.
4. **Avoid redundant nested loops**: Keep time complexity in check ($\mathcal{O}(n^2) \rightarrow \mathcal{O}(n)$).
5. **Pick the cleanest loop construct**: Use `for-each` for arrays and collections whenever indices are not needed.

---

## 🏁 10. Key Takeaways

1. **Automate Repetition**: Loops replace repetitive code with clean, concise constructs.
2. **Four Loop Types**: `for` (fixed count), `while` (condition-based), `do-while` (at least once), `for-each` (arrays/collections).
3. **Control Flow**: `break` terminates the loop; `continue` skips to the next iteration.
4. **Write Safe Loops**: Always ensure loop counters progress correctly to prevent infinite execution.
