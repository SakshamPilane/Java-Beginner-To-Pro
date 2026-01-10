# 🎭 Abstraction, Inheritance & Composition in Java

In Java, **Abstraction**, **Inheritance**, and **Composition** work together to build
**clean, scalable, and real-world–ready** object-oriented systems.

Understanding how and **when** to use each is critical for professional Java development.

---

# 🎭 Abstraction in Java

## 📌 What is Abstraction?

**Abstraction** is the process of **hiding implementation details**
and showing **only essential features** to the user.

```text
What an object does → visible
How it does it → hidden
```

Abstraction focuses on **behavior**, not implementation.

---

## 🧠 Why Abstraction is Needed?

- Reduces complexity
- Improves code readability
- Enhances security
- Makes systems easier to extend
- Helps in large-scale design

---

## 🧩 How Abstraction is Achieved in Java?

Java provides two ways:
1. **Abstract Classes**
2. **Interfaces**

---

## 🧱 Abstract Class

An **abstract class**:
- Is declared using the `abstract` keyword
- Can have abstract and non-abstract methods
- Cannot be instantiated
- Can have constructors and variables

```text
Partial abstraction
```

---

## 📌 Abstract Methods

- Declared without a body
- Must be implemented by child classes

```text
abstract method → no implementation
```

---

## ⚠️ Rules of Abstract Classes

- Can have constructors
- Can have instance variables
- Cannot be instantiated
- Child class must implement all abstract methods
- Can extend only one class

---

## 🧠 Abstraction vs Encapsulation

| Abstraction | Encapsulation |
|-----------|---------------|
| Hides implementation | Hides data |
| Focuses on design | Focuses on security |
| Achieved using abstract class/interface | Achieved using access modifiers |

---

# 🧬 Inheritance (Revisited with Abstraction)

## 📌 Role of Inheritance in Abstraction

Inheritance allows:
- Abstract classes to define a **common contract**
- Child classes to provide **specific implementations**

```text
Abstract Parent → Concrete Child
```

---

## 🧠 Why Inheritance Supports Abstraction?

- Enables code reuse
- Enforces method implementation
- Allows polymorphic behavior
- Models IS-A relationships

---

## ⚠️ Limitations of Inheritance

- Tight coupling
- Fragile hierarchy
- Changes in parent affect all children
- Overuse leads to rigid design

👉 This is why **composition** is often preferred.

---

# 🧩 Composition in Java (HAS-A Relationship)

## 📌 What is Composition?

**Composition** represents a **HAS-A relationship**.

Instead of inheriting behavior, a class:
- Uses another class
- As a member variable

```text
Car HAS-A Engine
Human HAS-A Heart
```

---

## 🧠 Why Use Composition?

- Loose coupling
- Better flexibility
- Easier maintenance
- Encouraged in real-world design

---

## 🧩 Composition Structure (Conceptual)

```text
Class A
 └── has object of Class B
```

A depends on B, but does not inherit from B.

---

## 🧠 Composition vs Inheritance

| Inheritance | Composition |
|-----------|------------|
| IS-A | HAS-A |
| Tight coupling | Loose coupling |
| Less flexible | More flexible |
| Hierarchy-based | Object-based |
| Compile-time relationship | Runtime relationship |

---

## 🔄 When to Use What?

### Use Inheritance when:
- There is a true IS-A relationship
- Behavior must be overridden
- Polymorphism is required

### Use Composition when:
- Behavior can change dynamically
- You want loose coupling
- You want reusable components

---

## 🌍 Real-World Comparison

```text
Inheritance:
Manager IS-A Employee

Composition:
Car HAS-A Engine
Computer HAS-A CPU
```

---

## 🧠 Design Rule (Important)

```text
Favor Composition over Inheritance
```

This is a core object-oriented design principle.

---

## 🎯 Key Takeaways

- Abstraction hides implementation details
- Achieved using abstract classes and interfaces
- Inheritance supports abstraction via IS-A relationship
- Composition represents HAS-A relationship
- Composition is more flexible than inheritance
- Professional systems heavily rely on abstraction + composition
