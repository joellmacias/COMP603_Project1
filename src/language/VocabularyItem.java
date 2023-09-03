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

    public VocabularyItem() {

    }
    
    //Vocabulary item constructor
    public VocabularyItem(String word, String translation) {
        setWord(word);
        setTranslation(translation);
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

}
