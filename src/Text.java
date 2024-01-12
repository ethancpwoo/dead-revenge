import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * class for writing text 
 * 
 * 
 * 
 */
public class Text extends Actor
{
    public Text(String str)
    {
        GreenfootImage text = new GreenfootImage(str, 40, Color.WHITE, null); 
        setImage(text); 
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
