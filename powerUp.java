import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class powerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class powerUp extends Actor
{
    /**
     * Act - do whatever the powerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public powerUp()
    {
       SimpleTimer powerUpTimer = new SimpleTimer(); 
       powerUpTimer.mark(); 
    }
    public void act() 
    {
        // Add your action code here.
    } 
    public void spawnRandom()
    {
        getWorld().addObject(this, Greenfoot.getRandomNumber(3800) + 100, Greenfoot.getRandomNumber(3800) + 100);
    }
}
