/**
 * Author: Ibrahimi Gul Amiz:)
 * A class to keep track of which seats have been reserved in an arena of seats.
 */
public class SeatReserver {

    //Instance Variables:
    // An array with an entry for each seat.  A true value means the seat is reserved.
    private boolean[] seatsReserved;
    
    // An array with an entry for each seat.  A true value means the seat has been 
    // presented to the user for consideration, but the seat is not yet reserved.
    private boolean[] seatsProposed;

    /**
     * CONSTRUCTOR
     * @param totalSeats the total number of seats in the arena
     */
    public SeatReserver(int totalSeats){
        // Initialize instance variables
        seatsReserved = new boolean[totalSeats];
        seatsProposed = new boolean[totalSeats];

        // Populate both arrays with false (not reserved)
        for (int i = 0; i < totalSeats; i++) {
            seatsReserved[i] = false;
            seatsProposed[i] = false;
        }

    }

    /**
     * Checks if the seat at index seatNum is reserved
     * @param seatNum the index of the seat whose status is being queried
     * @return true if the seat is reserved
     */
    public boolean isSeatReserved(int seatNum){
        if (seatNum < 0 || seatNum >= seatsReserved.length) {
            System.err.println("The seat number is invalid.");
            return false;  // Return false for invalid seat numbers
        } else {
            // Return the actual reservation status of the seat
            return seatsReserved[seatNum];
        }
    }

    /**
     * Reserves a single seat located at seatNum
     * @param seatNum the index of the seat being reserved in the seatsReserved array
     */
    public void reserveIndivSeat(int seatNum){
        // Assumes the seat number is valid
        seatsReserved[seatNum] = true;

    }

    /**
     * Copies the values from copyFrom into copyInto (such that copyInto will be a copy of 
     * copyFrom)
     * @param copyFrom the array to be copied
     * @param copyInto the array which will be filled with the copy
     */
    //@SuppressWarnings("unused")
    private void copyArray(boolean[] copyFrom, boolean[] copyInto) {
        for (int i = 0; i < copyFrom.length; i++) {
            copyInto[i] = copyFrom[i];
        }
    }

    /**
     * Checks if the total number of seats available (not reserved) >= the number of seats 
     * that the user wants to reserve
     * @param numSeatsWanted the total number of seats the user wants to reserve
     * @return true iff enough seats are available.  The seats might not be next to each other.
     */
    public boolean nonContiguousAvailable(int numSeatsWanted){
        int count = 0;
        for (int i = 0; i < seatsReserved.length && numSeatsWanted > 0; i++) {
            if (!seatsReserved[i]) {
                count++;
                if (count == numSeatsWanted) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    /**
     * Checks if it would be possible to reserve numSeatsWanted seats. If it is, it modifies 
     * the seatsProposed array to reflect what seatsReserved would look like if the requested 
     * seats were reserved too.
     * @param numSeatsWanted the total number of seats that the user wants to reserve
     * @return false if it is not possible to reserve the seats.  Return true if seatsProposed 
     * was successfully updated to show what seatsReserved would look like with the new seats 
     * reserved.
     */
    public boolean planNonContiguous(int numSeatsWanted){
        //initialization to count the numSeatsWanted
        int count = 0;
        for (int i = 0; i < seatsReserved.length; i++) {
            //if the seatNum is not reserved it proceeds to propose its reservation. 
            if (!seatsReserved[i]) {
                seatsProposed[i] = true;
                count++;
                //if 
                if (count == numSeatsWanted) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Updates seatsReserved to match seatsProposed
     */
    public void confirmReservation(){
        // HINT: This method should contain a single function call to a function you've already written!
        for (int i = 0; i < seatsReserved.length; i++) {
            if (seatsProposed[i]) {
                seatsReserved[i] = true;
            }
        }
        // Reset the proposed seats array
        seatsProposed = new boolean[seatsReserved.length];
    }   

    /**
     * Prints the seats currently reserved
     */
    public void printSeatsReserved(){
        System.out.println(java.util.Arrays.toString(this.seatsReserved));
    }

    /**
     * Prints the seats which would be reserved if the proposed layout was accepted
     */
    public void printSeatsProposed(){
        System.out.println(java.util.Arrays.toString(this.seatsProposed));
    }

    /**
     * Runs test code.
     */
    public void testCode() {
        SeatReserver sr = new SeatReserver(10);

        System.out.println("Reserve individual seats method test: ");
        sr.reserveIndivSeat(0);
        sr.reserveIndivSeat(4);
        sr.printSeatsReserved();

        System.out.println("\nCheck seat availability method test: ");
        System.out.println("Is seat 0 available? " + sr.isSeatReserved(0));
        System.out.println("Is seat 1 available? " + sr.isSeatReserved(1));

        // Comment out or remove the unnecessary print statement
        // System.out.println("\nTest 3: Reserve contiguous seats");
        // sr.reserveContiguous(4, 2);
        // sr.printSeatsReserved();

        System.out.println("\nPlan non-contiguous seats method test: ");
        sr.planNonContiguous(3);
        sr.printSeatsProposed();

        System.out.println("\nConfirm reservation method test: ");
        sr.confirmReservation();
        sr.printSeatsReserved();
    }

    /**
     * Interested in trying the challenge? Here's the starter code for it! You can replace
     * nonContiguousAvailable with findContiguous, and planNonContiguous with planContiguous
     * to test it! Please let Sage know in the readme if you've done this.
     */
    /**
     * Finds the start of a set of available, contiguous seats (if it exists)
     * @param numSeatsWanted the total number of seats requested
     * @return the index of the start of the contiguous sequence of seats.  Returns -1 if a 
     * contiguous sequence of seats of that size does not exist
     */
    // public int findContiguous(int numSeatsWanted){


    // }

    /**
     * Checks if it would be possible to reserve numSeatsWanted seats in a contiguous sequence. If it is, it modifies the seatsProposed array to reflect what seatsReserved would look like if the requested seats were reserved too.
     * @param numSeatsWanted the total number of seats that the user wants to reserve
     * @return true if it is possible to reserve the desired number of seats contiguously.
     *    Otherwise returns false. 
     */
    // public boolean planContiguous(int numSeatsWanted){


    // }

}
