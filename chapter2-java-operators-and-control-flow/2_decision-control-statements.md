# 🚦 Decision Control Statements in Java

Decision control statements allow a program to **take decisions** based on conditions.  
They help control the **flow of execution** by checking conditions and running specific blocks of code.

---

## 📌 Types of Decision Control Statements

1. `if` statement
2. `if-else` statement
3. `if-else-if ladder`
4. `nested if` statement
5. `switch-case` statement

> 💡 In Java the condition **must** evaluate to a `boolean`.  
> Unlike C/C++, you cannot write `if (5)` or `if (ptr)` — it is a compile error.  
> This also means the classic `if (x = 5)` typo is caught by the compiler (`int` is not `boolean`).

---

## 1️⃣ if Statement

👉 Executes a block only if the condition is **true**.

### Syntax:
```java
if (condition)
{
    // code to execute if condition is true
}
```

### Example:
```java
int marks = 75;
if (marks >= 40)
{
    System.out.println("Passed");
}
```

> ⚠️ **Braces are optional for a single statement — and that is exactly the danger:**
> ```java
> if (marks >= 40)
>     System.out.println("Passed");
>     System.out.println("Congratulations");   // ❌ ALWAYS runs — not part of the if!
> ```
> Indentation means nothing to the compiler. **Always use braces.**

---

## 2️⃣ if-else Statement

👉 Provides an alternative block if the condition is false.

### Syntax:
```java
if (condition)
{
    // code if true
}
else
{
    // code if false
}
```

### Example:
```java
int number = 7;
if (number % 2 == 0)
{
    System.out.println("Even");
}
else
{
    System.out.println("Odd");     // prints this
}
```

---

## 3️⃣ if-else-if Ladder

👉 Used when there are multiple conditions to check.

### Syntax:
```java
if (condition1)
{
    // code if condition1 is true
} 
else if (condition2)
{
    // code if condition2 is true
}
else if (condition3)
{
    // code if condition3 is true
}
else
{
    // code if none of the conditions are true
}
```

### Example:
```java
int marks = 82;

if (marks >= 90)      System.out.println("Grade A");
else if (marks >= 75) System.out.println("Grade B");   // ✅ matches, ladder STOPS here
else if (marks >= 60) System.out.println("Grade C");
else                  System.out.println("Fail");
```

> ⚠️ **Order matters.** The ladder stops at the **first** true condition.  
> If you write the loosest condition first (`marks >= 60` at the top), every passing student
> gets a "C" and the later branches never get a chance to run.

---

## 4️⃣ Nested if Statement

👉 An if inside another if.

### Syntax:
```java
if (condition1)
{
    if (condition2)
    {
        // code if both conditions are true
    }
}
```

### Example:
```java
if (age >= 18)
{
    if (hasLicense)
    {
        System.out.println("Allowed to drive");
    }
}
```

> 💡 A nested `if` with no `else` can usually be flattened with `&&`:  
> `if (age >= 18 && hasLicense) { ... }` — shorter and easier to read.

> ⚠️ **The "dangling else" problem:** an `else` always binds to the **nearest unmatched `if`**,
> no matter how the code is indented.
> ```java
> if (a > 0)
>     if (b > 0)
>         System.out.println("both positive");
> else                                          // ← binds to `if (b > 0)`, NOT `if (a > 0)`
>     System.out.println("misleading!");
> ```
> Braces remove all ambiguity.

---

## 5️⃣ switch-case Statement

👉 Allows selection among multiple options, cleaner than many if-else-if.

### ✅ Allowed selector types

| Category | Types |
|----------|-------|
| Primitives | `byte`, `short`, `char`, `int` |
| Wrappers | `Byte`, `Short`, `Character`, `Integer` (auto-unboxed) |
| Others | `String` (Java 7+), `enum` |

⚠️ **Note:**  
Switch cases **cannot** be used with `float`, `double`, `boolean`, and `long`.
- `float` and `double` → precision issues.
- `boolean` → only two values (`true`/`false`), better handled with `if-else`.
- `long` → not supported, as `switch` case labels must fit into the `int` range.

