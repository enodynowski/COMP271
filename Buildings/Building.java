package Buildings;
public class Building implements Comparable<Building> {

    /** Description of the building */
    protected String buildingDescription;

    /** Number of floors or levels */
    private int floors;

    /** Type of roof material */
    private String roofMaterial;

    /** Roof design */
    private String roofDesign;

    /** Entrance shape */
    private String entranceShape;

    /** Entrance material */
    private String entranceMaterial;

    private int squareFootage;

    /** Simple constructor */
    public Building(String buildingDescription) {
        this.buildingDescription = buildingDescription;
    }


   /**
    *
    * Method that compares two buildings based upon square footage and returns which is larger, represented by a negative, 0, or positive integer.
    * I chose to do this compareTo method using square footage because to me that is the logical way of comparing two buildings. 
    * I could have chose to compare based on how many floors, but a building can have 30 floors but still have less square footage than the merchandise mart.   
    *
    * @param Building building to be compared
    * @return result that stores -1, 0, or 1 depending on comparison
    */
    public int compareTo(Building building) {
        int result = 0;
        if (building.squareFootage < this.squareFootage){
            result = 1;
        } else if (building.squareFootage > this.squareFootage){
            result = -1;
        }
        
        return result;
    } //method compareTo

    /**
     * Description of roof
     */
    public void roof() {
        System.out.printf("\nThis %s has a %s roof made of %s.",
                this.buildingDescription, this.roofDesign, this.roofMaterial);
    }

    /**
     * Description of entrance
     */
    public void entrance() {
        System.out.printf("\nThis %s has a %s style entrance made of %s",
                this.buildingDescription, this.entranceShape, this.entranceMaterial);
    }


    /*
    ACCESSORS AND MUTATORS
     */

    public int getSquareFootage(){
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage){
        this.squareFootage = squareFootage;
    }

    public String getBuildingDescription() {
        return buildingDescription;
    }

    public void setBuildingDescription(String buildingDescription) {
        this.buildingDescription = buildingDescription;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getRoofMaterial() {
        return roofMaterial;
    }

    public void setRoofMaterial(String roofMaterial) {
        this.roofMaterial = roofMaterial;
    }

    public String getRoofDesign() {
        return roofDesign;
    }

    public void setRoofDesign(String roofDesign) {
        this.roofDesign = roofDesign;
    }

    public String getEntranceShape() {
        return entranceShape;
    }

    public void setEntranceShape(String entranceShape) {
        this.entranceShape = entranceShape;
    }

    public String getEntranceMaterial() {
        return entranceMaterial;
    }

    public void setEntranceMaterial(String entranceMaterial) {
        this.entranceMaterial = entranceMaterial;
    }

}