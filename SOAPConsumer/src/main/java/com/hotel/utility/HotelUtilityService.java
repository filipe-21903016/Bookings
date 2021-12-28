package com.hotel.utility;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.4.5
 * 2021-12-28T19:31:04.311Z
 * Generated source version: 3.4.5
 *
 */
@WebServiceClient(name = "HotelUtilityService",
                  wsdlLocation = "http://localhost:8080/HotelUtility/services/HotelUtilityPort?wsdl",
                  targetNamespace = "http://utility.hotel.com/")
public class HotelUtilityService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://utility.hotel.com/", "HotelUtilityService");
    public final static QName HotelUtilityPort = new QName("http://utility.hotel.com/", "HotelUtilityPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/HotelUtility/services/HotelUtilityPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(HotelUtilityService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/HotelUtility/services/HotelUtilityPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public HotelUtilityService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public HotelUtilityService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HotelUtilityService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public HotelUtilityService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public HotelUtilityService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public HotelUtilityService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns HotelUtility
     */
    @WebEndpoint(name = "HotelUtilityPort")
    public HotelUtility getHotelUtilityPort() {
        return super.getPort(HotelUtilityPort, HotelUtility.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HotelUtility
     */
    @WebEndpoint(name = "HotelUtilityPort")
    public HotelUtility getHotelUtilityPort(WebServiceFeature... features) {
        return super.getPort(HotelUtilityPort, HotelUtility.class, features);
    }

}
