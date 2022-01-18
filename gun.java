import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gun extends Actor
{
    public gun()
    {
        GreenfootImage pistol = new GreenfootImage("images/Survivor Spine/images/pistol.png"); 
        GreenfootImage rifle = new GreenfootImage("images/Survivor Spine/images/rifle.png");
        pistol.scale(60, 20);
        rifle.scale(120, 15); 
        setImage(pistol); 
    }
    public void act() 
    {
        
    }    
}
