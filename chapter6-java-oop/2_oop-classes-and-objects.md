# 🧱 Classes and Objects in Java

## © Class
A Class in Java is a template or blueprint that defines structure and behavior of objects. This class in java consists of fields and variables.

### Example

```java
public class Student
{
    String name;
    int rollNo;
    float marks;
    
    public void display()
    {
    }

    static void main(String[] args) {
    }
}
```

```text
Class = Student;
Attributes = name, rollNo, marks;
Methods = display() and main();
```

---

## 📍 Object
An object is an instance of a class that can access its components such as methods and variables.

Purpose:

- **Reusability** of code.
- **Scalability**.
- **Organization** of code.

---

## 📌 Variables in OOP

There are total of 3 types of variables in java.

## 1. Local Variable.

- A Variable defined within a block of code that be method, constructor, for & if block are considered to be local variables.
- Whose life lasts until the block is executing once execution of that block stops the variable also dies along with it.

## 2. Instance Variable.

- A Variable defined within a class but outside a method are known as Instance variables or non-static variables.
- These variables belong to each individual object of the class and each object has its own unique copy of these variables.
- Life span of Instance variables exists until object dies and is initialized when that object is created.

## 3. Static Variables.
- A Variable which is also a class variable (defined within class but outside method) but is only defined using static keyword.
- A static variable is common for all instances of a class meaning all objects share same static variable and no unique copy of it.
- They are initialized when the class is loaded in the memory and lasts until program execution is completed.

### Example for all variables

```java
public class Student
{
    String name; // instance variable
    int rollNo; // instance variable
    static String college; // static variable
    
    public void display(int a) //local variable
    {
        String studentName; // local variable
    }

    static void main(String[] args) {
        Student s = new Student();
        s.rollNo; // instance Variable accessed
        Student.college; // static variable accessed directly by calling class
    }
}
```

---

## ⛔️ Access Modifiers in Java

There are 4 types of access modifiers in java:

- **Public**.
- **Protected**.
- **Private**.
- **Default**.

### Private = Everyone has access.
### Protected = Sub class and sub package has access.
### Private = Only Access within the class it is declared.
### Private = Access within same package.

| Access Modifiers  | Same Class | Same Package | Sub Class In Other Package | Other Packages | Sub Class in Same Package |
|-------------------| ---------- |--------------| -------------------------- | -------------- | ------------------------- |
| Private           | ✅         | ❌            | ❌         | ❌         | ❌         |
| Default           | ✅         | ✅            | ❌         | ❌         | ✅         |
| Protected         | ✅         | ✅            | ✅         | ❌         | ✅         |
| Public            | ✅         | ✅            | ✅         | ✅         | ✅         |
| Private Protected | ✅         | ❌            | ✅         | ❌         | ✅         |