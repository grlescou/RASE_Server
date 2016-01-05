/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;


import ht.mbds.haiti.rase.model.MaladieSymptomes;
import ht.mbds.haiti.rase.service.MaladieSymptomesService;
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
@RequestMapping(value="/v1/maladieSymptomes")
public class MaladieSymptomesController {
    
    
    @Autowired private MaladieSymptomesService maladieSymptomesService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public MaladieSymptomes[] getMaladieSymptomesArray() {
        return maladieSymptomesService.findMaladieSymptomesAll().toArray(new MaladieSymptomes[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public MaladieSymptomes getMaladieSymptomesById(@PathVariable("Id") String Id) {     
        MaladieSymptomes maladieSymptomes = maladieSymptomesService.findMaladieSymptomesById(Id) ;
        return maladieSymptomes;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public MaladieSymptomes createMaladieSymptomes(@Valid @RequestBody MaladieSymptomes maladieSymptomes) {
        MaladieSymptomes savedMaladieSymptomes = maladieSymptomesService.saveMaladieSymptomes(maladieSymptomes);
        return savedMaladieSymptomes;
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE})
    public MaladieSymptomes updateMaladieSymptomes(@PathVariable("Id") String maladieSymptomesId,
                              @RequestBody MaladieSymptomes maladieSymptomes) { 
        maladieSymptomes.setId(maladieSymptomesId);
        maladieSymptomesService.saveMaladieSymptomes(maladieSymptomes);
        return maladieSymptomes;
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMaladieSymptomes(@PathVariable("Id") String maladieSymptomesId) {
        maladieSymptomesService.deleteMaladieSymptomes(maladieSymptomesId);
    }

}


