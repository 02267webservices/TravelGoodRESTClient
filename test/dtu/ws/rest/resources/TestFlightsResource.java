package dtu.ws.rest.resources;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import dtu.ws.group8.lameduck.client.FlightInfoListType;
import dtu.ws.group8.lameduck.client.FlightInfoType;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emil
 */
public class TestFlightsResource {
    
  static final String FLIGHTS_URI = "http://localhost:8080/RestWebService/webresources/flights";
  Client client = Client.create();
  WebResource r = client.resource(FLIGHTS_URI);
    
        
    @Test
     public void getFlights(){
        
         FlightInfoListType res = r.get(new GenericType<FlightInfoListType>(){});
         System.out.println("Here is a list of flights: " +res.getFlightInformation().get(0).getFlightBookingNumber());

        
       
         
     }

}