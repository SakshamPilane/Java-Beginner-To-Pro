# 🛠️ Common String Methods
###
| Method                  | Description                      | Example                                  |
| ----------------------- | -------------------------------- | ---------------------------------------- |
| `length()`              | Returns length of string         | `"Java".length() → 4`                    |
| `charAt(i)`             | Returns char at index            | `"Java".charAt(2) → v`                   |
| `substring(start, end)` | Extract substring                | `"Hello".substring(1, 4) → ell`          |
| `toLowerCase()`         | Converts to lowercase            | `"JAVA".toLowerCase() → java`            |
| `toUpperCase()`         | Converts to uppercase            | `"java".toUpperCase() → JAVA`            |
| `trim()`                | Removes spaces at start & end    | `" hello ".trim() → hello`               |
| `equals(str)`           | Checks equality (case-sensitive) | `"Java".equals("java") → false`          |
| `equalsIgnoreCase(str)` | Checks equality ignoring case    | `"Java".equalsIgnoreCase("java") → true` |
| `compareTo(str)`        | Compares lexicographically       | `"a".compareTo("b") → -1`                |
| `contains(str)`         | Checks substring presence        | `"Hello".contains("He") → true`          |
| `replace(a, b)`         | Replace chars/strings            | `"apple".replace('p','b') → abble`       |
| `split(regex)`          | Splits string into array         | `"a,b,c".split(",") → {a,b,c}`           |
| `startsWith(str)`       | Checks prefix                    | `"hello".startsWith("he") → true`        |
| `endsWith(str)`         | Checks suffix                    | `"hello".endsWith("lo") → true`          |

---

## 🔄 Mutable Strings: StringBuilder & StringBuffer

Since String is immutable, Java provides mutable classes:

### 1. StringBuilder (fast, not thread-safe).

```text
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb);  // Hello World
```

### 2. StringBuffer (thread-safe, slower).

```text
StringBuffer sb = new StringBuffer("Hello");
sb.append(" Java");
System.out.println(sb);  // Hello Java
```

---

## ⚡ String Comparison

- Using == → compares reference addresses.
- Using equals() → compares content.

```text
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");

System.out.println(s1 == s2);       // true (SCP reference)
System.out.println(s1 == s3);       // false (heap object)
System.out.println(s1.equals(s3));  // true (content same)
```

---

### 🎯 Key Takeaways

- String is an object in Java.
- Strings are immutable.
- Use StringBuilder/StringBuffer for mutable operations.
- == → reference check, equals() → content check.
- SCP helps save memory by reusing string literals.