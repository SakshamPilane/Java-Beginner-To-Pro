# 📦 Java Arrays

An **array** in Java is a collection of elements of the **same type** stored in **contiguous memory locations**.

It helps in storing multiple values in a single variable instead of declaring many variables.

---

## 📌 Key Features

- Fixed in size (cannot be resized once created).
- Stores elements of the same data type.
- Index-based (first element at index 0).
- Efficient for iterating and accessing values.

---

## 🔹 Declaration and Initialization

### 1. Declaration:
```text
dataType[] arrayName;
```

### 2. Memory Allocation:
```text
arrayName = new dataType[size];
```

### 3. Declaration + Allocation:
```text
dataType[] arrayName = new dataType[size];
```

### 4. Declaration + Initialization:
```text
int[] numbers = {10, 20, 30, 40, 50};
```

---

## 🔄 Accessing Array Elements

- Use index to access or update elements.
- Index starts from 0 and ends at length - 1.

```text
int[] arr = {1, 2, 3};
System.out.println(arr[0]);   // 1
arr[1] = 5;                   // updating value
```

---

## 📏 Array Length
Use the .length property to get the size.
```text
int[] marks = {90, 85, 88, 92};
System.out.println("Length = " + marks.length);  // 4
```

---

## 🔁 Iterating Over Arrays

### Using for loop:
```text
int[] arr = {2, 4, 6};
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

### Using enhanced for-each loop:
```text
for (int num : arr) {
    System.out.println(num);
}
```

---

## 🌐 Types of Arrays

### 1. Single-Dimensional Array
Stores elements in a single row.

```text
int[] arr = {10, 20, 30};
```

### 2. Multi-Dimensional Array
Array of arrays (commonly 2D arrays).

```text
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
System.out.println(matrix[1][2]); // 6
```

---

## ⚠️ Common Errors

- ArrayIndexOutOfBoundsException → occurs when trying to access an invalid index.

```text
int[] arr = {1, 2, 3};
System.out.println(arr[5]);  // ERROR
```

- NullPointerException → occurs when array is declared but not initialized.

---

### 🎯 Key Takeaways
- Arrays are fixed in size and index-based.
- Use .length to get array size.
- Support single and multidimensional forms.
- Always handle indices carefully to avoid exceptions.