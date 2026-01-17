# 🔌 Interfaces in Java

An **interface** in Java is a **contract** that defines **what a class can do**, not **how it does it**.

Interfaces are a core part of **abstraction and polymorphism** and are heavily used in **real-world Java applications**.

---

## 📌 What is an Interface?

An interface is a blueprint that contains:
- Abstract methods (by default)
- Constants (public static final)

```text
Interface = Capability / Behavior
```

It answers:
> “What actions can this object perform?”

---

## 🧠 Why Do We Need Interfaces?

Interfaces are used to:
- Achieve **100% abstraction**
- Support **multiple inheritance**
- Enable **loose coupling**
- Define **common behavior** across unrelated classes
- Build **scalable and maintainable systems**

---

## 🧩 Basic Interface Syntax

```java
interface Playable {
    void play();
}
```

Key points:
- Methods are implicitly `public` and `abstract`
- No method body (before Java 8)
- No constructors

---

## 🧱 Implementing an Interface

A class uses the `implements` keyword:

```java
class Guitar implements Playable {
    public void play() {
        System.out.println("Guitar plays");
    }
}
```

Rules:
- A class **must implement all methods** of the interface
- Otherwise, the class must be declared `abstract`

---

## 🔄 Interface-Based Polymorphism

```text
Playable p;

p = new Guitar();
p.play();

p = new Radio();
p.play();
```

✔ Same reference type  
✔ Different object types  
✔ Method call decided at runtime

This is **runtime polymorphism using interfaces**.

---

## 🧠 Interface vs Abstract Class (Quick Comparison)

| Interface | Abstract Class |
|--------|---------------|
| Supports multiple inheritance | Supports single inheritance |
| All methods abstract (pre-Java 8) | Can have abstract + concrete |
| No constructors | Can have constructors |
| Used for capabilities | Used for base classes |

---

## 🔑 When to Use Interface vs Inheritance

### Use **interface** when:
- Classes are **unrelated**
- You want to define a **capability**
- Multiple inheritance is required

Example:
```text
Guitar, Radio, VideoPlayer → CAN play
```

---

### Use **inheritance** when:
- There is an **IS-A relationship**
- Classes share common state + behavior

Example:
```text
Car IS-A Vehicle
Bike IS-A Vehicle
```

---

## 🧠 Real-World Analogy

```text
Remote Control (Interface)
 ├── TV
 ├── AC
 └── Music System
```

Different devices, same action → `operate()`

---

## ⚠️ Rules of Interfaces (IMPORTANT)

- Interface variables are `public static final`
- Interface methods are `public abstract` by default
- Cannot create objects of interface
- A class can implement **multiple interfaces**
- Interface can extend another interface

---

## 🔁 Multiple Inheritance Using Interfaces

```java
interface Walkable {
    void walk();
}

interface Runnable {
    void run();
}

class Human implements Walkable, Runnable {
    public void walk() {}
    public void run() {}
}
```

✔ Java allows multiple inheritance via interfaces  
❌ Java does NOT allow multiple inheritance via classes

---

## ✨ Default Methods (Java 8+)

Interfaces can have **default methods** with implementation:

```java
interface Playable {
    default void start() {
        System.out.println("Starting...");
    }
}
```

Purpose:
- Backward compatibility
- Optional behavior

---

## ✨ Static Methods in Interfaces

```java
interface Utils {
    static void help() {
        System.out.println("Helping...");
    }
}
```

- Belong to interface itself
- Called using interface name

---

## ❌ Common Beginner Mistakes

- Forgetting to implement all methods
- Using `extends` instead of `implements`
- Expecting constructors in interfaces
- Trying to create object of interface
- Confusing interface with abstract class

---

## 🎯 Interview One-Liners

- “Interfaces define what a class can do.”
- “Interfaces support multiple inheritance.”
- “Interfaces are used for abstraction and polymorphism.”
- “Interfaces define behavior, not state.”

---

## 🚀 Interfaces in Real Projects

Used heavily in:
- Spring Framework
- REST APIs
- Microservices
- Dependency Injection
- Plugin systems

Frameworks depend on interfaces for:
- Loose coupling
- Testing (mocking)
- Flexibility

---

## 🏁 Final Takeaways

- Interface defines **behavior**
- Classes implement interfaces
- Supports multiple inheritance
- Enables clean runtime polymorphism
- Essential for professional Java development
