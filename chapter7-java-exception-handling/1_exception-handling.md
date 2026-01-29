# 🚨 Exception Handling in Java

Exception Handling in Java is a mechanism used to handle **runtime errors** so that the normal flow of a program is not interrupted.

It allows a program to **fail gracefully**, explain the reason for failure, and take corrective or alternate actions.

---

## 📌 What is an Exception?

An **exception** is an abnormal condition or unexpected event that occurs during program execution.

Examples:
- Division by zero
- Accessing invalid array index
- File not found
- Null object access

Exceptions are **objects** in Java.

---

## ❌ What Exception Handling is NOT

- It does NOT handle syntax errors
- It does NOT handle logical errors
- It does NOT fix code automatically

Syntax and logical errors must be fixed by the programmer.

---

## ⚙️ Why Exception Handling is Needed

- Prevents program crash
- Improves program reliability
- Helps in debugging
- Allows alternate logic execution
- Used heavily in real-world applications

---

## 🧱 Exception Hierarchy (Basic View)

```
Object
 └── Throwable
      ├── Exception
      │     ├── Checked Exceptions
      │     └── Unchecked Exceptions
      └── Error
```

---

## 🔹 Types of Problems in Java

| Problem Type | Handled by Exception? |
|-------------|-----------------------|
| Syntax error | ❌ No |
| Type mismatch | ❌ No |
| Checked exception | ✅ Yes |
| Unchecked exception | ✅ Yes |
| Logical error | ❌ No |

---

## ✅ Keywords Used in Exception Handling

1. try
2. catch
3. finally
4. throw
5. throws

---

## 🟢 try Block

Used to wrap code that may cause an exception.

```text
try {
    int a = 10 / 0;
}
```

---

## 🔴 catch Block

Used to handle the exception thrown in the try block.

```text
catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

---

## 🟡 finally Block

- Always executes
- Used for cleanup code
- Optional

```text
finally {
    System.out.println("Cleanup done");
}
```

---

## 🔁 Complete try-catch-finally Example

```text
try {
    int x = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println(e.getMessage());
}
finally {
    System.out.println("Program ended safely");
}
```

---

## 📤 throw Keyword

Used to **manually create and throw an exception**.

```text
throw new Exception("Something went wrong");
```

---

## 📤 throws Keyword

Used to **pass responsibility** of handling the exception to the caller.

```text
void readFile() throws Exception {
}
```

---

## 🧪 Predefined Exceptions

These are exceptions already defined by Java.

Examples:
- ArithmeticException
- NullPointerException
- ArrayIndexOutOfBoundsException
- IOException

---

### Example: Predefined Exception

```text
try {
    int a = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## 🧑‍💻 User-Defined Exception

Custom exceptions created by the programmer to represent **business logic errors**.

---

### Step 1: Create Custom Exception Class

```java
class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}
```

---

### Step 2: Use the Exception

```java
class Test {
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
        System.out.println("Eligible to vote");
    }

    public static void main(String[] args) {
        try {
            checkAge(16);
        }
        catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

---

## 📌 Checked vs Unchecked Exceptions

### ✅ Checked Exceptions
- Checked at compile time
- Compiler forces handling
- Usually external issues (file, DB, network)

Example:
- IOException

---

### ❌ Unchecked Exceptions
- Occur at runtime
- Compiler does not force handling
- Mostly programming mistakes

Example:
- ArithmeticException
- NullPointerException

---

## ⚠️ Important Rules

- Exceptions occur only at runtime
- Checked ≠ compile-time error
- Compiler only checks handling, not execution
- Logical errors are NOT exceptions

---

## 🧠 How to Identify Checked vs Unchecked (Beginner Rule)

- If compiler forces try-catch or throws → Checked Exception
- If compiler allows but crashes at runtime → Unchecked Exception

---

## 🔄 Exception Propagation

If an exception is not handled in a method, it is passed to the calling method.

```java
void m1() throws Exception {
    throw new Exception("Error");
}

void m2() throws Exception {
    m1();
}
```

---

## 🌍 Real-World Usage

Exception handling is used to:
- Retry operations
- Use fallback logic
- Notify systems
- Safely shut down applications
- Maintain system stability

---

## ❌ What Exception Handling Cannot Do

- Resume execution from failed line
- Fix logical errors
- Undo partially executed code automatically

---

## 📌 Best Practices (Pro Level)

- Handle exceptions at appropriate levels
- Do not overuse try-catch
- Use meaningful exception messages
- Do not catch Exception blindly
- Avoid using exceptions for normal flow

---

## 🧾 One-Line Summary

Exception handling in Java allows programs to detect, handle, and recover from runtime errors in a controlled manner without crashing the application.

---

## ✅ Chapter Completion Checklist

✔ try-catch-finally  
✔ throw and throws  
✔ Predefined exceptions  
✔ User-defined exceptions  
✔ Checked vs unchecked  
✔ Runtime behavior understanding  
✔ Beginner → Pro clarity
