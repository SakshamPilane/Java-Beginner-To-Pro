# 🎼 Strings in Java

A String in Java is a sequence of characters.
It is one of the most used data types in Java for handling text.

Unlike primitive types, Strings are objects in Java.

---

## 📌 Ways to Create Strings

### 1. Using String Literals (most common):
```java
String name = "Saksham";
```

### 2. Using new keyword:
```java
String city = "Pune";
```

### 👉 Difference:
- String literals are stored in the String Constant Pool (SCP).
- new String() always creates a new object in the heap.

---

## ✨ Important Features

Immutability: Strings in Java are immutable, meaning once created, they cannot be changed.

Example:
```text
String s1 = "Hello";
s1.concat(" World");  // creates new string
System.out.println(s1);  // Output: Hello
```

#### 👉 The original string doesn’t change, instead a new one is created.
Memory Management:
String Constant Pool (SCP) avoids duplicates → saves memory.
"abc" == "abc" → true (points to same SCP object).
