# 🔄 StringBuilder & StringBuffer — Mutable Text

`String` is immutable, and file 1 showed the price: building text piece by piece creates a new object
every single time. `StringBuilder` is the answer — **one object you keep editing in place**.

---

## 💣 The Problem, Measured

```java
String result = "";
for (int i = 0; i < n; i++) {
    result += "x";          // ❌
}
```

What actually happens on each iteration: allocate a new array of size `i + 1`, copy `i` characters
into it, append one, throw the old string away.

```text
   i=0   ""      → "x"           copy 0 chars
   i=1   "x"     → "xx"          copy 1 char
   i=2   "xx"    → "xxx"         copy 2 chars
   i=3   "xxx"   → "xxxx"        copy 3 chars
                                 ─────────────
   total copies = 0+1+2+…+(n-1) = n(n-1)/2  →  O(n²)
```

| n | `String +=` | `StringBuilder.append` |
|---|-------------|------------------------|
| 1,000 | ~0.5 M char copies | 1,000 appends |
| 10,000 | ~50 M char copies | 10,000 appends |
| 100,000 | ~5 **billion** char copies | 100,000 appends |

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < n; i++) {
    sb.append("x");         // ✅ O(1) amortised each → O(n) total
}
String result = sb.toString();   // one final conversion
```

> 💡 **The rule:** any time you build a string **inside a loop**, use a `StringBuilder`. Outside a
> loop, plain `+` is fine and more readable — the compiler optimises a single expression for you.

---

## 🧱 How It Works Inside

```java
public final class StringBuilder {
    byte[] value;    // NOT final — this is the whole difference
    int count;       // how much of the array is actually used
}
```

`String` has a `final` array (can never change). `StringBuilder` has a **plain** array plus a
`count` — so it can overwrite slots and grow when it runs out.

```text
   new StringBuilder("Hi")        capacity = 2 + 16 = 18

   ┌───┬───┬───┬───┬───┬───┬─── … ───┐
   │ H │ i │   │   │   │   │         │   value[]  (capacity 18)
   └───┴───┴───┴───┴───┴───┴─── … ───┘
     0   1   2
             ▲
           count = 2      ← length() reports this, NOT the capacity
```

### Capacity vs length

```java
StringBuilder sb = new StringBuilder();     // capacity 16, length 0
StringBuilder sb2 = new StringBuilder("Hello");   // capacity 5 + 16 = 21
StringBuilder sb3 = new StringBuilder(1000);      // capacity 1000, length 0

sb.append("Java");
sb.length();      // 4   — characters actually stored
sb.capacity();    // 16  — room currently available
```

When the array fills up, it grows to roughly **double**: `newCapacity = (old << 1) + 2`.
Growing means allocating a bigger array and copying — the same `System.arraycopy` from Chapter 4.

> 💡 If you know the final size, **pre-size it**: `new StringBuilder(n)` skips every resize.
> `StringExpand.java` can pre-size once it knows the total count; `StringCompress.java` can size to
> the input length, since the output is never longer than that (well — almost never; see below).

---

## 🧰 The Method Set

| Method | Does | Example (`sb = "Hello"`) |
|--------|------|--------------------------|
| `append(x)` | Adds to the end — **any** type | `sb.append(" Java")` → `Hello Java` |
| `insert(i, x)` | Inserts at index `i` | `sb.insert(0, ">> ")` → `>> Hello` |
| `delete(start, end)` | Removes `[start, end)` | `sb.delete(1, 3)` → `Hlo` |
| `deleteCharAt(i)` | Removes one character | `sb.deleteCharAt(0)` → `ello` |
| `replace(start, end, str)` | Swaps a range for text | `sb.replace(0, 1, "J")` → `Jello` |
| `reverse()` | Reverses **in place** | `sb.reverse()` → `olleH` |
| `setCharAt(i, c)` | Overwrites one character | `sb.setCharAt(0, 'J')` → `Jello` |
| `charAt(i)` | Reads one character | `sb.charAt(1)` → `'e'` |
| `setLength(n)` | Truncates or pads with `\0` | `sb.setLength(0)` → **clears it** |
| `indexOf(str)` | First index, or `-1` | `sb.indexOf("ll")` → `2` |
| `toString()` | Converts to a real `String` | `sb.toString()` → `"Hello"` |

```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World").append('!').append(42).append(true);
System.out.println(sb);        // Hello World!42true
```

> 💡 Every mutator **returns `this`**, so calls chain. And `append` is overloaded for every primitive
> plus `Object` — `sb.append(42)` needs no conversion.

### Two mutators worth memorising

```java
sb.setLength(0);       // the idiomatic "empty this builder" — reuses the same array
sb.reverse();          // the one-line answer to coding_2, and it is Unicode-correct
```

`coding_2/StringReverse.java` asks you to reverse **without** built-ins — so use the two-pointer
`char[]` swap from file 4. But know that `new StringBuilder(s).reverse().toString()` is the
production answer, and say so in an interview after showing the manual one.

---

## ⚖️ String vs StringBuilder vs StringBuffer

| | `String` | `StringBuilder` | `StringBuffer` |
|---|----------|-----------------|----------------|
| Mutable | ❌ | ✅ | ✅ |
| Thread-safe | ✅ (by immutability) | ❌ | ✅ (`synchronized`) |
| Speed | slow for building | **fastest** | slower (lock overhead) |
| Since | 1.0 | 5.0 | 1.0 |
| Pooled | ✅ SCP | ❌ | ❌ |
| Use when | text is fixed | building text (**default**) | shared across threads |

```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" Java");        // identical API, every method synchronized
```

**Which do I use?** `StringBuilder`, essentially always. A builder is normally a local variable
inside one method — no other thread can even see it, so the locking in `StringBuffer` is pure cost.
Reach for `StringBuffer` only when the same builder is genuinely shared between threads, which is
rare and usually a design smell.

> ⚠️ `StringBuffer` being "thread-safe" is weaker than it sounds. Each *method* is atomic, but a
> sequence like `if (sb.length() > 0) sb.deleteCharAt(0);` is still a race — the check and the
> delete are two separate locks.

---

## 🪄 What `+` Actually Compiles To

```java
String s = a + b + c;
```

- **Java 8 and earlier:** the compiler rewrote this as
  `new StringBuilder().append(a).append(b).append(c).toString()`.
- **Java 9+:** it compiles to an `invokedynamic` call into `StringConcatFactory`, which builds an
  optimised concatenation at runtime — often faster than a hand-written builder for a single
  expression.

Either way, **one expression is optimised for you**:

```java
String s = "Name: " + name + ", Age: " + age;    // ✅ fine — one expression, one pass
```

The optimisation cannot cross a loop boundary, because each iteration is a *separate* expression:

```java
for (...) { s += x; }        // ❌ a NEW builder allocated and discarded every iteration
```

```text
   ONE expression  →  one builder  →  O(n)      ✅
   Loop of +=      →  n builders   →  O(n²)     ❌
