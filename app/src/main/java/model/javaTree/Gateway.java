package model.javaTree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by M2M_Ericcson on 24/10/2014.
 * This class represent a device.The device can have an amount of sensos
 */
public class Gateway implements Serializable {
    //Enviroment Quality Station(Acces from :ApplicationService,GatewayGroup)
    private String mdate = null;//The date at which the class is generate
    private String mGatewayId = null;//SmartPhone123456(unique number, ejem the device MAC)
    private String mGatewaySpecification = null;//Gateway Aditional information="<Android Version>:4.4.2<Bluetooth_type>:DUAL<Based Band>:MSM8610BP_.."
    private String mGatewayType = null;//Gateway Type, example MOTOROLA E
    private List<Sensor> mSensorList = new LinkedList<Sensor>();//in a gateway can have an amount of sensors ejem: gps,gyroswcope, accelerometer, magnetometer,Bluetooth Classic, BLE, camera
    //The gateway can send information about it self, example I am alive
    private List<Payload> mPayloadList = new LinkedList<Payload>();//
    /**
     * Constructor
     */

    public Gateway(String mGatewayId) {
        this.mGatewayId = mGatewayId;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }

    public Gateway(String mGatewayId, String mGatewaySpecification) {
        this.mGatewayId = mGatewayId;
        this.mGatewaySpecification = mGatewaySpecification;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }

    public Gateway(String mGatewayId, String mGatewaySpecification, String mGatewayType) {
        this.mGatewayId = mGatewayId;
        this.mGatewaySpecification = mGatewaySpecification;
        this.mGatewayType = mGatewayType;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }

    /**
     * Metod
     * /
     /**GETTER-SETTER
     *  I build all getter and setter, except set GatewayId,because,it is the identifier
     *     public void setGatewayId(String mGatewayId) {
     this.mGatewayId = mGatewayId;
     }
     */

    public String getGatewayId() {
        return mGatewayId;
    }

    public String getGatewaySpecification() {
        return mGatewaySpecification;
    }

    public void setGatewaySpecification(String mGatewaySpecification) {
        this.mGatewaySpecification = mGatewaySpecification;
    }

    public String getDate() {
        return mdate;
    }

    public void setDate(String mdate) {
        this.mdate = mdate;
    }

    public String getGatewayType() {
        return mGatewayType;
    }

    public void setGatewayType(String mGatewayType) {
        this.mGatewayType = mGatewayType;
    }

    public List<Sensor> getSensorList() {
        return mSensorList;
    }

    public void setSensorList(List<Sensor> mSensorList) {
        this.mSensorList = mSensorList;
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
    public void addSensor(Sensor sensor) {
        mSensorList.add(sensor);
    }
    public Sensor getSensor(int i) {
        return mSensorList.get(i);
    }

    public int getSensorListSize(){
        return mSensorList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gateway)) return false;
        Gateway gateway = (Gateway) o;
        if (!mGatewayId.equals(gateway.mGatewayId)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return mGatewayId.hashCode();
    }
}
