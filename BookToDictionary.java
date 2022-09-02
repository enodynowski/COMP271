
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class BookToDictionary {

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


    //this method
    public static String  makeBookString(Scanner book){
        String text = "";
        while (book.hasNext()){
            text += book.next();
        }
        return text;
        
    }

    public static int getWordCount(String book){
        book = makeBookString(browseTextFile(BOOKURL));
        String bookTrimmed = book.trim();
        if (bookTrimmed.isEmpty()){
            return 0;
        }
        return bookTrimmed.split("\\s+").length;
    }


    public static String [] makeDictionary(int wordCount, String book){

        String [] dictionary = new String[wordCount];
        dictionary = 
        
        

    }

    /** Use main() to call other methods; don't put all your code in main. */
    
}  // class BookToDictionary










/* getURL
 * readDataFrom(getURL)
 * 
 * 
 * 
 * 
 */