# 🔁 Loop Control Statements in Java

Loop control statements are used to **execute a block of code repeatedly** until a condition is met.  
They help reduce redundancy and make programs more efficient.

---

## 📌 Types of Loop Control Statements

1. `for` loop
2. `while` loop
3. `do-while` loop
4. **Enhanced for loop (for-each)**
5. **Jump statements** → `break`, `continue`

---

## 1️⃣ for Loop

👉 Executes a block repeatedly, with initialization, condition, and increment/decrement.

### Syntax:
```java
for (initialization; condition; update)
{
    // code to execute
}
```

### Example:
```java
for (int i = 1; i <= 5; i++)
{
    System.out.print(i + " ");    // 1 2 3 4 5
}
```

### Execution order

```
initialization  →  condition  →  body  →  update  →  condition  →  body  →  update  → …
     (once)         (check)                          (check)
```

The loop exits the moment the **condition is false** — the body does not run that time.

> 💡 **All three parts are optional.** `for (;;) { }` is a valid infinite loop
> (an empty condition is treated as `true`).

> 💡 Init and update accept **comma-separated** expressions:
> ```java
> for (int i = 0, j = 10; i < j; i++, j--) { ... }   // useful for two-pointer problems
> ```

> ⚠️ **Scope:** a variable declared in the init part exists **only inside the loop**.
> ```java
> for (int i = 0; i < 5; i++) { }
> System.out.println(i);   // ❌ compile error: cannot find symbol
> ```
> Declare `i` before the loop if you need its final value afterwards.

> ⚠️ **Never use floating point counters** — `for (double d = 0; d != 1.0; d += 0.1)` never
> terminates, because `0.1` cannot be represented exactly in binary.

---

## 2️⃣ while Loop

👉 Runs as long as the condition is true.

### Syntax:
```java
while (condition)
{
    // code to execute
}
```

### Example:
```java
int n = 1234, count = 0;
while (n > 0)
{
    n = n / 10;      // ← the update MUST happen inside the body
    count++;
}
System.out.println(count);   // 4 digits
```

> ⚠️ Forgetting the update statement inside the body is the most common cause of an
> **infinite loop**. In a `for` loop the update sits in the header, so it is harder to forget.

---

## 3️⃣ do-while Loop

👉 Similar to while loop, but guarantees at least one execution.

### Syntax:
```java
do
{
    // code to execute
} while (condition);
```

### Example — the classic menu / input-validation use case:
```java
int choice;
do
{
    System.out.println("1. Add  2. Delete  3. Exit");
    choice = sc.nextInt();
} while (choice != 3);       // menu shows at least once, then repeats until Exit
```

> ⚠️ The **semicolon after `while(condition)` is mandatory** in a `do-while` — leaving it out
> is a compile error. (In a normal `while`, a stray semicolon instead creates an empty body:
> `while (x < 5);` is an infinite loop.)

| | `while` | `do-while` |
|---|---|---|
| Condition checked | **Before** the body | **After** the body |
| Minimum executions | 0 | 1 |
| Called | Entry-controlled loop | Exit-controlled loop |

---

## 4️⃣ Enhanced for Loop (for-each)

👉 Used to iterate over arrays and collections.

### Syntax:
```java
for (datatype variable : array)
{
    // code using variable
}
```

### Example:
```java
int[] marks = {90, 75, 82};
for (int m : marks)
{
    System.out.println(m);
}
```

### ⚠️ What for-each **cannot** do

| Limitation | Why |
|------------|-----|
| No access to the index | The counter is hidden — use a normal `for` if you need `i` |
| Cannot modify array elements | The loop variable is a **copy**; `m = 0;` changes the copy, not `marks[i]` |
| Cannot traverse backwards or skip | Always forward, one element at a time |
| Cannot add/remove during iteration | Throws `ConcurrentModificationException` |

```java
// ❌ This does NOT change the array:
for (int m : marks) { m = m * 2; }

// ✅ Use an indexed loop instead:
for (int i = 0; i < marks.length; i++) { marks[i] = marks[i] * 2; }
```

