I’ll answer **each question in the fixed interview format** we agreed:

**Definition → Explanation → Example → Real-world usage**

These are **clear, 30–45 second answers suitable for interviews**.

---

# 1. Difference between JDK, JRE, and JVM

**Definition**
JDK, JRE, and JVM are core components of the Java platform used to **develop and run Java applications**.

**Explanation**

* **JVM (Java Virtual Machine)** executes Java bytecode and converts it into machine code.
* **JRE (Java Runtime Environment)** provides the environment required to run Java programs. It contains JVM and core libraries.
* **JDK (Java Development Kit)** is the complete toolkit used to develop Java applications. It contains JRE along with development tools like the compiler.

**Example**

```java
javac Hello.java   // Compile using JDK
java Hello         // Run using JVM
```

**Real-world usage**

Developers install **JDK to write and compile code**, while end users only need **JRE to run Java applications**.

---

# 2. Main Features of Java (OOP Principles)

**Definition**
Java follows **Object-Oriented Programming (OOP)** principles which help in building modular and reusable software.

**Explanation**

The four main OOP principles are:

* **Encapsulation** – wrapping data and methods together
* **Abstraction** – hiding implementation details
* **Inheritance** – reusing properties from another class
* **Polymorphism** – same method behaving differently

**Example**

```java
class Animal {
    void sound() {}
}

class Dog extends Animal {
    void sound() { System.out.println("Bark"); }
}
```

**Real-world usage**

OOP helps structure large applications like **banking systems, e-commerce platforms, and enterprise software**.

---

# 3. Primitive Data Types in Java

**Definition**
Primitive data types are **basic data types that store simple values directly in memory**.

**Explanation**

Java has **8 primitive types**:

* byte
* short
* int
* long
* float
* double
* char
* boolean

They are faster and consume less memory compared to objects.

**Example**

```java
int age = 25;
double salary = 50000.50;
boolean active = true;
```

**Real-world usage**

Primitive types are used to store values like **age, salary, flags, counts, and numeric calculations**.

---

# 4. Autoboxing and Unboxing

**Definition**

Autoboxing is the **automatic conversion of primitive types to wrapper objects**, and unboxing is the **conversion of wrapper objects back to primitive types**.

**Explanation**

Java introduced this feature in **Java 5** to simplify working with collections since collections store objects, not primitives.

**Example**

```java
Integer num = 10;   // Autoboxing
int value = num;    // Unboxing
```

**Real-world usage**

Autoboxing is commonly used when storing primitive values in **collections like List, Set, or Map**.

---

# 5. Access Modifiers

**Definition**

Access modifiers control the **visibility and accessibility of classes, variables, and methods**.

**Explanation**

Java has four access modifiers:

* **private** – accessible only within the same class
* **default** – accessible within the same package
* **protected** – accessible in the same package and subclasses
* **public** – accessible everywhere

**Example**

```java
private int balance;
public void deposit(){}
```

**Real-world usage**

They help implement **encapsulation and security** by controlling which parts of the program can access certain data.

---

# 6. Package in Java

**Definition**

A package is a **namespace used to organize related classes and interfaces**.

**Explanation**

Packages help avoid naming conflicts and make large applications easier to manage.

Java provides built-in packages like:

* `java.util`
* `java.lang`
* `java.io`

**Example**

```java
package com.bank.service;
```

**Real-world usage**

Large applications organize code into packages like:

* `controller`
* `service`
* `repository`
* `model`

---

# 7. Static Keyword

**Definition**

The `static` keyword indicates that a variable or method belongs to the **class rather than an instance of the class**.

**Explanation**

* **Static variables** are shared among all objects.
* **Static methods** can be called without creating an object.

**Example**

```java
class Test {
    static int count = 0;

    static void show() {
        System.out.println("Hello");
    }
}
```

**Real-world usage**

Static members are commonly used for **utility methods, constants, and counters**.

Example: `Math.sqrt()`.

---

# 8. Constructor in Java

**Definition**

A constructor is a **special method used to initialize objects when they are created**.

**Explanation**

Constructors have the same name as the class and do not have a return type.

Types:

* **Default Constructor**
* **Parameterized Constructor**

**Example**

```java
class Employee {
    Employee() {
        System.out.println("Object Created");
    }
}
```

**Real-world usage**

Constructors are used to initialize objects with required values when creating entities like **User, Product, or Order**.

---

# 9. Can we use static methods in a constructor?

**Definition**

Yes, static methods can be called inside a constructor.

**Explanation**

Since static methods belong to the class, they can be accessed directly or using the class name inside the constructor.

However, constructors themselves **cannot be static**.

**Example**

```java
class Test {

    static void display(){
        System.out.println("Static method");
    }

    Test(){
        display();
    }
}
```

**Real-world usage**

Static methods inside constructors are sometimes used for **utility operations like logging or initialization checks**.

---

# 10. Inheritance in Java

**Definition**

Inheritance is a mechanism where one class **acquires properties and methods of another class**.

**Explanation**

It promotes **code reuse and hierarchical relationships**.

Types:

* Single
* Multilevel
* Hierarchical

Java does not support multiple inheritance using classes.

**Example**

```java
class Animal {
    void eat(){}
}

class Dog extends Animal {
}
```

**Real-world usage**

Inheritance is used to build **class hierarchies like Vehicle → Car → ElectricCar**.

---

# 11. Polymorphism

**Definition**

Polymorphism means **one method can behave differently depending on the context**.

**Explanation**

Two types:

* **Compile-time polymorphism** – Method overloading
* **Runtime polymorphism** – Method overriding

**Example**

```java
class Animal {
    void sound(){}
}

class Dog extends Animal {
    void sound(){ System.out.println("Bark"); }
}
```

**Real-world usage**

Polymorphism allows systems to handle **different object types with the same interface**, improving flexibility.

---

# 12. Encapsulation and Abstraction

**Encapsulation**

**Definition**

Encapsulation means **wrapping data and methods together and restricting direct access**.

**Example**

```java
private int balance;

public void setBalance(int balance){
    this.balance = balance;
}
```

---

**Abstraction**

**Definition**

Abstraction means **hiding internal implementation and showing only essential functionality**.

**Example**

```java
abstract class Shape {
    abstract void draw();
}
```

**Real-world usage**

Encapsulation protects sensitive data, while abstraction simplifies complex systems.

---

# 13. Method Overloading vs Method Overriding

**Definition**

Both allow methods with the same name but differ in how they work.

**Explanation**

| Overloading                            | Overriding                      |
| -------------------------------------- | ------------------------------- |
| Same method name, different parameters | Same method name and parameters |
| Compile-time polymorphism              | Runtime polymorphism            |
| Same class                             | Parent-child classes            |

**Example**

```java
void add(int a, int b)
void add(int a, int b, int c)
```

**Real-world usage**

Overloading improves **readability**, while overriding enables **runtime behavior customization**.

---

# 14. Interface vs Abstract Class

**Definition**

Both are used to achieve abstraction but differ in design and usage.

**Explanation**

| Interface                             | Abstract Class                         |
| ------------------------------------- | -------------------------------------- |
| Only abstract methods (before Java 8) | Can have abstract and concrete methods |
| Multiple inheritance supported        | Single inheritance                     |
| Used for contracts                    | Used for partial implementation        |

**Example**

```java
interface Animal {
    void sound();
}
```

**Real-world usage**

Interfaces define **capabilities**, while abstract classes provide **shared base functionality**.

---

# 15. Marker Interface

**Definition**

A Marker Interface is an **empty interface without methods** used to indicate a special capability to the JVM or framework.

**Explanation**

The presence of the interface acts as a **marker or flag**.

**Example**

```java
Serializable
Cloneable
RandomAccess
```

**Real-world usage**

Frameworks check marker interfaces to enable specific behaviors, such as **object serialization**.

---

---

# 16. Difference between String, StringBuilder, and StringBuffer

**Definition**

