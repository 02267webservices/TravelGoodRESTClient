package dtu.ws.rest.resources;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import org.junit.Test;
import static org.junit.Assert.*;


public class TestFlightResource {
     static final String FLIGHT_URI = "http://localhost:8080/RestWebService/webresources/flight";

     Client client = Client.create();
     WebResource r = client.resource(FLIGHT_URI);
      
    
     @Test
     public void getBook(){
         String res = r.queryParam("bookingnumber","ABC1234").get(String.class);
         System.out.println("True if booked: " +res);
        assertEquals("true",res); //true = "true"

     }
     @Test
     public void getBook2(){
         String res = r.queryParam("bookingnumber","ABC12345").get(String.class);
         
         System.out.println("True if booked: " +res);
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
         System.out.println("True cancelling of booking number was succesfull: " +res);
         assertEquals("false",res);
     }
}