# 🔐 Getters & Setters in Java (Beginner → Pro Guide)

**Getters and Setters** are special methods used to **access and modify private data members** of a class.

They are a **core part of Encapsulation** and are heavily used in **real-world Java and backend development**.

---

## 📌 What Are Getters & Setters?

- **Getter** → reads (gets) the value of a variable
- **Setter** → updates (sets) the value of a variable

```text
get → read-only access
set → write access with control
```

---

## 🧠 Why Do We Need Getters & Setters?

In Java, instance variables are usually marked as `private`.

👉 This prevents **direct access** from outside the class.

Getters & setters allow:
- Controlled access
- Data validation
- Read-only or write-only properties
- Better maintainability

---

## 🔐 Encapsulation Connection

```text
Private data + Public methods = Encapsulation
```

Getters and setters are the **standard way** to implement encapsulation.

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

Java follows **strict naming conventions**:

| Variable | Getter | Setter |
|--------|--------|--------|
| name | getName() | setName() |
| age | getAge() | setAge() |
| isActive (boolean) | isActive() | setActive() |

⚠️ Interviewers notice naming mistakes.

---

## 🧠 Why Variables Should Be Private?

❌ Public variables:
- No control
- No validation
- Easy to misuse

✅ Private variables:
- Controlled access
- Secure data
- Flexible future changes

---

## 🛡️ Validation Using Setters (PRO LEVEL)

Setters are powerful because they allow **data validation**.

```java
public void setAge(int age) {
    if (age > 0) {
        this.age = age;
    } else {
        System.out.println("Invalid age");
    }
}
```

✔️ Prevents invalid data  
✔️ Enforces business rules

---

## 🔍 Read-Only & Write-Only Properties

### 🔒 Read-Only
- Only getter
- No setter

```java
public int getId() {
    return id;
}
```

Used when:
- ID should not change
- Sensitive data

---

### ✍️ Write-Only
- Only setter
- No getter

```java
public void setPassword(String password) {
    this.password = password;
}
```

Used for:
- Passwords
- Security fields

---

## 🧠 Getters & Setters vs Direct Access

| Direct Access | Getters/Setters |
|-------------|----------------|
| No validation | Validation possible |
| Poor security | High security |
| Hard to modify | Easy to refactor |
| Bad design | Industry standard |

---

## 🧩 Real-World Analogy

```text
ATM Machine
├── Card Slot (Setter)
├── Screen (Getter)
└── Cash Vault (Private Data)
```

You never touch the cash directly — access is controlled.

---

## ⚠️ Common Beginner Mistakes

- Making variables public
- Writing setters without validation
- Forgetting `this` keyword
- Incorrect method naming
- Adding logic inside getters unnecessarily

---

## 🧠 Performance Myth (Important)

❌ Myth: Getters & setters slow down code  
✅ Truth: JVM optimizes method calls — **no real performance cost**

---

## 🚀 Getters & Setters in Real Projects

Used heavily in:
- Spring Boot
- Hibernate / JPA
- DTOs (Data Transfer Objects)
- REST APIs
- Microservices

Frameworks rely on getters/setters for:
- Serialization
- Dependency injection
- ORM mapping

---

## 🎯 Interview One-Liners

- “Getters and setters provide controlled access to private variables.”
- “They are used to implement encapsulation.”
- “Setters allow validation and business rules.”

---

## 🧠 When NOT to Use Setters (Advanced Insight)

Avoid setters when:
- Object should be immutable
- Values should never change after creation

👉 Use **constructor injection** instead.

---

## 📌 Best Practice Summary

- Always keep variables `private`
- Use getters to expose data safely
- Use setters to validate input
- Follow naming conventions
- Prefer immutability where possible

---

## 🏁 Final Takeaway

- Getters & setters are simple but powerful
- They separate **internal state** from **external access**
- Essential for clean OOP and backend development
- Mastering them makes your code professional

