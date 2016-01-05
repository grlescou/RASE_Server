/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.repository;

import ht.mbds.haiti.rase.model.CasMaladie;
import ht.mbds.haiti.rase.model.Demographie;
import ht.mbds.haiti.rase.model.Maladie;
import ht.mbds.haiti.rase.model.MaladieSymptomes;
import ht.mbds.haiti.rase.model.Profession;
import ht.mbds.haiti.rase.model.Symptome;
import ht.mbds.haiti.rase.model.User;
import ht.mbds.haiti.rase.model.Zone;
import ht.mbds.haiti.rase.utils.GeoLocation;
import ht.mbds.haiti.rase.utils.Zonage;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


/**
 *
 * @author MyPC
 */
public class DemographieRepositoryImpl implements DemographieRepositoryCostum {

    @Autowired private MongoOperations mongoOperation ;
    
    @Override
    public Demographie getDemographieByGeomIntersectPoint(GeoLocation Glocation) {
        
        GeoJsonPoint Location = Glocation.getGeoJsonPoint();
          // GeoJsonPoint Location = new GeoJsonPoint (new Point( -72.30497360229492,18.5478128256271));
        // query to search demographie
	Query searchDemoQuery = new Query(Criteria.where("geometry").intersects(Location)) ;
        
        return  mongoOperation.findOne(searchDemoQuery, Demographie.class);
    }

  

    @Override
    public void test() {
         
        Profession  pMedecin = new Profession("Medecin","medecin de soin de sante");
        Profession  pInfirmiere = new Profession("Infirmiere","Infirmiere de soin de sante");
      
        // save
	mongoOperation.save(pMedecin);
          // save
	mongoOperation.save(pInfirmiere);
        

	User user1 = new User("Jean","Pierre","jpierre@gamil.com","pass12345",pMedecin, new GeoJsonPoint(-72.30497360229492,18.5478128256271).getCoordinates(),true,"192.168.1.1",false);
        User user2 = new User("Carl","Preval","cpreval@gamil.com","abc12345",pMedecin,new GeoJsonPoint(-72.30497360229492,18.5478128256271).getCoordinates(),true,"192.168.1.1",false);
        User user3 = new User("Jeanne","Lemoine","jLemoine@gamil.com","pass12345",pInfirmiere,new GeoJsonPoint(-72.30497360229492,18.5478128256271).getCoordinates(),true,"192.168.1.1",false);
         // save
	mongoOperation.save(user1);
         // save
	mongoOperation.save(user2);
         // save
	mongoOperation.save(user3);
        
        
        // query to search user
	Query searchUserQuery = new Query(Criteria.where("mail").is("jpierre@gamil.com"));

	// find the saved user again.
	User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
	System.out.println("Find savedUser : " + savedUser);
         
        // query to search user
	Query searchMaladieQuery = new Query(Criteria.where("nom").is("Choléra"));

	// find the saved user again.
	
        Maladie  m1 =  mongoOperation.findOne(searchMaladieQuery, Maladie.class);
        
        System.out.println("Find maladie : " + m1);
        
       int  idm =(int)Double.parseDouble(m1.getId());
         // query to search user
	Query searchMSQuery = new Query(Criteria.where("maladie._id").is(idm));

	// find the saved user again.
	
        MaladieSymptomes  ms1 =  mongoOperation.findOne(searchMSQuery, MaladieSymptomes.class);
        
        System.out.println("Find maladieSymptomes : " + ms1);
        
        Symptome s1 = ms1.getSymptomes().get(1);
        Symptome s2 = ms1.getSymptomes().get(2);
        Symptome s3 = ms1.getSymptomes().get(3);
        
        List<Symptome> symps = new ArrayList<>();
        symps.add(s1);
        symps.add(s2);
        symps.add(s3);
        
        
        
       GeoJsonPoint Location = new GeoJsonPoint (new Point( -72.30497360229492,18.5478128256271));
        Zone z1 = new Zone();
       CasMaladie cas = new CasMaladie(m1,symps,savedUser,"2015-12-28",Location.getCoordinates(),3,z1);
       
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
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-10-14",Location.getCoordinates(),5,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-24",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      //--------------------------------------------------
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-10-14",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-24",Location.getCoordinates(),2,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-10-14",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-24",Location.getCoordinates(),5,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-10-14",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-24",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-10-14",Location.getCoordinates(),4,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-24",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-24",Location.getCoordinates(),0,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
       Location = new GeoJsonPoint (new Point( -72.39166259765625,18.794517898837615));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-28",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
       
      Location = new GeoJsonPoint (new Point( -72.08129882812499,18.276302250871954));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-10-14",Location.getCoordinates(),1,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point( -73.88031005859375,18.101476387775914));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-11-20",Location.getCoordinates(),3,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
      Location = new GeoJsonPoint (new Point(-73.93524169921875,18.534304453676864));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-24",Location.getCoordinates(),2,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas); 
      
      Location = new GeoJsonPoint (new Point(-71.7901611328125,18.80231812168813));
       
      cas = new CasMaladie(m1,symps,savedUser,"2015-12-24",Location.getCoordinates(),5,null);
      demogSave = mongoOperation.findOne(searchDemoQuery, Demographie.class); 
      cas.setZone(Zonage.getZoneFromDemographie(demogSave));
      // save casMaladie
      mongoOperation.save(cas);  
      
    }
    
}
