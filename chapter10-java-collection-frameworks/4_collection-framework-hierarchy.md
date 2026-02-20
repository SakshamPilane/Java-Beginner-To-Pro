# 🌳 Java Collections Framework – Complete Hierarchy Tree

The Java Collections Framework consists of:

- Interfaces
- Implementation Classes
- Utility Classes
- Iteration Interfaces

---

# 🔷 ROOT LEVEL

Object (Root of all classes & interfaces)

---

# 🔷 ITERATION BRANCH
```text
Iterable (interface)
└── Collection (interface)
├── List (interface)
│      ├── ArrayList (class)
│      ├── LinkedList (class)
│      └── Vector (class)
│            └── Stack (class)
│
├── Set (interface)
│      ├── HashSet (class)
│      │      └── LinkedHashSet (class)
│      └── SortedSet (interface)
│             └── NavigableSet (interface)
│                     └── TreeSet (class)
│
└── Queue (interface)
├── Deque (interface)
│      ├── ArrayDeque (class)
│      └── LinkedList (class)
└── PriorityQueue (class)
```

---

# 🔷 MAP BRANCH (Separate from Collection)

```text
Map (interface)
├── HashMap (class)
│      └── LinkedHashMap (class)
├── SortedMap (interface)
│      └── NavigableMap (interface)
│              └── TreeMap (class)
└── Hashtable (class)
```
Important:
Map does NOT extend Collection.
Map stores key–value pairs, not single elements.

---

# 🔷 ITERATOR BRANCH (Separate)
```text
Iterator (interface)
├── ListIterator (interface)
└── Spliterator (interface, Java 8+)
```

**Collection extends Iterable** provides:
**Iterator<T> iterator()**

Map does NOT extend Iterable directly,
but:
- map.keySet()
- map.values()
- map.entrySet()

return Collection types, so they are Iterable.

---

# 🔷 UTILITY CLASS

Collections (final utility class)
- sort()
- reverse()
- shuffle()
- binarySearch()
- min()
- max()

Note:
Collections is NOT part of hierarchy.
It is a utility class with static methods.

---

# 🔷 SPECIAL NOTES

✔ Collection extends Iterable  
✔ List, Set, Queue extend Collection  
✔ Map is separate branch  
✔ LinkedList implements both List & Deque  
✔ Stack extends Vector  
✔ LinkedHashMap extends HashMap  
✔ LinkedHashSet extends HashSet  
✔ TreeSet implements NavigableSet  
✔ TreeMap implements NavigableMap

---

# 🔷 VISUAL SUMMARY

```text
Collections Framework
│
├── Iterable
│     └── Collection
│            ├── List
│            ├── Set
│            └── Queue
│
├── Map (separate branch)
│
├── Iterator (separate branch)
│
└── Collections (utility class)
```