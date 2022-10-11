// -----------------------------------------------------
// Assignment (1)
// Part: (1)
// Written by: (Terrance Liang 40158057)
// -----------------------------------------------------

package PublicT;
import java.lang.Math;

public class PublicTransportation {

    /**price of a ticket
     */
    protected double ticketPrice;
    /**number of stops
     */
    protected int numberOfStops;

    /**DEFAULT CONSTRUCTOR : initializes objects of type PublicTransportation
     */
    public PublicTransportation(){
        ticketPrice= ((int)((Math.random()*100)*100))/100.00;
        numberOfStops=0;
    }

    /**CONSTRUCTOR WITH PARAMETERS: initializes objects of type PublicTransportation with parameters
     * @param ticket ticket price
     * @param stops number of stops
     */
    public PublicTransportation(double ticket, int stops){
        ticketPrice = ticket;
        numberOfStops = stops;
    }

    /**COPY CONSTRUCTOR: Initializes and object based on a previous object's variables of type PublicTransportation
     * @param Transportation Public transportation object
     */
    public PublicTransportation(PublicTransportation Transportation){
        ticketPrice = Transportation.ticketPrice;
        numberOfStops = Transportation.numberOfStops;
    }

    /**ACCESSOR METHOD for ticket price
     * @return ticket price
     */
    public double getTicketPrice(){
        return ticketPrice;
    }

    /**MUTATOR METHOD for ticket price
     * @param ticketPrice ticket price
     */
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    /**ACCESSOR METHOD for number of stops
     * @return number of stops
     */
    public int getNumberOfStops(){
        return numberOfStops;
    }
    /**MUTATOR METHOD for number fo stops
     * @param numberOfStops number of stops
     */
    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }
    //End of accessor and mutator methods

    /**toString METHOD that returns in string format all the instance variables of an object PublicTransportation
     * @return converted instance variable values into strings
     */
    public String toString() {
        return "The public transportation has "+ numberOfStops + " stops, and costs " + ticketPrice + "$.";
    }

    /**equals METHOD that returns a boolean value if objects are the same: needs to check if object is null or not since
     * initial parameter class type is Object,then checks same class, then variable values
     *@param otherObject compared object
     * @return boolean indicating if objects have the same values
     */
    public boolean equals(Object otherObject){
        if(otherObject == null){
            return false;
        }
        else if(this.getClass()!= otherObject.getClass()){
            return false;
        }
        else{
            PublicTransportation temp= (PublicTransportation)otherObject;
            if(ticketPrice == temp.ticketPrice &&
                    numberOfStops == temp.numberOfStops){
                return true;
            }
            else{
                return false;
            }
        }
    }
}

