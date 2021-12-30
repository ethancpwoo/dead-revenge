import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class survivorIdleKnife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class survivorIdleKnife extends Actor
{
    GreenfootImage[] idle = new GreenfootImage[19];
    GreenfootImage[] attack = new GreenfootImage[14];
    /**
     * Act - do whatever the survivorIdleKnife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public survivorIdleKnife()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/Top_Down_Survivor/knife/move/survivor-move_knife_" + i + ".png");
            idle[i].scale(100,100); 
        }
        
        for(int i = 0; i < attack.length; i++)
        {
            attack[i] = new GreenfootImage("images/Top_Down_Survivor/knife/meleeattack/survivor-meleeattack_knife_" + i + ".png");
            attack[i].scale(125,125); 
        }
        setImage(idle[0]); 
    }
    
    /**
       Animate the character
       */
    int imageIndex = 0;
    public void animate()
    {
        setImage(idle[imageIndex]); 
        imageIndex = (imageIndex + 1) % idle.length; 
    }
    
    int attackIndex = 0; 
    public void knifeAttack()
    {
       
            setImage(attack[attackIndex]); 
            attackIndex = (attackIndex + 1) % attack.length; 
        
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
    
     public void act() 
    {
        MouseInfo m = Greenfoot.getMouseInfo();  
        if(m != null)
        {
            turnTowards(m);
            
            int buttonNumber = m.getButton();
            if (buttonNumber == 1)
            {
                knifeAttack(); 
            }
        }
        
        if(Greenfoot.isKeyDown("w"))
        {
            this.setLocation(this.getX(), this.getY() - 5); 
            knifeAttack(); 
        }
        
        if(Greenfoot.isKeyDown("a"))
        {
            this.setLocation(this.getX() - 5, this.getY()); 
            animate(); 
        }
        
        if(Greenfoot.isKeyDown("s"))
        {
            this.setLocation(this.getX(), this.getY() + 5); 
            animate(); 
        }
        
        if(Greenfoot.isKeyDown("d"))
        {
            this.setLocation(this.getX() + 5, this.getY()); 
            animate(); 
        }
    }   
}
