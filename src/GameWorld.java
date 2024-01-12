import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * main game world where all the action happens 
 */
public class GameWorld extends World
{
    
    GreenfootImage grey = new GreenfootImage(MapWorld.mapChoice); 
    public static int nCurrentZombies, nZombies, gunDistance, killCounter, zombieSpawnInterval; 
    private Scroller Scroller = null; 
    public static Actor scrollActor; 
    public startingSurvivor player = new startingSurvivor(); 
    public static ArrayList<Actor> moving = new ArrayList<Actor>(); 
    int[] positionX = {0, 500,1000,1500, 2000, 2500, 3000, 3500, 4000}; 
    int[] positionY = {0, 4000};
    
    gun CurrentWeapon = new gun(); 
    hitBox hitbox = new hitBox(); 
    Utilities ut = new Utilities(); 

    //HUD CLASSES
    HUDExtraDetails powerUpsDetail = new HUDExtraDetails("powerUps Hud.png", 1200, 800);
    HUDExtraDetails healthBarDetail = new HUDExtraDetails("healthicon.png", 60, 60);
    HUDExtraDetails sprintBarDetail = new HUDExtraDetails("sprint.png", 60, 60);
    HUDsprintBar sprintHud = new HUDsprintBar();
    HUDHealthBar healthHud = new HUDHealthBar();
    HUDChoosenWeapon weapon = new HUDChoosenWeapon(); 
    HUDPowerUps invincible = new HUDPowerUps("satr.png", 1000, 1000);
    HUDPowerUps pistolAmmo = new HUDPowerUps("pistolicon.png", 1000, 1000);
    HUDPowerUps arAmmo = new HUDPowerUps("assaultRifleAmmo.png", 1000, 1000);
    HUDPowerUps shotgunAmmo = new HUDPowerUps("shotgunicon.png", 1000, 1000);
    HUDPowerUps fastFireRate = new HUDPowerUps("fastfirerate.png", 1000, 1000);
    HUDPowerUps healthUp = new HUDPowerUps("healthsign.png", 1000, 1000);
    HUDPowerUps speedUp = new HUDPowerUps("shoe.png", 1000, 1000);
    ArrayList<HUDPowerUps> powerUpsTracker = new ArrayList<HUDPowerUps>(); 
    HUDExtraDetails skull = new HUDExtraDetails("zombieKills.png", 30,40);
    HUDExtraDetails timeLeft = new HUDExtraDetails("timeLeft.png", 75, 40); 
    
    // variables to keep track for changing power ups
    int pos1 = 0;
    int pos2 = 1;
    int pos3 = 2;
    int pos4 = 3;
    int pos5 = 4;
    int pos6 = 5; 
    int pos7 = 6; 
    
    //all ammo labels 
    HUDAmmoLabels AmmoCounterMagazine;
    HUDAmmoLabels AmmoCounterTotal; 
    HUDAmmoLabels AmmoCounterMagazineRifle;
    HUDAmmoLabels AmmoCounterTotalRifle; 
    HUDAmmoLabels AmmoCounterMagazineShotgun;
    HUDAmmoLabels AmmoCounterTotalShotgun; 
    HUDAmmoLabels AmmoCounterKnife; 
    
    
    //timer, score and kill counter labels 
    Label generalTime; 
    Label countKills; 
    Label scoreCounter; 
    SimpleTimer generalTimer = new SimpleTimer(); 
    
    //ammo variables
    public int MagazineHandgunAmmo = 7; 
    public int TotalHandgunAmmo = 14;
    public int MagazineRifleAmmo = 30; 
    public int TotalRifleAmmo = 0; 
    public int MagazineShotgunAmmo = 8;
    public int TotalShotgunAmmo = 0; 
    
    //variables to track timer, score and kill 
    public static int seconds = 0; 
    public static int score = 0;    
    public static int kills = 0; 
    
    //variable to keep track of the final score of the user, includes time bonus
    public static int finalScore = 0;
    GreenfootSound ambience, wind; 
    //userInfo for the high score 
    public static UserInfo myInfoScore1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        super(1200, 800, 1, false); 
        WelcomeWorld.bgm.stop(); 
        wind = new GreenfootSound("Strong Wind Blowing Sound (Background Sound Effect).wav"); 
        ambience = new GreenfootSound("Minecraft Zombie - Sound Effect.wav"); 
        ambience.setVolume(60);
        wind.setVolume(30); 
        ambience.playLoop(); 
        wind.playLoop(); 
        Scroller = new Scroller(this, grey, grey.getWidth(), grey.getHeight()); 
        scrollActor = new startingSurvivor(); 
        addObject(scrollActor, grey.getWidth()/2, grey.getHeight()/2);
        moving.add(scrollActor); 
        scroll(); 
        generalTimer.mark(); 
        nZombies = 5;
        nCurrentZombies = 5;
        zombieSpawnInterval = 30; 
        kills = 0; 
        seconds = 0; 
        score = 0; 
        zombieSpawn(nZombies); 
        
