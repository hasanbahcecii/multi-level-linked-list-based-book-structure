# 📚 Hierarchical Book Structure with Multi-Level Linked List

## 📌 Project Description
This project implements a **hierarchical book content structure** using a **multi-level linked list** in Java.

Each heading can:
- Point to the next heading on the same level
- Point to its sub-headings (child level)
- Optionally reference its parent node

This allows us to represent structures such as:

```
1 Introduction
1.1 Motivation
1.2 Scope
2 Methods
2.1 Data Collection
```

The system dynamically builds the hierarchy using a **path-based insertion logic** (e.g. `1.2.3`).

---

## 🧠 Data Structure Design

### HeadingNode
Each node contains:

- `String title` → Heading text
- `HeadingNode next` → Next heading at the same level
- `HeadingNode child` → First sub-heading
- `HeadingNode parent` → Parent heading (for upward traversal)

This creates a **tree-like structure implemented with linked lists**.

---

## ⚙️ Features

✔ Add headings using hierarchical path notation  
✔ Automatically creates multi-level structure  
✔ Prevents duplicate headings at the same level  
✔ Recursive formatted printing  
✔ Dynamic depth support  
✔ Position-based insertion  

---

## ➕ Example Insertions

```java
book.add("1", "Introduction");
book.add("1.1", "Motivation");
book.add("1.2", "Scope");
book.add("2", "Methods");
book.add("2.1", "Data Collection");
```

---

## 🖨️ Example Output
```
1 Introduction
1.1 Motivation
1.2 Scope
2 Methods
2.1 Data Collection
```

---

## 🔍 How Path Logic Works

Example:
```
Path → 2.3.1
```

Steps:

1. Go to 2nd main heading

2. Move to its 3rd sub-heading

3. Insert as its 1st child

The path is parsed character by character without using built-in split functions.

---

## ⏱️ Time Complexity

For insertion:
```
O(k + n)
```
Where:

- k → Path length

- n → Number of nodes at the target level

---

## 💾 Space Complexity
```
O(N)
```
Each heading is stored as a node with a constant number of references.

---

## 🧩 Why Parent Reference Exists?

Although deletion is not implemented, the parent pointer enables:

Efficient upward traversal

Future delete operation

Path generation from any node

This makes the structure extensible and scalable.

---

## 🏗️ Design Decisions

- Linked list used for efficient dynamic insertion

- Recursive printing for natural hierarchical traversal

- Encapsulation via private helper methods

- Manual path parsing (project constraint)

---

## 🚀 How to Run

Compile:
```Code
javac Main.java
```
Run:
```Code
java Main
```

---

## 📚 Educational Purpose

- This project demonstrates:

- Multi-level linked list design

- Tree-like hierarchy using linear structures

- Recursive traversal

- Custom parsing logic

- Object-oriented design

---

## 🔮 Possible Improvements

- Delete operation

- Search by title

- Automatic path generation

- Iterator support

- GUI representation

---

## 📜 License
MIT