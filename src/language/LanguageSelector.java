/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

import java.util.Scanner;

/**
 *
 * @author joellmacias
 */
public class LanguageSelector {

    public Language selectLanguage() {
        Scanner scan = new Scanner(System.in);
        String input;
        Language language = null;
        System.out.println("Available Languages:");
        System.out.println("1: Spanish 2: Maori 3: Samoan (x to exit)");
        input = scan.nextLine();
        switch (input.toLowerCase()) {
            case "1": {
                language = new Language("Spanish", "./resources/spanish.txt");
                break;
            }
            case "2": {
                language = new Language("Maori", "./resources/maori.txt");
                break;
            }
            case "3": {
                language = new Language("Samoan", "./resources/samoan.txt");
                break;
            }
            case "x": {
                language = null;
                break;
            }
            default: {
                System.out.println("Invalid selection. Please choose an available language.");
                return selectLanguage();
            }
        }

        return language;
    }

}
