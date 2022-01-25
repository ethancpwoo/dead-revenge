import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mapWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapWorld extends World
{
    Button easy, medium, hard; 
    public static String mapChoice; 
    /**
     * Constructor for objects of class mapWorld.
     * 
     */
    public MapWorld()
    {    
        super(1200,800, 1);
        GreenfootImage background = new GreenfootImage("1808239.jpg");
        easy = new Button(); 
        medium = new Button();
        hard = new Button();
        easy.getImage().scale(148, 52); 
        medium.getImage().scale(148, 52); 
        hard.getImage().scale(148, 52); 
        GreenfootImage map1 = new GreenfootImage("map.png");
        GreenfootImage map2 = new GreenfootImage("map2.png");
        GreenfootImage map3 = new GreenfootImage("map3.png");
        GreenfootImage easyTitle = new GreenfootImage("easy.png"); 
        GreenfootImage mediumTitle = new GreenfootImage("medium.png"); 
        GreenfootImage hardTitle = new GreenfootImage("hard.png"); 
        GreenfootImage mapTitle = new GreenfootImage("map select.png"); 
        map1.scale(300, 300); 
        map2.scale(300, 300);
        map3.scale(300, 300);
        background.drawImage(map1, 100, 400); 
        background.drawImage(map2, 800, 400);
        background.drawImage(map3, 450, 400);
        background.drawImage(easyTitle, 150, 225); 
        background.drawImage(mediumTitle, 450, 225);
        background.drawImage(hardTitle, 850, 225);
        background.setColor(Color.BLACK);
        background.drawImage(mapTitle, 400, 100);
        background.drawRect(99, 399, 301, 301);
        background.drawRect(449, 399, 301, 301);
        background.drawRect(799, 399, 301, 301);
        setBackground(background); 
        addObject(easy, 250, 350); 
        addObject(medium, 600, 350); 
        addObject(hard, 950, 350); 
    }
    public void act()
    {
        easy.getImage().scale(148, 52); 
        medium.getImage().scale(148, 52); 
        hard.getImage().scale(148, 52); 
        if(easy.touchingCursor()) 
        {
            mapChoice = "map.png"; 
            Greenfoot.setWorld(new GameWorld()); //go to choosing difficulty 
            
        }
        if(medium.touchingCursor()) 
        {
            mapChoice = "map3.png"; 
            Greenfoot.setWorld(new GameWorld()); //go to choosing difficulty 
            
        }
        if(hard.touchingCursor()) 
        {
            mapChoice = "map2.png"; 
            Greenfoot.setWorld(new GameWorld()); //go to choosing difficulty 
            
        }
    }
}
