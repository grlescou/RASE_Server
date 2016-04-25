/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Categorie;
import ht.mbds.haiti.rase.service.CategorieService;
import ht.mbds.haiti.rase.utils.Message;
import ht.mbds.haiti.rase.utils.SimpleMessage;
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
 * @author Kathleen
 */
@RestController
@RequestMapping(value="/v1/categorie")
public class CategorieController {
    
    //message success
    static final String success_message_categorie_create = "La catégorie a été créée avec succès";
    static final String success_message_categorie_update = "La catégorie a été modifiée avec succès";
    static final String success_message_categorie_delete = "La catégorie a été supprimée avec succès";
    // message fail
    static final String fail_message_categorie_create = "Echec de création de la catégorie";
    static final String fail_message_categorie_update = "Echec de modification de la catégorie";
    static final String fail_message_categorie_delete = "Echec de suppression de la catégorie";
    
    
    @Autowired private CategorieService categorieService;
    
     @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Categorie[] getCategorieArray() {
        return categorieService.findCategorieAll().toArray(new Categorie[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Categorie getCategorieById(@PathVariable("Id") String Id) {     
        Categorie categorie = categorieService.findCategorieById(Id) ;
        return categorie;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createCategorie(@Valid @RequestBody Categorie categorie) {
        Message<Categorie> message=null;
        try
        {
            Categorie savedCategorie = categorieService.saveCategorie(categorie);
            message = new Message<Categorie>(success_message_categorie_create,true,savedCategorie);
            return message;
        }
        catch(Exception ex)
        {
            message = new Message<Categorie>(fail_message_categorie_create,false,null);
            return message;
        }
        
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateCategorie(@PathVariable("Id") String categorieId,
                              @RequestBody Categorie categorie) { 
        SimpleMessage message=null;
        try
        {
            categorie.setId(categorieId);
            categorieService.saveCategorie(categorie);
            message=new SimpleMessage(success_message_categorie_update,true);
            return message;
        }
       catch(Exception ex)
       {
           message=new SimpleMessage(fail_message_categorie_update,true);
            return message;
       }
       
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public SimpleMessage deleteCategorie(@PathVariable("Id") String categorieId) {
        SimpleMessage message=null;
        try
        {
            categorieService.deleteCategorie(categorieId);
            message=new SimpleMessage(success_message_categorie_delete,true);
            return message;
        }
        catch(Exception ex)
        {
            message=new SimpleMessage(fail_message_categorie_delete,true);
            return message;
        }
        
    }

    
    
}
