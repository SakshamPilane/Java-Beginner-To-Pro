# 🏗️ Constructors & `this` Keyword in Java

A **constructor** is a special block of code used to **initialize objects**.
It is automatically called **when an object is created**.

Constructors are mainly used to **set initial values** for object variables and ensure
that objects start their life in a valid and meaningful state.

The **`this` keyword** is closely related to constructors and is used to refer to the
**current object**.

---

## 📌 What is a Constructor?

- A constructor has the **same name as the class**
- It does **not have a return type** (not even `void`)
- It is called **automatically** during object creation
- It runs **only once per object**

```text
Class Name = Constructor Name
```

---

## 🧠 Why Do We Need Constructors?

- To initialize instance variables
- To ensure objects are created with valid data
- To avoid repetitive setter calls
- To control how objects are created
- To improve code readability and safety

---

## 🧩 Basic Constructor Syntax

```java
class ClassName {
    ClassName() {
        // initialization code
    }
}
```

Object creation:
```java
ClassName obj = new ClassName();
```

---

## 🟢 Default Constructor

A **default constructor**:
- Takes **no parameters**
- Is provided automatically by Java **if no constructor is written**
- Initializes variables with default values

### Default Values:
```text
int      → 0
double   → 0.0
boolean  → false
String   → null
```

👉 Once you define **any constructor**, Java **does not** provide the default constructor automatically.

---

## 🟡 User-Defined / Non-Parameterized / No-Argument Constructor

When a programmer explicitly writes a constructor, it is called a **user-defined constructor**.

Purpose:
- Assign custom initial values
- Enforce required data at object creation
- Add logic during object initialization

---

## 🔄 Parameterized Constructor (Argument Constructor)

A **parameterized constructor** accepts parameters to initialize objects with custom values.

Example usage:
```java
ClassName obj = new ClassName(value1, value2);
```

### Benefits:
- Eliminates unnecessary setter calls
- Ensures object completeness
- Improves object consistency

---

## 🔁 Constructor Overloading

**Constructor Overloading** means defining **multiple constructors** in the same class
with **different parameter lists**.

This allows objects to be created in **multiple ways**.

---

## 📌 What Changes in Overloading?

- Constructor name remains the same (class name)
- Parameters differ in:
    - Number
    - Type
    - Order

❌ Return type is not considered.

---

## 🧠 Why Use Constructor Overloading?

- To provide flexibility in object creation
- To handle optional or partial data
- To improve API usability
- To support multiple initialization scenarios

---

## 🧩 Conceptual Example

```text
Student()
Student(String name)
Student(String name, int age)
Student(String name, int age, double marks)
```

Each constructor initializes the object differently.

---

## 🔑 The `this` Keyword in Java

The **`this` keyword** is a reference variable that refers to the **current object**.

It is commonly used in:
- Constructors
- Methods
- Constructor chaining

---

## 📌 Why `this` Keyword is Needed?

- To differentiate **instance variables** from **local variables**
- To refer to the current object
- To call another constructor in the same class
- To pass the current object as an argument

---

## 🧠 `this` to Differentiate Variables

When instance variables and constructor parameters have the same name,
`this` is used to avoid confusion.

```text
this.variable → instance variable
variable      → local variable
```

---

## 🔗 Constructor Chaining Using `this()`

One constructor can call another constructor **within the same class** using `this()`.

### Rules:
- `this()` must be the **first statement** in the constructor
- Used to avoid code duplication
- Improves maintainability

```text
Constructor A → calls Constructor B → Object Created
```

---

## 🧠 `this()` vs `super()` (Intro)

| this() | super() |
|------|---------|
| Calls constructor of same class | Calls constructor of parent class |
| Used in constructor overloading | Used in inheritance |
| First statement only | First statement only |

---

## ⚠️ Important Rules of Constructors

- Constructors cannot be `static`
- Constructors cannot be `abstract`
- Constructors are **not inherited**
- A class can have **multiple constructors**
- Constructor overloading is allowed
- Access modifiers can differ

---

## 📌 Execution Flow

```text
new keyword
   ↓
Constructor call
   ↓
this keyword binds object
   ↓
Object creation
   ↓
Memory allocation in heap
```

---

## 🎯 Key Takeaways

- Constructors initialize objects
- Constructor overloading allows flexible object creation
- `this` refers to the current object
- `this()` helps in constructor chaining
- Constructors + `this` are core to clean Java OOP design