# 🔁 Recursion in Java

A **recursive method** is a method that **calls itself** to solve a smaller version of the same
problem, until the problem becomes small enough to answer directly.

> 🧠 **The mental model:** *"I don't know the answer for `n`, but if someone hands me the answer
> for `n-1`, I can finish the job in one step."* That someone is the method itself.

Recursion fits problems with a **self-similar structure**: factorial, Fibonacci, digit-by-digit
maths, tree/graph traversal, folder scanning, divide-and-conquer sorting.

---

## 🧱 The Two Mandatory Parts

Every correct recursive method has both:

| Part | Job | Missing it means |
|------|-----|------------------|
| **Base case** | The smallest input, answered **without** recursing | Infinite recursion → `StackOverflowError` |
| **Recursive case** | Calls itself with an input **closer to the base case** | Infinite recursion → `StackOverflowError` |

```java
public class RecursionExample {
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;                      // 1️⃣ base case — stops the chain
        } else {
            return n * factorial(n - 1);   // 2️⃣ recursive case — n shrinks toward the base
        }
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 5 = " + factorial(5));   // 120
    }
}
```

> ⚠️ A base case alone is not enough — the recursive call **must make progress**.
> `return n * factorial(n)` has a perfectly good base case and still never reaches it.

---

## 🔬 Tracing `factorial(5)` — Wind Down, Then Unwind

Recursion has **two phases**: calls go *down* stacking up unfinished work, then values come *back
up* as each frame finishes.

```text
WINDING (each call waits)              UNWINDING (values return)
factorial(5) → 5 * factorial(4)        ← 5 * 24 = 120   ✅ final answer
  factorial(4) → 4 * factorial(3)      ← 4 * 6  = 24
    factorial(3) → 3 * factorial(2)    ← 3 * 2  = 6
      factorial(2) → 2 * factorial(1)  ← 2 * 1  = 2
        factorial(1) → returns 1  🛑 base case reached
```

The call stack at its deepest point:

```text
   ┌────────────────────┐  ← top
   │ factorial(1)  n=1  │
   ├────────────────────┤
   │ factorial(2)  n=2  │
   ├────────────────────┤
   │ factorial(3)  n=3  │
   ├────────────────────┤
   │ factorial(4)  n=4  │
   ├────────────────────┤
   │ factorial(5)  n=5  │
   ├────────────────────┤
   │ main()             │
   └────────────────────┘  ← bottom
```

> 💡 Each frame has its **own `n`** — that's pass-by-value again (`1_methods.md`). The five `n`s
> never interfere with each other, which is exactly why recursion works.

> ⚠️ Nothing after the recursive call runs until that call returns. `System.out.println` placed
> *after* `factorial(n-1)` prints in **reverse** order — a classic exam question.

---

## 🧩 The Patterns in Your Practice Files

### 1️⃣ Sum of digits — peel one digit per call
```java
public static int sumOfDigits(int number) {
    if (number == 0) return 0;                          // base
    return number % 10 + sumOfDigits(number / 10);      // last digit + rest
}
// 1234 → 4 + (3 + (2 + (1 + 0))) = 10
```

### 2️⃣ Power — multiply one factor per call
```java
public static int powerOfNumber(int number, int power) {
    if (power == 0) return 1;                           // base: anything^0 = 1
    return number * powerOfNumber(number, power - 1);   // shrink the EXPONENT
}
```
> ⚠️ Note it's the **exponent** that shrinks, not the base. In `PowRecursion.java` the extra
> `|| number == 1` check is harmless (1^n is 1) but not needed. What *is* missing is a guard for a
> **negative exponent** — `power = -2` never reaches `0` and blows the stack. Add
> `if (power < 0) throw new IllegalArgumentException("power must be >= 0");`

### 3️⃣ Fibonacci — two recursive calls per level
```java
public static int fibonacci(int n) {
    if (n == 0) return 0;                               // base 1
    if (n == 1) return 1;                               // base 2
    return fibonacci(n - 1) + fibonacci(n - 2);         // two branches
}
```

> 💡 Some problems need **more than one base case**. Fibonacci needs two, because the recursive
> case reaches back two steps and would otherwise skip over `n == 0`.

---

## 📉 The Cost of Naive Fibonacci

`fibonacci(5)` re-computes the same values over and over:

```text
                    fib(5)
             ┌────────┴────────┐
          fib(4)             fib(3)      ← fib(3) computed twice
        ┌────┴────┐        ┌────┴────┐
     fib(3)     fib(2)  fib(2)     fib(1)   ← fib(2) computed three times
```

| n | Total calls made | Rough time |
|---|------------------|-----------|
| 5 | 15 | instant |
| 20 | ~21,900 | instant |
| 40 | ~331 million | seconds |
| 50 | ~40 billion | minutes |

That is **O(2ⁿ)** — exponential. The fix is **memoization**: remember answers you already computed.

```java
static long[] memo = new long[100];

static long fib(int n) {
    if (n <= 1) return n;
    if (memo[n] != 0) return memo[n];            // already solved → reuse
    return memo[n] = fib(n - 1) + fib(n - 2);    // solve once, store
}
```
One cached array turns **O(2ⁿ) into O(n)**. `fib(50)` now returns instantly.

> 💡 In `FibonacciRecursion.java` the loop calls `fibonacci(i)` for every `i` — so the whole
> program is exponential *twice over*. Great for learning the mechanics, terrible for `n > 40`.

---

## 💥 `StackOverflowError`

Every call consumes a stack frame, and the stack is finite (typically ~512 KB–1 MB → roughly
**10,000–20,000 frames** deep for simple methods).

