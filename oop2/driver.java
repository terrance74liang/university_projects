// -----------------------------------------------------
// Assignment (1)
// Part: (2)
// Written by: (Terrance Liang 40158057)
//COMP 249
//Due date: July 18 2021
// -----------------------------------------------------

import PublicT.*;
import CityB.*;
import FerryC.*;
import AirCraftC.*;
import java.util.Scanner;

public class driver {

    public static void main(String[] args) {

        //REQ 1: CREATION OF OBJECTS FOR EVERY CLASS
        //the following variable descriptions are just objects for every existing class, using the parameter constructor was a decision by preference
        PublicTransportation Ptrans = new PublicTransportation(1, 2);
        CityBus Bus = new CityBus(5, 5, 3, 4, "Downtown", "Carlos");
        Tram TramObject = new Tram(10, 12, 40, 1999, "Sherbrooke", "Jack", 50);
        Metro MetroObject = new Metro(11, 20, 14, 1995, "Lionel-groulx", "Maria", 30, "Montreal");
        AirCraft AirC = new AirCraft(12, 22, "GLIDER", "WEEKLY");
        Ferry FerryObject = new Ferry(15, 3, 2000, "Goliath");

        //Display of the created objects
        System.out.println("\n\nCreate various objects from the 6 classes, and display all their information using the\n" +
                "toString() method.");
        System.out.println("");
        System.out.println(Ptrans.toString());
        System.out.println(Bus.toString());
        System.out.println(TramObject.toString());
        System.out.println(MetroObject.toString());
        System.out.println(AirC.toString());
        System.out.println(FerryObject.toString());
        System.out.println("----------------------------------------------------------------------------------------");
        //REQ 2: TESTING OBJECTS WITH THE EQUALS METHOD
        /*note: in addition to the testing of teh equals method with different classes, creation of two objects of the same class
        with only one differing variable was created for testing of the equal() method part 3 where null and class test phase have passed*/

        //creation of the extra objects for the test
        AirCraft AirC2 = new AirCraft(10, 12, "BALLOON", "WEEKLY");
        Tram TramObject2 = new Tram(10, 12, 40, 1999, "Sherbrooke", "Jack", 50);

        //display of test results
        System.out.println("\n\nTest the equality of some to the created objects using the equals() method.");
        System.out.println("");
        System.out.println("Ptrans = Bus: "+Ptrans.equals(Bus));
        System.out.println("Bus = Bus: "+Bus.equals(Bus));
        System.out.println("TramObject = TramObject2: "+TramObject.equals(TramObject2));
        System.out.println("MetroObject = AirC: "+MetroObject.equals(AirC));
        System.out.println("AirC = AirC2: "+AirC.equals(AirC2));
        System.out.println("FerryObject = Bus: "+FerryObject.equals(Bus));
        System.out.println("----------------------------------------------------------------------------------------");
        //REQ 3: creation of array with 15 objects using all classes
        //object creation to fill 15 object requirement
        PublicTransportation Ptrans2 = new PublicTransportation();
        CityBus Bus2 = new CityBus();
        CityBus Bus3 = new CityBus();
        Tram TramObject3 = new Tram();
        Metro MetroObject2 = new Metro();
        AirCraft AirC3 = new AirCraft();
        Ferry FerryObject2 = new Ferry();

        //array creation
        PublicTransportation[] array = {Ptrans, Ptrans2, Bus, Bus2, Bus3, TramObject, TramObject2, TramObject3, MetroObject,
                MetroObject2, AirC, AirC2, AirC3, FerryObject, FerryObject2};

        //display of length requirement
        System.out.println("\n\nCreate an array of 15 PublicTransportation objects and fill that array with various objects\n" +
                "from the 6 classes (each class must have at least one entry in that array).");
        System.out.println("");
        System.out.println("Array length (must be 15): "+ array.length);
        System.out.println("----------------------------------------------------------------------------------------");
        //Display of the most expensive and least expensive ticket price amongst array objects at each index
        double LeastExpensive = Ptrans.getTicketPrice();//variable declaration: least expensive ticket price
        double MostExpensive = Ptrans.getTicketPrice();//variable description:  most expensive ticket price
        int indexMost = 0;//variable description: index where most expensive ticket price resides
        int indexLeast = 0;//variable description: index where least expensive ticket price resides

        //algorithm: this locates the least and the most expensive ticket price amongst the 15 array index values/objects
        for (int i = 0; i < array.length; i++) {
            if (array[i].getTicketPrice() < LeastExpensive) {
                LeastExpensive = array[i].getTicketPrice();
                indexLeast = i;
            }
            if (array[i].getTicketPrice() > MostExpensive) {
                MostExpensive = array[i].getTicketPrice();
                indexMost =i;
            }
        }

        /*display of most expensive and least expensive ticket price + display of the objects' other variable values with
        least and most expensive ticket prices*/
        System.out.println("\n\nTrace(search) that array to find the object that is least expensive (has the lowest price)\n" +
                "and the one that is most expensive. Display all information about these two objects along\n" +
                "with their location (index) in the array. ");
        System.out.println("\nLeast expensive :"+LeastExpensive + "\nMost expensive " +MostExpensive);
        System.out.println("Index of most expensive ticket price: " +indexMost+ "\nIndex of least expensive ticket price: " +indexLeast);
        System.out.println("Most expensive: "+ array[indexMost] +"\nLeast expensive: " + array[indexLeast]);
        System.out.println("----------------------------------------------------------------------------------------");


    }
}

