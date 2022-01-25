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
    Button leaderboards; 
    String score; 
    String timeBonus; 
    String finalScore; 
    public WinWorld()
    {    
        super(1200, 800, 1); 
        score = String.valueOf(GameWorld.score); 
        timeBonus = String.valueOf((GameWorld.seconds / 10) * 100); 
        finalScore = String.valueOf(((GameWorld.seconds / 10) * 100) + GameWorld.score); 
        GreenfootImage background = new GreenfootImage("EndScreen.png");
        playAgain = new Button();
        quit = new Button(); //make objects
        leaderboards = new Button();
        /*
        background.setColor(gray);  
        background.fill();  //pure beige background
        background.setFont(titleFont); 
        background.setColor(Color.BLACK); 
        background.drawRect(100, 100, 1000, 600);
        background.setColor(Color.WHITE); 
        background.fillRect(101, 101, 999, 599);
        background.setColor(Color.BLACK); //white rectangle with black outline
        background.drawString("Game Over!", 450, 180);
        background.drawString("Score", 530, 250);
        background.drawString(score + " (Initial Score)", 530, 310);
        background.drawString("+", 480, 340);
        background.drawString(timeBonus + " (Time Bonus)", 530, 380);
        background.drawString("------------------", 530, 450);
        background.drawString(finalScore + " (Final Score)", 530, 490);
        background.drawString("Play Again", 820, 580); 
        background.drawString("Quit", 200, 580); 
        background.drawString("Leaderboards", 440, 580);*/ 
        addObject(playAgain, 950, 650);
        addObject(quit, 250, 650); 
        addObject(leaderboards, 600, 650);
        setBackground(background); //set background
        //background.drawImage(score, 525, 300); //draw the high score and current score
    }
    //
    public int getScore()
    {
      return 0;   
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
        if(leaderboards.touchingCursor() == true)
        {
            Greenfoot.setWorld(new Leaderboards()); //restart back to welcome world 
        }
    }
    
}