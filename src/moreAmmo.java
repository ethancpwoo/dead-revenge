import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bigBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class moreAmmo extends powerUp
{
    public moreAmmo()
    {
        super(); 
        GreenfootImage health = new GreenfootImage("ammoUp.png");
        health.scale(50, 50);
        setImage(health); 
         
    }
    public void act() 
    {

    }    
}
