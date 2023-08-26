/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

/**
 *
 * @author joelmacias
 */
public class VocabularyItem {

    private String word;
    private String translation;
    private int difficulty;
   
    public VocabularyItem(String word, String translation, int difficulty) {
        setWord(word);
        setTranslation(translation);
        setDifficulty(difficulty);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
