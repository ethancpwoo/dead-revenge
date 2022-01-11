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
    int sprint = 4;
    int sprintBarWidth = 80; 
    int sprintBarHeight = 15;
    int pixelsPerSprintPoint = (int)sprintBarWidth/sprint; 
    /**
     * Act - do whatever the HUD wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public HUD()
    {
        sprintBar(); 
    }
    
    public void act()
    {
        sprintBar(); 
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
    
    public void loseStamina()
    {
        sprint--;
        if(sprint <= 0)
        {
            sprint = 0; 
            sprint = sprint - 0; 
        }
    }
    
    public void gainStamina()
    {
        sprint++; 
        if(sprint >= 4)
        {
            sprint = 4; 
            sprint = sprint + 0; 
        }
    }
}
