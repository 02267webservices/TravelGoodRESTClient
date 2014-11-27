package dtu.ws.rest.resources;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import dtu.ws.group8.lameduck.client.*;
import hotelreservationservices.HotelType;
import hotelreservationservices.HotelsType;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import static org.junit.Assert.assertEquals;


import org.junit.Test;
/**
 *
 * @author emilhein
 */

public class TestFlightResource {
    static final String ITINERARY_URI = "http://localhost:8080/RestWebService/webresources/itineraries";
    //static final String FLIGHTS_URI = "http://localhost:8080/RestWebService/webresources/flights";
    static //final String HOTEL_URI = "http://localhost:8080/RestWebService/webresources/itinerary";
    private ArrayList<String> itine = new ArrayList();
    
  

     /*
  
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
  */
     
     @Test
     public void P1(){
         
     Client client = Client.create();

      //Get list of flights   
     
     List<FlightInfoType> flightsInfo = getFlights(client, "Copenhagen", "Berlin", "2015-01-01");
         
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
      
         addFlightsToItinerary("ABC1234");
         addFlightsToItinerary("ABC4321");
  
         bookItinerary(client);

         
        
       // HotelsType hotelsHolder = getHotels(client);
          
          
      /*    
           if (!hotelsHolder.getHotels().isEmpty()){
                for (int i = 0; i < hotelsHolder.getHotels().size(); i++) {
                    System.out.println(hotelsHolder.getHotels().get(i).getName()+ "\n" +
                           hotelsHolder.getHotels().get(i).getAddress()+ "\n" +
                           hotelsHolder.getHotels().get(i).getBookingNumber());
                }
            }
        */ 
         
          
          
       //  addFlightsToItinerary("ABC12dd34");
        

  
         
         bookHotel(client, "3");
      
   
       
         /*
         ///test cancel 
         String cancel1 = r.queryParam("bookingnumber","ABC1234").delete(String.class);
         System.out.println("True cancelling of booking number was succesfull: " +cancel1);
         assertEquals("true",cancel1);
         
          ///test cancel 
         String cancel2 = r.queryParam("bookingnumber","ABC1234").delete(String.class);
         System.out.println("True cancelling of booking number was succesfull: " +cancel2);
         assertEquals("false",cancel2);
         */
    
     }
     
  public  ArrayList<String> getItinerary() {
            
      return itine;
    }
  
public void bookItinerary(Client client){
   CreditCardInfoType cardInfo = getCardInfo("50408825","Thor-Jensen Claus","2009-05-05");

         for(int i = 0;i<itine.size();i++){
             System.out.println(itine.get(i).toString());
             String result = bookFlight(client, itine.get(i).toString(),cardInfo);
             assertEquals("true", result);
         }
}
     
  public void addFlightsToItinerary(String number){
    itine.add(number);
}
  
  public List<FlightInfoType> getFlights(Client client, String from, String to, String date){
     WebResource r = client.resource(ITINERARY_URI); 
     FlightInfoListType res = r.path("flights").queryParam("from",from).queryParam("to",to).queryParam("date",date).get(new GenericType<FlightInfoListType>(){});
      
     List<FlightInfoType> flightsInfo = res.getFlightInformation();

      
      return flightsInfo;
  }
 
    public HotelsType getHotels(Client client) {
      WebResource r = client.resource(ITINERARY_URI);   
      HotelsType res = r.path("hotels").get(new GenericType<HotelsType>(){});
      
      
      
      return res;
  }
  
  public String bookFlight(Client client, String number, CreditCardInfoType test){
      
      String param2 = test.getCardNumber();
      String param3 = test.getName();
      String param4 = test.getExpiryDate().toString();
    MultivaluedMap queryParams = new MultivaluedMapImpl();
    queryParams.add("bookingnumber", number);
    queryParams.add("cardnumber", param2);
    queryParams.add("name", param3);
    queryParams.add("expdate", param4);

      WebResource r = client.resource(ITINERARY_URI);
      String ans = r.queryParams(queryParams).get(String.class);
      System.out.println(ans);
      return ans;
  }
     
  
   public String bookHotel(Client client, String number){
      WebResource r = client.resource(ITINERARY_URI);
      String ans = r.path("hotel").queryParam("bookingnumber",number).put(String.class);
      System.out.println(ans);
      return ans;
   }

  
   private CreditCardInfoType getCardInfo(String cardnumber, String name, String expdate) {
        CreditCardInfoType cardInfo = new CreditCardInfoType();
       // cardInfo.setCardNumber("50408825");
       // cardInfo.setName("Thor-Jensen Claus");
          cardInfo.setCardNumber(cardnumber);
          cardInfo.setName(name);
          
        try {
            DatatypeFactory df = DatatypeFactory.newInstance();
          //  XMLGregorianCalendar expDate = df.newXMLGregorianCalendar("2009-05-05");
              XMLGregorianCalendar expDate = df.newXMLGregorianCalendar(expdate);

            cardInfo.setExpiryDate(expDate);
        }catch (Exception ex) {
        }
        return cardInfo;
    }  
}