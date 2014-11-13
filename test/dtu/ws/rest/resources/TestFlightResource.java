package dtu.ws.rest.resources;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.junit.Test;
import static org.junit.Assert.*;
import ws.dtu.rest.data.Flight;


public class TestFlightResource {
     static final String FLIGHT_URI = "http://localhost:8080/RestWebService/webresources/flights";

     Client client = Client.create();
     WebResource r = client.resource(FLIGHT_URI);
        
        
    @Test
    public void findFlight() {
        String result = r.queryParam("id","123").get(String.class);
        assertEquals(FLIGHT_URI + "/123",result);
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