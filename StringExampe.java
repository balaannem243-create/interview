import java.sql.Time;
import java.time.MonthDay;
import java.time.temporal.WeekFields;
import java.util.Scanner;

public class StringExampe {
    
    // String (Immutable) Example:-

    // public static void main(String[] args){
    //     String car ="Car Started";

    //     car.concat("with key");
    //     System.out.println("this won't added concat to car string");

    //     car = car.concat("with the key");
    //     System.out.println(car);
    // }


    // StringBuffer Example:-
    // public static void main(String[] args){
    //     StringBuffer sb = new StringBuffer("Hello");

    //     sb.append(" world");
    //     System.out.println(sb);

    //     sb.insert(5, " Java");
    //     System.out.println(sb);

    //     sb.delete(5, 10);
    //     System.out.println(sb);

    //     sb.reverse();
    //     System.out.println(sb);
    // }

    // StringBuilder Example:-
    // public static void main (String[] args){
    //     StringBuilder email = new StringBuilder("Kumarannem08");

    //     email.append("@gmail.com");
    //     System.out.println(email);

    //     email.insert(5, "kiran");
    //     System.out.println(email);

    //     email.deleteCharAt(5);
    //     System.out.println(email);

    //     email.delete(5, 9);
    //     System.out.println(email);

    //     email.replace(0, 5, "Kiran");
    //     System.out.println(email);

    //     email.reverse();
    //     System.out.println(email);
    // }

    // Reverse a String (Without Using Built-in reverse()) :- This approach is NOT efficient for large strings because:
                                                                // String is immutable
                                                                // Each += creates a new object
                                                                // Time Complexity becomes O(n²)

    // public static void main(String[] args){
    //     String str = "Hello";
    //     String reversed = "";

    //     for (int i = str.length()-1; i>=0; i--){
    //         reversed += str.charAt(i);
    //     }
    //     System.out.println(reversed);
    // }

    // Using StringBuilder & StringBuffer :-  Time Complexity: O(n)
    // public static void main(String[] args){
    //     String name = "Bala Kiran Kumar";
    //     String reversedName = new StringBuilder(name).reverse().toString();
    //     // StringBuilder reversedName = new StringBuilder(name).reverse();
    //     // StringBuffer reversedName = new StringBuffer(name).reverse();
    //     System.out.println(reversedName);
    // }

    // Using Character Array :- 
                        // ✅ Time Complexity: O(n)
                        // ✅ No extra string creation
    // public static void main(String[] args){
    //     String name = "Bala Kiran Kumar";           //  Original String
    //     char[] nameReversing = name.toCharArray(); // Convert string to char Array
    //     int start = 0;         // Pointer at the beginning
    //     int end = name.length() - 1; // Pointer at the end

    //     // Swap characters until start crosses end
    //     while (start < end){ 
    //         char temp = nameReversing[start];   // Store the start character
    //         nameReversing[start] = nameReversing[end];  // Put end character at start
    //         nameReversing[end] = temp; // Put stored start character at end

    //         start++;   // Move start forward
    //         end--;  //Move end backward
    //     }
    //     System.out.println(nameReversing);  // Print the reversed array as a string
    // }


// 5️⃣ Using Java 8 Streams :- 
    // public static void main(String[] args){
    //      String name = "Bala Kiran kumar";
    //      String nameReversing = new StringBuilder(name).reverse().toString();

    //      System.out.println(nameReversing);
    // }

  // Check if String is Palindrome
//    public static void main(String[] args){
//         String name = "madam";
//         boolean isPalindrome = true;

//         for(int i=0; i < name.length()/2; i++){
//             if( name.charAt(i) != name.charAt(name.length()- 1- i)){
//                 isPalindrome = false;
//                 break;
//             }
//             System.out.println(isPalindrome);
//         }
//    }

// public static void main(String[] args) {
//         String str = "Bala";

//         String reversed = new StringBuilder(str).reverse().toString();

//         System.out.println(str.equals(reversed));
//     }

// Using Two-Pointer While Loop :-
        // public static void main(String[] args){
        //     String name ="treat";

        //     int left =0;
        //     int right = name.length()-1;
        //     boolean isPalindrome= true;

        //     while (left < right){
        //         if (name.charAt(left++) != name.charAt(right--)){
        //             isPalindrome= false;
        //             break;
        //         }           
        //     }
        //     System.out.println(isPalindrome);
        // }

    //     // Count Occurrences of a Character
    // public static void main(String[] args){
    //     String str= "programming is big to understand in the java, At same point it was very attentive cpograming";
    //     char target = 'g';
    //     int count =0;

    //     for(char c: str.toCharArray()){
    //         if(c == target){
    //             count++;
    //         }
    //     }
    //     System.out.println(count);
    // }

    // 4️⃣ Remove Duplicate Characters
        // public static void main(String[] args){
        //     String str = "programminggg";
        //     String result ="";

        //     for(int i =0; i < str.length(); i++){
        //         if(result.indexOf(str.charAt(i)) == -1){
        //             result += str.charAt(i);
        //         }
        //     }
        //     System.out.println(result);
        // }

        // public static void main(String[] args) {
            
        //     Scanner scanner = new Scanner(System.in);
        //     System.out.print("Verify any given number is Even or Odd: ");
        //     int number = scanner.nextInt();
        //     if (number % 2 == 0){
        //         System.out.println(number + " is an Even number");
        //         if (number %2 ==0) {
        //             System.out.println(number /3 +" is divisible by 3");                   
        //         }
        //         else {
        //             System.out.println(number + " is not divisible by 3");
        //         }
        //     }
        //     else {
        //         System.out.println(number + " is an Odd number");
        //     }
        // }

        // public static void main(String[] args) {
        //     Scanner scanner = new Scanner(System.in);
        //     int student = scanner.nextInt();
        //     if (student < 35) {
        //         System.out.println("Student is Fail");
        //     }
        //     else if (student== 35){
        //         System.out.println("Student is just pass");
        //     }
        //     else if(student >35 && student < 70){
        //         System.out.println("Student secured third class");
        //     }
        //     else if(student >= 70 && student < 85){
        //         System.out.println("Student secured second class");
        //     }
        //     else if(student >= 85){
        //         System.out.println("Student secured first class");
        //     }
        //     else {
        //         System.out.println("Invalid marks entered");
        //     }
        
        // }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int day = scanner.nextInt();
            if(day >= 1 && day <= 5){
        System.out.println("Uff, It's a weekday");
        System.out.println(day + " is a weekday");
    } 
    else if(day == 6 || day == 7){
        System.out.println("Hurray, It's a weekend");
    }
    else {
        System.out.println("Invalid day entered");
    }
}
}