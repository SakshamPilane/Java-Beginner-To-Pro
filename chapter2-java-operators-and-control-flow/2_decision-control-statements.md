# 🚦 Decision Control Statements in Java

Decision control statements allow a program to **take decisions** based on conditions.  
They help control the **flow of execution** by checking conditions and running specific blocks of code.

---

## 📌 Types of Decision Control Statements

1. `if` statement
2. `if-else` statement
3. `if-else-if ladder`
4. `nested if` statement
5. `switch-case` statement

---

## 1️⃣ if Statement

👉 Executes a block only if the condition is **true**.

### Syntax:
```text
if (condition)
{
    // code to execute if condition is true
}
```

---

## 2️⃣ if-else Statement

👉 Provides an alternative block if the condition is false.

### Syntax:
```text
if (condition)
{
    // code if true
}
else
{
    // code if false
}
```

---

## 3️⃣ if-else-if Ladder

👉 Used when there are multiple conditions to check.

### Syntax:
```text
if (condition1)
{
    // code if condition1 is true
} 
else if (condition2)
{
    // code if condition2 is true
}
else if (condition3)
{
    // code if condition3 is true
}
else
{
    // code if none of the conditions are true
}
```

---

## 4️⃣ Nested if Statement

👉 An if inside another if.

### Syntax:
```text
if (condition1)
{
    if (condition2)
    {
        // code if both conditions are true
    }
}
```

---

## 5️⃣ switch-case Statement

👉 Allows selection among multiple options, cleaner than many if-else-if.

⚠️ **Note:**  
Switch cases **cannot** be used with `float`, `double`, `boolean`, and `long`.
- `float` and `double` → precision issues.
- `boolean` → only two values (`true`/`false`), better handled with `if-else`.
- `long` → not supported, as `switch` case labels must fit into the `int` range.

### Syntax:
```text
switch (variable) {
    case value1:
        // code for value1
        break;
    case value2:
        // code for value2
        break;
    ...
    default:
        // code if none match
}
```

---

## 🎯 Key Points

- **if** → Single condition check
- **if-else** → Two possible outcomes
- **if-else-if** → Multiple conditions
- **nested if** → Conditions inside conditions
- **switch-case** → Efficient for multiple fixed values