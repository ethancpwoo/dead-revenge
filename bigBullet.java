import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bigBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bigBullet extends powerUp
{
    public bigBullet()
    {
        super(); 
        GreenfootImage health = new GreenfootImage("largebullet.png");
        health.scale(50, 50);
        setImage(health); 
         
    }
    public void act() 
    {
        if(this.isTouching(startingSurvivor.class))
        {
            GameWorld.moving.remove(this); 
            getWorld().removeObject(this); 
        }
    }    
}
