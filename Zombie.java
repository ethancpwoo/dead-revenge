
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    GreenfootImage[] move = new GreenfootImage[16];
    public int health; 
    public int size = 100;
    StatBar zombieHealthBar; 
    
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Zombie()
    {
        for(int i = 0; i < move.length; i++)
        {
            move[i] = new GreenfootImage("images/export/skeleton-move_"+ i + ".png");
            move[i].scale(size, size); 
        }
        setImage(move[0]); 
        health = 5;
        zombieHealthBar = new StatBar(health, health, this, 40, 8, -40);
         
        GameWorld.moving.add(zombieHealthBar);
    }
    
    public void addedToWorld (World w)
    {
        w.addObject (zombieHealthBar, getX(), getY());
        zombieHealthBar.update(health);
    }
    
    public int getHealth()
    {
        return health; 
    }
    
    /**
       Animate the character
       */
    int imageIndex = 0;
    public void animate()
    {
        setImage(move[imageIndex]); 
        imageIndex = (imageIndex + 1) % move.length; 
    }
    
    public void moveAround()
    {
      move(7);
      animate();
    }
    
     public void chasePlayer()
    {
       turnTowards(startingSurvivor.survivorX,startingSurvivor.survivorY); 
    }
    
    public void act()
    {
       moveAround();
       chasePlayer();
       zombieHealthBar.update(health); 
       if(this.isTouching(Projectile.class) && gun.pistolSelected)
       {
           health--;  
       }
       if(this.isTouching(Projectile.class) && gun.shotgunSelected)
       {
           health = health - 5;  
       }
       if(this.isTouching(Projectile.class) && gun.rifleSelected)
       {
           health = health - 2;  
       }
       if(this.isTouching(hitBox.class) && hitBox.active == true)
       {
           health--; 
       }
       if(health <= 0)
       {
            GameWorld playerWorld = (GameWorld) getWorld(); 
            getWorld().removeObject(this);
            GameWorld.moving.remove(this);  
            GameWorld.kills++; 
            GameWorld.nCurrentZombies--; 
            playerWorld.IncreaseScore(100); 
       }
       
    }
}
