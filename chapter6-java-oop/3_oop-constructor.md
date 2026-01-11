# 🧱 Constructors in Java

- **Constructors** in java is a special type of method which is not exactly a method but is used to **initialize objects within a class**.
- Constructors has **same name as class name**.
- It does not have a **return type**.
- Constructor is **not inherited** by subclasses.
- **Can be Overloaded**.

### Example:
```java
public class Student
{
    public Student() // constructor
    {
        System.out.println("In Class Student");
    }
    public void display()
    {
        System.out.println("In Display Method");
    }

    static void main(String[] args) {
        Student s = new Student(); // called constructor Student();
        s.display();
    }
}
```

---

## 📌 Types of Constructors

### There are total **2 primary types** of constructors

### 1. No Arguments / Non Parameterized Constructors.

A Constructor with **no arguments passed to it explicitly during object instantiation** is known as **non parameterized constructor**.

### 2. Arguments / Parameterized Constructors.

A Constructor with **arguments passed to it explicitly during object instantiation** is known as **parameterized constructor**.

---

### There are more types which are special types of constructors.

### 1. Default Constructors.

A class with no explicit constructor provided then **java compiler provides an implicit, public and no argument constructor during compilation**.

### 2. Copy Constructors.

A copy constructor in Java is a special type of constructor that **creates a new object by copying the state of an existing object of the same class**.

### 3. Overloaded Constructors.

Constructor overloading is a concept in Java where **a class has multiple constructors with the same name (class name) but with different parameter lists**.
