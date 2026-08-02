# 🛠️ String Methods — The Full Toolbox

Every method here **returns a new String** and leaves the original untouched. Read that sentence once
more; it is the source of most bugs in this file.

Methods are grouped by *what you are trying to do*, because that is how you'll reach for them.

---

## 📏 Group 1 — Inspect

| Method | Returns | Example |
|--------|---------|---------|
| `length()` | number of characters | `"Java".length()` → `4` |
| `charAt(i)` | the `char` at index `i` | `"Java".charAt(2)` → `'v'` |
| `isEmpty()` | `length() == 0` | `"".isEmpty()` → `true` |
| `isBlank()` | empty **or** only whitespace (Java 11+) | `"   ".isBlank()` → `true` |
| `toCharArray()` | a fresh `char[]` copy | `"Java".toCharArray()` → `['J','a','v','a']` |
| `hashCode()` | cached content hash | `"Java".hashCode()` → `2301506` |

```text
   String:  "J"  "a"  "v"  "a"
   Index:    0    1    2    3        length() = 4
                                     LAST VALID INDEX = length() - 1 = 3
```

> ⚠️ `length()` is a **method** on a String; `length` is a **field** on an array. `str.length` and
> `arr.length()` are both compile errors — and both get typed constantly.

---

## ✂️ Group 2 — Extract

### `substring(begin)` and `substring(begin, end)`

```java
String s = "Programming";
//          0123456789...

s.substring(3);        // "gramming"   — from index 3 to the end
s.substring(0, 3);     // "Pro"        — begin INCLUSIVE, end EXCLUSIVE
s.substring(3, 7);     // "gram"       — length = end - begin = 4
s.substring(11);       // ""           — begin == length() is legal, gives ""
s.substring(12);       // 💥 StringIndexOutOfBoundsException
```

```text
   P  r  o  g  r  a  m  m  i  n  g
   0  1  2  3  4  5  6  7  8  9  10   11
   ▲        ▲                          ▲
   0        3                          length() = 11 (a valid begin, not a valid charAt)

   substring(0, 3) takes ────┘  →  "Pro"     (end index 3 is NOT included)
```

> 💡 **Same rule as `Arrays.copyOfRange` from Chapter 4**: `end` is exclusive, and the resulting
> length is `end - begin`. Java is consistent about this everywhere.

| Related | Does |
|---------|------|
| `concat(str)` | Joins — but throws NPE on `null`, unlike `+` |
| `repeat(n)` | `"ab".repeat(3)` → `"ababab"` (Java 11+) |
| `strip()` / `trim()` | Removes leading & trailing whitespace |
| `chars()` | Streams the characters as an `IntStream` (Java 8+) |

### `trim()` vs `strip()`

```java
"  Java  ".trim();      // "Java"  — removes anything <= U+0020
"  Java  ".strip();     // "Java"  — Unicode-aware (Java 11+), the modern choice
"  Java  ".stripLeading();    // "Java  "
"  Java  ".stripTrailing();   // "  Java"
```
Both trim only the **ends**. Neither touches spaces in the middle — that's `coding_5/SpacesRemover.java`'s job.

---

## ⚖️ Group 3 — Compare

| Method | Compares | Case-sensitive |
|--------|----------|----------------|
| `equals(str)` | contents | ✅ yes |
| `equalsIgnoreCase(str)` | contents | ❌ no |
| `compareTo(str)` | lexicographic order | ✅ yes |
| `compareToIgnoreCase(str)` | lexicographic order | ❌ no |
| `contentEquals(sb)` | a String against a `StringBuilder` | ✅ yes |

### What `compareTo` actually returns

Not just `-1 / 0 / 1` — it returns a **difference**:

```java
"a".compareTo("b");        // -1   ('a' - 'b' = 97 - 98)
"apple".compareTo("apricot"); // -3 ('p' - 'r' at the first mismatch, index 2)
"Java".compareTo("Java");  //  0   identical
"Java".compareTo("Jav");   //  1   no mismatch → length difference (4 - 3)
"A".compareTo("a");        // -32  uppercase sorts BEFORE lowercase
```

```text
   Rule:  walk both strings together
          ├─ first differing character?  → return  s1.charAt(i) - s2.charAt(i)
          └─ no difference at all?       → return  s1.length()  - s2.length()

   Read the SIGN, not the value:   < 0  → s1 comes first
                                   = 0  → equal
                                   > 0  → s2 comes first
```

