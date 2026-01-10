# 🧩 Class & Object in Java

In Java, everything revolves around **classes** and **objects**.
They are the foundation of Object-Oriented Programming.

---

## 📌 What is a Class?

A **class** is a **blueprint or template** used to create objects.

It defines:
- **Properties** → variables (data)
- **Behaviors** → methods (functions)

A class does **not** occupy memory until an object is created.

---

## 📦 Example (Conceptual)

```text
Class: Student
Properties: name, age, marks
Behaviors: study(), exam()
```

---

## 📌 What is an Object?

An **object** is a **real instance of a class**.

- Objects represent real-world entities
- Objects occupy memory
- Multiple objects can be created from one class

---

## 🧠 Class vs Object

| Class | Object |
|-----|-------|
| Blueprint | Real instance |
| Logical entity | Physical entity |
| No memory allocation | Memory allocated |
| Defined once | Can be created multiple times |

---

## 🛠 Object Creation in Java

Objects are created using the `new` keyword.

```java
ClassName objectName = new ClassName();
```

Example:
```java
Student s1 = new Student();
```

---

## 📌 Components Inside a Class

### 1️⃣ Variables (Fields)
- Store object data
- Represent object state

### 2️⃣ Methods
- Define object behavior
- Perform actions using data

---

## 🧠 Instance Variables vs Local Variables

### Instance Variables
- Declared inside class
- Outside methods
- Each object gets its own copy

### Local Variables
- Declared inside methods
- Exist only during method execution
- No default values

---

## 🗂 Memory Allocation (Basic Idea)

- **Class** → no memory
- **Object** → memory allocated in heap
- **Reference variable** → stored in stack

```text
Student s1 → stack (reference)
new Student() → heap (object)
```

---

## ⭐ Why Classes & Objects Matter

- Help model real-world problems
- Improve code structure
- Enable OOP features like inheritance & polymorphism
- Foundation of Java programming

---

## 📌 Summary

- Class is a blueprint
- Object is an instance of a class
- Objects bring classes to life
- One class → many objects
