import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
