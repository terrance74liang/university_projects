// -----------------------------------------------------
// Assignment (1)
// Part: (1)
// Written by: (Terrance Liang 40158057)
// -----------------------------------------------------

package CityB;
import CityB.*;

public class Tram extends CityBus {
    /**maximum speed achieved
     */
    protected int maximumSpeed;

    /**DEFAULT CONSTRUCTOR : initializes objects of type Tram
     */
    public Tram(){
        super();//super method that calls --> public CityBus()
        maximumSpeed = 0;
    }

    /**CONSTRUCTOR WITH PARAMETERS: initializes objects of type Tram with parameters
     * @param ticket ticket price
     * @param stops number of stops
     * @param route route number
     * @param year year of operation
     * @param Lname line name
     * @param Dname driver name
     * @param speed maximum speed attained
     */
    public Tram (double ticket, int stops,long route, int year, String Lname, String Dname,int speed){
        super (ticket, stops, route, year, Lname, Dname);//calls --> public CityBus(double ticket, int stops, long route, int year, String Lname, String Dname)
        maximumSpeed = speed ;
    }

    /**COPY CONSTRUCTOR: Initializes and object based on a previous object's variables of type CityBus
     * @param Transportation object of type Tram + city bus(inherited) + public transportation(inherited)
     */
    public Tram(Tram Transportation){
        super(Transportation); //calls--> public CityBus(CityBus Transportation)
        this.maximumSpeed = Transportation.maximumSpeed;
    }

    /**ACCESSOR METHOD for maximum speed attained
     * @return maximum speed
     */
    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    /**MUTATOR METHOD for maximum speed
     * @param maximumSpeed maximum speed
     */
    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }
    //End of accessor and mutator methods

    /**toString METHOD that returns in string format all the instance variables of an object Tram + parent variables
     * @return returns instance variables converted to String's
     */
    public String toString(){
        return  (super.toString()).replace( "city bus", "Tram") + "The maximum speed is " + maximumSpeed + " km/h.";
    }

    /**equals METHOD that returns a boolean value if objects are the same: needs to check if object is null or not since initial parameter class type is Object, then checks same class,
     * then variable values(current class +parent class)
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
            Tram temp= (Tram) otherObject;
            if(super.equals(otherObject) &&
                    maximumSpeed ==temp.maximumSpeed){
                return true;
            }
            else{
                return false;
            }
        }
    }
}

