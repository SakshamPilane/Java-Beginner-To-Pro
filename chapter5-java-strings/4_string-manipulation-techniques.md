# 🔧 String Manipulation Techniques

Files 1–3 covered the API. This file covers the **hand-rolled techniques** — what you write when the
question says *"without using inbuilt functions"*, which is most of your `coding-practice` folder.

Every technique here is a Chapter 4 array technique wearing a costume. That is the point.

---

## 🎬 Technique 0 — Get Out of `String` and Into `char[]`

Almost every non-trivial string problem starts the same way:

```java
char[] arr = str.toCharArray();      // now you have a mutable array
// … work in place …
String result = new String(arr);     // wrap it back at the end
```

```text
   String  ──toCharArray()──▶  char[]  ──(mutable, indexable)──▶  new String(arr)  ──▶  String
   immutable                   your playground                     immutable again
```

| Approach | When |
|----------|------|
| `char[]` + in-place edits | Same length in, same length out (reverse, swap, case flip) |
| `char[]` + **write cursor** | Output is **shorter** (remove spaces / vowels / duplicates) |
| `StringBuilder` | Output length is **unknown or longer** (compress, expand, join) |
| `charAt(i)` directly | Read-only scans (count, search, compare) — no copy needed |

> ⚠️ `toCharArray()` allocates a **copy** — O(n) time and memory. Don't call it inside a loop.
> For read-only work, `charAt(i)` is free.

---

## ↔️ Technique 1 — Two Pointers

The workhorse. One pointer at each end, walking inward.

```java
public static String reverse(String str) {
    char[] arr = str.toCharArray();
    int i = 0, j = arr.length - 1;
    while (i < j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
    return new String(arr);
}
```

```text
   J  a  v  a         i=0, j=3   swap
   ▲        ▲
   a  a  v  J         i=1, j=2   swap
      ▲  ▲
   a  v  a  J         i=2, j=1   i < j is false → stop
```

> ⚠️ The loop condition is `i < j`, **not** `i <= j`. With `<=` the middle element of an odd-length
> string swaps with itself — harmless for reversal, but a silent bug in palindrome checks and
> anything that counts swaps.

### Palindrome — the same loop, comparing instead of swapping

```java
public static boolean isPalindrome(String str) {
    int i = 0, j = str.length() - 1;
    while (i < j) {
        if (str.charAt(i) != str.charAt(j)) return false;   // mismatch → done
        i++;
        j--;
    }
    return true;
}
```
No `char[]` needed — nothing is being modified. **O(n) time, O(1) space.**

`coding_2/StringReverse.java` and `LongestPalindrome.java` both live here;
`WordCharacterReversal.reverseWord()` is this exact loop applied to a **sub-range** of the array.

---

## ✍️ Technique 2 — The Write Cursor (In-Place Filtering)

When the output is a **subset** of the input, walk with a read index and a slower write index.
Straight out of Chapter 4.

```java
public static String removeVowels(String str) {
    char[] arr = str.toCharArray();
    int write = 0;                                   // where the next KEPT char goes

    for (int read = 0; read < arr.length; read++) {  // read visits EVERY char
        if (!isVowel(arr[read])) {
            arr[write++] = arr[read];                // keep it
        }
    }
    return new String(arr, 0, write);                // ⚠️ only the first `write` chars are valid
}

static boolean isVowel(char c) {
    char lower = Character.toLowerCase(c);
    return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u';
}
```

```text
   input:  J  a  v  a  S  E
   read ───▶ every position
   write ──▶ only advances on a KEEP

   after:  J  v  S  E │ a  S  E      ← garbage tail left behind
                      ▲
                   write = 4          new String(arr, 0, write) → "JvSE"
```

> ⚠️ **`new String(arr)` would print the stale tail.** The three-arg constructor
> `new String(arr, offset, count)` is what makes this pattern work — `write` is the *logical* length.

This one pattern solves `coding_5/SpacesRemover.java`, `coding_6/VowelsRemover.java`,
`RemoveDuplicates.java` and `StringDuplicateRemover.java` — only the `if` condition changes.

---

## 🔢 Technique 3 — Frequency Arrays

Counting characters with an array indexed **by the character itself**. O(n) time, O(1) space.

```java
int[] freq = new int[256];               // full ASCII — works for any input
for (char c : str.toCharArray()) {
    freq[c]++;                           // char auto-widens to int — this is the whole trick
}
```

```text
   "banana"

   index:   ...  97   98   ...  110  ...
   char:        'a'  'b'       'n'
   count:        3    1         2
```

### Choosing the array size

| Size | Index expression | Use for |
|------|------------------|---------|
| `new int[26]` | `c - 'a'` | Guaranteed lowercase letters only |
| `new int[128]` | `c` | Standard ASCII |
| `new int[256]` | `c` | Extended ASCII — **the safe default** |
| `boolean[256]` | `c` | "Seen it?" only, no counts needed (`RemoveDuplicates.java`) |
| `HashMap<Character,Integer>` | — | Unicode / unbounded (Chapter 10) |

