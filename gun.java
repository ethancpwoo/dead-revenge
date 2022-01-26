import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * gun class, all weapon methods in here
 * 
 * 
 * 
 */
public class gun extends Actor
{
    public static int dsGun, wait, cooldownShootingHandgun, cooldownShootingShotgun, cooldownShootingRifle; 
    public static GreenfootImage pistol = new GreenfootImage("images/Survivor Spine/images/pistol.png"); 
    public static GreenfootImage rifle = new GreenfootImage("images/Survivor Spine/images/rifle.png"); 
    public static GreenfootImage shotgun = new GreenfootImage("images/Survivor Spine/images/shotgun.png");
    public static GreenfootImage blank = new GreenfootImage(5, 5); 
    public static GreenfootImage weapon; 
    public static boolean pistolSelected = false; 
    public static boolean rifleSelected = false; 
    public static boolean shotgunSelected = false;       
    //reload
    public boolean canReload;
    private boolean rDown; 
    public gun()
    {
        setImage(blank);
        weapon = blank; 
        wait = 0; 
        cooldownShootingHandgun = 12;
        cooldownShootingShotgun = 75; 
        cooldownShootingRifle = 9;
    }
    //shoot & reload
    public void HandgunShoot()
    {
        Projectile bullet = new Projectile();
        GreenfootSound HandgunShotSound = new GreenfootSound("handgun shot.mp3"); 
        GreenfootSound EmptyHandgunShotSound = new GreenfootSound("empty handgun sound.mp3"); 
        GameWorld playerWorld = (GameWorld) getWorld(); 
        if(Greenfoot.isKeyDown("Space") && wait > cooldownShootingHandgun && playerWorld.ammoMagazineIndicator() != 0)
        {
            HandgunShotSound.setVolume(30); 
            HandgunShotSound.play(); 
            
            
            wait = 0; 
            bullet.setRotation(getRotation());
            getWorld().addObject(bullet, startingSurvivor.survivorX, startingSurvivor.survivorY); 
            bullet.move(50); 
            bullet.setImage(Projectile.bullet);  
            
            playerWorld.ammoMagazine(); 
            
            
        }
        if(Greenfoot.isKeyDown("Space") && wait > cooldownShootingHandgun && playerWorld.ammoMagazineIndicator() == 0)
        {
            wait = 0; 
            EmptyHandgunShotSound.setVolume(50); 
            EmptyHandgunShotSound.play(); 
        }
    }
    public void reloadHandgun()
    {
        GameWorld playerWorld = (GameWorld) getWorld(); 
        GreenfootSound handgunReloadSound = new GreenfootSound("handgun reload.mp3"); 
        if(!rDown && playerWorld.ammoMagazineIndicator() != 7 && Greenfoot.isKeyDown("r") && playerWorld.ammoTotalIndicator() > 0)
        {
            rDown = true; 
            handgunReloadSound.setVolume(30); 
            handgunReloadSound.play(); 
            /*
            while(handgunReloadSound.isPlaying())
            {
               canReload = false;  
            }
            /*
            canReload = true;
        
            if(canReload)
            {
                playerWorld.addAmmoMagazine();  
            } 
            */
            playerWorld.addAmmoMagazine();  
        }
        if(rDown && !Greenfoot.isKeyDown("r"))
        {
            rDown = false; 
        }
    }
    
    public void ShotgunShoot()
    {
        Projectile bullet = new Projectile();
        Projectile bullet2 = new Projectile();
        Projectile bullet3 = new Projectile();
        GameWorld playerWorld = (GameWorld) getWorld(); 
        GreenfootSound shotgunShotSound = new GreenfootSound("pump shotgun shot.mp3"); 
        GreenfootSound EmptyshotgunShotSound = new GreenfootSound("shotgun dry firing.mp3"); 
        if(Greenfoot.isKeyDown("Space") && wait > cooldownShootingShotgun && playerWorld.ammoMagazineIndicatorShotgun() != 0)
        {
            shotgunShotSound.setVolume(50);
            shotgunShotSound.play(); 
            
            wait = 0; 
            
            bullet.setRotation(getRotation()+5);
            getWorld().addObject(bullet, startingSurvivor.survivorX, startingSurvivor.survivorY); 
            bullet.move(50); 
            bullet.setImage(Projectile.bullet);  
            
            bullet2.setRotation(getRotation());
            getWorld().addObject(bullet2, startingSurvivor.survivorX, startingSurvivor.survivorY); 
            bullet2.move(50); 
            bullet2.setImage(Projectile.bullet);  
            
            bullet3.setRotation(getRotation()-5);
            getWorld().addObject(bullet3, startingSurvivor.survivorX, startingSurvivor.survivorY); 
            bullet3.move(50); 
            bullet3.setImage(Projectile.bullet);  
            
            
            playerWorld.ammoMagazineShotgun(); 
            
            
        }
        if(Greenfoot.isKeyDown("Space") && wait > cooldownShootingShotgun && playerWorld.ammoMagazineIndicatorShotgun() == 0)
        {
            wait = 0;
            EmptyshotgunShotSound.setVolume(50);
            EmptyshotgunShotSound.play(); 
        }
    }
    public void reloadShotgun()
    {
        GameWorld playerWorld = (GameWorld) getWorld();
        GreenfootSound shotgunReloadSound = new GreenfootSound("shotgun reload.mp3"); 
        if(!rDown && playerWorld.ammoMagazineIndicatorShotgun() != 8 && Greenfoot.isKeyDown("r") && playerWorld.ammoTotalIndicatorShotgun() > 0)
        {
            rDown = true; 
            shotgunReloadSound.setVolume(30); 
            shotgunReloadSound.play(); 
            /*
            while(shotgunReloadSound.isPlaying())
            {
               canReload = false;  
            }
            canReload = true;
        
            if(canReload)
            {
                playerWorld.addAmmoMagazineShotgun();     
            }
            */
           playerWorld.addAmmoMagazineShotgun();   
        }
        if(rDown && !Greenfoot.isKeyDown("r"))
        {
            rDown = false; 
        }
    }
    
