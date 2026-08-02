# 🧩 String Problem Patterns

Almost every string question in an interview or coding round is one of **nine patterns**. Name the
pattern before you write a line of code — that single habit is the difference between "I've seen this"
and "I'm brute-forcing it."

---

## 1️⃣ Frequency Count

**Signals:** "count", "duplicate", "repeating", "anagram", "most frequent", "unique".

```java
int[] freq = new int[256];
for (int i = 0; i < str.length(); i++) freq[str.charAt(i)]++;
```

Then answer from the table. **O(n) time, O(1) space.**

| Question | Pass 2 |
|----------|--------|
| Character frequencies | Print `freq[i]` where `> 0` |
| First **non**-repeating | Walk the **string**, first `freq[c] == 1` |
| First repeating | Walk the **string**, first `freq[c] > 1` |
| Most frequent | Walk `freq`, track the max |
| Anagram? | Build both tables, compare — or `freq[c]++` for s1, `freq[c]--` for s2, then all zeros |
| Remove duplicates | `boolean[] seen` + write cursor |

```java
// Anagram in ONE array — increment for s1, decrement for s2
if (s1.length() != s2.length()) return false;        // ⚡ free early exit
int[] freq = new int[256];
for (int i = 0; i < s1.length(); i++) {
    freq[s1.charAt(i)]++;
    freq[s2.charAt(i)]--;
}
for (int f : freq) if (f != 0) return false;
return true;
```

> ⚠️ **Order questions need the string, not the table.** "First non-repeating" walking `freq[]`
> returns the alphabetically smallest one. Walk the original string in pass 2.

📁 `coding_3`, `coding_7`, `coding_8`, `CharWithMaxFreq.java`, `AnagramCheck.java`,
`RemoveDuplicates.java`, `StringDuplicateRemover.java`

---

## 2️⃣ Two Pointers

**Signals:** "reverse", "palindrome", "from both ends", "swap".

```java
int i = 0, j = str.length() - 1;
while (i < j) {
    // compare or swap arr[i] and arr[j]
    i++;
    j--;
}
```
**O(n) time, O(1) space** (O(n) if you need a `char[]` to write into).

📁 `coding_2/StringReverse.java`, `WordCharacterReversal.reverseWord()`

---

## 3️⃣ Expand Around Centre

**Signals:** "longest palindromic substring", "count palindromes".

Every palindrome has a centre. There are `2n - 1` of them — `n` characters and `n - 1` gaps — so try
each one and push outward.

```java
for (int centre = 0; centre < str.length(); centre++) {
    expand(str, centre, centre);       // odd length:  "aba"  → centre is a character
    expand(str, centre, centre + 1);   // even length: "abba" → centre is a gap
}

static void expand(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        // s.substring(left, right + 1) is a palindrome — record it if it's the longest so far
        left--;
        right++;
    }
}
```

```text
   "abba"

   centre 1 (odd,  'b')   →  b        length 1
   centre 1/2 (even gap)  →  bb → abba   ✅ length 4

   Both passes are required — an odd-only scan never finds "abba".
```

**O(n²) time, O(1) space.** Brute force (check every substring) is O(n³).

> ⚠️ Both the odd **and** even call are mandatory, and the bounds guard
> (`left >= 0 && right < length`) must come **before** the `charAt` comparison — short-circuiting is
> what keeps it in bounds.

📁 `LongestPalindrome.java`

---

## 4️⃣ Write Cursor (In-Place Filter)

**Signals:** "remove", "delete all", "keep only", "compact".

```java
int write = 0;
for (int read = 0; read < arr.length; read++) {
    if (keep(arr[read])) arr[write++] = arr[read];
}
return new String(arr, 0, write);      // ⚠️ write is the logical length
```
**O(n) time, O(1) extra space.** Only the `keep()` condition changes between problems.

📁 `coding_5/SpacesRemover.java`, `coding_6/VowelsRemover.java`, `RemoveDuplicates.java`

---

## 5️⃣ Run-Length Encoding

**Signals:** "compress", "expand", "consecutive", "aaabb → a3b2".

Track `current` + `count`, flush on change, **flush again after the loop**.

```java
// compress
char current = str.charAt(0);
int count = 1;
for (int i = 1; i < str.length(); i++) {
    if (str.charAt(i) == current) count++;
    else { sb.append(current).append(count); current = str.charAt(i); count = 1; }
}
sb.append(current).append(count);      // ⚠️ the last run

// expand — mirror image, with MULTI-DIGIT counts
for (int i = 0; i < s.length(); ) {
    char c = s.charAt(i++);
    int n = 0;
    while (i < s.length() && Character.isDigit(s.charAt(i))) n = n * 10 + (s.charAt(i++) - '0');
    for (int k = 0; k < n; k++) sb.append(c);
}
```
**O(n) time, O(n) space.**

📁 `StringCompress.java`, `StringExpand.java`

---

## 6️⃣ Substring Search (Sliding Compare)

