import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WaveCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveCounter extends Delayer
{
    /**
     * Act - do whatever the WaveCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static int currentWave;
    public void act()
    {
        wavesImg();
    }
    public void wavesImg(){
        setImage(currentWave+".png");
    }
}
