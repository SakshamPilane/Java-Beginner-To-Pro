# 📚 Vector & Stack in Java (Collections Framework)

Vector and Stack are legacy classes in the Java Collections Framework.

They are synchronized and were introduced before modern collection classes like ArrayList.

---

# 🔷 1️⃣ Vector in Java

Package:
java.util.Vector

---

# 🔹 Definition

Vector is a dynamic array implementation of List that:

- Maintains insertion order
- Allows duplicates
- Allows null values
- Is synchronized (thread-safe)
- Automatically resizes

Vector is similar to ArrayList but thread-safe.

---

# 🔹 Hierarchy

```
Object
   ↑
AbstractCollection
   ↑
AbstractList
   ↑
Vector
   ↑
Stack
```

Implements:
- List
- RandomAccess
- Cloneable
- Serializable

---

# 🔹 Internal Working

Vector is backed by:

```java
Object[] elementData;
int elementCount;
```

Similar to ArrayList but:

✔ Synchronized methods  
✔ Default growth factor can double capacity

---

# 🔹 Initial Capacity

Default capacity = 10

Custom capacity:

```java
Vector<Integer> v = new Vector<>(20);
```

You can also specify capacity increment:

```java
Vector<Integer> v = new Vector<>(10, 5);
```

- 10 = initial capacity
- 5 = increment step

---

# 🔹 Resizing Logic

If capacity increment not specified:

New Capacity = oldCapacity * 2

If increment specified:

New Capacity = oldCapacity + increment

---

# 🔹 Time Complexity

| Operation | Complexity |
|------------|------------|
| add() | O(1) amortized |
| get(index) | O(1) |
| remove(index) | O(n) |
| contains() | O(n) |

---

# 🔹 Core Methods

## ➤ Add Methods

```java
boolean add(E e)
void addElement(E obj)
```

---

## ➤ Access Methods

```java
E get(int index)
E elementAt(int index)
E firstElement()
E lastElement()
```

---

## ➤ Remove Methods

```java
E remove(int index)
boolean remove(Object o)
void removeElementAt(int index)
void removeAllElements()
```

---

## ➤ Utility Methods

```java
int size()
boolean isEmpty()
void clear()
```

---

# 🔹 Example

```java
Vector<Integer> vector = new Vector<>();
vector.add(10);
vector.add(20);
System.out.println(vector.get(0));
```

---

# 🔹 Why Vector Is Considered Legacy

- All methods are synchronized
- Slower in single-threaded applications
- Replaced by:
    - ArrayList (non-thread-safe)
    - Collections.synchronizedList()

---

# 🔷 2️⃣ Stack in Java

Package:
java.util.Stack

Stack extends Vector.

---

# 🔹 Definition

Stack is a subclass of Vector that represents a Last-In-First-Out (LIFO) data structure.

Stack operations:

- push
- pop
- peek

---

# 🔹 Internal Working

Since Stack extends Vector:

- Backed by dynamic array
- Thread-safe (inherited from Vector)
- Uses top element as last element of Vector

---

# 🔹 Core Stack Methods

```java
E push(E item)
E pop()
E peek()
boolean empty()
int search(Object o)
```

---

# 🔹 Method Usage

## ➤ push()

Adds element to top of stack.

```java
stack.push(10);
```

---

## ➤ pop()

Removes and returns top element.

```java
int value = stack.pop();
```

Throws EmptyStackException if empty.

---

## ➤ peek()

Returns top element without removing.

```java
int top = stack.peek();
```

---

## ➤ empty()

Checks if stack is empty.

---

## ➤ search(Object o)

Returns 1-based position from top.

---

# 🔹 Example

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);

System.out.println(stack.peek()); // 20
System.out.println(stack.pop());  // 20
System.out.println(stack.empty()); // false
```

---

# 🔹 Time Complexity

| Operation | Complexity |
|------------|------------|
| push() | O(1) amortized |
| pop() | O(1) |
| peek() | O(1) |

---

# 🔹 Why Stack Is Legacy

Modern alternative:

```java
Deque<Integer> stack = new ArrayDeque<>();
```

ArrayDeque is preferred because:

✔ Faster  
✔ Not synchronized overhead  
✔ Better design

---

# 🔷 Vector vs ArrayList

| Feature | Vector | ArrayList |
|------------|------------|------------|
| Thread-Safe | Yes | No |
| Performance | Slower | Faster |
| Growth | Double | 1.5x |
| Legacy | Yes | No |

---

# 🔷 Stack vs ArrayDeque

| Feature | Stack | ArrayDeque |
|------------|------------|------------|
| Inherits | Vector | Deque |
| Thread-Safe | Yes | No |
| Recommended | No | Yes |

---

# 📌 When to Use Vector or Stack

Generally avoid unless:

- Maintaining legacy code
- Explicit synchronization required

Modern practice:

✔ Use ArrayList instead of Vector  
✔ Use ArrayDeque instead of Stack

---

# 📌 One-Line Summary

Vector is a synchronized dynamic array implementation of List, and Stack is a LIFO data structure built on top of Vector. Both are legacy classes and generally replaced by modern alternatives like ArrayList and ArrayDeque.

---

# ✅ Mastery Checklist

- Understand Vector vs ArrayList difference
- Know resizing behavior
- Know Stack operations
- Know why they are legacy
- Know modern replacements