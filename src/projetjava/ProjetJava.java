/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetjava;
import com.connectionToDatabase.ConnectionToDatabase;
import com.crud.*;
import com.design.*;
import com.crud.GenererId;

/**
 *
 * @author Hyacinthe
 */
public class ProjetJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        ConnectionToDatabase connection = new ConnectionToDatabase();
        connection.connect();
        
        GenererId db = new GenererId();
        //db.GenererId("FR002");
        //System.out.println(db.prefixe);
        //System.out.println(db.num);
        
        
    }
    
}
