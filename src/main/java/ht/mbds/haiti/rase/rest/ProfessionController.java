/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Profession;
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
import ht.mbds.haiti.rase.service.UtilisateurService;
/**
 *
 * @author MyPC
 */

@RestController
@RequestMapping(value="/v1/profession")
public class ProfessionController {
    
    
    @Autowired private UtilisateurService professionService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Profession[] getProfessionArray() {
        return professionService.findProfessionAll().toArray(new Profession[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Profession getProfessionById(@PathVariable("Id") String Id) {     
        Profession profession = professionService.findProfessionById(Id) ;
        return profession;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Profession createProfession(@Valid @RequestBody Profession profession) {
        Profession savedProfession = professionService.saveProfession(profession);
        return savedProfession;
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE})
    public Profession updateProfession(@PathVariable("Id") String professionId,
                              @RequestBody Profession profession) { 
        profession.setId(professionId);
        professionService.saveProfession(profession);
        return profession;
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfession(@PathVariable("Id") String professionId) {
        professionService.deleteProfession(professionId);
    }

}


