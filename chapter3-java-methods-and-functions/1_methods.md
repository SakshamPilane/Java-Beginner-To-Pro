# 🧩 Java Methods

A **method** in Java is a **named block of statements** grouped together to perform one specific task.
It improves **readability, modularity, and reusability** of code.

> 📖 **Method vs Function:** in languages like C or Python, a standalone block of reusable code is
> called a *function*. In Java every block of code **must live inside a class**, so we call it a
> **method** ("a function that belongs to a class/object"). Same idea, different name.

Every Java application **starts its execution from the `main` method**.
- `main()` acts as the **entry point** — the JVM looks for it by name and signature.
- It controls the **flow of execution** by calling other methods.
- Those methods then distribute the work of the program.

---

## 📌 Why Use Methods?

| Reason | What it means in practice |
|--------|---------------------------|
| **Readability** | `isPrime(n)` reads better than 8 lines of loop logic inline |
| **Modularity** | Break one big task into small, independent tasks |
| **Reusability (DRY)** | Write once, call from anywhere — *Don't Repeat Yourself* |
| **Easier debugging** | A bug lives in **one** method, not copy-pasted in 5 places |
| **Testability** | A small method with a return value is easy to verify |
| **Abstraction** | The caller only needs *what* it does, not *how* it does it |

> 💡 **Rule of thumb:** if you ever copy-paste a block of code a second time, that block wants to
> be a method. If a method needs a scroll bar to read, it wants to be split.

---

## 🧱 Anatomy of a Method

```java
public static int add(int a, int b) throws Exception
//  ↑      ↑     ↑    ↑  ↑                  ↑
//  |      |     |    |  parameter list     optional throws clause
//  |      |     |    method name
//  |      |     return type
//  |      other modifier (static / final / abstract / synchronized)
//  access modifier (public / private / protected / default)
{
    return a + b;   // method body
}
```

| Part | Required? | Notes |
|------|-----------|-------|
| Access modifier | ❌ Optional | Omitted = *package-private* (visible inside the same package) |
| Other modifiers | ❌ Optional | `static`, `final`, `abstract`, `synchronized` … |
| **Return type** | ✅ **Required** | Use `void` when nothing is returned |
| **Method name** | ✅ **Required** | `camelCase`, should be a **verb**: `getArea`, `isEven`, `printBill` |
| **Parameter list** | ✅ **Required** | The `()` must be there — it may be empty |
| `throws` clause | ❌ Optional | Covered in Chapter 7 (Exception Handling) |
| Body `{ }` | ✅ Required | Except for `abstract` / `interface` methods (Chapter 6) |

---

## ✍️ Method Signature (very important)

In Java, the **signature** of a method is **only**:

> **method name + parameter types (in order)**

The **return type is NOT part of the signature.** Neither are parameter *names*.

```java
int   calc(int a, double b)   // signature → calc(int, double)
void  calc(int x, double y)   // SAME signature → ❌ compile error: method already defined
```

> ⚠️ This single rule is the reason **you cannot overload a method by changing only its return
> type**. Overloading is covered fully in `2_method-overloading.md`.

---

## 📞 Declaring vs Calling

```java
public class Demo {
    // 1️⃣ declaration (the recipe) — this code does nothing on its own
    public static int square(int n) {
        return n * n;
    }

    public static void main(String[] args) {
        // 2️⃣ call / invocation (actually cooking the recipe)
        int result = square(5);      // 5 is the ARGUMENT
        System.out.println(result);  // 25
    }
}
```

- **Parameter** = the variable in the *declaration* (`int n`) — the empty box.
- **Argument** = the actual value passed at the *call* (`5`) — what goes in the box.

---

## 🏷️ `static` vs Instance Methods

| | `static` method | Instance method |
|---|---|---|
| Belongs to | The **class** | An **object** of the class |
| Called as | `ClassName.method()` | `objectName.method()` |
| Can use `this` | ❌ No | ✅ Yes |
| Can access instance fields directly | ❌ No | ✅ Yes |
| Typical use | Utility/helper maths, `main` | Behaviour that depends on object data |

