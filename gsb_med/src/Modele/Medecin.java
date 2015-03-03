/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

/**
 *
 * @author sio
 */
public class Medecin {
   private String nom; 
    private String prenom; 
     private String adresse; 
      private String specialite; 
       private String tel; 

    public Medecin(String nom, String prenom, String adresse, String specialite, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.specialite = specialite;
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getTel() {
        return tel;
    }
       
}
