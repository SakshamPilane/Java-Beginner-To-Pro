# 🧱 Static Members & Encapsulation in Java

In Java, **static members** belong to the **class**, while **encapsulation** focuses on
**protecting data** by restricting direct access.

Together, they help in writing **efficient, secure, and maintainable** code.

---

# ⚙️ Static Members in Java

Static members are **shared across all objects** of a class.
They belong to the **class itself**, not to individual objects.

---

## 📌 What is `static`?

- `static` is a keyword used to define class-level members
- Static members are created **once**
- They are shared by all objects of the class

```text
Class-level → static
Object-level → non-static
```

---

## 🧠 Why Use Static Members?

- To save memory
- To represent common data
- To create utility methods
- To maintain class-wide information

---

## 🔢 Static Variables

A **static variable** is shared by all objects.

Example use cases:
- Counter for number of objects
- Company name
- College name

```text
One class → One static variable
Many objects → Same static variable
```

---

## 🔧 Static Methods

A **static method**:
- Belongs to the class
- Can be called **without creating an object**
- Can access **only static members directly**

```java
ClassName.methodName();
```

---

## ⚠️ Rules of Static Methods

- Cannot access non-static members directly
- Cannot use `this` keyword
- Can be overloaded
- Can be `main()` method

---

## 📦 Static Block (Intro)

A **static block**:
- Executes **once** when the class is loaded
- Used for initialization

```text
Class loaded → Static block executed
```

---

## 🧠 Static vs Non-Static

| Static | Non-Static |
|------|-----------|
| Belongs to class | Belongs to object |
| Shared among objects | Separate for each object |
| Loaded once | Loaded per object |
| No `this` access | Can use `this` |

---

# 🔐 Encapsulation in Java

**Encapsulation** is the process of **wrapping data and methods together**
and **restricting direct access** to data.

It is one of the **four pillars of OOP**.

---

## 📌 What is Encapsulation?

- Data is hidden using `private`
- Access is controlled using public methods
- Prevents misuse of data

```text
Data hiding + Controlled access = Encapsulation
```

---

## 🧠 Why Encapsulation is Important?

- Improves data security
- Prevents accidental modification
- Improves maintainability
- Makes code flexible and robust

---

## 🔑 Access Modifiers (Quick Overview)

| Modifier | Accessibility |
|--------|--------------|
| private | Same class only |
| default | Same package |
| protected | Package + subclass |
| public | Everywhere |

---

## 🧩 Getters and Setters

Encapsulation is implemented using:
- **Private variables**
- **Public getter and setter methods**

Purpose:
- Validate data
- Read-only or write-only access
- Control how data is modified

---

## 🧠 Encapsulation vs Data Hiding

| Encapsulation | Data Hiding |
|-------------|------------|
| OOP concept | Implementation technique |
| Wraps data + methods | Restricts access |
| Achieved using classes | Achieved using access modifiers |

---

## 🏗️ Real-World Analogy

```text
Capsule
├── Data inside (hidden)
└── Methods to access data
```

---

## ⚠️ Common Mistakes

- Making all variables public
- Not validating data in setters
- Mixing business logic in getters/setters

---

## 🎯 Key Takeaways

- Static members belong to the class, not objects
- Static methods can be called without object creation
- Encapsulation protects data
- Use private variables with public methods
- Static + Encapsulation improve design quality
