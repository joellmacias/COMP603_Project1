/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joelmacias
 */
public class FileLoader {

    public List<VocabularyItem> loadLanguageFromFile(Language language) {
        ArrayList<VocabularyItem> languageVocabList = new ArrayList<VocabularyItem>();
        try {
            BufferedReader inStream = new BufferedReader(new FileReader(language.getFilePath()));
            String line;
            while ((line = inStream.readLine()) != null) {
                String[] split = line.split(" ", 3);
                String word = split[0];
                String translation = split[1];
                int difficulty = Integer.parseInt(split[2]);
                languageVocabList.add(new VocabularyItem(word, translation, difficulty));
            }
            inStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());
        }

        return languageVocabList;
    }

    public void addUserToFile(User user, String filePath)
    {
        try
        {
            ArrayList<User> list = generateUser();
            boolean isUserFound = false;
            
            for (User j : list)
            {
                if (j.getUsername().equals(currentUser.getUsername()))
                {
                    isUserFound = true;
                    j.setScore(currentUser.getScore());
                }
            }
            if (!isUserFound)
            {
                list.add(currentUser);
            }
            
            BufferedWriter outStream = new BufferedWriter(new FileWriter("C://Users//Bishop//Downloads//PDC_Tutorials//resources//T04_users.txt"));
            
            for (User j : list)
            {
                outStream.write(j.getUsername() + " " + j.getScore());
                outStream.newLine();
            }
            outStream.close();
        }
        catch (IOException ex)
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> loadUsersFromFile(String filePath) {
        ArrayList<User> userList = new ArrayList<User>();
        try {
            BufferedReader inStream = new BufferedReader(new FileReader("./resources/users.txt"));
            String line;
            while ((line = inStream.readLine()) != null) {
                String[] split = line.split(" ", 2);
                String name = split[0];
                int score = Integer.parseInt(split[1]);
                userList.add(new User(name, score));
            }
            inStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());
        }

        return userList;
    }

    public List<User> loadScoreboardFromFile(String filePath) {
        return null;
    }

    public void addScoreboardToFile(List<User> users, String filePath) {

    }
    
    
}
