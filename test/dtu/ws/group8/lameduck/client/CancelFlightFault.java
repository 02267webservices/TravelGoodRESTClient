
package dtu.ws.group8.lameduck.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "cancelFlightFaultElement", targetNamespace = "http://types.lameduck.group8.ws.dtu")
public class CancelFlightFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private CancelFlightFaultType faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public CancelFlightFault(String message, CancelFlightFaultType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public CancelFlightFault(String message, CancelFlightFaultType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: dtu.ws.group8.lameduck.client.CancelFlightFaultType
     */
    public CancelFlightFaultType getFaultInfo() {
        return faultInfo;
    }

}
