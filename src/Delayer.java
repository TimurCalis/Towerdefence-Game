import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class delayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Delayer extends UI
{
    /**
     * Act - do whatever the delayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean isSpawning = false;
    int delayCounter = 0;   //delay between each spawned enemy
    int delayTime = 50;
    int callsCounter = 0;
    int callsMax = 6;           //amount of enemys spawned
    int wavesCounter = 0;
    int planeHealthE = 10;  //different waves with increasing difficulty
    public void act()
    {
        abc();   

    }
    public int wavesArray[][]= {
        {150,3,},
        {0,0,0},
        };
    
    
    
    public void abc()
        {
        if(this.isSpawning==true){
            if(this.delayCounter%delayTime==0){
                MyWorld myWorld=((MyWorld)getWorld());
                myWorld.spawnPlane(planeHealthE);   //spawn a plane with the amount of health given
                callsCounter++;
                
            }
            this.delayCounter ++;
            if(this.callsCounter == callsMax){
                this.isSpawning = false;
                delayCounter = 0;
                callsCounter = 0;
                wavesCounter ++;
            }
        }
    }
}


