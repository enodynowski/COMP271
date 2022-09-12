/**
 * Dresser as a metaphor for a dynamically sized array.
 *
 * @version 20220909.1700
 * 
 */

public class Dresser {

    // Upgrade factor: multiplier for old dresser size
    public static final int UPGRADE_FACTOR = 2;

    // Number of drawers
    static int totalDrawers = 4;

    // Number of drawers used
    static int usedDrawers = 0;

    // The dresser
    static String[] ourDresser = new String[totalDrawers];


    /**
     * Adds an item to a drawer; each drawer can contain only one kind of items.
     *
     * @param item String with kind of items contained in drawer.
     */
    public static void addToDrawer(String item) {
        // Make sure there is still empty drawers in the dresser
        if (usedDrawers == totalDrawers) {
            // upgrade dresser
            upgradeDresser();
        }
        //iterate over length of dresser and check if value is null. If it is, make it the value of null. 
        for (int i = 0; i < ourDresser.length; i++) {
            if(ourDresser[i]== null){
                ourDresser[i] = item;
            }
        }
        // add the new item to a drawer
        // increment the count of used drawers
        usedDrawers++;
    }  // method addToDrawer


    /**
     * Resizes the dresser.
     *
     */
    public static void upgradeDresser() {
        // Create a new dresser that is larger than the old dresser
        String[] newDresser = new String[UPGRADE_FACTOR*ourDresser.length];
        // Copy items from old dresser to new dresser
        for (int i = 0; i < ourDresser.length; i++) {
            newDresser[i] = ourDresser[i];
        }
        // Replace current dresser with new dresser
        ourDresser = newDresser;
    }  // method upgradeDresser


    /**
     * Clears the most recently used drawer.
     *
     * Method checks first that there is at least one drawer used.
     * @param drawer specifies the drawer to be emptied
     */
    public static void clearDrawer(int drawer) {
        // Make sure that there is at least one drawer used.
        if (usedDrawers > 0) {
            // Empty the contents of the specified drawer
            ourDresser[drawer] = null;
            // Reduce the number of used drawers
            usedDrawers--;
        }
    }  // method clearDrawer


    /**
     * Displays contents of dresser
     */
    public static void showContents() {
        System.out.printf("\n\nYour dresser has %d drawers with the following items:\n", totalDrawers);
        for (int i = 0; i < ourDresser.length; i++) {
            System.out.printf("\tDrawer %d: %s\n", i + 1, ourDresser[i]);
        }
    }  // method showContents


    /**
     * Test code
     */
    public static void main(String[] args) {
        addToDrawer("Socks");
        addToDrawer("Tee-shirts");
        addToDrawer("Cufflinks");
        addToDrawer("Bowties");
        addToDrawer("Neckties");
        showContents();
    }  // method main

} // class Dresser