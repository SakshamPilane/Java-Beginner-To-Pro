# 🔗 LinkedList in Java (Internal Working & Methods)

`LinkedList` is a doubly-linked list implementation of the `List` and `Deque` interfaces.

Package:
java.util.LinkedList

---

# 🔷 Definition

LinkedList is a dynamic data structure where:

- Elements are stored in nodes
- Each node contains:
    - Data
    - Reference to next node
    - Reference to previous node
- Maintains insertion order
- Allows duplicates
- Allows null values

---

# 🔷 Hierarchy Position

```
Object
   ↑
AbstractCollection
   ↑
AbstractList
   ↑
AbstractSequentialList
   ↑
LinkedList
```

Implements:

- List
- Deque
- Queue
- Cloneable
- Serializable

---

# 🔷 Internal Structure

Simplified internal node representation:

```java
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;
}
```

Important fields inside LinkedList:

```java
transient Node<E> first;
transient Node<E> last;
int size;
```

- `first` → head node
- `last` → tail node
- `size` → number of elements

---

# 🔷 Important Characteristics

✔ Doubly linked  
✔ Not circular  
✔ Not backed by array  
✔ No capacity concept  
✔ Not thread-safe

---

# 🔷 Time Complexity

| Operation | Time Complexity |
|------------|----------------|
| add(E e) | O(1) |
| addFirst() | O(1) |
| addLast() | O(1) |
| get(index) | O(n) |
| set(index, e) | O(n) |
| removeFirst() | O(1) |
| removeLast() | O(1) |
| remove(index) | O(n) |
| contains() | O(n) |
| size() | O(1) |

---

# 🔷 Why get(index) is O(n)

LinkedList must traverse nodes:

- From head if index < size/2
- From tail if index > size/2

Traversal required → O(n)

---

# 🔷 Why addFirst() and addLast() are O(1)

Only pointer adjustments:

- No shifting
- No resizing
- Just link updates

---

# 🔷 Core Constructors

```java
LinkedList()
LinkedList(Collection<? extends E> c)
```

---

# 🔷 Core Methods (List Methods)

## ➤ Add Methods

```java
boolean add(E e)
void add(int index, E element)
boolean addAll(Collection<? extends E> c)
boolean addAll(int index, Collection<? extends E> c)
```

---

## ➤ Access Methods

```java
E get(int index)
E set(int index, E element)
E getFirst()
E getLast()
```

---

## ➤ Remove Methods

```java
E remove()
E remove(int index)
boolean remove(Object o)
E removeFirst()
E removeLast()
```

---

## ➤ Queue / Deque Methods

```java
boolean offer(E e)
E poll()
E peek()
void push(E e)
E pop()
```

LinkedList can act as:

✔ Queue  
✔ Deque  
✔ Stack

---

# 🔷 Memory Usage

Each node stores:

- Element
- Next pointer
- Previous pointer

More memory consumption compared to ArrayList.

---

# 🔷 When to Use LinkedList

Use LinkedList when:

- Frequent insertion/deletion at beginning
- Deque operations needed
- Queue implementation required
- Unknown size but heavy modification operations

Avoid when:

- Frequent random access needed
- High-performance read-heavy applications

---

# 🔷 LinkedList vs ArrayList

| Feature | ArrayList | LinkedList |
|------------|------------|-------------|
| Backed By | Dynamic Array | Doubly Linked Nodes |
| get(index) | O(1) | O(n) |
| add(end) | O(1) amortized | O(1) |
| add(start) | O(n) | O(1) |
| Memory Usage | Low | Higher |
| Cache Friendly | Yes | No |

---

# 🔷 Important Notes

✔ No resizing logic  
✔ No capacity concept  
✔ Pointer manipulation heavy  
✔ Traversal required for indexing

---

# 📌 One-Line Summary

LinkedList is a doubly-linked node-based implementation of List and Deque that provides efficient insertion and deletion at the ends but slower random access due to traversal requirements.

---

# ✅ Mastery Checklist

- Understand node structure
- Know head and tail references
- Know time complexities
- Know when to use LinkedList
- Know Deque operations
- Know memory trade-offs