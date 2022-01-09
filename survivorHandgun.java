import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class survivorHandgun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class survivorHandgun extends startingSurvivor
{
    /**
     * Act - do whatever the survivorHandgun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
     public survivorHandgun()
    {
        wait = 0; 
        health = 0; 
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/Top_Down_Survivor/handgun/move/survivor-move_handgun_" + i + ".png");
            idle[i].scale(100,100); 
        }
        
        for(int i = 0; i < attack.length; i++)
        {
            attack[i] = new GreenfootImage("images/Top_Down_Survivor/knife/meleeattack/survivor-meleeattack_knife_" + i + ".png");
            attack[i].scale(125,125); 
        }
        setImage(idle[0]); 
    }
    
    public void act()
    {
        wait++; 
        survivorX = getX();
        survivorY = getY();
        MouseInfo m = Greenfoot.getMouseInfo();  
        if(m != null)
        {
            mouseData(m);           
        }  
        
        if(Greenfoot.isKeyDown("w"))
        {
            if(this.getY() > 50)
            {
                this.setLocation(this.getX(), this.getY() - 5);
            }
            animate(); 
        }
        
        if(Greenfoot.isKeyDown("a"))
        {
            if(this.getX() > 50)
            {
                this.setLocation(this.getX() - 5, this.getY()); 
            }
            animate(); 
        }
        
        if(Greenfoot.isKeyDown("s"))
        {
            if(this.getY() < 750)
            {
                this.setLocation(this.getX(), this.getY() + 5);    
            }
            animate(); 
        }
        
        if(Greenfoot.isKeyDown("d"))
        {
            if(this.getX() < 1150)
            {
                this.setLocation(this.getX() + 5, this.getY()); 
            } 
            animate(); 
        }
        shoot(); 
    }
}
