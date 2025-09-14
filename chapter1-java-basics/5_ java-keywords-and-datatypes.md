# 🟢 Java Keywords and Primitive Data Types

This guide contains a **comprehensive list of Java keywords** and **primitive data types**.  
It is beginner-friendly and ready for GitHub.

---

## 1️⃣ Java Keywords

Java has **50 reserved keywords** that cannot be used as identifiers.

| Keyword       | Description |
|---------------|-------------|
| `abstract`    | Declares an abstract class or method |
| `assert`      | Used for debugging purposes |
| `boolean`     | Declares a boolean variable |
| `break`       | Exits from loop or switch |
| `byte`        | Declares a byte variable |
| `case`        | Defines a branch in switch statement |
| `catch`       | Handles exceptions |
| `char`        | Declares a character variable |
| `class`       | Declares a class |
| `const`       | Not used (reserved) |
| `continue`    | Skips current iteration in a loop |
| `default`     | Specifies default block in switch |
| `do`          | Starts a do-while loop |
| `double`      | Declares a double-precision floating point variable |
| `else`        | Specifies alternative branch in if statement |
| `enum`        | Defines an enumeration |
| `extends`     | Indicates inheritance |
| `final`       | Declares constants or prevents overriding/inheritance |
| `finally`     | Executes code after try-catch block |
| `float`       | Declares a single-precision floating point variable |
| `for`         | Starts a for loop |
| `goto`        | Not used (reserved) |
| `if`          | Starts an if statement |
| `implements`  | Implements an interface |
| `import`      | Imports packages or classes |
| `instanceof`  | Tests object type |
| `int`         | Declares an integer variable |
| `interface`   | Declares an interface |
| `long`        | Declares a long integer variable |
| `native`      | Specifies native method |
| `new`         | Creates new object |
| `package`     | Declares package name |
| `private`     | Access modifier |
| `protected`   | Access modifier |
| `public`      | Access modifier |
| `return`      | Returns value from a method |
| `short`       | Declares a short integer variable |
| `static`      | Declares class-level members |
| `strictfp`    | Restricts floating point calculations for portability |
| `super`       | Refers to superclass |
| `switch`      | Starts a switch statement |
| `synchronized`| Ensures thread-safe execution |
| `this`        | Refers to current object |
| `throw`       | Throws exception |
| `throws`      | Declares exceptions thrown by method |
| `transient`   | Prevents serialization |
| `try`         | Starts a try-catch block |
| `void`        | Declares method with no return value |
| `volatile`    | Declares variable can be modified asynchronously |
| `while`       | Starts a while loop |

> ⚠️ Notes:
> - `const` and `goto` are **reserved but not used** in Java.
> - Keywords are **case-sensitive**.

---

## 2️⃣ Java Primitive Data Types

Java has **8 primitive data types** with fixed sizes.

| Data Type | Size        | Description |
|-----------|------------|-------------|
| `byte`    | 1 byte     | Stores whole numbers from -128 to 127 |
| `short`   | 2 bytes    | Stores whole numbers from -32,768 to 32,767 |
| `int`     | 4 bytes    | Stores whole numbers from -2³¹ to 2³¹-1 |
| `long`    | 8 bytes    | Stores whole numbers from -2⁶³ to 2⁶³-1 |
| `float`   | 4 bytes    | Stores decimal numbers (single-precision) |
| `double`  | 8 bytes    | Stores decimal numbers (double-precision) |
| `char`    | 2 bytes    | Stores a single Unicode character |
| `boolean` | 1 bit      | Stores `true` or `false` |

> 💡 Notes:
> - `char` uses **UTF-16 encoding**, hence 2 bytes.
> - `boolean` technically occupies **1 bit**, but JVM may allocate 1 byte.

---

## ✅ Key Takeaways

- **Keywords** are reserved words; cannot be used as variable names.
- **Primitive types** are the building blocks of data storage in Java.
- Correct use of keywords and data types ensures **compilation and runtime correctness**.
