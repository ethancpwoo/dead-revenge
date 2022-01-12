import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AmmoCounterMagazine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class AmmoCounterMagazine extends AmmoCounter


{ 
    //handgun magazine 
    int MagazineHandgunAmmo = 5; 
    int TotalHandgunAmmo = 10;
    
    //shotgun magazine 
    int MagazineShotgunAmmo; 
    
    //rifle magazine 
    int MagazineRifleAmmo; 
    
    
    Label AmmoCounterMagazine;
    public AmmoCounterMagazine()
    {
        AmmoCounterMagazine = new Label(MagazineHandgunAmmo, 80); 
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void ammoMagazine()
    {
        MagazineHandgunAmmo--; 
        AmmoCounterMagazine.setValue(MagazineHandgunAmmo); 
    }
    
    public int ammoMagazineAlert()
    {
        return MagazineHandgunAmmo; 
    }
    
    public void setAmmoMagazineAlert(int x)
    {
        MagazineHandgunAmmo = x; 
    }
}
