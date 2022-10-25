package SimpleInterfaces;

public class City extends Place implements Local, Statistical, Transportation {

    //Assigning all the appropriate return values that will be used later on. 
    private String nameOfAirport;
    private boolean hasAirport;
    private String nameOfHarbor;
    private boolean hasHarbor;
    private String nameOfTrainStation;
    private boolean hasTrainStation;
    private boolean hasBusService;
    private boolean hasSubwayNetwork;
    private int population;
    private String climateDescription;

    /*
     * All methods are either Setters or Getters. 
     * Methods that start with setSomething are setters, and allow you to use this class elsewhere to create and set attributes
     * of a city. E.g. setAirport()
     * 
     * All the other methods are Getters, meaning that they do nothing other than return a value, for use elsewhere. E.g. hasAirport() and nameOfAirport() 
     */

    /**
     * Airport Setter
     * @param airportName
     * @return City, for method chaining. 
     */
    public City setAirport(String airportName){
        if (airportName != null){
            hasAirport = true;
            nameOfAirport = airportName;
        } else {
            hasAirport = false;
        }
        return this;
    }
    /**
     * @return boolean, true if city has airport
     */
    public boolean hasAirport() {
        return hasAirport;
    }
    /**
     * @return String name of airport
     */
    public String nameOfAirport() {
        return nameOfAirport;
    }

    /**
     * Harbor setter
     * @param harborName
     * @return City, for method chaining
     */
    public City setHarbor (String harborName){
        if (harborName != null){
            hasHarbor = true;
            nameOfHarbor = harborName;
        } else {
            hasHarbor = false;
        }
        return this;
    }
    /**
     * @return boolean, true if city has harbor
     */
    public boolean hasHarbor() {
        return hasHarbor;
    }
    /**
     * @return String name of harbor
     */
    public String nameOfHarbor() {
        return nameOfHarbor;
    }

    /**
     * Train Station setter
     * @param TrainStationName
     * @return City, for method chaining
     */
    public City setTrainStation(String TrainStationName){
        if (TrainStationName != null){
            hasTrainStation = true;
            nameOfTrainStation = TrainStationName;
        } else {
            hasTrainStation = false;
        }
        return this;
    }
    /**
     * @return boolean, true if city has train station
     */
    public boolean hasTrainStation() {
        return hasTrainStation;
    }
    /**
     * @return String with name of train station
     */
    public String nameOfTrainStation() {
        return nameOfTrainStation;
    }


    /**
     * Setter for Bus Service
     * @param b
     * @return City, for method chainig
     */
    public City setBusService(boolean b){
        hasBusService = b;
        return this;
    }
    /**
     * @return boolean, true if the city has a bus service
     */
    public boolean hasBusService() {
        return hasBusService;
    }

    /**
     * Subway Network Setter
     * @param b boolean, sets hasSubwayNetwork to true. 
     * @return City, to allow chaining of methods
     */
    public City setSubwayNetwork(boolean b){
        hasSubwayNetwork = b;
        return this;
    }
    /**
     * @return boolean, true if the city has a subway network
     */
    public boolean hasSubwayNetwork() {
        return hasSubwayNetwork;
    }

    /**
     * setter for population
     * @param pop
     * @return City, for method chaining
     */
    public City setPop(int pop){
        population = pop;
        return this;
    }
    /**
     * @return an integer of the city's population
     */
    public int population() {
        return population;
    }

    /**
     * Setter for the climate description. 
     * @param climate
     * @return City, for method chaining
     */
    public City setClimate(String climate){
        climateDescription = climate;
        return this;
    }
    /**
     * @return a string containing a description of the climate at the city. 
     */
    public String describeClimate() {
        return climateDescription;
    }
}  // class City
