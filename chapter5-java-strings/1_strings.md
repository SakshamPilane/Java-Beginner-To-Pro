# 🎼 Strings in Java — What They Really Are

A `String` is a sequence of characters. It is the most-used type in Java for text — and the most
misunderstood, because it *looks* like a primitive (`String s = "hi";`) but behaves like an object
with two very unusual rules: it is **immutable**, and identical literals are **shared**.

Get those two rules right and the whole chapter falls into place.

---

## 🧬 A String Is an Object Wrapped Around an Array

```java
public final class String implements CharSequence, Comparable<String> {
    private final byte[] value;   // JDK 9+ (was char[] before)
    private int hash;             // cached hashCode
}
```

Three words in that snippet explain almost everything:

| Word | Consequence |
|------|-------------|
| `final` **class** | You cannot subclass `String`. No one can break its rules. |
| `private final` array | The contents can never be reassigned → **immutability**. |
| cached `hash` | `hashCode()` is computed once → fast `HashMap` keys. |

> 💡 **Everything from Chapter 4 applies here.** A `String` *is* an array underneath. Two pointers,
> frequency arrays, single-pass scans — every array technique comes straight back, which is exactly
> why this chapter follows arrays.

```text
   String s = "Java";

   ┌─────────┐        ┌───────────────────────────┐
   │  s  ────┼───────▶│ String object             │
   └─────────┘        │  value ──▶ ['J','a','v','a'] │
    stack             │  hash  = 2301506          │
                      └───────────────────────────┘
                              heap / SCP
```

---

## 📌 Ways to Create a String

### 1️⃣ String literal — the normal way

```java
String name = "Saksham";
```
Goes into the **String Constant Pool (SCP)**. If `"Saksham"` is already there, **no new object** is
created — the reference points at the existing one.

### 2️⃣ `new String(...)` — almost always wrong

```java
String city = new String("Pune");
```
⚠️ This creates **two** objects: `"Pune"` in the SCP (because the literal is still a literal) **and**
a separate object on the heap. `new String()` guarantees a fresh, non-shared object — which is
exactly what you don't want 99% of the time.

### 3️⃣ From a `char[]` — the pattern all your practice files use

```java
char[] arr = {'J', 'a', 'v', 'a'};
String s = new String(arr);        // "Java"
String t = String.valueOf(arr);    // "Java" — same thing, reads better
```
This is the closing move in `StringCompress.java`, `StringExpand.java`, `StringOrderReversal.java`
and `StringDuplicateRemover.java`: build the answer in a `char[]`, then wrap it once at the end.

> ⚠️ `String.valueOf(charArray)` builds `"Java"`, but `"" + charArray` gives you `[C@1b6d3586` —
> the array's `toString()`. Different methods, wildly different results.

### 4️⃣ Concatenation, `valueOf`, and friends

```java
String a = "Ja" + "va";              // folded at COMPILE time → the literal "Java", pooled
String b = "Ja" + varHoldingVa;      // built at RUNTIME → new heap object, NOT pooled
String c = String.valueOf(42);       // "42"
String d = Integer.toString(42);     // "42"
String e = 42 + "";                  // "42" — works, but the ugliest of the three
```

> 💡 `"Ja" + "va"` where both sides are compile-time constants is resolved by the **compiler**, so
> `("Ja" + "va") == "Java"` is `true`. Add one variable and it becomes `false`. This is the single
> most common trick question about strings.

---

## 🏊 The String Constant Pool (SCP)

A special region inside the heap where literals live, one copy each.

```java
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");
String s4 = s3.intern();
```

```text
                 ┌──────────────── HEAP ────────────────┐
                 │                                       │
   s1 ──────┐    │   ┌─── String Constant Pool ───┐      │
   s2 ──────┼───▶│   │      "Java"  ◀────┐        │      │
   s4 ──────┘    │   └───────────────────┼────────┘      │
                 │                       │ intern()      │
   s3 ───────────┼──▶ "Java" (separate object)           │
                 │                                       │
                 └───────────────────────────────────────┘

   s1 == s2 → true    (same pooled object)
   s1 == s3 → false   (different objects)
   s1 == s4 → true    (intern() returns the pooled one)
   s1.equals(s3) → true (same contents — the only check you should be doing)
```

**Why the pool exists:** text repeats constantly in a program. Sharing one `"Java"` instead of a
thousand copies saves real memory. This is only *safe* because strings are immutable — if one holder
could modify the shared object, every other holder would see the change.

