# 🎭 Abstraction in Java

**Abstraction** is one of the core principles of Object-Oriented Programming (OOP).
It focuses on **what an object does**, not **how it does it**.

Abstraction helps in building **clean, flexible, and scalable** Java applications.

---

## 📌 What is Abstraction?

**Abstraction** means:
> Hiding implementation details and exposing only essential features.

```text
WHAT an object does → visible
HOW it does it     → hidden
```

The goal is to **reduce complexity** and **increase clarity**.

---

## 🧠 Why Do We Need Abstraction?

- To hide unnecessary implementation details
- To reduce system complexity
- To enforce a common structure
- To make code flexible and extensible
- To support polymorphism
- To build large-scale applications

---

## 🧩 How Abstraction is Achieved in Java

Java supports abstraction using:
1. **Abstract Classes**
2. **Interfaces** (covered in advanced OOP)

This file focuses on **abstract classes**.

---

# 🧱 Abstract Classes in Java

## 📌 What is an Abstract Class?

An **abstract class** is a class that:
- Is declared using the `abstract` keyword
- Cannot be instantiated (no objects)
- Can have abstract and non-abstract methods

```text
Abstract class = Partial abstraction
```

---

## 🧩 Abstract Method

An **abstract method**:
- Has no method body
- Is declared using `abstract`
- Must be implemented by child classes

```java
abstract void calculateSalary();
```

---

## 🧠 Why Abstract Classes Exist?

- To define a **base blueprint**
- To force subclasses to implement required methods
- To share common code among related classes

---

## 🔑 Basic Syntax

```java
abstract class Shape {
    abstract void area();
}
```

Child class:
```java
class Circle extends Shape {
    void area() {
        // implementation
    }
}
```

---

## ⚠️ Rules of Abstract Classes

- Cannot create objects of abstract class
- Can have constructors
- Can have instance variables
- Can have both abstract and concrete methods
- A class extending an abstract class must implement all abstract methods
- Abstract class can extend another abstract or concrete class

---

## 🧠 Abstract Class vs Concrete Class

| Abstract Class | Concrete Class |
|--------------|---------------|
| Cannot be instantiated | Can be instantiated |
| May contain abstract methods | Contains full implementations |
| Used as base class | Used as final implementation |

---

## 🧠 Abstraction vs Encapsulation (Common Confusion)

| Abstraction | Encapsulation |
|-----------|---------------|
| Hides implementation | Hides data |
| Focuses on behavior | Focuses on security |
| Achieved using abstract classes | Achieved using access modifiers |

---

## 🔄 Role of Abstraction in Polymorphism

Abstraction works with inheritance and polymorphism:

```java
Shape s = new Circle();
s.area();  // Circle's implementation runs
```

- Reference type → Abstract class
- Object type → Child class
- Method decision → Runtime

---

## 🌍 Real-World Analogy

```text
ATM Machine
- Withdraw
- Deposit
- Check Balance

User knows WHAT actions are possible,
not HOW the ATM works internally.
```

---

## ❌ Common Beginner Mistakes

- Trying to create object of abstract class
- Not implementing abstract methods in child class
- Using abstraction when not required
- Confusing abstraction with encapsulation

---

## 🧠 When to Use Abstraction?

Use abstraction when:
- Multiple classes share common behavior
- You want to enforce method implementation
- You want loose coupling
- You are designing frameworks or base systems

---

## 🎯 Interview One-Liners

- “Abstraction hides implementation details and exposes only essential behavior.”
- “Abstract classes provide partial abstraction.”
- “Abstract methods must be implemented by subclasses.”

---

## 🏁 Final Takeaways

- Abstraction focuses on WHAT, not HOW
- Achieved using abstract classes and interfaces
- Abstract classes cannot be instantiated
- Used with inheritance and polymorphism
- Essential for clean OOP and backend design
