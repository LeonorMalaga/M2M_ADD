package model.javaTree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Created by M2M_Ericcson on 24/10/2014.
 * This class represent a group of devices
 */
public class GatewayGroup implements Serializable {
    //GatewayGroup(Acces from :EntepriseCustomer,User )
   //Is not a good idea-> private Enterprise_Technician_Data EnterpriseOwner= null; //this atribute has the information about : A gateway group is responsability of a worker. This worker is working for a company in a concrete project and for a concrete client
    private String mGatewayGroupId = null;
    private String mGatewayGroupSpecification = null;//GatewayGroup Aditional information
    private String mGatewayGroupType = null;//GatewayGroup Type
    private List<Gateway> mGatewayList = new LinkedList<Gateway>();//in a gateway can have an amount of sensors ejem: gps,gyroswcope, accelerometer, magnetometer,Bluetooth Classic, BLE, camera
    //The gatewaygroup can send information about it self, example I am alive
    private List<Payload> mPayloadList = new LinkedList<Payload>();//
    private String mdate = null;//The date at which the class is generate
    /**
     * Constructor
     */
    public GatewayGroup(String mGatewayGroupId) {
        this.mGatewayGroupId = mGatewayGroupId;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }

    public GatewayGroup(String mGatewayGroupId, String mGatewayGroupSpecification) {
        this.mGatewayGroupId = mGatewayGroupId;
        this.mGatewayGroupSpecification = mGatewayGroupSpecification;
        this.mdate = String.valueOf(System.currentTimeMillis());

    }

    public GatewayGroup(String mGatewayGroupId, String mGatewayGroupSpecification, String mGatewayGroupType) {
        this.mGatewayGroupId = mGatewayGroupId;
        this.mGatewayGroupSpecification = mGatewayGroupSpecification;
        this.mGatewayGroupType = mGatewayGroupType;
        this.mdate = String.valueOf(System.currentTimeMillis());

    }
/**
 * Metod
 * /
 /**GETTER-SETTER
 *  I build all getter and setter, except set GatewayGroupId,because It is the identifier
 *
 * public void setGatewayGroupId(String mGatewayGroupId) {
 *this.mGatewayGroupId = mGatewayGroupId;
 }
 *  */


public String getDate() {
    return mdate;
}

    public void setDate(String mdate) {
        this.mdate = mdate;
    }
    public String getGatewayGroupId() {
        return mGatewayGroupId;
    }


    public String getGatewayGroupSpecification() {
        return mGatewayGroupSpecification;
    }

    public void setGatewayGroupSpecification(String mGatewayGroupSpecification) {
        this.mGatewayGroupSpecification = mGatewayGroupSpecification;
    }

    public String getGatewayGroupType() {
        return mGatewayGroupType;
    }

    public void setGatewayGroupType(String mGatewayGroupType) {
        this.mGatewayGroupType = mGatewayGroupType;
    }

    public List<Gateway> getGatewayList() {
        return mGatewayList;
    }

    public void setGatewayList(List<Gateway> mGatewayList) {
        this.mGatewayList = mGatewayList;
    }

    public List<Payload> getPayloadList() {
        return mPayloadList;
    }

    public void setPayloadList(List<Payload> mPayloadList) {
        this.mPayloadList = mPayloadList;
    }
    /*
*OTHER
*/
    public void addPayload(Payload payload) {
        mPayloadList.add(payload);
    }
    public Payload getPayload(int i) {
        return mPayloadList.get(i);
    }
    public int getPayloadListSize(){
        return mPayloadList.size();
    }
    public void addGateway(Gateway gateway) {
        mGatewayList.add(gateway);
    }
    public Gateway getGateway(int i) {
        return mGatewayList.get(i);
    }

    public int getGatewayListSize(){
        return mGatewayList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GatewayGroup)) return false;

        GatewayGroup that = (GatewayGroup) o;

        if (!mGatewayGroupId.equals(that.mGatewayGroupId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mGatewayGroupId.hashCode();
    }
}
