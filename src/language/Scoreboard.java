/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

import java.util.List;

/**
 *
 * @author joelmacias
 */
public interface Scoreboard {
    public void updateScore(User user);
    public void displayScoreboard(int number);
    public List<User> getTopScore(int number);
}
