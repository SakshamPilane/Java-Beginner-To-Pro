# 📦 ArrayList in Java (Internal Working & Methods)

`ArrayList` is a resizable array implementation of the `List` interface.

Package:
java.util.ArrayList

---

# 🔷 Definition

ArrayList is a dynamic array that:

- Maintains insertion order
- Allows duplicates
- Allows null values
- Provides index-based access
- Resizes automatically when capacity is exceeded

---

# 🔷 Hierarchy Position

```
Object
   ↑
AbstractCollection
   ↑
AbstractList
   ↑
ArrayList
```

Implements:
- List
- RandomAccess
- Cloneable
- Serializable

---

# 🔷 Internal Structure

Inside ArrayList:

```java
transient Object[] elementData;
private int size;
```

- `elementData` → stores elements
- `size` → number of actual elements
- Capacity → length of elementData array

---

# 🔷 Initial Capacity

When created using:

```java
new ArrayList<>();
```

- Initial capacity allocated lazily
- First insertion triggers capacity of 10 (default)

Custom capacity:

```java
new ArrayList<>(20);
```

---

# 🔷 Capacity vs Size

- Size → number of elements currently stored
- Capacity → maximum elements array can hold before resizing

Example:

Size = 11  
Capacity = 15

---

# 🔷 Dynamic Resizing Logic

When array becomes full:

New Capacity = oldCapacity + (oldCapacity / 2)

Growth factor = 1.5x

Example:

10 → 15  
15 → 22  
22 → 33

---

# 🔷 Resize Process

1. Create new larger array
2. Copy old elements using System.arraycopy()
3. Assign new array reference
4. Add new element

Resize complexity = O(n)

---

# 🔷 Time Complexity

| Operation | Complexity |
|------------|------------|
| add(E e) | O(1) amortized |
| add(index, e) | O(n) |
| get(index) | O(1) |
| set(index, e) | O(1) |
| remove(index) | O(n) |
| remove(Object o) | O(n) |
| contains() | O(n) |
| size() | O(1) |
| clear() | O(n) |

---

# 🔷 Core Methods in ArrayList

## ➤ Constructors

```java
ArrayList()
ArrayList(int initialCapacity)
ArrayList(Collection<? extends E> c)
```

---

## ➤ Add Operations

```java
boolean add(E e)
void add(int index, E element)
boolean addAll(Collection<? extends E> c)
boolean addAll(int index, Collection<? extends E> c)
```

---

## ➤ Access Operations

```java
E get(int index)
E set(int index, E element)
```

---

## ➤ Remove Operations

```java
E remove(int index)
boolean remove(Object o)
void clear()
```

---

## ➤ Search Operations

```java
boolean contains(Object o)
int indexOf(Object o)
int lastIndexOf(Object o)
```

---

## ➤ Utility Methods

```java
int size()
boolean isEmpty()
Object[] toArray()
<T> T[] toArray(T[] a)
void ensureCapacity(int minCapacity)
void trimToSize()
```

---

# 🔷 Important Internal Concepts

✔ Backed by Object[] array  
✔ Uses type casting internally due to type erasure  
✔ Not synchronized (not thread-safe)  
✔ Faster for read operations  
✔ Slower for middle insertion/removal

---

# 🔷 Why ArrayList Is Fast for Reading

- Direct index access
- Contiguous memory
- No traversal required

---

# 🔷 Why ArrayList Is Slow for Middle Insert/Remove

- Requires shifting elements
- Uses System.arraycopy()
- O(n) time complexity

---

# 🔷 When to Use ArrayList

- Frequent reads
- Index-based access required
- Order matters
- Duplicates allowed
- Unknown size but growing dynamically

---

# 📌 One-Line Summary

ArrayList is a dynamic array-backed implementation of List that provides fast random access and amortized constant-time addition but requires shifting elements for middle insertions or deletions.

---

# ✅ Mastery Checklist

- Understand capacity vs size
- Know resize formula
- Know amortized complexity
- Know core methods
- Understand internal Object[] usage
- Know performance trade-offs