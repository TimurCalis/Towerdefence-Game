 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveStartButton extends UI
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkForButtonPress();
    }
    public void checkForButtonPress()
    {
       if(Greenfoot.mouseClicked(this)){
           Waves delayer = new Waves();
           this.getWorld().addObject(delayer ,2,1);
           WaveDisplayer waveDisplayer1 = new WaveDisplayer(0);
           this.getWorld().addObject(waveDisplayer1,2,1);
           WaveDisplayer waveDisplayer2 = new WaveDisplayer(1);
           this.getWorld().addObject(waveDisplayer2,1,1);
           delayer.isSpawning = true;
       }
    }
}
