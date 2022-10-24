package SimpleInterfaces;

public class City extends Place implements Local, Statistical, Transportation {

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
     * @return boolean, true if the city has a bus service
     */
    public boolean hasBusService() {
        return hasBusService;
    }
    /**
     * @return boolean, true if the city has a subway network
     */
    public boolean hasSubwayNetwork() {
        return hasSubwayNetwork;
    }

    /**
     * @return an integer of the city's population
     */
    public int population() {
        return population;
    }

    /**
     * @return a string containing a description of the climate at the city. 
     */
    public String describeClimate() {
        return climateDescription;
    }

    public void setAirport(String airportName){
        hasAirport = true;
        nameOfAirport = airportName;
    }

}  // class City
