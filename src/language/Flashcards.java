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
    private Language language;
    private User user;
    
    public Flashcards(Language language, User user)
    {   
        super(language, user);
    }
    
    @Override
    public void startMode()
    {
        while (running)
        {
            //(for loop) for selected language to repeat quesiton
            for(int attempts = 0; attempts <= 10; attempts++ )
            {
                System.out.println("Attempt: " + attempts + "Please translate " + language.getVocabularyItemList() + " in " + language.getName());
            }
        }
    }

    @Override
    public void endMode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void displayInstructions() {
        System.out.println("");  
    }
    

}