```java
static void boom(int n) {
    System.out.println(n);
    boom(n + 1);        // no base case, and n grows away from any base
}
// Exception in thread "main" java.lang.StackOverflowError
```

| | Infinite **loop** | Infinite **recursion** |
|---|---|---|
| Symptom | Program hangs forever | Crashes fast with `StackOverflowError` |
| Memory | Constant | Grows with every call |

> 💡 `StackOverflowError` is an **`Error`**, not an `Exception` — you don't catch it, you fix the
> base case (Chapter 7).

> ⚠️ Even a *correct* recursion can overflow: `sumOfDigits` is safe (max ~10 levels), but a
> recursive `sum(1..n)` with `n = 100000` will crash. **Depth matters, not correctness.**

---

## 🧨 Two Silent Bugs to Watch For

**1. Integer overflow in `factorial`** — the recursion is fine, the type isn't:

| n | `factorial(n)` as `int` |
|---|-------------------------|
| 12 | `479001600` ✅ (int max is 2,147,483,647) |
| 13 | `1932053504` ❌ wrong — the real 13! is 6,227,020,800; it silently wrapped around |
| 34 | `0` ❌ — enough factors of 2 accumulate to wipe out every bit |

Switching to `long` only buys you more room: **20!** is the last one that fits, and **21!** comes
back **negative**. Beyond that use `BigInteger`. Java **never warns** about integer overflow.

**2. Negative / unvalidated input** — `factorial(-3)` skips both base cases (`-3 → -4 → -5 …`) and
overflows the stack. Validate at the entry point:

```java
public static int factorial(int n) {
    if (n < 0) throw new IllegalArgumentException("n must be >= 0");
    return (n <= 1) ? 1 : n * factorial(n - 1);
}
```

---

## 🔀 Types of Recursion

| Type | Description | Example |
|------|-------------|---------|
| **Direct** | A method calls itself | `factorial()` |
| **Indirect (mutual)** | A calls B, B calls A | `isEven(n)` ↔ `isOdd(n)` |
| **Tail** | The recursive call is the **very last** action | `return helper(n - 1, acc * n);` |
| **Head / non-tail** | Work still remains after the call returns | `return n * factorial(n - 1);` |
| **Tree** | More than one recursive call per level | `fibonacci()`, tree traversal |

> ⚠️ **Java does NOT optimise tail recursion.** Languages like Scala and Kotlin can turn a tail
> call into a loop; the HotSpot JVM does not (it would break stack traces). So writing a
> tail-recursive method in Java buys you style, **not** safety from `StackOverflowError`.

---

## ⚖️ Recursion vs Iteration

| | **Recursion** | **Iteration (loops)** |
|---|---|---|
| Readability for self-similar problems | ✅ Often much clearer | ❌ Can need an explicit stack |
| Memory | ❌ One stack frame **per call** | ✅ Constant |
| Speed | ❌ Call overhead per level | ✅ Faster |
| Risk | `StackOverflowError` | Infinite loop |
| Best for | Trees, graphs, backtracking, divide & conquer | Counting, accumulating, scanning arrays |

Any recursion can be rewritten as a loop (and vice-versa):

```java
// same result, constant memory, no stack risk
static long factorialIterative(int n) {
    long result = 1;
    for (int i = 2; i <= n; i++) result *= i;
    return result;
}
```

> 💡 **Practical guidance:** if a loop expresses it naturally (like `ReverseANumberMethod.java`
> does with `while`), use the loop. Reach for recursion when the *problem itself* is recursive —
> and you will feel that from Chapter 10 onward (trees, sorting, backtracking).

---

## 📝 A 3-Step Recipe for Writing Any Recursive Method

1. **Find the base case** — what is the smallest input whose answer you know instantly?
   (`n == 0`, empty string, `null` node)
2. **Assume the smaller call already works** — trust `factorial(n-1)` to be correct. Do not try to
   trace the whole thing in your head; that's what breaks people's confidence with recursion.
3. **Combine** — do the one step that turns the smaller answer into the answer for `n`
   (`n * …`, `digit + …`, `left + right`).

Then sanity-check: *does every path shrink toward the base case?*

---

## 🐞 Common Mistakes Checklist

| Mistake | Symptom |
|---------|---------|
| No base case | `StackOverflowError` |
| Base case unreachable (wrong direction / negative input) | `StackOverflowError` |
| Forgetting to `return` the recursive call | Method returns garbage or won't compile |
| Missing a second base case (Fibonacci) | Wrong result or infinite recursion |
| Using a `static` accumulator field instead of parameters | Wrong answer on the **second** call |
| Recomputing subproblems | Exponential slowness |
| Overflowing `int` | Silently wrong numbers |

---

## 🎯 Key Takeaways

- Recursion = a method calling itself on a **smaller** version of the same problem.
- Every recursive method needs a **base case** *and* **progress toward it** — both, always.
- Calls **wind down** stacking frames, then **unwind** returning values; code after the recursive
  call runs during the unwind (in reverse order).
- Each call has its **own copy** of the parameters — separate stack frames.
- Depth costs memory: too deep → **`StackOverflowError`** (an `Error`, not an `Exception`).
- Naive Fibonacci is **O(2ⁿ)**; **memoization** brings it down to O(n).
- Java does **not** perform tail-call optimisation.
- `factorial` overflows `int` at **13!** — use `long` (to 20!) or `BigInteger`.
- Loops are cheaper; use recursion when the **problem shape** is recursive.
- 👉 Recursion returns in force in **Chapter 10** (collections, trees, sorting).
