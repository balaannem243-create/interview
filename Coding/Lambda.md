Here are **practical Java 8 Lambda examples** you can use for **interview preparation**, ranging from basic to advanced. These are commonly asked patterns.

---

# 🔹 1. Basic Lambda Syntax

```java
// Traditional
Runnable r1 = new Runnable() {
    public void run() {
        System.out.println("Hello");
    }
};

// Lambda
Runnable r2 = () -> System.out.println("Hello");
r2.run();
```

---

# 🔹 2. Functional Interface Example

```java
@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

public class Test {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println(add.operate(5, 3));       // 8
        System.out.println(multiply.operate(5, 3));  // 15
    }
}
```

---

# 🔹 3. Using Lambda with Collections (forEach)

```java
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack");

        names.forEach(name -> System.out.println(name));
    }
}
```

---

# 🔹 4. Sorting with Lambda

```java
import java.util.*;

public class SortExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 8, 1);

        list.sort((a, b) -> a - b);

        System.out.println(list); // [1, 2, 5, 8]
    }
}
```

👉 Interview twist: descending order

```java
list.sort((a, b) -> b - a);
```

---

# 🔹 5. Filtering using Streams + Lambda

```java
import java.util.*;
import java.util.stream.*;

public class FilterExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25);

        List<Integer> result = numbers.stream()
                .filter(n -> n > 15)
                .collect(Collectors.toList());

        System.out.println(result); // [20, 25]
    }
}
```

---

# 🔹 6. Map Transformation

```java
import java.util.*;
import java.util.stream.*;

public class MapExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("a", "b", "c");

        List<String> upper = names.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(upper); // [A, B, C]
    }
}
```

---

# 🔹 7. Reduce Example (Sum)

```java
import java.util.*;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

        int sum = nums.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum); // 10
    }
}
```

---

# 🔹 8. Predicate Example

```java
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println(isEven.test(4)); // true
        System.out.println(isEven.test(5)); // false
    }
}
```

---

# 🔹 9. Function Example

```java
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> square = n -> n * n;

        System.out.println(square.apply(5)); // 25
    }
}
```

---

# 🔹 10. Consumer Example

```java
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> printer = s -> System.out.println(s);

        printer.accept("Hello Lambda");
    }
}
```

---

# 🔹 11. Custom Comparator with Lambda

```java
import java.util.*;

class Employee {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(
                new Employee("A", 3000),
                new Employee("B", 2000)
        );

        list.sort((e1, e2) -> e1.salary - e2.salary);

        list.forEach(e -> System.out.println(e.name + " " + e.salary));
    }
}
```

---

# 🔹 12. Grouping using Streams

```java
import java.util.*;
import java.util.stream.*;

public class GroupingExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Ravi", "John");

        Map<Integer, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(s -> s.length()));

        System.out.println(grouped);
    }
}
```

---

# 🔹 13. Find Maximum using Lambda

```java
import java.util.*;

public class MaxExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(10, 50, 30);

        int max = nums.stream()
                .max((a, b) -> a - b)
                .get();

        System.out.println(max); // 50
    }
}
```

---

# 🔹 14. Real Interview Question (Most Asked)

👉 Find duplicate elements

```java
import java.util.*;
import java.util.stream.*;

public class DuplicateExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 1);

        Set<Integer> seen = new HashSet<>();

        list.stream()
                .filter(n -> !seen.add(n))
                .forEach(System.out::println);
    }
}
```

---

# 🔹 15. Convert List to Map

```java
import java.util.*;
import java.util.stream.*;

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class ListToMap {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "A"),
                new User(2, "B")
        );

        Map<Integer, String> map = users.stream()
                .collect(Collectors.toMap(u -> u.id, u -> u.name));

        System.out.println(map);
    }
}
```

---
