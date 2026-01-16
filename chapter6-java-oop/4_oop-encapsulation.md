# 🔐 Encapsulation, Getters & Setters in Java

Encapsulation is a **core OOP principle** that helps protect data and control access.
**Getters and Setters** are the primary tools used to achieve encapsulation in Java.

---

## 🧱 Encapsulation in Java

### 📌 What is Encapsulation?

**Encapsulation** means:
> Wrapping data (variables) and methods together  
> and **restricting direct access** to the data.

```text
Encapsulation = Data Hiding + Controlled Access
```

In Java:
- Data is kept **private**
- Access is provided using **public methods**

---

### 🧠 Why Encapsulation is Important?

- Protects data from misuse
- Allows validation before modification
- Improves maintainability
- Makes code flexible and secure
- Industry-standard OOP practice

---

## 🔑 Getters & Setters

### 📌 What are Getters & Setters?

- **Getter** → reads the value of a private variable
- **Setter** → updates the value of a private variable with control

```text
get → read access
set → write access
```

They provide **controlled interaction** with private data.

---

## 🧩 Basic Structure

```java
class Student {
    private int id;
    private String name;

    // Getter
    public int getId() {
        return id;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }
}
```

---

## 📖 Naming Convention (IMPORTANT)

| Variable | Getter | Setter |
|--------|--------|--------|
| name | getName() | setName() |
| age | getAge() | setAge() |
| boolean isActive | isActive() | setActive() |

⚠️ Correct naming is important for **frameworks and interviews**.

---

## 🛡️ Validation Using Setters

Setters allow **business rules and validation**.

```java
public void setAge(int age) {
    if (age > 0) {
        this.age = age;
    }
}
```

✔️ Prevents invalid data  
✔️ Protects object state

---

## 🔍 Read-Only & Write-Only Properties

### 🔒 Read-Only
- Only getter
- No setter

Used for:
- IDs
- Fixed values

---

### ✍️ Write-Only
- Only setter
- No getter

Used for:
- Passwords
- Sensitive data

---

## 🧠 Why Not Use Public Variables?

❌ Public variables:
- No control
- No validation
- Bad design

✅ Private variables + getters/setters:
- Secure
- Flexible
- Professional

---

## 🧠 Getters & Setters vs Direct Access

| Direct Access | Getters/Setters |
|-------------|----------------|
| Unsafe | Controlled |
| No validation | Validation possible |
| Hard to change | Easy to refactor |

---

## 🚀 Real-World Usage

Getters & setters are heavily used in:
- Spring Boot
- Hibernate / JPA
- DTOs
- REST APIs
- Microservices

Frameworks rely on them for:
- Serialization
- ORM mapping
- Dependency injection

---

## 🧠 When NOT to Use Setters (Pro Insight)

Avoid setters when:
- Object should be immutable
- Data must not change after creation

👉 Use **constructors** instead.

---

## 🎯 Interview One-Liners

- “Encapsulation hides data and exposes controlled access.”
- “Getters and setters implement encapsulation.”
- “Setters allow validation and protect object state.”

---

## 🏁 Final Takeaway

- Encapsulation protects data
- Getters & setters provide controlled access
- They are essential for clean OOP
- Mastering them makes your Java code professional
