import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUDHealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUDHealthBar extends Actor
{
    //variables for sprinting - health bar uses them 
    int sprint = 100;
    int sprintBarWidth = 100; 
    int sprintBarHeight = 15;
    int pixelsPerSprintPoint = (int)sprintBarWidth/sprint; 
    
    
    int healthBarWidth = 100; 
    int healthBarHeight = 15;
    
    public HUDHealthBar()
    {
        healthBar(); 
    }
    
    public void act()
    {
        healthBar(); 
    }
    
    //health bar methods 
    public void healthBar()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE); 
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, startingSurvivor.health*pixelsPerSprintPoint, healthBarHeight);
    }
}
