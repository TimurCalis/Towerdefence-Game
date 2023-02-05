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
    int planeHealthE;  //different waves with increasing difficulty
    public void act()
    {
        abc();   

    }
    public int wavesArray[][]= { //{delayTime, callsMax,planeHealthE}
        {150,3,1},
        {100,4,1},
        {100,7,1},
        {80,3,3}
        };
    public void wavesVariables() {
        delayTime    = this.wavesArray[0][wavesCounter];
        callsMax     = this.wavesArray[1][wavesCounter];
        planeHealthE = this.wavesArray[2][wavesCounter];
    }
    public void abc()
        {
        wavesVariables();
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
                //wavesVariables();
            }
        }
    }
}