> ⚠️ Because `'A'` (65) < `'a'` (97), `"Zebra".compareTo("apple")` is **negative** — capitalised
> words sort before lowercase ones. `compareToIgnoreCase` is usually what you meant.
> `SmallestWordInString.java` / `LargestWordInString.java` sidestep this entirely by comparing
> **lengths**, not order.

---

## 🔍 Group 4 — Search

| Method | Returns | Example |
|--------|---------|---------|
| `contains(str)` | `boolean` | `"Hello".contains("ell")` → `true` |
| `indexOf(str)` | first index, or **`-1`** | `"banana".indexOf("na")` → `2` |
| `indexOf(str, from)` | first index at/after `from` | `"banana".indexOf("na", 3)` → `4` |
| `lastIndexOf(str)` | last index, or `-1` | `"banana".lastIndexOf("na")` → `4` |
| `startsWith(str)` | `boolean` | `"hello".startsWith("he")` → `true` |
| `endsWith(str)` | `boolean` | `"hello".endsWith("lo")` → `true` |
| `matches(regex)` | `boolean`, **whole string** must match | `"abc123".matches("[a-z]+\\d+")` → `true` |

```java
if (str.indexOf("java") > 0)  { }    // ❌ misses a match at index 0!
if (str.indexOf("java") >= 0) { }    // ✅
if (str.contains("java"))     { }    // ✅ clearest
```

> ⚠️ **`indexOf` returns `-1` when not found — never `0`.** Index `0` is a perfectly valid *hit*.
> Compare with `>= 0`, or just use `contains` when you only need yes/no.

`UserDefinedFunctions.java` rebuilds `indexOf`, `startsWith` and `endsWith` by hand — the nested-loop
scan there is exactly the naive substring search covered in file 5. `coding_7/FirstNonRepeating.java`
and `coding_8/FirstRepeating.java` are the same search idea driven by a frequency array instead.

---

## 🔄 Group 5 — Transform

| Method | Example |
|--------|---------|
| `toLowerCase()` | `"JAVA".toLowerCase()` → `"java"` |
| `toUpperCase()` | `"java".toUpperCase()` → `"JAVA"` |
| `replace(a, b)` | `"apple".replace('p', 'b')` → `"abble"` |
| `replace(str, str)` | `"a-b-c".replace("-", "+")` → `"a+b+c"` |
| `replaceAll(regex, s)` | `"a1b2".replaceAll("\\d", "")` → `"ab"` |
| `replaceFirst(regex, s)` | `"a1b2".replaceFirst("\\d", "")` → `"ab2"` |

### ⚠️ `replace` is literal, `replaceAll` is **regex**

Both replace *every* occurrence — the names are misleading. The real difference is how the first
argument is interpreted:

```java
"3.14.15".replace(".", "-");       // "3-14-15"  ✅ literal dot
"3.14.15".replaceAll(".", "-");    // "-------"  💥 '.' is regex for "any character"
"3.14.15".replaceAll("\\.", "-");  // "3-14-15"  ✅ escaped
```

**Rule: reach for `replace` unless you genuinely need a pattern.** `coding_4/CharReplacer.java`
(spaces → `-`) is a `replace` job; `SpacesRemover` and `VowelsRemover` are pure `replaceAll`
territory (`"[aeiouAEIOU]"` → `""`) — though writing them by hand with a `char[]` is the point of the
exercise.

---

## 🪓 Group 6 — Split & Join

```java
"a,b,c".split(",");             // ["a", "b", "c"]
"one two  three".split(" ");    // ["one", "two", "", "three"]  ← double space → empty slot!
"one two  three".split("\\s+"); // ["one", "two", "three"]      ✅ one-or-more whitespace
"Java".split("");               // ["J", "a", "v", "a"]         ← split into characters
```

### The three `split` traps

```java
"a,b,,".split(",");        // ["a", "b"]        ← TRAILING empties are dropped
",a,b".split(",");         // ["", "a", "b"]    ← a LEADING empty is kept
"a,b,,".split(",", -1);    // ["a","b","",""]   ← negative limit keeps everything
"".split(",");             // [""]  length 1    ← NOT an empty array
```

> ⚠️ `split` takes a **regex**. `"a.b".split(".")` returns an empty array, not `["a","b"]`.
> Escape it: `split("\\.")`. Same trap as `replaceAll`.

