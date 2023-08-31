/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

import java.util.Scanner;

/**
 *
 *
 * @author joelmacias
 */
public class Flashcards extends LanguageMode {

    private Language language;
    private User user;

    public Flashcards(Language language, User user) {
        super(language, user);
    }

    @Override
    public void startMode() {
        displayInstructions();
        Scanner scan = new Scanner(System.in);

        while (true) {
            VocabularyItem answer = getRandomVocabularyItem();

            System.out.println("\nTranslate: \"" + answer.getWord() + "\" in " + getLanguage().getName() + " or press 'r' to reveal and skip (x to quit).");

            String userInput = scan.nextLine();

            if ("x".equalsIgnoreCase(userInput)) {
                System.out.println("Goodbye!");
                endMode();
                break;
            } else if (userInput.equalsIgnoreCase("r")) {
                System.out.println("Answer: " + answer.getTranslation());
            } else if (userInput.equalsIgnoreCase(answer.getTranslation())) {
                System.out.println("Correct!");
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    @Override
    public void displayInstructions() {
        System.out.println("\nFlashcards:");
        System.out.println("1. An English word will be presented");
        System.out.println("2. Translate the word in " + getLanguage().getName() + " and then press r to reveal the answer.");
        System.out.println("3. Flashcards will continue until you quit. Good luck!");
    }

}
