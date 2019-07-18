# RASE_Server
Project RaSE (Social Radio for Epidemiology detection) - context of Haiti - Java EE Spring frameware Web Service

A JSON REST API

Team of 2 (Master 2 MBDS Industrial project)

- Gaetan Robert Lescouflair
- Kathleen Jean-Baptiste 

See RaSEClientWeb repository for the client part
 - Angular JS client


[Project technical document in French](Dossier%20Technique_v1.2.pdf "Project technical document in FR PDF ")

# Code extract and functionality description

**Example of a Maladie (disease) model class**

Source file: Maladie.java 
```java
package ht.mbds.haiti.rase.model.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author MyPC
 */
@Document(collection = "maladie")
public class Maladie implements Serializable 
{
    @Id
    private String id;
    private String nom;
    private String description;
    private double  seuil;
    private String typeSeuil;
    
    @DBRef
    private Categorie categorie;
    @DBRef
    private List<Symptome> symptomes= new ArrayList<Symptome>();
    
    public Maladie() {
    }
    
    @JsonCreator
    public Maladie(@JsonProperty("nom") String nom, @JsonProperty("description") String description, @JsonProperty("seuil") double seuil,  @JsonProperty("typeSeuil") String typeSeuil,@JsonProperty("categorie") Categorie categorie) {
        this.nom = nom;
        this.description = description;
        this.seuil = seuil;
        this.typeSeuil =typeSeuil;
        this.categorie = categorie;
    }
    
/*
    public Maladie(long _id, String nom, String description, int seuil) {
        this.id = _id;
        this.nom = nom;
        this.description = description;
        this.seuil = seuil;
    }

   */

    
    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = _id;
    }


    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getNom ()
    {
        return nom;
    }

    public void setNom (String nom)
    {
        this.nom = nom;
    }

    public double getSeuil() {
        return seuil;
    }

    public void setSeuil(double seuil) {
        this.seuil = seuil;
    }

    public String getTypeSeuil() {
        return typeSeuil;
    }

    public void setTypeSeuil(String typeSeuil) {
        this.typeSeuil = typeSeuil;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Symptome> getSymptomes() {
        return symptomes;
    }

    public void setSymptomes(List<Symptome> symptomes) {
        this.symptomes = symptomes;
    }
    
    
    
    public void addSymptome (Symptome newSymptome){
        symptomes.add(newSymptome);
    }
    
    public void removeSymptome(Symptome removeSymptome){
        symptomes.remove(removeSymptome);
    }
    

    @Override
    public String toString() {
        return "Maladie{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", seuil=" + seuil + '}';
    }

    
    
    
}

```


Example of a repository class
Source file: MaladieRepositry.java

```java 
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Maladie;
import org.springframework.data.repository.Repository;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
/**
 *
 * @author MyPC
 */
public interface MaladieRepository extends MongoRepository<Maladie,String> {
    
    
    public Maladie findByNom(String nom);
     
}

Exemple de classe service 
Ficher source de l’interface : MaladieService.java
package ht.mbds.haiti.rase.service;

import ht.mbds.haiti.rase.model.model.Maladie;
import java.util.List;

/**
 *
 * @author MyPC
 */
public interface MaladieService {
    
    // maladie 
    
    public Maladie findMaladieById(String id);
    
     public Maladie findMaladieByNom(String nom);
     
     public List<Maladie> findMaladieAll();
    
     public Maladie saveMaladie ( Maladie maladie);
     
     public void deleteMaladie (Maladie maladie);
     
     public void deleteMaladie (String id);
     
}


```

Source file of the interface implementation: MaladieServiceImpl.java

