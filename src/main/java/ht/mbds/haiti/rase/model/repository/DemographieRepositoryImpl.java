/*
 * To change this license header, choose License Headers in Project PropertiesDemographie.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.Administrateur;
import ht.mbds.haiti.rase.model.model.Adresse;
import ht.mbds.haiti.rase.model.model.CasMaladie;
import ht.mbds.haiti.rase.model.model.Categorie;
import ht.mbds.haiti.rase.model.model.Commune;
import ht.mbds.haiti.rase.model.model.Demographie;
import ht.mbds.haiti.rase.model.model.Departement;
import ht.mbds.haiti.rase.model.model.GroupeIndividu;
import ht.mbds.haiti.rase.model.model.Maladie;
import ht.mbds.haiti.rase.model.model.Utilisateur;
//import ht.mbds.haiti.rase.model.model.MaladieSymptomes;
import ht.mbds.haiti.rase.model.model.MentionResponsabilite;
import ht.mbds.haiti.rase.model.model.Symptome;
import ht.mbds.haiti.rase.model.model.User;
import ht.mbds.haiti.rase.model.model.Personne;
import ht.mbds.haiti.rase.model.model.Role;
import ht.mbds.haiti.rase.model.model.Zone;
import ht.mbds.haiti.rase.model.model.utils.CasMaladieMR;
import ht.mbds.haiti.rase.model.model.utils.DemographieValue;
import ht.mbds.haiti.rase.utils.GeoLocation;
import ht.mbds.haiti.rase.utils.SimpleMessage;
import ht.mbds.haiti.rase.utils.Zonage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;


/**
 *
 * @author gaetan
 */
public class DemographieRepositoryImpl implements DemographieRepositoryCostum {

    @Autowired private MongoOperations mongoOperation ;
    @Autowired private MentionResponsabiliteRepository mentionRepo;
    @Autowired private MaladieRepository maladieRepo;
    @Autowired private CategorieRepository categorieRepo;
    
    
    @Autowired private CasMaladieRepository casMaladieRepo;
    @Autowired private UtilisateurRepository utilisateurRepo;
    @Autowired private DemographieRepository demographietRepo;
    
    
    @Autowired private  GroupeIndividuRepository grouepRepo;
    @Autowired private RoleRepository roleRepo;
    
    @Override
    public Demographie getDemographieByGeomIntersectPoint(GeoLocation Glocation) {
        
        GeoJsonPoint Location = Glocation.getGeoJsonPoint();
          // GeoJsonPoint Location = new GeoJsonPoint (new Point( -72.30497360229492,18.5478128256271));
        // query to search demographie
	Query searchDemoQuery = new Query(Criteria.where("geometry").intersects(Location)) ;
        
        return  mongoOperation.findOne(searchDemoQuery, Demographie.class);
    }
    
//    @Override
//    public void test() {
//        
//    }

 

