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
    private long moins_5an;

    private long femmes;

    private long hommes;

    private long population;

    public long getMoins_5an ()
    {
        return moins_5an;
    }

    public void setMoins_5an (long moins_5an)
    {
        this.moins_5an = moins_5an;
    }

    public long getFemmes ()
    {
        return femmes;
    }

    public void setFemmes (long femmes)
    {
        this.femmes = femmes;
    }

    public long getHommes ()
    {
        return hommes;
    }

    public void setHommes (long hommes)
    {
        this.hommes = hommes;
    }

    public long getPopulation ()
    {
        return population;
    }

    public void setPopulation (long population)
    {
        this.population = population;
    }

    @Override
    public String toString()
    {
        return "PopulationValue [moins_5an = "+moins_5an+", femmes = "+femmes+", hommes = "+hommes+", population = "+population+"]";
    }
}
