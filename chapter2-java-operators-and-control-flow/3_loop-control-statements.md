# 🔁 Loop Control Statements in Java

Loop control statements are used to **execute a block of code repeatedly** until a condition is met.  
They help reduce redundancy and make programs more efficient.

---

## 📌 Types of Loop Control Statements

1. `for` loop
2. `while` loop
3. `do-while` loop
4. **Enhanced for loop (for-each)**
5. **Jump statements** → `break`, `continue`

---

## 1️⃣ for Loop

👉 Executes a block repeatedly, with initialization, condition, and increment/decrement.

### Syntax:
```text
for (initialization; condition; update)
{
    // code to execute
}
```

---

## 2️⃣ while Loop

👉 Runs as long as the condition is true.

### Syntax:
```text
while (condition)
{
    // code to execute
}
```

---

## 3️⃣ do-while Loop

👉 Similar to while loop, but guarantees at least one execution.

### Syntax:
```text
do
{
    // code to execute
} while (condition);
```

---

## 4️⃣ Enhanced for Loop (for-each)

👉 Used to iterate over arrays and collections.

### Syntax:
```text
for (datatype variable : array)
{
    // code using variable
}
```

---

## 5️⃣ Jump Statements

### 🔹 break

👉 Exits the loop immediately.

### Syntax:
```text
for (datatype variable : array)
{
    // code using variable
    break;
}
```

### 🔹 continue

👉 Skips current iteration and moves to next.

### Syntax:
```text
for (datatype variable : array)
{
    // code using variable
    continue;
}
```

---

## 🎯 Key Points

- **for** → best when number of iterations is known
- **while** → best when condition-based looping
- **do-while** → executes at least once
- **for-each** → best for arrays & collections
- **break** → exit loop
- **continue** → skip iteration