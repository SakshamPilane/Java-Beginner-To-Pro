# ☕ Structure of Java - JDK, JRE & JVM

Understanding Java’s structure is crucial to know **how your code runs**.  
Java is designed with **layers of abstraction**, just like a processor architecture in textbooks.

---

## 📚 JDK Components

The **Java Development Kit (JDK)** contains everything needed to **develop, compile, and run Java programs**:

- **Java Docs** → Official documentation for developers.
- **Java Development Tools** → Tools like `javac`, `jar`, `jdb`, etc.
- **JRE (Java Runtime Environment)** → Environment to **run Java programs**, includes:
    - **Java SE** → Standard libraries for basic programming.
    - **Java Class Libraries** → Core APIs (Collections, IO, Networking, etc.)
    - **JVM (Java Virtual Machine)** → Executes compiled Java bytecode.

---

## ⚙️ Inside the JVM

The **JVM** is where the magic happens — it executes Java bytecode. Components include:

- **Class Loader** → Loads `.class` files into memory.
- **Bytecode Verifier** → Ensures the loaded bytecode is safe and valid.
- **Execution Engine** → Runs bytecode using:
    - **Interpreter** → Executes instructions one by one.
    - **JIT Compiler** → Compiles bytecode into native machine code for speed.
- **Runtime Data Area** → Memory management and program execution:
    - **Method Area** → Stores class structures and metadata.
    - **Heap** → Stores objects at runtime.
    - **Stack** → Stores method calls and local variables.
    - **PC Registers** → Tracks current instruction.
    - **Native Method Stack** → Handles native code calls.

---

## 🔑 The One-Line Relationship

> **JDK ⊃ JRE ⊃ JVM**  
> The JDK **contains** the JRE, and the JRE **contains** the JVM.

| You have… | You can… |
|-----------|----------|
| **JVM** only | Run bytecode (the engine alone) |
| **JRE** (JVM + libraries) | **Run** Java programs |
| **JDK** (JRE + tools) | **Develop + compile + run** Java programs |

🍱 **Analogy:** Think of a restaurant —
- **JVM** = the *chef* who actually cooks (executes) the dish.
- **JRE** = the *kitchen* (chef + ingredients/utensils) — enough to serve food.
- **JDK** = the *whole restaurant* (kitchen + recipes + staff) — enough to create new dishes.

---

## 🔄 Compile → Run Flow

```
 Hello.java  ──javac──▶  Hello.class (bytecode)  ──JVM──▶  Program runs
  (source)   (JDK tool)      (portable)          (JRE)      (output)
```

- **`javac`** (a JDK tool) compiles source → bytecode.
- **`java`** launches the **JVM**, which loads, verifies, and executes that bytecode.

---

## 🖼️ Block Diagram of Java Structure

![img.png](img.png)

> ✏️ **Editable source:** the diagram above is generated from [`img.puml`](img.puml) (PlantUML).
> To regenerate after editing: `plantuml img.puml` — or paste it into
> [plantuml.com](https://www.plantuml.com/plantuml).