> ⚠️ `new int[26]` with `freq[c - 'a']` **crashes on uppercase, digits and spaces** — `'A' - 'a'` is
> `-32`. Either normalise first (`str = str.toLowerCase()`) or use `int[256]`.

### The two-pass shape

Most frequency problems need **two passes**: count everything, then scan again to answer.

```java
// Pass 1 — count
int[] freq = new int[256];
for (int i = 0; i < str.length(); i++) freq[str.charAt(i)]++;

// Pass 2 — first character whose count is 1, IN ORIGINAL ORDER
for (int i = 0; i < str.length(); i++) {
    if (freq[str.charAt(i)] == 1) return str.charAt(i);
}
return '\0';   // sentinel: no such character
```

> 💡 **Pass 2 must walk the string, not the frequency array.** Walking `freq` gives you the
> alphabetically first match, not the *first-occurring* one. This is the exact bug that separates a
> correct `coding_7/FirstNonRepeating.java` from a plausible-looking wrong one.

Powers `coding_3/StringFrequencyCounter.java`, `coding_7`, `coding_8`, `CharWithMaxFreq.java`,
`AnagramCheck.java` and `RemoveDuplicates.java`.

---

## 🔤 Technique 4 — Character Classification

```java
Character.isLetter(c)         // a–z, A–Z (and Unicode letters)
Character.isDigit(c)          // 0–9
Character.isLetterOrDigit(c)  // alphanumeric
Character.isWhitespace(c)     // space, tab, newline …
Character.isUpperCase(c)
Character.isLowerCase(c)
Character.toLowerCase(c)      // returns a char — the primitive version
Character.toUpperCase(c)
```

The manual equivalents, for when built-ins are banned:

```java
boolean isLower  = (c >= 'a' && c <= 'z');
boolean isUpper  = (c >= 'A' && c <= 'Z');
boolean isDigit  = (c >= '0' && c <= '9');

char toLower = (char)(c + 32);       // ONLY valid if you already know c is uppercase
char toUpper = (char)(c - 32);       // ONLY valid if you already know c is lowercase
char flipped = (char)(c ^ 32);       // XOR flips the case bit either way — Chapter 2's operators
```

```text
   'A' = 0100 0001  (65)
   'a' = 0110 0001  (97)
                ▲
         one bit apart → that bit (value 32) IS the case flag
```

### Turning digit characters into numbers

```java
int value = c - '0';                     // '7' → 7
```

Multi-digit counts need accumulation — this is what `StringExpand.java` needs to handle `"a12"`:

```java
int count = 0;
while (i < s.length() && Character.isDigit(s.charAt(i))) {
    count = count * 10 + (s.charAt(i) - '0');    // 1 → 12 → 123
    i++;
}
```

> ⚠️ Reading only **one** digit is the classic expand bug: `"a12"` becomes `aa` + a stray `2`
> instead of twelve `a`s.

---

## 📝 Technique 5 — Scanning Words Without `split()`

`split("\\s+")` is the easy answer. Doing it manually is faster (no regex, no array of new strings)
and is what the "no inbuilt functions" version demands.

The pattern: an `inWord` flag plus a **sentinel iteration** that runs one step past the end.

```java
char[] arr = str.toCharArray();
int start = 0;
boolean inWord = false;

for (int i = 0; i <= arr.length; i++) {          // ⚠️ note the <= — one extra iteration
    boolean isChar = (i < arr.length) && (arr[i] != ' ');   // guard MUST come first

    if (isChar) {
        if (!inWord) { inWord = true; start = i; }           // word begins here
    } else if (inWord) {                                     // word ends at i - 1
        handleWord(arr, start, i - 1);
        inWord = false;
    }
}
```

```text
   "ab  cd"

   i:  0    1    2    3    4    5    6 ← the sentinel step (i == length)
       a    b    ' '  ' '  c    d    –
       │────┘    │         │────┘    │
       start=0   end at    start=4   end at i-1 = 5
                 i-1 = 1                       ▲
                                     the sentinel is what closes the LAST word
```

**Why the sentinel matters:** without the extra `i == arr.length` iteration, a string that doesn't
end in a space never closes its final word — the same "forgetting the final run" bug from Chapter 4.

**Why `i < arr.length` must come first:** `&&` short-circuits, so `arr[i]` is never evaluated on the
sentinel step. Swap the order and you get an `ArrayIndexOutOfBoundsException`.

