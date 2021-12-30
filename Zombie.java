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
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Zombie()
    {
        for(int i = 0; i < move.length; i++)
        {
            move[i] = new GreenfootImage("images/export/skeleton-move_"+ i + ".png");
            move[i].scale(100,100); 
        }
        setImage(move[0]); 
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
      move(1);
      animate();
    }
    
     public void chasePlayer()
    {
       turnTowards(survivorIdleKnife.survivorX,survivorIdleKnife.survivorY); 
    }
    
    public void act()
    {
       moveAround();
       chasePlayer();
    }
}
