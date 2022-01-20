import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zombieBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zombieBoss extends Zombie
{
    GreenfootImage[] move = new GreenfootImage[16];
    public int health;
    public int size = 200; 
    public zombieBoss()
    {
       for(int i = 0; i < move.length; i++)
        {
            move[i] = new GreenfootImage("images/export/skeleton-move_"+ i + ".png");
            move[i].scale(size, size); 
        }
        setImage(move[0]); 
        health = 40;  
    }
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
    public void act()
    {
       moveAround();
       chasePlayer();
       if(this.isTouching(Projectile.class))
       {
          health--; 
          if(health == 0)
          {
              GameWorld.kills++;
              getWorld().removeObject(this);
              GameWorld.moving.remove(this); 
          }
        }
        
    } 
}
