import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zombie extends Actor
{
    /**
     * Act - do whatever the zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        MouseInfo m = Greenfoot.getMouseInfo();  
        if(m != null)
        {
            turnTowards(m);
        }
        if(Greenfoot.isKeyDown("w"))
        {
            this.setLocation(this.getX(), this.getY() - 5); 
        }
        if(Greenfoot.isKeyDown("a"))
        {
            this.setLocation(this.getX() - 5, this.getY()); 
        }
        if(Greenfoot.isKeyDown("s"))
        {
            this.setLocation(this.getX(), this.getY() + 5); 
        }
        if(Greenfoot.isKeyDown("d"))
        {
            this.setLocation(this.getX() + 5, this.getY()); 
        }
        
    }   
    
    
    public void turnTowards (int x, int y)
    {
        double dx = x - getX();
        double dy = y - getY();
        double angle = Math.atan2(dy,dx)*180.0/Math.PI;
        setRotation( (int)angle );
    }
     
    public void turnTowards (MouseInfo mi)
    {
        turnTowards(mi.getX(), mi.getY());
    }
}
