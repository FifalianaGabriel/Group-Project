/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud;



/**
 *
 * @author gabri
 */
public class DonneesListeClient {
    
    public String numeroCompte;
    public String nom;
    public String prenoms;
    public String telephone;
    public String mail;
    
    public DonneesListeClient(String numeroCompte, String nom, String prenoms, String telephone, String mail ){
       
        this.numeroCompte = numeroCompte;
        this.nom = nom;
        this.prenoms = prenoms;
        this.telephone = telephone;
        this.mail = mail;
    }
    
    
    //Méthodes d'accès getters
    
    public String getNumeroCompte(){
        return numeroCompte;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenoms(){
        return prenoms;
    }
    public String getTelephone(){
        return telephone;
    }
    public String getMail(){
        return mail;
    }
    
    //Méthode setters
    public void setNumeroCompte( String numeroCompte){
        this.numeroCompte = numeroCompte;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPrenoms(String prenoms){
        this.prenoms = prenoms;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    
    
    
}
