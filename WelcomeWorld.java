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
    leftDoor leftdoor = new leftDoor(); 
    rightDoor rightdoor = new rightDoor();
    SimpleTimer timer = new SimpleTimer(); 
    public WelcomeWorld()
    {            
        super(1200,800, 1);
        //GreenfootImage title = new GreenfootImage(); //the custom title
        Text start = new Text("START");
        Text instruct = new Text("INSTRUCTIONS"); 
        Gear leftGear = new Gear(true); 
        Gear rightGear = new Gear(false);
        play = new Button("Play", 410, 230);
        instructions = new Button("Instructions", 770, 430); 
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
            openGate();
            Greenfoot.setWorld(new GameWorld()); //go to choosing difficulty 
            
        }
        if(instructions.touchingCursor()) 
        {
            Greenfoot.setWorld(new InstructionWorld()); //go to the instructions
        }
    }
    private void openGate()
    {
        addObject(leftdoor, -600, 400);
        addObject(rightdoor, 1800, 400); 
        timer.mark(); 
        for(int i = 0; i < 120; i++)
        {
            if(timer.millisElapsed() > 100)
            {
                leftdoor.setLocation(leftdoor.getX() + 5, leftdoor.getY()); 
                rightdoor.setLocation(rightdoor.getX() - 5, leftdoor.getY());
                timer.mark(); 
            }
            
        }
    }
}

