package dtu.ws.rest.resources;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import dtu.ws.group8.lameduck.client.FlightInfoListType;
import dtu.ws.group8.lameduck.client.FlightInfoType;
import static dtu.ws.rest.resources.TestFlightsResource.FLIGHTS_URI;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;


public class TestFlightResource {
     static final String FLIGHT_URI = "http://localhost:8080/RestWebService/webresources/flight";
    static final String FLIGHTS_URI = "http://localhost:8080/RestWebService/webresources/flights";
   
    Client client = Client.create();
    WebResource r = client.resource(FLIGHT_URI);
    
    Client client2 = Client.create();
    WebResource r2 = client2.resource(FLIGHTS_URI);
       
     /*
     @Test
     public void getBook(){
         String res = r.queryParam("bookingnumber","ABC1234").get(String.class);
         System.out.println("True if booked: " +res);
        assertEquals("true",res); //true = "true"

     }
     @Test
     public void getBook3(){
         String res = r.queryParam("bookingnumber","ABC1234").get(String.class);
         System.out.println("True if booked: " +res);
        assertEquals("true",res); //true = "true"

     }
     @Test
     public void getBook2(){
         String res = r.queryParam("bookingnumber","ABC12345").get(String.class);
         
         System.out.println("Should be false: " +res);
         assertEquals("false",res);
     }
      
     @Test
     public void cancelTest(){
         String res = r.queryParam("bookingnumber","ABC1234").delete(String.class);
         System.out.println("True cancelling of booking number was succesfull: " +res);
         assertEquals("true",res);
     }
    
     @Test
     public void cancelTest2(){
         String res = r.queryParam("bookingnumber","ABC1234srtw5").delete(String.class);
         System.out.println("Should be false: " +res);
         assertEquals("false",res);
     }
    
     @Test
     public void getFlights(){
        
         FlightInfoListType res = r2.get(new GenericType<FlightInfoListType>(){});
      List<FlightInfoType> flightsInfo2 = res.getFlightInformation();
         
          if (!flightsInfo2.isEmpty()){
            for (int i = 0; i < flightsInfo2.size(); i++) {
		System.out.println(flightsInfo2.get(i).getFlightReservationService()+ "\n" +
                           flightsInfo2.get(i).getFlightBookingNumber()+ "\n" +
                           Double.toString(flightsInfo2.get(i).getFlightPrice()) + "\n" +
                           flightsInfo2.get(i).getFlightInfo().getCarrierName() + "\n" +
                           flightsInfo2.get(i).getFlightInfo().getDestinationAirport() + "\n" +
                           flightsInfo2.get(i).getFlightInfo().getStartAirport());
            }
            
     }
          
  
}*/
     
     @Test
     public void P1(){
         
      //Get list of flights   
      FlightInfoListType res = r2.get(new GenericType<FlightInfoListType>(){});
      List<FlightInfoType> flightsInfo = res.getFlightInformation();
         
          if (!flightsInfo.isEmpty()){
            for (int i = 0; i < flightsInfo.size(); i++) {
		System.out.println(flightsInfo.get(i).getFlightReservationService()+ "\nFlightNumber: " +
                           flightsInfo.get(i).getFlightBookingNumber()+ "\nPrice: " +
                           Double.toString(flightsInfo.get(i).getFlightPrice()) + "\nCompany: " +
                           flightsInfo.get(i).getFlightInfo().getCarrierName() + "\nDestination: " +
                           flightsInfo.get(i).getFlightInfo().getDestinationAirport() + "\nFrom: " +
                           flightsInfo.get(i).getFlightInfo().getStartAirport()+ "\n");
            }       
     }
          
          
                 
         ///Book first flight
         String book = r.queryParam("bookingnumber","ABC1234").get(String.class);
         System.out.println("True if successfull booking of ABC1234: " +book);
         assertEquals("true",book); //true = "true"
         
         
      ///Get list of lfights again   
          
      FlightInfoListType res2 = r2.get(new GenericType<FlightInfoListType>(){});
      List<FlightInfoType> flightsInfo2 = res2.getFlightInformation();
         
          if (!flightsInfo2.isEmpty()){
            for (int i = 0; i < flightsInfo2.size(); i++) {
		System.out.println(flightsInfo2.get(i).getFlightReservationService()+ "\nFlightNumber: " +
                           flightsInfo2.get(i).getFlightBookingNumber()+ "\nPrice: " +
                           Double.toString(flightsInfo2.get(i).getFlightPrice()) + "\nCompany: " +
                           flightsInfo2.get(i).getFlightInfo().getCarrierName() + "\nDestination: " +
                           flightsInfo2.get(i).getFlightInfo().getDestinationAirport() + "\nFrom: " +
                           flightsInfo2.get(i).getFlightInfo().getStartAirport()+ "\n");
            }       
     }
         
   
         
        ///Book second flight
         String book2 = r.queryParam("bookingnumber","ABC4321").get(String.class);
         System.out.println("True if successfull booking of ABC4321: " +book2);
         assertEquals("true",book2); //true = "true"
           
          
         
     }
}