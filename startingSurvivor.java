
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class survivorIdleKnife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class startingSurvivor extends Actor
{
    public static int survivorX, survivorY, wait, knifeWait, health; 
    public double stamina = 100; 
    public int movementSpeed = 5; 
    SimpleTimer timer= new SimpleTimer();
    SimpleTimer timer1= new SimpleTimer();
    SimpleTimer timer2= new SimpleTimer();
    GreenfootImage[] idle = new GreenfootImage[19];
    GreenfootImage[] attack = new GreenfootImage[14];
    public Color lava = new Color(255, 83, 66);
    public Color lava2 = new Color(255, 129, 57);
    public Color lava3 = new Color(255, 110, 68); 
    public Color lightGrass = new Color(47, 129, 54);
    public Color darkGrass = new Color(0, 67, 55);
    public Color hole = new Color(0, 0, 0);  
    public static boolean moving, slowMoving;  
    
    //powerUps
    private boolean controlDown;  
    SimpleTimer invincibilityTimer = new SimpleTimer();
    SimpleTimer speedUpTimer = new SimpleTimer(); 
    SimpleTimer fastFireRateTimer = new SimpleTimer();  
    public static boolean invincibilityToggle; 
    public static boolean speedUpToggle; 
    public static boolean fastFireRateToggle; 
    gun gunFireRateChange = new gun(); 
    GreenfootSound invinciblilitySoundEffect = new GreenfootSound("invincible power up sound effect.mp3");
    GreenfootSound HealthSoundEffect = new GreenfootSound("applying medkit.mp3");
    GreenfootSound speedUpSoundEffect = new GreenfootSound("speedUp Sound Effect.mp3");
    GreenfootSound fastFireRateSoundEffect = new GreenfootSound("fast fire rate sound effect.mp3");
    GreenfootSound ammoPurchased = new GreenfootSound("ammopurchased.mp3");
    /**
     * Act - do whatever the survivorIdleKnife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public startingSurvivor()
    {
        
        knifeWait = 0; 
        health = 100; 

        timer.mark();
        timer1.mark();
        timer2.mark();
        
    
        
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
        
        gun.pistolSelected = false; 
        gun.rifleSelected = false; 
        gun.shotgunSelected = false; 
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
    public void Sprint(int sprintChange)
    {
        GameWorld playerWorld = (GameWorld) getWorld(); 
        
        //sprint bar 
        HUDsprintBar sprintingBar = playerWorld.sprintBar(); 
        if(Greenfoot.isKeyDown("Shift") && stamina > 5)
        {
             movementSpeed = 10;    
             stamina = stamina - sprintChange; 
             sprintingBar.loseStamina(sprintChange); 
             if(stamina <= 5)
             {
                stamina = 0;
                stamina = stamina + 0;
             }
             
        }
        else
        {
            movementSpeed = 5; 
            stamina = stamina + sprintChange;
            sprintingBar.gainStamina(sprintChange); 
            if(stamina >= 100){
                stamina = 100; 
                stamina = stamina + 0;
            }
            
        }
    }
    //
    
    public void soundCheck()
    {
        
        GreenfootSound slowRunning = new GreenfootSound("Minecraft Footsteps - Sound Effect (HD).wav"); 
        slowRunning.setVolume(50); 
    }
    //
    
    //key methods for the player
    public void checkKeys()
    {
        GameWorld playerWorld = (GameWorld) getWorld(); 
        //GreenfootSound running
        GreenfootSound running = new GreenfootSound("Valorant - Steps & Stepping - Gaming Sound Effect Valorant (HD) _ Sound Effects.wav");
        running.setVolume(50);
        if(Greenfoot.isKeyDown("w"))
        {
            /*if(!running.isPlaying())
            {
                running.play();
            }*/ //this method doesnt work!
            if(this.getY() > 50)
            {
                this.setLocation(this.getX(), this.getY() - movementSpeed);
            }
            animate(); 
        }
        else
        {
            moving = false; 
        }
       
        if(Greenfoot.isKeyDown("a"))
        {
            moving = true;
            if(this.getX() > 50)
            {
                this.setLocation(this.getX() - movementSpeed, this.getY()); 
            }
            
            animate(); 
        }
        else
        {
            moving = false; 
        }
        
        if(Greenfoot.isKeyDown("s"))
        {
            moving = true;
            if(this.getY() < 670)
            {
                this.setLocation(this.getX(), this.getY() + movementSpeed);    
            }
            animate(); 
        }
        else
        {
            moving = false; 
        }
        
        if(Greenfoot.isKeyDown("d"))
        {
            moving = true;
            if(this.getX() < 1150)
            {
                this.setLocation(this.getX() + movementSpeed, this.getY()); 
            } 
            animate(); 
        }
        else
        {
            moving = false; 
        }
        
        if(Greenfoot.isKeyDown("f") && knifeWait < 15)
        {   
            hitBox.active = true; 
            knifeAttack();
            
        }
        else
        {
            hitBox.active = false; 
        }
        
        
        //powerUps
         if(!controlDown && Greenfoot.isKeyDown("control"))
        {
            controlDown = true; 
            
            //pistol
            if(playerWorld.getObjectsAt( 180,530, HUDPowerUps.class).get(0).equals(playerWorld.pistolAmmo) && playerWorld.kills >= 5)
            {
                ammoPurchased.setVolume(50); 
                ammoPurchased.play(); 
                playerWorld.TotalHandgunAmmo = playerWorld.ammoTotalIndicator() + (70 - playerWorld.ammoTotalIndicator()); 
                playerWorld.AmmoCounterTotal.setValue(playerWorld.TotalHandgunAmmo);
                playerWorld.kills = playerWorld.kills - 5; 
            }
            //rifle
             if(playerWorld.getObjectsAt( 180,530, HUDPowerUps.class).get(0).equals(playerWorld.arAmmo) && playerWorld.kills >= 20)
            {   
                ammoPurchased.setVolume(50); 
                ammoPurchased.play(); 
                if(playerWorld.ammoTotalIndicatorRifle() <= 240)
                {
                    playerWorld.TotalRifleAmmo = playerWorld.ammoTotalIndicatorRifle() + 60; 
                    playerWorld.AmmoCounterTotalRifle.setValue(playerWorld.TotalRifleAmmo);
                }
                else
                {
                    playerWorld.TotalRifleAmmo = playerWorld.ammoTotalIndicatorRifle() + (300 - playerWorld.ammoTotalIndicatorRifle()); 
                    playerWorld.AmmoCounterTotalRifle.setValue(playerWorld.TotalRifleAmmo);
                }
                
                playerWorld.kills = playerWorld.kills - 20; 
            }
            //shotgunAmmo
            if(playerWorld.getObjectsAt( 180,530, HUDPowerUps.class).get(0).equals(playerWorld.shotgunAmmo) && playerWorld.kills >= 10)
            {   
                ammoPurchased.setVolume(50); 
                ammoPurchased.play(); 
                if(playerWorld.ammoTotalIndicatorShotgun() <= 64)
                {
                    playerWorld.TotalShotgunAmmo = playerWorld.ammoTotalIndicatorShotgun() + 16; 
                    playerWorld.AmmoCounterTotalShotgun.setValue(playerWorld.TotalShotgunAmmo);
                }
                else
                {
                    playerWorld.TotalShotgunAmmo = playerWorld.ammoTotalIndicatorShotgun() + (80 - playerWorld.ammoTotalIndicatorShotgun()); 
                    playerWorld.AmmoCounterTotalShotgun.setValue(playerWorld.TotalShotgunAmmo);
                }
                playerWorld.kills = playerWorld.kills - 10; 
            }
            
            //invincibility 
            if(playerWorld.getObjectsAt( 180,530, HUDPowerUps.class).get(0).equals(playerWorld.invincible) && playerWorld.kills >= 50)
            {
                invinciblilitySoundEffect.setVolume(50); 
                invinciblilitySoundEffect.play();
                playerWorld.kills = playerWorld.kills - 50; 
                invincibilityTimer.mark(); 
                invincibilityToggle = true; 
            }
            //healthUp
            if(playerWorld.getObjectsAt( 180,530, HUDPowerUps.class).get(0).equals(playerWorld.healthUp) && playerWorld.kills >= 15)
            {
                HealthSoundEffect.setVolume(50); 
                HealthSoundEffect.play(); 
                playerWorld.kills = playerWorld.kills - 15; 
                health = 100;
            }
            //speedUp
            if(playerWorld.getObjectsAt( 180,530, HUDPowerUps.class).get(0).equals(playerWorld.speedUp) && playerWorld.kills >= 15)
            {
                speedUpSoundEffect.setVolume(30); 
                speedUpSoundEffect.play(); 
                playerWorld.kills = playerWorld.kills - 15; 
                speedUpTimer.mark(); 
                speedUpToggle = true; 
            }
            //fast fire rate
            if(playerWorld.getObjectsAt( 180,530, HUDPowerUps.class).get(0).equals(playerWorld.fastFireRate) && playerWorld.kills >= 20)
            {
                fastFireRateSoundEffect.setVolume(40); 
                fastFireRateSoundEffect.play(); 
                playerWorld.kills = playerWorld.kills - 20; 
                fastFireRateTimer.mark(); 
                fastFireRateToggle = true; 
                
            }
        }
        if(controlDown && !Greenfoot.isKeyDown("control"))
        {
            controlDown = false; 
        }
    }
   
    //
    public void worldEffects()
    {
        GreenfootSound lavaSound = new GreenfootSound("Player Fire Hurt (Nr. 3 _ Minecraft Sound) - Sound Effect for editing.wav");
        lavaSound.setVolume(75); 
        if(getWorld().getColorAt(getX(), getY()).equals(lava))
        {
            
            if (timer1.millisElapsed() > 750)
            {
                if (!lavaSound.isPlaying()) 
                {
                    lavaSound.play(); 
                }
                health = health - 10; 
                timer1.mark(); 
            }
        }
        if(getWorld().getColorAt(getX(), getY()).equals(lava2))
        {
            if (timer1.millisElapsed() > 750)
            {
                if (!lavaSound.isPlaying()) 
                {
                    lavaSound.play(); 
                }
                health = health - 10; 
                timer1.mark(); 
            }
        }
        if(getWorld().getColorAt(getX(), getY()).equals(lava3))
        {
            if (timer1.millisElapsed() > 750)
            {
                if (!lavaSound.isPlaying()) 
                {
                    lavaSound.play(); 
                }
                health = health - 10; 
                timer1.mark(); 
            }
        }
        if(getWorld().getColorAt(getX(), getY()).equals(lightGrass))
        {
            timer2.mark(); 
            movementSpeed = 2;
            if(timer2.millisElapsed() > 1000)
            {
                movementSpeed = 5; 
                timer2.mark(); 
            }
            moving = false;
            slowMoving = true; 
        }
        if(getWorld().getColorAt(getX(), getY()).equals(darkGrass))
        {
            timer2.mark(); 
            movementSpeed = 3;
            if (timer1.millisElapsed() > 750)
            {
                health = health - 5; 
                timer1.mark(); 
            }
            if(timer2.millisElapsed() > 1000)
            {
                movementSpeed = 5; 
                timer2.mark(); 
            }
            moving = false;
            slowMoving = true; 
        }
        if(getWorld().getColorAt(getX(), getY()).equals(hole))
        {
            timer2.mark(); 
            movementSpeed = 2;
            if(timer2.millisElapsed() > 1000)
            {
                movementSpeed = 5; 
                timer2.mark(); 
            }
            moving = false;
            slowMoving = true; 
        }
    }
    public void checkDamage(int healthDamage)
    {
        if (timer.millisElapsed() > 250 )
        {
            GreenfootSound zombieDamage = new GreenfootSound("Horror Zombie Bite Sound Effect (No copyright sound effects) _ Sounds.wav");
            zombieDamage.setVolume(50);
            if(this.isTouching(Zombie.class) || this.isTouching(zombieBoss.class))
            {
                if (!zombieDamage.isPlaying()) 
                {
                    zombieDamage.play(); 
                }
                
                startingSurvivor.health = startingSurvivor.health - healthDamage; 
            }
            timer.mark(); 
        }
    }
    
    public void act() 
    {   
        //invincibility toggle 
        if(invincibilityTimer.millisElapsed() < 3000 && invincibilityToggle == true)
        {
            checkDamage(0);
        }
        else
        {
            invincibilityToggle = false; 
            checkDamage(5); 
        }
        //fastFireRateToggle 
        if(fastFireRateTimer.millisElapsed() < 5000 &&  fastFireRateToggle == true)
        {
            gunFireRateChange.cooldownShootingRifle = 5; 
            gunFireRateChange.cooldownShootingHandgun = 7;
            gunFireRateChange.cooldownShootingShotgun = 50; 
        }
        else
        {
            gunFireRateChange.cooldownShootingRifle = 9; 
            gunFireRateChange.cooldownShootingHandgun = 12; 
            gunFireRateChange.cooldownShootingShotgun = 75; 
            fastFireRateToggle = false; 
        }
        //speedUpToggle
        if(speedUpTimer.millisElapsed() < 7000 &&  speedUpToggle == true)
        {
            Sprint(0);
        }
        else
        {
            speedUpToggle = false; 
            Sprint(1);
        }
        
        knifeWait++;
        survivorX = getX();
        survivorY = getY();
        MouseInfo m = Greenfoot.getMouseInfo();   
        if(m != null)
        {
            mouseData(m);
        }
        if(knifeWait > 40)
        {
            knifeWait = 0; 
        }
        soundCheck();
        worldEffects();
        checkKeys(); //move 

    }  
    
}


