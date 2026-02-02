# ♻️ Garbage Collection in Java (JVM Internals)

Garbage Collection (GC) in Java is an automatic memory management mechanism provided by the JVM to remove unused objects from heap memory.

It helps Java programs:
- Manage memory safely
- Avoid manual deallocation
- Prevent memory leaks caused by unreachable objects

---

## 📌 What is Garbage Collection?

Garbage Collection is the process by which the JVM:
- Identifies objects that are no longer reachable
- Frees the memory occupied by those objects
- Makes memory available for future allocations

GC is:
- Automatic
- JVM-controlled
- Non-deterministic (execution time not guaranteed)

---

## ❌ What Garbage Collection is NOT

- GC does NOT delete variables
- GC does NOT clean stack memory
- GC does NOT run immediately when an object becomes unused
- GC does NOT guarantee immediate memory release
- GC does NOT work on primitive data types

---

## 🧠 JVM Memory Areas (Important)

```text
JVM Memory
│
├── Stack Memory
│   ├── Method calls
│   ├── Local variables
│   ├── References
│   └── Not handled by GC
│
├── Heap Memory
│   ├── Objects
│   ├── Instance variables
│   └── Garbage Collection works here
│
└── Method Area / Metaspace
    └── Class metadata
```

---

## 🗑️ When is an Object Eligible for Garbage Collection?

An object becomes eligible for GC when it is not reachable from any GC Root.

---

### Common Cases of Eligibility

1) Nullifying Reference

MyClass obj = new MyClass();
obj = null;

---

2) Reassigning Reference

MyClass obj = new MyClass();
obj = new MyClass();   // old object becomes unreachable

---

3) Local Object Goes Out of Scope

void test() {
MyClass obj = new MyClass();
}
// obj goes out of scope after method ends

---

4) Island of Isolation

class A {
A ref;
}

A a1 = new A();
A a2 = new A();

a1.ref = a2;
a2.ref = a1;

a1 = null;
a2 = null;

Objects reference each other but are not reachable, hence eligible for GC.

---

## 🌱 What are GC Roots?

GC Roots are starting points used by the JVM to determine object reachability.

Common GC Roots:
- Local variables in stack frames
- Active threads
- Static variables
- JNI references

If an object is reachable from a GC Root → Alive  
Otherwise → Garbage

---

## 🔍 How JVM Identifies Garbage (Reachability Analysis)

Java uses Reachability Analysis, not reference counting.

Steps:
1) JVM starts from GC Roots
2) Traverses object references
3) Marks reachable objects
4) Unmarked objects are treated as garbage

---

## 🏷️ Mark Phase (Internal Working)

- Each object has a mark flag in its object header
- JVM marks reachable objects
- Unmarked objects are candidates for removal

---

## 🧹 Garbage Collection Algorithms

### Mark and Sweep
1) Mark reachable objects
2) Sweep heap to remove unmarked objects

Drawback:
- Causes memory fragmentation

---

### Mark and Copy (Young Generation)
1) Mark reachable objects
2) Copy them to a new memory region
3) Clear old region

Advantages:
- Fast
- No fragmentation

---

### Mark and Compact (Old Generation)
1) Mark reachable objects
2) Move objects together
3) Compact memory
4) Update references

Advantages:
- Reduces fragmentation

Drawback:
- More expensive operation

---

## ⏸️ Stop-The-World (STW)

During Garbage Collection:
- JVM pauses application threads
- Object graph remains stable
- GC safely removes unreachable objects

Modern garbage collectors aim to minimize pause time.

---

## 🔁 Minor, Major & Full GC

Minor GC:
- Runs on Young Generation
- Frequent

Major GC:
- Runs on Old Generation
- Less frequent

Full GC:
- Runs on entire heap
- Very expensive

---

## ⚙️ System.gc() Method

System.gc();

- Requests garbage collection
- Does NOT force GC
- JVM decides whether to run GC or not

---

## ⚠️ finalize() Method (Deprecated)

protected void finalize() throws Throwable {
}

- Called before object destruction (not guaranteed)
- Runs at most once
- Deprecated since Java 9
- Unreliable

Not recommended.
Use try-with-resources instead.

---

## 💥 StackOverflowError vs Garbage Collection

- StackOverflowError occurs due to deep recursion
- It is an Error, not an Exception
- Garbage Collection does NOT clean stack memory
- JVM terminates execution safely

---

## 🚨 Memory Leaks in Java

Java can still have logical memory leaks.

static List<Object> list = new ArrayList<>();

while (true) {
list.add(new Object());
}

Objects remain reachable, so GC cannot remove them, leading to OutOfMemoryError.

---

## 🧠 Interview Questions & Answers

Q1. Does GC clean stack memory?
No, only heap memory.

Q2. Can we force garbage collection?
No, only request using System.gc().

Q3. What makes an object eligible for GC?
When it becomes unreachable from GC Roots.

Q4. Is finalize() guaranteed to execute?
No.

Q5. Does Java completely prevent memory leaks?
No, logical memory leaks are possible.

---

## 📌 Why Garbage Collection is Important

- Prevents manual memory management
- Avoids dangling pointers
- Improves application stability
- Enables safe multithreading
- Core reason Java is memory-safe

---

## 🧾 One-Line Summary

Garbage Collection in Java is an automatic JVM process that identifies unreachable objects using reachability analysis and frees heap memory to manage application memory safely and efficiently.

---

## ✅ Chapter Completion Checklist

- Object eligibility for GC
- GC Roots
- Reachability analysis
- GC algorithms
- JVM role in GC
- Memory safety understanding
- Interview readiness
