import java.util.ArrayList;

public class Car implements CarRequirements {
    // Attributes
    private ArrayList<Passenger> PassengersOnboard;
    private int Capacity;

    /**
     * Constructor
     * @param Capacity
     */
    public Car(int Capacity) {
        this.Capacity = Capacity;
        this.PassengersOnboard = new ArrayList<>();
    }

    /**
     * Capacity getter
     * @return Capacity
     */
    public int getCapacity() {
        return Capacity;
    }

    /**
     * Calculates seats remaining
     * @return seats remaining
     */
    public int seatsRemaining() {
        int seats = Capacity - PassengersOnboard.size();
        return seats;
    }

    /**
     * Adds a given passenger onto the train
     * @param p passenger 
     * @return boolean of whether the passenger was successfully added 
     */
    public Boolean addPassenger(Passenger p) {
        // First checks to make sure there is space on the car, then adds the passenger
        if (seatsRemaining() > 0) {
            PassengersOnboard.add(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a given passenger from thr train
     * @param p passenger
     * @return boolean of whether the passenger was successfully removed
     */
    public Boolean removePassenger(Passenger p) {
        // First checks to make sure the passenger is already onboard
        if (PassengersOnboard.contains(p)) {
            PassengersOnboard.remove(p);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prints manifest of all passengers on board
     */
    public void printManifest() {
        if (PassengersOnboard.size() == 0) {
            System.out.println("This car is EMPTY.");
        } else {
            System.out.println("This car's manifest is:");
            for (Passenger p : PassengersOnboard) {
                System.out.println(p.getName());
            }
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car(20);
        System.out.println("Car capacity is: " + myCar.getCapacity());
        System.out.println("Seats remaining is: " + myCar.seatsRemaining());
        Passenger Kate = new Passenger("Kate");
        myCar.addPassenger(Kate);
        Passenger Naomi = new Passenger("Naomi");
        myCar.addPassenger(Naomi);
        System.out.println("Seats remaining is: " + myCar.seatsRemaining());
        myCar.printManifest();
    }
}