`intern()` manually pushes a string into the pool and hands back the pooled reference. You will
almost never need it; know it for the theory question.

---

## 🔒 Immutability — The Rule That Explains Everything

Once a `String` object exists, its contents can **never** change. Every method that looks like it
modifies a string actually **returns a new one**.

```java
String s1 = "Hello";
s1.concat(" World");
System.out.println(s1);        // Hello   ← unchanged!

s1 = s1.concat(" World");      // ✅ reassign the reference
System.out.println(s1);        // Hello World
```

```text
   BEFORE                        AFTER  s1 = s1.concat(" World")

   s1 ──▶ ┌─────────┐            s1 ─┐   ┌─────────┐
          │ "Hello" │                │   │ "Hello" │  ← still exists, now garbage
          └─────────┘                │   └─────────┘
                                     └──▶┌───────────────┐
                                         │ "Hello World" │
                                         └───────────────┘
```

### The same trap, five different disguises

```java
String s = "  Java  ";
s.trim();              // ❌ result thrown away
s.toUpperCase();       // ❌ result thrown away
s.replace('a', 'o');   // ❌ result thrown away
s.substring(2);        // ❌ result thrown away
System.out.println(s); // "  Java  " — nothing happened

s = s.trim().toUpperCase();   // ✅ this is how you actually use them
```

> ⚠️ **If a `String` method's return value is not assigned, the call did nothing.** No compiler
> error, no warning — just silently unchanged text. This is the #1 String bug for beginners.

### Why Java made strings immutable

| Reason | What it buys |
|--------|--------------|
| **Pool sharing** | One `"Java"` can be safely shared by a thousand references. |
| **Thread safety** | No locks needed — nothing can change mid-read. |
| **Hash caching** | A `HashMap` key whose hash can't change → `hash` computed once (`RemoveDuplicates`-style lookups stay fast). |
| **Security** | A filename/URL/password checked and then passed on can't be swapped underneath you. |
| **Class loading** | Class names are strings; a mutable one would be an open door. |

### The cost of immutability

```java
String result = "";
for (int i = 0; i < 10000; i++) {
    result += i;            // ❌ builds ~10,000 throwaway objects — O(n²)
}
```
Every `+=` copies the entire string so far into a new object. This is **the** performance trap of
the chapter, and the reason `StringBuilder` exists (file 3).

---

## ⚖️ `==` vs `equals()`

```java
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");

s1 == s2            // true  — same pooled object
s1 == s3            // false — different objects, identical contents
s1.equals(s3)       // true  — contents compared, character by character
```

```text
   ==       asks "same OBJECT?"    → compares memory addresses
   equals() asks "same TEXT?"      → compares contents  ✅ use this
```

**Rule: use `equals()` for strings. Always.** `==` on strings only works by accident (when both
happen to be pooled) and fails the moment the text comes from user input, a file, or a network call
— which is exactly when it matters.

```java
Scanner sc = new Scanner(System.in);
String input = sc.nextLine();          // typed "yes"
if (input == "yes")        { }         // ❌ false — input is NOT pooled
if (input.equals("yes"))   { }         // ✅ true
if ("yes".equals(input))   { }         // ✅ true, and NPE-proof if input is null
```

> 💡 `"yes".equals(input)` — literal first — is called the **Yoda comparison**. It can never throw a
> `NullPointerException`, because the literal is never null.

`coding_10/StringCompare.java` implements `equals()` by hand: compare lengths, then walk both
strings with `charAt(i)` and bail on the first mismatch. That is exactly what the real method does.

---

## 🔤 `char` vs `String`

```java
char c = 'J';        // single quotes, ONE character, a primitive (16-bit)
String s = "J";      // double quotes, an OBJECT of length 1
```

| | `char` | `String` |
|---|--------|----------|
| Quotes | `'a'` | `"a"` |
| Kind | primitive | object |
| Compare | `==` ✅ | `equals()` ✅ |
| Empty allowed | ❌ `''` is a compile error | ✅ `""` is fine |

### `char` is a number — use it

Because `char` is an integer type, character arithmetic just works. Every frequency-counting file
you wrote relies on this:

