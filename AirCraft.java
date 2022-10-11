// -----------------------------------------------------
// Assignment (1)
// Part: (1)
// Written by: (Terrance Liang 40158057)
// -----------------------------------------------------

package AirCraftC;
import PublicT.*;

//note:here we set enum type to private because they are constants anyways

public class AirCraft extends PublicTransportation{
    /**enum type for airTransportation allowed values
     */
    private enum classType {helicopter, airline, glider, balloon};
    /**enum type for time frame for maintenance allowed values
     */
    private enum maintenanceType {weekly, monthly, yearly};
    /** air transportation types of mediums
     */
    protected classType AirTransportation;
    /**maintenance time frame
     */
    protected maintenanceType timeFrame;

    /**DEFAULT CONSTRUCTOR : initializes objects of type AirCraft
     */
    public AirCraft(){
        super();//super method that calls --> public PublicTransportation()
        AirTransportation = classType.helicopter;
        timeFrame = maintenanceType.weekly;
    }

    /**CONSTRUCTOR WITH PARAMETERS: initializes objects of type AirCraft with parameters
     * @param ticket ticket price
     * @param stops number of stops
     * @param Atrans type of air transportation
     * @param Mtype type of time frame
     */
    public AirCraft(double ticket, int stops, String Atrans, String Mtype){
        super(ticket, stops);//calls --> public PublicTransportation(double ticket, int stops)
        AirTransportation = classType.valueOf(Atrans.toLowerCase());
        timeFrame =maintenanceType.valueOf(Mtype.toLowerCase());
    }

    /**COPY CONSTRUCTOR: Initializes and object based on a previous object's variables of type AirCraft
     * @param Transportation object of type AirCraft + public transportation(inherited)
     */
    public AirCraft(AirCraft Transportation){
        super(Transportation); //calls--> public PublicTransportation(PublicTransportation Transportation)
        AirTransportation =Transportation.AirTransportation;
        timeFrame = Transportation.timeFrame;
    }

    /**MUTATOR METHOD for AirTransportation
     * @param AirTransportation type of air transportation
     */
    public void setAirTransportation(classType AirTransportation) {
        this.AirTransportation = AirTransportation;
    }
    /**
     * ACCESSOR METHOD for air transportation
     * @return type of air transportation
     */
    public classType getAirTransportation() {
        return AirTransportation;
    }
    /**MUTATOR METHOD for time frame
     * @param timeFrame type of time frame
     */
    public void setTimeFrame(maintenanceType timeFrame) {
        this.timeFrame = timeFrame;
    }
    /**ACCESSOR METHOD for time frame
     * @return type of time frame
     */
    public maintenanceType getTimeFrame() {
        return timeFrame;
    }
    //End of accessor and mutator methods

    /**toString METHOD that returns in string format all the instance variables of an object CityBus + parent variables
     * @return returns instance variables converted to String's
     */
    public String toString() {
        return   (super.toString()).replace("public transportation",AirTransportation.toString()) + " Maintenance is "+ timeFrame.toString() +".";
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
            AirCraft temp= (AirCraft) otherObject;
            if(super.equals(otherObject) &&
                    AirTransportation .equals(temp.AirTransportation) &&
                    timeFrame.equals(temp.timeFrame)
            ){
                return true;
            }
            else{
                return false;
            }
        }
    }

}
