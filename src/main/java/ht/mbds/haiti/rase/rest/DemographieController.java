/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Demographie;
import ht.mbds.haiti.rase.model.model.Demographie;
import ht.mbds.haiti.rase.utils.GeoLocation;
import java.util.List;

import ht.mbds.haiti.rase.service.DemographieService;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author MyPC
 */

@RestController
@RequestMapping(value="/v1/demographie")
public class DemographieController {
    
    @Autowired private DemographieService demographieService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Demographie[] getDemographieArray() {
        return demographieService.findDemographieAll().toArray(new Demographie[]{});
    }
    
     @RequestMapping(value="/{x}/{y}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Demographie getDemographieByGeomIntersectPoint(@PathVariable("x") Double x ,@PathVariable("y") Double y) {     
        //Demographie demographie = demographieService.getDemographieByGeomIntersectPoint(new GeoLocation(-72.30497360229492,18.5478128256271));
        
        System.out.println("x:"+x+"  y:"+y);
          Demographie demographie = demographieService.getDemographieByGeomIntersectPoint(new GeoLocation(x,y));
        if (demographie ==  null){
            return null;
        }
        return demographie;
    }
   
   
   
   
     
}



 /*
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Demographie createDemographie(@Valid @RequestBody Demographie demographie) {
        Demographie savedDemographie = demographieService.saveDemographie(demographie);
        return savedDemographie;
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE})
    public Demographie updateDemographie(@PathVariable("Id") String demographieId,
                              @RequestBody Demographie demographie) { 
        demographie.setId(demographieId);
        demographieService.saveDemographie(demographie);
        return demographie;
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDemographie(@PathVariable("Id") String demographieId) {
        demographieService.deleteDemographie(demographieId);
    }
    
    */
    
    