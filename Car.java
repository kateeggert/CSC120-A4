import java.util.ArrayList;
/**
 * Class for each car in the train, with passengers onboards and a capacity
 */
public class Car implements CarRequirements {
    // Attributes
    private ArrayList<Passenger> passengersOnboard;
    private int capacity;

    /**
     * Constructor
     * @param capacity
     */
    public Car(int capacity) {
        this.capacity = capacity;
        this.passengersOnboard = new ArrayList<>();
    }

    /**
     * Capacity getter
     * @return Capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Calculates seats remaining
     * @return seats remaining
     */
    public int seatsRemaining() {
        int seats = capacity - passengersOnboard.size();
        return seats;
    }

    /**
     * Adds a given passenger onto the train
     * @param p passenger 
     * @return boolean of whether the passenger was successfully added 
     */
    public Boolean addPassenger(Passenger p) {
        // First checks to make sure there is space on the car
        if (seatsRemaining() == 0) {
            return false;
        } 
        // Makes sure passenger isn't already on board
        if(passengersOnboard.contains(p)) {
            return false;
        } else {
            // Boards the passenger
            passengersOnboard.add(p);
            return true;
        }
    }

    /**
     * Removes a given passenger from thr train
     * @param p passenger
     * @return boolean of whether the passenger was successfully removed
     */
    public Boolean removePassenger(Passenger p) {
        // First checks to make sure the passenger is already onboard
        if (passengersOnboard.contains(p)) {
            passengersOnboard.remove(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints manifest of all passengers on board
     */
    public void printManifest() {
        // checks if the car is empty
        if (passengersOnboard.size() == 0) {
            System.out.println("This car is EMPTY.");
        } else {
            System.out.println("This car's manifest is:");
            for (Passenger p : passengersOnboard) {
                System.out.println(p.getName());
            }
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car(20);
        System.out.println("Car capacity is: " + myCar.getCapacity());
        System.out.println("Seats remaining is: " + myCar.seatsRemaining());
        Passenger mia = new Passenger("Mia");
        System.out.println(myCar.addPassenger(mia));
        System.out.println(myCar.addPassenger(mia));
    }
}