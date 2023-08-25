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
    private String filePath;
    private List<VocabularyItem> vocabularyItemList;
    
    public Language(String name, String filePath) {
        setName(name);
        setFilePath(filePath);
        vocabularyItemList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
