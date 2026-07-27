# 🎭 Method Overloading in Java

**Method overloading** means having **several methods with the same name** in the same class,
distinguished by their **parameter list**.

It is Java's way of saying: *"same idea, different inputs."*

```java
public class Calculator {
    static int    add(int a, int b)           { return a + b; }
    static double add(double a, double b)     { return a + b; }
    static int    add(int a, int b, int c)    { return a + b + c; }
    static String add(String a, String b)     { return a + b; }

    public static void main(String[] args) {
        System.out.println(add(2, 3));           // 5      → add(int, int)
        System.out.println(add(2.5, 3.5));       // 6.0    → add(double, double)
        System.out.println(add(1, 2, 3));        // 6      → add(int, int, int)
        System.out.println(add("Ja", "va"));     // Java   → add(String, String)
    }
}
```

> 💡 You have been using overloading since day one:
> `System.out.println()` is overloaded **10+ times** — for `int`, `double`, `char`, `boolean`,
> `String`, `Object`, `char[]`, and with no argument at all. That is why one method name handles
> everything you throw at it.

Overloading is a form of **compile-time (static) polymorphism** — the compiler decides which
version to call while compiling, based on the argument types it can see.

---

## ✅ What Makes an Overload Valid?

The methods must differ in the **parameter list**, in at least one of these ways:

| Difference | Example | Valid? |
|------------|---------|--------|
| **Number** of parameters | `f(int)` vs `f(int, int)` | ✅ |
| **Type** of parameters | `f(int)` vs `f(double)` | ✅ |
| **Order** of parameter types | `f(int, String)` vs `f(String, int)` | ✅ |
| Only the **return type** | `int f(int)` vs `double f(int)` | ❌ |
| Only the **parameter names** | `f(int a)` vs `f(int b)` | ❌ |
| Only `final` on a parameter | `f(int a)` vs `f(final int a)` | ❌ |
| Only the **access modifier** or `static` | `public f(int)` vs `private static f(int)` | ❌ |

Remember from `1_methods.md`: **signature = name + parameter types**. If two methods have the same
signature, nothing else can save them:

```java
static int    getValue(int x) { return x; }
// static double getValue(int y) { return y; }   ❌ "method getValue(int) is already defined"
```

> ⚠️ **Why can't the return type distinguish them?** Because a caller may ignore the return value:
> ```java
> getValue(5);   // which one did you mean? the compiler has no way to know
> ```

---

## 🧭 How Java Picks the Right Overload (Resolution Order)

When several overloads *could* accept your argument, the compiler tries **three phases in order**
and stops at the first one that finds a match:

| Phase | What is allowed | Example |
|-------|-----------------|---------|
| **1️⃣ Exact match + widening** | `int` → `long` → `float` → `double`, subclass → superclass | `f(int)` then `f(long)` |
| **2️⃣ Autoboxing / unboxing** | `int` → `Integer` → `Object` | `f(Integer)`, `f(Object)` |
| **3️⃣ Varargs** | `f(int...)` | last resort, always loses |

**Golden rule: widening beats boxing, and boxing beats varargs.**

```java
public class Resolution {
    static void show(long x)      { System.out.println("long"); }
    static void show(Integer x)   { System.out.println("Integer"); }
    static void show(Object x)    { System.out.println("Object"); }
    static void show(int... x)    { System.out.println("varargs"); }

    public static void main(String[] args) {
        show(5);      // "long"  ← phase 1 wins: widening int→long beats boxing int→Integer
    }
}
```

Remove `show(long)` and the same call prints `"Integer"` (phase 2).
Remove `show(Integer)` too and it prints `"Object"` (still phase 2 — box, then widen the reference).
Remove that as well and only then does `"varargs"` run (phase 3).

> 💡 **How to reason about it:** *"Can I reach a match without boxing? Take it. Otherwise box.
> Varargs only if nothing else fits."*

---

## ⚠️ Overloading Traps (Interview Favourites)

### 1️⃣ `char` silently widens

```java
static void print(int x)    { System.out.println("int: " + x); }

print('A');   // "int: 65"  ← no print(char) exists, so char widens to int
```
Add a `print(char)` and it wins — an exact match always beats widening.

### 2️⃣ `null` picks the **most specific** type