    @Override
    public void test() {
        
       
        //Role roleU = new Role("Utilisateur");
              
         
      //  MentionResponsabilite  pMedecin = new MentionResponsabilite("Medecin","medecin de soin de sante");
       // MentionResponsabilite  pInfirmiere = new MentionResponsabilite("Infirmiere","Infirmiere de soin de sante");
      
       MentionResponsabilite  pMedecin = mentionRepo.findByNom("Medecin");
       MentionResponsabilite  pInfirmiere = mentionRepo.findByNom("Infirmiere");
       
       Categorie virus = categorieRepo.findByNom("virus");
       Categorie bact = categorieRepo.findByNom("bacterie");
        // save
	//mongoOperation.save(pMedecin);
          // save
	//mongoOperation.save(pInfirmiere);
        

	//PersonnelSante user1 = personSantRepo.findByMail(mail);
      //  Utilisateur user2 = personSantRepo.findByMail(mail);
      //  Utilisateur user3 = personSantRepo.findByMail(mail);
        // save
	//mongoOperation.save(user1);
         // save
	//mongoOperation.save(user2);
         // save
	//mongoOperation.save(user3);
        
        
        // query to search user
	//Query searchUserQuery = new Query(Criteria.where("mail").is("jpierre@gamil.com"));

	// find the saved user again.
	//User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
	//System.out.println("Find savedUser : " + savedUser);
         
        // query to search malaide
	Query searchMaladieQuery = new Query(Criteria.where("nom").is("Choléra"));

	// find the saved user again.
	
        Maladie  m1 =  mongoOperation.findOne(searchMaladieQuery, Maladie.class);
        
        System.out.println("Find maladie : " + m1);
        
        
        
        // query to search malaide
	searchMaladieQuery = new Query(Criteria.where("nom").is("Fièvre typhoïde"));

	// find the saved user again.
	
        Maladie  m2 =  mongoOperation.findOne(searchMaladieQuery, Maladie.class);
        
        System.out.println("Find maladie : " + m2);
        
        
          // query to search malaide
	searchMaladieQuery = new Query(Criteria.where("nom").is("Chikungunya"));

	// find the saved user again.
	
        Maladie  m3 =  mongoOperation.findOne(searchMaladieQuery, Maladie.class);
        
        System.out.println("Find maladie : " + m3);
        
        
        
        
       int  idm =(int)Double.parseDouble(m1.getId());
         // query to search user
	Query searchMSQuery = new Query(Criteria.where("maladie._id").is(idm));

	// find the saved user again.

 /*comment----        MaladieSymptomes  ms1 =  mongoOperation.findOne(searchMSQuery, MaladieSymptomes.class);
        
        System.out.println("Find maladieSymptomes : " + ms1);
        
        Symptome s1 = ms1.getSymptomes().get(1);
        Symptome s2 = ms1.getSymptomes().get(2);
        Symptome s3 = ms1.getSymptomes().get(3);
        
        List<Symptome> symps = new ArrayList<>();
        symps.add(s1);
        symps.add(s2);
        symps.add(s3);
        
       --- comment */
 
       Utilisateur savedUser = utilisateurRepo.findByMail("jpierre@gamil.com");
        
       GeoJsonPoint Location = new GeoJsonPoint (new Point( -72.30497360229492,18.5478128256271));
        Zone z1 = new Zone();
       CasMaladie cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-12-28",Location.getCoordinates(),3,z1);
       
       // query to search demographie
	Query searchDemoQuery = new Query(Criteria.where("geometry").intersects(Location));
        
        Demographie demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class);
	System.out.println("2. find - demogSave : " + demogSave);
         Zone z2 = new Zone();
        z2.setDepartement(demogSave.getProperties().getDEPARTEMEN());
        z2.setCommune(demogSave.getProperties().getCOMMUNE());
        z2.setArrondissement("none");
        z2.setSectionCommunale("none");
        
        cas.setZone(z2);
        
         // save casMaladie
	mongoOperation.save(cas);
        
