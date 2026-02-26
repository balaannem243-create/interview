## Core Java Fundamentals
## Basic Concepts

## 1️⃣ What is the difference between JDK, JRE, and JVM? 
👉 **JVM** is the core component that   executes java bytecode by converting it into a machine code.

**JRE provides the runtime environment**, which includes **JVM and core libraries** required to run java applications.

**JDK** is the complete development kit that includes **JRE along with the development** tools like the java compiler and debugger.

| Feature        | JVM                    | JRE                                       | JDK                                 |
| -------------- | ---------------------- | ----------------------------------------- | ----------------------------------- |
| Full Form      | Java Virtual Machine   | Java Runtime Environment                  | Java Development Kit                |
| Purpose        | Executes Java bytecode | Provides environment to run Java programs | Used to develop & run Java programs |
| Contains       | Execution engine       | JVM + Libraries                           | JRE + Development tools             |
| Tools Included | ❌ No compiler          | ❌ No compiler                             | ✅ javac, debugger, javadoc          |
| Used By        | System (internally)    | End Users                                 | Developers                          |


## 2️⃣ What are the main features of Java (OOP principles)?
👉 ## ✅ Main Features of Java (OOP Principles)

Java follows **Object-Oriented Programming (OOP)** concepts. The four main pillars are:

1. Encapsulation
2. Abstraction
3. Inheritance
4. Polymorphism

---

## ✅ Encapsulation

### 💼 Interview Answer

> "Encapsulation is the process of **wrapping data(variables) and methods into a single unit(class)** and restricting direct access to data using access modifiers(private, public, etc.) to ensure data security."

### 🌍 Real-Time Example

Think of a **bank account**.
You cannot directly change your balance. You must use methods like `deposit()` or `withdraw()`.


---

## ✅ Abstraction

### 💼 Interview Answer

> "Abstraction hides internal implementation details and exposes only required functionality. In Java, it is achieved using abstract classes and interfaces."

### 🌍 Real-Time Example

When you drive a car, you only use the steering wheel and pedals.
You don’t need to know how the engine works internally.



---

## ✅ Inheritance

### 💼 Interview Answer

> "Inheritance is a mechanism where **one class acquires properties and behaviors of another class**, promoting code reusability. In Java, it is achieved using the **extends** keyword."

### 🌍 Real-Time Example

A **Dog** is an **Animal**.
Dog inherits common properties like eat(), sleep() from Animal.



---

## ✅ Polymorphism

### 💼 Interview Answer

> "Polymorphism allows **one method to have different behaviors based on the object or parameters**. It can be achieved through **(Compile-time)method overloading and (Runtime) method overriding** in Java."

### 🌍 Real-Time Example

A person can be:

* Father at home
* Employee at office
* Friend with friends

Same person, different roles.



---

# 🎯 Quick Memory Trick for Interviews

👉 **E A I P**

* Encapsulation
* Abstraction
* Inheritance
* Polymorphism

---

# 🔥 45-Second Complete Interview Answer

> "Java follows four main OOP principles: Encapsulation, Abstraction, Inheritance, and Polymorphism. Encapsulation ensures data security by **wrapping data(variables) and methods into a single unit(class) and restricting access**. Abstraction **hides implementation details and exposes only required details**. Inheritance promotes **code reusability by allowing one class to inherit another**. Polymorphism allows **methods to behave differently at compile-time or runtime**."

---


# 4️⃣ What Are Primitive Data Types in Java?
## 💼 Interview Answer (Professional & Crisp)

> "Primitive data types in Java are the basic built-in data types used to store simple values. Java provides eight primitive types: byte, short, int, long, float, double, char, and boolean. They store actual values directly in memory and are more memory-efficient compared to objects."

---

## 🎯 Quick Memory Trick

👉 **2 Types of Primitives**

* **Numeric** → byte, short, int, long, float, double
* **Non-Numeric** → char, boolean

👉 **Memory Order (Small → Large)**
`byte → short → int → long → float → double`

---



Java has **8 primitive data types**:

| Data Type | Size    | Example                | Purpose                  |
| --------- | ------- | ---------------------- | ------------------------ |
| `byte`    | 1 byte  | `byte b = 10;`         | Small integer            |
| `short`   | 2 bytes | `short s = 100;`       | Medium integer           |
| `int`     | 4 bytes | `int num = 1000;`      | Default integer          |
| `long`    | 8 bytes | `long l = 10000L;`     | Large integer            |
| `float`   | 4 bytes | `float f = 10.5f;`     | Decimal (less precision) |
| `double`  | 8 bytes | `double d = 20.99;`    | Decimal (more precision) |
| `char`    | 2 bytes | `char c = 'A';`        | Single character         |
| `boolean` | 1 bit   | `boolean flag = true;` | True/False               |

---

## ✅ 4. What is Autoboxing and Unboxing?

## 💼 Interview Answer (Professional & Crisp)

> "Autoboxing is the automatic conversion of a primitive type into its corresponding wrapper class object, and unboxing is the reverse process. It was introduced in Java 5 to simplify working with collections and generics, since collections store objects and not primitive types."

---

## 🎯 Quick Memory Trick

👉 **Boxing = Primitive inside Object**

👉 **Unboxing = Object back to Primitive**

---

### 📌 Primitive ↔ Wrapper Mapping (Important for Interviews)

| Primitive | Wrapper Class |
| --------- | ------------- |
| byte      | Byte          |
| short     | Short         |
| int       | Integer       |
| long      | Long          |
| float     | Float         |
| double    | Double        |
| char      | Character     |
| boolean   | Boolean       |

---
## 5️⃣ What Are Access Modifiers in Java?

Access modifiers in Java define the **visibility (access level)** of classes, variables, methods, and constructors.

Java provides **4 access modifiers**:

* `private` - Accessible **only within the same class**.
* `default` (no modifier) - Accessible **only within the same package**.
* `protected` - Accessible:
    * Within same package
    * Outside package through inheritance (subclass)
* `public` - Accessible **from anywhere** in the application.

---


## 📌 Quick Comparison Table

| Modifier  | Same Class | Same Package | Subclass (Other Package) | Anywhere |
| --------- | ---------- | ------------ | ------------------------ | -------- |
| private   | ✅          | ❌            | ❌                        | ❌        |
| default   | ✅          | ✅            | ❌                        | ❌        |
| protected | ✅          | ✅            | ✅                        | ❌        |
| public    | ✅          | ✅            | ✅                        | ✅        |

---

# 💼 Interview Answer (Professional & Crisp – 45 Seconds)

> "Access modifiers in Java control the visibility of classes, methods, and variables. Java provides four access modifiers: private, default, protected, and public. Private members are accessible only within the same class. Default members are accessible within the same package. Protected members are accessible within the package and also outside the package through inheritance. Public members are accessible from anywhere in the application. They help achieve encapsulation and security in Java applications."

---

## 6️⃣ What is a Package in Java?


### 💼 Interview Answer (Professional & Crisp – 40 Seconds)

> "A package in Java is a namespace used to group related classes and interfaces. It helps in organizing code, avoiding naming conflicts, and providing access control. Java provides built-in packages like java.util and java.io, and developers can also create user-defined packages using the package keyword."

---

### 🎯 Quick Memory Trick

👉 **Package = Folder for Classes**

👉 Used for **Organization + Security + Maintenance**

---

