# 📦 Wrapper Classes in Java

Wrapper classes in Java are used to convert **primitive data types into objects**.  
They act as a bridge between **primitives** and **objects**, allowing primitives to be used in places where objects are required.

Java provides **one wrapper class for each primitive data type**.

---

## 📌 Why Wrapper Classes Exist

Java is an object-oriented language, but primitive data types are **not objects**.

Wrapper classes help to:
- Treat primitives as objects
- Use primitives in Collections and Generics
- Provide utility methods for conversion and comparison
- Support Autoboxing and Unboxing

---

## 🧠 Primitive to Wrapper Mapping

Primitive Type → Wrapper Class

byte    → Byte  
short   → Short  
int     → Integer  
long    → Long  
float   → Float  
double  → Double  
char    → Character  
boolean → Boolean

---

## 🏗️ Creating Wrapper Objects

### 1️⃣ Using Constructor (Deprecated)

Integer obj = new Integer(10);

This approach is **deprecated** and not recommended.

---

### 2️⃣ Using valueOf() Method (Recommended)

Integer obj = Integer.valueOf(10);

This method is:
- Efficient
- Uses internal caching
- Preferred in modern Java

---

## 🔄 Autoboxing

Autoboxing is the **automatic conversion of a primitive into its corresponding wrapper object** by the Java compiler.

Example:

int x = 10;  
Integer obj = x;   // Autoboxing

Internally converted to:
Integer.valueOf(x)

---

## 🔄 Unboxing

Unboxing is the **automatic conversion of a wrapper object into its corresponding primitive type**.

Example:

Integer obj = 20;  
int y = obj;   // Unboxing

Internally converted to:
obj.intValue()

---

## ⚠️ Autoboxing & Unboxing Risk

If a wrapper object is null and unboxed, it causes a runtime error.

Example:

Integer x = null;  
int y = x;   // NullPointerException

---

## 🧪 Useful Wrapper Utility Methods

### Parsing String to Primitive

int x = Integer.parseInt("100");  
double d = Double.parseDouble("12.5");  
boolean b = Boolean.parseBoolean("true");

---

### Converting String to Wrapper Object

Integer i = Integer.valueOf("200");  
Double d = Double.valueOf("15.5");

---

### Converting Wrapper to String

String s1 = Integer.toString(50);  
String s2 = i.toString();

---

## 🔍 Character Wrapper Methods

Character.isDigit('5');  
Character.isLetter('A');  
Character.isUpperCase('A');  
Character.isLowerCase('a');  
Character.isWhitespace(' ');

---

## 📏 MIN_VALUE and MAX_VALUE

Every numeric wrapper class provides constant limits.

Integer.MIN_VALUE  
Integer.MAX_VALUE

Long.MIN_VALUE  
Long.MAX_VALUE

Float.MIN_VALUE  
Float.MAX_VALUE

Used for boundary checks and overflow handling.

---

## 🧠 Wrapper Class Caching

Java caches wrapper objects for performance.

### Integer Cache Range
-128 to 127

Example:

Integer a = 100;  
Integer b = 100;  
a == b   → true

Integer x = 200;  
Integer y = 200;  
x == y   → false

Reason:
- Small values are cached
- Larger values create new objects

✔ Always use equals() for comparison

---

## ⚖️ == vs equals() in Wrapper Classes

Example:

Integer a = 128;  
Integer b = 128;

a == b        → false (reference comparison)  
a.equals(b)  → true  (value comparison)

Rule:
- Use == for primitives
- Use equals() for wrapper objects

---

## 🔢 Special Floating-Point Checks

Double.isNaN(value);  
Float.isInfinite(value);

Used to validate floating-point calculations.

---

## 🧠 Wrapper Classes and Collections

Collections store **objects only**, not primitives.

Example:

ArrayList<Integer> list = new ArrayList<>();  
list.add(10);   // Autoboxing happens

Primitive → Wrapper → Stored in collection

---

## ⚠️ Performance Consideration

Primitive operations are faster than wrapper operations.

int x = 10;        // Faster  
Integer y = 10;    // Slower (object creation)

Use wrapper classes only when required.

---

## 🚨 Common Mistakes

- Using == instead of equals()
- Unboxing null wrapper objects
- Overusing wrapper classes unnecessarily
- Ignoring performance overhead

---

## 🧠 Interview Questions & Answers

Q1. Are wrapper classes immutable?  
Yes, all wrapper classes are immutable.

Q2. Can wrapper objects be null?  
Yes, unlike primitives.

Q3. Does autoboxing happen at runtime?  
No, it happens at compile time.

Q4. Why does Integer caching exist?  
To improve performance and reduce memory usage.

Q5. Can wrapper classes be extended?  
No, they are final.

---

## 📌 Why Wrapper Classes Are Important

- Bridge between primitives and objects
- Required for Collections and Generics
- Provide conversion and utility methods
- Enable modern Java features

---

## 🧾 One-Line Summary

Wrapper classes convert primitive data types into objects, enabling object-oriented behavior, collections usage, and automatic boxing and unboxing in Java.

---

## ✅ Chapter Completion Checklist

- Primitive to wrapper mapping
- Autoboxing and unboxing
- Utility methods
- Wrapper caching
- Performance considerations
- equals() vs ==
- Interview readiness
