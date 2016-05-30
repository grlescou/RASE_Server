/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.model.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author gaetan
 */
@Document(collection = "historique_detection")
public class HistoriqueDetection implements Serializable {

    @Id
    private String id;
    private String dateDetection;
    private String maladie;
    private int periode;
    private String dateDebut;
    private String dateFin;
    private double seuil;
    private String typeSeuil;
    private String departement;
    private String commune;
    private String sectionCommunale;
    private long nombresCas;
    private long femme;
    private long homme ;
    private long moins_5ans;
    @DBRef
    private List<Confirmation> listeConfirmation ;
    private boolean valider ;
    private String validerPar;

    public HistoriqueDetection() {
    }

    @JsonCreator
    public HistoriqueDetection(@JsonProperty("dateDetection") String dateDetection,@JsonProperty("maladie") String maladie,@JsonProperty("periode") int periode,@JsonProperty("dateDebut") String dateDebut,@JsonProperty("dateFin") String dateFin, @JsonProperty("seuil") double seuil, @JsonProperty("typeSeuil") String typeSeuil,@JsonProperty("departement") String departement,@JsonProperty("commune") String commune, @JsonProperty("sectionCommunale") String sectionCommunale,@JsonProperty("nombresCas") long nombresCas,@JsonProperty("femme") long femme,@JsonProperty("homme") long homme,@JsonProperty("homme") long moins_5ans ,@JsonProperty("valider") boolean valider,@JsonProperty("validerPar") String validerPar) {
        
        this.dateDetection = dateDetection;
        this.maladie = maladie;
        this.periode = periode;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.seuil = seuil;
        this.typeSeuil = typeSeuil;
        this.departement = departement;
        this.commune = commune;
        this.sectionCommunale = sectionCommunale;
        this.nombresCas = nombresCas;
        this.femme = femme;
        this.homme = homme;
        this.moins_5ans = moins_5ans;
        this.valider = valider;
        this.validerPar = validerPar;
    }
    
     @JsonIgnore
    public boolean isNew() {
        return id == null;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateDetection() {
        return dateDetection;
    }

    public void setDateDetection(String dateDetection) {
        this.dateDetection = dateDetection;
    }

    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
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

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getSectionCommunale() {
        return sectionCommunale;
    }

    public void setSectionCommunale(String sectionCommunale) {
        this.sectionCommunale = sectionCommunale;
    }

    public long getNombresCas() {
        return nombresCas;
    }

    public void setNombresCas(long nombresCas) {
        this.nombresCas = nombresCas;
    }

    public long getFemme() {
        return femme;
    }

    public void setFemme(long femme) {
        this.femme = femme;
    }

    public long getHomme() {
        return homme;
    }

    public void setHomme(long homme) {
        this.homme = homme;
    }

    public long getMoins_5ans() {
        return moins_5ans;
    }

    public void setMoins_5ans(long moins_5ans) {
        this.moins_5ans = moins_5ans;
    }

    public List<Confirmation> getListeConfirmation() {
        return listeConfirmation;
    }

    public void setListeConfirmation(List<Confirmation> listeConfirmation) {
        this.listeConfirmation = listeConfirmation;
    }
    
    public void PiecesJustificatifs (Confirmation confirmation){
         this.listeConfirmation.add(confirmation);
    }
    
    public void removePiecesJustificatifs(Confirmation confirmation){
        this.listeConfirmation.remove(confirmation);
    }

    public boolean isValider() {
        return valider;
    }

    public void setValider(boolean valider) {
        this.valider = valider;
    }

    public String getValiderPar() {
        return validerPar;
    }

    public void setValiderPar(String validerPar) {
        this.validerPar = validerPar;
    }
    
    
    

}