        //HUD ELEMENTS
        addObject(skull, 1150, 130); 
        addObject(timeLeft, 670, 50); 
        addObject(sprintHud, 150 ,120); 
        addObject(healthBarDetail, 50, 50 );
        addObject(sprintBarDetail, 50, 120);
        addObject(healthHud, 150 ,50); 
        addObject(weapon, 950,750); 
        addObject(powerUpsDetail, 600, 400); 
        //powerUps
        invincible.getImage().scale(50, 50);
        pistolAmmo.getImage().scale(50, 50);
        arAmmo.getImage().scale(50, 50); 
        shotgunAmmo.getImage().scale(50, 50); 
        fastFireRate.getImage().scale(50, 50);
        healthUp.getImage().scale(50, 50);
        speedUp.getImage().scale(50, 50);
        powerUpsTracker.add(invincible);
        powerUpsTracker.add(pistolAmmo);
        powerUpsTracker.add(arAmmo);
        powerUpsTracker.add(shotgunAmmo);
        powerUpsTracker.add(fastFireRate); 
        powerUpsTracker.add(healthUp); 
        powerUpsTracker.add(speedUp); 
        addObject(powerUpsTracker.get(pos1),85, 585); 
        addObject(powerUpsTracker.get(pos2), 180,530); 
        addObject(powerUpsTracker.get(pos3), 280,585); 
        addObject(powerUpsTracker.get(pos4), 300,680);
        addObject(powerUpsTracker.get(pos5), 238,753);  
        addObject(powerUpsTracker.get(pos6), 117,753);
        addObject(powerUpsTracker.get(pos7), 65,680);  
        
                    
        //pistol
        AmmoCounterMagazine = new HUDAmmoLabels(MagazineHandgunAmmo, 50); 
        AmmoCounterTotal = new HUDAmmoLabels(TotalHandgunAmmo, 50); 
        //rifle
        AmmoCounterMagazineRifle = new HUDAmmoLabels(MagazineRifleAmmo, 50); 
        AmmoCounterTotalRifle = new HUDAmmoLabels(TotalRifleAmmo, 50); 
        //shotgun
        AmmoCounterMagazineShotgun = new HUDAmmoLabels(MagazineShotgunAmmo, 50); 
        AmmoCounterTotalShotgun = new HUDAmmoLabels(TotalShotgunAmmo, 50); 
        //knife
        AmmoCounterKnife = new HUDAmmoLabels("INFINITE", 50); 
        addObject(AmmoCounterKnife, 1100, 750); 
        
        generalTime = new Label(seconds, 50); 
        countKills = new Label(kills, 50); 
        scoreCounter = new Label(score, 50); 
        
        addObject(hitbox, scrollActor.getX(), scrollActor.getY());
        addObject(CurrentWeapon, scrollActor.getX(), scrollActor.getY());
        addObject(generalTime, 600, 50); 
        addObject(countKills, 1100, 130); 
        addObject(scoreCounter, 1100, 50); 

