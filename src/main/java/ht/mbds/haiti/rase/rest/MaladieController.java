/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

/**
 *
 * @author MyPC
 */

import ht.mbds.haiti.rase.model.Maladie;
import ht.mbds.haiti.rase.service.MaladieService;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/v1/maladie")
public class MaladieController {
    
    @Autowired private MaladieService maladieService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Maladie[] getCountryArray() {
        return maladieService.findMaladieAll().toArray(new Maladie[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Maladie getCountry(@PathVariable("Id") long Id) {     
        Maladie maladie = maladieService.findMaladieById(Id) ;
        return maladie;
    }
}
