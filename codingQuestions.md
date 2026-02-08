Got you 👍 — here are **clean, interview-ready Java answers** for each problem.
I’ll keep them **simple, correct, and easy to explain aloud**.

---

## 1️⃣ Reverse a Number

### Logic

* Take last digit using `% 10`
* Build reversed number
* Remove last digit using `/ 10`

### Code

```java
public class ReverseNumber {
    public static void main(String[] args) {
        int num = 1234;
        int rev = 0;

        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num = num / 10;
        }

        System.out.println(rev);
    }
}
```

### Time & Space

* Time: `O(n)`
* Space: `O(1)`

---

## 2️⃣ Find Factorial of a Number

### Iterative Approach (Preferred)

```java
public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        System.out.println(fact);
    }
}
```

---

### Recursive Approach

```java
static long factorial(int n) {
    if (n == 0 || n == 1)
        return 1;
    return n * factorial(n - 1);
}
```

### Interview Tip

👉 Iterative = better (no stack overflow)

---

## 3️⃣ Check if a Number Is Prime

### Logic

* 1 is not prime
* Check divisibility till `sqrt(n)`

### Code

```java
public class PrimeCheck {
    public static void main(String[] args) {
        int n = 29;
        boolean isPrime = true;

        if (n <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        System.out.println(isPrime);
    }
}
```

### Complexity

* Time: `O(√n)`
* Space: `O(1)`

---

## 4️⃣ Fibonacci Series

### Iterative Approach (Optimized)

```java
public class Fibonacci {
    public static void main(String[] args) {
        int n = 7;
        int a = 0, b = 1;

        System.out.print(a + " " + b + " ");

        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
```

---

### Recursive Approach (Not Recommended)

```java
static int fib(int n) {
    if (n <= 1)
        return n;
    return fib(n - 1) + fib(n - 2);
}
```

### Interview Tip

👉 Recursion = exponential time ❌
👉 Iteration = best choice ✅

---

## 5️⃣ Swap Two Numbers Without Using Third Variable

### Using Addition & Subtraction

```java
int a = 10;
int b = 20;

a = a + b;
b = a - b;
a = a - b;

System.out.println(a + " " + b);
```

---

### Using XOR (Safest)

```java
int a = 10;
int b = 20;

a = a ^ b;
b = a ^ b;
a = a ^ b;

System.out.println(a + " " + b);
```

### Interview Tip

👉 XOR avoids overflow issues

---

## 🔥 Quick Interview Summary

| Question       | Best Approach |
| -------------- | ------------- |
| Reverse number | `%` and `/`   |
| Factorial      | Iteration     |
| Prime check    | Loop till √n  |
| Fibonacci      | Iteration     |
| Swap numbers   | XOR           |

---

If you want next:

* 📝 Add these **directly into your MD file**
* 🎯 More coding answers (missing number, anagram, move zeros)
* 🎤 Mock **live coding interview**

Just tell me 🚀

---
Perfect 👍 — here are **clean, interview-ready Java answers** for each **intermediate coding question**, with **clear logic + efficient code + interview tips**.

---

## 6️⃣ Find Missing Number in an Array

### Logic (Sum Formula)
For numbers from `1` to `n`:
```
Expected Sum = n * (n + 1) / 2
Missing = Expected Sum - Actual Sum
```

### Code
```java
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int n = arr.length + 1;

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        System.out.println("Missing number: " + (expectedSum - actualSum));
    }
}
```

### Complexity
- Time: `O(n)`
- Space: `O(1)`

---

## 7️⃣ Remove Duplicates from an Array

### Using `HashSet` (Best & Clean)
```java
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 3};

        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        System.out.println(set);
    }
}
```

### Output
```
[1, 2, 3, 4]
```

---

