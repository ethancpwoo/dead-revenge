import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChoosenWeapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class HUDChoosenWeapon extends Actor
{
    /**
     * Act - do whatever the ChoosenWeapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage pistol = new GreenfootImage("pistol.png");
    GreenfootImage rifle = new GreenfootImage("rifle.png");
    GreenfootImage shotgun = new GreenfootImage("shotgun.png"); 
    GreenfootImage knife = new GreenfootImage("knife.png"); 
    
    public HUDChoosenWeapon()
    {
        setImage(knife); 
        knife.scale(75,65); 
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("1"))
        {
            setImage(knife); 
            knife.scale(75,60); 
        }
        
         if(Greenfoot.isKeyDown("2"))
        {
            setImage(pistol); 
            pistol.scale(75,65); 
        }
        
         if(Greenfoot.isKeyDown("3"))
        {
            setImage(rifle); 
            rifle.scale(170,130); 
        }
        
        if(Greenfoot.isKeyDown("4"))
        {
            setImage(shotgun); 
            shotgun.scale(200,200); 
        }
    }
}
