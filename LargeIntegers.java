import java.util.HashMap;
import java.util.Scanner;

public class LargeIntegers {
    public static void main (String[] args){
        System.out.print(addIntegers(collectInput()));
    }
    
    //taking input from the user and storing it in a HashMap
    public static HashMap<String, String> collectInput(){
        HashMap<String, String> integers = new HashMap<String, String>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first int:");
        integers.put("first int", input.nextLine());
        System.out.print("Enter second int:");
        integers.put("second int", input.nextLine());
        input.close();
        return integers;
        
    }

    //taking the hashmap from above, extracting the two numbers, and adding them together
    public static String addIntegers (HashMap<String, String> integers){
        String firstInt = integers.get("first int");
        String secondInt = integers.get("second int");

    //making sure that there isnt an index out of bounds exception by ensuring that the second int is longer
        if (firstInt.length() > secondInt.length()){
           String t = firstInt;
           firstInt = secondInt;
           secondInt = t;
        }

        //initializing and declaring a string to store the sum of the two numbers
        String sumString = "";

        int length1 = firstInt.length();
        int length2 = secondInt.length();

        //reversing the strings to help with the math
        firstInt = new StringBuilder(firstInt).reverse().toString();
        secondInt = new StringBuilder(secondInt).reverse().toString();


        //actually doing the math that adds the numbers together. Using carry to keep track of carried values to add back in at the end
        int carry = 0;
        for (int i = 0; i < length1; i++){
            int sum  = ((int)(firstInt.charAt(i) - '0') + (int)(secondInt.charAt(i) - '0') + carry);
            sumString += (char)(sum %10 + '0');

            carry = sum / 10;
        }
        for (int i = length1; i < length2; i++){
            int sum = ((int)(secondInt.charAt(i) - '0') + carry);
            sumString += (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        //adding the carry back in if there is one
        if (carry > 0){
            sumString += (char)(carry + '0');
        }

        //putting the answer back in the correct order
        sumString = new StringBuilder(sumString).reverse().toString();

        return sumString;

    }
}