`String`, `StringBuilder`, and `StringBuffer` are classes used to work with character sequences in Java.

**Explanation**

* **String** → Immutable (cannot be changed after creation)
* **StringBuilder** → Mutable and **not thread-safe**
* **StringBuffer** → Mutable and **thread-safe (synchronized)**

Because of synchronization, **StringBuffer is slower than StringBuilder**.

**Example**

```java
String s = "Hello";
s.concat(" World");   // creates new object

StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");  // modifies same object
```

**Real-world usage**

* **String** → when value should not change
* **StringBuilder** → when modifying strings frequently
* **StringBuffer** → when thread safety is required

---

# 17. Difference between creating String using Literal vs new

**Definition**

Strings can be created using **string literals** or the **new keyword**.

**Explanation**

* **Literal ("Hello")** → stored in the **String Pool**
* **new String("Hello")** → creates a **new object in heap memory**

Even if the same literal exists, `new` will create a new object.

**Example**

```java
String s1 = "Java";
String s2 = "Java";

String s3 = new String("Java");
```

Here:

* `s1` and `s2` refer to the **same object**
* `s3` refers to a **new object**

**Real-world usage**

Using **string literals is preferred** because it improves **memory efficiency** using the String pool.

---

# 18. What is String Pool and how does it work?

**Definition**

String Pool is a special memory area in the **heap** where Java stores string literals.

**Explanation**

When a string literal is created, Java first checks the pool:

* If it exists → reuse the same object
* If not → create a new object in the pool

This helps **avoid duplicate string objects**.

**Example**

```java
String s1 = "Java";
String s2 = "Java";
```

Both `s1` and `s2` refer to the **same memory location**.

**Real-world usage**

String pool improves **memory efficiency in large applications** where many identical strings exist.

---

# 19. Advantages of String Pool

**Definition**

String Pool helps manage string objects efficiently in memory.

**Explanation**

Advantages include:

* Reduces memory usage
* Avoids duplicate objects
* Improves performance
* Faster string comparison using reference equality

**Example**

```java
String a = "Hello";
String b = "Hello";
```

Both variables point to the **same object in the pool**.

**Real-world usage**

Large enterprise systems often reuse many strings like **status values, role names, or configuration keys**.

---

# 20. Why String is Immutable?

**Definition**

In Java, String objects are **immutable**, meaning their values cannot be changed after creation.

**Explanation**

Whenever a modification occurs, Java creates a **new String object instead of modifying the existing one**.

Immutability provides several benefits:

* Security
* Thread safety
* String pool optimization
* Reliable hashing

**Example**

```java
String s = "Hello";
s = s.concat(" World");
```

A **new object** is created instead of modifying the original.

**Real-world usage**

Immutability is important for **security-sensitive operations like URLs, file paths, and database connections**.

---

# 21. What is a Collection in Java?

**Definition**

A Collection in Java is a **framework used to store and manipulate groups of objects dynamically**.

**Explanation**

The **Java Collections Framework (JCF)** provides interfaces and classes such as:

* List
* Set
* Queue
* Map

It provides operations like **adding, removing, searching, and sorting elements**.

**Example**

```java
List<String> list = new ArrayList<>();
list.add("Java");
```

**Real-world usage**

Collections are used everywhere in applications for managing **users, orders, transactions, logs, etc.**

---

# 22. Difference between Array and ArrayList

**Definition**

Array and ArrayList are both used to store elements, but they differ in flexibility and features.

**Explanation**

| Array                | ArrayList                     |
| -------------------- | ----------------------------- |
| Fixed size           | Dynamic size                  |
| Can store primitives | Stores objects only           |
| Faster               | Slightly slower               |
| Part of core Java    | Part of Collections Framework |

**Example**

```java
int[] arr = new int[5];

ArrayList<Integer> list = new ArrayList<>();
```

**Real-world usage**

ArrayList is preferred when **size may change dynamically**.

---

# 23. Difference between ArrayList and LinkedList

**Definition**

Both are implementations of the **List interface** but use different internal data structures.

**Explanation**

| ArrayList          | LinkedList              |
| ------------------ | ----------------------- |
| Uses dynamic array | Uses doubly linked list |
| Fast access        | Fast insertion/deletion |
| Slow insert/delete | Slower access           |

**Example**

```java
List<String> list = new ArrayList<>();
List<String> list2 = new LinkedList<>();
```

**Real-world usage**

* ArrayList → frequent **read operations**
* LinkedList → frequent **insert/delete operations**

---

# 24. What is HashMap? Basic operations

**Definition**

HashMap is a class in Java that stores data in **key-value pairs**.

**Explanation**

It uses a **hashing mechanism** to store and retrieve elements efficiently.

Basic operations:

* `put()` → add element
* `get()` → retrieve value
* `remove()` → delete entry
* `containsKey()` → check key

**Example**

```java
HashMap<Integer, String> map = new HashMap<>();
map.put(1, "John");
map.get(1);
```

**Real-world usage**

HashMap is commonly used for **caching, configuration storage, and lookup tables**.

---

# 25. Difference between HashSet and TreeSet

**Definition**

Both are implementations of the **Set interface** used to store unique elements.

**Explanation**

| HashSet                 | TreeSet             |
| ----------------------- | ------------------- |
| Unordered               | Sorted              |
| Uses HashMap internally | Uses Tree structure |
| Faster                  | Slower              |
| Allows one null         | No null allowed     |

**Example**

```java
Set<Integer> set = new HashSet<>();
Set<Integer> set2 = new TreeSet<>();
```

**Real-world usage**

TreeSet is used when **sorted data is required**.

---

# 26. What is an Iterator?

**Definition**

Iterator is an interface used to **traverse elements in a collection one by one**.

**Explanation**

It provides three main methods:

* `hasNext()`
* `next()`
* `remove()`

It allows safe iteration while modifying collections.

**Example**

```java
Iterator<String> it = list.iterator();

while(it.hasNext()){
    System.out.println(it.next());
}
```

**Real-world usage**

Iterators are useful when **removing elements during iteration**.

---

# 27. Difference between List and Set

**Definition**

List and Set are interfaces in the Java Collections Framework.

**Explanation**

| List                | Set               |
| ------------------- | ----------------- |
| Allows duplicates   | No duplicates     |
| Maintains order     | Usually unordered |
| Allows index access | No index          |

**Example**

```java
List<Integer> list = new ArrayList<>();
Set<Integer> set = new HashSet<>();
```

**Real-world usage**

* List → ordered data like **user history**
* Set → unique data like **user IDs**

---

# 28. Array vs List

**Definition**

Arrays and Lists are used to store multiple elements.

**Explanation**

| Array                | List                          |
| -------------------- | ----------------------------- |
| Fixed size           | Dynamic size                  |
| Can store primitives | Stores objects                |
| Part of core Java    | Part of Collections Framework |

**Example**

```java
int[] arr = {1,2,3};

List<Integer> list = new ArrayList<>();
```

**Real-world usage**

Lists are preferred in modern applications due to **flexibility and built-in methods**.

---

# 29. Set vs List

**Definition**

Both are interfaces used to store collections of objects.

**Explanation**

| List                      | Set                       |
| ------------------------- | ------------------------- |
| Allows duplicates         | Does not allow duplicates |
| Maintains insertion order | No guaranteed order       |
| Supports index access     | No index access           |

**Example**

```java
List<String> list = new ArrayList<>();
Set<String> set = new HashSet<>();
```

**Real-world usage**

* List → storing ordered data like **product lists**
* Set → storing **unique elements like email IDs**

---
---

# 30. What is an Exception? Types of exceptions?

**Definition**
An Exception is an event that **disrupts the normal flow of a program during runtime**.

**Explanation**

Java exceptions are mainly of two types:

* **Checked Exceptions** – checked at compile time
  Example: `IOException`, `SQLException`
* **Unchecked Exceptions** – occur at runtime
  Example: `NullPointerException`, `ArithmeticException`

