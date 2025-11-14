/**
 * Class for the engine for the train, with a fuel type, current fuel level, and max fuel level
 */

public class Engine implements EngineRequirements {
    // Attributes
    private FuelType fuelType;
    private double currentFuel;
    private double maxFuel;

    /**
     * Constructor
     * @param fuelType
     * @param currentFuel
     * @param maxFuel
     */
    public Engine (FuelType fuelType, double currentFuel, double maxFuel) {
        this.fuelType = fuelType;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
    }

    /**
     * Getter for fuel type
     * @return fuel type
     */
    public FuelType getFuelType() {
        return this.fuelType;
    }

    /**
     * Max fuel getter
     * @return max fuel
     */
    public double getMaxFuel() {
        return this.maxFuel;
    }

    /** 
     * Current fuel getter
     * @return current fuel level
     */
    public double getCurrentFuel() {
        return this.currentFuel;
    }

    /**
     * Refuels the current fuel all the way up (to max fuel level)
     */
    public void refuel() {
        this.currentFuel = this.maxFuel;
    }

    /** 
     * Makes the train go, decreasing fuel as it does
     * @return Boolean of whether the train still has the fuel to go
     */
    public Boolean go() {
        // Makes sure the fuel won't go negative
        if (currentFuel >= 10) {
            currentFuel -= 10;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }

}