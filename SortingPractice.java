import java.util.Arrays;

public class SortingPractice {

    // I could not figure out how to do this with the provided merge method. I look forward to seeing the solution. 
    // I did manage to figure out how to do it recursively as well though, which is sort of cool. You can see that code
    // below in the comments. The code for the assignment is below that. 

    /*
     * static int[] merge(int[] first, int[] second) {
        // Initialize the output array
        int[] merged = new int[first.length+second.length];
        // Initialize array indices; use first letter of array's name
        int f = 0;
        int s = 0;
        int m = 0;
        // While both arrays have elements to process
        while (f < first.length && s < second.length) {
            if (first[f] < second[s]) {
                // Smallest value is in first array
                merged[m++] = first[f++];
            } else {
                // Smallest value is in second array
                merged[m++] = second[s++];
            }
        }
        // Second array has no more elements to process. Focus on first
        while (f < first.length) {
            merged[m++] = first[f++];
        }
        // First array has no more elements to process. Focus on second
        while (s < second.length) {
            merged[m++] = second[s++];
        }
        // Done!
        return merged;
    }  // method merge

    static int[] recursiveMergeSort(int[] array, int low, int high) {
        //System.out.println(Arrays.toString(array));
        if (low == high){
            int [] br = new int [1];
            br [0] = array[low];
            return br;
        }
        int midPoint = (low + high)/ 2;

        int [] temp1 = recursiveMergeSort(array, low, midPoint);
        System.out.println(Arrays.toString(temp1));
        int [] temp2 = recursiveMergeSort(array, midPoint + 1, high);
        System.out.println(Arrays.toString(temp2));

        int [] merged =  merge(temp1, temp2);
        return merged;
    }  // method iterativeMergeSort
     */

/*******************************************************************/
/*Here is the code for the actual assignment */
    /**
     * @param array int array to sort
     * @return int array sorted
     */
    static int [] iterativeMergeSort (int []  array){
        //the outer loop increments current size of the array
        int currentSize;
        //the inner loop increments the start point
        int leftStart;

        //iterate over the length of the array, and change the size of the array each pass, doubling each time. 
        //This makes first 1 element arrays, then 2, then 4, etc. 
        for ( currentSize = 1; currentSize <= array.length -1; currentSize = 2*currentSize){
            //iterate over the length of the array and determine what the start point is to merge from. 
            for(leftStart = 0; leftStart < array.length -1; leftStart += 2*currentSize){
                // set the midpoint for my merge method equal to whichever of the two parameters is smaller.
                int mid = Math.min(leftStart + currentSize -1, array.length -1);
                //determine the right side of the array to be merged. It will vary depending on size of the array
                //and the left start point. 
                int rightEnd = Math.min(leftStart + 2*currentSize -1, array.length-1);
                //merge the arrays
                merge(array, leftStart, mid, rightEnd);
            }
        }
        return array;
    }

    /**
     * I used some code that I found online and adapted to fit our needs for this. I could not figure out how to get 
     * the provided merge and slice methods to work with one another. This method combines the two. 
     * @param array array to be merged
     * @param leftStart the left start of the array
     * @param midPoint the mid point where the array will be sliced
     * @param rightEnd the right end point
     */
    static void merge(int array[], int leftStart, int midPoint, int rightEnd)
    {
        //creating some variables to help with code readability. 
        //i, j, and k are used to keep track of the various for loops below
        int i, j, k;
        int leftLength = midPoint - leftStart + 1;
        int rightLength = rightEnd - midPoint;
      
        //creating two temporary arrays to store the numbers
        int leftTemp[] = new int[leftLength];
        int rightTemp[] = new int[rightLength];
      
        //copying the numbers from the array to the two temporary arrays
        //ensureing that the leftmost numbers go in the left temp, and vice versa
        for (i = 0; i < leftLength; i++){
            leftTemp[i] = array[leftStart + i];
        }
        for (j = 0; j < rightLength; j++){
            rightTemp[j] = array[midPoint + 1+ j];
        }
      
        //reset i, j, and k
        i = 0;
        j = 0;
        k = leftStart;
        /*
         * Sorting the arrays and merging them back into one another. 
         * e.g. if leftTemp = [1,3,6] and rightTemp = [2,5,9]
         * then it will sort them into 
         * [1,2,3,5,9]
         */
        while (i < leftLength && j < rightLength)
        {
            //checking which value is smaller, and putting that one into the array again.
            if (leftTemp[i] <= rightTemp[j])
            {
                array[k] = leftTemp[i];
                i++;
            }
            else
            {
                array[k] = rightTemp[j];
                j++;
            }
            k++;
        }
      
        //if there's any remaining elements in both arrays, they get added in. 
        while (i < leftLength)
        {
            array[k] = leftTemp[i];
            i++;
            k++;
        }
        while (j < rightLength)
        {
            array[k] = rightTemp[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        int[] actual = { 5, 1, 6, 2, 3, 4, 8, 9, 7};
        System.out.println(Arrays.toString(iterativeMergeSort(actual)));

    }

}  // class SortingPractice