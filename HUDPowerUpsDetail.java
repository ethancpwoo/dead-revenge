import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUDPowerUpsDetail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUDPowerUpsDetail extends Actor
{
    /**
     * Act - do whatever the HUDPowerUpsDetail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public HUDPowerUpsDetail()
    {
        GreenfootImage  HUDPowerUpsDetail = new GreenfootImage("powerUps Hud.png");
        setImage( HUDPowerUpsDetail); 
         HUDPowerUpsDetail.scale(1200,800);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
