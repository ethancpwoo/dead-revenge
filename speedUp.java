import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class speedUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class speedUp extends powerUp
{
    public speedUp()
    {
        super(); 
        GreenfootImage speed = new GreenfootImage("shoe.png");
        speed.scale(50, 50);
        setImage(speed); 
    }
    public void act() 
    {
        if(this.isTouching(startingSurvivor.class))
        {
            getWorld().removeObject(this); 
        }
    }    
}