```java
public class Demo {
    int value = 10;                 // instance field

    static void staticHello()   { System.out.println("static hello"); }
    void instanceHello()        { System.out.println("value = " + value); }

    public static void main(String[] args) {
        staticHello();              // ✅ static → static, direct call is fine

        // instanceHello();         // ❌ error: non-static method cannot be
                                    //    referenced from a static context
        Demo d = new Demo();
        d.instanceHello();          // ✅ create an object first
    }
}
```

> ⚠️ **The #1 beginner error in this chapter:**
> *"Non-static method `xyz()` cannot be referenced from a static context."*
> `main` is `static`, so it runs **without any object existing yet**. It can therefore only call
> other `static` methods directly. Either mark your helper `static` (fine for Chapters 1–5), or
> create an object and call the method on it (the OOP way — Chapter 6).

> 💡 That is exactly why every practice file in `coding-practice/` writes
> `public static int findFactorial(int n)` — so `main` can call it directly.

---

## 📥 Passing Values to Methods

### Syntax
```text
returnType methodName(type1 param1, type2 param2, ...)
{
    // statements
}
```

A method can have **zero**, **one**, or **many** parameters — but each parameter needs **its own
type**:

```java
void ok(int a, int b)   { }   // ✅
// void bad(int a, b)   { }   // ❌ 'b' has no type
```

Arguments are matched **by position**, not by name:

```java
static void divide(int numerator, int denominator) { … }

divide(10, 2);   // numerator = 10, denominator = 2
divide(2, 10);   // silently different meaning — order matters!
```

> 💡 Keep the parameter count small (ideally ≤ 3). Long parameter lists of the same type are a
> magnet for argument-order bugs. Later you will group them into an object instead.

---

## 🔁 Return Types & the `return` Statement

```java
static double areaOfCircle(double r) {
    return 3.14159 * r * r;      // value must match (or widen to) the return type
}

static void printGreeting(String name) {
    System.out.println("Hello " + name);
    // no return value; `return;` alone is allowed to exit early
}
```

**Rules to remember:**

| Rule | Example |
|------|---------|
| Non-`void` methods must return on **every** path | Missing `else`-return → ❌ *missing return statement* |
| `void` methods may use `return;` to exit early | `if (x < 0) return;` |
| `void` methods may **not** return a value | `return 5;` in a `void` method → ❌ compile error |
| Return value can be **widened** automatically | `double f() { return 5; }` → `5.0` ✅ |
| Return value cannot be **narrowed** automatically | `int f() { return 5.0; }` → ❌ needs `(int)` cast |
| Code after `return` is unreachable | ❌ *unreachable statement* compile error |
| The returned value may be **ignored** by the caller | `square(5);` compiles, result thrown away |

```java
// ❌ does not compile — the compiler cannot prove a value is always returned
static int bad(int n) {
    if (n > 0) {
        return 1;
    }
    // falls off the end → "missing return statement"
}

// ✅ every path returns
static int good(int n) {
    if (n > 0) return 1;
    return -1;
}
```

> 💡 **Early return** (also called a *guard clause*) keeps code flat and readable:
> ```java
> static int divide(int a, int b) {
>     if (b == 0) return 0;    // handle the bad case first, then get on with it
>     return a / b;
> }
> ```

---

## 🎁 Java is **Always** Pass-by-Value

This is the most misunderstood topic in the whole chapter, and a guaranteed interview question.

> **Java always copies the value of the argument into the parameter.**
> For objects, the *value being copied* is the **reference** (the address), never the object itself.

### 1️⃣ Primitives — the caller's variable never changes

```java
static void increment(int n) {
    n = n + 100;                 // only the local copy changes
}

public static void main(String[] args) {
    int x = 5;
    increment(x);
    System.out.println(x);       // 5  ← unchanged!
}
```

