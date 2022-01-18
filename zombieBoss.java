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
    
    public zombieBoss()
    {
       for(int i = 0; i < move.length; i++)
        {
            move[i] = new GreenfootImage("images/export/skeleton-move_"+ i + ".png");
            move[i].scale(300,300); 
            move[i].setColor(Color.RED); 
            move[i].fill(); 
            move[i].setTransparency(55); 
        } 
       setImage(move[0]); 
        health = 40;
    }
    public void moveAround()
    {
      move(4);
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
              getWorld().removeObject(this);
              GameWorld.moving.remove(this); 
          }
        }
        
    } 
}
