# ⚙️ Chapter 2 – Operators in Java

Operators in Java are special symbols that perform operations on **variables and values**.  
They are the building blocks of expressions and help us manipulate data.

---

## 🧮 Types of Operators in Java

### 1. Arithmetic Operators
Used for basic mathematical operations:
- Addition: `+`
- Subtraction: `-`
- Multiplication: `*`
- Division: `/`
- Modulus (Remainder): `%`

```java
int a = 7, b = 2;
System.out.println(a + b);   // 9
System.out.println(a - b);   // 5
System.out.println(a * b);   // 14
System.out.println(a / b);   // 3   ← integer division, decimal part is TRUNCATED
System.out.println(a % b);   // 1
```

> ⚠️ **Integer division truncates, it does not round.** `7 / 2` is `3`, not `3.5`.  
> To get `3.5`, at least one operand must be floating point: `7 / 2.0` → `3.5`.

**Division by zero behaves differently for integers and floating point:**

| Expression   | Result                          |
|--------------|---------------------------------|
| `5 / 0`      | ❌ `ArithmeticException` at runtime |
| `5 % 0`      | ❌ `ArithmeticException` at runtime |
| `5.0 / 0`    | ✅ `Infinity`                    |
| `-5.0 / 0`   | ✅ `-Infinity`                   |
| `0.0 / 0`    | ✅ `NaN` (Not a Number)          |

> 💡 **Sign of `%` follows the dividend (left operand), not the divisor:**
> - `-7 % 3` → `-1`
> - `7 % -3` → `1`
>
> So `%` is a *remainder* operator, not a true mathematical *modulo*.

**`+` is overloaded for Strings:**
```java
System.out.println(1 + 2 + "Java");   // "3Java"  ← 1+2 done first (left to right)
System.out.println("Java" + 1 + 2);   // "Java12" ← once a String appears, rest is concatenation
```

---

### 2. Unary Operators
Operate on a single operand:
- Increment: `++`
- Decrement: `--`
- Unary plus/minus: `+` / `-`
- Logical NOT: `!`
- Bitwise Complement: `~`

**Pre vs Post increment — the classic confusion:**

| Form | Name | Meaning |
|------|------|---------|
| `++x` | Pre-increment  | Increment **first**, then use the value |
| `x++` | Post-increment | Use the **old** value, then increment |

```java
int x = 5;
System.out.println(x++);   // prints 5, x becomes 6
System.out.println(++x);   // x becomes 7, prints 7
```

> ⚠️ **Famous trap:** `int i = 5; i = i++;` leaves `i` as **5**, not 6.  
> The old value `5` is saved, `i` is incremented to `6`, then the saved `5` is assigned back — wiping out the increment.

---

### 3. Relational (Comparison) Operators
Used to compare values:
- Less than: `<`
- Less than or equal to: `<=`
- Greater than: `>`
- Greater than or equal to: `>=`
- Equal to: `==`
- Not equal to: `!=`
- Instance check: `instanceof`

> ⚠️ **`==` compares values for primitives, but compares *references* for objects.**
> ```java
> String s1 = new String("hi");
> String s2 = new String("hi");
> System.out.println(s1 == s2);        // false → different objects in heap
> System.out.println(s1.equals(s2));   // true  → same content
> ```
> Always use `.equals()` to compare object **content**.

> ⚠️ **Integer caching trap:** Java caches `Integer` objects for `-128` to `127`.
> ```java
> Integer a = 127, b = 127;
> System.out.println(a == b);   // true  → both point to the cached object
>
> Integer c = 128, d = 128;
> System.out.println(c == d);   // false → outside cache, new objects created
> ```

---

### 4. Logical Operators
Work with boolean values:
- AND: `&&`
- OR: `||`
- NOT: `!`

**Short-circuit evaluation** — `&&` and `||` may skip the right operand entirely:

| Operator | Behaviour |
|----------|-----------|
| `&&` | If left is `false`, right is **never evaluated** (result is already `false`) |
| `\|\|` | If left is `true`, right is **never evaluated** (result is already `true`) |
| `&`  | Both sides **always** evaluated (non-short-circuit) |
| `\|`  | Both sides **always** evaluated (non-short-circuit) |

```java
// Short-circuit protects against a crash:
if (arr != null && arr.length > 0) { ... }   // safe — length is only read if arr isn't null
if (arr != null & arr.length > 0)  { ... }   // ❌ NullPointerException if arr is null
```

> 💡 Watch out for side effects: in `if (a++ > 0 || b++ > 0)`, `b++` may never run.

---

### 5. Bitwise Operators
Operate on bits:
- AND: `&`
- OR: `|`
- XOR: `^`
- Complement: `~`
- Left shift: `<<`
- Right shift: `>>`
- Unsigned right shift: `>>>`

**Truth table (bit by bit):**

| a | b | `a & b` | `a \| b` | `a ^ b` |
|---|---|---------|----------|---------|
| 0 | 0 | 0 | 0 | 0 |
| 0 | 1 | 0 | 1 | 1 |
| 1 | 0 | 0 | 1 | 1 |
| 1 | 1 | 1 | 1 | 0 |

**Bitwise complement `~` — why `~5` is `-6`:**

`~x` flips every bit. Because Java stores negatives in **two's complement**, flipping all bits is
mathematically the same as `-(x + 1)`.

```
  5  = 0000 0101
 ~5  = 1111 1010  →  -6
```

**Shift operators:**

| Operator | Name | Effect |
|----------|------|--------|
| `<<`  | Left shift | Multiplies by 2ⁿ, fills right with `0` |
| `>>`  | Signed / arithmetic right shift | Divides by 2ⁿ (floor), copies the **sign bit** in from the left |
| `>>>` | Unsigned / logical right shift | Always fills with `0` from the left — result is never negative |

