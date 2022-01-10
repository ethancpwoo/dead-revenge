import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class survivorIdleKnife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class startingSurvivor extends Actor
{
    public static int survivorX, survivorY, wait, health;
    public double stamina = 100; 
    public int movementSpeed = 5; 
    GreenfootImage[] idle = new GreenfootImage[19];
    GreenfootImage[] attack = new GreenfootImage[14];
    /**
     * Act - do whatever the survivorIdleKnife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public startingSurvivor()
    {
        wait = 0; 
        health = 0; 
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
    
    //mouse movement 
    public void turnTowards (int x, int y)
    {
        double dx = x - getX();
        double dy = y - getY();
        double angle = Math.atan2(dy,dx)*180.0/Math.PI;
        setRotation( (int)angle );
    }
    public void mouseData(MouseInfo mi)
    {
        turnTowards(mi.getX(), mi.getY());
    }
    //
    
    //sprinting method 
    public void Sprint()
    {
        if(Greenfoot.isKeyDown("Shift") && stamina > 1)
        {
             movementSpeed = 10;    
             stamina = stamina - 1; 
             if(stamina <= 0)
             {
                stamina = 0;
                stamina = stamina + 0;
             }
             
        }
        else
        {
            movementSpeed = 5; 
            stamina = stamina + 0.1;
            if(stamina >= 100){
                stamina = 100; 
                stamina = stamina + 0;
            }
            
        }
    }
    //
    
    //shoot
    public void shoot()
    {
        Projectile bullet = new Projectile();
        if(Greenfoot.isKeyDown("Space") && wait > 11){
            wait = 0;
            getWorld().addObject(bullet, getX(),getY());
            bullet.setRotation(getRotation());
        }
    }
    //
    
    //move
    public void move()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            if(this.getY() > 50)
            {
                this.setLocation(this.getX(), this.getY() - movementSpeed);
            }
            animate(); 
        }
       
        
        if(Greenfoot.isKeyDown("a"))
        {
            if(this.getX() > 50)
            {
                this.setLocation(this.getX() - movementSpeed, this.getY()); 
            }
            animate(); 
        }
        
        if(Greenfoot.isKeyDown("s"))
        {
            if(this.getY() < 750)
            {
                this.setLocation(this.getX(), this.getY() + movementSpeed);    
            }
            animate(); 
        }
        
        if(Greenfoot.isKeyDown("d"))
        {
            if(this.getX() < 1150)
            {
                this.setLocation(this.getX() + movementSpeed, this.getY()); 
            } 
            animate(); 
        }
    }
    //
    
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
        
       
        if (Greenfoot.isKeyDown("Space"))
        {
            knifeAttack(); 
        }
        
        if(Greenfoot.isKeyDown("f"))
        {
            knifeAttack(); 
        }
        
        //sprint
        Sprint(); 
        
        //move
        move(); 
        
    }  
    
}
