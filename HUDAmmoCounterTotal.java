import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AmmoCounterTotal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class HUDAmmoCounterTotal extends Actor
{
    /**
     * Act - do whatever the AmmoCounterTotal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    Label AmmoCounterTotal; 
    
    //handgun magazine 
    int MagazineHandgunAmmo = 5; 
    int TotalHandgunAmmo = 10;
    
    //shotgun magazine 
    int MagazineShotgunAmmo; 
    
    //rifle magazine 
    int MagazineRifleAmmo; 
    
    
    public String value;
    public int fontSize;
    public Color lineColor = Color.BLACK;
    public Color fillColor = Color.WHITE;
    public int minX; 
    public int minY; 
    public int maxX; 
    public int maxY; 
    
    public static final Color transparent = new Color(0,0,0,0);
    
    public HUDAmmoCounterTotal(String value, int fontSize)
    {
        this.value = value;
        this.fontSize = fontSize;
        updateImage();
    }
    
    public HUDAmmoCounterTotal(int value, int fontSize)
    {
        this(Integer.toString(value), fontSize);
    }
    
    public void updateImage()
    {
        setImage(new GreenfootImage(value, fontSize, fillColor, transparent, lineColor));
    }
    
     public void ammoMagazine()
    {
        MagazineHandgunAmmo--; 
        //AmmoCounterMagazine.setValue(MagazineHandgunAmmo); 
    }
    
    public int ammoMagazineAlert()
    {
        return MagazineHandgunAmmo; 
    }
    
    public void setAmmoMagazineAlert(int x)
    {
        MagazineHandgunAmmo = x; 
    }
    
    
    /**
     * Sets the value  as text
     * 
     * @param value the text to be show
     */
    public void setValue(String value)
    {
        this.value = value;
        updateImage();
    }
    
    /**
     * Sets the value as integer
     * 
     * @param value the value to be show
     */
    public void setValue(int value)
    {
        this.value = Integer.toString(value);
        updateImage();
    }
    
    /**
     * Sets the line color of the text
     * 
     * @param lineColor the line color of the text
     */
    public void setLineColor(Color lineColor)
    {
        this.lineColor = lineColor;
        updateImage();
    }
    
    /**
     * Sets the fill color of the text
     * 
     * @param fillColor the fill color of the text
     */
    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
        updateImage();
    }
    
    
    public void act()
    {
        
    }
}

