/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.job;

/**
 *
 * @author gaetan
 */

import ht.mbds.haiti.rase.model.model.Adresse;
import ht.mbds.haiti.rase.model.model.CasMaladie;
import ht.mbds.haiti.rase.model.model.Categorie;
import ht.mbds.haiti.rase.model.model.Demographie;
import ht.mbds.haiti.rase.model.model.HistoriqueDetection;
import java.util.List;
import org.springframework.scheduling.annotation.Scheduled;

import ht.mbds.haiti.rase.model.model.Maladie;
import ht.mbds.haiti.rase.model.model.MentionResponsabilite;
import ht.mbds.haiti.rase.model.model.Role;
import ht.mbds.haiti.rase.model.model.Utilisateur;
import ht.mbds.haiti.rase.model.model.Zone;
import ht.mbds.haiti.rase.model.repository.CategorieRepository;
import ht.mbds.haiti.rase.model.repository.MentionResponsabiliteRepository;
import ht.mbds.haiti.rase.model.repository.RoleRepository;
import ht.mbds.haiti.rase.model.repository.UtilisateurRepository;
import ht.mbds.haiti.rase.service.CasMaladieService;
import ht.mbds.haiti.rase.service.DemographieService;
import ht.mbds.haiti.rase.service.HistoriqueDetectionService;
import ht.mbds.haiti.rase.service.MaladieService;
import ht.mbds.haiti.rase.service.MentionResponsabiliteService;
import ht.mbds.haiti.rase.service.RoleService;
import ht.mbds.haiti.rase.service.SectionCommunaleService;
import ht.mbds.haiti.rase.service.UtilisateurService;
import ht.mbds.haiti.rase.utils.DateUtils;
import ht.mbds.haiti.rase.utils.GeoLocation;
import ht.mbds.haiti.rase.utils.Zonage;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;


public class JobDetection {
    @Autowired private SectionCommunaleService sectionService;
    @Autowired private MaladieService maladieService;
     @Autowired private HistoriqueDetectionService historiqueDetectionService;
     
     
     @Autowired private CasMaladieService casMaladieService;
     @Autowired private DemographieService demographieService;
     
     @Autowired private MentionResponsabiliteService mentionRepo;
     @Autowired private CategorieRepository categorieRepo;
     
        @Autowired private UtilisateurService utilisateurRepo;
        
         @Autowired private RoleService roleRepo;
     
