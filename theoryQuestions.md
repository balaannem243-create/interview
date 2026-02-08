# 🔹 Core Java (Must-Know)

## 1️⃣ Difference between JDK, JRE, and JVM

### JVM (Java Virtual Machine)

- Executes **bytecode**
- Platform-dependent (different JVM for Windows, Linux, etc.)
- Handles memory, GC, security

👉 You **can’t write code** with JVM alone.

---

### JRE (Java Runtime Environment)

- JVM **+** core libraries
- Needed to **run** Java programs

👉 If you only want to **run** Java apps → JRE is enough.

---

### JDK (Java Development Kit)

- JRE **+** developer tools (`javac`, `javadoc`, debugger)
- Needed to **develop** Java applications

👉 If you want to **write + compile + run** Java → JDK

**Analogy**

- JVM = engine
- JRE = car
- JDK = car + factory tools

---

## 2️⃣ OOP Concepts in Java

### 🔹 Encapsulation

Wrapping data + methods together and **hiding internal details**.

```java
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
```

✅ Data is protected
✅ Access via methods only

---

### 🔹 Inheritance

One class **inherits** another.

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}
```

✅ Promotes code reuse
✅ `Dog` IS-A `Animal`

---

### 🔹 Polymorphism

Same method name, **different behavior**.

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}
```

```java
Animal a = new Dog();
a.sound(); // Bark
```

✅ Decided at **runtime**
✅ Key for flexibility

---

### 🔹 Abstraction

Hiding implementation, showing **only what matters**.

```java
abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts with key");
    }
}
```

✅ Focus on **what**, not **how**

---

## 3️⃣ Why is Java Platform-Independent?

Because of **bytecode + JVM**.

```text
Java Code (.java)
   ↓
Bytecode (.class)
   ↓
JVM (Windows / Linux / Mac)
```

- Java compiler generates **bytecode**
- JVM converts bytecode → machine code

👉 **Write once, run anywhere**

---

## 4️⃣ Difference between `==` and `.equals()`

### `==`

- Compares **memory references**

### `.equals()`

- Compares **content**

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b);        // false
System.out.println(a.equals(b));   // true
```

👉 Interview tip:
`==` → reference
`equals()` → value (if overridden)

---

## 5️⃣ Immutable Objects & Why String is Immutable

### Immutable Object

- Object whose **state cannot be changed** after creation

```java
String s = "Java";
s.concat(" World");

System.out.println(s); // Java
```

A new object is created, original stays unchanged.

---

### Why `String` is Immutable?

1. **Security** (used in DB URLs, class loaders)
2. **Thread-safe**
3. **String pool optimization**
4. **HashMap key reliability**

---

## 6️⃣ `final` Keyword

### Final Variable

```java
final int x = 10;
// x = 20; ❌
```

Value cannot change.

---

### Final Method

```java
class Parent {
    final void show() {}
}