**Example**

```java
int a = 10/0; // ArithmeticException
```

**Real-world usage**

In a **Spring Boot REST API**, exceptions occur when:

* database connection fails
* invalid user input
* resource not found

We usually handle them using **global exception handlers**.

---

# 31. Difference between checked and unchecked exceptions

**Definition**

Checked and unchecked exceptions differ in **when they are checked by the compiler**.

**Explanation**

| Checked Exception       | Unchecked Exception           |
| ----------------------- | ----------------------------- |
| Checked at compile time | Occur at runtime              |
| Must be handled         | Not mandatory to handle       |
| Example: IOException    | Example: NullPointerException |

**Example**

```java
FileReader fr = new FileReader("test.txt");
```

Requires handling `IOException`.

**Real-world usage**

In projects:

* **Checked exceptions** → file handling, database operations
* **Unchecked exceptions** → programming errors like null values.

---

# 32. What is try-catch-finally block?

**Definition**

It is used to **handle exceptions and prevent program crashes**.

**Explanation**

* **try** → code that may throw exception
* **catch** → handles exception
* **finally** → always executes

**Example**

```java
try {
    int a = 10/0;
} catch(Exception e) {
    System.out.println("Error occurred");
} finally {
    System.out.println("Cleanup code");
}
```

**Real-world usage**

In projects, `finally` is often used for **closing resources like database connections or files**.

---

# 33. Can we use try without catch?

**Definition**

Yes, a `try` block can exist **without a catch block if it has a finally block**.

**Explanation**

Java requires at least **one catch or finally block** with try.

**Example**

```java
try {
    System.out.println("Hello");
} finally {
    System.out.println("Always executes");
}
```

**Real-world usage**

Used when we only need **cleanup operations**, like closing connections.

---

# 34. throw vs throws

**Definition**

Both are used for exception handling but serve different purposes.

**Explanation**

| throw                                 | throws                   |
| ------------------------------------- | ------------------------ |
| Used to explicitly throw an exception | Declares exceptions      |
| Used inside method                    | Used in method signature |

**Example**

```java
throw new IllegalArgumentException("Invalid input");
```

```java
public void readFile() throws IOException
```

**Real-world usage**

In projects, `throws` is often used in **service methods when delegating exception handling to higher layers**.

---

# 35. Use cases of user-defined exceptions

**Definition**

User-defined exceptions are **custom exceptions created by developers**.

**Explanation**

They help represent **business-specific errors**.

**Example**

```java
class InvalidAgeException extends Exception {
}
```

**Real-world usage**

In a project we create custom exceptions like:

* `UserNotFoundException`
* `OrderNotFoundException`
* `InvalidPaymentException`

These improve **readability and error handling in APIs**.

---

# 36. Handling user-defined exceptions

**Definition**

Custom exceptions can be handled using **try-catch or global exception handling**.

**Example**

```java
try {
    throw new UserNotFoundException();
} catch(UserNotFoundException e){
    System.out.println("User not found");
}
```

**Real-world usage**

In Spring Boot projects we usually handle custom exceptions using **@ControllerAdvice global exception handler**.

---

# 37. NullPointerException and prevention

**Definition**

NullPointerException occurs when we try to **use an object reference that is null**.

**Example**

```java
String name = null;
name.length();
```

**Explanation**

This happens when an object is **not initialized properly**.

**Real-world usage**

To prevent it we use:

* null checks
* Optional class
* proper validations

Example in service layer:

```java
if(user != null){
    user.getName();
}
```

---

# 38. ClassCastException

**Definition**

ClassCastException occurs when **an object is cast to an incompatible type**.

**Example**

```java
Object obj = "Java";
Integer num = (Integer) obj;
```

**Explanation**

The object type and casting type must be compatible.

**Real-world usage**

In projects it may happen when **handling generic objects or converting DTOs improperly**.

---

# 39. Error vs Exception

**Definition**

Both represent abnormal situations but differ in severity.

**Explanation**

| Error                     | Exception               |
| ------------------------- | ----------------------- |
| Serious system problem    | Application level issue |
| Cannot be handled         | Can be handled          |
| Example: OutOfMemoryError | Example: IOException    |

**Real-world usage**

Errors usually indicate **JVM or system failures**, while exceptions represent **application logic issues**.

---

# 40. Difference between break and continue

**Definition**

Both are control statements used in loops.

**Explanation**

* **break** → exits the loop completely
* **continue** → skips current iteration

**Example**

```java
for(int i=1;i<=5;i++){
    if(i==3) continue;
}
```

**Real-world usage**

Used in loops when processing **large datasets or filtering records**.

---

# 41. Difference between == and equals()

**Definition**

Both are used to compare objects but work differently.

**Explanation**

| ==                        | equals()         |
| ------------------------- | ---------------- |
| compares memory reference | compares content |
| used for primitives       | used for objects |

**Example**

```java
String a = "Java";
String b = "Java";

a == b       // true
a.equals(b)  // true
```

**Real-world usage**

In projects we usually use **equals() when comparing object values like usernames or IDs**.

---

# 42. What is Spring Boot?

**Definition**

Spring Boot is a framework that simplifies **building Spring-based applications with minimal configuration**.

**Explanation**

It provides:

* auto-configuration
* embedded servers
* production-ready features

**Example**

```java
@SpringBootApplication
public class App {
}
```

**Real-world usage**

Used to build **REST APIs, microservices, and enterprise applications quickly**.

---

# 43. Advantages of Spring Boot

**Definition**

Spring Boot simplifies application development.

**Explanation**

Advantages include:

* Auto configuration
* Embedded servers (Tomcat)
* Less XML configuration
* Faster development

**Real-world usage**

It allows developers to **create microservices quickly without complex setup**.

---

# 44. What is @SpringBootApplication?

**Definition**

`@SpringBootApplication` is the **main annotation used to start a Spring Boot application**.

**Explanation**

It combines three annotations:

* `@Configuration`
* `@EnableAutoConfiguration`
* `@ComponentScan`

**Example**

```java
@SpringBootApplication
public class Application {
}
```

**Real-world usage**

Used in the **main class to bootstrap the application**.

---

# 45. Difference between @Component, @Service, @Repository

**Definition**

These annotations are used to mark classes as **Spring-managed beans**.

**Explanation**

| Annotation  | Usage                |
| ----------- | -------------------- |
| @Component  | Generic bean         |
| @Service    | Business logic layer |
| @Repository | Data access layer    |

**Example**

```java
@Service
public class UserService {
}
```

**Real-world usage**

Typical project structure:

* Controller → API layer
* Service → business logic
* Repository → database operations

---

# 46. What is Dependency Injection?

**Definition**

Dependency Injection is a design pattern where **objects receive dependencies instead of creating them**.

**Explanation**

Spring manages object creation and injection automatically.

**Example**

```java
@Autowired
UserService userService;
```

**Real-world usage**

In projects, controllers receive services through **dependency injection instead of manual object creation**.

---

# 47. What is @Autowired?

**Definition**

`@Autowired` is used to **automatically inject dependencies managed by Spring container**.

**Example**

```java
@Autowired
private UserService userService;
```

**Explanation**

Spring finds the required bean and injects it automatically.

**Real-world usage**

Used in **controllers and services to inject dependencies**.

---

# 48. What are Spring Boot starters?

**Definition**

Spring Boot starters are **predefined dependency packages**.

**Explanation**

They simplify dependency management.

Examples:

* `spring-boot-starter-web`
* `spring-boot-starter-data-jpa`
* `spring-boot-starter-security`

**Real-world usage**

In projects we use starters to **quickly add features like REST APIs, database access, and security**.

---

# 49. What is application.properties file?

**Definition**

`application.properties` is used to **configure application settings**.

**Example**

```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/test
```

**Real-world usage**

Used to configure:

* database
* server port
* logging
* security settings

---

# 50. Difference between Spring and Spring Boot

**Definition**

