 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends UI
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       //if(this.getWorld()!=null){
        checkForButtonPress();
        
    //}
    }
    public void checkForButtonPress()
    {
       if(Greenfoot.mouseClicked(this)){
           
           Delayer delayer = new Delayer();
           this.getWorld().addObject(delayer,25,1);
           WaveCounter waveCounter = new WaveCounter();
           this.getWorld().addObject(waveCounter,29,1);
           delayer.isSpawning = true;
           System.out.println("butto");
       }
    }
    
}
