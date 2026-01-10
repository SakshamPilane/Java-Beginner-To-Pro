# 🧬 Inheritance in Java (Basics)

**Inheritance** is one of the core principles of Object-Oriented Programming (OOP).
It allows a class to **reuse properties and behavior** of another class.

Inheritance represents an **IS-A relationship**.

---

## 📌 What is Inheritance?

Inheritance allows:
- A **child (subclass)** to acquire
- Properties and methods of a **parent (superclass)**

```text
Child IS-A Parent
```

Example:
```text
Car IS-A Vehicle
Dog IS-A Animal
Student IS-A Person
```

---

## 🧠 Why Use Inheritance?

- Code reusability
- Avoids duplication
- Improves maintainability
- Supports polymorphism
- Models real-world relationships

---

## 🧩 Basic Syntax of Inheritance

```java
class ChildClass extends ParentClass {
    // child-specific code
}
```

Keyword used:
```text
extends
```

---

## 🏗️ Parent Class (Superclass)

- The class whose properties are inherited
- Also called **base class**
- Provides common behavior

---

## 👶 Child Class (Subclass)

- The class that inherits from another class
- Also called **derived class**
- Can add new behavior or override existing behavior

---

## 🔍 What Gets Inherited?

✔️ Public methods and variables  
✔️ Protected members  
✔️ Default members (same package)

❌ Private members are **not directly accessible**

---

## 🔐 Access Control in Inheritance (Intro)

| Modifier | Accessible in Child |
|--------|--------------------|
| private | ❌ No |
| default | ✔️ Same package |
| protected | ✔️ Yes |
| public | ✔️ Yes |

---

## 🧠 Types of Inheritance in Java

### ✔️ Single Inheritance
```text
Parent → Child
```

### ✔️ Multilevel Inheritance
```text
Grandparent → Parent → Child
```

### ✔️ Hierarchical Inheritance
```text
Parent → Child1
       → Child2
```

❌ Multiple inheritance using classes is **not supported** in Java  
✔️ Achieved using **interfaces**

---

## 🔑 The `super` Keyword (Intro)

`super` is used to refer to the **parent class object**.

Uses:
- Access parent class variables
- Call parent class methods
- Call parent class constructor

```text
super → immediate parent
```

---

## 🧠 Inheritance vs Composition (Intro)

| Inheritance | Composition |
|-----------|------------|
| IS-A relationship | HAS-A relationship |
| Tight coupling | Loose coupling |
| Code reuse via parent | Code reuse via objects |

---

## ⚠️ Important Rules

- A class can extend only **one class**
- Constructors are **not inherited**
- Private members are not accessible
- Method overriding requires inheritance

---

## 🌍 Real-World Analogy

```text
Animal
 └── Dog
     └── Bark()
```

Dog inherits common features from Animal and adds its own behavior.

---

## 🎯 Key Takeaways

- Inheritance promotes code reuse
- Uses `extends` keyword
- Represents IS-A relationship
- Foundation for polymorphism and overriding
- Essential for real-world OOP design