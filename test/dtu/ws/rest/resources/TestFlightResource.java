package dtu.ws.rest.resources;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import dtu.ws.group8.lameduck.client.FlightInfoListType;
import dtu.ws.group8.lameduck.client.GetFlightRequestType;
import javax.ws.rs.core.MediaType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestFlightResource {
     static final String FLIGHT_URI = "http://localhost:8080/RestWebService/webresources/flight";

     Client client = Client.create();
     WebResource r = client.resource(FLIGHT_URI);
        
    /*    
    @Test
    public void getFlight() {
        String result = r.queryParam("id","123").get(String.class);
        assertEquals(FLIGHT_URI + "/123",result);
    } 
    */
     
     
     /*
   @Test
    public void getFlight() throws DatatypeConfigurationException {
        GetFlightRequestType input = new GetFlightRequestType();
        input.setFlightStartAirport("Copenhagen");
        input.setFlightDestinationAirport("Berlin");
        
        DatatypeFactory df = DatatypeFactory.newInstance();
        XMLGregorianCalendar dateFlight = df.newXMLGregorianCalendar("2015-01-01");
        input.setFlightDate(dateFlight);
        
        System.out.println("TESTTTT");
          System.out.println(r.get(FlightInfoListType.class));
       r.get(FlightInfoListType.class);
    } 
     */
     
     @Test
     public void getTest(){
         
         String response = r.get(String.class);
         System.out.println(response);
     }
    
      @Test
     public void getTest2(){
         String res = r.queryParam("id","Jimmy").accept(MediaType.TEXT_PLAIN).
                 get(String.class);
          
         System.out.println(res);
     }
      
      
    
     
    /* 
   @Test
    public void registerFlight() {
        Flight flight = new Flight();
        flight.setNumber(111);
        flight.setName("Jumbo1");
        String res = r.entity(flight).post(String.class);
        assertEquals(FLIGHT_URI + "/111",res);
    }
    
  */

   
   
     
}