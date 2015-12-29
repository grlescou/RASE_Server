/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author MyPC
 */
@Document(collection = "zone")
public class Zone implements Serializable 
{
    private String SectionCommunale;

    private String Departement;

    private String Commune;

    private String Arrondissement;

    public String getSectionCommunale ()
    {
        return SectionCommunale;
    }

    public void setSectionCommunale (String SectionCommunale)
    {
        this.SectionCommunale = SectionCommunale;
    }

    public String getDepartement ()
    {
        return Departement;
    }

    public void setDepartement (String Departement)
    {
        this.Departement = Departement;
    }

    public String getCommune ()
    {
        return Commune;
    }

    public void setCommune (String Commune)
    {
        this.Commune = Commune;
    }

    public String getArrondissement ()
    {
        return Arrondissement;
    }

    public void setArrondissement (String Arrondissement)
    {
        this.Arrondissement = Arrondissement;
    }

    @Override
    public String toString()
    {
        return "Zone [SectionCommunale = "+SectionCommunale+", Departement = "+Departement+", Commune = "+Commune+", Arrondissement = "+Arrondissement+"]";
    }
}
			
