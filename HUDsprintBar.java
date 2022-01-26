import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUDsprintBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUDsprintBar extends Actor
{
    //variables for sprinting 
    int sprint = 100;
    int sprintBarWidth = 100; 
    int sprintBarHeight = 15;
    int pixelsPerSprintPoint = (int)sprintBarWidth/sprint; 
    
    public HUDsprintBar()
    {
        sprintBar(); 
    }
   
    public void act()
    {
       sprintBar(); 
    }
    
    //sprint bar methods 
    public void sprintBar()
    {
        setImage(new GreenfootImage(sprintBarWidth + 2, sprintBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE); 
        myImage.drawRect(0, 0, sprintBarWidth + 1, sprintBarHeight + 1);
        myImage.setColor(Color.BLUE);
        myImage.fillRect(1, 1, sprint*pixelsPerSprintPoint, sprintBarHeight);
    }
    public void loseStamina(int lose)
    {
        sprint = sprint - lose;
        if(sprint <= 5)
        {
            sprint = 0; 
            sprint = sprint - 0; 
        }
    }
    public void gainStamina(int gain)
    {
        sprint = sprint + gain; 
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
