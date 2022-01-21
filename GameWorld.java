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
    GreenfootImage grey = new GreenfootImage("map2.png");
    public static int nCurrentZombies, nZombies, gunDistance, killCounter; 
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
    HUDPowerUps invincible = new HUDPowerUps("satr.png", 50, 50);
    HUDPowerUps bigBullet = new HUDPowerUps("largebullet.png", 60, 30);
    HUDPowerUps fastFireRate = new HUDPowerUps("fastfirerate.png", 50, 50);
    HUDPowerUps healthUp = new HUDPowerUps("healthsign.png", 50, 50);
    HUDPowerUps speedUp = new HUDPowerUps("shoe.png", 50, 50);
    ArrayList<HUDPowerUps> powerUpsTracker = new ArrayList<HUDPowerUps>(); 
    HUDPowerUpsDetail powerUpsDetail = new HUDPowerUpsDetail(); 
    //temporary, just here to easily update
    ArrayList<HUDPowerUpsLabelTEMPORARY> powerUpsTrackerLabel = new ArrayList<HUDPowerUpsLabelTEMPORARY>(); 
    HUDPowerUpsLabelTEMPORARY invincibleLabel = new HUDPowerUpsLabelTEMPORARY(50, 25); 
    HUDPowerUpsLabelTEMPORARY bigBulletLabel = new HUDPowerUpsLabelTEMPORARY(25, 25); 
    HUDPowerUpsLabelTEMPORARY fastFireRateLabel = new HUDPowerUpsLabelTEMPORARY(15, 25); 
    HUDPowerUpsLabelTEMPORARY healthUpLabel = new HUDPowerUpsLabelTEMPORARY(35, 25); 
    HUDPowerUpsLabelTEMPORARY speedUpLabel = new HUDPowerUpsLabelTEMPORARY(15, 25); 
    int pos1Label = 0; 
    int pos2Label = 1; 
    int pos3Label = 2; 
    int pos4Label = 3; 
    int pos5Label = 4; 
    //
    int pos1 = 0;
    int pos2 = 1;
    int pos3 = 2;
    int pos4 = 3;
    int pos5 = 4;
    private boolean eDown; 
    private boolean qDown; 
    private boolean controlDown; 
    HUDAmmoLabels AmmoCounterMagazine;
    HUDAmmoLabels AmmoCounterTotal; 
    HUDAmmoLabels AmmoCounterMagazineRifle;
    HUDAmmoLabels AmmoCounterTotalRifle; 
    HUDAmmoLabels AmmoCounterMagazineShotgun;
    HUDAmmoLabels AmmoCounterTotalShotgun; 
    HUDAmmoLabels AmmoCounterKnife; 
    Label generalTime; 
    Label countKills; 
    SimpleTimer generalTimer = new SimpleTimer(); 
    
    
    //ammo variables - will add to seperate class later 
    public int MagazineHandgunAmmo = 7; 
    public int TotalHandgunAmmo = 70;
    public int MagazineRifleAmmo = 30; 
    public int TotalRifleAmmo = 300; 
    public int MagazineShotgunAmmo = 8;
    public int TotalShotgunAmmo = 80; 
    public int seconds = 0; 
    
    
    public static int kills; 
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
        generalTimer.mark(); 
        nZombies = 5;
        nCurrentZombies = 5; 
        kills = 0; 
        zombieSpawn(nZombies); 
        
        //HUD ELEMENTS
        addObject(powerUpsDetail, 600, 400); 
        addObject(sprintHud,80, 50); 
        addObject(healthHud, 80,30); 
        addObject(weapon, 950,750); 
        //powerUps
        powerUpsTracker.add(invincible);
        powerUpsTracker.add(bigBullet); 
        powerUpsTracker.add(fastFireRate); 
        powerUpsTracker.add(healthUp); 
        powerUpsTracker.add(speedUp); 
        addObject(powerUpsTracker.get(pos1),100, 650); 
        addObject(powerUpsTracker.get(pos2), 200,575); 
        addObject(powerUpsTracker.get(pos3), 300,650); 
        addObject(powerUpsTracker.get(pos4), 265,745);
        addObject(powerUpsTracker.get(pos5), 140,745);  
        
        //temporary
        powerUpsTrackerLabel.add(invincibleLabel);
        powerUpsTrackerLabel.add(bigBulletLabel); 
        powerUpsTrackerLabel.add(fastFireRateLabel); 
        powerUpsTrackerLabel.add(healthUpLabel); 
        powerUpsTrackerLabel.add(speedUpLabel); 
        addObject(powerUpsTrackerLabel.get(pos1Label), 130,675); 
        addObject(powerUpsTrackerLabel.get(pos2Label), 230,600); 
        addObject(powerUpsTrackerLabel.get(pos3Label), 330,675); 
        addObject(powerUpsTrackerLabel.get(pos4Label), 295,770); 
        addObject(powerUpsTrackerLabel.get(pos5Label), 165,770); 
        //
        
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
        
        addObject(hitbox, scrollActor.getX(), scrollActor.getY());
        addObject(CurrentWeapon, scrollActor.getX(), scrollActor.getY());
        addObject(generalTime, 1000, 100); 
        addObject(countKills, 900, 100); 
        //start the waves here and continue through those methods
    }
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
    //Ammo methods - need to find a way to put them in a class; turn into interface?
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
        if(generalTimer.millisElapsed() > 90 && generalTimer.millisElapsed() < 110 && seconds % 40 == 0)
        {
            zombieBoss zombieboss = new zombieBoss();
            addObject(zombieboss, 0, 0); 
            moving.add(zombieboss); 
        }
        //powerUp switching 
        if(!eDown && Greenfoot.isKeyDown("e"))
        {
            eDown = true;
            removeObjects(getObjects(HUDPowerUps.class)); 
            pos1++;
            pos2++;
            pos3++;
            pos4++;
            pos5++;
            if(pos1 > 4)
            {
                pos1 = 0; 
            }
            if(pos2 > 4)
            {
                pos2 = 0; 
            }
            if(pos3 > 4)
            {
                pos3 = 0; 
            }
            if(pos4 > 4)
            {
                pos4 = 0; 
            }
            if(pos5 > 4)
            {
                pos5 = 0; 
            }
            addObject(powerUpsTracker.get(pos1),100, 650); 
            addObject(powerUpsTracker.get(pos2), 200,575); 
            addObject(powerUpsTracker.get(pos3), 300,650); 
            addObject(powerUpsTracker.get(pos4), 265,745);
            addObject(powerUpsTracker.get(pos5), 140,745);  
            
            
            //temporary 
            removeObjects(getObjects(HUDPowerUpsLabelTEMPORARY.class)); 
            pos1Label++;
            pos2Label++;
            pos3Label++;
            pos4Label++;
            pos5Label++;
            if(pos1Label > 4)
            {
                pos1Label = 0; 
            }
            if(pos2Label > 4)
            {
                pos2Label = 0; 
            }
            if(pos3Label > 4)
            {
                pos3Label = 0; 
            }
            if(pos4Label > 4)
            {
                pos4Label = 0; 
            }
            if(pos5Label > 4)
            {
                pos5Label = 0; 
            }
            addObject(powerUpsTrackerLabel.get(pos1Label), 130,675); 
            addObject(powerUpsTrackerLabel.get(pos2Label), 230,600); 
            addObject(powerUpsTrackerLabel.get(pos3Label), 330,675); 
            addObject(powerUpsTrackerLabel.get(pos4Label), 295,770); 
            addObject(powerUpsTrackerLabel.get(pos5Label), 165,770); 
            //
        }
        if(eDown && !Greenfoot.isKeyDown("e"))
        {
            eDown = false; 
        }
        if(!qDown && Greenfoot.isKeyDown("q"))
        {
            qDown = true;
            removeObjects(getObjects(HUDPowerUps.class)); 
            pos1--;
            pos2--;
            pos3--;
            pos4--;
            pos5--;
            if(pos1 < 0)
            {
                pos1 = 4; 
            }
            if(pos2 < 0)
            {
                pos2 = 4; 
            }
            if(pos3 < 0)
            {
                pos3 = 4; 
            }
            if(pos4 < 0)
            {
                pos4 = 4; 
            }
            if(pos5 < 0)
            {
                pos5 = 4; 
            }
            addObject(powerUpsTracker.get(pos1),100, 650); 
            addObject(powerUpsTracker.get(pos2), 200,575); 
            addObject(powerUpsTracker.get(pos3), 300,650); 
            addObject(powerUpsTracker.get(pos4), 265,745);
            addObject(powerUpsTracker.get(pos5), 140,745);  
            
            //temporary
            removeObjects(getObjects(HUDPowerUpsLabelTEMPORARY.class)); 
            pos1Label--;
            pos2Label--;
            pos3Label--;
            pos4Label--;
            pos5Label--;
            if(pos1Label < 0)
            {
                pos1Label = 4; 
            }
            if(pos2Label < 0)
            {
                pos2Label = 4; 
            }
            if(pos3Label < 0)
            {
                pos3Label = 4; 
            }
            if(pos4Label < 0)
            {
                pos4Label = 4; 
            }
            if(pos5Label < 0)
            {
                pos5Label = 4; 
            }
            addObject(powerUpsTrackerLabel.get(pos1Label), 130,675); 
            addObject(powerUpsTrackerLabel.get(pos2Label), 230,600); 
            addObject(powerUpsTrackerLabel.get(pos3Label), 330,675); 
            addObject(powerUpsTrackerLabel.get(pos4Label), 295,770); 
            addObject(powerUpsTrackerLabel.get(pos5Label), 165,770); 
            //
        }
        if(qDown && !Greenfoot.isKeyDown("q"))
        {
            qDown = false; 
        }
        //
        
        //knife
        if(Greenfoot.isKeyDown("1"))
        {
            removeObjects(getObjects(HUDAmmoLabels.class)); 
            addObject(AmmoCounterKnife, 1100, 750);
            addObject(generalTime, 1000, 100);
        }
        //pistol
        if(Greenfoot.isKeyDown("2"))
        {
            removeObjects(getObjects(HUDAmmoLabels.class)); 
            addObject(AmmoCounterMagazine, 1100, 750); 
            addObject(AmmoCounterTotal, 1150, 750); 
            addObject(generalTime, 1000, 100);
        }
        //rifle 
        if(Greenfoot.isKeyDown("3"))
        {
            removeObjects(getObjects(HUDAmmoLabels.class)); 
            addObject(AmmoCounterMagazineRifle, 1075, 750); 
            addObject(AmmoCounterTotalRifle, 1150, 750);
            addObject(generalTime, 1000, 100);
        }
        //shotgun
        if(Greenfoot.isKeyDown("4"))
        {
            removeObjects(getObjects(HUDAmmoLabels.class)); 
            addObject(AmmoCounterMagazineShotgun, 1100, 750); 
            addObject(AmmoCounterTotalShotgun, 1150, 750); 
            addObject(generalTime, 1000, 100);
        }
        
        if(!controlDown && Greenfoot.isKeyDown("control"))
        {
            controlDown = true; 
            //bullet 
            if(getObjectsAt(200, 575, HUDPowerUps.class).get(0).equals(bigBullet) && kills >= 25)
            {
                System.out.println("bigBullet");
                kills = kills - 25; 
            }
            //invincibility 
            if(getObjectsAt(200, 575, HUDPowerUps.class).get(0).equals(invincible) && kills >= 50)
            {
                System.out.println("invincible");
                kills = kills - 50; 
            }
            //healthUp
            if(getObjectsAt(200, 575, HUDPowerUps.class).get(0).equals(healthUp) && kills >= 35)
            {
                System.out.println("healthUp");
                kills = kills - 35; 
            }
            //speedUp
            if(getObjectsAt(200, 575, HUDPowerUps.class).get(0).equals(speedUp) && kills >= 15)
            {
                System.out.println("speedUp");
                kills = kills - 15; 
            }
            //fastFireRate
            if(getObjectsAt(200, 575, HUDPowerUps.class).get(0).equals(fastFireRate) && kills >= 15)
            {
                System.out.println("fastFireRate");
                kills = kills - 15; 
            }
        }
        if(controlDown && !Greenfoot.isKeyDown("control"))
        {
            controlDown = false; 
        }
        
        if(hitbox.active)
        {
            CurrentWeapon.setImage(gun.blank); 
        }
        else
        {
            CurrentWeapon.setImage(gun.weapon); 
        }
        
        hitbox.setRotation(scrollActor.getRotation());
        double angle = Math.toRadians(360 - scrollActor.getRotation()); 
        hitbox.setLocation(scrollActor.getX() + (int)(Math.cos(angle) * 30), scrollActor.getY() - (int)(Math.sin(angle) * 30)); 
        updateTimer(); 
        
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
        CurrentWeapon.setLocation(scrollActor.getX() + (int)(Math.cos(angle) * gun.dsGun), scrollActor.getY() - (int)(Math.sin(angle) * gun.dsGun)); 
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
