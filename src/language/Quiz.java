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
    private int questions;

    //Quiz constructor using super taking in the language, currentuser and the number
    // of questions the quiz will have
    public Quiz(Language language, User user, int questions) {
        super(language, user);
        setQuestions(questions);
    }

    public void setQuestions(int questions) {
        this.questions = questions;
    }

    //Generates multiple choice questions using the abstract method
    // getRandomVocabularyItem and then checks using a loop if each choice
    // is unique
    public List<VocabularyItem> generateMultipleChoices(VocabularyItem answer) {
        List<VocabularyItem> choices = new ArrayList<>();
        choices.add(answer);

        while (choices.size() < 4) {
            VocabularyItem randomVocab = getRandomVocabularyItem();
            boolean unique = true;
            for (VocabularyItem existingChoice : choices) {
                if (existingChoice.getWord().equalsIgnoreCase(randomVocab.getWord())) {
                    unique = false;
                    break;
                }
            }

            if (unique) {
                choices.add(randomVocab);
            }

        }
        Collections.shuffle(choices);
        return choices;
    }

    @Override
    public void startMode() {
        displayInstructions();
        Scanner scan = new Scanner(System.in);
        int score = 0;
        //Each iteration is one question, generating new choices and each answer
        // every time, 
        for (int i = 1; i <= questions; i++) {
            VocabularyItem answer = getRandomVocabularyItem();
            List<VocabularyItem> choices = generateMultipleChoices(answer);
            
            //Asks the question and presents the multiple choice questions
            while (true) {
                System.out.println("\nQuestion " + i + ": What is the translation of " + answer.getWord() + "?");
                for (int j = 0; j < choices.size(); j++) {
                    System.out.println((j + 1) + ": " + choices.get(j).getTranslation());
                }

                String userChoice = scan.nextLine();

                if ("x".equalsIgnoreCase(userChoice)) {
                    endMode();
                    return;
                }
                try {
                    //checks if the answer is correct and if not presents the
                    //correct answer
                    int userChoiceInt = Integer.parseInt(userChoice);
                    if (userChoiceInt <= choices.size() && userChoiceInt > 0) {
                        if (choices.get(userChoiceInt - 1).getWord().equalsIgnoreCase(answer.getWord())) {
                            System.out.println("Correct!");
                            score++;
                            break;
                        } else {
                            System.out.println("Incorrect. The correct answer was " + answer.getTranslation() + ".");
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
        //Prints the score and then checks if the score needs to be saved
        System.out.println("Your score was: " + score + "/20. Thanks for playing!");

        if (getUser().getScore() == 0) {
            getUser().setScore(score);
            System.out.println("Your first highscore is " + score + "!");

        } else if (getUser().getScore() < score) {
            System.out.println("Congratulations! You have set a new highscore of " + score + "!");
            getUser().setScore(score);

        } else {
            System.out.println("Your best highscore is " + getUser().getScore() + "!");
        }
        endMode();
    }

    //Display instructions for the quiz
    @Override
    public void displayInstructions() {
        System.out.println("\nQuiz mode:");
        System.out.println("1: You will see a word in English.");
        System.out.println("2: You will select the correct translation in " + getLanguage().getName() + " from the multiple-choice options.");
        System.out.println("3: Your score will be calculated based on your answers.");
        System.out.println("4: Press x at any time to go back to menu. ");
        System.out.println("5: There are 20 questions in total, good luck!\n");
    }
}