Spring Boot is an extension of the Spring framework that simplifies configuration.

**Explanation**

| Spring                        | Spring Boot        |
| ----------------------------- | ------------------ |
| Requires manual configuration | Auto configuration |
| External server needed        | Embedded server    |
| More setup required           | Faster development |

**Real-world usage**

Most modern applications prefer **Spring Boot for microservices and REST APIs**.

---

# 51. What is IOC container in Spring?

**Definition**

IOC (Inversion of Control) container is responsible for **creating and managing Spring beans**.

**Explanation**

Instead of objects creating dependencies, the **container injects them automatically**.

**Example**

```java
ApplicationContext context =
 new AnnotationConfigApplicationContext(AppConfig.class);
```

**Real-world usage**

In projects the IOC container manages **controllers, services, repositories, and their dependencies automatically**.

---


---

# 52. What is HTTP? Common HTTP methods?

**Definition**
HTTP (HyperText Transfer Protocol) is a protocol used for **communication between a client and a server over the web**.

**Explanation**

In REST APIs, clients send HTTP requests and the server responds with data.

Common HTTP methods:

* **GET** → retrieve data
* **POST** → create new data
* **PUT** → update existing data
* **DELETE** → remove data
* **PATCH** → partial update

**Example**

```http
GET /users
POST /users
PUT /users/1
DELETE /users/1
```

**Real-world usage in project**

In a **User Management REST API**:

* `GET /users` → fetch users
* `POST /users` → create new user
* `PUT /users/{id}` → update user
* `DELETE /users/{id}` → delete user

---

# 53. What are HTTP status codes?

**Definition**

HTTP status codes indicate the **result of an HTTP request sent to the server**.

**Explanation**

They are grouped into categories:

| Code    | Meaning               |
| ------- | --------------------- |
| **200** | Success               |
| **201** | Resource created      |
| **400** | Bad request           |
| **404** | Resource not found    |
| **500** | Internal server error |

**Example**

```java
return ResponseEntity.ok(user);
```

**Real-world usage in project**

In REST APIs:

* **200** → successful data retrieval
* **404** → user not found
* **500** → server/database failure

Proper status codes make APIs **more understandable for clients**.

---

# 54. What is REST API?

**Definition**

REST API (Representational State Transfer API) is a **web service architecture that allows communication between client and server using HTTP methods**.

**Explanation**

REST APIs use:

* HTTP methods
* JSON for data exchange
* stateless communication
* resource-based URLs

Example endpoint:

```http
GET /users/1
```

**Example**

```java
@GetMapping("/users")
public List<User> getUsers(){
    return userService.getUsers();
}
```

**Real-world usage in project**

In a Spring Boot project we build REST APIs for operations like:

* creating users
* fetching orders
* updating products
* deleting records

---

# 55. What is JSON?

**Definition**

JSON (JavaScript Object Notation) is a **lightweight data format used for data exchange between client and server**.

**Explanation**

It represents data in **key-value format** and is easy to read and parse.

Example JSON:

```json
{
  "id": 1,
  "name": "John",
  "email": "john@email.com"
}
```

**Example**

Spring Boot automatically converts Java objects to JSON using **Jackson library**.

**Real-world usage in project**

In REST APIs:

* client sends JSON request
* server returns JSON response

Example:

User creation request body.

---

# 56. Difference between @RestController and @Controller

**Definition**

Both annotations define controllers in Spring MVC but serve different purposes.

**Explanation**

| Annotation          | Usage                     |
| ------------------- | ------------------------- |
| **@Controller**     | returns view pages (HTML) |
| **@RestController** | returns JSON response     |

`@RestController` is actually a combination of:

```
@Controller + @ResponseBody
```

**Example**

```java
@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
```

**Real-world usage in project**

In **REST API projects**, we mostly use `@RestController` because APIs return **JSON responses instead of HTML views**.

---

# 57. Process of creating a REST API (Spring Boot)

**Definition**

Creating a REST API involves building endpoints that allow clients to interact with the application.

**Explanation**

Typical steps:

1️⃣ Create Spring Boot project
2️⃣ Create **Entity class**
3️⃣ Create **Repository layer**
4️⃣ Create **Service layer**
5️⃣ Create **Controller with REST endpoints**

**Example**