### Without Extra Space (Sorted Array)
```java
public class RemoveDuplicatesNoExtraSpace {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4};

        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                arr[++j] = arr[i];
            }
        }

        for (int i = 0; i <= j; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

---

## 8️⃣ First Non-Repeating Character in a String

### Logic
- Count frequency using `LinkedHashMap`
- Preserve insertion order

### Code
```java
import java.util.*;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String str = "java";

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
```

### Complexity
- Time: `O(n)`
- Space: `O(n)`

---

## 9️⃣ Count Character Occurrences in a String

### Code
```java
import java.util.*;

public class CharacterCount {
    public static void main(String[] args) {
        String str = "hello";

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map);
    }
}
```

### Output
```
{h=1, e=1, l=2, o=1}
```

### Interview Tip
👉 `getOrDefault()` is Java 8+

---

## 🔟 Check if Two Strings Are Anagrams

### Approach 1️⃣: Using HashMap (Best)
```java
import java.util.*;

public class AnagramCheck {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        if (s1.length() != s2.length()) {
            System.out.println(false);
            return;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s2.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }

        for (int count : map.values()) {
            if (count != 0) {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
}
```

---

### Approach 2️⃣: Sorting (Simpler)
```java
import java.util.*;

public class AnagramSort {
    public static void main(String[] args) {
        char[] a = "listen".toCharArray();
        char[] b = "silent".toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println(Arrays.equals(a, b));
    }
}
```

---

## 🔥 Interview Cheat Table

| Question | Best Technique |
|-------|---------------|
| Missing number | Sum formula |
| Remove duplicates | HashSet |
| First non-repeating char | LinkedHashMap |
| Char count | HashMap |
| Anagram | HashMap / Sorting |

---

If you want next:
- 🧑‍💻 **Advanced coding answers** (move zeros, longest substring, intersections)
- 📝 Merge all answers into your **MD interview notes**
- 🎤 **Mock coding interview (intermediate → advanced)**

Just say the word 🚀

# 🔹 Collections + Logic (Interview Favorites)
Awesome 👍 — here are **clear, interview-ready Java answers** for **11️⃣–15️⃣**, with **clean logic, readable code, and tips**.

---

## 1️⃣1️⃣ Sort a `HashMap` by Value

### Java 8 (Streams – Preferred)

```java
import java.util.*;
import java.util.stream.*;

public class SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 3);
        map.put("B", 1);
        map.put("C", 2);

        Map<String, Integer> sortedMap =
            map.entrySet()
               .stream()
               .sorted(Map.Entry.comparingByValue())
               .collect(Collectors.toMap(
                   Map.Entry::getKey,
                   Map.Entry::getValue,
                   (e1, e2) -> e1,
                   LinkedHashMap::new
               ));

        System.out.println(sortedMap);
    }
}
```

### Output

```
{B=1, C=2, A=3}
```

### Interview Tip

👉 Use `LinkedHashMap` to preserve sorted order

---

## 1️⃣2️⃣ Find Duplicates in a String

### Logic

* Use `HashMap` to count characters
* Print characters with count > 1

### Code

```java
import java.util.*;

public class DuplicateCharacters {
    public static void main(String[] args) {
        String str = "programming";

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
```

### Output

```
r g m
```

---

## 1️⃣3️⃣ Find Longest Word in a Sentence

### Code

```java
public class LongestWord {
    public static void main(String[] args) {
        String sentence = "Java coding interviews are challenging";

        String[] words = sentence.split(" ");
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        System.out.println("Longest word: " + longest);
    }
}
```

### Interview Tip

👉 Watch for punctuation in real interviews

---

## 1️⃣4️⃣ Find Intersection of Two Arrays

### Using `HashSet` (Best)

```java
import java.util.*;

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {2, 3, 4};

        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int num : a) {
            set.add(num);
        }

        for (int num : b) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        System.out.println(result);
    }
}
```

### Output

```
[2, 3]
```

### Complexity

* Time: `O(n + m)`
* Space: `O(n)`

---

## 1️⃣5️⃣ Find Frequency of Elements in an Array

### Code

```java
import java.util.*;

