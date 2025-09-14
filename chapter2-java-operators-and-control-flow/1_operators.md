# ⚙️ Chapter 2 – Operators in Java

Operators in Java are special symbols that perform operations on **variables and values**.  
They are the building blocks of expressions and help us manipulate data.

---

## 🧮 Types of Operators in Java

### 1. Arithmetic Operators
Used for basic mathematical operations:
- Addition: `+`
- Subtraction: `-`
- Multiplication: `*`
- Division: `/`
- Modulus (Remainder): `%`

---

### 2. Unary Operators
Operate on a single operand:
- Increment: `++`
- Decrement: `--`
- Unary plus/minus: `+` / `-`
- Logical NOT: `!`
- Bitwise Complement: `~`

---

### 3. Relational (Comparison) Operators
Used to compare values:
- Less than: `<`
- Less than or equal to: `<=`
- Greater than: `>`
- Greater than or equal to: `>=`
- Equal to: `==`
- Not equal to: `!=`
- Instance check: `instanceof`

---

### 4. Logical Operators
Work with boolean values:
- AND: `&&`
- OR: `||`
- NOT: `!`

---

### 5. Bitwise Operators
Operate on bits:
- AND: `&`
- OR: `|`
- XOR: `^`
- Complement: `~`
- Left shift: `<<`
- Right shift: `>>`
- Unsigned right shift: `>>>`

---

### 6. Assignment Operators
Used to assign values to variables:
- Basic assignment: `=`
- Add and assign: `+=`
- Subtract and assign: `-=`
- Multiply and assign: `*=`
- Divide and assign: `/=`
- Modulus and assign: `%=`
- Bitwise and assign: `&=`
- Bitwise or assign: `|=`
- Bitwise xor and assign: `^=`
- Left shift and assign: `<<=`
- Right shift and assign: `>>=`
- Unsigned right shift and assign: `>>>=`

---

### 7. Ternary Operator
- Conditional: `? :`  
  Acts as a shorthand for `if-else`.

---

## 🏗️ Operator Precedence in Java

When multiple operators appear in an expression, **precedence** determines the order of evaluation.  
Operators with **higher precedence** are evaluated first. If precedence is the same, **associativity** decides direction.

---

### 📊 Precedence Table

| Precedence (High → Low) | Operators | Associativity |
|--------------------------|-----------|---------------|
| 1 | `()  []  .` | Left to Right |
| 2 | `++  --  +  -  !  ~` | Right to Left |
| 3 | `*  /  %` | Left to Right |
| 4 | `+  -` | Left to Right |
| 5 | `<<  >>  >>>` | Left to Right |
| 6 | `<  <=  >  >=  instanceof` | Left to Right |
| 7 | `==  !=` | Left to Right |
| 8 | `&` | Left to Right |
| 9 | `^` | Left to Right |
| 10 | `|` | Left to Right |
| 11 | `&&` | Left to Right |
| 12 | `||` | Left to Right |
| 13 | `?:` | Right to Left |
| 14 | `=  +=  -=  *=  /=  %=  &=  ^=  |=  <<=  >>=  >>>=` | Right to Left |

---

✅ **Key Takeaways:**
- Parentheses `()` always have the highest precedence.
- Unary operators (`++`, `--`, `!`, `~`) come before arithmetic operators.
- Relational operators (`<`, `>`, `instanceof`) are evaluated before equality (`==`, `!=`).
- Logical operators (`&&`, `||`) come after bitwise operators.
- Assignment has the lowest precedence.

---
