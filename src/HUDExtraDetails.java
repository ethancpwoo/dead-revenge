import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * extra details on the hud (skull, timer and etc)
 */
public class HUDExtraDetails extends Actor
{
    /**
     * Act - do whatever the HUDPowerUpsDetail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public HUDExtraDetails(String x, int scaleX, int scaleY )
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
