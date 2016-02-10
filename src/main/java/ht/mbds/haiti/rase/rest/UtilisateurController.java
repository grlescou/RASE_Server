/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.model.Administrateur;
import ht.mbds.haiti.rase.model.model.PersonnelSante;
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
 * @author MyPC
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
    
    // Authentification utilisateur
    
    @RequestMapping(value="/utilisateur/auth",method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public Message createPersonnelSante(@Valid @RequestBody AuthUtilisateur user) {
        Message<Utilisateur> messageGood = null;
         Message<AuthUtilisateur> messageBad = null;
         Utilisateur authUser= null;
        try{
            
        
        authUser= userService.findUtilisateurByMail(user.getMail());
        if (authUser == null){
            messageBad = new Message<>(fail_message_utilisateur_auth,false,user); 
            return messageBad;
        }
        else{
            
          if(authUser.getPassword().equals(user.getPassword())){
        authUser.setPassword("");
        
         messageGood = new Message<>(success_message_utilisateur_auth,true,authUser);
         return messageGood;
          }
          else{
             messageBad = new Message<>(fail_message_utilisateur_auth,false,user);
             return messageBad;
          }
         
         
         
        }
        }
        catch(Exception ex){
             messageBad = new Message<>(fail_message_utilisateur_auth,false,user);
             return messageBad;
        }
        
    }
    
    
    
    
    // section personnel sante 
    
     @RequestMapping(value="/personnelSante",method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public PersonnelSante[] getPersonnelSanteArray() {
        return userService.findPersonnelSanteAll().toArray(new PersonnelSante[]{});
    }
    
     @RequestMapping(value="/personnelSante/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public PersonnelSante getPersonnelSanteById(@PathVariable("Id") String Id) {     
        PersonnelSante user = userService.findPersonnelSanteById(Id) ;
      
        return user;
    }
    
    @RequestMapping(value="/personnelSante/email/{email}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public PersonnelSante getPersonnelSanteByEmail(@PathVariable("email") String email) {     
        PersonnelSante user = userService.findPersonnelSanteByMail(email) ;
        return user;
    }
    
   @RequestMapping(value="/personnelSante",method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public Message<PersonnelSante> createPersonnelSante(@Valid @RequestBody PersonnelSante user) {
        Message<PersonnelSante> message = null;
        try{
        
        PersonnelSante savedPersonnelSante = userService.savePersonnelSante(user);
         message = new Message<>(success_message_utilisateur_create,true,savedPersonnelSante);
         return message;
        }
        catch(Exception ex){
             message = new Message<>(fail_message_utilisateur_create,false,null);
             return message;
        }
        
    }
    
    
    @RequestMapping(value="/personnelSante/{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updatePersonnelSante(@PathVariable("Id") String userId,
                              @RequestBody PersonnelSante user) { 
       
        //return user;
         SimpleMessage message = null;
        try{
        
        user.setId(userId);
        userService.savePersonnelSante(user);
         message = new SimpleMessage(success_message_utilisateur_update,true);
         return message;
        }
        catch(Exception ex){
             message = new SimpleMessage(fail_message_utilisateur_update,false);
             return message;
        }

        
    }

    @RequestMapping(value="/personnelSante/{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deletePersonnelSante(@PathVariable("Id") String userId) {
    
        SimpleMessage message = null;
        try{
        
         userService.deletePersonnelSante(userId);
         message = new SimpleMessage(success_message_utilisateur_delete,true);
         return message;
        }
        catch(Exception ex){
             message = new SimpleMessage(fail_message_utilisateur_delete,false);
             return message;
        }
        

    }

    
    
    // section Administrateur
    
     @RequestMapping(value="/administrateur",method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Administrateur[] getAdministrateurArray() {
        return userService.findAdministrateurAll().toArray(new Administrateur[]{});
    }
    
     @RequestMapping(value="/administrateur/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Administrateur getAdministrateurById(@PathVariable("Id") String Id) {     
        Administrateur user = userService.findAdministrateurById(Id) ;
      
        return user;
    }
    
    @RequestMapping(value="/administrateur/email/{email}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Administrateur getAdministrateurByEmail(@PathVariable("email") String email) {     
        Administrateur user = userService.findAdministrateurByMail(email) ;
        return user;
    }
    
   @RequestMapping(value="/administrateur",method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE}, produces={APPLICATION_JSON_VALUE})
    public Message<Administrateur> createAdministrateur(@Valid @RequestBody Administrateur user) {
        Message<Administrateur> message = null;
        try{
        
        Administrateur savedAdministrateur = userService.saveAdministrateur(user);
         message = new Message<>(success_message_utilisateur_create,true,savedAdministrateur);
         return message;
        }
        catch(Exception ex){
             message = new Message<>(fail_message_utilisateur_create,false,null);
             return message;
        }
        
    }
    
    
    @RequestMapping(value="/administrateur/{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateAdministrateur(@PathVariable("Id") String userId,
                              @RequestBody Administrateur user) { 
       
        //return user;
         SimpleMessage message = null;
        try{
        
        user.setId(userId);
        userService.saveAdministrateur(user);
         message = new SimpleMessage(success_message_utilisateur_update,true);
         return message;
        }
        catch(Exception ex){
             message = new SimpleMessage(fail_message_utilisateur_update,false);
             return message;
        }     
    }

    @RequestMapping(value="/administrateur/{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteAdministrateur(@PathVariable("Id") String userId) {
    
        SimpleMessage message = null;
        try{
        Administrateur adm = userService.findAdministrateurById(userId);
        
        if (adm.getTypeAdmin().equals("Super-Admin")){
             message = new SimpleMessage(fail_message_utilisateur_delete_Super,true);
            return message;
        }
        
         userService.deleteAdministrateur(userId);
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
