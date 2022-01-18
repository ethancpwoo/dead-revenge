import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gun extends Actor
{
    GreenfootImage pistol = new GreenfootImage("images/Survivor Spine/images/pistol.png"); 
    GreenfootImage rifle = new GreenfootImage("images/Survivor Spine/images/rifle.png");
    GreenfootImage knife = new GreenfootImage("images/Survivor Spine/images/knife.png"); 
    GreenfootImage shotgun = new GreenfootImage("images/Survivor Spine/images/shotgun.png"); 
    public gun(String x, int scaleX, int scaleY)
    {
        GreenfootImage weapon = new GreenfootImage(x);
        weapon.scale(scaleX, scaleY);
        setImage(weapon); 
    }
    public void act() 
    {
        
    }    
}
