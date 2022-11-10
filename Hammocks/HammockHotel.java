package Hammocks;

import java.util.Arrays;

/**
 * @version 20221104.2130
 */
public class HammockHotel {

    /** A simple nested class for linkable Nodes */
    class Node {
        String data;
        Node next;
        Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }  // nested class Node

    /** The underlying array of The Hammock Hotel and the default array size */
    private Node[] rooms;
    private static final int DEFAULT_ROOMS_SIZE = 4;

    /** The number of guests currently hanging for dear life in The Hammock Hotel */
    private int usage;

    /** The desired utilization (load factor) threshold for rehashing and its default */
    private double loadFactor;
    private static final double DEFAULT_LOAD_FACTOR = 2.0;

    /** Resizing factor for underlying array and its default */
    private int resizeFactor;
    private static final int DEFAULT_RESIZE_FACTOR = 2;


    /** Full constructor */
    public HammockHotel(int roomsSize, double loadFactor, int resizeFactor) {
        // The following three ternaries ensure that the passed arguments are legal;
        // If not, the default values will be used.
        roomsSize = (roomsSize > 0) ? roomsSize : DEFAULT_ROOMS_SIZE;
        loadFactor = (loadFactor > 1.0) ? loadFactor : DEFAULT_LOAD_FACTOR;
        resizeFactor = (resizeFactor > 1) ? resizeFactor : DEFAULT_RESIZE_FACTOR;
        this.rooms = new Node[roomsSize];
        this.usage = 0;
        this.loadFactor = loadFactor;
        this.resizeFactor = resizeFactor;
    }  // Full constructor


    /** Default constructor */
    public HammockHotel() {
        this(DEFAULT_ROOMS_SIZE, DEFAULT_LOAD_FACTOR, DEFAULT_RESIZE_FACTOR);
    }  // default constructor


    private int hashCode(String string) {
        // int hash = (int) (string.toUpperCase().charAt(0));
        int hashValue = 0;
        for (int i = 0; i < string.length(); i++) {
            hashValue = hashValue + (int) string.charAt(i);
        }
        return hashValue % this.rooms.length;
    }  // method hashCode


    /**
     * Adds a guest to the Hammock hotel by placing the guest to a hammock (or a Node) dangling
     * from a room specified by the hash value of the guest's name.
     *
     * @param guestName String with guest name.
     */
    public void add(String guestName) {
        int roomNumber = this.hashCode(guestName);
        /*
        rooms[i] is essentially the head of the linked list at this position. We
        are adding a new node to the linked list an making that node the new head.
        That's why the linked list at this position, represented by its head (rooms[i])
        is appended to the new node. The new node's next pointer is to node
        rooms[i], the present head of the linked list. And by placing that new
        node at rooms[i], we make the new node the head of the list.
         */
        this.rooms[roomNumber] = new Node(guestName, this.rooms[roomNumber]);
        // Update count of nodes
        this.usage++;
        // Check if utilization is over the threshold for rehashing
        if (this.utilization() > this.loadFactor) {
            // and if it is, rehash.
            this.rehash();
        }
    }  // method add


    /**
     * Rehashes the structure by replacing the underlying array with a larger one.
     */
    private void rehash() {
        // Move guests to a temporary array similar to underlying array
        Node[] oldRooms = this.rooms;
        // Resize the underlying array to something larger
        this.rooms = new Node[this.resizeFactor*oldRooms.length];
        // Very important to reset usage, so that we don't double count guests.
        this.usage = 0;
        // Go room by room in the temporary array
        for (int i = 0; i < oldRooms.length; i++) {
            // start with the first guest
            Node cursor = oldRooms[i];
            // For every guest in the room, add them to the new array
            while (cursor != null) {
                // this.add operates on this.room that just got upsized!
                this.add(cursor.data);
                cursor = cursor.next;
            }
        }
    }  // method rehash


    /**
     * Compute the current utilization of the structure.
     *
     * @return ratio of nodes to number of hotel rooms.
     */
    public double utilization() {
        return (double) this.usage / (double) this.rooms.length;
    }  // method utilization


    /**
     * String representation of the data structure
     * @return String for printing the contents of the data structure
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n\nYour weird hotel has %d rooms and currently %d guests.",
                this.rooms.length, this.usage));
        sb.append(String.format("\nThe utilization rate is %.2f and the rehash threshold is %.2f.\n",
                this.utilization(), this.loadFactor));
        for (int i = 0; i < this.rooms.length; i++) {
            sb.append(String.format("\nRoom[%02d]:", i));
            if (this.rooms[i] == null) {
                sb.append(String.format(" -- the room is empty --"));
            } else {
                Node cursor = this.rooms[i];
                while (cursor != null) {
                    sb.append(String.format("  --> %s", cursor.data));
                    cursor = cursor.next;
                }
            }
        }
        return sb.toString();
    }  // method toString


    /*

                        METHODS FOR THE ASSIGNMENT DUE 11/11/22

     */


