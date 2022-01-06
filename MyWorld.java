import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GreenfootImage grey = new GreenfootImage("grey.png"); 
    private Scroller Scroller = null; 
    Actor scrollActor; 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1200, 800, 1, false); 
        Scroller = new Scroller(this, grey, grey.getWidth(), grey.getHeight()); 
        scrollActor = new survivorIdleKnife(); 
        addObject(scrollActor, grey.getWidth()/2, grey.getHeight()/2); 
        scroll(); 
    }
    public void act()
    {
        if(scrollActor != null)
        {
            scroll(); 
        }
    }
    private void scroll()
    {
        int loX = 100; 
        int hiX = 1200 - 100;
        int loY = 100; 
        int hiY = 800 - 100; 
        int dsx = 0;
        int dsy = 0;
        if(scrollActor.getX() < loX)
        {
            dsx = scrollActor.getX() - loX; 
        }
        if(scrollActor.getX() > hiX)
        {
            dsx = scrollActor.getX() - hiX; 
        }
        if(scrollActor.getY() < loY)
        {
            dsy = scrollActor.getY() - loY;
        }
        if(scrollActor.getY() > hiY)
        {
            dsy = scrollActor.getY() - hiY; 
        }
        Scroller.scroll(dsx, dsy); 
    }
}
