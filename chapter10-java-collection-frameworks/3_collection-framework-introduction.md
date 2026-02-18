# 📦 Java Collections Framework (Introduction)

The Java Collections Framework (JCF) is a unified architecture for storing and manipulating groups of objects.

It provides:

- Interfaces (List, Set, Queue, Map)
- Implementations (ArrayList, HashSet, HashMap, etc.)
- Utility algorithms (sorting, searching, reversing, etc.)

---

# 🎯 Why Collections Framework Exists

Before JCF:

- Arrays were used for storing data
- Fixed size
- No built-in dynamic operations
- Manual implementation of data structures

Collections Framework provides:

✔ Dynamic resizing  
✔ Built-in data structures  
✔ Standardized APIs  
✔ Reusable algorithms  
✔ Improved performance

---

# 🧠 Core Components of JCF

The framework consists of:

1️⃣ Interfaces  
2️⃣ Implementation Classes  
3️⃣ Utility Class (`Collections`)

---

# 🔷 1️⃣ Collection Interface (Root Interface)

`java.util.Collection`

It is the root interface for most collection types.

Represents a group of objects.

Subinterfaces:

- List
- Set
- Queue

Important Methods:

- add()
- remove()
- size()
- contains()
- isEmpty()
- iterator()

---

# 🔷 2️⃣ Iterable Interface

`java.lang.Iterable`

Collection extends Iterable.

Why?

To support enhanced for-loop:

```java
for (String s : list) {
    System.out.println(s);
}
```

Iterable provides:

```java
Iterator<T> iterator();
```

Without Iterable, collections could not be used in for-each loops.

---

# 🔷 3️⃣ Map Interface (Separate Hierarchy)

`java.util.Map`

Map is NOT part of Collection interface.

Reason:

Collection stores single elements.  
Map stores key–value pairs.

Structure:

```
Collection
 ├── List
 ├── Set
 └── Queue

Map (separate branch)
```

Map Methods:

- put(K key, V value)
- get(K key)
- remove(K key)
- containsKey()
- containsValue()

---

# 🏗️ Collection Hierarchy Overview

```
Iterable
   ↑
Collection
   ├── List
   │     ├── ArrayList
   │     ├── LinkedList
   │     └── Vector
   │
   ├── Set
   │     ├── HashSet
   │     ├── LinkedHashSet
   │     └── TreeSet
   │
   └── Queue
         ├── PriorityQueue
         └── Deque
               └── ArrayDeque

Map
   ├── HashMap
   ├── LinkedHashMap
   ├── TreeMap
   └── Hashtable
```

---

# 📌 List Interface

Characteristics:

- Ordered
- Allows duplicates
- Index-based access

Common Implementations:

- ArrayList
- LinkedList
- Vector

---

# 📌 Set Interface

Characteristics:

- No duplicate elements
- Not index-based
- Based on hashing or tree structure

Common Implementations:

- HashSet
- LinkedHashSet
- TreeSet

---

# 📌 Queue Interface

Characteristics:

- FIFO (First-In-First-Out)
- Used for processing elements

Common Implementations:

- PriorityQueue
- ArrayDeque

---

# 📌 Map Interface

Characteristics:

- Key–Value pairs
- Unique keys
- Values may duplicate

Common Implementations:

- HashMap
- LinkedHashMap
- TreeMap
- Hashtable

---

# 🔧 Collections Utility Class

`java.util.Collections`

Utility class with static methods:

- sort()
- reverse()
- shuffle()
- binarySearch()
- min()
- max()

Example:

```java
Collections.sort(list);
Collections.reverse(list);
```

---

# 🔥 Important Differences

| Feature | List | Set | Map |
|----------|------|------|------|
| Stores | Values | Values | Key-Value |
| Duplicates | Allowed | Not Allowed | Keys Not Allowed |
| Ordering | Preserved | Depends on Implementation | Depends on Implementation |
| Index Access | Yes | No | No |

---

# 📌 Key Design Principles

- Interfaces define behavior
- Implementations define storage mechanism
- Utility class provides algorithms
- Map kept separate due to key–value structure
- Collection extends Iterable for for-each support

---

# 🧠 Interview Questions

Q1. Why is Map not part of Collection?  
Because Collection represents a group of elements, while Map represents key–value mappings.

Q2. Why does Collection extend Iterable?  
To support enhanced for-loop using iterator().

Q3. What is the difference between Collection and Collections?  
Collection is an interface.  
Collections is a utility class.

Q4. What is the root interface of List and Set?  
Collection.

---

# 📌 One-Line Summary

The Java Collections Framework provides a standardized architecture of interfaces and implementations to efficiently store, retrieve,
