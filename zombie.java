import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zombie extends Actor
{
    /**
     * Act - do whatever the zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("w"))
        {
            this.setLocation(this.getX(), this.getY() - 1); 
        }
        if(Greenfoot.isKeyDown("a"))
        {
            this.setLocation(this.getX() - 1, this.getY()); 
        }
        if(Greenfoot.isKeyDown("s"))
        {
            this.setLocation(this.getX(), this.getY() + 1); 
        }
        if(Greenfoot.isKeyDown("d"))
        {
            this.setLocation(this.getX() + 1, this.getY()); 
        }
        
    }    
}
