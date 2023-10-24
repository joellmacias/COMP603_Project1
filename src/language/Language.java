/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package language;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joelmacias
 */
public class Language {

    private String name;
    private List<VocabularyItem> vocabularyItemList;
    
    //Language constructor
    // change to Databse instead of filepath
    public Language(String name) {
        setName(name);
        vocabularyItemList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVocabularyItemList(List<VocabularyItem> vocabList)
    {
        this.vocabularyItemList = vocabList;
    }
            
    public List<VocabularyItem> getVocabularyItemList()
    {
        return vocabularyItemList;
    }
}
