import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    
    //GreenfootImage grey = new GreenfootImage(MapWorld.mapChoice); 
    GreenfootImage grey = new GreenfootImage("map.png");
    public static int nCurrentZombies, nZombies, gunDistance; 
    private Scroller Scroller = null; 
    public static Actor scrollActor; 
    public static ArrayList<Actor> moving = new ArrayList<Actor>(); 
    int[] positionX = {0, 500,1000,1500, 2000, 2500, 3000, 3500, 4000}; 
    int[] positionY = {0, 4000};

    gun CurrentWeapon = new gun(); 
    hitBox hitbox = new hitBox(); 

    //HUD CLASSES
    HUDsprintBar sprintHud = new HUDsprintBar();
    HUDHealthBar healthHud = new HUDHealthBar();
    HUDChoosenWeapon weapon = new HUDChoosenWeapon(); 
    Label AmmoCounterMagazine;
    Label AmmoCounterTotal; 
    Label AmmoCounterMagazineRifle;
    Label AmmoCounterTotalRifle; 
    Label AmmoCounterMagazineShotgun;
    Label AmmoCounterTotalShotgun; 
    Label AmmoCounterKnife; 
    
    //ammo variables - will add to seperate class later 
    public int MagazineHandgunAmmo = 7; 
    public int TotalHandgunAmmo = 70;
    public int MagazineRifleAmmo = 30; 
    public int TotalRifleAmmo = 300; 
    public int MagazineShotgunAmmo = 8;
    public int TotalShotgunAmmo = 80; 
    
    //HUDAmmoCounterTotal totalAmmo = new HUDAmmoCounterTotal(8, 100); 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        super(1200, 800, 1, false); 
        Scroller = new Scroller(this, grey, grey.getWidth(), grey.getHeight()); 
        scrollActor = new startingSurvivor(); 
        addObject(scrollActor, grey.getWidth()/2, grey.getHeight()/2);
        moving.add(scrollActor); 
        scroll(); 
        spawnPowerUp(); 
        nZombies = 5;
        nCurrentZombies = 5; 
        zombieSpawn(nZombies); 
        
        
        //HUD ELEMENTS
        addObject(sprintHud,80, 50); 
        addObject(healthHud, 80,30); 
        addObject(weapon, 950,750); 
        //addObject(totalAmmo, 200, 300); 
        //pistol
        AmmoCounterMagazine = new Label(MagazineHandgunAmmo, 50); 
        AmmoCounterTotal = new Label(TotalHandgunAmmo, 50); 
        //rifle
        AmmoCounterMagazineRifle = new Label(MagazineRifleAmmo, 50); 
        AmmoCounterTotalRifle = new Label(TotalRifleAmmo, 50); 
        //shotgun
        AmmoCounterMagazineShotgun = new Label(MagazineShotgunAmmo, 50); 
        AmmoCounterTotalShotgun = new Label(TotalShotgunAmmo, 50); 
        //knife
        AmmoCounterKnife = new Label("INFINITE", 50); 
        addObject(AmmoCounterKnife, 1100, 750); 
        
        addObject(hitbox, scrollActor.getX(), scrollActor.getY());
        addObject(CurrentWeapon, scrollActor.getX(), scrollActor.getY());
        //start the waves here and continue through those methods
    }
    
    //Ammo methods - need to find a way to put them in a class
    public void ammoMagazine()
    {
        MagazineHandgunAmmo--; 
        AmmoCounterMagazine.setValue(MagazineHandgunAmmo); 
    }
    public void addAmmoMagazine()
    {
        TotalHandgunAmmo = TotalHandgunAmmo - (7 - ammoMagazineIndicator());
        MagazineHandgunAmmo = MagazineHandgunAmmo + (7 - ammoMagazineIndicator());
        if(TotalHandgunAmmo <= 7)
        {
            if((7 - ammoMagazineIndicator()) > TotalHandgunAmmo)
            {
                MagazineHandgunAmmo = MagazineHandgunAmmo + TotalHandgunAmmo;
                TotalHandgunAmmo = 0; 
            }
        }
        AmmoCounterMagazine.setValue(MagazineHandgunAmmo); 
        AmmoCounterTotal.setValue(TotalHandgunAmmo); 
    }
    public int ammoMagazineIndicator()
    {
        return MagazineHandgunAmmo; 
    }
    public int ammoTotalIndicator()
    {
        return TotalHandgunAmmo; 
    }
    //
    
    
    
    
    public void act()
    {
        CurrentWeaponFollow(); 
        if(scrollActor != null)
        {
            scroll(); 
        }
        if(startingSurvivor.health <= 0)
        {
            Greenfoot.setWorld(new WinWorld()); 
        }
        if(nCurrentZombies <= 0)
        {
            nZombies++;
            nCurrentZombies = nZombies; 
            zombieSpawn(nZombies); 
        }
         
        
        
        //knife
        if(Greenfoot.isKeyDown("1"))
        {
            removeObjects(getObjects(Label.class)); 
            addObject(AmmoCounterKnife, 1100, 750); 
        }
        //pistol
        if(Greenfoot.isKeyDown("2"))
        {
            removeObjects(getObjects(Label.class)); 
            addObject(AmmoCounterMagazine, 1100, 750); 
            addObject(AmmoCounterTotal, 1150, 750); 
        }
        //rifle 
        if(Greenfoot.isKeyDown("3"))
        {
            removeObjects(getObjects(Label.class)); 
            addObject(AmmoCounterMagazineRifle, 1075, 750); 
            addObject(AmmoCounterTotalRifle, 1150, 750);
        }
        //shotgun
        if(Greenfoot.isKeyDown("4"))
        {
            removeObjects(getObjects(Label.class)); 
            addObject(AmmoCounterMagazineShotgun, 1100, 750); 
            addObject(AmmoCounterTotalShotgun, 1150, 750); 
        }
        /*
        if(hitbox.active)
        {
            CurrentWeapon.setImage(gun.blank); 
        }
        else
        {
            CurrentWeapon.setImage(gun.weapon); 
        }
        */
        hitbox.setRotation(scrollActor.getRotation());
        double angle = Math.toRadians(360 - scrollActor.getRotation()); 
        hitbox.setLocation(scrollActor.getX() + (int)(Math.cos(angle) * 30), scrollActor.getY() - (int)(Math.sin(angle) * 30)); 
        
        
    }
    private void scroll()
    {
        int loX = 550; 
        int hiX = 1200 - 550;
        int loY = 350; 
        int hiY = 800 - 350; 
        int dsx = 0;
        int dsy = 0;
        if(scrollActor.getX() < loX)
        {
            dsx = scrollActor.getX() - loX; 
        }
        if(scrollActor.getX() > hiX)
        {
            dsx = scrollActor.getX() - hiX; 
        }
        if(scrollActor.getY() < loY)
        {
            dsy = scrollActor.getY() - loY;
        }
        if(scrollActor.getY() > hiY)
        {
            dsy = scrollActor.getY() - hiY; 
        }
        Scroller.scroll(dsx, dsy); 
    }
    public void zombieSpawn(int countDown)
    { 
        if(countDown <= 0)
        {
            return; 
        }
        Zombie zombs = new Zombie(); 
        moving.add(zombs); 
        addObject(zombs, getRandom(positionX), getRandom(positionY)); 
        zombieSpawn(countDown - 1); 
    }
    public void CurrentWeaponFollow()
    {
        CurrentWeapon.setRotation(scrollActor.getRotation());
        double angle = Math.toRadians(360 - scrollActor.getRotation()); 
        CurrentWeapon.setLocation(scrollActor.getX() + (int)(Math.cos(angle) * 30), scrollActor.getY() - (int)(Math.sin(angle) * 30)); 
    }
    
    public static int getRandom(int[] array) 
    {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    public void spawnPowerUp()
    { 
        healthUp healthUp = new healthUp(); 
        Invincible invincible = new Invincible(); 
        bigBullet bigbullet = new bigBullet(); 
        speedUp speedUp = new speedUp(); 
        fastfirerate fastfirerate = new fastfirerate(); 
        
        
 
    }
    public HUDsprintBar sprintBar()
    {
        return sprintHud; 
    }
}
