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

    private static final String USER_NAME = "game";
    private static final String PASSWORD = "game";
    private static final String URL = "jdbc:derby:TranslatorDatabase;create=true";

    Connection conn;

    public TranslatorDatabase() {
        establishConnection();
        createLanguageTable();
        createUserTable();
    }

    public static void main(String[] args) {
        TranslatorDatabase translatorDB = new TranslatorDatabase();
        System.out.println(translatorDB.getConnection());

    }

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

    public Connection getConnection() {
        return this.conn;
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TranslatorDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

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

    public void createUserTable() {
        try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {
            try (Statement statement = conn.createStatement()) {
                String createTableSQL = "CREATE TABLE USERS("
                        + "NAME VARCHAR(15) NOT NULL, "
                        + "SCORE VARCHAR(2) NOT NULL"
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

    public void updateDatabase(String sql) {
        Connection connection = this.conn;
        Statement statement;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(String name, int score) {
        try {
            String selectSQL = "SELECT * FROM USERS WHERE NAME = '" + name
                    + "' AND SCORE = '" + score
                    + "'";

            ResultSet resultSet = Querry(selectSQL);

            if (resultSet.next()) {
                String updateSQL = "UPDATE USERS SCORE = '" + score
                        + "'WHERE NAME = '" + name
                        + "'AND SCORE = '" + score
                        + "'";

                updateDatabase(updateSQL);

                System.out.println("User data successfully updated.");
            } else {
                String insertSQL = "INSERT INTO USERS (NAME, SCORE) VALUES ('"
                        + name + "', " + score
                        + ")";

                updateDatabase(insertSQL);

                System.out.println("User created, data successfully inserted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet Querry(String sql) {
        Connection connection = this.conn;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public List<VocabularyItem> loadLanguageFromDatabase(Language language) {
        ArrayList<VocabularyItem> languageVocabList = new ArrayList<VocabularyItem>();
        try {
            Connection connection = this.conn;
            Statement statement = conn.createStatement();
            String query = "SELECT ENGLISHWORD, TRANSLATEDWORD FROM "+language.getName();
            ResultSet resultSet = statement.executeQuery(query); 

            while (resultSet.next()) {
                String word = resultSet.getString("ENGLISHWORD");
                String translation = resultSet.getString("TRANSLATEDWORD");
                languageVocabList.add(new VocabularyItem(word, translation));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return languageVocabList;
    }
}