Controller example:

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
```

**Real-world usage in project**

Typical project structure:

```
Controller → handles HTTP requests
Service → business logic
Repository → database operations
Entity → database model
```

Example API flow:

Client → Controller → Service → Repository → Database → Response

---

# 🟡 LEVEL 2: INTERMEDIATE (2–4 Years Experience)

Below are **simple, interview-ready explanations**.
These are written exactly how you can **say them in an interview (30–40 seconds each)**.

---

# Advanced Core Java – Collections Deep Dive

# 58. Contract between hashCode() and equals()

**How you explain in interview**

> In Java, `equals()` and `hashCode()` are used to compare objects, especially in collections like HashMap and HashSet.
> The contract says that if two objects are equal using `equals()`, then they must return the same `hashCode()`.
> However, if two objects have the same `hashCode()`, they may or may not be equal.
>
> This rule ensures that hash-based collections store and retrieve objects correctly.

**Real-world usage**

> In projects, when we store custom objects like `User` or `Employee` in HashMap or HashSet, we override these methods to avoid duplicate objects.

---

# 59. Explain internal working of HashMap

**How you explain in interview**

> HashMap stores data in key-value pairs using a hashing mechanism.
> When we insert a key, Java calls the key’s `hashCode()` method and converts it into a bucket index.
> The value is then stored in that bucket.
> If multiple keys map to the same bucket, a collision occurs and Java stores them using a linked list.
> In Java 8, if the number of collisions increases, the linked list is converted into a balanced tree for better performance.

**Real-world usage**

> In my projects, HashMap is commonly used for caching data or storing mappings like `userId → User object`.

---

# 60. What happens on a HashMap collision?

**How you explain in interview**

> A collision happens when two keys generate the same bucket index in HashMap.
> In this case, Java stores multiple entries in the same bucket using a linked list.
> Starting from Java 8, if the number of entries in a bucket exceeds a threshold, the linked list is converted into a balanced tree to improve search performance.

**Real-world usage**

> Collision handling ensures HashMap still performs efficiently even when storing large amounts of data.

---

# 61. What is load factor in HashMap?

**How you explain in interview**

> The load factor determines when HashMap should resize its internal bucket array.
> The default load factor is **0.75**.
> When the number of entries exceeds `capacity × load factor`, HashMap automatically increases its capacity and rehashes the elements.
> This helps balance memory usage and performance.

**Real-world usage**

> In high-performance systems, adjusting the load factor can help optimize memory and lookup speed.

---

# 62. HashMap vs LinkedHashMap vs TreeMap

**How you explain in interview**

> HashMap, LinkedHashMap, and TreeMap are implementations of the Map interface.
> HashMap does not maintain any order of keys.
> LinkedHashMap maintains insertion order.
> TreeMap stores elements in sorted order using a tree structure.
> HashMap is usually faster, while TreeMap is used when sorted data is required.

**Real-world usage**

> For example, in projects we use TreeMap when we need sorted results like ranking or ordered reports.

---

# 63. HashMap vs LinkedHashMap vs ConcurrentHashMap

**How you explain in interview**

> HashMap and LinkedHashMap are not thread-safe, while ConcurrentHashMap is designed for multi-threaded environments.
> ConcurrentHashMap allows multiple threads to access the map simultaneously without locking the entire map, which improves performance.
> LinkedHashMap maintains insertion order, while HashMap and ConcurrentHashMap do not.

**Real-world usage**

> ConcurrentHashMap is often used in applications where multiple threads access shared data like caching systems.

---

# 64. How can you convert a HashMap into an ArrayList?

**How you explain in interview**

> We can convert a HashMap into an ArrayList by using its `entrySet()` method and passing it to the ArrayList constructor.
> This converts the map entries into a list format.

Example:

```java
List<Map.Entry<Integer,String>> list = new ArrayList<>(map.entrySet());
```

**Real-world usage**

> This is useful when we want to sort map entries or process them using streams.

---

# 65. Comparable vs Comparator

**How you explain in interview**

> Comparable and Comparator are used to sort objects in Java.
> Comparable provides the default sorting logic inside the class using the `compareTo()` method.
> Comparator is used when we want to define custom sorting logic outside the class using the `compare()` method.
> So Comparable gives natural ordering, while Comparator provides flexible custom sorting.

**Real-world usage**

> For example, in projects we may sort employees by salary, name, or joining date using Comparator.

---

# 66. What is ConcurrentHashMap?

**How you explain in interview**

> ConcurrentHashMap is a thread-safe implementation of the Map interface designed for concurrent access.
> Instead of locking the entire map like Hashtable, it allows multiple threads to access different parts of the map simultaneously.
> This improves performance in multi-threaded applications.

**Real-world usage**

> It is commonly used in caching systems and shared data storage where multiple threads read and update data.

---

# 67. Hashtable vs ConcurrentHashMap

**How you explain in interview**

> Both Hashtable and ConcurrentHashMap are thread-safe maps.
> However, Hashtable synchronizes the entire map for every operation, which reduces performance.
> ConcurrentHashMap allows multiple threads to operate on different segments of the map simultaneously, making it more efficient.

**Real-world usage**

> Modern applications prefer ConcurrentHashMap instead of Hashtable because it provides better performance.

---

# 68. Vector vs ArrayList

**How you explain in interview**

> Both Vector and ArrayList store elements in a dynamic array.
> The main difference is that Vector is thread-safe and synchronized, while ArrayList is not synchronized.
> Because of synchronization, Vector is slower, so ArrayList is generally preferred in modern applications.

**Real-world usage**

> In most projects, ArrayList is used unless thread safety is required.

---

# 69. HashMap vs Hashtable

**How you explain in interview**

> HashMap and Hashtable both store key-value pairs.
> The main difference is that HashMap is not thread-safe while Hashtable is synchronized and thread-safe.
> HashMap also allows one null key and multiple null values, whereas Hashtable does not allow null keys or values.

**Real-world usage**

> In modern applications, HashMap or ConcurrentHashMap is usually preferred instead of Hashtable.

---

# 70. ArrayList vs LinkedList

**How you explain in interview**

> ArrayList and LinkedList both implement the List interface but use different data structures.
> ArrayList uses a dynamic array, so accessing elements by index is faster.
> LinkedList uses a doubly linked list, so insertion and deletion operations are faster.
> Therefore ArrayList is preferred for frequent read operations.

**Real-world usage**

> In most applications ArrayList is used because reading data is more common than inserting in the middle.

---

# Java 8 Features

# 71. What is a Functional Interface?

**How you explain in interview**

> A Functional Interface is an interface that contains exactly one abstract method.
> It was introduced in Java 8 to support lambda expressions.
> Even though it has one abstract method, it can contain multiple default or static methods.
> Examples include Predicate, Function, and Consumer.

**Real-world usage**

> Functional interfaces are widely used with lambda expressions and Stream API for cleaner code.

---

# 72. Explain Java 8 features

**How you explain in interview**

> Java 8 introduced several important features such as Lambda expressions, Stream API, Optional class, and functional interfaces.
> Lambda expressions allow writing shorter implementations of functional interfaces.
> Stream API provides a functional way to process collections.
> Optional helps avoid NullPointerException.
> These features improve readability and reduce boilerplate code.

**Real-world usage**

> In projects, streams are commonly used for filtering, mapping, and processing collections.

---

# 73. Difference between map() and flatMap()

**How you explain in interview**

> Both map() and flatMap() are stream operations used to transform data.
> map() performs a one-to-one transformation of elements.
> flatMap() is used when each element contains multiple elements, and it flattens them into a single stream.

**Real-world usage**

> flatMap is useful when working with nested collections like orders containing multiple order items.

---

# 74. What is Stream API?

**How you explain in interview**

> Stream API was introduced in Java 8 to process collections in a functional and declarative way.
> It allows operations like filtering, mapping, sorting, and aggregation without writing complex loops.

Example:

```java
list.stream()
.filter(x -> x > 10)
.forEach(System.out::println);
```

**Real-world usage**

> In projects we use streams for filtering data, transforming objects, and improving readability.

---

# 75. What is Stream pipeline?

**How you explain in interview**

> A stream pipeline is a sequence of operations performed on a stream.
> It consists of three parts: source, intermediate operations, and terminal operation.

Example:

```java
list.stream()
.filter(x -> x > 5)
.map(x -> x * 2)
.forEach(System.out::println);
```

---

# 76. Intermediate vs Terminal operations

**How you explain in interview**

> Intermediate operations transform the stream and return another stream, such as filter(), map(), and sorted().
> Terminal operations produce the final result and trigger execution of the stream pipeline, such as forEach(), collect(), and count().

---

# 77. Find 2nd highest salary using Stream API

**How you explain in interview**

> We can find the second highest salary by sorting the salaries in descending order, skipping the first element, and retrieving the next value.

Example:

```java
employees.stream()
.map(Employee::getSalary)
.sorted(Comparator.reverseOrder())
.skip(1)
.findFirst()
.get();
```

---

# 78. Use of Stream API in projects

**How you explain in interview**

> In my projects, Stream API is mainly used to simplify collection processing.
> It helps filter records, transform objects, remove duplicates, and perform aggregations.
> This reduces complex loops and improves code readability.

---

# 79. Lambda expressions vs Anonymous classes

**How you explain in interview**

> Both lambda expressions and anonymous classes are used to provide implementations for interfaces.
> Lambda expressions provide a shorter and cleaner syntax, while anonymous classes require a full class implementation.
> Lambda expressions are mainly used with functional interfaces.

Example:

```java
Runnable r = () -> System.out.println("Hello");
```

---

---

# Advanced OOP

# 80. What is a Functional Interface?

**How you explain in interview**

> A Functional Interface is an interface that contains exactly one abstract method.
> It was introduced in Java 8 to support lambda expressions.
> Even though it has only one abstract method, it can contain multiple default or static methods.
> The `@FunctionalInterface` annotation is used to ensure that the interface has only one abstract method.
> Examples include Runnable, Predicate, Function, and Consumer.

**Real-world usage**

> Functional interfaces are commonly used with **lambda expressions and Stream API** to write concise and readable code.

---

# 81. What are Sealed Classes (Java 17)?

**How you explain in interview**

> Sealed classes were introduced in Java 17 to control which classes can extend or implement a particular class.
> Using the `sealed` keyword, we can explicitly specify the permitted subclasses.
> This improves security and design control in inheritance hierarchies.

Example:

```java
sealed class Vehicle permits Car, Bike {}
```

**Real-world usage**

> Sealed classes help enforce **strict class hierarchies**, especially in domain models where only certain subclasses are allowed.

---

# 82. What is Fail-Fast Iteration?

**How you explain in interview**

> Fail-fast iterators immediately throw a `ConcurrentModificationException` if a collection is modified while it is being iterated.
> This behavior helps detect errors early during iteration.

Example:

```java
for(String s : list){
    list.remove(s); // causes exception
}
```

**Real-world usage**

> This mechanism prevents unpredictable behavior when collections are modified during iteration.

---

# 83. What is ConcurrentModificationException?

**How you explain in interview**

> ConcurrentModificationException occurs when a collection is modified while it is being iterated using an iterator.
> Java collections like ArrayList and HashMap use fail-fast iterators that detect such modifications and throw this exception.

**Real-world usage**

> To avoid this exception we use:

* Iterator remove()
* Concurrent collections like `CopyOnWriteArrayList`

---

# 84. final, finally, and finalize()

**How you explain in interview**

> These three keywords serve different purposes in Java.
> The `final` keyword is used to restrict modification of variables, methods, or classes.
> `finally` is a block used in exception handling that always executes after try-catch.
> `finalize()` is a method called by the garbage collector before destroying an object.

**Real-world usage**

> In modern Java, `finalize()` is rarely used because garbage collection handles memory automatically.

---

# 85. Autoboxing vs Unboxing

**How you explain in interview**

> Autoboxing is the automatic conversion of primitive data types into their corresponding wrapper objects.
> Unboxing is the reverse process where a wrapper object is converted back into a primitive type.

Example:

```java
Integer num = 10;  // autoboxing
int value = num;   // unboxing
```

**Real-world usage**

> Autoboxing is widely used when working with **collections**, because collections store objects rather than primitives.

---

# 86. What is Cloneable? Deep vs Shallow clone

**How you explain in interview**

> The Cloneable interface is used to indicate that a class allows cloning of its objects using the `clone()` method.
> A shallow clone copies only the object itself but not the objects it references.
> A deep clone creates copies of the object as well as all referenced objects.

**Real-world usage**

> Deep cloning is useful when we need completely independent copies of objects.

---

# 87. Shallow Copy vs Deep Copy

**How you explain in interview**

> A shallow copy copies only the object reference, meaning both objects point to the same underlying data.
> A deep copy creates a completely independent copy of the object and its nested objects.

**Real-world usage**

> Deep copy is used when modifying one object should not affect another object.

---

# Memory Management

# 88. Explain Java memory management

**How you explain in interview**

> Java memory management is handled automatically by the JVM.
> Memory is mainly divided into stack memory and heap memory.
> Objects are stored in the heap, while method calls and local variables are stored in the stack.
> The garbage collector automatically removes unused objects from memory.

**Real-world usage**

> Automatic memory management helps prevent memory leaks and reduces manual memory handling.

---

# 89. What is garbage collection?

**How you explain in interview**

> Garbage collection is the process of automatically freeing memory by removing objects that are no longer referenced in the program.
> The JVM periodically checks for unused objects and deletes them to free heap memory.

**Types of GC**

* Serial GC
* Parallel GC
* G1 GC
* ZGC

**Real-world usage**

> Garbage collection ensures efficient memory usage in long-running applications.

---

# 90. What is finalize() method?

**How you explain in interview**

> The finalize() method is called by the garbage collector before an object is removed from memory.
> It was used to perform cleanup operations, but it is now deprecated and generally not recommended.

---

# 91. Stack vs Heap Memory

**How you explain in interview**

> Stack memory stores method calls and local variables, and it works in a LIFO order.
> Heap memory stores objects created using the `new` keyword and is shared across threads.
> Stack memory is faster but limited, while heap memory is larger and managed by the garbage collector.

---

# 92. Handling OutOfMemoryError

**How you explain in interview**

> OutOfMemoryError occurs when the JVM cannot allocate more memory in the heap.
> To handle it we can increase JVM heap size using JVM options like `-Xmx`, optimize object creation, and fix memory leaks.

---

# Multithreading Basics

# 93. What is multithreading?

**How you explain in interview**

> Multithreading is the ability of a program to execute multiple threads simultaneously.
> A thread is the smallest unit of execution within a process.
> Multithreading improves performance by allowing multiple tasks to run concurrently.

**Real-world usage**

> Used in applications that perform tasks like background processing, API calls, and parallel computations.

---

# 94. What is synchronization?

**How you explain in interview**

> Synchronization is used to control access to shared resources when multiple threads access them simultaneously.
> The `synchronized` keyword ensures that only one thread can execute a block of code at a time.

Example:

```java
synchronized(this){
    // critical section
}
```

---

# 95. wait() vs sleep()

**How you explain in interview**

> The `sleep()` method pauses the execution of a thread for a specified time but does not release the lock.
> The `wait()` method releases the lock and allows other threads to execute until it is notified.

---

# 96. volatile keyword

**How you explain in interview**

> The volatile keyword ensures that a variable’s value is always read from main memory instead of thread cache.
> This guarantees visibility of changes across multiple threads.

---

# 97. What is ThreadLocal?

**How you explain in interview**

> ThreadLocal provides thread-local variables where each thread has its own independent copy of a variable.
> This avoids shared data conflicts between threads.

**Real-world usage**

> Commonly used in frameworks like Spring to store user session data per thread.

---

# 98. What is a deadlock?

**How you explain in interview**

> Deadlock occurs when two or more threads wait indefinitely for resources held by each other.
> This causes the program to stop progressing.

**Avoiding deadlock**

* proper lock ordering
* using timeouts
* avoiding nested locks

---

# 99. Thread vs Runnable

**How you explain in interview**

> In Java we can create a thread either by extending the Thread class or implementing the Runnable interface.
> Runnable is preferred because it allows a class to extend another class while still defining thread behavior.

---

# 100. Runnable vs Callable

**How you explain in interview**

> Runnable and Callable are both used for multithreading tasks.
> Runnable does not return a result and cannot throw checked exceptions.
> Callable can return a result and can throw exceptions.

---

# 101. Synchronized method vs Synchronized block

**How you explain in interview**

> A synchronized method locks the entire method for a thread, meaning only one thread can execute it at a time.
> A synchronized block locks only a specific part of the code.
> Using synchronized blocks improves performance because it limits the locked area.

---


# Advanced Configuration

# 102. How does Spring Boot auto-configuration work?

**How you explain in interview**

> Spring Boot auto-configuration automatically configures beans based on the dependencies present in the classpath.
> When the application starts, Spring Boot checks which libraries are available and automatically creates the required configurations.
> This is mainly enabled by the `@EnableAutoConfiguration` annotation, which is included inside `@SpringBootApplication`.

**Real-world usage**

> For example, when we add the `spring-boot-starter-web` dependency, Spring Boot automatically configures Tomcat, Spring MVC, and JSON converters without manual configuration.

---

# 103. Role of @Configuration and @Bean

**How you explain in interview**

> `@Configuration` indicates that a class contains Spring configuration methods.
> Inside that class, we use the `@Bean` annotation to define beans that should be managed by the Spring container.
> When the application starts, Spring creates and manages these beans automatically.

Example:

```java
@Configuration
public class AppConfig {