        //--------------------------------------------- Cas Maladie adding 
        
      Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-10-14",Location.getCoordinates(),5,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-12-24",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      //--------------------------------------------------
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-10-14",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-12-24",Location.getCoordinates(),2,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-10-14",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Moins_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),5,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-10-14",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-10-14",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),0,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-10-14",Location.getCoordinates(),1,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),2,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m1,m1.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),5,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      
      
      
      
      
      
      
      
          //--------------------------------------------- Cas Maladie adding part 2 
        
      Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-10-14",Location.getCoordinates(),5,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      //--------------------------------------------------
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Homme","Plus_de_5","2015-10-14",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),2,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-10-14",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),5,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-10-14",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser,pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser, pMedecin,"Homme","Plus_de_5","2015-10-14",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser, pMedecin,"Homme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser, pMedecin,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),0,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-10-14",Location.getCoordinates(),1,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),2,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m2,m2.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),5,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      
      
      
      
      
      
      
      
      
      
          //--------------------------------------------- Cas Maladie adding  part 3
        
      Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Homme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Homme","Plus_de_5","2015-10-14",Location.getCoordinates(),5,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Homme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      //--------------------------------------------------
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Homme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Homme","Plus_de_5","2015-10-14",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Homme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),2,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-10-14",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),5,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-10-14",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pMedecin,"Femme","Plus_de_5","2015-10-14",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pInfirmiere,"Homme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pInfirmiere,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pInfirmiere,"Homme","Plus_de_5","2015-12-24",Location.getCoordinates(),0,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pInfirmiere,"Homme","Plus_de_5","2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pInfirmiere,"Femme","Plus_de_5","2015-10-14",Location.getCoordinates(),1,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pInfirmiere,"Femme","Plus_de_5","2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pInfirmiere,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),2,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m3,m3.getSymptomes(),savedUser, pInfirmiere,"Femme","Plus_de_5","2015-12-24",Location.getCoordinates(),5,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      
      
      
      
      
      
      
      
      
    }

  
    
    
    

    @Override
    public boolean createUtilisateur() {
       
        try{
         Role roleAdm = new Role("Administrateur");
         Role roleUser = new Role("Utilisateur");
         
         mongoOperation.save(roleAdm);
         mongoOperation.save(roleUser);
        
        GroupeIndividu groupePersonnelSante = new GroupeIndividu("PersonnelSante","Une Personne qui occupe une fonction medicale: Medecin, Infirmiere, Pharmacien");
        GroupeIndividu groupePersonneAvise = new GroupeIndividu("PersonneAvise","Une Personne qui occupe un poste de superieur hierachique telque : Directeur d'ecole, Chef d'entreprise, Chef religieux...");
        
        mongoOperation.save(groupePersonnelSante);
        mongoOperation.save(groupePersonneAvise);
        
        groupePersonnelSante = grouepRepo.findByNomGroupe("PersonnelSante");
        groupePersonneAvise = grouepRepo.findByNomGroupe("PersonneAvise");
        
        MentionResponsabilite  pMedecin = new MentionResponsabilite("Medecin","medecin de soin de sante",groupePersonnelSante);
        MentionResponsabilite  pInfirmiere = new MentionResponsabilite("Infirmiere","Infirmiere de soin de sante",groupePersonnelSante);
        MentionResponsabilite  pAvise = new MentionResponsabilite("Directeur d'ecole","Resposable d'eleve d'ecole",groupePersonneAvise);
        
        //Profession  pMedecin = profRepo.findByNom("Medecin");
        //Profession  pInfirmiere = profRepo.findByNom("Infirmiere");
        
        // save
	mongoOperation.save(pMedecin);
	mongoOperation.save(pInfirmiere);
        mongoOperation.save(pAvise);
        
        
         pMedecin = mentionRepo.findByNom("Medecin");
         pInfirmiere = mentionRepo.findByNom("Infirmiere");
        
         roleUser = roleRepo.findByPrivilege("Utilisateur");
         roleAdm = roleRepo.findByPrivilege("Administrateur");
         
        
        // Personnel de sante 
	Utilisateur user1 = new Utilisateur("Jean","Pierre","jpierre@gamil.com","pass12345",roleUser,"50937695611",new Adresse(),true,"192.168.1.1",pMedecin, new GeoJsonPoint(-72.30497360229492,18.5478128256271).getCoordinates(),"En Cours");
        Utilisateur user2 = new Utilisateur("Carl","Preval","cpreval@gamil.com","abc12345",roleUser,"50937898882",new Adresse(),true,"192.168.1.1",pMedecin,new GeoJsonPoint(-72.30497360229492,18.5478128256271).getCoordinates(),"En Cours");
        Utilisateur user3 = new Utilisateur("Jeanne","Lemoine","jLemoine@gamil.com","pass12345",roleUser,"50938694631",new Adresse(),true,"192.168.1.1",pInfirmiere,new GeoJsonPoint(-72.30497360229492,18.5478128256271).getCoordinates(),"Accepter");
         // save
	mongoOperation.save(user1);
         // save
	mongoOperation.save(user2);
         // save
	mongoOperation.save(user3);
        
        // administrateur
        
        Administrateur admin1 = new Administrateur("Jacques","Laurent","jLaurent@gmail.com","pass12345",roleAdm,"50938694631",new Adresse(),true,"192.168.1.1","Super-Admin");
        Administrateur admin2 = new Administrateur("Jules","Paul","julesPaul@gmail.com","pass12345",roleAdm,"50938694631",new Adresse(),true,"192.168.1.1","Admin");
        
         // save
	mongoOperation.save(admin1);
         // save
	mongoOperation.save(admin2);
        
        return true;
        
        }catch(Exception ex){
            return false;
        }
        
        
    }

    @Override
    public SimpleMessage creerCategorie() {
      
       SimpleMessage message = null;
        try{
            
        
        Categorie c1 = new Categorie("virus", "maladie liee a des virus");
        Categorie c2 = new Categorie("bacterie", "maladie liee a des virus");
        Categorie c3 = new Categorie("piqure moustique", "maladie liee piqure moustique");
        
          // query to search user
	Query searchMaladieQuery = new Query(Criteria.where("nom").is("Choléra"));

	// find the saved user again.
	
        Maladie  m1 =  maladieRepo.findByNom("Choléra");
        c1.addMaladie(m1);
        
        
        
       categorieRepo.save(c1);
       categorieRepo.save(c2);
       categorieRepo.save(c3);
       
        
        
        
            return new SimpleMessage("categorie ajouter avec succes",true);
      
        }
        catch(Exception ex)
        {
            return  new SimpleMessage("echec categorie ajouter",false);
        }
        
        
    }
    
    
    @Override
     public Map<String,DemographieValue> getDemographieByDepartement(){
        
      //Query query = new Query(where("maladie.$id").is("1"));
      MapReduceResults<DemographieValue> results = mongoOperation.mapReduce("geo_section_demographie", "classpath:/js/MapDepartement.js", "classpath:/js/ReduceDepartement.js", DemographieValue.class);
    Map<String,DemographieValue> listDemographieValueMRs= new HashMap<String,DemographieValue>();
    for (DemographieValue valueObject : results) {
        System.out.println(valueObject);
        listDemographieValueMRs.put(valueObject.get_id().toLowerCase().replaceFirst(" ", "-"),valueObject);
    }  
       return listDemographieValueMRs ;
    }
         
         
     
     @Override
     public Map<String,DemographieValue> getDemographieByCommune(){
        
      //Query query = new Query(where("maladie.$id").is("1"));
      MapReduceResults<DemographieValue> results = mongoOperation.mapReduce("geo_section_demographie", "classpath:/js/MapCommune.js", "classpath:/js/ReduceCommune.js", DemographieValue.class);
    Map<String,DemographieValue> listDemographieValueMRs= new HashMap<String,DemographieValue>();
    for (DemographieValue valueObject : results) {
        System.out.println(valueObject);
        listDemographieValueMRs.put(valueObject.get_id().toLowerCase(),valueObject);
    }  
       return listDemographieValueMRs ;
    }
         
         
    
     
     
     
     
      @Override
    public List<Demographie> getSectionCommunaleDemographieCM(long idMaladie){
    
      List<Demographie> listCommune= demographietRepo.findAll();
    
      Map<String,CasMaladieMR> listCasMaladieMRs= casMaladieRepo.getCasMaladieMR_SectionCommunale(idMaladie);
    
       Map<String,DemographieValue> listDemographieValueMRs= demographietRepo.getDemographieByCommune();
    
    for (Demographie sec : listCommune) {
       
        String StrCommune = sec.getProperties().getSection().toLowerCase();
        
        //listCasMaladieMRs.get(StrDepartement);
        //listDemographieValueMRs.get(StrDepartement);
        
        if(listCasMaladieMRs.containsKey(StrCommune)){
        sec.getProperties().setCasMaladieValue(listCasMaladieMRs.get(StrCommune).getValue());
        }
        else
        {
           sec.getProperties().setCasMaladieValue(null);   
        }
        
        
    } 
       return listCommune ;
    }
    
     
     
    
    
}
