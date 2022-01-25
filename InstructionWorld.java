import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionWorld extends World
{
    Color gray = new Color(64, 64, 64); 
    Font titleFont = new Font("Calibri", true, false, 40);
    Font textFont = new Font("Calibri", false, false, 25);
    GreenfootImage text = new GreenfootImage("BACK", 40, Color.BLACK, null);
    Button back; //define objects, colors, and fonts
    public InstructionWorld()
    {    
        super(1200, 800, 1); 
        GreenfootImage background = new GreenfootImage("instructions.png");
        back = new Button(); //make the button object
        back.getImage().scale(111, 39);
        //the actual instructions
        background.drawImage(text, 45, 650);   
        addObject(back, 90, 715); 
        setBackground(background); //set the background
    }
    public void act()
    {
        back.getImage().scale(111, 39);
        if(back.touchingCursor() == true)
        {
            Greenfoot.setWorld(new WelcomeWorld()); //go back to the welcome world
        }
    }
}
