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
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bishop
 */
public class TranslatorDatabase {
    //Database created inside assignment directory
    //Username, Password and URL allow us to access the database.
    private static final String USER_NAME = "game";
    private static final String PASSWORD = "game";
    private static final String URL = "jdbc:derby:TranslatorDatabase;create=true";
    Connection conn;
    
    //Default constructor establishes the connection and creates the database tables.
    public TranslatorDatabase() {
        establishConnection();
        createLanguageTable();
        createUserTable();
    }

    //Establishes connection method
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Connection Successfully Established");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    //Return method which returns the conenction
    public Connection getConnection() {
        return this.conn;
    }

    //Closes connections method
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TranslatorDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Creates language tables inside the database storing english and translated words
    //If table does not exist creates it, if it does prints a friendly message.
    public void createLanguageTable() {
        try (Statement statement = conn.createStatement()) {
            String createTableSpannish = "CREATE TABLE SPANNISH("
                    + "ENGLISHWORD VARCHAR(20) NOT NULL,"
                    + "TRANSLATEDWORD VARCHAR(20) NOT NULL"
                    + ")";
            statement.executeUpdate(createTableSpannish);

            String createTableSamoan = "CREATE TABLE SAMOAN("
                    + "ENGLISHWORD VARCHAR(20) NOT NULL,"
                    + "TRANSLATEDWORD VARCHAR(20) NOT NULL"
                    + ")";
            statement.executeUpdate(createTableSamoan);

            String createTableMaori = "CREATE TABLE MAORI("
                    + "ENGLISHWORD VARCHAR(20) NOT NULL,"
                    + "TRANSLATEDWORD VARCHAR(20) NOT NULL"
                    + ")";
            statement.executeUpdate(createTableMaori);

            System.out.println("Languages Successfully Loaded");
            statement.close();
        } catch (SQLException e) {
            if (e.getSQLState().equals("X0Y32")) {
                System.out.println("Table already exists");
            } else {
                e.printStackTrace();
            }
        }
    }

    //Creates user tables inside the database storing name and score.
    //If table does not exist creates it, if it does prints a friendly message.
    public void createUserTable() {
        try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {
            try (Statement statement = conn.createStatement()) {
                String createTableSQL = "CREATE TABLE USERS("
                        + "NAME VARCHAR(15) NOT NULL, "
                        + "SCORE INT NOT NULL"
                        + ")";
                statement.executeUpdate(createTableSQL);
                System.out.println("User Table successfully created");
            }
        } catch (SQLException e) {
            if (e.getSQLState().equals("X0Y32")) {
                System.out.println("Table already exists");
            } else {
                e.printStackTrace();
            }
        }
    }

    //Updates the database
    public void updateDatabase(String sql) 
    {
        Connection connection = this.conn;
        Statement statement;

        try 
        {
            if (sql != null && !sql.isEmpty())
            {
                statement = connection.createStatement();
                statement.executeUpdate(sql);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    //Checks if the user already exists in the database
    //if they exist, updates the database
    //if not they are created and inserted into database
    public void updateUser(String name, int score) 
    {
        try 
        {
            String selectSQL = "SELECT * FROM USERS WHERE NAME = '" + name + "'";
            ResultSet resultSet = Querry(selectSQL);
            
            if (resultSet.next())
            {
                String updateSQL = "UPDATE USERS SET SCORE = " + score + " WHERE NAME = '" + name + "'";
                updateDatabase(updateSQL);
                System.out.println("User data successfully updated.");
            }
            else
            {
                String insertSQL = "INSERT INTO USERS (NAME, SCORE) VALUES ('" + name + "', " + score + ")";
                updateDatabase(insertSQL);
                System.out.println("User created, data successfully inserted.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //Query method which querrys the database
    public ResultSet Querry(String sql) 
    {
     Connection connection = this.conn;
     Statement statement = null;
     ResultSet resultSet = null;

      if (sql == null || sql.isEmpty()) 
      {
         return null;
      }

      try 
      {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
      } 
      catch (Exception e) 
      {
          e.printStackTrace();
      }
      return resultSet;
    }

    //Retrieves english word and translated word from database and stores them in our list
    public List<VocabularyItem> loadLanguageFromDatabase(Language language) 
    {
       ArrayList<VocabularyItem> languageVocabList = new ArrayList<VocabularyItem>();
       try 
       {
        if (language != null) 
        {
            Connection connection = this.conn;
            String tableName = language.getName();
            String query = "SELECT ENGLISHWORD, TRANSLATEDWORD FROM " + tableName;
            try (Statement statement = connection.createStatement()) 
            {
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) 
                {
                    String word = resultSet.getString("ENGLISHWORD");
                    String translation = resultSet.getString("TRANSLATEDWORD");
                    languageVocabList.add(new VocabularyItem(word, translation));
                }
            }
        }
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    return languageVocabList;
    }

    //Retrieves name from database and orders first 10 rows of score in descending order
    public ResultSet getHighestScores()
    {
        try
        {
            Statement statement = conn.createStatement();
            String query = "SELECT NAME, SCORE FROM USERS ORDER BY SCORE DESC FETCH FIRST 10 ROWS ONLY";
            return statement.executeQuery(query);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
}
