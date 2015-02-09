/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

/**
 *
 * @author sio
 */
public class medecin {
   private String nom; 
    private String prenom; 
     private String adresse; 
      private String sepecialite; 
       private String tel; 

    public medecin(String nom, String prenom, String adresse, String sepecialite, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.sepecialite = sepecialite;
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

    public String getSepecialite() {
        return sepecialite;
    }

    public String getTel() {
        return tel;
    }
       
}
