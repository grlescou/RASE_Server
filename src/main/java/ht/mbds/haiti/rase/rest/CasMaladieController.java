/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.CasMaladie;
import ht.mbds.haiti.rase.model.model.Demographie;
import ht.mbds.haiti.rase.model.model.Zone;
import ht.mbds.haiti.rase.service.CasMaladieService;
import ht.mbds.haiti.rase.service.DemographieService;
import ht.mbds.haiti.rase.utils.GeoLocation;
import ht.mbds.haiti.rase.utils.Message;
import ht.mbds.haiti.rase.utils.SimpleMessage;
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
 * @author gaetan
 */
@RestController
@RequestMapping(value="/v1/casMaladie")
public class CasMaladieController {
    
    // message success
    static final String success_message_casMaladie_create = "Le cas maladie a été créé avec succès";
    static final String success_message_casMaladie_update = "Le cas maladie a été modifié avec succès";
    static final String success_message_casMaladie_delete = "Le cas maladie a été supprimé avec succès";
    // message fail
    static final String fail_message_casMaladie_create = "Echec de creation du cas maladie";
    static final String fail_message_casMaladie_update = "Echec de modification du cas maladie";
    static final String fail_message_casMaladie_delete = "Echec de suppression du cas maladie";
    
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
   public Message createCasMaladie(@Valid @RequestBody CasMaladie casMaladie)
    //public CasMaladie createCasMaladie(@Valid @RequestBody CasMaladie casMaladie)
    {
       Message<CasMaladie> message=null;
       try
        {
        GeoLocation location = new GeoLocation(casMaladie.getLocation());
        Demographie demog =demographieService.getDemographieByGeomIntersectPoint(location);
        Zone zone = Zonage.getZoneFromDemographie(demog);
        casMaladie.setZone(zone);
        CasMaladie savedCasMaladie = casMaladieService.saveCasMaladie(casMaladie);
        message = new Message<CasMaladie>(success_message_casMaladie_create,true,savedCasMaladie);
         return message;
        }
       catch(Exception ex)
       {
           message = new Message<CasMaladie>(fail_message_casMaladie_create,false,null);
             return message;
       }
        
   
     }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE})
    public SimpleMessage updateCasMaladie(@PathVariable("Id") String casMaladieId,@RequestBody CasMaladie casMaladie)
    { 
         SimpleMessage message = null;
        try
        {
            casMaladie.setId(casMaladieId);
            casMaladieService.saveCasMaladie(casMaladie);
            message = new SimpleMessage(success_message_casMaladie_update,true);
            return message;
        }
        catch(Exception ex)
        {
             message = new SimpleMessage(fail_message_casMaladie_update,true);
             return message;
        }
       
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteCasMaladie(@PathVariable("Id") String casMaladieId) {
        SimpleMessage message = null;
        try
        {
            casMaladieService.deleteCasMaladie(casMaladieId);
             message = new SimpleMessage(success_message_casMaladie_delete,true);
            return message;
        }
        catch(Exception Ex)
        {
             message = new SimpleMessage(fail_message_casMaladie_delete,true);
            return message;
        }
        
    }
}
