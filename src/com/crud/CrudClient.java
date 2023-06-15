/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud;

import com.connectionToDatabase.ConnectionToDatabase;
import java.beans.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class CrudClient {
    
    ConnectionToDatabase connection = new ConnectionToDatabase();
    
    
///////////////////**********GenererId*********///////////
      public String Gerer(){
          
        Statement stat = null;
        ResultSet res = null;
        String StrMax;
        String id = null;
        int max = 0;
        try{
            connection.connect();
            
            PreparedStatement prp = connection.connect().prepareStatement("SELECT COUNT(numerocompte) FROM client;");
            res = prp.executeQuery();
            
            if (res.next()){
                
                int count = res.getInt(1);
                
               
                if(count !=0){
                    PreparedStatement req= connection.connect().prepareStatement("SELECT numerocompte FROM client");
                    res = req.executeQuery();
                    while(res.next()){
                        String Valeur = res.getString("numerocompte");
                        GenererId gerId = new GenererId();
                        gerId.GenererId(Valeur);
                        int PartInt = gerId.num;
                       
                        if (max<PartInt){
                            max=PartInt;
                        }
                    }
                
                }
           
            }
      
            max +=1;
            StrMax = String.valueOf(max);
            id ="CL"+StrMax;
            System.out.println("Ato mety e");
      }
      catch(SQLException ex)
              {
                  ex.getMessage();
                  System.out.println( "Ato le bleme");
              }
      
       return id;
    }
      
    ////////////////////***************GenenrerId********************////////////////
    
    public void ajoutClient( String nom, String prenoms,String telephone, String mail){
        
         connection.connect();
        String idClient = Gerer();
        
       
        String requeteAjoutClient = "INSERT INTO client(numerocompte, nom, prenoms, telephone, mail) VALUES (?,?,?,?,?);";
        
        try(PreparedStatement statement = connection.connect().prepareStatement(requeteAjoutClient)){
                statement.setString(1, idClient);
                statement.setString(2,nom);
                statement.setString(3,prenoms);
                statement.setString(4,telephone);
                statement.setString(5,mail);
                
                statement.executeUpdate();
                System.out.println("Ato zao mety");
                
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Ato tsy mety e");
        }
        
        
        
    }
    public List<DonneesListeClient> affichageClient(){
        connection.connect();
        //Création d'une liste de type DonneesListeClient
        List<DonneesListeClient> clients = new ArrayList<>();
        
        String requeteAffichage = "SELECT * FROM client";
        
        try(PreparedStatement statement = connection.connect().prepareStatement(requeteAffichage)){
            ResultSet resultat = statement.executeQuery();
            System.out.println("Tafa e");
            while(resultat.next()){
                
                System.out.println( "Ato anaty liste LE");
                String numeroCompte = resultat.getString("numerocompte");
                String nom = resultat.getString("nom");
                String prenoms = resultat.getString("prenoms");
                String telephone = resultat.getString("telephone");
                String mail = resultat.getString("mail");
                
                //Creation de l'objet client à partir des données récupérées
                DonneesListeClient client = new DonneesListeClient(numeroCompte, nom, prenoms, telephone, mail);
                clients.add(client);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage() + "Ato anaty liste");
            System.out.println("tsy tafa ndray");
        }
        return clients;
    }
    
    
    public void modifierClient(){
       
        /*
       connection.connect();
       
       String requeteModifier = "UPDATE client SET nom =? prenoms=? telephone = ? mail= ? WHERE numeroCompte = ?";
       
       try(PreparedStatement statement = connection.connect().prepareStatement(requeteModifier)){
           
           
           
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       
*/
        
    }
    public void supprimerClient(){
        
        
        
    }
    
    
    
}
