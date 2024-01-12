import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * display what weapon the character has 
 */



public class HUDChoosenWeapon extends Actor
{
  
    GreenfootImage pistol = new GreenfootImage("pistol.png");
    GreenfootImage rifle = new GreenfootImage("rifle.png");
    GreenfootImage shotgun = new GreenfootImage("shotgun.png"); 
    GreenfootImage knife = new GreenfootImage("knife.png"); 
    
    public HUDChoosenWeapon()
    {
        setImage(knife); 
        knife.scale(75,65); 
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("1"))
        {
            setImage(knife); 
            knife.scale(75,60); 
        }
        
         if(Greenfoot.isKeyDown("2"))
        {
            setImage(pistol); 
            pistol.scale(75,65); 
        }
        
         if(Greenfoot.isKeyDown("3"))
        {
            setImage(rifle); 
            rifle.scale(170,130); 
        }
        
        if(Greenfoot.isKeyDown("4"))
        {
            setImage(shotgun); 
            shotgun.scale(200,200); 
        }
    }
}
