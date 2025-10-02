import java.util.ArrayList;

public class Train implements TrainRequirements {
    // Attributes
    private FuelType fuelType; 
    private double currentFuelLevel;
    private double fuelCapacity;
    private int nCars;
    private int passengerCapacity;
    private ArrayList<Car> totalCars;
    private Engine myEngine;

    /**
     * Constructor
     * @param fuelType
     * @param currentFuelLevel
     * @param fuelCapacity
     * @param nCars number of desired cars
     * @param passengerCapacity capacity per car
     */
    public Train (FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity) {
        this.fuelType = fuelType;
        this.currentFuelLevel = currentFuelLevel;
        this.fuelCapacity = fuelCapacity;
        this.nCars = nCars;
        this.passengerCapacity = passengerCapacity;
        this.totalCars = new ArrayList<>();
        this.myEngine = new Engine(this.fuelType, this.currentFuelLevel, this.fuelCapacity);

        // Creates an instance of a car for the number of cars the user inputs
        for (int i = 0; i < this.nCars; i++) {
            Car car = new Car(this.passengerCapacity);
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
        int TotalMaxCapacity = 0;
        // for each car in the train, adds the car capacity to find the total capacity
        for (int i = 0; i < this.totalCars.size(); i++){
            Car car = this.totalCars.get(i);
            TotalMaxCapacity += car.getCapacity();
        }
        return TotalMaxCapacity;
    }

    /**
     * Gets seats remaining accross the whole train
     * @return total seats remaining
     */
    public int seatsRemaining() {
        int TotalSeatsRemaining = 0;
        // for each car in the train, adds the seats remaining in the car to find total seats remaining
        for (int i = 0; i < this.totalCars.size(); i++){
            Car car = this.totalCars.get(i);
            TotalSeatsRemaining += car.seatsRemaining();
        }
        return TotalSeatsRemaining;
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
        Passenger Naomi = new Passenger("Naomi");
        myCar.addPassenger(Naomi);
        System.out.println("Seats remaining is: " + myCar.seatsRemaining());
        myTrain.printManifest();
    }
}

