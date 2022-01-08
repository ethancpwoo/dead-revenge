import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    boolean touchingImage = false;
    GreenfootImage init = new GreenfootImage("GreySTARTbutton.png"); 
    GreenfootImage after = new GreenfootImage("GreySTARTbuttonon.png");
    public Button()
    {        
       init.scale(222, 78);
       after.scale(222, 78); 
       this.setImage(init); 
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) == true)
        {
           touchingImage = true;
        }
        else {
           touchingImage = false;
        }
        if(Greenfoot.mouseMoved(this))
        {
            setImage(after); 
        }
        if(Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            setImage(init); 
        }
    }    
    public boolean touchingCursor()
    {
        return touchingImage; 
    }
}
