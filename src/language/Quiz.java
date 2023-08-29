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
public class Quiz extends LanguageMode {

    private Language language;
    private User user;

    public Quiz(Language language, User user) {
        super(language, user);
    }

    public List<VocabularyItem> generateMultipleChoices(VocabularyItem answer) {
        List<VocabularyItem> choices = new ArrayList<>();

        VocabularyItem one = getRandomVocabularyItem();
        VocabularyItem two = getRandomVocabularyItem();
        VocabularyItem three = getRandomVocabularyItem();

        choices.add(answer);
        choices.add(one);
        choices.add(two);
        choices.add(three);

        Collections.shuffle(choices);

        return choices;
    }

    @Override
    public void startMode() {
        displayInstructions();
        Scanner scan = new Scanner(System.in);
        int score = 0;
        for (int i = 1; i <= 20; i++) {
            VocabularyItem answer = getRandomVocabularyItem();
            List<VocabularyItem> choices = generateMultipleChoices(answer);

            while (true) {
                System.out.println("Question " + i + ": What is the translation of " + answer.getWord() + "?");
                for (int j = 0; j < choices.size(); j++) {
                    System.out.println((j + 1) + ": " + choices.get(j).getTranslation());
                }

                String userChoice = scan.nextLine();

                if ("x".equalsIgnoreCase(userChoice)) {
                    break;
                }
                try {

                    int userChoiceInt = Integer.parseInt(userChoice);
                    if (userChoiceInt <= choices.size() && userChoiceInt > 0) {
                        if (choices.get(userChoiceInt - 1).getWord().equalsIgnoreCase(answer.getWord())) {
                            System.out.println("Correct!\n");
                            score++;
                            break;
                        } else {
                            System.out.println("Incorrect. The correct answer was " + answer.getTranslation() + " .");
                            break;
                        }
                    } else {
                        System.out.println("Invalid number. Please enter a number between 1 to 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number or press x.");
                }
            }
        }
        System.out.println("Your score was: " + score + "/20. Thanks for playing!");
        
        if(user.getScore() < score)
        {
            user.setScore(score);
            System.out.println("Your previous highscore was "+user.getScore()+"!");
        }
    }

    @Override
    public void endMode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void displayInstructions() {
        System.out.println("Quiz mode:");
        System.out.println("1: You will see a word in English.");
        System.out.println("2: You will select the correct translation in " + getLanguage().getName() + " from the multiple-choice options.");
        System.out.println("3: Your score will be calculated based on your answers.");
        System.out.println("4: There are 20 questions in total, good luck!\n");
    }
}
