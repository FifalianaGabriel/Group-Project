/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud;
import com.connectionToDatabase.ConnectionToDatabase;
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
    

    
    
    public void ajoutClient(String nom, String prenoms,String telephone, String mail){
        
         connection.connect();
        
        
        String requeteAjoutClient = "INSERT INTO client(nom,prenoms,telephone,mail) VALUES (?,?,?,?);";
        
        try(PreparedStatement statement = connection.connect().prepareStatement(requeteAjoutClient)){
                statement.setString(1,nom);
                statement.setString(2,prenoms);
                statement.setString(3,telephone);
                statement.setString(4,mail);
                
                statement.executeUpdate();
                
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        
        
    }
    public List<DonneesListeClient> affichageClient(){
        connection.connect();
        //Création d'une liste de type DonneesListeClient
        List<DonneesListeClient> clients = new ArrayList<>();
        
        String requeteAffichage = "SELECT * FROM client";
        
        try(PreparedStatement statement = connection.connect().prepareStatement(requeteAffichage)){
            ResultSet resultat = statement.executeQuery();
            
            while(resultat.next()){
                int numeroCompte = resultat.getInt("numeroCompte");
                String nom = resultat.getString("nom");
                String prenoms = resultat.getString("prenoms");
                String telephone = resultat.getString("telephone");
                String mail = resultat.getString("mail");
                
                //Creation de l'objet client à partir des données récupérées
                DonneesListeClient client = new DonneesListeClient(numeroCompte, nom, prenoms, telephone, mail);
                clients.add(client);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return clients;
    }
    
    
    public void modifierClient(){
       
       
       
        
    }
    public void supprimerClient(){
        
        
        
    }
    
}