Splitting on whitespace is how `CountWords.java`, `LargestWordInString.java` and
`SmallestWordInString.java` get their words — though a manual scan (file 4) handles messy spacing
without any regex at all.

### Joining back together

```java
String.join(", ", "a", "b", "c");        // "a, b, c"
String.join("-", listOfStrings);         // works with any Iterable
```

---

## 🎨 Group 7 — Formatting & Conversion

```java
String.format("%s scored %d (%.2f%%)", "Saksham", 87, 87.456);
// "Saksham scored 87 (87.46%)"

"%s is %d".formatted("age", 21);         // Java 15+, same thing as a method
```

| Placeholder | Meaning |
|-------------|---------|
| `%s` | any object / String |
| `%d` | integer |
| `%f` / `%.2f` | float, optionally fixed decimals |
| `%c` | char |
| `%b` | boolean |
| `%n` | platform newline |
| `%%` | a literal `%` |

### Converting to and from String

```java
String s = String.valueOf(42);       // int → "42"   (also handles char[], boolean, double…)
int    i = Integer.parseInt("42");   // "42" → 42    (NumberFormatException if not numeric)
double d = Double.parseDouble("3.14");
char[] c = "Java".toCharArray();
```

> ⚠️ `String.valueOf(null)` does **not** compile to what you expect — the compiler picks the
> `char[]` overload and it throws a `NullPointerException` at runtime. `String.valueOf((Object) null)`
> gives `"null"`. Pure trick-question material.

---

## 🧮 Method Cheat Sheet — Complexity

| Method | Cost | Why |
|--------|------|-----|
| `length()`, `charAt(i)`, `isEmpty()` | **O(1)** | Direct array access |
| `equals`, `compareTo`, `hashCode` (first call) | O(n) | Walks the characters |
| `substring`, `toCharArray`, `toUpperCase`, `replace` | O(n) | Allocates and copies a new string |
| `indexOf`, `contains` | O(n × m) | Naive scan of the haystack for the needle |
| `split` | O(n) + regex overhead | Also allocates the array **and** every piece |
| `s1 + s2` | O(n + m) | A brand-new string each time |

> 💡 **The trap this table exposes:** `substring` inside a loop looks free but allocates every
> iteration. A loop calling `s.substring(i, i + k)` n times is O(n × k), not O(n).

---

## 🐞 Common Mistakes

| Mistake | What happens |
|---------|--------------|
| `s.toUpperCase();` with no assignment | Silently does nothing |
| `str.length` / `arr.length()` | Compile error — field vs method |
| `s.charAt(s.length())` | `StringIndexOutOfBoundsException` |
| `s.substring(2, 100)` | Exception — `end` may not exceed `length()` |
| `indexOf(x) > 0` | Misses a match at index `0` |
| `split(".")` or `replaceAll(".")` | Regex "any character" — not a literal dot |
| Expecting `split` to keep trailing empties | Dropped unless you pass `limit = -1` |
| `==` instead of `equals` | Works in tests, fails on real input |
| `concat(null)` | NPE — `+ null` prints `"null"` instead |

---

## 🗂️ Where to Practise This

| File | Methods it exercises (or reimplements) |
|------|----------------------------------------|
| `coding_1/StringBasics.java` | `length`, `charAt`, `substring`, case conversion |
| `coding_4/CharReplacer.java` | `replace` vs manual `char[]` rewrite |
| `coding_5/SpacesRemover.java` | Filtering characters out |
| `coding_6/VowelsRemover.java` | Conditional filtering |
| `coding_10/StringCompare.java` | `equals` from scratch |
| `UserDefinedFunctions.java` | `indexOf`, `startsWith`, `endsWith` from scratch |
| `CountWords.java` | Word splitting |

---

## 🎯 Key Takeaways

- Every String method **returns a new string** — assign it or lose it.
- `substring(begin, end)`: `end` is **exclusive**, exactly like `Arrays.copyOfRange`.
- `indexOf` returns **`-1`** when absent — compare with `>= 0`, never `> 0`.
- `replace` = literal, `replaceAll` / `split` / `matches` = **regex**. A `.` means "any character".
- `compareTo` returns a **difference**; read its sign, and remember uppercase sorts first.
- `split` drops trailing empty pieces unless you pass a negative limit.
- `substring` and `+` allocate — O(n) each, which becomes O(n²) inside a loop.
- 👉 Next: **`3_stringbuilder-and-stringbuffer.md`** — the fix for that O(n²).
