package SimpleInterfaces;

public class Chicago {
    public static void main(String[] args) {
        City Chicago = new City();
        Chicago.setElevation(650);
        Chicago.setLatitude(41.8781);
        Chicago.setLongitude(87.6298);
        Chicago.setAirport("Ohare").setBusService(true).setClimate("Arctic in the winter, nice in the summer").setHarbor("Montrose Harbor").setPop(2_700_000);

        /*
         * What I am unable to do, with the private variables in the top of City.java is this:
         * Chicago.hasAirport = true;
         * 
         * If I call Chicago.hasAirport() this just returns whether or not Chicago has an airport. If I were to change
         * the variables in City.java to public or protected, it would allow me to change their values. 
         */
    }
    
}
