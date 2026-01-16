# 🎭 Polymorphism in Java

**Polymorphism** is one of the core principles of Object-Oriented Programming (OOP).

The word **Polymorphism** means:
```text
Poly  → Many
Morph → Forms
```

👉 **One method name, many behaviors**

---

## 📌 What is Polymorphism?

Polymorphism allows:
- The **same method**
- To behave **differently**
- Based on **how or where it is used**

It makes programs **flexible, extensible, and scalable**.

---

## 🧠 Why Do We Need Polymorphism?

- Reduces code dependency
- Improves flexibility
- Makes code extensible
- Supports dynamic behavior
- Widely used in real-world frameworks

---

## 🧩 Types of Polymorphism in Java

Java supports **two types of polymorphism**:

1. **Static Polymorphism** (Compile-Time)
2. **Dynamic Polymorphism** (Runtime)

---

# 🅰️ 1. Static Polymorphism (Compile-Time)

## 📌 What is Static Polymorphism?

Static polymorphism is when:
- Method call is **resolved at compile time**
- Decision is made **before program runs**

👉 Achieved using **Method Overloading**

---

## 🔁 Method Overloading

### 📌 Definition
Method overloading means:
- Same method name
- Different parameter list (number, type, order)
- Happens in the **same class**

```text
Same method name
Different parameters
```

---

## 🧠 Why It Is Called Compile-Time?

Because:
- Compiler decides **which method to call**
- Based on method signature
- Before execution starts

---

## 📌 Example (Conceptual)

```text
add(int a, int b)
add(double a, double b)
add(int a, int b, int c)
```

---

## ⚠️ Important Rules of Method Overloading

- Return type alone cannot change
- Inheritance is NOT required
- Happens in same class
- Faster than runtime polymorphism

---

## 🎯 Use Case of Static Polymorphism

- Utility classes
- Mathematical operations
- Compile-time optimization

---

# 🅱️ 2. Dynamic Polymorphism (Runtime)

## 📌 What is Dynamic Polymorphism?

Dynamic polymorphism is when:
- Method call is **resolved at runtime**
- Decision depends on **object type**, not reference type

👉 Achieved using **Method Overriding**

---

## 🔁 Method Overriding

### 📌 Definition
Method overriding means:
- Child class provides its own implementation
- Of a method already present in parent class
- Method signature remains the same

```text
Same method name
Same parameters
Different implementation
```

---

## 🧠 Why It Is Called Runtime?

Because:
- JVM decides **which method to execute**
- During program execution
- Based on actual object

---

## 📌 Key Requirement (VERY IMPORTANT)

```java
Parent ref = new Child();
```

- Reference type → Parent
- Object type → Child

👉 Child’s method is executed.

---

## ⚠️ Rules of Method Overriding

- Inheritance is required
- Method signature must be same
- Access modifier cannot be more restrictive
- `static`, `final`, `private` methods cannot be overridden
- Happens in different classes

---

## 🔐 Static vs Dynamic Polymorphism (MOST IMPORTANT TABLE)

| Feature | Static Polymorphism | Dynamic Polymorphism |
|------|-------------------|--------------------|
| Also called | Compile-Time | Runtime |
| Achieved by | Method Overloading | Method Overriding |
| Method binding | Compile-time | Runtime |
| Inheritance needed | ❌ No | ✅ Yes |
| Performance | Faster | Slightly slower |
| Flexibility | Less | More |

---

## 🧠 Overloading vs Overriding (COMMON CONFUSION CLEARED)

| Overloading | Overriding |
|-----------|-----------|
| Same class | Parent-child classes |
| Different parameters | Same parameters |
| Compile-time | Runtime |
| No inheritance | Requires inheritance |
| Static polymorphism | Dynamic polymorphism |

👉 **Overloading ≠ Overriding**

---

## 🧠 What Polymorphism Does NOT Apply To

- Variables (not polymorphic)
- Constructors
- Static methods

Only **instance methods** support runtime polymorphism.

---

## 🌍 Real-World Analogy

```text
Remote Control Button
→ Different TVs
→ Same button, different behavior
```

---

## 🎯 Interview One-Liners

- “Polymorphism allows one interface to have multiple implementations.”
- “Method overloading is compile-time polymorphism.”
- “Method overriding is runtime polymorphism.”

---

## 🏁 Final Takeaways

- Polymorphism means many forms
- Static polymorphism = method overloading
- Dynamic polymorphism = method overriding
- Runtime polymorphism depends on object type
- Core concept for interviews and backend systems