> ⚠️ A `null` selector throws a **`NullPointerException`** in a classic switch
> (e.g. `switch (someString)` where the String is `null`). Guard for null first.

> 💡 `switch` on a `String` is **case-sensitive** — `"Monday"` does not match `case "monday"`.

> 💡 `case` labels must be **compile-time constants** (literals or `final` constants) and must be **unique**.

### Syntax:
```java
switch (variable) {
    case value1:
        // code for value1
        break;
    case value2:
        // code for value2
        break;
    ...
    default:
        // code if none match
}
```

### ⬇️ Fall-through — the #1 switch bug

If you forget `break`, execution **falls through** into the following cases:

```java
int day = 2;
switch (day) {
    case 1: System.out.println("Mon");
    case 2: System.out.println("Tue");   // ← match starts here
    case 3: System.out.println("Wed");
    default: System.out.println("Other");
}
// Output: Tue  Wed  Other   ❌ not just "Tue"
```

> 💡 Fall-through is sometimes **intentional** — stacking labels that share a body:
> ```java
> switch (ch) {
>     case 'a': case 'e': case 'i': case 'o': case 'u':
>         System.out.println("Vowel");
>         break;
>     default:
>         System.out.println("Consonant");
> }
> ```

> ⚠️ `default` does not have to be last, and it runs **only** when nothing else matched —
> but if it is placed in the middle without a `break`, fall-through applies to it too.

---

## 6️⃣ Modern Switch (Java 14+)

The **arrow form** removes fall-through entirely — only the matched branch runs, no `break` needed:

```java
switch (day) {
    case 1, 7 -> System.out.println("Weekend");
    case 2, 3, 4, 5, 6 -> System.out.println("Weekday");
    default -> System.out.println("Invalid");
}
```

**Switch expressions** go further — the whole `switch` produces a **value**:

```java
String type = switch (day) {
    case 1, 7 -> "Weekend";
    case 2, 3, 4, 5, 6 -> "Weekday";
    default -> "Invalid";
};
```

Use `yield` when a branch needs a multi-statement block:

```java
int size = switch (fruit) {
    case "apple" -> 1;
    case "watermelon" -> {
        System.out.println("that's a big one");
        yield 10;                       // yield returns the block's value
    }
    default -> 0;
};
```

| | Classic `switch` statement | `switch` expression (Java 14+) |
|---|---|---|
| Syntax | `case x:` | `case x ->` |
| Fall-through | Yes (needs `break`) | No |
| Produces a value | No | Yes |
| `default` required | No | Yes, unless all enum cases are covered (**exhaustive**) |

> 💡 **Java 16+** also added *pattern matching for `instanceof`*, which removes the manual cast:
> ```java
> if (obj instanceof String s && s.length() > 3) {   // s is ready to use
>     System.out.println(s.toUpperCase());
> }
> ```
> **Java 21** extends this to `switch` itself, allowing any reference type plus `case null`.

---

## 🎯 Key Points

- **if** → Single condition check
- **if-else** → Two possible outcomes
- **if-else-if** → Multiple conditions
- **nested if** → Conditions inside conditions
- **switch-case** → Efficient for multiple fixed values

---

## ✅ Key Takeaways

- The condition must be a `boolean` — Java rejects `if (5)`.
- **Always use braces**, even for one-liners (dangling `else`, silent extra statements).
- In an `if-else-if` ladder, **only the first matching branch runs** — order from strictest to loosest.
- `switch` works on `byte`/`short`/`char`/`int`, their wrappers, `String`, and `enum` — **not** `long`, `float`, `double`, `boolean`.
- Missing `break` causes **fall-through**; the arrow form (`->`) avoids it entirely.
- A `null` selector in a classic `switch` throws `NullPointerException`.
- Prefer `switch` over a long ladder when testing **one variable against fixed values**; prefer `if-else-if` for **ranges** and compound conditions.
