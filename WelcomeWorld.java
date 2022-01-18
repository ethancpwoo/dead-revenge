import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @Ethan Woo and Kenny Zhao
 * @Fall 2021
 */
public class WelcomeWorld extends World
{
    //declare objects
    Button play; 
    Button instructions;
    SimpleTimer timer = new SimpleTimer(); 
    public WelcomeWorld()
    {            
        super(1200,800, 1);
        //GreenfootImage title = new GreenfootImage(); //the custom title
        Text start = new Text("START");
        Text instruct = new Text("INSTRUCTIONS"); 
        Gear leftGear = new Gear(true); 
        Gear rightGear = new Gear(false);
        play = new Button();
        instructions = new Button(); 
        GreenfootImage background = new GreenfootImage("1808239.jpg"); //the custom background
        //initialize objects and create them 
        //background.drawImage(title, 390, 220); //set the images and background     
        addObject(start, 400, 425);
        addObject(instruct, 800, 425); 
        addObject(play, 400, 500); 
        addObject(instructions,800, 500); //add objects to the world
        addObject(leftGear, 0, 800);
        addObject(rightGear, 1200, 800); 
        setBackground(background);
        
    }
    public void act()
    {
        
        if(play.touchingCursor()) 
        {
            Greenfoot.setWorld(new MapWorld()); //go to choosing difficulty 
            
        }
        if(instructions.touchingCursor()) 
        {
            Greenfoot.setWorld(new InstructionWorld()); //go to the instructions
        }
    }
   
}

