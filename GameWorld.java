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
    
    GreenfootImage grey = new GreenfootImage(MapWorld.mapChoice); 
    public static int nCurrentZombies, nZombies; 
    private Scroller Scroller = null; 
    Actor scrollActor; 
    public static ArrayList<Actor> moving = new ArrayList<Actor>(); 
    int[] positionX = {0, 500,1000,1500, 2000, 2500, 3000, 3500, 4000}; 
    int[] positionY = {0, 4000};

    
    //HUD CLASSES
    HUDsprintBar sprintHud = new HUDsprintBar();
    HUDHealthBar healthHud = new HUDHealthBar();
    HUDAmmoCounterTotal totalAmmo = new HUDAmmoCounterTotal(8, 100); 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        super(1200, 800, 1, false); 
        Scroller = new Scroller(this, grey, grey.getWidth(), grey.getHeight()); 
        scrollActor = new survivorHandgun(); 
        addObject(scrollActor, grey.getWidth()/2, grey.getHeight()/2);
        moving.add(scrollActor); 
        scroll(); 
        spawnPowerUp(); 
        nZombies = 5;
        nCurrentZombies = 5; 
        zombieSpawn(nZombies); 
        
        
        //HUD ELEMENTS
        addObject(sprintHud,80, 50); 
        addObject(healthHud, 80,30); 
        addObject(totalAmmo, 200, 300); 
        //Ammo Labels 
        //Label AmmoCounterMagazine = new Label(3, 80); 
        //addObject(AmmoCounterMagazine, 50, 50); 
        
        //AmmoCounterTotal = new Label(0, 80); 
        //addObject(AmmoCounterTotal, 150, 50); 
        //start the waves here and continue through those methods
    }
    
    public void act()
    {
        if(scrollActor != null)
        {
            scroll(); 
        }
        if(startingSurvivor.health <= 0)
        {
            Greenfoot.setWorld(new WinWorld()); 
        }
        if(nCurrentZombies <= 0)
        {
            nZombies++;
            nCurrentZombies = nZombies; 
            zombieSpawn(nZombies); 
        }
         
    }
    private void scroll()
    {
        int loX = 550; 
        int hiX = 1200 - 550;
        int loY = 350; 
        int hiY = 800 - 350; 
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
    public void zombieSpawn(int countDown)
    { 
        if(countDown <= 0)
        {
            return; 
        }
        Zombie zombs = new Zombie(); 
        moving.add(zombs); 
        addObject(zombs, getRandom(positionX), getRandom(positionY)); 
        zombieSpawn(countDown - 1); 
    }
            
    public static int getRandom(int[] array) 
    {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    public void spawnPowerUp()
    { 
        healthUp healthUp = new healthUp(); 
        Invincible invincible = new Invincible(); 
        bigBullet bigbullet = new bigBullet(); 
        speedUp speedUp = new speedUp(); 
        fastfirerate fastfirerate = new fastfirerate(); 
        
        
 
    }
    public HUDsprintBar sprintBar()
    {
        return sprintHud; 
    }
}
