import java.util.ArrayList;
/**
 * Class that combines the other classes to run a train
 */
public class Train implements TrainRequirements {
    // Attributes
    private int nCars;
    private ArrayList<Car> totalCars;
    private Engine myEngine;

    /**
     * Constructor
     * @param fuelType type of fuel
     * @param currentFuelLevel current level of fuel
     * @param fuelCapacity max fuel
     * @param nCars number of desired cars
     * @param passengerCapacity capacity per car
     */
    public Train (FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity) {
        this.nCars = nCars;
        this.totalCars = new ArrayList<>();
        this.myEngine = new Engine(fuelType, currentFuelLevel, fuelCapacity);

        // Creates an instance of a car for the number of cars the user inputs
        for (int i = 0; i < this.nCars; i++) {
            Car car = new Car(passengerCapacity);
            totalCars.add(car);
        }
    }

    /**
     * Engine getter
     * @return myEngine
     */
    public Engine getEngine() {
        return myEngine;
    }

    /**
     * Gets the car at the given index
     * @param i index for the car
     * @return the car
     */
    public Car getCar(int i) {
        return this.totalCars.get(i);
    }

    /**
     * Gets the capacity for the entire train
     * @return total maximum capacity
     */
    public int getMaxCapacity() {
        int totalMaxCapacity = 0;
        // for each car in the train, adds the car capacity to find the total capacity
        for (int i = 0; i < this.totalCars.size(); i++){
            Car car = this.totalCars.get(i);
            totalMaxCapacity += car.getCapacity();
        }
        return totalMaxCapacity;
    }

    /**
     * Gets seats remaining accross the whole train
     * @return total seats remaining
     */
    public int seatsRemaining() {
        int totalSeatsRemaining = 0;
        // for each car in the train, adds the seats remaining in the car to find total seats remaining
        for (int i = 0; i < this.totalCars.size(); i++){
            Car car = this.totalCars.get(i);
            totalSeatsRemaining += car.seatsRemaining();
        }
        return totalSeatsRemaining;
    }

    /** 
     * Prints manifest of all passengers on the train
     */
    public void printManifest() {
        // Prints the manifest of each car
        for (int i = 0; i < this.totalCars.size(); i++) {
            Car car = this.totalCars.get(i);
            car.printManifest();
        } 
    }

    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.ELECTRIC, 100, 1000, 4, 20);
        System.out.println("Car capacity is:" + myTrain.getMaxCapacity());
        System.out.println("Seats remaining is: " + myTrain.seatsRemaining());
        Passenger Kate = new Passenger("Kate");
        Car myCar = myTrain.getCar(0);
        System.out.println("Seats remaining is: " + myCar.seatsRemaining());
        myCar.addPassenger(Kate);
        System.out.println("Seats remaining is: " + myCar.seatsRemaining());
        Passenger Naomi = new Passenger("Naomi");
        myCar.addPassenger(Naomi);
        System.out.println("Seats remaining is: " + myCar.seatsRemaining());
        myCar.addPassenger(Naomi);
        System.out.println("Seats remaining is: " + myCar.seatsRemaining());
        // myTrain.printManifest();
    }
}

