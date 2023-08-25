/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author joelmacias
 */
public class LanguageAppController implements Scoreboard {

    private boolean running = true;
     
    @Override
    public void updateScore(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void displayScoreboard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<User> getTopScore(int number) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void startApp() {
        
        LanguageSelector selector = new LanguageSelector();
        FileLoader loader = new FileLoader();
        User user = new User();
        Scanner scan = new Scanner(System.in);
        List<User> UserList = new ArrayList();
       
        UserList = loader.loadUsersFromFile("users.txt");
        
        while (running)
        {
        System.out.println("Welcome to Language Vocabulary Application! Type x at any time to exit.");
        System.out.println("What is your name?");
        String name = scan.nextLine().trim();
        if ("x".equalsIgnoreCase(name))
        {
            stopApp();
            break;
        }
        Language language = selector.selectLanguage();
        if (language == null)
        {
            stopApp();
            break;
        }
        
        System.out.println(language.getName());
        break;
        }
    }
    
   public void stopApp()
   {
       this.running = false;
       System.out.println("Program ended.");
   }
}
