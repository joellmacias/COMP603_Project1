/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author joelmacias
 */
public class LanguageAppController implements Scoreboard {

    private boolean running = true;
    private List<User> scoreboard = new ArrayList<>();

    @Override
    public void updateScore(User user) {
        if (scoreboard.contains(user)) {
            scoreboard.remove(user);
        }
        scoreboard.add(user);
        Collections.sort(scoreboard, Collections.reverseOrder());
    }

    @Override
    public void displayScoreboard() {
        System.out.println("Scoreboard:");
        for (int i = 0; i < scoreboard.size(); i++) {
            User user = scoreboard.get(i);
            System.out.println((i + 1) + ": " + user.getUsername() + " " + user.getScore());
        }
    }

    @Override
    public List<User> getTopScore(int number) {
        System.out.println("1");
        return null;
    }

    public void startApp() {

        LanguageSelector selector = new LanguageSelector();
        FileLoader loader = new FileLoader();
        User user = new User();
        User currentUser = null;
        Scanner scan = new Scanner(System.in);
        List<User> userList = new ArrayList();
        List<VocabularyItem> languageVocabList = new ArrayList();
        userList = loader.loadUsersFromFile("./resources/users.txt");
        scoreboard = loader.loadUsersFromFile("./resources/scoreboard.txt");
        Language language = null;

        System.out.println("Welcome to Language Vocabulary Application! Type x at any time to exit.");
        System.out.println("What is your name?");
        String name = scan.nextLine().trim();
        if ("x".equalsIgnoreCase(name)) {
            stopApp();
            return;
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
        while (running) {
            language = selector.selectLanguage();
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
            while (true) {
                System.out.println("Would you like to practice with Flashcards or take a Quiz? (f/q/x/s to exit, g to go back)");
                String userChoice = scan.nextLine().trim();
                if ("x".equalsIgnoreCase(userChoice)) {
                    stopApp();
                    return;
                } else if ("f".equalsIgnoreCase(userChoice)) {
                    Flashcards flashcards = new Flashcards(language, currentUser);
                    flashcards.getLanguage();
                    flashcards.startMode();

                } else if ("s".equalsIgnoreCase(userChoice)) {
                   displayScoreboard();
                } else if ("q".equalsIgnoreCase(userChoice)) {
                    Quiz quiz = new Quiz(language, currentUser, 20);
                    quiz.startMode();
                    updateScore(user);
                    loader.addUserToFile(currentUser, "./resources/users.txt");
                } else if ("g".equalsIgnoreCase(userChoice)) {
                    break;
                } else {
                    System.out.println("Invalid input, please try again");
                }
            }
        }
    }

    public void stopApp() {
        this.running = false;
        System.out.println("Program ended.");
    }
}
