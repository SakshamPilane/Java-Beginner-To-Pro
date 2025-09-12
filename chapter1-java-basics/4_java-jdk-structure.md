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

## 🖼️ Block Diagram of Java Structure

```mermaid
graph LR
    %% Main JDK block
    subgraph JDK["**JDK**"]
        JD["**Java Docs**"]
        JDT["**Java Development Tools**"]
        subgraph JRE["**JRE**"]
            JSE["**Java SE**"]
            JCL["**Java Class Libraries**"]
            subgraph JVM["**JVM**"]
                CL["**Class Loader**"]
                BV["**Bytecode Verifier**"]
                subgraph EE["**Execution Engine**"]
                    INT["**Interpreter**"]
                    JIT["**JIT Compiler**"]
                end
                subgraph RDA["**Runtime Data Area**"]
                    MA["**Method Area**"]
                    HEAP["**Heap**"]
                    STK["**Stack**"]
                    PC["**PC Registers**"]
                    NMS["**Native Method Stack**"]
                end
            end
        end
    end

    %% Connections
    JD --> JRE
    JDT --> JRE
    JSE --> JCL
    CL --> BV
    BV --> EE
    EE --> RDA
    JCL --> CL

    %% Styling blocks with colors
    style JD fill:#f9c74f,stroke:#000,stroke-width:2px,color:#000
    style JDT fill:#f9844a,stroke:#000,stroke-width:2px,color:#fff
    style JRE fill:#90be6d,stroke:#000,stroke-width:2px,color:#000
    style JSE fill:#43aa8b,stroke:#000,stroke-width:2px,color:#fff
    style JCL fill:#4d908e,stroke:#000,stroke-width:2px,color:#fff
    style JVM fill:#577590,stroke:#000,stroke-width:2px,color:#fff
    style CL fill:#277da1,stroke:#000,stroke-width:2px,color:#fff
    style BV fill:#f94144,stroke:#000,stroke-width:2px,color:#fff
    style EE fill:#f3722c,stroke:#000,stroke-width:2px,color:#fff
    style INT fill:#f8961e,stroke:#000,stroke-width:2px,color:#000
    style JIT fill:#f9c74f,stroke:#000,stroke-width:2px,color:#000
    style RDA fill:#90be6d,stroke:#000,stroke-width:2px,color:#000
    style MA fill:#43aa8b,stroke:#000,stroke-width:2px,color:#fff
    style HEAP fill:#4d908e,stroke:#000,stroke-width:2px,color:#fff
    style STK fill:#577590,stroke:#000,stroke-width:2px,color:#fff
    style PC fill:#277da1,stroke:#000,stroke-width:2px,color:#fff
    style NMS fill:#f94144,stroke:#000,stroke-width:2px,color:#fff
