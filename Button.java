import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * button for interaction in menues
 */
public class Button extends Actor
{
    boolean touchingImage = false;
    public GreenfootImage init = new GreenfootImage("GreySTARTbutton.png"); 
    public GreenfootImage after = new GreenfootImage("GreySTARTbuttonon.png");
    GreenfootSound buttonHover = new GreenfootSound("hover button sfx.mp3");
    GreenfootSound buttonClick = new GreenfootSound("buttonclicksfx.mp3");
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
           buttonClick.setVolume(60); 
           buttonClick.play();
        }
        else {
           touchingImage = false;
        }
        if(Greenfoot.mouseMoved(this))
        {
            //buttonHover.play(); 
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
