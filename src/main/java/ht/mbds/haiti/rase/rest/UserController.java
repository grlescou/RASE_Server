/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.rest;

import ht.mbds.haiti.rase.model.User;
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
@RequestMapping(value="/v1/user")
public class UserController {
    
    
    @Autowired private UserService userService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public User[] getUserArray() {
        return userService.findUserAll().toArray(new User[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public User getUserById(@PathVariable("Id") String Id) {     
        User user = userService.findUserById(Id) ;
        return user;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public User createUser(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return savedUser;
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE})
    public User updateUser(@PathVariable("Id") String userId,
                              @RequestBody User user) { 
        user.setId(userId);
        userService.saveUser(user);
        return user;
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("Id") String userId) {
        userService.deleteUser(userId);
    }

}