```java 
package ht.mbds.haiti.rase.service;

/**
 *
 * @author MyPC
 */

import ht.mbds.haiti.rase.model.model.Maladie;
import ht.mbds.haiti.rase.model.repository.MaladieRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MaladieServiceImpl implements MaladieService {

    @Autowired private MaladieRepository maladieRepository;
    
    @Override
    public Maladie findMaladieById(String id) {
      return maladieRepository.findOne(id);
    }

    @Override
    public Maladie findMaladieByNom(String nom) {
        return maladieRepository.findByNom(nom);
    }

    @Override
    public List<Maladie> findMaladieAll() {
       return maladieRepository.findAll();
    }

    @Override
    public Maladie saveMaladie(Maladie maladie) {
       return maladieRepository.save(maladie);
    }

    @Override
    public void deleteMaladie(Maladie maladie) {
       maladieRepository.delete(maladie);
    }

    @Override
    public void deleteMaladie(String id) {
       maladieRepository.delete(id);
    }
    
}
 

```
Example of REST class
Source file: MaladieController.java

```java 
package ht.mbds.haiti.rase.rest;

/**
 *
 * @author gaetan
 */

import ht.mbds.haiti.rase.model.model.Maladie;
import ht.mbds.haiti.rase.service.MaladieService;
import ht.mbds.haiti.rase.utils.Message;
import ht.mbds.haiti.rase.utils.SimpleMessage;
import javax.validation.Valid;
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
    
    //message success
    static final String success_message_maladie_create = "La maladie a été créée avec succès";
    static final String success_message_maladie_update = "La maladie a été modifiée avec succès";
    static final String success_message_maladie_delete = "La maladie a été supprimée avec succès";
    // message fail
    static final String fail_message_maladie_create = "Echec de création de la maladie";
    static final String fail_message_maladie_update = "Echec de modification de la maladie";
    static final String fail_message_maladie_delete = "Echec de suppression de la maladie";
    
    @Autowired private MaladieService maladieService;
    
    @RequestMapping(method=RequestMethod.GET, produces=APPLICATION_JSON_VALUE)
    public Maladie[] getMaladieArray() {
        return maladieService.findMaladieAll().toArray(new Maladie[]{});
    }
    
     @RequestMapping(value="/{Id}", method=RequestMethod.GET, produces={APPLICATION_JSON_VALUE})
    public Maladie getMaladieById(@PathVariable("Id") String Id) {     
        Maladie maladie = maladieService.findMaladieById(Id) ;
        return maladie;
    }
    
   @RequestMapping(method=RequestMethod.POST, consumes={APPLICATION_JSON_VALUE})
    public Message createMaladie(@Valid @RequestBody Maladie malaide) {
        Message<Maladie> message= null;
        try
        {
            Maladie savedMaladie = maladieService.saveMaladie(malaide);
            message = new Message<Maladie>(success_message_maladie_create,true,savedMaladie);
            return message;
        }
        catch(Exception ex)
        {
            message = new Message<Maladie>(fail_message_maladie_create,false,null);
            return message;
        }
        
    }
    
    
    @RequestMapping(value="{Id}", method=RequestMethod.PUT, consumes={APPLICATION_JSON_VALUE},produces={APPLICATION_JSON_VALUE})
    public SimpleMessage updateMaladie(@PathVariable("Id") String maladieId,
                              @RequestBody Maladie maladie) {
        SimpleMessage message =null;
        try
        {
            maladie.setId(maladieId);
            maladieService.saveMaladie(maladie);
            message= new SimpleMessage(success_message_maladie_update,true);
            return message;
        }
        catch(Exception ex)
        {
            message= new SimpleMessage(fail_message_maladie_update,true);
            return message;
        }
       
       
    }

    @RequestMapping(value="{Id}", method=RequestMethod.DELETE,produces={APPLICATION_JSON_VALUE})
    public SimpleMessage deleteMaladie(@PathVariable("Id") String maladieId) {
         SimpleMessage message =null;
         try
         {
             maladieService.deleteMaladie(maladieId);
             message= new SimpleMessage(success_message_maladie_delete,true);
             return message;
         }
         catch(Exception ex)
         {
             message= new SimpleMessage(fail_message_maladie_delete,true);
             return message;
         }
        
    }

    
}


```

