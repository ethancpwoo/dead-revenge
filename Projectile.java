import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static GreenfootImage bullet, blank, bigBullet;
    private static Color white = new Color (255, 255, 250);
    public Projectile()
    {
       bullet = drawProjectile();
       bigBullet = drawBigProjectile(); 
       blank = new GreenfootImage(5, 5);
       setImage(blank);
    }
    public void act() 
    {
      if (isAtEdge())
      {
           getWorld().removeObject(this);
           return;
      } 
      if(this.isTouching(Zombie.class) && !getWorld().getObjects(Projectile.class).isEmpty())
      {
          getWorld().removeObject(this);
          return;
      }
      move(15);
    }   
    private GreenfootImage drawProjectile(){
      GreenfootImage temp = new GreenfootImage(16, 1);
      temp.setColor(white);
      temp.fillRect(0,0,16,1);
       
       return temp;
    }
    private GreenfootImage drawBigProjectile(){
      GreenfootImage temp = new GreenfootImage(50, 50);
      temp.setColor(white);
      temp.fillRect(0,0,50,50);
       
       return temp;
    }
}
