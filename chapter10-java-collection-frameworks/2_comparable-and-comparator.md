# 🔁 Comparable & Comparator in Java

Comparable and Comparator are interfaces used in Java to define object ordering and sorting logic.

They are heavily used in Collections Framework (ArrayList, TreeSet, TreeMap, etc.).

---

# 🔷 1️⃣ Comparable Interface

## 📌 Definition

`Comparable<T>` is an interface that defines the **natural ordering** of objects.

It is present in:

java.lang.Comparable

---

## 🧠 Why We Need Comparable

When objects need to be sorted, Java must know:

- How to compare two objects
- Which one is greater or smaller

Comparable allows the class itself to define its default sorting logic.

---

## ⚙️ Method

```java
int compareTo(T o);
```

Return Value Meaning:

- Negative → Current object < Other object
- Zero → Both objects are equal
- Positive → Current object > Other object

---

## 💡 Example

```java
class Student implements Comparable<Student> {
    int marks;

    Student(int marks) {
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        return this.marks - other.marks;
    }
}
```

Usage:

```java
Collections.sort(studentList);
```

---

## 🔥 Important Points

- Defines **natural ordering**
- Implemented inside the class
- Only one natural ordering allowed
- Used by:
    - Collections.sort()
    - TreeSet
    - TreeMap (for keys)
    - PriorityQueue

---

## ⚠️ Rules to Remember

- compareTo() must be consistent with equals()
- Should not return random values
- Should follow transitive property

---

# 🔷 2️⃣ Comparator Interface

## 📌 Definition

`Comparator<T>` is an interface used to define **custom sorting logic** outside the class.

It is present in:

java.util.Comparator

---

## 🧠 Why We Need Comparator

Sometimes one class needs multiple sorting strategies.

Example: Student can be sorted by:

- Marks
- Name
- Age

Comparable allows only one.
Comparator allows multiple.

---

## ⚙️ Method

```java
int compare(T o1, T o2);
```

Return Value Meaning:

- Negative → o1 < o2
- Zero → Equal
- Positive → o1 > o2

---

## 💡 Example (Anonymous Class)

```java
Comparator<Student> sortByMarks = new Comparator<Student>() {
    public int compare(Student s1, Student s2) {
        return s1.marks - s2.marks;
    }
};
```

Usage:

```java
Collections.sort(studentList, sortByMarks);
```

---

## 💡 Java 8 Lambda Version

```java
Collections.sort(studentList,
    (s1, s2) -> s1.marks - s2.marks);
```

Or using method reference:

```java
studentList.sort(Comparator.comparingInt(s -> s.marks));
```

---

## 🔥 Important Points

- Defines external sorting logic
- Does not modify original class
- Allows multiple sorting criteria
- Used in:
    - Collections
    - Streams
    - PriorityQueue
    - TreeSet (with constructor)

---

# 🔁 Comparable vs Comparator

| Feature | Comparable | Comparator |
|----------|------------|------------|
| Package | java.lang | java.util |
| Method | compareTo() | compare() |
| Defined In | Inside class | Outside class |
| Sorting Type | Natural ordering | Custom ordering |
| Multiple Strategies | ❌ No | ✅ Yes |
| Changes Class Code | ✅ Yes | ❌ No |

---

# 🔍 Internal Working in Collections

If no Comparator is provided:

- TreeSet uses Comparable
- TreeMap uses Comparable for keys
- Collections.sort() uses Comparable

If Comparator is provided:

- It overrides natural ordering

---

# 💥 Common Interview Questions

### Q1. Why is Comparable generic?
To ensure type-safe comparison.

### Q2. Why is Comparator needed if Comparable exists?
To allow multiple sorting strategies without modifying the class.

### Q3. What happens if compareTo() is inconsistent with equals()?
Sorted collections may behave incorrectly.

### Q4. Which is better?
Neither. Use Comparable for natural ordering, Comparator for custom logic.

---

# 📌 One-Line Summary

Comparable defines the natural ordering inside a class, while Comparator defines custom sorting logic externally for flexible and multiple sorting strategies.

---

# ✅ Mastery Checklist

- Understand compareTo()
- Understand compare()
- Know sorting flow in Collections
- Know TreeSet & TreeMap behavior
- Know difference clearly
