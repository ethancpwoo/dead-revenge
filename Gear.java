import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * extra details, moving gears
 */
public class Gear extends Actor
{
    boolean turn = true; 
    public Gear(boolean clockwise)
    {
        GreenfootImage gear = new GreenfootImage("gear.png"); 
        gear.scale(500, 500); 
        setImage(gear); 
        turn = clockwise; 
    }
    public void act() 
    {
        if(turn)
        {
            turn(1); 
        }
        else
        {
            turn(-1);
        } 
    }    
}
