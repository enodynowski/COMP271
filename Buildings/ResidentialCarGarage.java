package Buildings;

public class ResidentialCarGarage extends Building {

    /** Number of cars accommodated */
    private int cars;

    /** Default constructor */
    public ResidentialCarGarage() {
        super("garage");
    }

    public int compareTo(ResidentialCarGarage garage){
        return this.cars - garage.cars;
    }

    

    /**
     * Describe car space
     */
    public void parking() {
        String noun = (this.cars > 1) ? "cars" : "car";
        System.out.printf("\nThis %s can accommodate %d %s.",
                this.buildingDescription, this.cars, noun);
    }
}
