import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gun extends Actor
{
    public static GreenfootImage blank, pistol, rifle; 
    public gun()
    {
        pistol = new GreenfootImage("images/Survivor Spine/images/pistol.png"); 
        rifle = new GreenfootImage("images/Survivor Spine/images/rifle.png");
        blank = new GreenfootImage(5, 5); 
        pistol.scale(60, 20);
        rifle.scale(120, 15); 
        setImage(pistol); 
    }
    public void act() 
    {
        
    }    
}
