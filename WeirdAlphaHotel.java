import java.util.ArrayList;  // For testing only. Not be used in homework solutions
import java.util.Random;  // For testing only. Not be used in homework solutions

public class WeirdAlphaHotel {

    /**
     * The number of rooms in the hotel. This is also the basis for mapping
     * (hashing) a guest to a room. The field has also a default value.
     */
    private int numberOfRooms;
    private static final int DEFAULT_NUMBER_OF_ROOMS = 128;

    /**
     * The number of rooms away from the designated room that we are willing to
     * consider placing a guest if their designated room is not available.
     * The field has also a default value.
     */
    private int probingLength;
    private static final int DEFAULT_PROBING_LENGTH = 3;

    /** The array of hotel rooms */
    private String[] hotel;

    /** The number of rooms currently in use */
    private int usage;

    /**
     * Basic constructor
     * @param numberOfRooms int number of rooms in the hotel
     * @param probingLength int number of rooms to the right of the designated
     *                      room to consider, if designated room is occupied by
     *                      another guest.
     */
    public WeirdAlphaHotel(int numberOfRooms, int probingLength) {
        this.numberOfRooms = numberOfRooms;
        this.probingLength = probingLength;
        this.usage = 0;
        this.hotel = new String[numberOfRooms];
    }  // constructor WeirdAlphaHotel


    /**
     * Default constructor
     */
    public WeirdAlphaHotel() {
        this(DEFAULT_NUMBER_OF_ROOMS, DEFAULT_PROBING_LENGTH);
    }  // constructor WeirdAlphaHotel


    /**
     * Maps a string to an integer number, based on the string's initial letter's
     * ASCII value, modulo the number of rooms in the hotel.
     *
     * @param string String to map
     * @return int with the hash value described above
     */
    private int hash(String string) {
        return ((int) string.toUpperCase().charAt(0)) % this.numberOfRooms;
    }  // method hash


    /**
     * An easy way to tell if there are vacant rooms in hte hotel.
     * @return
     */
    private boolean hasVacancy() {
        return this.usage < this.hotel.length;
    }  // method hasVacancy


    /**
     * An easy way to tell if a hotel room is available
     * @param roomNumber int room number to check
     * @return true if room not assigned to a guest presently, false otherwise.
     */
    private boolean isAvailable(int roomNumber) {
        return this.hotel[roomNumber] == null;
    }  // method isAvailable


    /**
     * Returns the name of the guest in the specified room. If the room is empty
     * or if the specified room is out of range method returns null.
     *
     * @param room int with room number to check
     * @return String with guest name or null if room unoccupied or room value out of bounds
     */
    public String getGuestName(int room) {
        String name = null;
        if (room>=0 && room < this.hotel.length) {
            name = this.hotel[room];
        }
        return name;
    }  // method getGuestName


    /**
     * Adds a guest to the hotel, if there are empty rooms and if the designated
     * room or a nearby room is available.
     *
     * @param guestName String guest to accommodate
     * @return int with room number assigned to guest; or -1 if guest is rejected.
     */
    public int add(String guestName){
        // Assume that we cannot accommodate guest
        int assignedRoom = -1;
        // Check if hotel has available rooms
        if (this.hasVacancy()) {
            // Determine which room this guest should go to
            int designatedRoom = this.hash(guestName);
            // Check if that room is available
            if (this.isAvailable(designatedRoom)) {
                // Place guest here and update assignedRoom and usage
                assignedRoom = designatedRoom;
            } else {
                // Designated room is not available, try nearby rooms, using %
                // to wrap around if we are near the last room in the array.
                if (this.isAvailable((designatedRoom+1)%this.numberOfRooms)) {
                    // Place guest here and update assignedRoom and usage
                    assignedRoom = (designatedRoom+1)%this.numberOfRooms;
                } else if (this.isAvailable((designatedRoom+2)%this.numberOfRooms)) {
                    // Place guest here and update assignedRoom and usage
                    assignedRoom = (designatedRoom+2)%this.numberOfRooms;
                } 
            }
        }
        /*
         * check if the assignedRoom value has changed, which would imply that one of the above if statements was true
         * then add the guest to the hotel and increment the hotel usage. 
         */
        if (assignedRoom != -1){
            this.hotel[assignedRoom] = guestName;
            this.usage++;
        }
        return assignedRoom;
    }  // method add


    /**
     * Removes a guest from a room and makes the room available again.
     *
     * @param room int number of room to vacate
     * @return name of the departing guest
     */
    public String remove(int room) {
        String departingGuest = null;
        //assuming that the specified hotel room is occupied...
        if (this.hotel[room] != null){
            //store the guest name
            departingGuest = this.hotel[room];
            //set the room to null
            this.hotel[room] = null;
            //increment the usage accordingly
            this.usage--;
        }
        //return the name of the departing guest
        return departingGuest;
    }  // method remove


