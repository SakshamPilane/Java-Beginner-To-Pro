# 🧩 Java Methods – Basics

A **method** in Java is a **collection of statements** grouped together to perform a specific task.  
It improves **readability, modularity, and reusability** of code.

Every Java application **starts its execution from the `main` method**.
- `main()` acts as the **entry point**.
- It controls the **flow of execution** by calling other methods.
- Those methods then distribute the work of the program.

---

## 📌 Why Use Methods?

- To **increase readability** of code
- To achieve **modularity** (breaking big tasks into smaller tasks)
- To promote **reusability** of logic
- To show **programming skills** by organizing code better

---

## 📥 Passing Values to Methods

Values passed to a method are called **parameters (or arguments)**.

### Syntax:
```text
returnType methodName(parameter1, parameter2, ...)
{
    // statements
}
```
👉 A method can have:
- Zero parameters.
- One parameter.
- Multiple parameters.

The return type of the method must match the type of the value being returned.

---

## 🔄 Dynamic (Variable) Parameters

Sometimes, the number of inputs to a method is not fixed.
In such cases, Java provides varargs (...) to accept a variable number of arguments.

```java
public class VarArgsExample {
    public static void calc(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum = " + sum);
    }

    public static void main(String[] args) {
        calc(10, 20);              // 2 arguments
        calc(5, 15, 25, 35);       // 4 arguments
        calc(100);                 // 1 argument
    }
}
```

👉 Here, int... numbers means the method can accept any number of integers.
Internally, Java treats numbers as an array.

---

## 🔁 Recursive Methods

A recursive method is a method that calls itself.
It is often used to solve problems that can be broken down into smaller sub-problems (e.g., factorial, Fibonacci).

⚠️ A recursive method must have a termination condition (if-else) to prevent infinite recursion.

```java
public class RecursionExample {
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;   // base condition
        } else {
            return n * factorial(n - 1);   // recursive call
        }
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 5 = " + factorial(5));
    }
}
```

---

## 🎯 Key Takeaways
- A method is a block of code designed for a specific task.
- The main() method is the entry point of every Java program. 
- Methods can accept parameters and return values. 
- Use varargs (...) for a dynamic number of parameters. 
- Recursive methods call themselves but must have a base condition.