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
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author gaetan
 */
@Document(collection = "utilisateur")
public class Utilisateur extends Personne implements Serializable {
    
    
    
    
    @DBRef
    private MentionResponsabilite mentionResponsabilite;
    
    // the coordinates must be stored in the longitude, latitude order
    private List<Double> dernierLocation;
    private String status ;  // "En Cours", "Accepter" , "Rejeter"
    
    private List<Justificatif> piecesJustificatifs;

    public Utilisateur() {
    }
    

    @JsonCreator
    public Utilisateur(@JsonProperty("prenom") String prenom, @JsonProperty("nom") String nom, @JsonProperty("mail") String mail, @JsonProperty("password") String password, @JsonProperty("role") Role role, @JsonProperty("telephone") String telephone, @JsonProperty("adresse") Adresse adresse,  @JsonProperty("actif") boolean actif, @JsonProperty("ip")  String ip, @JsonProperty("mentionResposabilite") MentionResponsabilite mentionResposabilite,  @JsonProperty("dernierLocation")   List<Double> dernierLocation, @JsonProperty("status") String status, @JsonProperty("piecesJustificatifs") List<Justificatif> piecesJustificatifs) {
        super(prenom, nom, mail, password, role, telephone, adresse, actif, ip);
        this.mentionResponsabilite = mentionResposabilite;
        this.dernierLocation = dernierLocation;
        this.status = status;
        this.piecesJustificatifs = piecesJustificatifs;
    }
    
  

    public MentionResponsabilite getMentionResponsabilite() {
        return mentionResponsabilite;
    }

    public void setMentionResponsabilite(MentionResponsabilite mentionResponsabilite) {
        this.mentionResponsabilite = mentionResponsabilite;
    }

    

    public List<Double> getDernierLocation() {
        return dernierLocation;
    }

    public void setDernierLocation(List<Double> dernierLocation) {
        this.dernierLocation = dernierLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Justificatif> getPiecesJustificatifs() {
        return piecesJustificatifs;
    }

    public void setPiecesJustificatifs(List<Justificatif> piecesJustificatifs) {
        this.piecesJustificatifs = piecesJustificatifs;
    }

    
     public void PiecesJustificatifs (Justificatif justificatif){
        this.piecesJustificatifs.add(justificatif);
    }
    
    public void removePiecesJustificatifs(Justificatif justificatif){
       this.piecesJustificatifs.remove(justificatif);
    }
    
    
    
    
}
