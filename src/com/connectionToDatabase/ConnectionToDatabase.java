/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.connectionToDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabri
 */
public class ConnectionToDatabase {
    private final String url = "jdbc:postgresql://localhost/GestionBancaire";
    private final String user = "postgres";
    private final String password = "248651379rfg";
    
    public Connection connect(){
        Connection connection = null;
        
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion a la base de donnees reussie");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return connection;
       
        
    }
}