    public void RifleShoot()
    {
        Projectile bullet = new Projectile();
        GameWorld playerWorld = (GameWorld) getWorld(); 
        GreenfootSound RifleShotSound = new GreenfootSound("rifle gun sounds.mp3"); 
        GreenfootSound EmptyRifleShotSound = new GreenfootSound("rifle dry fire.mp3");
        if(Greenfoot.isKeyDown("Space") && wait > cooldownShootingRifle && playerWorld.ammoMagazineIndicatorRifle() != 0)
        {
            RifleShotSound.setVolume(30);
            RifleShotSound.play(); 
                        
            wait = 0;
            bullet.setRotation(getRotation());
            getWorld().addObject(bullet, startingSurvivor.survivorX, startingSurvivor.survivorY); 
            bullet.move(50); 
            bullet.setImage(Projectile.bullet);  
            
            playerWorld.ammoMagazineRifle(); 
            
            
        }
        if(Greenfoot.isKeyDown("Space") && wait > cooldownShootingRifle && playerWorld.ammoMagazineIndicatorRifle() == 0)
        {
            wait = 0;
            EmptyRifleShotSound.play(); 
        }
        
    }
    public void reloadRifle()
    {
        GameWorld playerWorld = (GameWorld) getWorld(); 
        GreenfootSound rifleReloadSound = new GreenfootSound("rifle reload.mp3"); 
        if(!rDown && playerWorld.ammoMagazineIndicatorRifle() != 30 && Greenfoot.isKeyDown("r") && playerWorld.ammoTotalIndicatorRifle() > 0)
        {
            rifleReloadSound.setVolume(30); 
            rifleReloadSound.play(); 
            /*
            while(rifleReloadSound.isPlaying())
            {
               canReload = false;  
            }
            canReload = true;
        
            if(canReload)
            {
                playerWorld.addAmmoMagazineRifle();       
            }
            */
            playerWorld.addAmmoMagazineRifle();    
        }
        if(rDown && !Greenfoot.isKeyDown("r"))
        {
            rDown = false; 
        }
    }
    public void act() 
    {
        GameWorld playerWorld = (GameWorld) getWorld(); 
        wait++; 
        if(Greenfoot.isKeyDown("1"))
        {
            setImage(blank); 
            weapon = blank; 
            pistolSelected = false; 
            rifleSelected = false; 
            shotgunSelected = false; 
            //displaying specific gun image 
            playerWorld.removeObjects(playerWorld.getObjects(HUDAmmoLabels.class)); 
            playerWorld.addObject(playerWorld.AmmoCounterKnife, 1100, 750);
            playerWorld.addObject(playerWorld.generalTime, 1000, 100);
        }
         if(Greenfoot.isKeyDown("2"))
        {
            setImage(pistol); 
            pistol.scale(75,20);
            weapon = pistol;
            dsGun = 30; 
            pistolSelected = true; 
            rifleSelected = false; 
            shotgunSelected = false; 
            //displaying specific gun image 
            playerWorld.removeObjects( playerWorld.getObjects(HUDAmmoLabels.class)); 
            playerWorld.addObject( playerWorld.AmmoCounterMagazine, 1100, 750); 
            playerWorld.addObject( playerWorld.AmmoCounterTotal, 1150, 750); 
            playerWorld.addObject( playerWorld.generalTime, 1000, 100);
        }
        
         if(Greenfoot.isKeyDown("3"))
        {
            setImage(rifle); 
            rifle.scale(75,20); 
            weapon = rifle;
            dsGun = 50; 
            pistolSelected = false; 
            rifleSelected = true; 
            shotgunSelected = false; 
            //displaying specific gun image 
            playerWorld.removeObjects(playerWorld.getObjects(HUDAmmoLabels.class)); 
            playerWorld.addObject(playerWorld.AmmoCounterMagazineRifle, 1075, 750); 
            playerWorld.addObject(playerWorld.AmmoCounterTotalRifle, 1150, 750);
            playerWorld.addObject(playerWorld.generalTime, 1000, 100);
        }
        
        if(Greenfoot.isKeyDown("4"))
        {
            setImage(shotgun); 
            shotgun.scale(75,20); 
            weapon = shotgun;
            dsGun = 50; 
            pistolSelected = false; 
            rifleSelected = false; 
            shotgunSelected = true; 
            //displaying specific gun image 
            playerWorld.removeObjects(playerWorld.getObjects(HUDAmmoLabels.class)); 
            playerWorld.addObject(playerWorld.AmmoCounterMagazineShotgun, 1100, 750); 
            playerWorld.addObject(playerWorld.AmmoCounterTotalShotgun, 1150, 750); 
            playerWorld.addObject(playerWorld.generalTime, 1000, 100);
        }
        
        if(pistolSelected == true)
        {
            HandgunShoot(); 
            reloadHandgun(); 
        }
        if(rifleSelected == true)
        {
            RifleShoot(); 
            reloadRifle();
        }
        if(shotgunSelected == true)
        {
            ShotgunShoot(); 
            reloadShotgun();
        }
    }    
}
