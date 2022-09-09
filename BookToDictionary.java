
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.Arrays;

public class BookToDictionary{

    /**
     * Produces a Scanner connected to a text file accessible via the web.
     *
     * The method expects a link to a text file. When accessing material from
     * Project Gutenberg it is import to use the plain text version of a book.
     *
     * DO NOT MODIFY THIS METHOD.
     *
     * @param link String with URL to text file.
     * @return a Scanner for the file or null if connection cannot be made.
     */


    private static final String BOOKURL = "https://www.gutenberg.org/files/98/98-0.txt";
    public static void main(String[] args) {
        // Link to A Tale of Two Cities
        readInput(browseTextFile(BOOKURL));
    } 

    public final static Scanner browseTextFile(final String link) {
        // Declare the return variable
        Scanner fileOnline;
        // Use try/catch to prevent the program from crashing.
        try {
            // Create a URL object from the link provided
            URL url = new URL(link);
            // Turn the URL into a Scanner
            fileOnline = new Scanner(url.openStream());
        } catch (IOException e) {
            // If something goes wrong, prepare to return null Scanner.
            fileOnline = null;
        }
        return fileOnline;
    }  // method browseTextFile

    /**
    * Returns an array containing all elements of input array, but larger
    * @param size Integer value by which to increase the array size.
    * @param a String [] array of which you wish to modify the size.
    * @return String [] new array of increased size. 
    */
    private static String[] increaseArraySize(String [] a, int size){
        //create a new temp array that is some value *size* larger than the input array
        String [] b = new String [a.length + size];
        //copy the contents of the original array into the new array
        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
        //make the original array equal to the temp array and return it
        a = b;
        return a;
    }

    /**
    * Returns a boolean containing the value of whether a supplied string is equal to any of the 
    * values already in the supplied array. 
    * @param a String[] array in which you wish to check for a value.
    * @param testCase String the value that you wish to check for.
    * @return boolean of whether the value is in the array or not. 
    */
    private static boolean arrayContains(String [] a, String testCase){
        //instantiating the result boolean and a counter to keep track of where we're at.
        boolean result = false;
        int counter = 0;
        //looping through the array so long as we haven't found a duplicate and haven't reached the end of the array.
        while (!result && counter < a.length){
            //if the value is not null, set result boolean to the result of whether the value is equal to the test value.
            if (a[counter] != null) result = removePunctuation(a[counter]).equals(testCase);
            //increment the counter
            counter++;
        }
        return result;
    }

    /**
    * Returns a string that has the punctuation and case removed.
    * @param str String that you wish to remove punctuation from.
    * @return String the same string, containing only characters a-z or A-Z. 
    */
    private static String removePunctuation(String str){
        //using regex to replace all characters that are not a-z or A-Z, and converting to lower case, then returning
        //the cleansed string
        str = str.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        return str;
    }

    /**
     * Returns a String [] containing the dictionary
     * @param book Scanner connected to the gutenberg txt file containing the book. 
     * @return String[] an array of the unique words in the book, in the order that they appear. 
     */
    private static String [] readInput(Scanner book){
        //creating the final array that we'll be using to store our dictionary
        String[] dictionary = new String [2];
        //ensuring that the first item of the array is the first word of the book
        dictionary[0] = book.next(); 
        while (book.hasNext()){
            //iterate over the length of the array instantiated above. 
            for (int i = 1; i < dictionary.length; i++){
                //setting a variable to the next word, so as not to continue reading words every time I need to reference it. 
                String word = book.next();
                //checking if the array already contains the word, sans punctuation. 
                if (arrayContains(dictionary, removePunctuation(word)) == false){
                    //assuming the array does not contain the word, adding it to the array. Then increasing the size of the array by 1, so the loop keeps going. 
                    dictionary[i] = removePunctuation(word);
                    dictionary = increaseArraySize(dictionary, 1);
                    System.out.println(Arrays.toString(dictionary));
                //if the word is in the array, take a step back to avoid having a null value in the array. 
                } else {
                    i--;
                } 
            }
        }
        //close the scanner and return the complete dictionary. 
        book.close();
        return dictionary;
    }
}  // class BookToDictionary