    @Bean
    public MyService myService(){
        return new MyService();
    }
}
```

**Real-world usage**

> This is used when we need to configure third-party libraries or custom objects as Spring beans.

---

# 104. How do profiles work in Spring Boot?

**How you explain in interview**

> Spring profiles allow us to use different configurations for different environments like development, testing, and production.
> We can activate a profile using the `spring.profiles.active` property and use the `@Profile` annotation to load specific beans for that environment.

Example:

```java
@Profile("dev")
@Service
public class DevService {}
```

**Real-world usage**

> In projects, we often maintain different database configurations for dev, test, and production environments using profiles.

---

# 105. What is @Transactional?

**How you explain in interview**

> The `@Transactional` annotation is used to manage database transactions automatically.
> It ensures that a group of operations either completes successfully or rolls back completely if an error occurs.
> This helps maintain data consistency.

Example:

```java
@Transactional
public void transferMoney(){
    debit();
    credit();
}
```

**Real-world usage**

> In banking or payment systems, transactions ensure that both debit and credit operations succeed together.

---

# 106. Global exception handler in Spring Boot

**How you explain in interview**

> In Spring Boot we use `@ControllerAdvice` to create a global exception handler that handles exceptions across all controllers.
> Inside it, we use `@ExceptionHandler` methods to handle specific exceptions and return proper responses.

Example:

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(){
        return ResponseEntity.status(500).body("Error occurred");
    }
}
```

**Real-world usage**

> This helps return consistent error responses in REST APIs.

---

# 107. application.properties vs application.yml

**How you explain in interview**

> Both files are used to configure Spring Boot applications.
> `application.properties` uses a key-value format, while `application.yml` uses a hierarchical YAML structure which is easier to read for complex configurations.

Example:

Properties:

