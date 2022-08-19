//Eno Dynowski, COMP-271 - Data Structures, Fall 2022
import java.util.Scanner;

public class LargeIntegers {
    public static void main (String[] args){
        System.out.print(addIntegers(collectInputArray()));
    }
    

    //collectuing input from the users and storing it in an array.
    public static String [] collectInputArray(){

        String [] integers = new String [2];
        Scanner input = new Scanner (System.in);
        System.out.print("Enter first int:");
        integers [0] = input.nextLine();
        System.out.print("Enter second int:");
        integers [1] = input.nextLine();
        input.close();
        return integers;
    }

    //taking the array from above, extracting the two numbers, and adding them together
    public static String addIntegers (String[] integers){
        String firstInteger = integers[0];
        String secondInteger = integers [1];

    //making sure that there isnt an index out of bounds exception by ensuring that the second int is longer
        if (firstInteger.length() > secondInteger.length()){
           String t = firstInteger;
           firstInteger = secondInteger;
           secondInteger = t;
        }

        //initializing and declaring a string to store the sum of the two numbers
        String sumString = "";

        int length1 = firstInteger.length();
        int length2 = secondInteger.length();

        //reversing the strings to help with the math
        firstInteger = new StringBuilder(firstInteger).reverse().toString();
        secondInteger = new StringBuilder(secondInteger).reverse().toString();


        //actually doing the math that adds the numbers together. Using carry to keep track of carried values to add back in at the end
        int carry = 0;
        for (int i = 0; i < length1; i++){
            //this loop iterates through each digit in the first number, and adds it to the second number and keeps track of the carry. 
            int sum  = ((int)(firstInteger.charAt(i) - '0') + (int)(secondInteger.charAt(i) - '0') + carry);
            //adding the sum to the final result. 
            sumString += (char)(sum %10 + '0');

            carry = sum / 10;
        }

        //this loop iterates through the rest of the digits in the second number, which we forced to be longer above, and adds them to the sum in the same manner as above. 
        for (int i = length1; i < length2; i++){
            int sum = ((int)(secondInteger.charAt(i) - '0') + carry);
            sumString += (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        //adding the leftover carry back in if there is one
        if (carry > 0){
            sumString += (char)(carry + '0');
        }

        //putting the answer back in the correct order
        sumString = new StringBuilder(sumString).reverse().toString();

        return sumString;

    }
}
