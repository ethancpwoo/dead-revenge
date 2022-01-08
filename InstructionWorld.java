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
        GreenfootImage background = new GreenfootImage(1200, 800);
        back = new Button(); //make the button object
        background.setColor(gray);  
        background.fill(); //make the background pure gray
        background.setFont(titleFont); 
        background.setColor(Color.BLACK); 
        background.drawRect(100, 100, 1000, 600); 
        background.setColor(Color.WHITE); 
        background.fillRect(101, 101, 999, 599);
        background.setColor(Color.BLACK); //make a white rectangle with a black outline
        background.drawString("Instructions", 145, 170);
        background.setFont(textFont); 
        background.drawString("1. Use WASD to move around, use your mouse to aim and press space to shoot.", 145, 250);
        background.drawString("2. Zombies will come at you and will take 3 shots to kill.", 145, 300);
        background.drawString("3. Try to get the highest score possible before losing all your health.", 145, 350);
        background.drawString("4. Find cover behind walls and move around the map.", 145, 400);
        background.drawString("5. Use all weapons and be aware of bosses!", 145, 450); 
        background.drawString("6. Have fun!", 145, 500); //the actual instructions
        background.drawImage(text, 857, 535);   
        addObject(back, 900, 620); 
        setBackground(background); //set the background
    }
    public void act()
    {
        if(back.touchingCursor() == true)
        {
            Greenfoot.setWorld(new WelcomeWorld()); //go back to the welcome world
        }
    }
}
