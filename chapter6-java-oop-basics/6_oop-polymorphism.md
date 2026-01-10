# 🔁 Method Overriding & Polymorphism in Java

**Method Overriding** and **Polymorphism** are closely related concepts in Java.
They allow the same method call to behave **differently** depending on the object type,
making Java programs **flexible, extensible, and scalable**.

---

# 🔁 Method Overriding in Java

## 📌 What is Method Overriding?

Method overriding occurs when:
- A **child class** provides its own implementation of a method
- That method already exists in the **parent class**
- The method signature remains the **same**

```text
Same method name
Same parameters
Different implementation
```

---

## 🧠 Why Method Overriding is Needed?

- To modify inherited behavior
- To provide specific implementation
- To support runtime polymorphism
- To follow real-world behavior

---

## 🧩 Basic Syntax

```java
class Parent {
    void show() {
        // parent behavior
    }
}

class Child extends Parent {
    void show() {
        // child behavior
    }
}
```

---

## 📏 Rules for Method Overriding

- Method name must be the same
- Parameter list must be the same
- Return type must be same or covariant
- Access modifier cannot be more restrictive
- Only inherited methods can be overridden
- `static` methods cannot be overridden
- `final` methods cannot be overridden
- Constructors cannot be overridden

---

## 🔐 Access Modifier Rules

| Parent | Child |
|------|------|
| public | public |
| protected | protected / public |
| default | default / protected / public |
| private | ❌ not overridden |

---

## 🧠 Method Overloading vs Method Overriding

| Overloading | Overriding |
|-----------|-----------|
| Same method name | Same method name |
| Different parameters | Same parameters |
| Compile-time | Runtime |
| No inheritance required | Inheritance required |

---

# 🎭 Polymorphism in Java

## 📌 What is Polymorphism?

**Polymorphism** means **one name, many forms**.

In Java, polymorphism allows:
- A single method call
- To behave differently
- Based on the object type at runtime

---

## 🧠 Types of Polymorphism

### 1️⃣ Compile-Time Polymorphism
- Achieved using **method overloading**
- Method call resolved at compile time

---

### 2️⃣ Runtime Polymorphism
- Achieved using **method overriding**
- Method call resolved at runtime
- Uses **dynamic method dispatch**

---

## 🔄 Runtime Polymorphism (Dynamic Method Dispatch)

Dynamic method dispatch means:
- Method call is decided at **runtime**
- Based on the **actual object**, not reference type

```java
Parent ref = new Child();
ref.show();   // Child's version is called
```

---

## 🧠 Why Reference Type Matters?

- Reference type determines **accessible methods**
- Object type determines **executed method**

```text
Reference → Compile-time check
Object → Runtime execution
```

---

## 🧩 Polymorphic Reference Example (Conceptual)

```text
Shape s = new Circle();
s.area();  // Calls Circle's implementation
```

---

## 🔐 Conditions for Runtime Polymorphism

✔️ Inheritance  
✔️ Method overriding  
✔️ Parent class reference  
✔️ Child class object

---

## ⚠️ Important Limitations

- Static methods are not polymorphic
- Variables are not polymorphic
- Constructors are not polymorphic
- Polymorphism works only with methods

---

## 🌍 Real-World Analogy

```text
Remote Control → Button press
TV → Different actions based on brand
```

Same button → different behavior

---

## 🧠 Polymorphism vs Overriding (Connection)

```text
Overriding → Mechanism
Polymorphism → Behavior
```

Overriding enables runtime polymorphism.

---

## 🎯 Key Takeaways

- Method overriding customizes inherited behavior
- Polymorphism enables flexible method calls
- Runtime polymorphism is resolved at execution time
- Parent reference + child object is the key
- Core concept for interviews and backend systems
