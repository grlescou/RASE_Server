/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.Symptome;
import ht.mbds.haiti.rase.service.SymptomeService;
import ht.mbds.haiti.rase.service.UserService;
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
@RequestMapping(value="/v1/symptome")
public class SymptomeController {
    
    
    @Autowired private SymptomeService symptomeService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Symptome[] getSymptomeArray() {
        return symptomeService.findSymptomeAll().toArray(new Symptome[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Symptome getSymptomeById(@PathVariable("Id") String Id) {     
        Symptome user = symptomeService.findSymptomeById(Id) ;
        return user;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Symptome createSymptome(@Valid @RequestBody Symptome symptome) {
        Symptome savedSymptome = symptomeService.saveSymptome(symptome);
        return savedSymptome;
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE})
    public Symptome updateSymptome(@PathVariable("Id") String symptomeId,
                              @RequestBody Symptome symptome) { 
        symptome.setId(symptomeId);
        symptomeService.saveSymptome(symptome);
        return symptome;
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSymptome(@PathVariable("Id") String symptomeId) {
        symptomeService.deleteSymptome(symptomeId);
    }

}






