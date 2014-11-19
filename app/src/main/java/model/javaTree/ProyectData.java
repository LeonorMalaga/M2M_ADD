package model.javaTree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by M2M_Ericcson on 24/10/2014.
 * this class represent the relationship between the user of this aplication with his company, the client of the company, and the proyect about he is working
 */
public class ProyectData implements Serializable {
    /**
     * Atributte
     */
    //Company
    private String mdate = null;//Date of ther reguister
    private String mOperatorIdentifier = null;//ejem DataIntegratorSL, the company
    private String mOperatorPassword = null;//for DM acces//ejem Password1
    private String mDomainApplicationId = null;//ejem domainApplicationMalaga,the proyect about he is working
    private String mDomainPassword = null;//Credential acces
    private String mEnterpriseCustomerId = null;//ejem enterpriseCustomerMalaga, the client of the company
    //Technician responsible of GatewayGroup
    private String mUserId = null;//ejem 45713701M, the user of this aplication
    private String mPassword = null;//Credential acces
    //This Proyect will can be compose of a lot of GatewayGroups
    private List<GatewayGroup> mGatewayGroupList = new LinkedList<GatewayGroup>();//ejem Smartphones, WifiRouters, Temperature Sensors group, others

    /**
     * Constructor
     */
    public ProyectData(String mOperatorIdentifier, String mOperatorPassword, String mDomainApplicationId, String mDomainPassword, String mEnterpriseCustomerId, String mUserId, String mPassword) {
        this.mOperatorIdentifier = mOperatorIdentifier;
        this.mOperatorPassword = mOperatorPassword;
        this.mDomainApplicationId = mDomainApplicationId;
        this.mDomainPassword = mDomainPassword;
        this.mEnterpriseCustomerId = mEnterpriseCustomerId;
        this.mUserId = mUserId;
        this.mPassword = mPassword;
        this.mdate =String.valueOf(System.currentTimeMillis());
    }
    /**
     * Metod
     * /
     /**GETTER-SETTER
     *  I build all getter and setter, because,a client with a harwared structure and a technician ,
     *  can change the company that give support and pay to the technician
     */
    public String getDate() {
        return mdate;
    }

    public void setDate(String mdate) {
        this.mdate = mdate;
    }
    public String getOperatorIdentifier() {
        return mOperatorIdentifier;
    }

    public void setOperatorIdentifier(String mOperatorIdentifier) {
        this.mOperatorIdentifier = mOperatorIdentifier;
    }

    public String getOperatorPassword() {
        return mOperatorPassword;
    }

    public void setOperatorPassword(String mOperatorPassword) {
        this.mOperatorPassword = mOperatorPassword;
    }

    public String getDomainApplicationId() {
        return mDomainApplicationId;
    }

    public void setDomainApplicationId(String mDomainApplicationId) {
        this.mDomainApplicationId = mDomainApplicationId;
    }

    public String getDomainPassword() {
        return mDomainPassword;
    }

    public void setDomainPassword(String mDomainPassword) {
        this.mDomainPassword = mDomainPassword;
    }

    public String getEnterpriseCustomerId() {
        return mEnterpriseCustomerId;
    }

    public void setEnterpriseCustomerId(String mEnterpriseCustomerId) {
        this.mEnterpriseCustomerId = mEnterpriseCustomerId;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String mUserId) {
        this.mUserId = mUserId;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public List<GatewayGroup> getGatewayGroupList() {
        return mGatewayGroupList;
    }

    public void setGatewayGroupList(List<GatewayGroup> mGatewayGroupList) {
        this.mGatewayGroupList = mGatewayGroupList;
    }
    /*
     *OTHER
     */
    public void addGatewayGroup(GatewayGroup gatewayGroup) {
        mGatewayGroupList.add(gatewayGroup);
    }
    public GatewayGroup getGatewayGroup(int i) {
        return mGatewayGroupList.get(i);
    }

    public int getGatewayGroupListSize(){
        return mGatewayGroupList.size();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProyectData)) return false;

        ProyectData that = (ProyectData) o;

        if (!mDomainApplicationId.equals(that.mDomainApplicationId)) return false;
        if (mDomainPassword != null ? !mDomainPassword.equals(that.mDomainPassword) : that.mDomainPassword != null)
            return false;
        if (mEnterpriseCustomerId != null ? !mEnterpriseCustomerId.equals(that.mEnterpriseCustomerId) : that.mEnterpriseCustomerId != null)
            return false;
        if (!mOperatorIdentifier.equals(that.mOperatorIdentifier)) return false;
        if (mOperatorPassword != null ? !mOperatorPassword.equals(that.mOperatorPassword) : that.mOperatorPassword != null)
            return false;
        if (mPassword != null ? !mPassword.equals(that.mPassword) : that.mPassword != null)
            return false;
        if (!mUserId.equals(that.mUserId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mOperatorIdentifier.hashCode();
        result = 31 * result + (mOperatorPassword != null ? mOperatorPassword.hashCode() : 0);
        result = 31 * result + mDomainApplicationId.hashCode();
        result = 31 * result + (mDomainPassword != null ? mDomainPassword.hashCode() : 0);
        result = 31 * result + (mEnterpriseCustomerId != null ? mEnterpriseCustomerId.hashCode() : 0);
        result = 31 * result + mUserId.hashCode();
        result = 31 * result + (mPassword != null ? mPassword.hashCode() : 0);
        return result;
    }
}
