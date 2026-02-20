# 📋 List Interface in Java (Collections Framework)

The `List` interface is a part of the Java Collections Framework.

It represents an **ordered collection** (also known as a sequence).

It extends:

Iterable → Collection → List

---

# 🔷 Definition

`List` is an interface that:

- Maintains insertion order
- Allows duplicate elements
- Allows null values (except some implementations)
- Supports index-based access

---

# 🔷 Hierarchy Position

```
Object
   ↑
Iterable
   ↑
Collection
   ↑
List
```

---

# 🔷 Subinterfaces of List

List has the following subinterface:

- None directly in standard JCF

However, `ListIterator` is a specialized iterator for List.

---

# 🔷 Concrete Implementations of List

1️⃣ ArrayList  
2️⃣ LinkedList  
3️⃣ Vector  
4️⃣ Stack (extends Vector)

---

# 🔷 Characteristics of List

✔ Ordered collection  
✔ Allows duplicates  
✔ Allows multiple nulls (except certain cases)  
✔ Index-based operations  
✔ Supports positional access

---

# 🔷 Core Methods of List

Below are the important methods defined in the List interface:

---

## 🔹 Basic Operations

```java
boolean add(E e);
void add(int index, E element);
boolean addAll(Collection<? extends E> c);
boolean addAll(int index, Collection<? extends E> c);

E get(int index);
E set(int index, E element);

E remove(int index);
boolean remove(Object o);

int size();
boolean isEmpty();
void clear();
```

---

## 🔹 Search Operations

```java
boolean contains(Object o);
int indexOf(Object o);
int lastIndexOf(Object o);
```

---

## 🔹 Iteration Methods

```java
Iterator<E> iterator();
ListIterator<E> listIterator();
ListIterator<E> listIterator(int index);
```

---

## 🔹 Bulk Operations

```java
boolean removeAll(Collection<?> c);
boolean retainAll(Collection<?> c);
```

---

## 🔹 Conversion Methods

```java
Object[] toArray();
<T> T[] toArray(T[] a);
```

---

# 🔷 ListIterator (Special Iterator for List)

ListIterator extends Iterator and adds:

```java
boolean hasPrevious();
E previous();
int nextIndex();
int previousIndex();
void set(E e);
void add(E e);
```

Allows:

✔ Forward traversal  
✔ Backward traversal  
✔ Modification during iteration

---

# 🔷 Time Complexity (Generalized)

| Operation | ArrayList | LinkedList |
|------------|------------|-------------|
| get(index) | O(1) | O(n) |
| add(end) | O(1) amortized | O(1) |
| add(index) | O(n) | O(n) |
| remove(index) | O(n) | O(n) |
| contains() | O(n) | O(n) |

---

# 🔷 When to Use List

Use List when:

- Order matters
- Duplicates are allowed
- Index-based access is needed
- Frequent read operations required (ArrayList preferred)

---

# 🔷 Important Design Principles

✔ List allows positional access  
✔ List supports multiple null values  
✔ List maintains insertion order  
✔ Not thread-safe by default (except Vector)

---

# 🔷 Common Mistakes

❌ Thinking List extends Map (it does not)  
❌ Confusing List.of() with ArrayList constructor  
❌ Forgetting that List is interface, not class

---

# 🔷 Interview Questions

Q1. What is difference between List and Set?  
List allows duplicates and preserves order. Set does not allow duplicates.

Q2. Why is List index-based but Set is not?  
Because List maintains sequence ordering.

Q3. Which List implementation is best for frequent reads?  
ArrayList.

Q4. Which List implementation is synchronized?  
Vector (legacy).

---

# 📌 One-Line Summary

List is an ordered, index-based collection that allows duplicates and provides positional access to elements within the Java Collections Framework.

---

# ✅ Mastery Checklist

- Understand List hierarchy
- Know implementations
- Know major methods
- Know performance differences
- Understand ListIterator
- Know when to use ArrayList vs LinkedList