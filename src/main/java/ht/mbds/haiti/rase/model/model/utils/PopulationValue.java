/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model.utils;

import java.io.Serializable;

/**
 *
 * @author gaetan
 */
public class PopulationValue implements Serializable {
    private String moins_5an;

    private String femmes;

    private String hommes;

    private String population;

    public String getMoins_5an ()
    {
        return moins_5an;
    }

    public void setMoins_5an (String moins_5an)
    {
        this.moins_5an = moins_5an;
    }

    public String getFemmes ()
    {
        return femmes;
    }

    public void setFemmes (String femmes)
    {
        this.femmes = femmes;
    }

    public String getHommes ()
    {
        return hommes;
    }

    public void setHommes (String hommes)
    {
        this.hommes = hommes;
    }

    public String getPopulation ()
    {
        return population;
    }

    public void setPopulation (String population)
    {
        this.population = population;
    }

    @Override
    public String toString()
    {
        return "PopulationValue [moins_5an = "+moins_5an+", femmes = "+femmes+", hommes = "+hommes+", population = "+population+"]";
    }
}
