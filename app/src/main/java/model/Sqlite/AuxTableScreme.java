package model.sqlite;

/**
 *Created by M2M_Ericcson on 01/11/2014.
 * auxiliar class to make ArrayList<AuxTableScreme>
 */
public class AuxTableScreme {
    public String columName=null;
    public String type=null;
    public String value=null;

    public AuxTableScreme(String columName, String type, String value) {
        this.columName = columName;
        this.type = type;
        this.value = value;
    }

}
