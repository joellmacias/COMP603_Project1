/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package language;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bishop
 */
public class TranslatorDatabaseTest {
    
    public TranslatorDatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of establishConnection method, of class TranslatorDatabase.
     */
    @Test
    public void testEstablishConnection() {
        System.out.println("establishConnection");
        TranslatorDatabase instance = new TranslatorDatabase();
        instance.establishConnection();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of closeConnections method, of class TranslatorDatabase.
     */
    @Test
    public void testCloseConnections() {
        System.out.println("closeConnections");
        TranslatorDatabase instance = new TranslatorDatabase();
        instance.closeConnections();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of createLanguageTable method, of class TranslatorDatabase.
     */
    @Test
    public void testCreateLanguageTable() {
        System.out.println("createLanguageTable");
        TranslatorDatabase instance = new TranslatorDatabase();
        instance.createLanguageTable();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of createUserTable method, of class TranslatorDatabase.
     */
    @Test
    public void testCreateUserTable() {
        System.out.println("createUserTable");
        TranslatorDatabase instance = new TranslatorDatabase();
        instance.createUserTable();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateDatabase method, of class TranslatorDatabase.
     */
    @Test
    public void testUpdateDatabase() {
        System.out.println("updateDatabase");
        String sql = "";
        TranslatorDatabase instance = new TranslatorDatabase();
        instance.updateDatabase(sql);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class TranslatorDatabase.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        String name = "Bishop";
        int score = 3;
        TranslatorDatabase instance = new TranslatorDatabase();
        instance.updateUser(name, score);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Querry method, of class TranslatorDatabase.
     */
    @Test
    public void testQuerry() {
        System.out.println("Querry");
        String sql = "";
        TranslatorDatabase instance = new TranslatorDatabase();
        ResultSet expResult = null;
        ResultSet result = instance.Querry(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadLanguageFromDatabase method, of class TranslatorDatabase.
     */
    @Test
    public void testLoadLanguageFromDatabase() {
        System.out.println("loadLanguageFromDatabase");
        Language language = new Language("SAMOAN");
        TranslatorDatabase instance = new TranslatorDatabase();
        List<VocabularyItem> result = instance.loadLanguageFromDatabase(language);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getHighestScores method, of class TranslatorDatabase.
     */
    @Test
    public void testGetHighestScores() {
        System.out.println("getHighestScores");
        TranslatorDatabase instance = new TranslatorDatabase();
        ResultSet result = instance.getHighestScores();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
