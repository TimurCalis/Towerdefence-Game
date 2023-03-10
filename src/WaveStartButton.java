 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * starts the wave
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
       if(Greenfoot.mouseClicked(this) && this.getWorld().getObjects(Enemy.class) != null){//if there are no more enemys in the world and clicked, start
           Waves waves = new Waves();
           this.getWorld().addObject(waves ,2,1);
           WaveDisplayer waveDisplayer1 = new WaveDisplayer(0);
           this.getWorld().addObject(waveDisplayer1,2,1);//adds both decimal values of the waves 10^0 and 10^1
           WaveDisplayer waveDisplayer2 = new WaveDisplayer(1);
           this.getWorld().addObject(waveDisplayer2,1,1);
           waves.isSpawning = true;
       }
    }
}