    /**
     * Reports the room number of a specified guest. If there are multiple guests
     * with the same name, method returns the room of the first guest with that
     * name. If no guest with the specified name is found, method will return -1.
     *
     * @param guestName String with guest name to look up
     * @return int with room number where guest is found or -1 if guest not present.
     */
    public int whichRoom(String guestName) {
        //initialize the room number
        int room = -1;
        //while we havent found the appropriate room
        while (room == -1){
            //iterate over the length of the hotel
            for (int i = 0; i < hotel.length; i++) {
                //check if the guest in hotel[i] is the requested guest
                if (this.hotel[i] == guestName){
                    //if it is, store the room number
                    room = i;
                }
            }
        }
        // return the room number
        return room;
    }  // method isGuestHere


    /**
     * Tells if a guest is present in the hotel.If there are multiple guests with
     * the same name, method returns the room of the first guest with that name.
     *
     * @param guestname String with guest name to look up
     * @return true if guest is found, false otherwise.
     */
    public boolean isGuestHere(String guestname) {
        //variable to store the result
        boolean result = false;
        //while we haven't found the guest
        while (!result){
            //for each guest name in the hotel...
            for (String name: this.hotel){
                //check if the guest is the requested guest name
                if (name == guestname){
                    //if it is, store the value in our result variable
                    result = true;
                }
            }
        }
        //return our result variable
        return result; // Rewrite this method to fulfill the functionality described in its Javadoc
    }  // method isGuestHere


    /**
     * FOR TESTING PURPOSES ... DO NOT MODIFY THIS METHOD. Generates a string
     * of random upper case letters, of specified length.
     *
     * @param len int length of string to generate
     * @return String of random characters
     */
    private static String generateGuestName(int len) {
        StringBuilder guestName = new StringBuilder();
        Random rng = new Random();
        int ASCII_A = 65;
        int LETTERS = 26;
        for (int i = 0; i < len; i++) {
            guestName.append(String.valueOf((char) (ASCII_A+rng.nextInt(LETTERS))));
        }
        return guestName.toString();
    }  // method generateGuestName ... DO NOT MODIFY


    /**
     * FOR TESTING PURPOSES ... DO NOT MODIFY THIS METHOD.
     */
    public static void main(String[] args) {
        String PASSED = "Passed";
        String FAILED = "Failed";
        int testHotelSize = 64;
        int testProbingLength = 5;
        int randomStringLength = 5;
        WeirdAlphaHotel test = new WeirdAlphaHotel(testHotelSize, testProbingLength);
        // Assume there are as many guests arriving as rooms: not all of them will be admitted;
        // Idea for possible exam question: what's the max number of hotel guests we can admit in this
        // scheme and why?
        ArrayList<Integer> occupiedRooms = new ArrayList<>();
        for (int guest = 0; guest < testHotelSize; guest++) {
            int room = test.add(generateGuestName(randomStringLength));
            if (room != -1) {
                occupiedRooms.add(room);
            }
        }
        // Test whichRoom and isGuestHere
        boolean successfulWhichRoom = true;
        boolean successfulIsGuestHere = true;
        for (int occupiedRoom: occupiedRooms) {
            String guestName = test.getGuestName(occupiedRoom);
            int guestRoom = test.whichRoom(guestName);
            successfulWhichRoom = successfulWhichRoom && (occupiedRoom == guestRoom);
            boolean guestHere = test.isGuestHere(guestName);
            successfulIsGuestHere = successfulWhichRoom && guestHere;
        }
        String whichRoomTest = (successfulWhichRoom) ? PASSED : FAILED;
        System.out.printf("\n\n  Method whichRoom test: %s", whichRoomTest);
        String isGuestHereTest = (successfulIsGuestHere) ? PASSED : FAILED;
        System.out.printf("\nMethod isGuestHere test: %s", isGuestHereTest);
        // test remove
        boolean successfulRemoval = true;
        while (successfulRemoval && occupiedRooms.size()> 0) {
            int roomToVacate = occupiedRooms.remove(0);
            String guest = test.getGuestName(roomToVacate);
            String departingGuest = test.remove(roomToVacate);
            successfulRemoval = guest.equals(departingGuest);
        }
        String removalTest = (successfulRemoval) ? PASSED : FAILED;
        System.out.printf("\n     Method remove test: %s\n\n", removalTest);
    }  // method main ... DO NOT MODIFY

}  // class WeirdAlphaHotel