> ⚠️ **The `inWord` guard on the `else` branch is not optional.** `WordCharacterReversal.java`
> currently calls `reverseWord(arr, startIndex, i - 1)` on *every* non-letter position, so a
> **double space** re-reverses from the previous `startIndex` and drags a space to the front
> (verified by running it):
>
> ```text
> input "ab cd"   → "ba dc"    ✅ correct
> input "ab  cd"  → " ab dc"   ❌ expected "ba  dc"
> ```
>
> On the second space, `startIndex` is still `0`, so the range `[0, 2]` — the already-reversed
> `"ba "` — gets reversed *again* into `" ab"`. Wrapping the call in `if (inWord)` (and clearing the
> flag inside) fixes it. Single spaces hide the bug completely, which is why it survives casual
> testing.

Used by `CountWords.java`, `LargestWordInString.java`, `SmallestWordInString.java`,
`WordCharacterReversal.java` and `StringOrderReversal.java`.

### Reversing word order — the two-reversal trick

`StringOrderReversal.java` copies words back-to-front. There is a neat O(1)-space alternative worth
knowing:

```text
   "java is fun"

   1. reverse the WHOLE string      →  "nuf si avaj"
   2. reverse EACH WORD in place    →  "fun is java"     ✅
```

Both steps are Technique 1; step 2 is Technique 5 driving `reverseWord(arr, start, end)`. It's the
same pair of helpers you already wrote, composed differently.

---

## 🧮 Technique 6 — Run Detection (Consecutive Groups)

Track the current character and a count; flush when it changes.

```java
char current = str.charAt(0);
int count = 1;
StringBuilder result = new StringBuilder();

for (int i = 1; i < str.length(); i++) {        // ⚠️ start at 1
    if (str.charAt(i) == current) {
        count++;
    } else {
        result.append(current).append(count);   // flush the finished run
        current = str.charAt(i);
        count = 1;
    }
}
result.append(current).append(count);           // ⚠️ flush the LAST run — outside the loop
```

```text
   "aaabbc"

   i=1 'a'==a → count 2
   i=2 'a'==a → count 3
   i=3 'b'!=a → flush "a3", current='b', count=1
   i=4 'b'==b → count 2
   i=5 'c'!=b → flush "b2", current='c', count=1
   loop ends  → flush "c1"          ← WITHOUT this line the output is "a3b2"
   result: "a3b2c1"
```

This is exactly `StringCompress.java`, and it already gets both hard parts right: starting the loop
at `i = 1` after seeding from index 0, and the final flush after the loop.

> 💡 Real compression only helps if the result is shorter. `"abc"` compresses to `"a1b1c1"` — longer!
> Production versions return the original when `compressed.length() >= original.length()`.

---

## 🔁 Technique 7 — Normalise Before Comparing

Many problems are only hard because of case and spacing. Normalise first, compare second.

```java
String clean = str.toLowerCase().replaceAll("[^a-z0-9]", "");
```

```java
// "A man, a plan, a canal: Panama" → "amanaplanacanalpanama" → palindrome ✅
```

The manual, regex-free version is Technique 2 (write cursor) with an
`if (Character.isLetterOrDigit(c))` condition and `Character.toLowerCase(c)` on the way in.

> 💡 `AnagramCheck.java` is normalisation in disguise: two words are anagrams when their
> **frequency arrays** match. Compare `int[256]` counts — O(n) — instead of sorting both, which
> is O(n log n).

---

## 🐞 Common Mistakes

| Mistake | What happens |
|---------|--------------|
| `new String(arr)` after a write-cursor filter | Prints the stale garbage tail |
| Two-pointer loop with `i <= j` | Middle element compared/swapped with itself |
| `freq[c - 'a']` on mixed-case input | Negative index → `ArrayIndexOutOfBoundsException` |
| Scanning `freq[]` instead of the string in pass 2 | Alphabetically first, not first-occurring |
| Missing the final flush after a run loop | Last group silently dropped |
| No sentinel iteration in a word scan | Last word never processed |
| No `inWord` guard on the else branch | Double spaces corrupt the output |
| `arr[i]` before the `i < arr.length` guard | Out of bounds on the sentinel step |
| Reading one digit for a multi-digit count | `"a12"` expands as `"aa"` + junk |
| `toCharArray()` inside a loop | O(n²) from repeated copying |
| `(char)(c - 32)` on an already-uppercase char | Produces punctuation, not a letter |

---

## 🎯 Key Takeaways

- Convert to `char[]`, work in place, wrap back with `new String(arr)` — or `new String(arr, 0, n)`
  when you filtered.
- **Two pointers** (`i < j`) reverse and check palindromes in O(n) time, O(1) space.
- **Write cursor** filters in place; the cursor *is* the logical length.
- **Frequency arrays** are O(n) counting — `int[256]` unless you've proven the input is `a–z`.
  Answer questions about *order* by re-walking the **string**.
- `c - '0'` for digits, `c - 'a'` for indices, `c ^ 32` to flip case.
- **Word scans** need a sentinel iteration *and* an `inWord` guard — both, or the edges break.
- **Run detection** needs the flush after the loop.
- 👉 Next: **`5_string-problem-patterns.md`** — how to recognise which technique a question wants.
