/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Administrateur;
import ht.mbds.haiti.rase.model.model.Personne;
import ht.mbds.haiti.rase.model.model.Personne;
import ht.mbds.haiti.rase.model.model.Utilisateur;
import ht.mbds.haiti.rase.model.model.utils.AuthUtilisateur;
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
import ht.mbds.haiti.rase.utils.Message;
import ht.mbds.haiti.rase.utils.SimpleMessage;
/**
 *
 * @author gaetan
 */

@RestController
@RequestMapping(value="/v1")
public class UtilisateurController {
    
    // message success
    static final String success_message_utilisateur_create = "L'utilisateur a ete cree avec succes";
    static final String success_message_utilisateur_update = "L'utilisateur a ete modifie avec succes";
    static final String success_message_utilisateur_delete = "L'utilisateur a ete supprime avec succes";
    static final String success_message_utilisateur_auth = "Authentification avec success";
    // message fail
    static final String fail_message_utilisateur_create = "Echec de creation de l'utilisateur";
    static final String fail_message_utilisateur_update = "Echec de modification de l'utilisateur";
    static final String fail_message_utilisateur_delete = "Echec de suppression de l'utilisateur";
    static final String fail_message_utilisateur_delete_Super ="Desole, vous pouvez pas supprimer le Super-Admin";
    static final String fail_message_utilisateur_auth = "Echec - utilisateur ou mot de passe incorrect";
    
    @Autowired private UtilisateurService userService;
  

    
    @RequestMapping(value="/personne",method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Personne[] getPersonneArray() {
        return userService.findPersonneAll().toArray(new Personne[]{});
    }
    
     @RequestMapping(value="/personne/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Personne getPersonneById(@PathVariable("Id") String Id) {     
        Personne user = userService.findPersonneById(Id) ;
   
        return user;
    }
    
    @RequestMapping(value="/personne/email/{email}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Personne getPersonneByEmail(@PathVariable("email") String email) {     
        Personne user = userService.findPersonneByMail(email) ;
        return user;
    }
    
    // Authentification personne
    
    @RequestMapping(value="/personne/auth",method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public Message createUtilisateur(@Valid @RequestBody AuthUtilisateur user) {
        Message<Personne> messageGood = null;
         Message<AuthUtilisateur> messageBad = null;
         Personne authUser= null;
        try{
            
        
        authUser= userService.findPersonneByMail(user.getMail());
        if (authUser == null){
            messageBad = new Message<AuthUtilisateur>(fail_message_utilisateur_auth,false,user); 
            return messageBad;
        }
        else{
            
          if(authUser.getPassword().equals(user.getPassword())){
        authUser.setPassword("");
        
         messageGood = new Message<Personne>(success_message_utilisateur_auth,true,authUser);
         return messageGood;
          }
          else{
             messageBad = new Message<AuthUtilisateur>(fail_message_utilisateur_auth,false,user);
             return messageBad;
          }
         
         
         
        }
        }
        catch(Exception ex){
             messageBad = new Message<AuthUtilisateur>(fail_message_utilisateur_auth,false,user);
             return messageBad;
        }
        
    }
    
    
    
    
    // section personnel sante 
    
     @RequestMapping(value="/utilisateur",method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Utilisateur[] getUtilisateurArray() {
        return userService.findUtilisateurAll().toArray(new Utilisateur[]{});
    }
    
     @RequestMapping(value="/utilisateur/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Utilisateur getUtilisateurById(@PathVariable("Id") String Id) {     
        Utilisateur user = userService.findUtilisateurById(Id) ;
      
        return user;
    }
    
    @RequestMapping(value="/utilisateur/email/{email}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Utilisateur getUtilisateurByEmail(@PathVariable("email") String email) {     
        Utilisateur user = userService.findUtilisateurByMail(email) ;
        return user;
    }
    
   @RequestMapping(value="/utilisateur",method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public Message<Utilisateur> createUtilisateur(@Valid @RequestBody Utilisateur user) {
        Message<Utilisateur> message = null;
        try{
        
        Utilisateur savedUtilisateur = userService.saveUtilisateur(user);
         message = new Message<Utilisateur>(success_message_utilisateur_create,true,savedUtilisateur);
         return message;
        }
        catch(Exception ex){
             message = new Message<Utilisateur>(fail_message_utilisateur_create,false,null);
             return message;
        }
        
    }
    
    
    @RequestMapping(value="/utilisateur/{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateUtilisateur(@PathVariable("Id") String userId,
                              @RequestBody Utilisateur user) { 
       
        //return user;
         SimpleMessage message = null;
        try{
        
        user.setId(userId);
        userService.saveUtilisateur(user);
         message = new SimpleMessage(success_message_utilisateur_update,true);
         return message;
        }
        catch(Exception ex){
             message = new SimpleMessage(fail_message_utilisateur_update,false);
             return message;
        }

        
    }

    @RequestMapping(value="/utilisateur/{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteUtilisateur(@PathVariable("Id") String userId) {
    
        SimpleMessage message = null;
        try{
        
         userService.deleteUtilisateur(userId);
         message = new SimpleMessage(success_message_utilisateur_delete,true);
         return message;
        }
        catch(Exception ex){
             message = new SimpleMessage(fail_message_utilisateur_delete,false);
             return message;
        }
        

    }

    
    
    
    // @ResponseStatus(HttpStatus.NO_CONTENT)
   
}