public class FrequencyCount {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 4, 2};

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(map);
    }
}
```

### Output

```
{1=2, 2=3, 3=1, 4=1}
```

---

## 🔥 Interview Cheat Summary

| Question           | Best Approach           |
| ------------------ | ----------------------- |
| Sort map by value  | Streams + LinkedHashMap |
| Duplicate chars    | HashMap                 |
| Longest word       | Split + loop            |
| Array intersection | HashSet                 |
| Frequency count    | HashMap                 |

---

If you want next:

* 🧑‍💻 **Advanced coding answers** (move zeros, longest substring, sliding window)
* 📝 Combine **all coding answers into one MD file**
* 🎤 **Mock coding interview (intermediate → advanced)**

Just tell me 🚀

---

# 🔹 Advanced / Tricky Coding Questions
Perfect 👍 — here are **clean, interview-ready Java answers** for **16️⃣–20️⃣**, with **clear logic + efficient code + edge cases covered**.

---

## 1️⃣6️⃣ Check if Array Is Sorted (Ascending)

### Logic

* Traverse once
* If any element > next element → not sorted

### Code

```java
public class CheckSorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        boolean isSorted = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                break;
            }
        }

        System.out.println(isSorted);
    }
}
```

### Edge Cases

* Empty array → sorted
* Single element → sorted

👉 **Time:** `O(n)` | **Space:** `O(1)`

---

## 1️⃣7️⃣ Find Largest and Smallest Number in an Array

### Logic

* Single traversal
* Track `min` and `max`

### Code

```java
public class MinMax {
    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 1, 7};

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
```

👉 **Time:** `O(n)` (best possible)

---

## 1️⃣8️⃣ Move All Zeros to End of Array

### Logic (Two-Pointer)

* `j` tracks position for non-zero elements
* Maintain relative order

### Code

```java
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 3};

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j++] = arr[i];
            }
        }

        while (j < arr.length) {
            arr[j++] = 0;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

### Output

```
1 2 3 0 0
```

👉 **Time:** `O(n)` | **Space:** `O(1)`

---

## 1️⃣9️⃣ Find Second Non-Repeating Character

### Logic

* Use `LinkedHashMap` to preserve order
* Count frequencies
* Return second character with count = 1

### Code

```java
import java.util.*;

public class SecondNonRepeatingChar {
    public static void main(String[] args) {
        String str = "swiss";

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
                if (count == 2) {
                    System.out.println(entry.getKey());
                    return;
                }
            }
        }

        System.out.println("Not found");
    }
}
```

👉 Interview tip: If not found, handle gracefully.

---

## 2️⃣0️⃣ Implement Your Own `HashMap` (Logic Only)

⚠️ **This is conceptual + partial implementation** — interviewers care about **approach**, not full production code.

---

### Key Concepts

* Array of buckets
* Hashing using `hashCode()`
* Collision handling using linked list

---

### Simplified Implementation

```java
class MyHashMap<K, V> {

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 16;
    private Node<K, V>[] table;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Node[capacity];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = table[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> head = table[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }
}
```

---

### Interview Talking Points (VERY IMPORTANT)

* Hashing → `hashCode()`
* Buckets → array index
* Collisions → linked list
* Time complexity:

  * Average → `O(1)`
  * Worst → `O(n)`

---

## 🔥 Final Cheat Sheet (16–20)

| Question          | Best Technique    |
| ----------------- | ----------------- |
| Check sorted      | Single pass       |
| Min & max         | Single traversal  |
| Move zeros        | Two-pointer       |
| Second non-repeat | LinkedHashMap     |
| Custom HashMap    | Buckets + hashing |

---

If you want:

* 📝 **All coding answers merged into one MD file**
* 🎯 **Senior-level follow-ups** (rehashing, load factor, resizing)
* 🎤 **Full mock coding interview (FAANG-style)**

Just say the word 🚀

---

# 🔹 Multithreading Coding Questions
Great set 👌 — these are **real multithreading + Java 8 coding questions** that interviewers love.  
Here are **clear, working Java solutions** with **simple explanations**.

---

## 2️⃣1️⃣ Print Numbers 1–10 Using Two Threads

### Requirement
- Thread A → prints odd numbers
- Thread B → prints even numbers
- Use `wait()` / `notify()`

### Code
```java
class PrintNumbers {
    private int number = 1;
    private final int MAX = 10;

    public synchronized void printOdd() {
        while (number <= MAX) {
            if (number % 2 == 0) {
                try { wait(); } catch (InterruptedException e) {}
            }
            System.out.println(Thread.currentThread().getName() + ": " + number++);
            notify();
        }
    }

    public synchronized void printEven() {
        while (number <= MAX) {
            if (number % 2 != 0) {
                try { wait(); } catch (InterruptedException e) {}
            }
            System.out.println(Thread.currentThread().getName() + ": " + number++);
            notify();
        }
    }
}

public class TwoThreads {
    public static void main(String[] args) {
        PrintNumbers obj = new PrintNumbers();

        new Thread(obj::printOdd, "Odd").start();
        new Thread(obj::printEven, "Even").start();
    }
}
```

### Interview Tip
👉 Always use `wait()` inside a loop (spurious wakeups)

---

## 2️⃣2️⃣ Producer–Consumer Problem

### Using `wait()` / `notify()`

```java
import java.util.*;

class ProducerConsumer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 5;

    public synchronized void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            while (queue.size() == LIMIT) {
                wait();
            }
            queue.add(value);
            System.out.println("Produced: " + value++);
            notify();
            Thread.sleep(500);
        }
    }

    public synchronized void consume() throws InterruptedException {
        while (true) {
            while (queue.isEmpty()) {
                wait();
            }
            int val = queue.poll();
            System.out.println("Consumed: " + val);
            notify();
            Thread.sleep(500);
        }
    }
}

public class ProducerConsumerTest {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        new Thread(() -> {
            try { pc.produce(); } catch (Exception e) {}
        }).start();

        new Thread(() -> {
            try { pc.consume(); } catch (Exception e) {}
        }).start();
    }
}
```

### Interview Tip
👉 Real systems use `BlockingQueue` (simpler & safer)

---

## 2️⃣3️⃣ Deadlock Example and Fix

### Deadlock Example ❌
```java
class DeadlockExample {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 got lock1");
                synchronized (lock2) {
                    System.out.println("Thread 1 got lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 got lock2");
                synchronized (lock1) {
                    System.out.println("Thread 2 got lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

---

### Fix: Lock Ordering ✅
```java
synchronized (lock1) {
    synchronized (lock2) {
        // safe
    }
}
```

### Interview Line
> Deadlock happens due to circular lock dependency

---

# 🔹 Java 8 Coding Questions

## 2️⃣4️⃣ Filter Even Numbers Using Streams

```java
import java.util.*;

public class EvenNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        list.stream()
            .filter(n -> n % 2 == 0)
            .forEach(System.out::println);
    }
}
```

### Output
```
2 4 6
```

---

## 2️⃣5️⃣ Find Max Number Using Streams

```java
import java.util.*;

public class MaxNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 5, 20, 8);

        int max = list.stream()
                      .max(Integer::compare)
                      .orElseThrow();

        System.out.println(max);
    }
}
```

---

## 🔥 Interview Cheat Summary

| Question | Key Concept |
|--------|------------|
| Two threads print | wait/notify |
| Producer–Consumer | thread communication |
| Deadlock | lock ordering |
| Streams filter | lambda |
| Streams max | comparator |

---

If you want next:
- 📝 Merge **all multithreading + Java 8 code into MD**
- 🎯 Advanced follow-ups (`BlockingQueue`, `CompletableFuture`)
- 🎤 **Senior concurrency mock interview**

Just say the word 🚀
---

### 2️⃣6️⃣ Count word frequency using streams

---

### 2️⃣7️⃣ Sort list of strings by length using lambda
