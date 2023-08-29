/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

import java.util.Scanner;

/**
 *
 * @author joelmacias
 */
public class Flashcards extends LanguageMode
{
// Would you like the rules?
// diffuclty etc
    
    private boolean running = true;
    
    
    public Flashcards()
    {   
        
    }
    
    @Override
    public void startMode()
    {
        while (running)
        {
            //(for loop) for selected language to repeat quesiton
            for(int attempts = 0; attempts <= 10; attempts++ )
            {
                System.out.println("Attempt: " + attempts + "Please translate " + language.getVocabularyItemList() + " in " + selectLanguage);
            }
        }
    }
    

}
