package Coding;

import java.util.Arrays;
import java.util.List;

public class LambdaCodingExamples {
    // public static void main(String[] args) {
    // // 1. Basic Lambda Syntax
    // // Traditional way
    // Runnable r1 = new Runnable() {
    // public void run() {
    // System.out.println("Hello, World!");
    // }
    // };
    // r1.run();
    // }

    // Lambda way
    // Runnable r2 = () -> System.out.println("Hello, Lambda!");
    // r2.run();

    // ------------2. Functional Interface Example------------
    // @FunctionalInterface
    // interface Calculator {
    //     int operation(int a, int b);
    // }

    // public static void main(String[] args) {
    //     Calculator add = (a, b) -> a + b;
    //     Calculator subtract = (a, b) -> a - b;
    //     Calculator multiply = (a, b) -> a * b;
    //     Calculator divide = (a, b) -> a / b;
    //     System.out.println("Addition: " + add.operation(5, 3)); // Output: 8
    //     System.out.println("Subtraction: " + subtract.operation(10, 3)); // Output: 7
    //     System.out.println("Multiplication: " + multiply.operation(15, 3)); // Output: 45
    //     System.out.println("Division: " + divide.operation(9, 3)); // Output: 3

    // }

    // ------------3. Using Lambdas with Collections------------
public static void main(String[] args){
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David","Annemarie");
    // Using lambda to filter names starting with 'A'
   names.stream(). filter(name -> name.startsWith("A")).forEach(name -> System.out.println("Name starting with A: " + name));
}
}
