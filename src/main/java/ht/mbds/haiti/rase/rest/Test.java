/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

/**
 *
 * @author gaetan
 */


import ht.mbds.haiti.rase.model.model.Maladie;
import ht.mbds.haiti.rase.service.DemographieService;
import ht.mbds.haiti.rase.utils.SimpleMessage;
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

@RestController
@RequestMapping(value="/v1/test")
public class Test {
     @Autowired private DemographieService demo;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public String getTest() {
        demo.test();
        return "Test done..";
    }
    
       @RequestMapping(value="/user", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public SimpleMessage getTestUser() {     
        
        return demo.createUtilisateur();
    }
    
     @RequestMapping(value="/categorie", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public SimpleMessage creerCategorie(){
        return demo.createCategorie();
    }
    
}
