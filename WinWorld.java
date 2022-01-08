import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
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
    public WinWorld()
    {    
        super(1200, 800, 1); 
        GreenfootImage background = new GreenfootImage(1200, 800);
        playAgain = new Button();
        quit = new Button(); //make objects
        background.setColor(gray);  
        background.fill();  //pure beige background
        background.setFont(titleFont); 
        background.setColor(Color.BLACK); 
        background.drawRect(100, 100, 1000, 600);
        background.setColor(Color.WHITE); 
        background.fillRect(101, 101, 999, 599);
        background.setColor(Color.BLACK); //white rectangle with black outline
        background.drawString("Time's Up!", 475, 250);
        addObject(playAgain, 850, 520);
        addObject(quit, 375, 520); 
        setBackground(background); //set background
        //background.drawImage(score, 525, 300); //draw the high score and current score
    }
     public void act()
    {
        if(quit.touchingCursor() == true)
        {
            Greenfoot.stop(); //quit
        }
        if(playAgain.touchingCursor() == true)
        {
            Greenfoot.setWorld(new WelcomeWorld()); //restart back to welcome world 
        }
    }
}