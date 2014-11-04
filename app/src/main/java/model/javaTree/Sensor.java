package model.javaTree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by M2M_Ericcson on 24/10/2014.
 * This class represent a device component that takes measures.
 */
public class Sensor implements Serializable {
    //Inside everyone of these Station we would have sensors(Acces from :Gateway)
    private String mdate = null;//The date at which the class is generate
    private String mSensorId = null;//ejem gps,gyroswcope, accelerometer, magnetometer,Bluetooth Classic, BLE, camera
    private String mSensorSpecification = null;//Sensor Aditional information
    private String mSensorType = null;//Sensor Type
    //Every sensor can return diferent values/resources
    private List<Resource> mResourceList = new LinkedList<Resource>();
    //The sensor can send information about it self, example I am alive
    private List<Payload> mPayloadList = new LinkedList<Payload>();//
    /**
     * Constructor
     */
    public Sensor(String mSensorId) {
        this.mSensorId = mSensorId;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }

    public Sensor(String mSensorId, String mSensorSpecification) {
        this.mSensorId = mSensorId;
        this.mSensorSpecification = mSensorSpecification;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }

    public Sensor(String mSensorId, String mSensorSpecification, String mSensorType) {
        this.mSensorId = mSensorId;
        this.mSensorSpecification = mSensorSpecification;
        this.mSensorType = mSensorType;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }
    /**
     * Metod
     * /
     /**GETTER-SETTER
     *  I build all getter and setter, except set mSensorId,because,it is the identifier
     *public void setmSensorId(String mSensorId) {
     *this.mSensorId = mSensorId;
     *}
     */

    public String getDate() {
        return mdate;
    }

    public void setDate(String mdate) {
        this.mdate = mdate;
    }
    public String getSensorId() {
        return mSensorId;
    }

    public String getSensorSpecification() {
        return mSensorSpecification;
    }

    public void setSensorSpecification(String mSensorSpecification) {
        this.mSensorSpecification = mSensorSpecification;
    }

    public String getSensorType() {
        return mSensorType;
    }

    public void setSensorType(String mSensorType) {
        this.mSensorType = mSensorType;
    }

    public List<Resource> getResourceList() {
        return mResourceList;
    }

    public void setResourceList(List<Resource> mResourceList) {
        this.mResourceList = mResourceList;
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
    public void addResource(Resource resource) {
        mResourceList.add(resource);
    }
    public Resource getResource(int i) {
        return  mResourceList.get(i);
    }
    public int getResourceListSize(){
        return  mResourceList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sensor)) return false;

        Sensor sensor = (Sensor) o;

        if (!mSensorId.equals(sensor.mSensorId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mSensorId.hashCode();
    }

}
