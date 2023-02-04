import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends UI
{
    int size;
    String txt;
    GreenfootImage image;
    public Text(String txt,int size)
    {
      this.txt=txt;
      this.size=size;
    }
    
    public void act()
    {
        image = new GreenfootImage(this.txt, this.size, Color.WHITE, new Color(0,0,0,0));  
        setImage(image);
    }
    public GreenfootImage getText()
    {
        return image;
    }
}