```java
char c = 'a';
int position = c - 'a';          // 0  → the index trick behind int[26] frequency arrays
char upper = (char)(c - 32);     // 'A' — lowercase and uppercase are 32 apart in ASCII
char next  = (char)(c + 1);      // 'b'

int digit = '7' - '0';           // 7   ← char '7' to int 7. NOT (int)'7', which gives 55!
```

```text
   ASCII you actually need:
   '0'–'9'  →  48–57
   'A'–'Z'  →  65–90
   'a'–'z'  →  97–122          ('a' - 'A' == 32)
```

> ⚠️ `(int) '7'` is **55**, not 7. To turn a digit character into its value, subtract `'0'`.
> `StringExpand.java` needs this to read the count out of `"a3b2"`.

```java
char[] chars = str.toCharArray();     // String → char[]   (a fresh copy)
String back  = new String(chars);     // char[] → String
```

---

## 🧵 Escape Sequences

| Escape | Meaning |
|--------|---------|
| `\n` | New line |
| `\t` | Tab |
| `\\` | Backslash |
| `\"` | Double quote |
| `\'` | Single quote |
| `\u0041` | Unicode character (`A`) |

```java
System.out.println("C:\\Users\\Saksham");   // C:\Users\Saksham
System.out.println("She said \"hi\"");      // She said "hi"
```

**Text blocks** (Java 15+) skip all the escaping:

```java
String json = """
        {
          "name": "Saksham",
          "lang": "Java"
        }
        """;
```

---

## 🌍 One Thing About Unicode

`length()` returns the number of **UTF-16 code units**, not the number of characters a human sees.

```java
"Java".length();     // 4  ✅
"🙂".length();       // 2  ⚠️ one emoji, two code units (a surrogate pair)
```

For everything in this chapter — ASCII text, coding-round questions, interview problems — `length()`
and `charAt()` are exactly right. Just know *why* the emoji case is different, because it is a
favourite follow-up question.

---

## 🕳️ `null` vs `""` vs `"   "`

```java
String a = null;    // no object at all — a.length() throws NullPointerException
String b = "";      // a real String, length 0
String c = "   ";   // a real String, length 3

b.isEmpty();        // true   (length == 0)
c.isEmpty();        // false  ← three spaces is not empty
c.isBlank();        // true   (Java 11+: empty OR only whitespace)
```

Guard in this order — short-circuiting means the null check protects the call after it:

```java
if (str != null && !str.isEmpty()) { ... }   // ✅ safe
if (!str.isEmpty() && str != null) { ... }   // ❌ NPE on the first call
```

---

## 🐞 Common Mistakes

| Mistake | What actually happens |
|---------|----------------------|
| `s.toUpperCase();` without assigning | Nothing changes — result discarded |
| `s1 == s2` on user input | `false` even when the text matches |
| `new String("x")` out of habit | Two objects, no pooling, zero benefit |
| `+=` inside a loop | O(n²) and a heap full of garbage |
| `(int) '7'` expecting `7` | Gives `55` — subtract `'0'` instead |
| `str.charAt(str.length())` | `StringIndexOutOfBoundsException` — last index is `length() - 1` |
| Calling a method on a `null` string | `NullPointerException` |
| `''` for an empty char | Compile error — there is no empty `char` |

---

## 🗂️ Where to Practise This

| File | What it drills |
|------|----------------|
| `coding_1/StringBasics.java` | Creation, literals, basic methods |
| `coding_9/StringCopy.java` | Manual copy — proves a copy is a new object |
| `coding_10/StringCompare.java` | `equals()` from scratch — content vs reference |
| `UserDefinedFunctions.java` | `indexOf`, `startsWith`, `endsWith` rebuilt by hand |

---

## 🎯 Key Takeaways

- A `String` is a **final class wrapping a private final array** — that's the whole design.
- **Literals are pooled**, `new String()` is not. `new String()` is a code smell.
- **Immutable**: every "modifying" method returns a new string. **If you don't assign it, nothing
  happened.**
- Immutability buys pooling, thread safety, hash caching and security — and costs you O(n²) if you
  concatenate in a loop.
- `==` compares **objects**, `equals()` compares **text**. Use `equals()`; prefer `"literal".equals(x)`.
- `char` is a 16-bit number — `c - 'a'` and `c - '0'` are the backbone of half this chapter's problems.
- `""` is not `null`, and `"   "` is not empty.
- 👉 Next: **`2_string-methods.md`** — the full toolbox and where each method hides a gotcha.