```properties
server.port=8080
```

YAML:

```yaml
server:
  port: 8080
```

**Real-world usage**

> Many teams prefer YAML for large configuration files because it is more readable.

---

# 108. CommandLineRunner vs ApplicationRunner

**How you explain in interview**

> Both CommandLineRunner and ApplicationRunner are used to run code after the Spring Boot application starts.
> The main difference is that ApplicationRunner provides access to application arguments in a structured way.

Example:

```java
@Component
public class StartupRunner implements CommandLineRunner {
    public void run(String... args){
        System.out.println("Application started");
    }
}
```

**Real-world usage**

> These runners are often used to initialize data or run startup logic.

---

# 109. Embedded server (Tomcat) in Spring Boot

**How you explain in interview**

> Spring Boot comes with an embedded server like Tomcat, so we don’t need to deploy the application on an external server.
> When the application starts, Spring Boot automatically starts the embedded server and deploys the application within it.

**Real-world usage**

> This makes deployment easier because the application runs as a standalone JAR.

---

# 110. Override default auto-configurations

**How you explain in interview**

> Spring Boot allows us to override default auto-configuration by defining our own configuration beans or by excluding specific auto-configurations using annotations like `@EnableAutoConfiguration(exclude=...)`.

Example:

```java
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
```

**Real-world usage**

> This is useful when we want custom configurations instead of Spring Boot’s default behavior.

---

# 111. Handle circular dependencies in Spring Boot

**How you explain in interview**

> A circular dependency occurs when two beans depend on each other.
> For example, Service A depends on Service B, and Service B depends on Service A.
> To resolve this, we can use constructor injection carefully or use the `@Lazy` annotation to delay bean initialization.

Example:

```java
@Lazy
@Autowired
private ServiceB serviceB;
```

---

# Dependency Injection

# 112. Constructor vs Field vs Setter injection

**How you explain in interview**

> Constructor injection provides dependencies through the class constructor and is considered the best practice because it ensures immutability and easier testing.
> Field injection directly injects dependencies into fields using `@Autowired`.
> Setter injection injects dependencies using setter methods.

**Real-world usage**

> Most modern Spring applications prefer constructor injection.

---

# 113. @Qualifier vs @Primary

**How you explain in interview**

> Both annotations help resolve ambiguity when multiple beans of the same type exist.
> `@Primary` marks one bean as the default bean, while `@Qualifier` specifies exactly which bean should be injected.

---

# 114. @Qualifier vs @Primary precedence

**How you explain in interview**

> If both `@Primary` and `@Qualifier` are used, the `@Qualifier` annotation takes precedence because it explicitly specifies the bean to be injected.

---

# 115. Avoid bean creation failures

**How you explain in interview**

> Bean creation failures can occur due to missing dependencies or configuration errors.
> To avoid this we ensure proper component scanning, correct bean configuration, and proper dependency injection.

---

# 116. @Autowired vs @Qualifier

**How you explain in interview**

> `@Autowired` automatically injects a bean by type, while `@Qualifier` is used along with `@Autowired` to specify the exact bean when multiple beans of the same type exist.

---

# 117. @Primary vs @Qualifier

**How you explain in interview**

> `@Primary` defines a default bean when multiple beans exist, while `@Qualifier` explicitly selects a specific bean during injection.

---

# REST API Advanced

# 118. @RequestMapping vs @GetMapping

**How you explain in interview**

> `@RequestMapping` is a general annotation used to map HTTP requests to controller methods and can handle multiple HTTP methods.
> `@GetMapping` is a specialized version used specifically for HTTP GET requests.

Example:

```java
@GetMapping("/users")
```

---

# 119. @PathVariable vs @RequestParam

**How you explain in interview**

> `@PathVariable` extracts values from the URL path, while `@RequestParam` retrieves query parameters from the request.

Example:

```
/users/10   -> PathVariable
/users?id=10 -> RequestParam
```

---

# 120. @PostMapping vs @PutMapping

**How you explain in interview**

> `@PostMapping` is used to create new resources, while `@PutMapping` is used to update an existing resource.

---

# 121. PUT vs PATCH

**How you explain in interview**

> PUT updates the entire resource, while PATCH updates only specific fields of a resource.

---

# 122. @ExceptionHandler vs @ControllerAdvice

**How you explain in interview**

> `@ExceptionHandler` handles exceptions within a specific controller, while `@ControllerAdvice` provides global exception handling across all controllers.

---


# REST API Advanced, Spring Boot Annotations, Database & JPA Basics



## REST API Advanced

## 118. @RequestMapping vs @GetMapping

**How you explain in interview**

> `@RequestMapping` is a general annotation used to map HTTP requests to controller methods and can support multiple HTTP methods like GET, POST, PUT, and DELETE.
> `@GetMapping` is a specialized shortcut annotation introduced in Spring 4.3 specifically for handling HTTP GET requests.
> It improves readability and makes the code cleaner.

**Example**

```java
@GetMapping("/users")
public List<User> getUsers() {
    return userService.getUsers();
}
```

**Real-world usage**

> In REST APIs we usually prefer `@GetMapping`, `@PostMapping`, etc., instead of `@RequestMapping` for cleaner and more readable code.

---

## 119. @PathVariable vs @RequestParam

**How you explain in interview**

> `@PathVariable` is used to extract values directly from the URL path, while `@RequestParam` retrieves values from query parameters in the request URL.

**Example**

```java
@GetMapping("/users/{id}")
public User getUser(@PathVariable int id) {}
```

```
/users/10
```

```java
@GetMapping("/users")
public User getUser(@RequestParam int id) {}
```

```
/users?id=10
```

**Real-world usage**

> `@PathVariable` is commonly used for resource identifiers like userId, while `@RequestParam` is used for filters or optional parameters.

---

## 120. @PostMapping vs @PutMapping

**How you explain in interview**

> `@PostMapping` is used to create new resources in the system, while `@PutMapping` is used to update an existing resource completely.

**Example**

```java
@PostMapping("/users")
```

Creates a new user.

```java
@PutMapping("/users/{id}")
```

Updates an existing user.

**Real-world usage**

> In REST APIs, POST is typically used when creating records and PUT is used when updating them.

---

## 121. PUT vs PATCH

**How you explain in interview**

> PUT updates the entire resource, meaning all fields are replaced.
> PATCH is used to update only specific fields of the resource without affecting the rest.

**Example**

PUT request

```
PUT /users/1
```

Updates the full user object.

PATCH request

```
PATCH /users/1
```

Updates only specific fields like email or phone.

**Real-world usage**

> PATCH is useful when updating partial data like changing only a user’s address.

---

## 122. @ExceptionHandler vs @ControllerAdvice

**How you explain in interview**

> `@ExceptionHandler` is used inside a controller to handle exceptions specific to that controller.
> `@ControllerAdvice` is used for global exception handling across all controllers.

**Example**

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(){
        return ResponseEntity.status(404).body("User not found");
    }
}
```

**Real-world usage**

> In production APIs we use `@ControllerAdvice` to return consistent error responses for the entire application.

---

# Spring Boot Annotations

## 123. @ComponentScan vs @EnableAutoConfiguration

**How you explain in interview**

> `@ComponentScan` tells Spring where to scan for components like controllers, services, and repositories.
> `@EnableAutoConfiguration` automatically configures Spring beans based on the dependencies present in the project.

**Real-world usage**

> Both annotations are included inside `@SpringBootApplication`, which simplifies Spring Boot configuration.

---

## 124. @Configuration vs @Bean

**How you explain in interview**

> `@Configuration` marks a class as a configuration class that contains bean definitions.
> Inside this class, `@Bean` is used to create and register objects as Spring beans.

**Example**

```java
@Configuration
public class AppConfig {

