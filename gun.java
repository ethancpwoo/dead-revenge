import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gun extends Actor
{
    public static int dsGun; 
    public static GreenfootImage pistol = new GreenfootImage("images/Survivor Spine/images/pistol.png"); 
    public static GreenfootImage rifle = new GreenfootImage("images/Survivor Spine/images/rifle.png"); 
    public static GreenfootImage shotgun = new GreenfootImage("images/Survivor Spine/images/shotgun.png");
    public static GreenfootImage blank = new GreenfootImage(5, 5); 
    public static GreenfootImage weapon; 
    public gun()
    {
        setImage(blank);
        weapon = blank; 
    }
    public void act() 
    {
         if(Greenfoot.isKeyDown("1"))
        {
            setImage(blank); 
            weapon = blank; 
        }
         if(Greenfoot.isKeyDown("2"))
        {
            setImage(pistol); 
            pistol.scale(75,20);
            weapon = pistol;
            dsGun = 30; 
        }
        
         if(Greenfoot.isKeyDown("3"))
        {
            setImage(rifle); 
            rifle.scale(75,20); 
            weapon = rifle;
            dsGun = 50; 
        }
        
        if(Greenfoot.isKeyDown("4"))
        {
            setImage(shotgun); 
            shotgun.scale(75,20); 
            weapon = shotgun;
            dsGun = 50; 
        }
    }    
}
