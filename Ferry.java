// -----------------------------------------------------
// Assignment (1)
// Part: (1)
// Written by: (Terrance Liang 40158057)
// -----------------------------------------------------

package FerryC;
import PublicT.*;

public class Ferry extends PublicTransportation{
    /** year of manufacture
     */
    protected int buildYear;
    /**name of the ship
     */
    protected String shipName;

    /**DEFAULT CONSTRUCTOR : initializes objects of type Ferry
     */
    public Ferry(){
        super();//super method that calls --> public PublicTransportation()
        buildYear = 0;
        shipName = "";
    }

    /**CONSTRUCTOR WITH PARAMETERS: initializes objects of type Ferry with parameters
     * @param ticket ticket price
     * @param stops number of stops
     * @param year year OF manufacture
     * @param ship ship name
     */
    public Ferry(double ticket, int stops, int year, String ship){
        super(ticket, stops);//calls --> public PublicTransportation(double ticket, int stops)
        buildYear = year;
        shipName =ship;
    }

    /**COPY CONSTRUCTOR: Initializes and object based on a previous object's variables of type Ferry
     * @param Transportation object of type Ferry + public transportation(inherited)
     */
    public Ferry (Ferry Transportation){
        super(Transportation);//calls--> public PublicTransportation(PublicTransportation Transportation)
        buildYear = Transportation.buildYear;
        shipName = Transportation.shipName;
    }

    /**ACCESSOR METHOD for build year
     * @return year of manufacture
     */
    public int getBuildYear() {
        return buildYear;
    }

    /**MUTATOR METHOD for build year
     * @param buildYear manufacture year
     */
    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    /**ACCESSOR METHOD for ship name
     * @return ship name
     */
    public String getShipName() {
        return shipName;
    }

    /**MUTATOR METHOD for ship name
     * @param shipName
     */
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    //End of accessor and mutator methods

    /**toString METHOD that returns in string format all the instance variables of an object CityBus + parent variables
     * @return returns instance variables converted to String's
     */
    public String toString() {
        return  (super.toString()).replace("public transportation","ferry") + " It was built in "+ buildYear + " and the ship name is " + shipName +".";
    }

    /**equals METHOD that returns a boolean value if objects are the same: needs to check if object is null or not since initial parameter class type is Object,
     * then checks same class, then variable values(current class +parent class)
     * @param otherObject compared object
     * @return boolean indicating if objects have the same values
     */
    public boolean equals(Object otherObject) {
        if(otherObject == null){
            return false;
        }
        else if(this.getClass()!= otherObject.getClass()){
            return false;
        }
        else{
            Ferry temp= (Ferry) otherObject;
            if(super.equals(otherObject) &&
                    buildYear == temp.buildYear &&
                    shipName.equals(temp.shipName)
            ){
                return true;
            }
            else{
                return false;
            }
        }
    }

}
