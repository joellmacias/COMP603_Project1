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
                String[] split = line.split(" ", 2);
                String word = split[0];
                String translation = split[1];
                languageVocabList.add(new VocabularyItem(word, translation));
            }
            inStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());
        }

        return languageVocabList;
    }

    public void addUserToFile(User currentUser, String filePath) {
        try {
            ArrayList<User> userList = loadUsersFromFile(filePath);
            boolean isUserFound = false;

            for (User existingUser : userList) {
                if (existingUser.getUsername().equals(currentUser.getUsername())) {
                    isUserFound = true;
                    existingUser.setScore(currentUser.getScore());
                }
            }
            if (!isUserFound) {
                userList.add(currentUser);
            }

            BufferedWriter outStream = new BufferedWriter(new FileWriter(filePath));

            for (User user : userList) {
                outStream.write(user.getUsername() + " " + user.getScore());
                outStream.newLine();
            }
            outStream.close();
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<User> loadUsersFromFile(String filePath) {
        ArrayList<User> userList = new ArrayList<User>();
        try {
            BufferedReader inStream = new BufferedReader(new FileReader(filePath));
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

    public void addScoreboardToFile(List<User> users, String filePath) {
        try {
            List<User> userList = users;
           
            BufferedWriter outStream = new BufferedWriter(new FileWriter(filePath));

            for (User user : userList) {
                outStream.write(user.getUsername() + " " + user.getScore());
                outStream.newLine();
            }
            outStream.close();
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