    @Bean
    public MyService myService(){
        return new MyService();
    }
}
```

**Real-world usage**

> These annotations are commonly used when integrating third-party libraries with Spring.

---

## 125. @Async vs @Scheduled

**How you explain in interview**

> `@Async` is used to run methods asynchronously in a separate thread.
> `@Scheduled` is used to execute methods at fixed intervals or specific times.

**Example**

```java
@Async
public void sendEmail() {}
```

```java
@Scheduled(fixedRate = 5000)
public void generateReport() {}
```

**Real-world usage**

> Async is used for background tasks like sending emails, while scheduled jobs are used for batch processes or report generation.

---

## 126. @Cacheable vs @CacheEvict

**How you explain in interview**

> `@Cacheable` stores method results in cache so that repeated calls return cached data instead of executing the method again.
> `@CacheEvict` removes data from the cache when it becomes outdated.

**Example**

```java
@Cacheable("users")
public User getUser(int id) {}
```

**Real-world usage**

> Caching improves performance by reducing database queries.

---

# Database & JPA Basics

## 127. What is ORM?

**How you explain in interview**

> ORM stands for Object Relational Mapping.
> It is a technique that maps Java objects to database tables, allowing developers to work with objects instead of writing SQL queries directly.

**Real-world usage**

> Frameworks like Hibernate use ORM to simplify database operations.

---

## 128. What is JPA? Difference between JPA and Hibernate

**How you explain in interview**

> JPA (Java Persistence API) is a specification that defines how Java objects should be mapped to database tables.
> Hibernate is an implementation of the JPA specification that provides the actual functionality.

**Real-world usage**

> In Spring Boot applications we typically use JPA with Hibernate as the default ORM implementation.

---

## 129. What is an Entity in JPA?

**How you explain in interview**

> An entity is a Java class that represents a database table.
> Each instance of the entity corresponds to a row in the table.

**Example**

```java
@Entity
public class User {
   @Id
   private Long id;
}
```

---

## 130. Important JPA annotations

**How you explain in interview**

Common JPA annotations include:

* `@Entity` → marks a class as a database entity
* `@Id` → defines the primary key
* `@GeneratedValue` → automatically generates primary key values

**Example**

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

---

## 131. persist() vs merge()

**How you explain in interview**

> `persist()` is used to save a new entity into the database.
> `merge()` is used to update an existing entity by merging its state with the current persistence context.

---

## 132. JPA Relationships

**How you explain in interview**

JPA supports relationships between entities such as:

* `@OneToOne`
* `@OneToMany`
* `@ManyToOne`
* `@ManyToMany`

These annotations define how tables are connected.

**Real-world usage**

> For example, a User can have multiple Orders, which is represented using `@OneToMany`.

---

## 133. What is JPQL?

**How you explain in interview**

> JPQL (Java Persistence Query Language) is similar to SQL but works with Java entity objects instead of database tables.

Example:

```java
SELECT u FROM User u WHERE u.name = 'John'
```

---

## 134. Lazy loading vs Eager loading

**How you explain in interview**

> Lazy loading fetches related data only when it is needed.
> Eager loading fetches related data immediately when the main entity is loaded.

**Real-world usage**

> Lazy loading improves performance by avoiding unnecessary database queries.

---

## 135. save() vs saveAndFlush()

**How you explain in interview**

> `save()` stores the entity in the persistence context and commits it later during transaction commit.
> `saveAndFlush()` immediately writes the changes to the database.

---

## 136. get() vs load() in Hibernate

**How you explain in interview**

> `get()` immediately fetches the object from the database and returns null if it does not exist.
> `load()` returns a proxy object and fetches data only when required. If the object doesn’t exist, it throws an exception.

---

# Testing Basics & Security Basics



---

# Testing Basics

## 137. What is JUnit? Basic annotations?

**How you explain in interview**

> JUnit is a popular testing framework used in Java to write and run unit tests.
> It helps developers verify that individual units of code, like methods or classes, work correctly.
> JUnit provides several annotations to control test execution.

Common annotations include:

* `@Test` → defines a test method
* `@BeforeEach` → runs before every test
* `@AfterEach` → runs after every test
* `@BeforeAll` → runs once before all tests
* `@AfterAll` → runs once after all tests

**Example**

```java
@Test
void testAddition() {
    assertEquals(5, 2 + 3);
}
```

**Real-world usage**

> In projects, JUnit is used to test service methods, repository operations, and business logic.

---

## 138. What is Mockito? When to use @Mock?

**How you explain in interview**

> Mockito is a Java testing framework used to create mock objects for unit testing.
> It helps isolate the class being tested by replacing real dependencies with mock objects.
> The `@Mock` annotation is used to create a mock version of a dependency.

**Example**

```java
@Mock
UserRepository userRepository;
```

**Real-world usage**

> In service layer testing, we mock repositories so that tests run without connecting to the database.

---

## 139. Difference between @Mock, @MockBean, and @Spy

**How you explain in interview**

> `@Mock` creates a mock object using Mockito and is mainly used in unit tests.
> `@MockBean` is used in Spring Boot tests to replace a bean in the application context with a mock object.
> `@Spy` creates a partial mock, meaning it uses the real object but allows certain methods to be mocked.

**Real-world usage**

> `@MockBean` is commonly used in controller or service tests where we need to replace real dependencies.

---

## 140. How do you test REST controllers using MockMvc?

**How you explain in interview**

> MockMvc is used in Spring Boot tests to simulate HTTP requests without starting the full server.
> It allows us to test REST API endpoints by sending requests and verifying responses.

**Example**

```java
mockMvc.perform(get("/users"))
       .andExpect(status().isOk());
```

**Real-world usage**

> This is useful for testing API endpoints, response status codes, and JSON responses.

---

## 141. @SpringBootTest vs @WebMvcTest

**How you explain in interview**

> `@SpringBootTest` loads the full Spring Boot application context and is used for integration testing.
> `@WebMvcTest` loads only the web layer and is used to test controllers specifically.

**Real-world usage**

> `@WebMvcTest` is faster for testing controllers, while `@SpringBootTest` is used when we need to test the entire application flow.

---

# Security Basics

## 142. Authentication vs Authorization

**How you explain in interview**

> Authentication verifies the identity of a user, while authorization determines what actions the authenticated user is allowed to perform.
> In simple terms, authentication answers "Who are you?" and authorization answers "What are you allowed to do?"

**Example**

* Login process → Authentication
* Access control → Authorization

**Real-world usage**

> In applications, users first log in (authentication), and then their roles determine which resources they can access (authorization).

---

## 143. What is Spring Security?

**How you explain in interview**

> Spring Security is a powerful framework used to secure Spring applications.
> It provides authentication, authorization, and protection against common security attacks like CSRF and session fixation.

**Real-world usage**

> It is commonly used to secure REST APIs and web applications.

---

## 144. How do you secure REST APIs using Spring Security?

**How you explain in interview**

> REST APIs can be secured using Spring Security by configuring authentication mechanisms such as Basic Authentication or JWT.
> We define security rules in a configuration class and specify which endpoints require authentication.

**Example**

```java
http.authorizeHttpRequests()
    .requestMatchers("/admin/**").authenticated()
```

**Real-world usage**

> Most modern APIs use JWT-based authentication for stateless security.

---

## 145. BasicAuth vs JWT

**How you explain in interview**

> Basic Authentication sends the username and password with every request in encoded form.
> JWT (JSON Web Token) uses a token generated after login, and the client sends that token with each request for authentication.

**Real-world usage**

> JWT is preferred in modern REST APIs because it supports stateless authentication and better scalability.

---

## 146. HTTP status codes (401, 403, 404, 500, 502, 503)

**How you explain in interview**

| Code    | Meaning                                |
| ------- | -------------------------------------- |
| **401** | Unauthorized – authentication required |
| **403** | Forbidden – access denied              |
| **404** | Resource not found                     |
| **500** | Internal server error                  |
| **502** | Bad gateway                            |
| **503** | Service unavailable                    |

**Real-world usage**

> These status codes help clients understand the result of API requests and handle errors properly.

---



