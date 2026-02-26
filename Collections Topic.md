# 🔥 1️⃣ What is Collections Framework?

## ✅ Interview Definition

> “The Java Collections Framework is a unified architecture for storing and manipulating groups of objects. It provides interfaces, implementations, and algorithms.”

It mainly consists of:

* **Interfaces**
* **Implementations**
* **Utility classes (Collections class)**

---

## 📌 Core Interfaces Hierarchy

![Image](https://miro.medium.com/1%2AqgcrVwo8qzF4muOQ-kKB8A.jpeg)

![Image](https://miro.medium.com/v2/resize%3Afit%3A1016/0%2Aro8i2-Co08aBSedb.png)

![Image](https://www.tutorialspoint.com/java/images/hierarchy-of-collection-framework.jpg)

![Image](https://www.codejava.net/images/articles/javacore/collections/collections%20framework%20overview.png)

---

Main Interfaces:

* **List**
* **Set**
* **Map** (Not part of Collection interface directly)
* **Queue**

We focus on:

* List
* Set
* Map
* Iterator
* Comparable & Comparator

---

# 🔵 2️⃣ LIST

> Ordered collection, allows duplicates, index-based access.

## 🔹 ArrayList

### ✅ Interview Explanation

* Backed by **dynamic array**
* Allows duplicates
* Maintains insertion order
* Fast random access (O(1))
* Slow insertion/deletion in middle (O(n))

---

### 💻 Code Example

```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add("A");

System.out.println(list.get(1));  // B
```

---

### 🎯 Internal Working (Experienced Level)

* Default capacity = 10
* Grows by 50% (oldCapacity + oldCapacity/2)
* Uses `Object[]` internally

---

## 🔹 LinkedList

### ✅ Interview Explanation

* Doubly linked list
* Better insertion/deletion (O(1))
* Slow random access (O(n))

---

### 💻 Code Example

```java
List<String> list = new LinkedList<>();
list.add("A");
list.add("B");
list.remove("A");
```

---

### 🎯 When to Use?

* Frequent insertions/deletions
* Queue/Deque operations

---

### 🔥 ArrayList vs LinkedList

| Feature              | ArrayList     | LinkedList           |
| -------------------- | ------------- | -------------------- |
| Structure            | Dynamic array | Doubly linked list   |
| Access               | Fast          | Slow                 |
| Insert/Delete middle | Slow          | Faster               |
| Memory               | Less          | More (node overhead) |

---

# 🔵 3️⃣ SET

> Does NOT allow duplicates.

---

## 🔹 HashSet

### ✅ Interview Explanation

* Backed by HashMap
* No duplicates
* No order guarantee
* O(1) average time

---

### 💻 Code Example

```java
Set<String> set = new HashSet<>();
set.add("A");
set.add("B");
set.add("A");  // ignored
```

---

### 🎯 Internal Working

* Uses HashMap internally
* Stores value as key
* Uses hashCode() and equals()

---

## 🔹 LinkedHashSet

### ✅ Interview Explanation

* Maintains insertion order
* Backed by LinkedHashMap

---

## 🔹 TreeSet

### ✅ Interview Explanation

* Sorted Set
* Uses Red-Black Tree
* O(log n)

---

### 💻 Code Example

```java
Set<Integer> set = new TreeSet<>();
set.add(10);
set.add(5);
System.out.println(set); // [5,10]
```

---

# 🔵 4️⃣ MAP

> Key-Value pairs. Keys must be unique.

---

## 🔹 HashMap

### ✅ Interview Explanation

* Not synchronized
* Allows one null key
* O(1) average time
* Backed by array of buckets

---

### 💻 Code Example

```java
Map<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);
```

---

### 🎯 Internal Working (VERY IMPORTANT 🔥)

* Uses array of Node
* Index = hash(key) % capacity
* Collision handled using:

  * LinkedList (Java 7)
  * LinkedList + Tree (Java 8+ if >8 entries)

---

## 🔹 LinkedHashMap

* Maintains insertion order
* Doubly linked list internally

---

## 🔹 TreeMap

* Sorted Map
* Red-Black Tree
* O(log n)

---

## 🔹 Hashtable

* Synchronized
* No null key or value
* Legacy class

---

### 🔥 HashMap vs Hashtable

| Feature     | HashMap   | Hashtable |
| ----------- | --------- | --------- |
| Thread-safe | ❌         | ✅         |
| Null key    | 1 allowed | ❌         |
| Performance | Faster    | Slower    |

---

# 🔵 5️⃣ Iterator

### ✅ Interview Explanation

> Iterator is used to traverse collection elements one by one.

---

### 💻 Code Example

```java
Iterator<String> it = list.iterator();
while(it.hasNext()) {
    System.out.println(it.next());
}
```

---

### 🎯 Important Concepts

* Fail-fast iterator (throws ConcurrentModificationException)
* Remove() method is safe

---

# 🔵 6️⃣ Comparable vs Comparator

---

## 🔹 Comparable

* Used for default sorting
* Implemented inside class
* compareTo()

```java
class Student implements Comparable<Student> {
    int age;
    public int compareTo(Student s) {
        return this.age - s.age;
    }
}
```

---

## 🔹 Comparator

* External sorting logic
* compare() method
* Multiple sorting possible

```java
Comparator<Student> byName = (s1, s2) -> 
        s1.name.compareTo(s2.name);
```

---

### 🔥 Difference

| Feature | Comparable  | Comparator    |
| ------- | ----------- | ------------- |
| Package | java.lang   | java.util     |
| Method  | compareTo() | compare()     |
| Sorting | Single      | Multiple ways |

---

# 🔥 INTERVIEW QUESTIONS & ANSWERS

---

## 🟢 BASIC

1. Difference between List and Set?
   → List allows duplicates, Set doesn’t.

2. Difference between HashSet and TreeSet?
   → HashSet unordered, TreeSet sorted.

3. Why HashMap is not thread-safe?
   → No synchronization.

---

## 🔴 INTERMEDIATE

4. How does HashMap work internally?
   → Array of buckets, hashCode(), equals(), collision handling.

5. What happens if hashCode is not overridden?
   → Default Object hashCode → wrong bucket grouping.

6. Why load factor default 0.75?
   → Balance between space and time.

---

## 🔴 ADVANCED (7+ Years)

7. What happens when two keys have same hashCode?
   → Collision → equals() check → linked list/tree node.

8. How does HashMap convert to Tree in Java 8?
   → If bucket size > 8 and capacity ≥ 64 → treeify.

9. Why ConcurrentHashMap better than Hashtable?
   → Segment locking / bucket-level locking → better performance.

10. What is fail-fast iterator?
    → Throws ConcurrentModificationException if collection modified during iteration.

---

## 🔥 SCENARIO QUESTIONS

11. You need sorted, thread-safe Map → What will you use?
    → ConcurrentSkipListMap.

12. You need insertion order maintained →
    → LinkedHashMap.

13. Frequently read, rarely write →
    → CopyOnWriteArrayList.

14. High concurrency environment Map →
    → ConcurrentHashMap.

---

---