```

---

## 🕳️ The `equals` Trap

`StringBuilder` does **not** override `equals()` — it inherits the one from `Object`, which compares
references.

```java
StringBuilder a = new StringBuilder("Java");
StringBuilder b = new StringBuilder("Java");

a.equals(b);                      // false  😱  different objects
a.toString().equals(b.toString()); // true  ✅
"Java".contentEquals(a);          // true  ✅ String vs CharSequence

System.out.println(a);            // "Java" — println calls toString(), which IS overridden
```

> ⚠️ It also has no `hashCode()` override — never use a `StringBuilder` as a `HashMap` key.

---

## 🧵 Related Builders

### `StringJoiner` — separators without the trailing-comma dance

```java
StringJoiner sj = new StringJoiner(", ", "[", "]");
sj.add("a").add("b").add("c");
System.out.println(sj);        // [a, b, c]
```

Compare with the manual version everyone writes first:

```java
StringBuilder sb = new StringBuilder();
for (String s : items) sb.append(s).append(", ");
sb.setLength(sb.length() - 2);      // ⚠️ chop the trailing ", " — and crashes if items is empty
```

`String.join(", ", items)` is the one-liner when you don't need prefix/suffix.

---

## 🐞 Common Mistakes

| Mistake | What happens |
|---------|--------------|
| `+=` in a loop | O(n²) and heavy garbage |
| Forgetting `.toString()` | Passing a `StringBuilder` where a `String` is required |
| `sb1.equals(sb2)` | Reference comparison — almost always `false` |
| `sb.delete(1, 3)` expecting 3 chars gone | `end` is **exclusive** — only 2 removed |
| `sb.setLength(0)` vs `sb = new StringBuilder()` | Both work; `setLength(0)` reuses the array |
| Using `StringBuffer` "to be safe" | Pure lock overhead for a local variable |
| `sb.length()` vs `sb.capacity()` | Length = content, capacity = room |
| Chopping a trailing separator without a length check | `StringIndexOutOfBoundsException` on empty input |

---

## 🗂️ Where to Practise This

| File | Why a builder fits |
|------|--------------------|
| `StringCompress.java` | Appending `char + count` groups one at a time |
| `StringExpand.java` | Repeating a character `n` times, unknown total length |
| `StringDuplicateRemover.java` | Appending only first-seen characters |
| `coding_2/StringReverse.java` | Manual two-pointer first — then compare with `reverse()` |
| `WordCharacterReversal.java` | Rebuilding a sentence word by word |

> 💡 Several of these files build into a `char[]` with a write cursor instead of a builder. That is
> **the same idea one level down** — the write-cursor pattern from Chapter 4 *is* what
> `StringBuilder` does internally. Writing it by hand once is the point; using the builder is what
> you'd ship.

---

## 🎯 Key Takeaways

- `String` is immutable → building in a loop is **O(n²)**. `StringBuilder` makes it **O(n)**.
- A builder is a **non-final array + a count** — that one missing `final` is the whole difference.
- Default capacity **16** (or `text.length() + 16`); it doubles on overflow. **Pre-size when you know
  the length.**
- `StringBuilder` (fast, unsynchronised) is the default. `StringBuffer` only for genuine cross-thread sharing.
- One `+` expression is already optimised by the compiler — only **loops** need a builder.
- `delete(start, end)`: `end` exclusive, like everything else in Java.
- `StringBuilder.equals()` compares **references** — call `.toString()` first.
- 👉 Next: **`4_string-manipulation-techniques.md`** — the hand-rolled techniques your practice files use.
