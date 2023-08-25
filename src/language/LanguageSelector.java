/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

import java.util.Scanner;

/**
 *
 * @author Bishop
 */
public class LanguageSelector 
{
    Scanner scanner = new Scanner(System.in);
    int choice = scanner.nextInt();
    String translatedText;
    
// user driven text to translate or have them select from array of words
// if selecting from array of words will need need to display array then request user to select word to translate (in main)

    public static String translate(String text, int choice) 
    {
        String translatedText = "";

        switch (choice) 
        {
            case 1:
                translatedText = translateToSpanish(text);
                break;
            case 2:
                translatedText = translateToSamoan(text);
                break;
            case 3:
                translatedText = translateToMāori(text);
                break;
            default:
                translatedText = "Translation for this language is not supported.";
        }

        return translatedText;
    }
    
    public static String translateToSpanish(String text) 
    {
        // would implement the translation logic here
        // just returning the same text in this eg assuming no translation
        return "Spanish translation of: " + text;
    }
    
    public static String translateToSamoan(String text) 
    {
        // replace this with actual translation code
        return "Samoan translation of: " + text;
    }
    
    public static String translateToMāori(String text) 
    {
        // replace this with actual translation code
        return "Māori translation of: " + text;
    }
}
