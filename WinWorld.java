import greenfoot.*; 
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
    
    Label scoreLabel1; 
    Label scoreLabel2; 
    Label scoreLabel3; 
    Label currentHighScore;
    Label currentScore; 
    GreenfootSound bgm = new GreenfootSound("Tom Clancy's Siege (Original Game Soundtrack) _ Ben Frost - First Strike (Track 02).wav"); 
    GreenfootImage background;
    public WinWorld()
    {    
        super(1200, 800, 1); 
        score = String.valueOf(GameWorld.score);  
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
        //bgm.playLoop(); 
        
        //GameWorld.myInfoScore1.getScore()
        //UserInfo topUser2 = (UserInfo)GameWorld.myInfo.getTop(3).get(2);
        //currentScore = new Label(GameWorld.finalScore, 80); 
        //scoreLabel1 = new Label(GameWorld.myInfoScore1.getScore(), 80);
        //scoreLabel2 = new Label(GameWorld.myInfoScore2.getScore(), 80);
        //scoreLabel3 = new Label(GameWorld.myInfoScore3.getScore(), 80);
       
       
        //scoreLabel = new Label(GameWorld.myInfo.getTop(1).get(0).getScore(), 80);
    
        addObject(playAgain, 475, 650);
        addObject(quit, 760, 650); 
        addObject(leftGear, 0, 800);
        addObject(rightGear, 1200, 800); 
        //addObject(currentScore, 600, 230);
        //addObject(scoreLabel1, 220, 400);
        //addObject(scoreLabel2, 600, 400);
        //addObject(scoreLabel3, 970, 400);
        setBackground(background); //set background
        //background.drawImage(score, 525, 300); //draw the high score and current score
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
    
    
    //quick sort method to sort the leaderboards 
    public int partition(int[] arr, int lo, int hi) 
    {
            int i = lo; 
            int j = hi + 1;
            while (true) {
                while (arr[++i] < arr[lo])  // Find item on left to swap  
                    if (i == hi) break; 
                while (arr[--j] > arr[lo]) 
                    if (j == lo) break;
                
                if (i >= j) break;  // Check if pointers cross 
                swap(arr, i, j);  // Swap
            } 
            swap(arr, lo, j);  // Swap partitioning element  
            return j;  // Return index of item now know to be in place
    }
    
    private static void shuffle(int[] arr)
    {
        Random r = new Random();
        for(int i = arr.length - 1; i > 0; i--)
        {
            int j = r.nextInt(i+1); 
            
            swap(arr, i, j); 
        }
    }
    
    private static void swap(int[] arr, int i, int j)
    {
        int placeHolder = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = placeHolder; 
    }
    
    public void quickSort(int[] arr) 
    {
     shuffle(arr); 
     quicksort(arr, 0, arr.length - 1); 
    }
 
    private void quicksort(int[] arr, int lo, int hi) 
    {
         if (hi <= lo) return;
         int j = partition(arr, lo, hi); 
         quicksort(arr, lo, j-1); 
         quicksort(arr, j+1, hi); 
    }
}