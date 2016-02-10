/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.utils;

import ht.mbds.haiti.rase.model.model.Demographie;
import ht.mbds.haiti.rase.model.model.Zone;

/**
 *
 * @author MyPC
 */
public class Zonage {
    
    private Zone zone;

    public Zonage(Demographie demographie) {
        
        zone.setDepartement(demographie.getProperties().getDEPARTEMEN());
        zone.setCommune(demographie.getProperties().getCOMMUNE());
        zone.setArrondissement("none");
        zone.setSectionCommunale("none");
        
    }

    public Zone getZone() {
        return zone;
    }

    public static Zone getZoneFromDemographie(Demographie demographie){
        Zone zone = new Zone();
        zone.setDepartement(demographie.getProperties().getDEPARTEMEN());
        zone.setCommune(demographie.getProperties().getCOMMUNE());
        zone.setArrondissement("none");
        zone.setSectionCommunale("none");
        return zone;
    }
    
}
