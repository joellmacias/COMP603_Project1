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

        boolean isUserFound = false;

        for (User existingUser : scoreboard) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                isUserFound = true;
                existingUser.setScore(user.getScore());
            }
        }
        if (!isUserFound) {
            scoreboard.add(user);
        }
        Collections.sort(scoreboard, Collections.reverseOrder());
    }

    @Override
    public void displayScoreboard(int number) {
        System.out.println("Top " + number + " Scoreboard:");
        List<User> topUsers = getTopScore(number);
        for (int i = 0; i < topUsers.size(); i++) {
            User user = scoreboard.get(i);
            System.out.println((i + 1) + ": " + user.getUsername() + " " + user.getScore());
        }
    }

    @Override
    public List<User> getTopScore(int number) {
        List<User> topUsers = new ArrayList();
        Collections.sort(scoreboard, Collections.reverseOrder());

        for (int i = 0; i < Math.min(number, scoreboard.size()); i++) {
            topUsers.add(scoreboard.get(i));
        }
        return topUsers;
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
                System.out.println("Hello " + name + "! Welcome back. Your highest score is " + currentUser.getScore() + ". ");
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
            while (true) {
                System.out.println("\nWould you like to practice with Flashcards, take a Quiz or view the Scoreboard? (f/q/s/x/g): x to exit, g to go back)");
                String userChoice = scan.nextLine().trim();
                if ("x".equalsIgnoreCase(userChoice)) {
                    stopApp();
                    return;
                } else if ("f".equalsIgnoreCase(userChoice)) {
                    Flashcards flashcards = new Flashcards(language, currentUser);
                    flashcards.startMode();
                } else if ("s".equalsIgnoreCase(userChoice)) {
                    displayScoreboard(10);
                } else if ("q".equalsIgnoreCase(userChoice)) {
                    Quiz quiz = new Quiz(language, currentUser, 20);
                    quiz.startMode();
                    updateScore(currentUser);
                    loader.addUserToFile(currentUser, "./resources/users.txt");
                    loader.addScoreboardToFile(scoreboard, "./resources/scoreboard.txt");
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
