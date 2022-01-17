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
    
    public HUDChoosenWeapon()
    {
        setImage(pistol); 
        pistol.scale(75,75); 
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
