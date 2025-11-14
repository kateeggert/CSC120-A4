public class Passenger implements PassengerRequirements {
    // Attributes
    private String name;

    /**
     * Constructor
     * @param name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Adds passenger onto a given car
     * @param c car
     */
    public void boardCar(Car c) {
        if (c.addPassenger(this) == false) {
            System.out.println("Boarding was unsuccessful. Car is full or passenger has already boarded");
        }
    }

    /** 
     * Takes a passenger off a given car
     * @param c car
     */
    public void getOffCar(Car c) {
        if (c.removePassenger(this) == false) {
            System.out.println("Exiting was unsuccessful. Passenger is not on board");
        }
    }

    /**
     * Name getter
     * @return name
     */
    public String getName() {
        return this.name;
    }
}