**Signals:** "contains", "is X a substring of Y", "index of", "starts/ends with".

```java
public static boolean contains(String text, String pattern) {
    int n = text.length(), m = pattern.length();
    if (m > n) return false;                          // ⚡ early exit

    for (int i = 0; i <= n - m; i++) {                // ⚠️ <= n - m, not < n
        int j = 0;
        while (j < m && text.charAt(i + j) == pattern.charAt(j)) j++;
        if (j == m) return true;                      // matched all the way through
    }
    return false;
}
```

```text
   text = "banana",  pattern = "nan"      n - m = 3

   i=0  ban   ✗
   i=1  ana   ✗
   i=2  nan   ✓ → true
   i=3  ana   (last valid start — i > 3 would run off the end)
```

**O(n × m) worst case.** Real-world algorithms (KMP, Boyer–Moore) reach O(n + m); you don't need them
yet, but knowing the naive version *is* O(n·m) is expected.

> ⚠️ The outer bound `i <= n - m` is the whole trick. `i < n` reads past the end;
> `i < n - m` misses a match that ends exactly at the last character.

📁 `SubStringCheck.java`, `FindWordOccurrence.java`, `UserDefinedFunctions.java` (`indexOf`,
`startsWith`, `endsWith`)

---

## 7️⃣ Rotation — the Concatenation Trick

**Signals:** "is s2 a rotation of s1", `"erbottlewat"` vs `"waterbottle"`.

```java
public static boolean isRotation(String s1, String s2) {
    if (s1.length() != s2.length()) return false;    // ⚠️ mandatory guard
    return (s1 + s1).contains(s2);
}
```

```text
   s1 = "waterbottle"
   s1 + s1 = "waterbottlewaterbottle"
                   └──────────┘
                   "erbottlewat"  ✅ every rotation of s1 lives inside s1+s1
```

**Why it works:** rotating means cutting `s1` at some index `k` and swapping the halves. `s1 + s1`
contains every such cut as a contiguous window.

**O(n²) with the naive search**, O(n) with a real one. Without the length guard, `"ab"` would count
as a rotation of `"a"`.

📁 `StringRotationCheck.java` — which builds `s1 + s1` and feeds it to its own `checkSubString`,
i.e. pattern 7 composed with pattern 6.

---

## 8️⃣ Word-Level Parsing

**Signals:** "words", "sentence", "longest word", "reverse the words".

Scan with `inWord` + a sentinel iteration (file 4, Technique 5), or `split("\\s+")` when built-ins
are allowed.

| Question | Track while scanning |
|----------|---------------------|
| Count words | A counter, incremented on each word **start** |
| Longest / shortest word | Best length + its start index |
| Reverse each word | Call `reverseWord(arr, start, end)` per word |
| Reverse word **order** | Reverse the whole string, then each word |
| Word occurrences | Compare each word against the target |

```text
   Reverse word order in O(1) space:

   "java is fun"  ──reverse all──▶  "nuf si avaj"  ──reverse each word──▶  "fun is java"
```

> ⚠️ `split(" ")` on `"a  b"` yields an **empty string** in the middle. Use `split("\\s+")`, or
> `trim()` first — a leading space produces a leading empty element even with `\\s+`.

📁 `CountWords.java`, `LargestWordInString.java`, `SmallestWordInString.java`,
`WordCharacterReversal.java`, `StringOrderReversal.java`, `FindWordOccurrence.java`

---

## 9️⃣ Backtracking (Permutations)

**Signals:** "all permutations", "all combinations", "generate every arrangement".

```java
public static void permute(char[] arr, int start) {
    if (start == arr.length - 1) {            // base case: one char left → a complete arrangement
        System.out.println(new String(arr));
        return;
    }
    for (int i = start; i < arr.length; i++) {
        swap(arr, start, i);                  // choose
        permute(arr, start + 1);              // explore
        swap(arr, start, i);                  // ⚠️ UN-choose — this is the "backtracking"
    }
}
```

```text
   "abc"
                    abc
         ┌───────────┼───────────┐
      swap(0,0)   swap(0,1)   swap(0,2)
        abc          bac         cba
       ┌──┴──┐      ┌──┴──┐     ┌──┴──┐
      abc  acb    bac  bca    cba  cab
```

**O(n! × n) time** — `n!` arrangements, O(n) to print each. `n = 10` is already 3.6 million.

> ⚠️ **The swap back is not optional.** Without it the array stays scrambled and later branches
> explore the wrong state — the single most common backtracking bug. Duplicate characters also
> produce duplicate outputs; a `Set` or a sorted-skip guard fixes that.

📁 `StringPermutation.java`

---

## 🔟 Bonus — Sliding Window

Not in your practice folder yet, but the natural next step and extremely common in interviews.

**Signals:** "longest substring with…", "smallest window containing…", "at most k distinct".

