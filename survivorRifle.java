import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class survivorRifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class survivorRifle extends startingSurvivor
{
    /**
     * Act - do whatever the survivorRifle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int rifleAmmo = 0; 
    
    public survivorRifle()
    {
        wait = 0; 
        health = 0; 
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/Top_Down_Survivor/rifle/move/survivor-move_rifle_" + i + ".png");
            idle[i].scale(100,100); 
        }
        
        for(int i = 0; i < attack.length; i++)
        {
            attack[i] = new GreenfootImage("images/Top_Down_Survivor/knife/meleeattack/survivor-meleeattack_knife_" + i + ".png");
            attack[i].scale(125,125); 
        }
        setImage(idle[0]); 
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
