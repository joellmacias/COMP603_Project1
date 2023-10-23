/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bishop
 */
public class TranslatorDatabase 
{
    private static final String USER_NAME = "game";
    private static final String PASSWORD = "game";
    private static final String URL = "jdbc:derby:TranslatorDatabase;create=true";
    
    Connection conn;
    
    public TranslatorDatabase()
    {
        establishConnection();
        
    }
    
   /* public static void main(String[] args) 
    {
        TranslatorDatabase translatordb = new TranslatorDatabase();
        System.out.println(translatordb.getConnection());
    }
    */
    
    public void establishConnection() 
    {
        if (this.conn == null) 
        {
            try 
            {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Connection Successfully Established");
            } catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public Connection getConnection() 
    {
        return this.conn;
    }
    
    public void closeConnections() 
    {
        if (conn != null) 
        {
            try 
            {
                conn.close();
            } 
            catch (SQLException ex) 
            {
               // Logger.getLogger(TranslatorDatabase.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
}
