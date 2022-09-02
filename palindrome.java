import java.util.Scanner;

//method to tell if a string is a palindrome
public class palindrome{
    public static void main (String [] args){
        // taking the user input with scanner and then using the input as the parameter in the isPalindrome method
        Scanner input = new Scanner (System.in);
        System.out.print("Please enter the string: ");
        String sentence = input.nextLine();
        input.close();

        //if isPalindrome returns true, letting the user know that it's a palidrome, or vice versa. 
        if (isPalindrome(removePunctuationAndSpaces(sentence))){
            System.out.println("It's a palindrome!");
        } else {
            System.out.println("It's not a palindrome!");
        }
    }

    //a method that returns a boolean value of representing whether the input string is a palidrome
    public static boolean isPalindrome (String sentence){
        //this method takes the input sentence, reverses it, and then returns a boolean that contains whether it is equal to the original input string. 
        String reverseString = new StringBuilder(sentence).reverse().toString();
        return (reverseString.equals(sentence));
    }


    public static String removePunctuationAndSpaces(String sentence){
        /*removing the punctuation using the replaceAll method from the String class. Making the whole string lowercase. And then splitting the sentence into words using the split 
          method from the String class. Storing each word in the array words. 
        */
        String [] words = sentence.toLowerCase().replaceAll("\\W", "").split("\\s+");
        //creating a new string to store the new, edited string that I can actually work with. 
        String noSpacesNoPunct = "";
        for (int i = 0; i < words.length; i++){
            noSpacesNoPunct += words[i];
        }
        return noSpacesNoPunct;
    }
}