### 2️⃣ Objects/arrays — you can change the **contents**…

```java
static void modify(int[] arr) {
    arr[0] = 99;                 // follows the copied reference to the SAME array
}

public static void main(String[] args) {
    int[] a = {1, 2, 3};
    modify(a);
    System.out.println(a[0]);    // 99  ← changed!
}
```

### 3️⃣ …but you can **not** re-point the caller's variable

```java
static void reassign(int[] arr) {
    arr = new int[]{7, 8, 9};    // the local copy now points elsewhere
    arr[0] = 100;                // affects only the new array
}

public static void main(String[] args) {
    int[] a = {1, 2, 3};
    reassign(a);
    System.out.println(a[0]);    // 1  ← untouched!
}
```

> ⚠️ **The classic swap trap** — this method looks right and does nothing:
> ```java
> static void swap(int a, int b) { int t = a; a = b; b = t; }   // useless
> ```
> Java has no reference parameters (no `&` like C++, no `ref` like C#). To "return two values",
> return an array/object, or set fields on an object.

> ⚠️ `String` is an object, but it is **immutable** — so `s.concat("x")` or `s += "x"` inside a
> method never changes the caller's string. It just creates a new one. (Chapter 5.)

---

## 🔄 Dynamic (Variable) Parameters — `varargs`

Sometimes the number of inputs is not fixed. Java's **varargs** (`...`) accepts any number of
arguments, including **zero**.

```java
public class VarArgsExample {
    public static void calc(int... numbers) {
        int sum = 0;
        for (int num : numbers) {      // `numbers` behaves exactly like an int[]
            sum += num;
        }
        System.out.println("Sum = " + sum + " (count = " + numbers.length + ")");
    }

    public static void main(String[] args) {
        calc(10, 20);            // Sum = 30 (count = 2)
        calc(5, 15, 25, 35);     // Sum = 80 (count = 4)
        calc(100);               // Sum = 100 (count = 1)
        calc();                  // Sum = 0 (count = 0)  ← empty array, NOT null
        calc(new int[]{1, 2});   // Sum = 3  ← you may pass a real array too
    }
}
```

👉 `int... numbers` means "any number of `int`s". Internally the compiler **wraps them into an
array** (`int[]`) before the call — so `.length` and `for-each` work as usual.

### Varargs rules

| Rule | Why |
|------|-----|
| A method can have **only one** varargs parameter | Otherwise the compiler cannot tell where one list ends |
| It must be the **last** parameter | `f(String label, int... nums)` ✅ &nbsp; `f(int... nums, String label)` ❌ |
| Calling with no arguments gives an **empty array** | `numbers.length == 0`, never `null` |
| A real array can be passed directly | `calc(arr)` works |

> ⚠️ `calc(null)` passes `null` **as the whole array** → `NullPointerException` on the loop.
> Write `calc(new int[0])` (or just `calc()`) if you mean "nothing".

> ⚠️ Varargs are the **last resort** during overload resolution — a fixed-arity method always
> wins over a varargs one. See `2_method-overloading.md`.

> 💡 Real-world varargs you already use: `String.format(...)`, `System.out.printf(...)`,
> `List.of(...)`, and `main(String[] args)` itself (which could legally be written
> `main(String... args)`).

---

## 🔦 Variable Scope & Shadowing

A variable exists only inside the `{ }` block where it was declared.

```java
public class ScopeDemo {
    static int counter = 0;             // field → visible to every method of the class

    static void demo(int param) {       // param → visible only inside demo()
        int local = 5;                  // local → visible only inside demo()
        if (param > 0) {
            int inner = 10;             // inner → visible only inside this if-block
            local += inner;
        }
        // System.out.println(inner);   // ❌ error: cannot find symbol
        counter++;                      // ✅ fields are shared across methods
    }
}
```

- **Local variables have no default value** — they must be initialised before use.
  (Fields *do* get defaults: `0`, `false`, `null`.)
- Two different methods can each declare a variable called `sum` — they are **unrelated**.
- **Shadowing:** a local variable with the same name as a field hides the field inside that method.
  Use `this.field` to reach the field (Chapter 6).

> 💡 This is why `int sum = 0;` appears *inside* `calcSum` in `MethodWithVarArgs.java`:
> the local `sum` is created fresh on **every call**, so the totals never bleed into each other.

---

## 🧠 How a Method Call Actually Works (the Call Stack)

Every method call pushes a **stack frame** holding that call's parameters and local variables.
When the method returns, its frame is **popped** and its locals vanish.

```text
main() calls square(5) which calls helper()

   ┌──────────────┐  ← top of stack (currently running)
   │  helper()    │
   ├──────────────┤
   │  square(5)   │   n = 5
   ├──────────────┤
   │  main()      │   args, result
   └──────────────┘  ← bottom
```

- Control **always returns to the exact line after the call**.
- Each call gets its **own copy** of the parameters — that is pass-by-value in action.
- If frames are pushed forever without returning → **`StackOverflowError`**
  (see `3_recursion.md`).

---

## 🧾 Naming & Style Conventions

| Convention | Example |
|------------|---------|
| `camelCase`, starting lowercase | `calculateTotal`, `reverseNumber` |
| Name it after **what it does** (a verb) | `printBill()`, `findFactorial()` |
| Boolean-returning methods read like a question | `isEven()`, `hasNext()`, `canVote()` |
| Getter/setter style (Chapter 6) | `getName()` / `setName()` |
| One method = one job | If the name needs "And", split it |

---

## 🐞 Common Compile Errors — Quick Decoder

| Error message | Real cause |
|---------------|------------|
| *non-static method X cannot be referenced from a static context* | Called an instance method from `main` without an object |
| *missing return statement* | A non-`void` path can fall off the end |
| *incompatible types: possible lossy conversion from double to int* | Returning/passing a wider type into a narrower one |
| *method X is already defined in class Y* | Same signature twice (return type doesn't count!) |
| *cannot find symbol* | Used a variable outside its scope, or misspelled the method name |
| *unreachable statement* | Code written after `return` / `break` |
| *varargs parameter must be the last parameter* | `f(int... a, int b)` |
| *actual and formal argument lists differ in length* | Wrong number of arguments at the call site |

---

## 🗂️ Where to Practise This

| Concept | File in `coding-practice/` |
|---------|---------------------------|
| Declaring & calling simple `void` methods | `BasicMethodsIntroduction.java` |
| Parameters + return values, menu-driven design | `MethodsWithParametersAndReturn.java` |
| Varargs | `MethodWithVarArgs.java` |
| Returning a computed value | `ReverseANumberMethod.java`, `PalindromeCheckerMethod.java` |
| Recursion | `FactorialRecursion.java`, `FibonacciRecursion.java`, `SumOfDigitsRecursion.java`, `PowRecursion.java` |

---

## 🎯 Key Takeaways

- A method is a **named, reusable block** designed for one specific task.
- `main()` is the entry point; the JVM calls it with the exact signature `main(String[])`.
- A **signature = name + parameter types**. Return type and parameter names are *not* part of it.
- Non-`void` methods must return a value on **every** path; `void` methods may `return;` early.
- **Java is always pass-by-value** — for objects the *reference* is copied, so contents can be
  changed but the caller's variable can never be re-pointed.
- **varargs (`...`)** accept 0..n arguments, arrive as an array, must be the **last** parameter,
  and there can be only **one** per method.
- Local variables live only inside their block and have **no default value**.
- Each call gets its own **stack frame**; returning pops it.
- Calling an instance method from `static main` needs an object — the most common error here.
- 👉 Next: **`2_method-overloading.md`** (same name, different parameters) and
  **`3_recursion.md`** (methods that call themselves).
