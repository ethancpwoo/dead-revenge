import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Actor
{
    //variables for sprinting 
    int sprint = 100;
    int sprintBarWidth, healthBarWidth = 100; 
    int sprintBarHeight, healthBarHeight = 15;
    int pixelsPerSprintPoint = (int)sprintBarWidth/sprint; 
    /**
     * Act - do whatever the HUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public HUD()
    {
        sprintBar(); 
        //healthBar(); 
    }
    
    public void act()
    {
        sprintBar(); 
        //healthBar(); 
    }
    
    public void sprintBar()
    {
        setImage(new GreenfootImage(sprintBarWidth + 2, sprintBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE); 
        myImage.drawRect(0, 0, sprintBarWidth + 1, sprintBarHeight + 1);
        myImage.setColor(Color.BLUE);
        myImage.fillRect(1, 1, sprint*pixelsPerSprintPoint, sprintBarHeight);
    }
    
    public void healthBar()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE); 
        myImage.drawRect(0, 30, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 31, startingSurvivor.health*pixelsPerSprintPoint, healthBarHeight);
    }
    
    public void loseStamina()
    {
        sprint--;
        if(sprint <= 5)
        {
            sprint = 0; 
            sprint = sprint - 0; 
        }
    }
    public void gainStamina()
    {
        sprint++; 
        if(sprint >= 100)
        {
            sprint = 100; 
            sprint = sprint + 0; 
        }
    }
    public int getStamina()
    {
        return sprint; 
    }
}
