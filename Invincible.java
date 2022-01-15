import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Invincible here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Invincible extends powerUp
{
    public Invincible()
    {
        super(); 
        GreenfootImage health = new GreenfootImage("satr.png");
        health.scale(50, 50);
        setImage(health); 
         
    }
    public void act() 
    {
        if(this.isTouching(startingSurvivor.class))
        {
            getWorld().removeObject(this); 
        }
    }     
}