        //start the waves here and continue through those methods

        
    }
    //score methods 
    public void IncreaseScore(int increaseScoreBy)
    {
        score = score + increaseScoreBy; 
        scoreCounter.setValue(score); 
    }
    public int getScore()
    {
        return score; 
    }
    //timer method
    public void updateTimer()
    {
        if(generalTimer.millisElapsed() > 1000)
        {
            seconds++; 
            generalTime.setValue(seconds); 
            generalTimer.mark(); 
        }
        countKills.setValue(kills); 
    }
    //Ammo methods 
    //handgun
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
    //shotgun
    public void ammoMagazineShotgun()
    {
        MagazineShotgunAmmo--; 
        AmmoCounterMagazineShotgun.setValue(MagazineShotgunAmmo); 
    }
    public void addAmmoMagazineShotgun()
    {
        TotalShotgunAmmo = TotalShotgunAmmo - (8 - ammoMagazineIndicatorShotgun());
        MagazineShotgunAmmo = MagazineShotgunAmmo + (8 - ammoMagazineIndicatorShotgun());
        if(TotalShotgunAmmo <= 8)
        {
            if((8 - ammoMagazineIndicatorShotgun()) > TotalShotgunAmmo)
            {
                MagazineShotgunAmmo = MagazineShotgunAmmo + TotalShotgunAmmo;
                TotalShotgunAmmo = 0; 
            }
        }
        AmmoCounterMagazineShotgun.setValue(MagazineShotgunAmmo); 
        AmmoCounterTotalShotgun.setValue(TotalShotgunAmmo); 
    }
    public int ammoMagazineIndicatorShotgun()
    {
        return MagazineShotgunAmmo; 
    }
    public int ammoTotalIndicatorShotgun()
    {
        return TotalShotgunAmmo; 
    }
    //rifle
    public void ammoMagazineRifle()
    {
        MagazineRifleAmmo--; 
        AmmoCounterMagazineRifle.setValue(MagazineRifleAmmo); 
    }
    public void addAmmoMagazineRifle()
    {
        TotalRifleAmmo = TotalRifleAmmo - (30 - ammoMagazineIndicatorRifle());
        MagazineRifleAmmo = MagazineRifleAmmo + (30 - ammoMagazineIndicatorRifle());
        if(TotalRifleAmmo <= 30)
        {
            if((30 - ammoMagazineIndicatorRifle()) > TotalRifleAmmo)
            {
                MagazineRifleAmmo = MagazineRifleAmmo + TotalRifleAmmo;
                TotalRifleAmmo = 0; 
            }
        }
        AmmoCounterMagazineRifle.setValue(MagazineRifleAmmo); 
        AmmoCounterTotalRifle.setValue(TotalRifleAmmo); 
    }
    public int ammoMagazineIndicatorRifle()
    {
        return MagazineRifleAmmo; 
    }
    public int ammoTotalIndicatorRifle()
    {
        return TotalRifleAmmo; 
    }
    //
    
    
    
    
    public void act()
    {
        //making sure weapon follows survivor 
        CurrentWeaponFollow(); 
        //enabling scroll 
        if(scrollActor != null)
        {
            scroll(); 
        }
        //survivor dies 
        if(startingSurvivor.health <= 0)
        {
            wind.stop(); 
            ambience.stop(); 
            Greenfoot.setWorld(new WinWorld()); 
        }
        //spawn zombies 
        if(nCurrentZombies <= 0)
        {
            nZombies++;
            nCurrentZombies = nZombies; 
            zombieSpawn(nZombies); 
        }
        //score calculator 
        finalScore = ((seconds / 10) * 100) + score;
        
        //spawning zombie boss 
        if(generalTimer.millisElapsed() > 90 && generalTimer.millisElapsed() < 110 && seconds % zombieSpawnInterval == 0)
        {
            zombieBoss zombieboss = new zombieBoss();
            moving.add(zombieboss); 
            addObject(zombieboss, 0, 0);
        }
        
        //zombie spawning 
        if(seconds == 60)
        {
            zombieSpawnInterval = 20; 
        }
        if(seconds == 130)
        {
            zombieSpawnInterval = 10; 
        }
        if(hitbox.active)
        {
            CurrentWeapon.setImage(gun.blank); 
        }
        else
        {
            CurrentWeapon.setImage(gun.weapon); 
        }
        
        //detect hitbox 
        hitbox.setRotation(scrollActor.getRotation());
        double angle = Math.toRadians(360 - scrollActor.getRotation()); 
        hitbox.setLocation(scrollActor.getX() + (int)(Math.cos(angle) * 30), scrollActor.getY() - (int)(Math.sin(angle) * 30)); 
        updateTimer(); 
        
    }
    
    //zombie spawning methods
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
        addObject(zombs, ut.getRandom(positionX), ut.getRandom(positionY)); 
        zombieSpawn(countDown - 1); 
    }
    public void CurrentWeaponFollow()
    {
        CurrentWeapon.setRotation(scrollActor.getRotation());
        double angle = Math.toRadians(360 - scrollActor.getRotation()); 
        CurrentWeapon.setLocation(scrollActor.getX() + (int)(Math.cos(angle) * gun.dsGun), scrollActor.getY() - (int)(Math.sin(angle) * gun.dsGun)); 
    }
    //returning sprint bar for the survivor actor class to use
    public HUDsprintBar sprintBar()
    {
        return sprintHud; 
    }
    
}
