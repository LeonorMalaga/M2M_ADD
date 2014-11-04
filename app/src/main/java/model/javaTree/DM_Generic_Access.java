package model.javaTree;

/**
 * Created by M2M_Ericcson on 24/10/2014.
 * this class conteing the information necesari to comunicate with the data server
 */
public class DM_Generic_Access {
    //Acces CUL parameters
    private String mURLprovisioningAcces = null;//ejem http://10.95.20.162:8181/m2m/provisioning/LL/enterpriseCustomer
    private String mURLsouthboundAcces = null;//ejem http://10.95.20.162:8181/m2m/southbound/dataStore
    private String m_HContentType = null;//ejem Content-Type:application/vnd.ericsoon.m2m.SB+xml;version=1.0
    private String msouthbound_data = null;//ejem @payload.xml
    private String mXMLNSm2m = null;//ejem urn:com:ericsoon:schema:xml:m2m:protocolos:vnd.ericsson.m2m.SB
    private String mXMLNSxsi = null;//ejem https://www.w3.org/2001/XMLSchema-instance
    private String mURLnorthboundAcces = null;//ejem for pullhttp://10.95.20.162:8181/m2m/dataServices/ec/
    private String m_HPullAccept = null;//ejem Accept://application/vnd.ericsson.m2m.NB+xml;version=1.0
    private String mURLnorthboundSubscription = null;// ejem http://10.95.20.162:8181/m2m/dataServices/subscription
    private String mSubscriptionheader = null;//ejem Content-type:application/x-www-form-urlencoded
}
