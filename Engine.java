public class Engine implements EngineRequirements {
    // Attributes
    private FuelType fuelType;
    private double CurrentFuel;
    private double MaxFuel;

    /**
     * Constructor
     * @param fuelType
     * @param CurrentFuel
     * @param MaxFuel
     */
    public Engine (FuelType fuelType, double CurrentFuel, double MaxFuel) {
        this.fuelType = fuelType;
        this.CurrentFuel = CurrentFuel;
        this.MaxFuel = MaxFuel;
    }

    /**
     * Fuel type getter
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
        return this.MaxFuel;
    }

    /** 
     * Current fuel getter
     * @return current fuel level
     */
    public double getCurrentFuel() {
        return this.CurrentFuel;
    }

    /**
     * Refuels the current fuel all the way up (to max fuel level)
     */
    public void refuel() {
        this.CurrentFuel = this.MaxFuel;
    }

    /** 
     * Makes the train go, decreasing fuel as it does
     * @return Boolean of whether the train still has the fuel to go
     */
    public Boolean go() {
        // Makes sure the fuel won't go negative
        if (CurrentFuel > 10) {
            CurrentFuel -= 10;
            return true;
        }
        else {
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