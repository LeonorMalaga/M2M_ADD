package model.javaTree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by M2M_Ericcson on 24/10/2014.
 * This class represent a type of measure of a Sensor.
 * Ejem for gps sensor latitude or longitude,  for BLE parseable string identificate by the bluettoth adress(with ejem:<Adress>:AE1234CD,<device_name>:"LUIS", <RSSI>:"-51dBm")
 */
public class Resource implements Serializable {
    private String mdate = null;//The date at which the class is generate
    private String mResourceId = null;//ejem latitude, longitude, bluettoth adrees
    private String mResourceSpecification = null;//Resource Aditional information, the latitude is repesented by grades minutes and seconds
    private List<Payload> mPayloadList = new LinkedList<Payload>();//List of measures values with his date and type of value
    /**
     * Constructor
     */
    public Resource(String mResourceId) {
        this.mResourceId = mResourceId;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }

    public Resource(String mResourceId, String mResourceSpecification) {
        this.mResourceId = mResourceId;
        this.mResourceSpecification = mResourceSpecification;
        this.mdate = String.valueOf(System.currentTimeMillis());
    }
    /**
     * Metod
     * /
     /**GETTER-SETTER
     *  I build all getter and setter, except set mResourceId,because,it is the identifier
     * public void setmResourceId(String mResourceId) {
     *this.mResourceId = mResourceId;
     *}
     */
    public String getDate() {
        return mdate;
    }

    public void setDate(String mdate) {
        this.mdate = mdate;
    }
    public String getResourceId() {
        return mResourceId;
    }

    public String getResourceSpecification() {
        return mResourceSpecification;
    }

    public void setResourceSpecification(String mResourceSpecification) {
        this.mResourceSpecification = mResourceSpecification;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource)) return false;

        Resource resource = (Resource) o;

        if (!mResourceId.equals(resource.mResourceId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mResourceId.hashCode();
    }
}
