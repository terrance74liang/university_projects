// -----------------------------------------------------
// Assignment (1)
// Part: (1)
// Written by: (Terrance Liang 40158057)
// -----------------------------------------------------


package CityB;
import PublicT.*;

public class CityBus extends PublicTransportation {
    /**route number
     */
    protected long routeNumber;
    /**start of operations
     */
    protected int beginOperationYear;
    /**name of the line
     */
    protected String lineName;
    /**name of the driver
     */
    protected String driverName;

    /**DEFAULT CONSTRUCTOR : initializes objects of type CityBus
     *
     */
    public CityBus() {
        super();//super method that calls --> public PublicTransportation()
        routeNumber = 0;
        beginOperationYear = 0;
        lineName = "NDG";
        driverName = "Rose";
    }

    /**CONSTRUCTOR WITH PARAMETERS: initializes objects of type CityBus with parameters
     * @param ticket ticket price
     * @param stops number of stops
     * @param route route number
     * @param year year of operation
     * @param Lname line name
     * @param Dname driver name
     */
    public CityBus(double ticket, int stops, long route, int year, String Lname, String Dname) {
        super(ticket, stops);//calls --> public PublicTransportation(double ticket, int stops)
        routeNumber = route;
        beginOperationYear = year;
        lineName = Lname;
        driverName = Dname;
    }

    /**COPY CONSTRUCTOR: Initializes and object based on a previous object's variables of type CityBus
     * @param Transportation city bus + public transportation object(inherited)
     */
    public CityBus (CityBus Transportation) {
        super(Transportation); //calls--> public PublicTransportation(PublicTransportation Transportation)
        routeNumber = Transportation.routeNumber;
        beginOperationYear = Transportation.beginOperationYear;
        lineName = Transportation.lineName;
        driverName = Transportation.driverName;
    }

    /**ACCESSOR for routeNumber
     * @return route number
     */
    public long getRouteNumber() {
        return routeNumber;
    }

    /**MUTATOR METHOD for route number
     * @param routeNumber route number
     */
    public void setRouteNumber(long routeNumber) {
        this.routeNumber = routeNumber;
    }

    /**ACCESSOR METHOD for start of operation year
     * @return start of operation year
     */
    public int getBeginOperationYear() {
        return beginOperationYear;
    }

    /**MUTATOR METHOD for start of operation year
     * @param beginOperationYear start of operation year
     */
    public void setBeginOperationYear(int beginOperationYear) {
        this.beginOperationYear = beginOperationYear;
    }

    /**ACCESSOR METHOD for line name
     * @return line name
     */
    public String getLineName() {
        return lineName;
    }
    /**MUTATOR METHOD for line name
     * @param lineName line name
     */
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    /**ACCESSOR METHOD for driver name
     * @return driver name
     */
    public String getDriverName() {
        return driverName;
    }
    /**MUTATOR METHOD for driver name
     * @param driverName
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    //End of accessor and mutator methods

    /**toString METHOD that returns in string format all the instance variables of an object CityBus + parent variables
     * @return returns instance variables converted to String's
     */
    public String toString() {
        return  (super.toString()).replace("public transportation","city bus") + " It will take line " + lineName + " on route " + routeNumber +
                ". " + "Operations began on " + beginOperationYear + ". ";
    }

    /**equals METHOD that returns a boolean value if objects are the same: needs to check if object is null or not since initial parameter class type is Object,
     * then checks same class, then variable values(current class +parent class)
     * @param otherObject compared object
     * @return boolean indicating if objects have the same values
     */
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        } else if (this.getClass() != otherObject.getClass()) {
            return false;
        } else {
            CityBus temp = (CityBus) otherObject;
            if (super.equals(otherObject) &&
                    routeNumber == temp.routeNumber &&
                    beginOperationYear == temp.beginOperationYear &&
                    lineName.equals(temp.lineName) &&
                    driverName.equals(temp.driverName)) {
                return true;
            } else {
                return false;
            }
        }
    }
}

