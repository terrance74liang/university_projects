// -----------------------------------------------------
// Assignment (1)
// Part: (1)
// Written by: (Terrance Liang 40158057)
// -----------------------------------------------------

package CityB;
import CityB.*;

public class Metro extends CityBus {
    /**number of vehicles present
     */
    protected int numberOfVehicles;
    /**name of the city
     */
    protected String nameOfTheCity;

    /**DEFAULT CONSTRUCTOR : initializes objects of type Metro
     */
    public Metro(){
        super();//super method that calls --> public CityBus()
        numberOfVehicles = 0;
        nameOfTheCity = "";
    }

    /**CONSTRUCTOR WITH PARAMETERS: initializes objects of type Metro with parameters
     * @param ticket ticket price
     * @param stops number of stops
     * @param route route number
     * @param year year of operation
     * @param Lname line name
     * @param Dname driver name
     * @param vehicles number of vehicles
     * @param city name of the city
     */
    public Metro (double ticket, int stops,long route, int year, String Lname, String Dname,int vehicles, String city){
        super (ticket, stops, route, year, Lname, Dname);//calls --> public CityBus(double ticket, int stops, long route, int year, String Lname, String Dname)
        numberOfVehicles = vehicles ;
        nameOfTheCity = city;
    }

    /**COPY CONSTRUCTOR: Initializes and object based on a previous object's variables of type Metro
     * @param Transportation object of type metro + city bus(inherited) + public transportation(inherited)
     */
    public Metro(Metro Transportation){
        super(Transportation);//calls--> public CityBus(CityBus Transportation)
        numberOfVehicles = Transportation.numberOfVehicles;
        nameOfTheCity = Transportation.nameOfTheCity;
    }

    /**ACCESSOR METHOD for number of vehicles
     * @return number of cehicles
     */
    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    /**MUTATOR METHOD for number of vehicles
     * @param numberOfVehicles number of vehicles
     */
    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    /**
     * ACCESSOR METHOD for name of the city
     * @return name of the city
     */
    public String getNameOfTheCity() {
        return nameOfTheCity;
    }

    /**MUTATOR METHOD for name of the city
     * @param nameOfTheCity name of the city
     */
    public void setNameOfTheCity(String nameOfTheCity) {
        this.nameOfTheCity = nameOfTheCity;
    }
    //End of accessor and mutator methods

    /**toString METHOD that returns in string format all the instance variables of an object Tram + parent variables
     * @return returns instance variables converted to String's
     */
    public String toString() {
        return (super.toString()).replace("city bus","Metro") + "The number of vehicles is " + numberOfVehicles +
                " and the name of the city is " + nameOfTheCity;
    }

    /**equals METHOD that returns a boolean value if objects are the same: needs to check if object is null or not since initial parameter class type is Object, then checks same class,
     * then variable values (current class +parent class)
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
            Metro temp= (Metro) otherObject;
            if(super.equals(otherObject) &&
                    numberOfVehicles == temp.numberOfVehicles &&
                    nameOfTheCity.equals(temp.nameOfTheCity)){
                return true;
            }
            else{
                return false;
            }
        }
    }
}

