/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

import java.util.Random;

/**
 *
 * @author joelmacias
 */
public abstract class LanguageMode {

    private Language language;

    public LanguageMode(Language language) {
        this.language = language;
    }

    public VocabularyItem getRandomVocabularyItem() {
        Random random = new Random();
        int randomIndex = random.nextInt(language.getVocabularyItemList().size());
        return language.getVocabularyItemList().get(randomIndex);
    }

    public abstract void startMode();

    public abstract void endMode();

    public abstract void displayInstructions();
}