```java
System.out.println(8 << 2);    // 32   → 8 * 2²
System.out.println(-8 >> 2);   // -2   → sign preserved
System.out.println(-8 >>> 2);  // 1073741822 → sign bit treated as data
```

> ⚠️ **Shift distances are masked**, they do not "shift everything away":
> - For `int`, only the **lowest 5 bits** of the shift count are used (`count % 32`).
> - For `long`, only the **lowest 6 bits** are used (`count % 64`).
>
> So `1 << 33` is `1 << 1` = `2`, and `-1 >>> 32` is `-1 >>> 0` = `-1` (not `0`!).

> 💡 **Common bit tricks used in the coding practice folder:**
> - `x & 1` → checks if `x` is odd
> - `x ^ x` → always `0` (basis of XOR swapping)
> - `x & (x - 1)` → clears the lowest set bit (used in counting set bits)

---

### 6. Assignment Operators
Used to assign values to variables:
- Basic assignment: `=`
- Add and assign: `+=`
- Subtract and assign: `-=`
- Multiply and assign: `*=`
- Divide and assign: `/=`
- Modulus and assign: `%=`
- Bitwise and assign: `&=`
- Bitwise or assign: `|=`
- Bitwise xor and assign: `^=`
- Left shift and assign: `<<=`
- Right shift and assign: `>>=`
- Unsigned right shift and assign: `>>>=`

> ⚠️ **Compound assignment hides an implicit cast.** `a += b` is really `a = (T)(a + b)` where `T` is `a`'s type.
> ```java
> byte b = 10;
> b = b + 5;   // ❌ compile error: int cannot be converted to byte
> b += 5;      // ✅ compiles — the cast back to byte is inserted automatically
>
> byte small = 127;
> small += 1;  // ✅ compiles, but silently OVERFLOWS to -128
> ```
> This is convenient, but it can silently lose data — worth remembering in interviews.

---

### 7. Ternary Operator
- Conditional: `? :`  
  Acts as a shorthand for `if-else`.

```java
int a = 10, b = 20;
int max = (a > b) ? a : b;    // 20
```

> 💡 Unlike `if-else`, the ternary is an **expression** — it produces a value, so it can be used
> directly inside an assignment, a `return`, or a method argument.

> ⚠️ **Numeric promotion trap:** both branches get promoted to a common type.
> ```java
> Object o = true ? Integer.valueOf(1) : Double.valueOf(2.0);
> System.out.println(o);   // 1.0  ← not 1! The Integer was promoted to double
> ```

> 🧹 Nested ternaries (`a ? b : c ? d : e`) are legal but hurt readability — prefer `if-else-if`.

---

## 🏗️ Operator Precedence in Java

When multiple operators appear in an expression, **precedence** determines the order of evaluation.  
Operators with **higher precedence** are evaluated first. If precedence is the same, **associativity** decides direction.

---

### 📊 Precedence Table

| Precedence (High → Low) | Operators | Associativity |
|--------------------------|-----------|---------------|
| 1 | `()` `[]` `.` `expr++` `expr--` (postfix) | Left to Right |
| 2 | `++expr` `--expr` `+` `-` (unary) `!` `~` `(cast)` `new` | Right to Left |
| 3 | `*  /  %` | Left to Right |
| 4 | `+  -` | Left to Right |
| 5 | `<<  >>  >>>` | Left to Right |
| 6 | `<  <=  >  >=  instanceof` | Left to Right |
| 7 | `==  !=` | Left to Right |
| 8 | `&` | Left to Right |
| 9 | `^` | Left to Right |
| 10 | `|` | Left to Right |
| 11 | `&&` | Left to Right |
| 12 | `||` | Left to Right |
| 13 | `?:` | Right to Left |
| 14 | `=  +=  -=  *=  /=  %=  &=  ^=  |=  <<=  >>=  >>>=` | Right to Left |
| 15 | `->` (lambda) | Right to Left |

> ⚠️ **Postfix `x++` binds tighter than prefix `++x`** — that is why they sit on different rows above.

---

### 🔍 Precedence vs Evaluation Order

These are **two different things**, and mixing them up is a common mistake:

- **Precedence** decides how the expression is *grouped* (which operator gets which operands).
- **Evaluation order** decides which operand is *computed first*.

Java always evaluates operands **strictly left to right**, regardless of precedence:

```java
int i = 1;
int r = i + i++ * 2;   // grouping: i + ((i++) * 2)
                       // evaluation: left i read as 1, then i++ yields 1 (i→2)
                       // r = 1 + (1 * 2) = 3
```

> 💡 This is a guarantee in Java (unlike C/C++, where such expressions are undefined behaviour).
> Still — don't write code like this. Use parentheses and separate statements.

---

✅ **Key Takeaways:**
- Parentheses `()` always have the highest precedence.
- Unary operators (`++`, `--`, `!`, `~`) come before arithmetic operators.
- Relational operators (`<`, `>`, `instanceof`) are evaluated before equality (`==`, `!=`).
- Logical operators (`&&`, `||`) come after bitwise operators.
- Assignment has the lowest precedence.
- Integer division **truncates**; `/` by zero throws for `int` but gives `Infinity`/`NaN` for `double`.
- `&&` and `||` **short-circuit**; `&` and `|` do not.
- `==` compares **references** for objects — use `.equals()` for content.
- Compound assignment (`+=`) silently inserts a **narrowing cast**.
- `>>` preserves the sign; `>>>` does not.

---