     static final  int cas = 300000;
     
     
    @Scheduled(fixedRate=cas)
    public void Periodique() {
        System.out.println("I am called by Spring scheduler");
        
      List<Maladie> listeMaladie = maladieService.findMaladieAll();
      
      
      
      
      for (Maladie m : listeMaladie){
             
              Date df = new Date();
              Date db = DateUtils.addDays(df, -8);
              String dateDebut = DateUtils.dateToString(db);
              String dateFin = DateUtils.dateToString(df);
          
            List<Demographie> demographies = sectionService.getSectionCommunale(Long.parseLong(m.getId()) , dateDebut, dateFin, "", 0);
            
            for (Demographie demo : demographies){
                
               long pop = Long.parseLong(demo.getProperties().getPOPULATION());
               
               double seuil = m.getSeuil();  //demo.getProperties().getCasMaladieValue().getMaladie().getSeuil();
               
               long nbCas = demo.getProperties().getCasMaladieValue().getCount();
               
               String typeSeuil = m.getTypeSeuil();
               
               
               
               
               
      if (typeSeuil.equals("Incidence cumulée") )
      {
            if (    (nbCas/pop) >= seuil   )
            {
                HistoriqueDetection histo = new HistoriqueDetection();
                histo.setCommune(demo.getProperties().getCOMMUNE());
                histo.setDateDebut(dateDebut);
                histo.setDateFin(dateFin);
                histo.setDateDetection(dateFin);
                histo.setDepartement(demo.getProperties().getDEPARTEMEN());
                histo.setFemme(demo.getProperties().getCasMaladieValue().getFemmes());
                histo.setHomme(demo.getProperties().getCasMaladieValue().getHommes());
                histo.setMaladie(m.getNom());
                histo.setMoins_5ans(demo.getProperties().getCasMaladieValue().getMoins_5an());
                histo.setSectionCommunale(demo.getProperties().getSection());
                histo.setSeuil(seuil);
                histo.setTypeSeuil(m.getTypeSeuil());
                histo.setNombresCas(nbCas);
                historiqueDetectionService.saveHistoriqueDetection(histo);
              
            }
             else {
                 

            }

      }
      else if (typeSeuil.equals("Incidence") )
      { 
           if (  (nbCas/seuil) >= 1  )
            {
                HistoriqueDetection histo = new HistoriqueDetection();
                histo.setCommune(demo.getProperties().getCOMMUNE());
                histo.setDateDebut(dateDebut);
                histo.setDateFin(dateFin);
                histo.setDateDetection(dateFin);
                histo.setDepartement(demo.getProperties().getDEPARTEMEN());
                histo.setFemme(demo.getProperties().getCasMaladieValue().getFemmes());
                histo.setHomme(demo.getProperties().getCasMaladieValue().getHommes());
                histo.setMaladie(m.getNom());
                histo.setMoins_5ans(demo.getProperties().getCasMaladieValue().getMoins_5an());
                histo.setSectionCommunale(demo.getProperties().getSection());
                histo.setSeuil(seuil);
                histo.setTypeSeuil(m.getTypeSeuil());
                histo.setNombresCas(nbCas);
                historiqueDetectionService.saveHistoriqueDetection(histo);
            }
             else {
                 

            }
      }
      else
      {
          
      }
               
               
               
               
                
            }
          
      }
      
    }    
      
@Scheduled(fixedRate=200)      
public void Limitaleur() {
    System.out.println("===================Nouveau cas Maladie en cours===================");
       Random random;   
      double minlat = 18.020;
      double maxlat=  20.090 ;

      double minlon = -74.480;
      double maxlon=  -72.25;

      List<String> listeSexe = new ArrayList<String>();
      
      listeSexe.add("Femme");
      listeSexe.add("Homme");
      listeSexe.add("Mixe");
      
       List<String> listegroupeAge = new ArrayList<String>();
       
       listegroupeAge.add("Moins_de_5");
       listegroupeAge.add("Plus_de_5");
      

    random = new Random();
    double lat = minlat + (maxlat - minlat) * random.nextDouble();
    
      System.out.println("lat ="+lat);
   
      double lon = minlon + (maxlon - minlon) * random.nextDouble();
      
      System.out.println("lon ="+lon);
      List<Maladie> listeMaladie = maladieService.findMaladieAll();
      
       int minM = 0 ;
       int maxM= listeMaladie.size();
      
       int valueM = minM +  random.nextInt(maxM);
       System.out.println("Value Maladie ="+valueM);
       
       int note = 1 +  random.nextInt(5);
       
       System.out.println("note ="+note);
       
         int nbcas = 1 + random.nextInt(10);
         
         System.out.println("nbcas ="+nbcas);
         
         
        int minS = 0 ;
       int maxS= listeSexe.size();
      
       int valueS = minS +  random.nextInt(maxS);
       
       System.out.println("sexe ="+valueS);
       
       
       int minG = 0 ;
       int maxG= listegroupeAge.size();
      
       int valueG = minG + random.nextInt(maxG);
       
       System.out.println("Age grpoue ="+valueG);
       
       String age = listegroupeAge.get(minG);
       
       String sexe = listeSexe.get(minS);
       
       System.out.println("sexe ="+sexe+"  age="+age);
       
       
       int minD = 0 ;
       int maxD=  30;
      
       int valueD = minD +  random.nextInt(maxD);
       
       System.out.println("date minus value ="+valueD);
       
              Date df = new Date();
              //Date db = DateUtils.addDays(df, -valueD);
              String dateReport = DateUtils.addDaysToString(df, -valueD);
              
              System.out.println("Date Report  ="+dateReport);
          
        System.out.println("ready to report");
         
        try{
       MentionResponsabilite  pMedecin = mentionRepo.findMentionResponsabiliteByNom("Medecin");
       //MentionResponsabilite  pInfirmiere = mentionRepo.findMentionResponsabiliteByNom("Infirmiere");
       
       //Categorie virus = categorieRepo.findByNom("virus");
       //Categorie bact = categorieRepo.findByNom("bacterie");
       Role roleUser = roleRepo.findRoleByPrivilege("Utilisateur");
       
        Utilisateur savedUser = utilisateurRepo.findUtilisateurByMail("jlucien@raseht.com");
       
        if( savedUser == null ){
       // Personnel de sante 
       System.out.println("creation nouveau user =");
	Utilisateur user1 = new Utilisateur("jean","lucien","jlucien@raseht.com","pass12345",roleUser,"50937695611",new Adresse(),true,"192.168.1.1",pMedecin, new GeoJsonPoint(-72.30497360229492,18.5478128256271).getCoordinates(),"En Cours",null);
          utilisateurRepo.saveUtilisateur(user1);
        
         savedUser = utilisateurRepo.findUtilisateurByMail("jlucien@raseht.com");
        }
        
        Maladie m = listeMaladie.get(valueM);
        
        System.out.println("Maladie class ="+m);
        
        GeoJsonPoint locationP = new GeoJsonPoint (new Point( lon,lat));
        GeoLocation location = new GeoLocation(locationP.getCoordinates());
        Demographie demog =demographieService.getDemographieByGeomIntersectPoint(location);
        
         
        while(demog == null){
              System.out.println("=========re try lat and lon===============");
           lat = minlat + (maxlat - minlat) * random.nextDouble();
    
      System.out.println("lat ="+lat);
   
       lon = minlon + (maxlon - minlon) * random.nextDouble();
      
      System.out.println("lon ="+lon);
      
       locationP = new GeoJsonPoint (new Point( lon,lat));
       location = new GeoLocation(locationP.getCoordinates());
       demog =demographieService.getDemographieByGeomIntersectPoint(location);
     
      
            
        }
        
       Zone zone = Zonage.getZoneFromDemographie(demog);
        
        CasMaladie  casMaladie = new CasMaladie(m,m.getSymptomes(),savedUser, pMedecin,sexe,age,dateReport,locationP.getCoordinates(),note,nbcas,zone);
        
        
        
        
        casMaladie.setZone(zone);
         System.out.println("begin to report");
          System.out.println("Before cas Maladie reporter");
        
        CasMaladie savedCasMaladie = casMaladieService.saveCasMaladie(casMaladie);
      
        System.out.println("Nouveau cas Maladie reporter");
        System.out.println(savedCasMaladie);
          System.out.println("==================================================================");
       }
       catch(Exception ex){
             System.out.println("message d'erreur :"+ ex.getLocalizedMessage());
       }
    
    
    
    
     
 }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   /*     
      if (feature.getProperty('population')) {
      pop = feature.getProperty('population');
      
      var casMaladie = feature.getProperty("casMaladieValue");
      var seuil = casMaladie.maladie.seuil;
      var nbCas = casMaladie.count;
      var typeSeuil = casMaladie.maladie.typeSeuil;
      
      if (typeSeuil === "Incidence cumulée")
      {
            if (  ((nbCas/pop)/seuil) >=0 && ((nbCas/pop)/seuil) <=0.25   )
            {
                color = "green";
            }
            else if(((nbCas/pop)/seuil) >0.25 && ((nbCas/pop)/seuil) <=0.50 )
            {
                color = "yellow";
            }
            else if(((nbCas/pop)/seuil) >0.50 && ((nbCas/pop)/seuil) <=0.75 ){
                color = "orange";
            }
            else if( ((nbCas/pop)/seuil) > 0.75 && ((nbCas/pop)/seuil) <=1 ) {
                color = "red";
            }
             else {
                  color = "white";

            }

      }
      else if (typeSeuil === "Incidence")
      { 
           if (  (nbCas/seuil) >=0 && (nbCas/seuil) <=0.25   )
            {
                color = "green";
            }
            else if( (nbCas/seuil) >0.25 && (nbCas/seuil) <=0.50 )
            {
                color = "yellow";
            }
            else if( (nbCas/seuil) >0.50 && (nbCas/seuil) <=0.75 ){
                color = "orange";
            }
            else if( (nbCas/seuil) > 0.75 && (nbCas/seuil) <=1 ) {
                color = "red";
            }
             else {
                  color = "white";

            }
      }
      else
      {
           color = "white";
      }
        
       
        
    }
    */ 
    
}