```java
static void test(String s)  { System.out.println("String"); }
static void test(Object o)  { System.out.println("Object"); }

test(null);   // "String"  ← String is more specific than Object
```

But if two candidates are **siblings** (neither is more specific), it fails:

```java
static void test(String s)        { }
static void test(StringBuilder s) { }

// test(null);   ❌ "reference to test is ambiguous"  → cast it: test((String) null)
```

### 3️⃣ Equally-good candidates = ambiguity error

```java
static void f(int a, long b)  { }
static void f(long a, int b)  { }

// f(5, 5);   ❌ ambiguous — each version wins on one argument and loses on the other
```

### 4️⃣ Boxing does **not** chain with widening for primitives

```java
static void g(Long x) { }

// g(5);   ❌ int cannot box to Integer and then widen to Long
g(5L);     // ✅ long boxes to Long
```

### 5️⃣ `main` can be overloaded — but only one is the entry point

```java
public class MainOverload {
    public static void main(String[] args) {
        System.out.println("real main");
        main(10);                       // an ordinary method call
    }
    public static void main(int x) {    // legal overload, JVM ignores it
        System.out.println("overloaded main: " + x);
    }
}
// Output:
// real main
// overloaded main: 10
```
The JVM only ever *starts* at `public static void main(String[])`.

### 6️⃣ Two varargs overloads are almost always ambiguous

```java
static void v(int... a)     { }
static void v(Integer... a) { }

// v();   ❌ ambiguous — both accept zero arguments equally well
```

---

## 🏗️ Constructor Overloading (preview of Chapter 6)

Constructors follow the exact same rules — this is where overloading is used most:

```java
class Student {
    String name;
    int marks;

    Student()                        { this("Unknown", 0); }   // chains to the one below
    Student(String name)             { this(name, 0); }
    Student(String name, int marks)  { this.name = name; this.marks = marks; }
}
```

> 💡 The pattern above is called **constructor chaining** — the "smaller" constructors delegate to
> the fullest one with `this(...)`, so the initialisation logic lives in exactly one place.

---

## 🆚 Overloading vs Overriding

You will meet **overriding** in Chapter 6 (Inheritance). Keep the difference straight from day one:

| | **Overloading** | **Overriding** |
|---|---|---|
| Where | Same class (or inherited into it) | Subclass redefines a superclass method |
| Parameter list | **Must differ** | **Must be identical** |
| Return type | Can be anything | Same, or a covariant subtype |
| Decided at | **Compile time** (static binding) | **Runtime** (dynamic binding) |
| Polymorphism type | Compile-time | Runtime |
| `static` methods | Can be overloaded ✅ | Cannot be overridden (only *hidden*) ❌ |
| `private` / `final` methods | Can be overloaded ✅ | Cannot be overridden ❌ |
| Access modifier | Free to change | Cannot be more restrictive |

> 💡 Memory hook: **overLOADing = same name, LOADED with different parameters (compile time).**
> **overRIDing = the child RIDES OVER the parent's version (runtime).**

---

## ✍️ Good Practice

- Overload only when the methods genuinely do the **same conceptual thing**.
  `print(int)` and `print(String)` ✅ · `process(int)` = save while `process(String)` = delete ❌
- Keep the **return type consistent** across overloads — surprising a caller is worse than a longer
  method name.
- If overloads start needing casts or `null` gymnastics at the call site, use **different names**
  instead (`readInt()`, `readLine()` — this is exactly what `Scanner` does).
- Avoid mixing **varargs** with fixed-arity overloads of the same name; resolution gets subtle fast.

---

## 🎯 Key Takeaways

- Overloading = **same method name, different parameter list**, in the same class.
- Valid differences: **number**, **type**, or **order** of parameters.
- Return type, parameter names, `final`, `static`, and access modifiers **cannot** distinguish
  overloads — signature is name + parameter types only.
- It is **compile-time polymorphism**: the compiler binds the call, not the JVM.
- Resolution order is **widening → boxing → varargs**; the first phase that finds a match wins.
- `char` widens to `int` when no `char` overload exists.
- `null` selects the **most specific** reference type, and is **ambiguous** among siblings.
- `main` can be overloaded, but the JVM only starts at `main(String[])`.
- Overloading ≠ overriding: different parameters/compile time vs same parameters/runtime.
