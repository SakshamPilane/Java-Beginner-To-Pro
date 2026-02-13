# 🔷 Generics in Java (Compile-Time Type Safety & Reusability)

Generics allow Java developers to write **type-safe, reusable, and flexible code** by parameterizing classes, interfaces, and methods.

They eliminate unnecessary casting and prevent runtime `ClassCastException` by shifting errors to **compile time**.

---

# 📌 What Are Generics?

Generics are a **compile-time feature** that enable parameterized types.

Without generics:

```java
List list = new ArrayList();
list.add("Hello");
list.add(10);

String s = (String) list.get(1); // Runtime ClassCastException
```

With generics:

```java
List<String> list = new ArrayList<>();
list.add("Hello");
list.add(10); // Compile-time error
```

### ✅ Generics ensure:
- Type safety
- No manual casting
- Cleaner APIs
- Early error detection

---

# 🎯 Why Generics?

Before Java 5:
- Collections allowed mixed types
- Explicit casting was required
- Errors appeared at runtime

After Java 5:
- Types are enforced at compile time
- APIs became safer and cleaner

Generics move errors from:

Runtime → Compile Time

---

# 🧱 Generic Class

```java
class Box<T> {

    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
```

Usage:

```java
Box<Integer> intBox = new Box<>();
Box<String> strBox = new Box<>();
```

### 📖 Definitions:
- **T** → Type parameter
- **Integer / String** → Type argument

---

# 🧩 Generic Interface

```java
interface Repository<T> {
    void save(T data);
    T findById(int id);
}
```

Implementation:

```java
class UserRepository implements Repository<User> {

    public void save(User data) {}

    public User findById(int id) {
        return null;
    }
}
```

---

# ⚙️ Generic Methods

A method can declare its own type parameter.

```java
public static <T> T identity(T value) {
    return value;
}
```

### Important:
`<T>` must appear **before the return type**.

Type inference:

```java
String s = identity("Hello");
Integer n = identity(10);
```

---

# 🔒 Bounded Type Parameters

Used to restrict allowed types.

## 1️⃣ Upper Bound

```java
class Box<T extends Number> {

    T value;

    double doubleValue() {
        return value.doubleValue();
    }
}
```

Valid:
- Box<Integer>
- Box<Double>

Invalid:
- Box<String> ❌

---

## 2️⃣ Multiple Bounds

```java
<T extends Number & Comparable<T>>
```

### Rules:
- First bound must be a class
- Remaining bounds must be interfaces

---

# 🏗️ Generic Constructor

A constructor can also declare its own type parameter.

```java
class Printer {

    public <T> Printer(T value) {
        System.out.println(value);
    }
}
```

Note:
The class itself does NOT need to be generic.

---

# ❓ Wildcards in Generics

Wildcard represents an unknown type.

```java
List<?> list;
```

---

## 1️⃣ Unbounded Wildcard

```java
List<?> list;
```

- Can read as Object
- Cannot add elements (except null)

---

## 2️⃣ Upper Bounded Wildcard

```java
List<? extends Number>
```

- Accepts Number and subclasses
- Can read as Number
- Cannot add elements

---

## 3️⃣ Lower Bounded Wildcard

```java
List<? super Integer>
```

- Accepts Integer and its superclasses
- Can add Integer
- Reading returns Object

---

# 🔥 PECS Rule

**Producer → extends**  
**Consumer → super**

If a structure produces data → use `extends`  
If it consumes data → use `super`

---

# 🧬 Type Erasure

Generics exist only at compile time.

At runtime:

```text
List<String>
List<Integer>
```

Both become:

```text
List
```

The JVM does NOT retain generic type information.

This process is called **Type Erasure**.

---

## Why Type Erasure Exists

- Backward compatibility with older Java versions
- No JVM modification required
- Smooth migration from legacy code

---

# ⚠️ Restrictions & Limitations

## 1️⃣ Cannot Use Primitive Types

```text
❌ List<int>
✔ List<Integer>
```

---

## 2️⃣ Cannot Instantiate Type Parameter

```text
❌ T obj = new T();
```

Reason:
Type erased at runtime.

---

## 3️⃣ Cannot Create Generic Arrays

```text
❌ T[] arr = new T[10];
```

Reason:
Arrays enforce runtime type checking.

---

## 4️⃣ Static Members Cannot Use Type Parameter

```java
class Box<T> {
    static T value; // Not allowed
}
```

Reason:
Static belongs to class, not instance.

---

## 5️⃣ Generics and Exceptions

Not allowed:

```java
class MyException<T> extends Exception {}
```

```java
catch (T e) {}
```

Reason:
Exception handling relies on runtime type checking.

---

# 🧠 Inheritance Rules

Generics are **invariant**.

```text
❌ List<Object> list = new ArrayList<String>();
```

Reason:
List<String> is NOT a subtype of List<Object>.

Correct usage:

```java
List<?> list = new ArrayList<String>();
```

---

# 💥 Generics – Interview Questions

---

### Q1. Why are generics important?

<details>
<summary>▶ Show Answer</summary>

Generics provide compile-time type safety and eliminate explicit casting.
They prevent runtime ClassCastException by catching type errors during compilation.

</details>

---

### Q2. What is Type Erasure?

<details>
<summary>▶ Show Answer</summary>

Type Erasure is the process where the compiler removes generic type information during compilation.
At runtime, List<String> and List<Integer> both become simply List.

</details>

---

### Q3. Why can't we create generic arrays?

<details>
<summary>▶ Show Answer</summary>

Arrays enforce runtime type checking, while generics are erased at compile time.
Allowing generic arrays would break type safety.

</details>

---

### Q4. Difference between `<T>` and `<?>`?

<details>
<summary>▶ Show Answer</summary>

`<T>` declares a named type parameter and allows consistent type usage.
`<?>` represents an unknown type and provides flexibility when the exact type is not required.

</details>

---

### Q5. What is PECS?

<details>
<summary>▶ Show Answer</summary>

PECS stands for:
Producer → Extends  
Consumer → Super

If data is being produced, use `extends`.
If data is being consumed, use `super`.

</details>

---

# 📌 One-Line Summary

Generics provide compile-time type safety through parameterized types while maintaining backward compatibility using type erasure.

---

# ✅ Chapter Completion Checklist

- Why generics
- Generic classes
- Generic interfaces
- Generic methods
- Bounded type parameters
- Wildcards (extends / super)
- PECS rule
- Type erasure
- Restrictions
- Interview clarity