class Child extends Parent {
    // void show() {} ❌
}
```

Cannot be overridden.

---

### Final Class

```java
final class Utility {}
// class Test extends Utility {} ❌
```

Cannot be inherited.

---

## 7️⃣ Constructors & Overriding

### Constructor

- Initializes objects
- Same name as class
- No return type

```java
class Person {
    Person() {
        System.out.println("Constructor called");
    }
}
```

---

### Can We Override Constructors?

❌ **No**

Because:

- Constructors are **not inherited**
- Overriding works only with inheritance

👉 But you **can overload** constructors.

---

## 8️⃣ Method Overloading vs Overriding

### Method Overloading (Compile-time)

- Same method name
- Different parameters
- Same class

```java
class MathUtil {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

---

### Method Overriding (Runtime)

- Same method signature
- Parent–child relationship

```java
class Parent {
    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child");
    }
}
```

---

## 🔑 Quick Interview Summary Table

| Feature     | Overloading  | Overriding          |
| ----------- | ------------ | ------------------- |
| Binding     | Compile-time | Runtime             |
| Inheritance | Not required | Required            |
| Parameters  | Must differ  | Must be same        |
| Return type | Can differ   | Same (or covariant) |

---

-

# 🔹 Collections & Data Structures (Very Common)
Perfect set of questions 👍 — these are **guaranteed interview favorites**.  
I’ll explain each **clearly + with examples + interview tips**.

---

## 1️⃣ ArrayList vs LinkedList

| Feature | ArrayList | LinkedList |
|------|---------|-----------|
| Data structure | Dynamic array | Doubly linked list |
| Access | Fast (`O(1)`) | Slow (`O(n)`) |
| Insert/Delete | Slow (shift elements) | Fast (node links) |
| Memory | Less | More (prev + next) |

### Example
```java
List<Integer> a = new ArrayList<>();
List<Integer> l = new LinkedList<>();

a.get(2); // fast
l.get(2); // slow
```

👉 **Use ArrayList** when read-heavy  
👉 **Use LinkedList** when insert/delete-heavy

---

## 2️⃣ How HashMap Works Internally

At a high level:
```text
Key → hashCode() → index → bucket → value
```

### Step-by-step
1. `hashCode()` is called on key
2. Hash is converted to **index**
3. Entry stored in **bucket**
4. Collisions handled if needed

---

## 3️⃣ Hashing

Hashing converts a key into an integer (hash code).

```java
int hash = key.hashCode();
int index = hash % capacity;
```

Good hashing:
- Uniform distribution
- Fewer collisions

Bad hashing:
- More collisions → slower performance

---

## 4️⃣ Buckets

- HashMap internally uses an **array of buckets**
- Each bucket can store:
  - Linked list (Java 7)
  - Red-black tree (Java 8+, if many collisions)

```text
Bucket[0] → (k1,v1)
Bucket[1] → (k2,v2) → (k3,v3)
```

---

## 5️⃣ Collision Handling

### Collision
When **two keys map to the same bucket**

```java
map.put("A", 1);
map.put("B", 2); // same bucket
```

### How Java Handles It
- Uses **LinkedList**
- Converts to **Red-Black Tree** if:
  - Bucket size > 8
  - Capacity ≥ 64

✅ Improves performance from `O(n)` → `O(log n)`

---

## 6️⃣ HashMap vs Hashtable

| Feature | HashMap | Hashtable |
|------|--------|---------|
| Thread-safe | ❌ No | ✅ Yes |
| Performance | Faster | Slower |
| Null key | 1 allowed | ❌ Not allowed |
| Null value | Allowed | ❌ Not allowed |
| Legacy | Modern | Legacy |

👉 Interview tip:  
**Prefer HashMap + Collections.synchronizedMap() or ConcurrentHashMap**

---

## 7️⃣ Why Keys in HashMap Are Immutable?

Because keys are used for **hashing and indexing**.

### Problem Example
```java
class Key {
    int id;
}
```

If `id` changes after insertion:
- `hashCode()` changes
- Entry becomes **unreachable**

```java
map.put(key, value);
key.id = 10; // ❌
map.get(key); // null
```

✅ Immutable keys ensure:
- Stable hashCode
- Consistent equals()
- Reliable retrieval

---

## 8️⃣ Set vs List vs Map

| Feature | List | Set | Map |
|------|----|----|----|
| Duplicates | Allowed | ❌ Not allowed | Keys ❌ |
| Order | Preserved | Depends | No |
| Access | Index-based | No index | Key-based |

### Examples
```java
List<String> list = new ArrayList<>();
Set<String> set = new HashSet<>();
Map<Integer,String> map = new HashMap<>();
```

---

## 9️⃣ How ConcurrentHashMap Works

Designed for **multi-threading** without full locking.

### Java 8+
- Uses **CAS (Compare-And-Swap)**
- Locks **only the bucket**
- No locking for read operations

```java
ConcurrentHashMap<Integer, String> map =
    new ConcurrentHashMap<>();
```

✅ High performance  
✅ No `ConcurrentModificationException`

---

## 🔟 Fail-Fast vs Fail-Safe Iterators

### Fail-Fast
- Throws `ConcurrentModificationException`
- Detects modification immediately

```java
List<Integer> list = new ArrayList<>();
for(Integer i : list) {
    list.add(10); // ❌
}
```

Used by:
- ArrayList
- HashMap
- HashSet

---

### Fail-Safe
- Works on a **copy**
- No exception
- Slower

```java
CopyOnWriteArrayList<Integer> list =
    new CopyOnWriteArrayList<>();
```

Used by:
- ConcurrentHashMap
- CopyOnWriteArrayList

---

## 🎯 Interview One-Liners (Gold)

- **HashMap** → Not thread-safe, allows one null key  
- **Hashtable** → Synchronized, legacy  
- **Collision** → LinkedList → Tree  
- **ConcurrentHashMap** → High concurrency, no full lock  
- **Fail-fast** → Immediate exception  

---

If you want next:
- 📝 **MD-ready notes** for your file  
- 🧠 **Tricky follow-up interview questions**  
- 🎤 **Mock interview on Collections**

Just say the word 😄

---

# 🔹 Multithreading & Concurrency (High Impact)

Great — this is the **core multithreading set** interviewers use to separate *Java users* from *Java engineers*.
I’ll explain each **clearly, with examples + interview-ready points** 👇

---

## 1️⃣ What is a Thread?

**Difference between `Thread` and `Runnable`**

### What is a Thread?

A **thread** is a lightweight unit of execution inside a process.
Multiple threads can run **in parallel** and share the same memory.

---

### Creating a Thread – Two Ways

#### 1️⃣ Extending `Thread`

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

MyThread t = new MyThread();
t.start();
```

❌ Can’t extend another class (Java supports single inheritance)

---

#### 2️⃣ Implementing `Runnable` (Preferred)

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Task running");
    }
}

Thread t = new Thread(new MyTask());
t.start();
```

✅ Better design
✅ Allows inheritance
✅ Separates task from thread

---

### Interview Verdict

👉 **Always prefer `Runnable` over `Thread`**

---

## 2️⃣ Thread Lifecycle in Java

![Image](https://www.tutorialspoint.com/java/images/thread_life_cycle.jpg)

![Image](https://d8it4huxumps7.cloudfront.net/uploads/images/67529ba029405_thread_lifecycle_in_java.jpg?d=2000x2000)

### States

1. **New** – Thread created
2. **Runnable** – Ready to run
3. **Running** – Executing
4. **Blocked / Waiting** – Waiting for lock / signal
5. **Terminated** – Finished execution

```java
Thread t = new Thread();
t.start(); // New → Runnable
```

👉 JVM decides **when** the thread runs

---

## 3️⃣ What is Synchronization?

Synchronization ensures **only one thread accesses a critical section at a time**.

### Problem (Race Condition)

```java
balance = balance + amount;
```

Two threads updating balance → wrong result ❌

---

### Solution: `synchronized`

```java
synchronized void withdraw(int amount) {
    balance -= amount;
}
```

✅ Prevents data inconsistency
❌ Slower (blocking)

---

## 4️⃣ `synchronized` vs `volatile`

| Feature          | synchronized     | volatile    |
| ---------------- | ---------------- | ----------- |
| Mutual exclusion | ✅ Yes            | ❌ No        |
| Visibility       | ✅ Yes            | ✅ Yes       |
| Locking          | Uses lock        | No lock     |
| Use case         | Critical section | Flag/status |

### Example (`volatile`)

```java
volatile boolean running = true;
```

Ensures **visibility**, not atomicity.

👉 Interview tip:
**`volatile` ≠ thread-safe**

---

## 5️⃣ What is Deadlock? How to Prevent It?

![Image](https://miro.medium.com/1%2ApFiainbHT7SfJfEd8wBSyg.png)

![Image](https://jojozhuang.github.io/assets/images/programming/2412/deadlock.png)

### Deadlock

When **two or more threads wait forever** for each other’s locks.

```java
Thread A → Lock 1 → waiting for Lock 2  
Thread B → Lock 2 → waiting for Lock 1
```

---

### Prevention Techniques

1. **Lock ordering**
2. **Avoid nested locks**
3. **Use `tryLock()`**
4. **Timeouts**
5. **Minimize synchronized blocks**

👉 Interview one-liner:
Deadlock = circular wait + mutual exclusion

---

## 6️⃣ Executors & Thread Pools

![Image](https://www.callicoder.com/static/bde5cf532e54e2b4a31e58d042db59ea/0a151/executor-service-thread-pool-blocking-queue-example.jpg)

![Image](https://jenkov.com/images/java-concurrency-utils/thread-pool-executor.png)

### Problem with Manual Threads

* Too many threads
* Poor resource management

---

### Executor Framework

Manages **thread pools automatically**

```java
ExecutorService executor =
    Executors.newFixedThreadPool(5);

executor.submit(() -> {
    System.out.println("Task running");
});

executor.shutdown();
```

### Benefits

✅ Reuse threads
✅ Better performance
✅ Easy lifecycle management

---

## 7️⃣ Callable vs Runnable

| Feature          | Runnable | Callable |
| ---------------- | -------- | -------- |
| Return value     | ❌ No     | ✅ Yes    |
| Throws exception | ❌ No     | ✅ Yes    |
| Method           | `run()`  | `call()` |
| Used with        | Thread   | Executor |

### Callable Example

```java
Callable<Integer> task = () -> 10;

Future<Integer> result =
    executor.submit(task);

System.out.println(result.get());
```

---

## 🔥 Interview Gold Summary

* **Runnable > Thread**
* **Synchronization** = safety, not speed
* **volatile** = visibility only
* **Deadlock** = circular lock dependency
* **Executors** manage threads efficiently
* **Callable** when result is needed

---

If you want next:

* 📝 Convert this into **MD notes**
* 🎯 Get **1–2 line interview answers**
* 🎤 Do a **mock multithreading interview**

Just tell me 😄


---

# 🔹 Exception Handling
Nice 👍 — exception handling is a **favorite trap area** in Java interviews.
Let’s go through each one **cleanly, with examples + interview tips**.

---

## 1️⃣ Checked vs Unchecked Exceptions

### ✅ Checked Exceptions

* Checked **at compile time**
* Must be **handled or declared**

Examples:

* `IOException`
* `SQLException`
* `FileNotFoundException`

```java
void readFile() throws IOException {
    FileReader fr = new FileReader("test.txt");
}
```

👉 If not handled → **compile-time error**

---

### ❌ Unchecked Exceptions

* Checked **at runtime**
* Extend `RuntimeException`

Examples:

* `NullPointerException`
* `ArithmeticException`
* `ArrayIndexOutOfBoundsException`

```java
int x = 10 / 0; // ArithmeticException
```

👉 Not mandatory to handle

---

### Interview One-liner

* **Checked** → recoverable
* **Unchecked** → programming errors

---

## 2️⃣ Difference between `throw` and `throws`

| Feature | throw                      | throws              |
| ------- | -------------------------- | ------------------- |
| Purpose | Explicitly throw exception | Declare exception   |
| Used in | Method body                | Method signature    |
| Number  | One exception              | Multiple exceptions |

### Example

```java
void validate(int age) throws IllegalArgumentException {
    if (age < 18) {
        throw new IllegalArgumentException("Not eligible");
    }
}
```

👉 `throw` → creates exception
👉 `throws` → passes responsibility

---

## 3️⃣ Can We Have Multiple Catch Blocks?

✅ **Yes**, to handle different exceptions differently.

```java
try {
    int[] arr = new int[5];
    arr[10] = 20;
}
catch (ArithmeticException e) {
    System.out.println("Arithmetic error");
}
catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Index error");
}
```

### Rule (Very Important)

➡️ **Child exception must come before parent**

❌ Wrong:

```java
catch (Exception e) {}
catch (IOException e) {} // unreachable
```

---

## 4️⃣ What is `finally`? Will It Always Execute?

### `finally`

* Block that **always executes**
* Used for **cleanup** (closing files, DB connections)

```java
try {
    int x = 10 / 2;
}
catch (Exception e) {
    System.out.println("Error");
}
finally {
    System.out.println("Cleanup");
}
```

---

### When `finally` Does NOT Execute ❌

1. `System.exit()`
2. JVM crash
3. Power failure

👉 Otherwise, **yes, it runs**

---

## 5️⃣ Custom Exceptions — When and Why?

### Why Custom Exceptions?

* Business-specific errors
* Cleaner error handling
* Better readability

Examples:

* `InvalidUserException`
* `InsufficientBalanceException`

---

### Creating a Custom Exception

#### Checked Exception

```java
class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}
```

#### Unchecked Exception

```java
class InvalidAgeException extends RuntimeException {
    InvalidAgeException(String msg) {
        super(msg);
    }
}
```

---

### Usage

```java
void vote(int age) {
    if (age < 18) {
        throw new InvalidAgeException("Age must be 18+");
    }
}
```

---

## 🔥 Interview Gold Points

* Checked → compile-time
* Unchecked → runtime
* `throw` vs `throws` → action vs declaration
* Multiple catch → specific to general
* `finally` → cleanup code
* Custom exceptions → business logic clarity

---

If you want next:

* 📝 Add these to your **MD notes**
* 🎯 Convert into **2-line interview answers**
* 🎤 Mock interview (exceptions round)

Just say the word 😄



---

# 🔹 Java 8+ Features (Very Popular Now)

Nice 😄 — this is the **Java 8+ section** that interviewers *really* care about now.
I’ll keep it **clear, example-driven, and interview-ready**.

---

## 1️⃣ What are Lambda Expressions?

Lambda expressions provide a **concise way to represent anonymous functions**.

### Before Java 8

```java
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Running");
    }
};
```

### With Lambda

```java
Runnable r = () -> System.out.println("Running");
```

### Syntax

```text
(parameters) -> expression
```

### Why Lambdas?

* Less boilerplate
* Cleaner code
* Enables functional programming

---

## 2️⃣ Functional Interfaces (with Examples)

### Functional Interface

An interface with **exactly one abstract method**.

### Examples (Very Important)

```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}
```

---

### Built-in Functional Interfaces

| Interface       | Method     | Example   |
| --------------- | ---------- | --------- |
| `Predicate<T>`  | `test()`   | Filter    |
| `Function<T,R>` | `apply()`  | Transform |
| `Consumer<T>`   | `accept()` | Consume   |
| `Supplier<T>`   | `get()`    | Supply    |

```java
Predicate<Integer> p = x -> x > 10;
```

👉 Lambdas **work only with functional interfaces**

---

## 3️⃣ What is Stream API?

Stream API processes **collections in a functional style**.

```java
List<Integer> list = List.of(1,2,3,4,5);
```

---

### `filter()` – filtering data

```java
list.stream()
    .filter(x -> x % 2 == 0)
    .forEach(System.out::println);
```

---

### `map()` – transforming data

```java
list.stream()
    .map(x -> x * 2)
    .forEach(System.out::println);
```

---

### `reduce()` – reducing to single value

```java
int sum = list.stream()
              .reduce(0, Integer::sum);
```

---

### Key Stream Points

* Does **not modify original collection**
* Lazy evaluation
* Supports parallel processing

---

## 4️⃣ Difference between `map()` and `flatMap()`

### `map()`

* One input → one output

```java
List<String> words = List.of("java", "stream");

words.stream()
     .map(w -> w.split(""))
     .forEach(System.out::println);
```

Output:

```text
["j","a","v","a"]
["s","t","r","e","a","m"]
```

---

### `flatMap()`

* Flattens nested structure

```java
words.stream()
     .flatMap(w -> Arrays.stream(w.split("")))
     .forEach(System.out::println);
```

Output:

```text
j a v a s t r e a m
```

👉 Interview one-liner:
**map = transform, flatMap = transform + flatten**

---

## 5️⃣ What is `Optional`? Why Introduced?

`Optional` is a **container that may or may not contain a value**.

### Problem Before

```java
String name = user.getName();
name.length(); // NullPointerException ❌
```

---

### With Optional

```java
Optional<String> name = Optional.ofNullable(user.getName());

name.ifPresent(System.out::println);
```

### Benefits

* Avoids `NullPointerException`
* Makes null handling explicit
* Encourages better API design

👉 Optional is **not a replacement for all nulls**

---

## 6️⃣ Default Methods in Interfaces

Java 8 allows **method implementations in interfaces**.

```java
interface Vehicle {
    default void start() {
        System.out.println("Vehicle starts");
    }
}
```

### Why Introduced?

* Backward compatibility
* Add methods without breaking implementations

---

### Override Default Method

```java
class Car implements Vehicle {
    public void start() {
        System.out.println("Car starts");
    }
}
```

---

## 🔥 Interview Gold Summary

* Lambda → anonymous function
* Functional interface → single abstract method
* Stream → functional data processing
* map vs flatMap → transform vs flatten
* Optional → safer null handling
* Default methods → backward compatibility

---

If you want:

* 📝 These added to your **MD notes**
* 🎯 **2-line interview answers**
* 🎤 Java 8 **mock interview round**

Just say the word 😄

---

## 🔹 JVM & Memory (Senior-Level Favorite)

Got it 👍 — **no images**, only **clean line (ASCII) diagrams** + explanations.
I’ll redo the **JVM & Memory** topics in an interview-friendly way.

---

## 1️⃣ JVM Memory Areas

**Heap, Stack, Metaspace**

```
+-----------------------+
|        JVM            |
|                       |
|  +-----------------+  |
|  |   Heap Memory   |  |
|  |  (Objects)     |  |
|  |  Young / Old   |  |
|  +-----------------+  |
|                       |
|  +-----------------+  |
|  |   Stack Memory  |  |
|  |  (Per Thread)  |  |
|  |  Frames, Vars  |  |
|  +-----------------+  |
|                       |
|  +-----------------+  |
|  |   Metaspace     |  |
|  |  (Class Info)  |  |
|  +-----------------+  |
+-----------------------+
```

### Heap

* Stores **objects**
* Shared by all threads
* Garbage collected

```java
Person p = new Person(); // heap
```

---

### Stack

* Stores **method calls, local variables**
* One stack **per thread**
* Faster than heap

```java
void test() {
    int x = 10; // stack
}
```

---

### Metaspace

* Stores **class metadata**
* Replaced PermGen (Java 8+)
* Uses native memory

---

### Interview Line

> Heap → objects
> Stack → execution
> Metaspace → class metadata

---

## 2️⃣ How Garbage Collection Works

```
[Objects Created]
        ↓
[Reachability Check]
        ↓
[Unreachable Objects]
        ↓
[Garbage Collected]
```

### Key Idea

GC removes objects **no longer referenced**.

```java
Person p = new Person();
p = null; // eligible for GC
```

### GC Phases

1. **Mark** – identify live objects
2. **Sweep** – remove dead objects
3. **Compact** – reduce fragmentation (some GCs)

👉 GC is **automatic**, not manual.

---

## 3️⃣ Types of Garbage Collectors (Basics)

### Serial GC

```
[App Stops]
     ↓
[Single GC Thread]
     ↓
[App Resumes]
```

* Single-threaded
* Stop-the-world
* Small apps

---

### Parallel GC

```
[App Stops]
     ↓
[Multiple GC Threads]
     ↓
[App Resumes Faster]
```

* High throughput
* Multiple threads

---

### G1 GC (Most Used)

```
Heap → Regions
[Region1][Region2][Region3]
```

* Collects region-wise
* Predictable pauses
* Good for large heaps

---

### ZGC

```
[App Running]
     ↓
[Concurrent GC]
     ↓
[Very Small Pauses]
```

* Ultra-low latency
* Large heaps
* Modern JVMs

---

### Interview One-Liner

* Serial → simple
* Parallel → fast
* G1 → balanced
* ZGC → low latency

---

## 4️⃣ Memory Leaks in Java — How Do They Happen?

Memory leak = **objects are reachable but never used**

```
Object Created
     ↓
Still Referenced
     ↓
GC Cannot Remove ❌
```

### Common Causes

#### 🔹 Static References

```java
static List<String> list = new ArrayList<>();
```

Lives for JVM lifetime ❌

---

#### 🔹 Unclosed Resources

```java
FileInputStream fis = new FileInputStream("a.txt");
// not closed ❌
```

---

#### 🔹 Listeners / Callbacks

```
Object Registered
     ↓
Never Deregistered
     ↓
Memory Leak
```

---

#### 🔹 Unbounded Caches

```java
Map<String,Object> cache = new HashMap<>();
```

---

### Interview Line

> Java leaks are caused by **bad references**, not missing GC

---

## 5️⃣ What is Class Loading?

Class loading = bringing `.class` files into JVM.

```
.class file
    ↓
[Loading]
    ↓
[Linking]
    ↓
[Initialization]
```

---

### Phases Explained

#### 1️⃣ Loading

* Loads bytecode
* Creates `Class` object

#### 2️⃣ Linking

* Verify bytecode
* Allocate memory
* Resolve references

#### 3️⃣ Initialization

* Static variables assigned
* Static blocks executed

```java
static {
    System.out.println("Class initialized");
}
```

---

### ClassLoader Hierarchy

```
Bootstrap
    ↓
Extension
    ↓
Application
```

---

### Interview One-Liner

> Class loading happens **once per class per JVM**

---

## 🔥 Final Interview Summary (Memorize This)

* Heap → objects, GC
* Stack → method execution
* Metaspace → class metadata
* GC → mark, sweep, compact
* G1 → default choice
* ZGC → low latency
* Memory leak → reference issue
* Class loading → load, link, init

---

If you want next:

* 📝 I can **replace images with these line diagrams in your MD file**
* 🎯 Compress this into **2-line interview answers**
* 🎤 Do a **JVM deep-dive mock interview**

Just tell me 👍


---

# 🔹 Coding / Practical Questions
Perfect 👍 — these are **classic Java coding interview questions**.
I’ll give you **clean logic + readable code + interview tips** (no built-ins, no shortcuts).

---

## 1️⃣ Reverse a String (Without Built-in Methods)

### Logic

* Convert string to char array
* Swap characters from both ends

### Code

```java
public class ReverseString {
    public static void main(String[] args) {
        String str = "java";
        char[] arr = str.toCharArray();

        int left = 0, right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        System.out.println(new String(arr));
    }
}
```

### Interview Tip

👉 Time: `O(n)`
👉 Space: `O(n)` (char array)

---

## 2️⃣ Find Duplicate Elements in an Array

### Logic

* Use `HashSet`
* If add() returns false → duplicate

### Code

```java
import java.util.*;

public class Duplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 1};

        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (!set.add(num)) {
                System.out.println("Duplicate: " + num);
            }
        }
    }
}
```

### Interview Tip

👉 Best solution
👉 Time: `O(n)`

---

## 3️⃣ Check if a String Is a Palindrome

### Logic

* Compare characters from both ends

### Code

```java
public class Palindrome {
    public static void main(String[] args) {
        String str = "madam";

        int left = 0;
        int right = str.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println(isPalindrome);
    }
}
```

### Interview Tip

👉 No extra memory
👉 Efficient & clean

---

## 4️⃣ Find Second Largest Number in an Array

### Logic

* Track largest and second largest
* Single pass

### Code

```java
public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        System.out.println("Second Largest: " + secondLargest);
    }
}
```

### Interview Tip

👉 One loop
👉 Time: `O(n)`
👉 Avoid sorting (`O(n log n)` ❌)

---

## 5️⃣ Count Word Occurrences Using `HashMap`

### Logic

* Split string
* Use word as key, count as value

### Code

```java
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String text = "java is java and java is powerful";
        String[] words = text.split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println(map);
    }
}
```

### Output

```
{java=3, is=2, and=1, powerful=1}
```

### Interview Tip

👉 `getOrDefault()` is Java 8+
👉 Very commonly asked

---

## 🔥 Interview Cheat Summary

| Problem        | Best Approach |
| -------------- | ------------- |
| Reverse string | Two-pointer   |
| Duplicates     | HashSet       |
| Palindrome     | Two-pointer   |
| Second largest | Single pass   |
| Word count     | HashMap       |

---

If you want next:

* 📝 Add these into your **MD interview notes**
* 🎯 Variations interviewers ask (follow-ups)
* 🎤 Mock **live coding interview**

Just say it 😄



---

## 🔹 Tricky / Frequently Asked
These are **classic “tricky Java” questions** interviewers use to test *real understanding*, not memorization.
Let’s break them down **clearly, with examples + interview-safe explanations** 👇

---

## 1️⃣ Why Is Java Pass-by-Value?

Java is **always pass-by-value** — even for objects.

### For Primitive Types

```java
void change(int x) {
    x = 20;
}

int a = 10;
change(a);
System.out.println(a); // 10
```

✔ A **copy of value** is passed.

---

### For Objects

```java
class Test {
    int x;
}

void change(Test t) {
    t.x = 20;
}

Test obj = new Test();
obj.x = 10;
change(obj);
System.out.println(obj.x); // 20
```

Why did it change?
➡️ The **reference value is copied**, not the object.

---

### Proof (Reassigning reference)

```java
void change(Test t) {
    t = new Test();
    t.x = 50;
}
```

Original object remains unchanged.

### Interview Line

> Java passes **object references by value**

---

## 2️⃣ Can We Override Static Methods?

❌ **No**, static methods **cannot be overridden**.

### Why?

* Static methods belong to **class**, not object
* Overriding works via **runtime polymorphism**
* Static binding happens at **compile time**

---

### Example (Method Hiding)

```java
class Parent {
    static void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Child");
    }
}
```

```java
Parent p = new Child();
p.show(); // Parent
```

👉 This is **method hiding**, not overriding.

---

## 3️⃣ Can an Interface Have Variables?

✅ **Yes**, but they are **implicitly**:

* `public`
* `static`
* `final`

### Example

```java
interface Test {
    int x = 10;
}
```

Equivalent to:

```java
public static final int x = 10;
```

❌ You cannot change it:

```java
Test.x = 20; // compilation error
```

### Interview Line

> Interface variables are constants

---

## 4️⃣ Abstract Class vs Interface

| Feature              | Abstract Class      | Interface                  |
| -------------------- | ------------------- | -------------------------- |
| Methods              | Abstract + concrete | Abstract + default         |
| Variables            | Instance variables  | `public static final` only |
| Multiple inheritance | ❌ No                | ✅ Yes                      |
| Constructor          | ✅ Yes               | ❌ No                       |
| Access modifiers     | Any                 | `public` only              |

---

### When to Use What?

* **Abstract class** → IS-A + shared state
* **Interface** → CAN-DO capability

### Example

```java
abstract class Animal {
    int age;
    abstract void sound();
}

interface Flyable {
    void fly();
}
```

---

## 5️⃣ Why Multiple Inheritance Is Not Supported in Java?

To avoid the **Diamond Problem**.

### Diamond Problem

```
   A
  / \
 B   C
  \ /
   D
```

Which method should `D` inherit? ❌

---

### Java’s Solution

* No multiple inheritance with classes
* Multiple inheritance via **interfaces**

```java
interface A {
    default void show() {}
}

interface B {
    default void show() {}
}

class C implements A, B {
    public void show() {
        A.super.show();
    }
}
```

✔ Conflict resolved explicitly

---

## 🔥 Interview One-Line Answers (Memorize These)

* Java → **pass-by-value**
* Static methods → **cannot be overridden**
* Interface variables → **constants**
* Abstract vs Interface → **state vs capability**
* No multiple inheritance → **avoid ambiguity**

---

If you want:

* 📝 Merge this into your **MD interview notes**
* 🎯 Turn these into **2-line interview answers**
* 🎤 Do a **tricky Java mock interview round**

