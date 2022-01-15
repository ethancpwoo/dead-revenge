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
        GreenfootImage map1 = new GreenfootImage("map.png");
        GreenfootImage map2 = new GreenfootImage("map2.png");
        GreenfootImage map3 = new GreenfootImage("map3.png");
        map1.scale(300, 300); 
        map2.scale(300, 300);
        map3.scale(300, 300);
        background.drawImage(map1, 150, 350); 
        background.drawImage(map2, 450, 350);
        background.drawImage(map3, 750, 350);
        setBackground(background); 
        addObject(easy, 300, 300); 
        addObject(medium, 600, 300); 
        addObject(hard, 900, 300); 
    }
    public void act()
    {
        if(easy.touchingCursor()) 
        {
            mapChoice = "map.png"; 
            Greenfoot.setWorld(new GameWorld()); //go to choosing difficulty 
            
        }
        if(medium.touchingCursor()) 
        {
            mapChoice = "map2.png"; 
            Greenfoot.setWorld(new GameWorld()); //go to choosing difficulty 
            
        }
        if(hard.touchingCursor()) 
        {
            mapChoice = "map3.png"; 
            Greenfoot.setWorld(new GameWorld()); //go to choosing difficulty 
            
        }
    }
}
