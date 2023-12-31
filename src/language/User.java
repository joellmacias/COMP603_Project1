/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package language;

/**
 *
 * @author joelmacias
 */
public class User implements Comparable<User>{
    private String username;
    private int score;
    
    public User(){
        
    }
    
    //user constructor taking only the username as a parameter
    public User(String username)
    {
        setUsername(username);
        setScore(0);
    }
    //user constructor, taking in an int parameter
    public User(String username, int score)
    {
        setUsername(username);
        setScore(score);
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    
    public int getScore()
    {
        return this.score;
    }
    
    //increaes the score by a value of int
    public void increaseScore(int value)
    {
        if (score > 0)
        {
        this.score+=value;
        }
    }

    //compare function for integer using score to see which is higher
    @Override
    public int compareTo(User other) {
        return Integer.compare(this.score, other.score);
    }
            
}
