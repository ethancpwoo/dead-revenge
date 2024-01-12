import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUDPowerUps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUDPowerUps extends Actor
{
    
    public HUDPowerUps(String x, int scaleX, int scaleY)
    {
        GreenfootImage CurrentPowerUp = new GreenfootImage(x);
        CurrentPowerUp.scale(scaleX,scaleY);
        setImage(CurrentPowerUp ); 
         
    }
    
    public void act()
    {
        
    }
}
