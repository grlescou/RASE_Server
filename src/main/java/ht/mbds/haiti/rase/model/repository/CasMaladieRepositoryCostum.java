/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.repository;

import ht.mbds.haiti.rase.model.model.utils.CasMaladieMR;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gaetan
 */
public interface CasMaladieRepositoryCostum {
    
  // MapReduce and groupe
   
   
   public Map<String,CasMaladieMR> getCasMaladieMR_Departement(Long idMaldie, String dateDebut,String dateFin, String Mention, int note);
   
    public Map<String,CasMaladieMR> getCasMaladieMR_Commune(Long idMaldie, String dateDebut,String dateFin, String Mention, int note);
    
    public Map<String,CasMaladieMR> getCasMaladieMR_SectionCommunale(Long idMaldie, String dateDebut,String dateFin, String Mention, int note);
     
    
}
