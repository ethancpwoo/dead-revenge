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
        int dsx = scrollActor.getX() - 300/2; 
        int dsy = scrollActor.getY() - 200/2; 
        Scroller.scroll(dsx, dsy); 
    }
}
