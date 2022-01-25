import greenfoot.*;
public class zombieBoss extends Actor
{
    GreenfootImage[] move = new GreenfootImage[16];
    public int health; 
    public int size = 200;
    StatBar zombieHealthBar; 
    SimpleTimer timer= new SimpleTimer();
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public zombieBoss()
    {
        for(int i = 0; i < move.length; i++)
        {
            move[i] = new GreenfootImage("images/export/skeleton-move_"+ i + ".png");
            move[i].scale(size, size); 
        }
        setImage(move[0]); 
        health = 40;
        zombieHealthBar = new StatBar(health, health, this, 40, 8, -80);
        GameWorld.moving.add(zombieHealthBar);
        timer.mark();
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
      move(2);
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
           health = health - 3;  
       }
       if(this.isTouching(Projectile.class) && gun.rifleSelected)
       {
           health = health--;  
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
            playerWorld.IncreaseScore(500); 
       }
       if (timer.millisElapsed() > 250)
        {
            GreenfootSound zombieDamage = new GreenfootSound("Horror Zombie Bite Sound Effect (No copyright sound effects) _ Sounds.wav");
            zombieDamage.setVolume(50);
            if(this.isTouching(startingSurvivor.class))
            {
                if (!zombieDamage.isPlaying()) 
                {
                    zombieDamage.play(); 
                }
                
                health = health - 5; 
            }
            timer.mark(); 
        }
    }
}