import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUDPowerUpsExtraDetails here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUDPowerUpsExtraDetails extends Actor
{
    /**
     * Act - do whatever the HUDPowerUpsExtraDetails wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public HUDPowerUpsExtraDetails(String x, int scaleX, int scaleY )
    {
        GreenfootImage HUDExtraDetail = new GreenfootImage(x);
        setImage( HUDExtraDetail); 
        HUDExtraDetail.scale(scaleX,scaleY);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
