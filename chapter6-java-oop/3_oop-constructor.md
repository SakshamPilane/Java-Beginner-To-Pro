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

#### EXAMPLE
```java
public class Student{
    Student() // this is non parameterized constructors
    {
    }
}
```

### 2. Arguments / Parameterized Constructors.

A Constructor with **arguments passed to it explicitly during object instantiation** is known as **parameterized constructor**.

#### EXAMPLE
```java
public class Student{
    Student(int a, String abc) // this is parameterized constructors
    {
    }
}
```
---

### There are more types which are special types of constructors.

### 1. Default Constructors.

A class with no explicit constructor provided then **java compiler provides an implicit, public and no argument constructor during compilation**.

### 2. Copy Constructors.

A copy constructor in Java is a special type of constructor that **creates a new object by copying the state of an existing object of the same class**.

#### EXAMPLE
```java
public class Student{
    int id;
    String name;
    Student(int a, String abc) // this is non parameterized constructors
    {
        id = a;
        name = abc;
    }
    
    Student(Student s)
    {
        this.id = s.id;
        this.name = s.name;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
    
    public static void main(String[] args)
    {
        Student s1 = new Student(1,"Saksham");
        Student s2 = new Student(s1); // this is a copy constructor

        s1.display();
        s2.display();
    }
}
```

### 3. Overloaded Constructors.

Constructor overloading is a concept in Java where **a class has multiple constructors with the same name (class name) but with different parameter lists**.

#### EXAMPLE
```java
public class Student{
    int id;
    String name;
    
    Student()
    {
    }
    
    Student(int a) // overloading previous constructor based on parameters passed
    {
        id = a;
    }
    
    Student(int a, String abc) // overloading previous constructors based on parameters passed
    {
        id = a;
        name = abc;
    }
    
    public static void main(String[] args)
    {
        Student s1 = new Student();
        Student s2 = new Student(2);
        Student s3 = new Student(2,"abc");
    }
}
```