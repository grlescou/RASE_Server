/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;

import ht.mbds.haiti.rase.model.model.utils.CasMaladieValue;
import ht.mbds.haiti.rase.model.model.utils.DemographieValue;
import java.io.Serializable;

/**
 *
 * @author gaetan
 */


public class PropertiesCommune  implements Serializable {
    
    private String ID_ADM2;

    private String ID_ADM3;

    private String ID_ADM1;

    private String ADM1;

    private String NOM_ADM3;

    private String ADM2;

    private String ADM3;

    private String Shape_Leng;
    
     private CasMaladieValue casMaladieValue;
    
    private DemographieValue  demographieValue ;

    public String getID_ADM2 ()
    {
        return ID_ADM2;
    }

    public void setID_ADM2 (String ID_ADM2)
    {
        this.ID_ADM2 = ID_ADM2;
    }

    public String getID_ADM3 ()
    {
        return ID_ADM3;
    }

    public void setID_ADM3 (String ID_ADM3)
    {
        this.ID_ADM3 = ID_ADM3;
    }

    public String getID_ADM1 ()
    {
        return ID_ADM1;
    }

    public void setID_ADM1 (String ID_ADM1)
    {
        this.ID_ADM1 = ID_ADM1;
    }

    public String getADM1 ()
    {
        return ADM1;
    }

    public void setADM1 (String ADM1)
    {
        this.ADM1 = ADM1;
    }

    public String getNOM_ADM3 ()
    {
        return NOM_ADM3;
    }

    public void setNOM_ADM3 (String NOM_ADM3)
    {
        this.NOM_ADM3 = NOM_ADM3;
    }

    public String getADM2 ()
    {
        return ADM2;
    }

    public void setADM2 (String ADM2)
    {
        this.ADM2 = ADM2;
    }

    public String getADM3 ()
    {
        return ADM3;
    }

    public void setADM3 (String ADM3)
    {
        this.ADM3 = ADM3;
    }

    public String getShape_Leng ()
    {
        return Shape_Leng;
    }

    public void setShape_Leng (String Shape_Leng)
    {
        this.Shape_Leng = Shape_Leng;
    }

    public CasMaladieValue getCasMaladieValue() {
        return casMaladieValue;
    }

    public void setCasMaladieValue(CasMaladieValue casMaladieValue) {
        this.casMaladieValue = casMaladieValue;
    }

    public DemographieValue getDemographieValue() {
        return demographieValue;
    }

    public void setDemographieValue(DemographieValue demographieValue) {
        this.demographieValue = demographieValue;
    }
    
    
    

    @Override
    public String toString()
    {
        return "PropertiesCommune [ID_ADM2 = "+ID_ADM2+", ID_ADM3 = "+ID_ADM3+", ID_ADM1 = "+ID_ADM1+", ADM1 = "+ADM1+", NOM_ADM3 = "+NOM_ADM3+", ADM2 = "+ADM2+", ADM3 = "+ADM3+", Shape_Leng = "+Shape_Leng+"]";
    }
    
    
}
