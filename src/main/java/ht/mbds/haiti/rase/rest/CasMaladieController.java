/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.CasMaladie;
import ht.mbds.haiti.rase.model.Demographie;
import ht.mbds.haiti.rase.model.Zone;
import ht.mbds.haiti.rase.service.CasMaladieService;
import ht.mbds.haiti.rase.service.DemographieService;
import ht.mbds.haiti.rase.utils.GeoLocation;
import ht.mbds.haiti.rase.utils.Zonage;
import javax.validation.Valid;
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
@RequestMapping(value="/v1/casMaladie")
public class CasMaladieController {
     @Autowired private CasMaladieService casMaladieService;
     @Autowired private DemographieService demographieService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public CasMaladie[] getCasMaladieArray() {
        return casMaladieService.findCasMaladieAll().toArray(new CasMaladie[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public CasMaladie getCasMaladieById(@PathVariable("Id") String Id) {     
        CasMaladie casMaladie = casMaladieService.findCasMaladieById(Id) ;
        return casMaladie;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public CasMaladie createCasMaladie(@Valid @RequestBody CasMaladie casMaladie) {
        GeoLocation location = new GeoLocation(casMaladie.getLocation());
        Demographie demog =demographieService.getDemographieByGeomIntersectPoint(location);
        Zone zone = Zonage.getZoneFromDemographie(demog);
        casMaladie.setZone(zone);
        CasMaladie savedCasMaladie = casMaladieService.saveCasMaladie(casMaladie);
        return savedCasMaladie;
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE})
    public CasMaladie updateCasMaladie(@PathVariable("Id") String casMaladieId,
                              @RequestBody CasMaladie casMaladie) { 
        casMaladie.setId(casMaladieId);
        casMaladieService.saveCasMaladie(casMaladie);
        return casMaladie;
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCasMaladie(@PathVariable("Id") String casMaladieId) {
        casMaladieService.deleteCasMaladie(casMaladieId);
    }
}
