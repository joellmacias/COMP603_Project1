/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author joelmacias
 */
public class LanguageAppController implements Scoreboard {

    private boolean running = true;

    @Override
    public void updateScore(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void displayScoreboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> getTopScore(int number) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void startApp() {

        LanguageSelector selector = new LanguageSelector();
        FileLoader loader = new FileLoader();
        User user = new User();
        User currentUser = null;
        Scanner scan = new Scanner(System.in);
        List<User> userList = new ArrayList();
        List<VocabularyItem> languageVocabList = new ArrayList();
        userList = loader.loadUsersFromFile("users.txt");

        while (running) {
            System.out.println("Welcome to Language Vocabulary Application! Type x at any time to exit.");
            System.out.println("What is your name?");
            String name = scan.nextLine().trim();
            if ("x".equalsIgnoreCase(name)) {
                stopApp();
                break;
            }
            for (User existingUser : userList) {
                if (existingUser.getUsername().equalsIgnoreCase(name)) {
                    currentUser = existingUser;
                    System.out.println("Hello " + name + "! Welcome back. Your highest score is " + currentUser.getScore());
                }
            }
            if (currentUser == null) {
                currentUser = new User(name);
                System.out.println("Hello " + name + "! We are thrilled to have you for the first time!");

            }
            
            Language language = selector.selectLanguage();
            if (language == null) {
                stopApp();
                break;
            }
            languageVocabList = loader.loadLanguageFromFile(language);
            language.setVocabularyItemList(languageVocabList);
//            for (VocabularyItem item: language.getVocabularyItemList())
//            {
//                System.out.println(item.getDifficulty());
//            } 
//          testing purposes
            while (running) {
                System.out.println("Would you like to practice with Flashcards or take a Quiz? (f/q/x to exit)");
                String userChoice = scan.nextLine().trim();
                if ("x".equalsIgnoreCase(userChoice)) {
                    stopApp();
                    break;
                } else if ("f".equalsIgnoreCase(userChoice)) {
                    Flashcards flashcards = new Flashcards(language, currentUser);
                    flashcards.startMode();
                    break;
                } else if ("q".equalsIgnoreCase(userChoice)) {
                    Quiz quiz = new Quiz(language, currentUser);
                    quiz.startMode();
                    break;
                } else {
                    System.out.println("Invalid input, please try again");
                }
            }
            break;
        }
    }

    public void stopApp() {
        this.running = false;
        System.out.println("Program ended.");
    }
}