```java
// Longest substring without repeating characters
int[] lastSeen = new int[256];
java.util.Arrays.fill(lastSeen, -1);
int best = 0, start = 0;

for (int end = 0; end < s.length(); end++) {
    char c = s.charAt(end);
    if (lastSeen[c] >= start) start = lastSeen[c] + 1;   // shrink past the duplicate
    lastSeen[c] = end;
    best = Math.max(best, end - start + 1);
}
```

```text
   "abcabcbb"

   window grows  ──▶  [abc]abcbb        best = 3
   'a' repeats   ──▶  a[bca]bcbb        start jumps past the old 'a'
                      window NEVER moves backwards → O(n), not O(n²)
```

**O(n) time, O(1) space.** Both pointers only move forward — that's what makes a window O(n).

---

## 🧭 Choosing a Pattern

```text
   "count / duplicate / anagram / frequency"     →  1  Frequency array
   "reverse / palindrome / both ends"            →  2  Two pointers
   "LONGEST palindrome"                          →  3  Expand around centre
   "remove / keep only"                          →  4  Write cursor
   "compress / expand / consecutive"             →  5  Run-length
   "contains / index of / substring"             →  6  Sliding compare
   "rotation"                                    →  7  s1 + s1
   "words / sentence"                            →  8  Word scan
   "all permutations"                            →  9  Backtracking
   "longest/smallest window with a property"     → 10  Sliding window
```

---

## ⏱️ Complexity Reference

| Pattern | Time | Space |
|---------|------|-------|
| Frequency count | O(n) | O(1) — fixed 256 |
| Two pointers | O(n) | O(1) |
| Write cursor | O(n) | O(1) in place |
| Run-length | O(n) | O(n) output |
| Word scan | O(n) | O(1) manual / O(n) with `split` |
| Sliding window | O(n) | O(1) |
| Expand around centre | O(n²) | O(1) |
| Naive substring search | O(n × m) | O(1) |
| Rotation (naive search) | O(n²) | O(n) |
| Sort-then-compare (anagram) | O(n log n) | O(n) |
| Permutations | O(n! × n) | O(n) recursion depth |
| ❌ `+=` in a loop | O(n²) | O(n²) garbage |

> 💡 **Read your own code:** count nested loops *over the data*. Two pointers that only move forward
> stay O(n) even though there are two of them. `substring` or `+` **inside** a loop quietly adds a
> factor of n.

---

## 🐞 The Bugs This Chapter Keeps Producing

| Bug | Where it bites |
|-----|----------------|
| Calling a String method without assigning the result | Everywhere — silently does nothing |
| `==` instead of `equals()` | Passes with literals, fails on `Scanner` input |
| `charAt(length())` | `StringIndexOutOfBoundsException` |
| `substring(begin, end)` treating `end` as inclusive | One character short |
| `indexOf(x) > 0` | Misses a match at index `0` |
| `split(".")` / `replaceAll(".")` | Regex "any character" — output is all separators |
| `freq[c - 'a']` on mixed-case input | Negative index → crash |
| Scanning `freq[]` instead of the string for "first" | Alphabetical answer, not positional |
| Missing the final flush in run-length | Last group dropped |
| Missing the sentinel iteration in a word scan | Last word never processed |
| No `inWord` guard on the else branch | Double spaces corrupt the output |
| `new String(arr)` after a write cursor | Stale garbage tail printed |
| Two-pointer loop with `i <= j` | Middle element compared with itself |
| Only the odd centre in expand-around-centre | `"abba"` never found |
| `i < n` instead of `i <= n - m` in substring search | Out of bounds, or a missed final match |
| No length check before the rotation trick | `"a"` "rotates" into `"ab"` |
| Forgetting the swap-back in backtracking | Corrupted array, wrong permutations |
| Reading one digit for a multi-digit count | `"a12"` expands wrong |
| `+=` inside a loop | O(n²) |

---

## 🎯 Key Takeaways

- **Ten patterns cover the chapter. Name the pattern before writing code.**
- **Frequency arrays** are the single highest-value tool here — O(n) counting, O(1) space, and they
  answer duplicate, anagram, and non-repeating questions alike. Use `int[256]` unless you've proven
  the input is `a–z`.
- **Two pointers** solve reversal and palindromes in O(1) space; **expand around centre** upgrades
  that to *longest* palindrome for O(n²).
- **Write cursor** filters in place — and the cursor is the logical length, so use
  `new String(arr, 0, write)`.
- **Edge cases live at the boundaries:** the last run, the last word, the last valid start index
  (`i <= n - m`). Chapter 4 said the same thing; it is still the most common source of wrong answers.
- Guard **before** you index — `&&` short-circuits, and that is what keeps a scan in bounds.
- **Never build strings with `+=` in a loop.** `StringBuilder`, every time.
- 👉 Next chapter: **`chapter6-java-oop`** — where `String` finally makes sense as a *class*:
  `final`, `equals`/`hashCode`, and encapsulation via a `private final` field.
