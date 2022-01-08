import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; 
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    GreenfootImage grey = new GreenfootImage("grey.png"); 
    public static int nZombies; 
    private Scroller Scroller = null; 
    Actor scrollActor; 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        super(1200, 800, 1, false); 
        Scroller = new Scroller(this, grey, grey.getWidth(), grey.getHeight()); 
        scrollActor = new survivorIdleKnife(); 
        addObject(scrollActor, grey.getWidth()/2, grey.getHeight()/2); 
        scroll(); 
        wave1(); 
        //start the waves here and continue through those methods
    }
    public void act()
    {
        if(scrollActor != null)
        {
            scroll(); 
        }
        if(nZombies <= 0)
            {
                wave2(); 
            }
    }
    private void scroll()
    {
        int loX = 100; 
        int hiX = 1200 - 100;
        int loY = 100; 
        int hiY = 800 - 100; 
        int dsx = 0;
        int dsy = 0;
        if(scrollActor.getX() < loX)
        {
            dsx = scrollActor.getX() - loX; 
        }
        if(scrollActor.getX() > hiX)
        {
            dsx = scrollActor.getX() - hiX; 
        }
        if(scrollActor.getY() < loY)
        {
            dsy = scrollActor.getY() - loY;
        }
        if(scrollActor.getY() > hiY)
        {
            dsy = scrollActor.getY() - hiY; 
        }
        Scroller.scroll(dsx, dsy); 
    }
    public void wave1()
    {
        int[] positionX = {0, 500, 1000,1500}; 
        int[] positionY = {0, 1000}; 
        nZombies = 3;
        for(int i = 0; i < 4; i++)
        {
            Zombie zombs = new Zombie(); 
            addObject(zombs, getRandom(positionX), getRandom(positionY));  
        }
        //im guessing that it doesnt run after the for loop is done... so maybe we have to put this inside of another class? Or make a seperate variable for each wave
            
    }
    public void wave2()
    {
        int[] positionX = {0, 500, 1000,1500}; 
        int[] positionY = {0, 1000}; 
        nZombies = 5; 
        for(int i = 0; i < 6; i++)
        {
            Zombie zombs = new Zombie(); 
            addObject(zombs, getRandom(positionX), getRandom(positionY)); 
        }
        if(nZombies == 0)
        {
             //wave2(); 
        }
    }
    public static int getRandom(int[] array) 
    {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