    /**
     * Accessor for this.usage
     * @return int this.usage
     */
    public int getUsage() {
        return this.usage;
    }  // method getUsage


    /**
     * Checks if the specified guest is found in one of the rooms.
     *
     * @param guestName String with name of guest to search for
     *
     * @return true if guest is present on one of the hammocks, false otherwise.
     */
    public boolean contains(String guestName) {
        // Initialize return variable
        boolean found = false;
        // Room where guest should be found
        int assignedRoom = this.hashCode(guestName);
        // Explore the hammocks at this room.
        Node hammock = this.rooms[assignedRoom];
        // If the room is empty, the loop won't even run.
        while (!found && hammock != null) {
            // Is the guest in this hammock? If yes, the !found above will break the loop.
            found = hammock.data.equals(guestName);
            // Move to the next hammock, in case we need to try; if null, the loop will end.
            hammock = hammock.next;
        }
        return found;
    }  // method contains


    /**
     * Adds a guest to the hotel if no other guest with the same name is present.
     * The method returns true if the guest has been successfully added; false otherwise.
     *
     * @param guestName String with name of guest to try adding to the hotel
     *
     * @return true if guest was successfully added.
     */
    public boolean addUnique(String guestName) {
        //boolean to store result
        boolean inHotel = false;
        //Check if the hotel does not contain the guest already
        if (!this.contains(guestName)){
            //add the guest if theyre not in the hotel already
            this.add(guestName);
            //update that theyre in the hotel
            inHotel = true;
        }
        //return the result
        return inHotel; 
    }  // method addUnique

    /**
     * Are there any guests in the hotel?
     *
     * @return true if there are absolutely no guests in the hotel and false otherwise.
     */
    public boolean isEmpty() {
        //Return whether the usage is 0
        return this.usage == 0; 
    }  // method isEmpty


    /**
     * Create a String array with the guest names as its elements.
     *
     * @return String array with the names of all the guest.
     */
    public String[] toArray() {
        //create a string to store the names
        String guestString = "";
        //iterate over the length of the hotel
        for (int i = 0; i < this.rooms.length; i++) {
            //skip the rooms that are empty
            if (this.rooms[i] == null){
                continue;
            } else {
                //if they are not empty, create a cursor starting at the current room
                Node cursor = this.rooms[i];
                //while that cursor is not null, i.e. there are still people in that room
                while (cursor != null) {
                    //add the guest names to the guest string
                    guestString = guestString.concat(cursor.data + " ");
                    //increment the cursor
                    cursor = cursor.next;
                }
            }
        }
        //create the array that is going to be returned, by taking the guest string and splitting it at the spaces. 
        String[] guests  = guestString.split(" ");
        //return the array
        return guests; 
    }  // method toArray


    /**
     * Empty the hotel of all guests.
     */
    public void clear() {
        //create new array of the same length as the current hotel
        Node [] oldHotel = new Node[this.rooms.length];
        //set the current hotel to the old one
        this.rooms = oldHotel;
        //reset the usage to 0 since there are no guests
        this.usage = 0;
    }  //  method clear


    /**
     * Create an array with the number of guests in each hotel room
     * @return int array with how many guests are in each room
     */
    public int[] stats() {
        //create new array to store the results
        int[] quantInRoomArray = new int[this.rooms.length];
        //iterate over the length of the hotel
        for (int i = 0; i < this.rooms.length; i++) {
            //if the room is empty, make sure the array reflects that
            if (this.rooms[i] == null){
                quantInRoomArray[i] = 0;
            } else {
                //otherwise create a counter to keep track of how many guests there are
                int quantInRoom = 0;
                //and a cursor to keep track of where we are in the room
                Node cursor = this.rooms[i];
                //while we havent counted all the guests
                while (cursor != null) {
                    //increment the counter and the cursor
                    quantInRoom++;
                    cursor = cursor.next;
                }
                //once we've exhausted the guests in the room, set that equal to the corresponding array element.
                quantInRoomArray[i] = quantInRoom;
            }
        }
        //return the array
        return quantInRoomArray;
    }  // method stats


}  // class HammockHotel