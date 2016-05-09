/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Administrateur;
import ht.mbds.haiti.rase.model.model.utils.AuthUtilisateur;
import ht.mbds.haiti.rase.service.AdministrateurService;
import ht.mbds.haiti.rase.service.AdministrateurService;
import ht.mbds.haiti.rase.utils.Message;
import ht.mbds.haiti.rase.utils.SimpleMessage;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gaetan
 */
@RestController
@RequestMapping(value="/v1/administrateur")
public class AdminstrateurController {
    
    
       // message success
    static final String success_message_administrateur_create = "L'administrateur a ete cree avec succes";
    static final String success_message_administrateur_update = "L'administrateur a ete modifie avec succes";
    static final String success_message_administrateur_delete = "L'administrateur a ete supprime avec succes";
    static final String success_message_administrateur_auth = "Authentification avec success";
    // message fail
    static final String fail_message_administrateur_create = "Echec de creation de l'administrateur";
    static final String fail_message_administrateur_update = "Echec de modification de l'administrateur";
    static final String fail_message_administrateur_delete = "Echec de suppression de l'administrateur";
    static final String fail_message_administrateur_delete_Super ="Desole, vous pouvez pas supprimer le Super-Admin";
    static final String fail_message_administrateur_auth = "Echec - administrateur ou mot de passe incorrect";
    
     @Autowired private AdministrateurService  userService;
    
    // section Administrateur
    
     @RequestMapping(method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Administrateur[] getAdministrateurArray() {
        return userService.findAdministrateurAll().toArray(new Administrateur[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Administrateur getAdministrateurById(@PathVariable("Id") String Id) {     
        Administrateur user = userService.findAdministrateurById(Id) ;
      
        return user;
    }
    
    @RequestMapping(value="/email/{email}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Administrateur getAdministrateurByEmail(@PathVariable("email") String email) {     
        Administrateur user = userService.findAdministrateurByMail(email) ;
        return user;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE}, produces={APPLICATION_JSON_VALUE})
    public Message<Administrateur> createAdministrateur(@Valid @RequestBody Administrateur user) {
        Message<Administrateur> message = null;
        try{
        
        Administrateur savedAdministrateur = userService.saveAdministrateur(user);
         message = new Message<Administrateur>(success_message_administrateur_create,true,savedAdministrateur);
         return message;
        }
        catch(Exception ex){
             message = new Message<Administrateur>(fail_message_administrateur_create,false,null);
             return message;
        }
        
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateAdministrateur(@PathVariable("Id") String userId,
                              @RequestBody Administrateur user) { 
       
        //return user;
         SimpleMessage message = null;
        try{
        
        user.setId(userId);
        userService.saveAdministrateur(user);
         message = new SimpleMessage(success_message_administrateur_update,true);
         return message;
        }
        catch(Exception ex){
             message = new SimpleMessage(fail_message_administrateur_update,false);
             return message;
        }     
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteAdministrateur(@PathVariable("Id") String userId) {
    
        SimpleMessage message = null;
        try{
        Administrateur adm = userService.findAdministrateurById(userId);
        
        if (adm.getTypeAdmin().equals("Super-Admin")){
             message = new SimpleMessage(fail_message_administrateur_delete_Super,true);
            return message;
        }
        
         userService.deleteAdministrateur(userId);
         message = new SimpleMessage(success_message_administrateur_delete,true);
         return message;
        }
        catch(Exception ex){
             message = new SimpleMessage(fail_message_administrateur_delete,false);
             return message;
        }
        

    }

    
     // Authentification Utilsateur
    
    @RequestMapping(value="/auth",method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public Message createAdministrateur(@Valid @RequestBody AuthUtilisateur user) {
        Message<Administrateur> messageGood = null;
         Message<AuthUtilisateur> messageBad = null;
         Administrateur authUser= null;
        try{
            
        
        authUser= userService.findAdministrateurByMail(user.getMail());
        if (authUser == null){
            messageBad = new Message<AuthUtilisateur>(fail_message_administrateur_auth,false,user); 
            return messageBad;
        }
        else{
            
          if(authUser.getPassword().equals(user.getPassword())){
        authUser.setPassword("");
        
         messageGood = new Message<Administrateur>(success_message_administrateur_auth,true,authUser);
         return messageGood;
          }
          else{
             messageBad = new Message<AuthUtilisateur>(fail_message_administrateur_auth,false,user);
             return messageBad;
          }
         
         
         
        }
        }
        catch(Exception ex){
             messageBad = new Message<AuthUtilisateur>(fail_message_administrateur_auth,false,user);
             return messageBad;
        }
        
    }
    
    
}

        