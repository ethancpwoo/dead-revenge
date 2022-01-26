import greenfoot.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList; 
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors 
import java.util.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * @Ethan Woo and Kenny Zhao
 * @Fall 2021
 */

public class WinWorld extends World
{
    String scoreText;
    Color gray = new Color(64, 64, 64); 
    Font titleFont = new Font("Calibri", true, false, 60);
    Font textFont = new Font("Calibri", false, false, 25);
    Button playAgain;
    Button quit; //make objects
    String score; 
    String timeBonus; 
    String finalScoreString;
    int finalScore; 
    public static int timesPlayed = 0;
    Label scoreLabel1; 
    Label scoreLabel2; 
    Label scoreLabel3; 
    Label currentHighScore;
    Label currentScore; 
    GreenfootSound bgm = new GreenfootSound("Tom Clancy's Siege (Original Game Soundtrack) _ Ben Frost - First Strike (Track 02).wav"); 
    GreenfootImage background;
    ArrayList<Integer> scores = new ArrayList<Integer>(); 
    public WinWorld()
    {    
        super(1200, 800, 1); 
        timesPlayed++; 
        background = new GreenfootImage("EndScreen.png");
        playAgain = new Button();
        quit = new Button(); //make objects
        playAgain.getImage().scale(185, 78);
        quit.getImage().scale(185, 78);
        playAgain.after.scale(185, 78);
        quit.after.scale(185, 78);
        Gear leftGear = new Gear(true); 
        Gear rightGear = new Gear(false);  
        bgm.setVolume(10); 
        bgm.playLoop(); 
        currentScore = new Label(GameWorld.finalScore, 80);
        File scoresheet = new File("highScores.txt"); 
        try
        {
            FileWriter writer = new FileWriter("highScores.txt", true); 
            
            writer.write(GameWorld.finalScore + System.lineSeparator());
       
            writer.close();
        }
        catch (IOException e) 
        {

        }
        
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(scoresheet)); 
            String score; 
            while((score = in.readLine()) != null)
            {
                scores.add(Integer.valueOf(score));   
            }
            in.close();
        }
        catch (IOException e)
        {
            
        }
        int[] finalScores = scores.stream().mapToInt(i -> i).toArray(); 
        Utilities.quickSort(finalScores); 
        Utilities.reverseArray(finalScores); 
        if(finalScores.length == 1)
        {
            scoreLabel1 = new Label(finalScores[0], 80);
            addObject(scoreLabel1, 220, 400);
        } 
        if(finalScores.length == 2)
        {
            scoreLabel1 = new Label(finalScores[0], 80);
            addObject(scoreLabel1, 220, 400);
            scoreLabel2 = new Label(finalScores[1], 80);
            addObject(scoreLabel2, 600, 400);
        }
        if(finalScores.length >= 3)
        {
            scoreLabel1 = new Label(finalScores[0], 80);
            addObject(scoreLabel1, 220, 400);
            scoreLabel2 = new Label(finalScores[1], 80);
            addObject(scoreLabel2, 600, 400);
            scoreLabel3 = new Label(finalScores[2], 80);
            addObject(scoreLabel3, 970, 400);
        }
        
       
    
        addObject(playAgain, 475, 650);
        addObject(quit, 760, 650); 
        addObject(leftGear, 0, 800);
        addObject(rightGear, 1200, 800); 
        addObject(currentScore, 600, 230);

        
        setBackground(background); //set background
    }
    
    
    
     public void act()
    {
        playAgain.getImage().scale(185, 78);
        quit.getImage().scale(185, 78);
        if(quit.touchingCursor() == true)
        {
            bgm.stop(); 
            Greenfoot.stop(); //quit
        }
        if(playAgain.touchingCursor() == true)
        {
            bgm.stop(); 
            Greenfoot.setWorld(new WelcomeWorld()); //restart back to welcome world 
        }
    }
    
    
}