```java
// ❌ ConcurrentModificationException
for (String s : list) { if (s.isEmpty()) list.remove(s); }

// ✅ Safe removal
list.removeIf(String::isEmpty);
```

> 💡 Under the hood, for-each compiles to an indexed loop for arrays and to an
> `Iterator` for anything implementing `Iterable`.

---

## 5️⃣ Jump Statements

### 🔹 break

👉 Exits the loop immediately.

```java
for (int i = 1; i <= 10; i++)
{
    if (i == 5) break;          // stop entirely when i hits 5
    System.out.print(i + " ");  // 1 2 3 4
}
```

### 🔹 continue

👉 Skips current iteration and moves to next.

```java
for (int i = 1; i <= 10; i++)
{
    if (i % 2 != 0) continue;   // skip odd numbers
    System.out.print(i + " ");  // 2 4 6 8 10
}
```

> ⚠️ **`continue` behaves differently in `for` vs `while`:**
> - In a `for` loop it jumps to the **update** part — the counter still advances.
> - In a `while` loop it jumps straight back to the **condition**, skipping any update
>   you wrote below it → **infinite loop**.
> ```java
> int i = 0;
> while (i < 10) {
>     if (i == 5) continue;   // ❌ i never increments again — hangs forever
>     i++;
> }
> ```

> ⚠️ **`break` only exits the innermost enclosing loop or switch.**  
> A `break` inside a `switch` that sits inside a loop breaks the **switch**, not the loop.

### 🔹 Labeled break / continue

For nested loops, a **label** lets you break out of an outer loop directly:

```java
outer:
for (int i = 0; i < 3; i++)
{
    for (int j = 0; j < 3; j++)
    {
        if (i * j > 1) break outer;      // exits BOTH loops
        if (j == 1) continue outer;      // jumps to the next i
        System.out.println(i + "," + j);
    }
}
// Output: 0,0   1,0   2,0   then `break outer` fires at i=2, j=1
```

> 💡 Handy for searching a 2-D array. Use it sparingly — deeply labeled jumps get hard to read.
> Extracting the loop into a method and using `return` is often cleaner.

### 🔹 break vs continue vs return

| Statement | Effect |
|-----------|--------|
| `break` | Exits the innermost loop / switch |
| `continue` | Skips to the next iteration of the innermost loop |
| `return` | Exits the **entire method**, loop included |

---

## 6️⃣ Nested Loops

A loop inside a loop — the inner loop completes **fully** for every single outer iteration.
This is the foundation of every pattern program in the `coding-practice/pattern_*` folders.

```java
for (int i = 1; i <= 4; i++)          // rows
{
    for (int j = 1; j <= i; j++)      // columns — depends on the current row
    {
        System.out.print("* ");
    }
    System.out.println();             // move to the next line after each row
}
```
```
* 
* * 
* * * 
* * * * 
```

> 💡 **Reading pattern problems:** the outer loop controls **rows**, the inner loop(s) control
> **what appears in that row**. Spaces and stars are usually two separate inner loops.

> ⚠️ Nested loops multiply work: two nested loops over `n` items is **O(n²)** iterations.
> Three levels is O(n³). Fine for patterns, costly for large data.

---

## 🎯 Key Points

- **for** → best when number of iterations is known
- **while** → best when condition-based looping
- **do-while** → executes at least once
- **for-each** → best for arrays & collections
- **break** → exit loop
- **continue** → skip iteration

---

## ✅ Key Takeaways

- `for` keeps init/condition/update together — hardest loop to accidentally make infinite.
- `while` is entry-controlled (may run **0** times); `do-while` is exit-controlled (runs **at least 1** time).
- A `do-while` needs a **semicolon** after its condition.
- Loop variables declared in the `for` header are **scoped to the loop**.
- `for-each` is read-only over elements: no index, no modification, no safe removal.
- `continue` inside a `while` skips your manual update → classic infinite loop.
- `break` escapes only the **innermost** loop or switch; use a **label** or `return` to go further.
- Nested loops drive pattern printing — outer = rows, inner = columns.
