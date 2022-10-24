import java.util.Arrays;
import java.util.Random;

/**
 * An array-based demonstration for FIFO and LIFO operations
 * @version 202210151800
 */

public class SimpleXIFO {

    /**
     * An array that stores strings added to it either on a first-available
     * basis (using the addLast method); or inserted as the first element
     * (using the addFirst method).
     */
    private String[] xifo;


    /** A counter that tells us when the xifo array is full or empty */
    private int usage;


    /** Default size for the array if someone calls the default constructor */
    private static final int DEFAULT_SIZE = 4;


    /**
     * Default constructor. Passes the default size value to the basic constructor.
     *
     * DO NOT MODIFY THIS CONSTRUCTOR
     */
    public SimpleXIFO() {
        this(DEFAULT_SIZE);
    }  // Default constructor ... DO NOT MODIFY


    /**
     * Basic constructor. Initializes an array with the specified size and sets
     * its usage to 0.
     *
     * @param size int value of size for the xifo array.
     *
     * DO NOT MODIFY THIS CONSTRUCTOR
     */
    public SimpleXIFO(int size) {
        this.xifo = new String[size];
        this.usage = 0;
    }  // Basic constructor ... DO NOT MODIFY


    /**
     * Last-in.
     *
     * Method adds a string to the first available position in the array, if there
     * is room in the array. Note that the method does not add elements at the
     * last position in the array but at the first available. As more elements
     * are added, they move closer and closer to the end fo the array.
     *
     * @param string String value to the end of the array
     *
     * DO NOT MODIFY THIS METHOD
     */
    public void addLast(String string) {
        // Check that there is room in the array
        if (this.usage < this.xifo.length) {
            this.xifo[usage] = string;
            // Update usage
            usage++;
        }
    }  // method addLast ... DO NOT MODIFY


    /**
     * First out.
     *
     * Method removes the first element of the array.
     *
     * @return String with the value of the first element in the array.
     */
    public String removeFirst() {
        //create an empty string to store what the first element is.
        String removed = "";
        //create a boolean to track if the item in the array is the first one, and a counter to keep track of where we're at in the array
        boolean isFirst = false;
        int counter = 0;
        //iterate over the length of the array, checking if we're at the end, and if we're at the first non-null element
        while (counter < this.xifo.length && !isFirst){
            //if it is the first element, store the value in removed, set the value to null, then change our boolean
            if (this.xifo[counter] != null){
                removed = this.xifo[counter];
                this.xifo[counter] = null;
                isFirst = true;
            }
            //increment the counter
            counter++;
        }
        //return the removed string
        return removed;
    }  // method removeFirst


    /**
     * First in
     *
     * Adds an element at the beginning of the array, if there is room in the
     * array. The method must ensure that existing elements in the array are not
     * lost. For example, consider the array ["C", "B", "A", null]. If we use
     * addFirst("D"), the array must become ["D", "C", "B", "A"].
     *
     * @param string String value to add to the beginning of the array.
     */
    public void addFirst(String string) {
        //check if the usage is less than the length 
        if (this.usage < this.xifo.length){
            //create a temporary array that is the same length as the input one
            String [] temp = new String [this.xifo.length];
            //ensure the first element of the temp array is the new string
            temp[0] = string;
            //iterate over the length of the array, and copy each element of this.xifo into temp, excluding the first element. 
            for (int i = 0; i < temp.length -1; i++) {
                temp[i + 1] = this.xifo[i];
            }
            //make this.xifo = temp
            this.xifo = temp;
        } else {
            //if there is no room in the array, let the user know. 
            System.out.println("There is no room in the Array");
        }
        
    }  // method addFirst

    /** FOR TESTING PURPOSES ONLY. DO NOT MODIFY THIS METHOD */
    public String[] getXifo() {
        return this.xifo;
    }  // method getXifo ... DO NOT MODIFY


    /** FOR TESTING PURPOSES ONLY. DO NOT MODIFY THIS METHOD */
    public String toString() {
        return Arrays.toString(this.xifo);
    }  // method toString ... DO NOT MODIFY


    /**
     * TEST CODE. DO NOT MOFIFY THE MAIN METHOD BUT USE IT TO TEST IF YOUR
     * CODE WORKS AS EXPECTED.
     */
    public static void main(String[] args) {
        int testSize = 12;
        int ascii_A = (int) 'A';
        int letters = 26;
        Random rng = new Random();
        SimpleXIFO fifo = new SimpleXIFO(testSize);
        SimpleXIFO lifo = new SimpleXIFO(testSize);
        for (int i = 0; i < testSize; i++) {
            String dataToAdd = String.valueOf((char) (ascii_A+rng.nextInt(letters)));
            fifo.addFirst(dataToAdd);
            lifo.addLast(dataToAdd);
        }
        String[] ofif = fifo.getXifo().clone();
        String[] ofil = lifo.getXifo().clone();
        // System.out.println(Arrays.toString(ofif));
        // System.out.println(Arrays.toString(ofil));
        boolean fifoTest = true;
        boolean lifoTest = true;
        for (int i = 0; i < testSize; i++) {
            fifoTest = fifoTest && fifo.removeFirst().equals(ofif[i]);
            lifoTest = lifoTest && lifo.removeFirst().equals(ofil[i]);
        }
        boolean symmetry = true;
        for (int i = 0; i < testSize; i++) {
            symmetry = symmetry && ofil[i].equals(ofif[ofif.length-1-i]);
        }
        if (symmetry && fifoTest && lifoTest) {
            System.out.printf("\nYour code seems to be working as expected.\n");
        } else if (!symmetry) {
            System.out.printf("\nYour addFirst method is not quite there yet.\n");
        } else {
            System.out.printf("\nYour removeFirst method is not quite there yet.\n");
        }



    }  // method main ... DO NOT MODIFY
}