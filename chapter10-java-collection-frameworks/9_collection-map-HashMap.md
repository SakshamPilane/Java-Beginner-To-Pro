# 🗺️ HashMap in Java (Internal Working & Complete Guide)

`HashMap` is a hash-table-based implementation of the `Map` interface.

Package:
java.util.HashMap

---

# 🔷 Definition

HashMap stores data in:

Key → Value pairs

Characteristics:

✔ Keys must be unique  
✔ Values can duplicate  
✔ Allows one null key  
✔ Allows multiple null values  
✔ Not synchronized (not thread-safe)  
✔ Does NOT guarantee order

---

# 🔷 Hierarchy

```
Object
   ↑
AbstractMap
   ↑
HashMap
```

Implements:
- Map
- Cloneable
- Serializable

---

# 🔷 Internal Structure (Java 8+)

HashMap internally uses:

Array of Nodes (Buckets)

```java
transient Node<K,V>[] table;
```

Each bucket may contain:

- Single Node
- Linked List of Nodes (collision)
- Red-Black Tree (if collisions exceed threshold)

---

# 🔷 Node Structure

```java
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;
}
```

Each entry stores:

- Hash value
- Key
- Value
- Next reference (for collision chain)

---

# 🔷 Default Values

Default initial capacity = 16  
Default load factor = 0.75

---

# 🔷 What is Load Factor?

Load Factor determines when resizing happens.

Formula:

Resize when:

```
size >= capacity × loadFactor
```

Example:

Capacity = 16  
Load factor = 0.75

Threshold = 12

When size reaches 12 → resize to 32

---

# 🔷 Resizing Logic

New capacity = old capacity × 2

During resize:

- New array created
- All entries rehashed
- Buckets recalculated

Time complexity = O(n)

---

# 🔷 Hashing Process

When inserting:

1. Compute hashCode() of key
2. Apply hash function
3. Determine bucket index:

```
index = (n - 1) & hash
```

4. Insert entry in bucket
5. Handle collision if needed

---

# 🔷 Collision Handling

If multiple keys map to same index:

Java 7:
→ LinkedList chain

Java 8+:
→ If bucket size ≥ 8
→ Converted to Red-Black Tree

Why?

To improve worst-case performance from O(n) → O(log n)

---

# 🔷 Time Complexity

| Operation | Average | Worst Case |
|------------|----------|-------------|
| put() | O(1) | O(log n) |
| get() | O(1) | O(log n) |
| remove() | O(1) | O(log n) |

Worst case happens during heavy collisions.

---

# 🔷 Core Constructors

```java
HashMap()
HashMap(int initialCapacity)
HashMap(int initialCapacity, float loadFactor)
HashMap(Map<? extends K, ? extends V> m)
```

---

# 🔷 Core Methods

## ➤ Insertion

```java
V put(K key, V value)
void putAll(Map<? extends K, ? extends V> m)
```

---

## ➤ Retrieval

```java
V get(Object key)
boolean containsKey(Object key)
boolean containsValue(Object value)
```

---

## ➤ Removal

```java
V remove(Object key)
boolean remove(Object key, Object value)
```

---

## ➤ Utility

```java
int size()
boolean isEmpty()
void clear()
Set<K> keySet()
Collection<V> values()
Set<Map.Entry<K,V>> entrySet()
```

---

# 🔷 Iteration Example

```java
for (Map.Entry<K,V> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```

---

# 🔷 Important Rules for Keys

Keys must properly override:

✔ equals()
✔ hashCode()

If not:

- Retrieval may fail
- Duplicate logical keys may exist

---

# 🔷 Why equals() & hashCode() Important?

HashMap first uses:

1. hashCode() → to find bucket
2. equals() → to compare keys inside bucket

Both must be consistent.

---

# 🔷 When to Use HashMap

Use when:

- Fast lookup required
- Order not important
- Unique keys needed
- Key-based retrieval required

Avoid when:

- Sorted order needed → Use TreeMap
- Insertion order needed → Use LinkedHashMap
- Thread-safe required → Use ConcurrentHashMap

---

# 🔷 HashMap vs Hashtable

| Feature | HashMap | Hashtable |
|------------|------------|------------|
| Thread-Safe | No | Yes |
| Null Key | 1 allowed | Not allowed |
| Performance | Faster | Slower |
| Legacy | No | Yes |

---

# 🔷 Java 8 Improvement

If bucket size ≥ 8:

LinkedList → Red-Black Tree

Threshold for treeify = 8  
Minimum capacity for treeify = 64

---

# 📌 One-Line Summary

HashMap is a hash-table-based implementation of Map that provides near constant-time performance for put, get, and remove operations using hashing and bucket-based storage.

---

# ✅ Mastery Checklist

- Understand hashing process
- Know load factor
- Know resize logic
- Know collision handling
- Know treeification
- Understand equals() & hashCode()
- Know time complexity
- Know when to use HashMap